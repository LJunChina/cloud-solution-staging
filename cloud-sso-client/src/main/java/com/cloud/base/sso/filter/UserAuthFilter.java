package com.cloud.base.sso.filter;

import com.alibaba.fastjson.JSONObject;
import com.cloud.base.sso.context.LoginUser;
import com.cloud.base.sso.context.LoginUserContext;
import com.cloud.base.sso.context.TokenInfo;
import com.cloud.base.sso.service.TokenService;
import com.cloud.common.dto.BaseRespDTO;
import com.cloud.common.enums.ResultCode;
import com.cloud.common.util.EmptyChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * 用户权限过滤器
 * <p>只针对静态资源html处理,其他接口资源放行到拦截器中</p>
 * @author Jon_China
 * @create 2018/1/13
 *
 */
@Component
public class UserAuthFilter extends BaseFilter {
    private static final Logger logger = LoggerFactory.getLogger(UserAuthFilter.class);

    @Autowired
    private TokenService tokenService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        response.setCharacterEncoding("UTF-8");
        String header = request.getHeader("X-Requested-With");
        boolean isAjax = "XMLHttpRequest".equals(header);
        try {
            String currentUrl = request.getRequestURI();
            //若当前请求在排除范围内,直接放行
            if(EmptyChecker.notEmpty(excludeUrl) && excludeUrl.contains(currentUrl)){
                chain.doFilter(request,response);
                return;
            }
            String jsonResult = new BaseRespDTO(ResultCode.LOGIN_EFFICACY).toString();
            Cookie[] cookies = request.getCookies();
            if(EmptyChecker.isEmpty(cookies)){
                redirect(response,isAjax,jsonResult);
                return;
            }
            String tokenId;
            Cookie tokenCookie = Stream.of(cookies)
                    .filter(c -> "tokenId".equals(c.getName()))
                    .findFirst()
                    .orElse(null);
            if(EmptyChecker.isEmpty(tokenCookie)){
                redirect(response,isAjax,jsonResult);
                return;
            }
            tokenId = tokenCookie.getValue();
            if(EmptyChecker.isEmpty(tokenId)){
                redirect(response,isAjax,jsonResult);
                return;
            }
            //查询token是否有效
            String result = this.tokenService.checkLoginToken(tokenId);
            logger.debug("token result : {}",result);
            JSONObject object = JSONObject.parseObject(result);
            if(!ResultCode.OK.getCode().equals(object.getString("code"))){
                logger.info("token disable,redirect to login page");
                redirect(response,isAjax,jsonResult);
                return;
            }
            TokenInfo tokenInfo = JSONObject.parseObject(object.getString("data"),TokenInfo.class);
            //查询用户信息
            String userStr = this.tokenService.getLoginUserInfo(tokenInfo.getUserId());
            JSONObject userObject = JSONObject.parseObject(userStr);
            String tokenStr = userObject.getJSONObject("data").getString("loginToken");
            if(!tokenStr.equals(tokenId)){
                redirect(response,isAjax,jsonResult);
                return;
            }
            //排除配置不包含的
            //查询权限信息
            String privilegeCheck = this.tokenService.checkLoginUserPrivilege(tokenInfo.getUserId(),"1",request.getRequestURI());
            BaseRespDTO resultCheck = JSONObject.parseObject(privilegeCheck,BaseRespDTO.class);
            if(EmptyChecker.isEmpty(resultCheck) || !ResultCode.OK.getCode().equals(resultCheck.getCode())){
                redirect(response,isAjax,privilegeCheck);
                return;
            }
            //存储用户登录上下文
            LoginUser loginUser = new LoginUser();
            loginUser.setUserId(tokenInfo.getUserId());
            loginUser.setUserName(userObject.getJSONObject("data").getString("userName"));
            LoginUserContext.addLoginUserContext(loginUser);
            //刷新cookie
            tokenCookie.setMaxAge(30 * 60);
            tokenCookie.setDomain("joninfo.cn");
            tokenCookie.setPath("/");
            response.addCookie(tokenCookie);
            chain.doFilter(request,response);
        }catch (Exception e){
            logger.error("exception occurred in filter : {}",e);
            redirect(response,isAjax,new BaseRespDTO(ResultCode.ERROR).toString());
        }finally {
            LoginUserContext.removeCurrentLoginUser();
        }
    }

    @Override
    public void destroy() {
    }
}
