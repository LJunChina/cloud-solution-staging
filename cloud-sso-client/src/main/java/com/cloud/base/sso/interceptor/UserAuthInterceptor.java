package com.cloud.base.sso.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.cloud.base.sso.config.UrlConfig;
import com.cloud.base.sso.context.LoginUser;
import com.cloud.base.sso.context.LoginUserContext;
import com.cloud.base.sso.context.TokenInfo;
import com.cloud.base.sso.exception.UserAuthException;
import com.cloud.base.sso.service.TokenService;
import com.cloud.common.dto.BaseRespDTO;
import com.cloud.common.enums.ResultCode;
import com.cloud.common.util.EmptyChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.stream.Stream;

/**
 * 登录权限拦截器
 *
 * @author Jon_China
 * @create 2017/11/11
 */
@Component
public class UserAuthInterceptor extends BaseInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthInterceptor.class);

    @Autowired
    private TokenService tokenService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("current request url:{}",request.getRequestURL());
        String header = request.getHeader("X-Requested-With");
        response.setCharacterEncoding("UTF-8");
        String jsonResult = new BaseRespDTO(ResultCode.LOGIN_EFFICACY).toString();
        boolean isAjax;
        isAjax = "XMLHttpRequest".equals(header);
        try {
            init();
            Cookie[] cookies = request.getCookies();
            if(EmptyChecker.isEmpty(cookies)){
                redirect(response,isAjax,jsonResult);
                return false;
            }
            String tokenId;
            Cookie tokenCookie = Stream.of(cookies).filter(c -> "tokenId".equals(c.getName())).findFirst().orElse(null);
            if(EmptyChecker.isEmpty(tokenCookie)){
                redirect(response,isAjax,jsonResult);
                return false;
            }
            tokenId = tokenCookie.getValue();
            if(EmptyChecker.isEmpty(tokenId)){
                redirect(response,isAjax,jsonResult);
                return false;
            }
            //查询token是否有效
            String result = this.tokenService.checkLoginToken(tokenId);
            JSONObject object = JSONObject.parseObject(result);
            if(ResultCode.OK.getCode().equals(object.getString("code"))){
                logger.info("token result : {}",result);
                TokenInfo tokenInfo = JSONObject.parseObject(object.getString("data"),TokenInfo.class);
                //查询用户信息
                String userStr = this.tokenService.getLoginUserInfo(tokenInfo.getUserId());
                JSONObject userObject = JSONObject.parseObject(userStr);
                String tokenStr = userObject.getJSONObject("data").getString("loginToken");
                if(!tokenStr.equals(tokenId)){
                    redirect(response,isAjax,jsonResult);
                    return false;
                }
                //排除配置不包含的
                //查询权限信息
                String privilegeCheck = this.tokenService.checkLoginUserPrivilege(tokenInfo.getUserId(),"1",request.getRequestURI());
                BaseRespDTO resultCheck = JSONObject.parseObject(privilegeCheck,BaseRespDTO.class);
                if(EmptyChecker.isEmpty(resultCheck) || !ResultCode.OK.getCode().equals(resultCheck.getCode())){
                    redirect(response,isAjax,privilegeCheck);
                    return false;
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
                return true;
            }
            redirect(response,isAjax,jsonResult);
            return false;
        }catch (UserAuthException e){
            logger.error("exception of login occurred in interceptor:{}",e);
            response.getWriter().write(new BaseRespDTO(ResultCode.INVALID_USER).toString());
            return false;
        }catch (UnsupportedEncodingException e){
            logger.error("not support encode");
            response.getWriter().write(new BaseRespDTO(ResultCode.NOT_SUPPORT_ENCODE).toString());
            return false;
        }catch (Exception e){
            logger.error("exception occurred in interceptor:{}",e);
            response.getWriter().write(new BaseRespDTO(ResultCode.FAIL).toString());
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LoginUserContext.removeCurrentLoginUser();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
