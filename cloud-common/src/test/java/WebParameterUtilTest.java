import com.cloud.common.util.WebParameterUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jon_China
 * @create 2018/3/10
 */
public class WebParameterUtilTest {

    @Test
    public void testGeneratorRestStyle(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", "3423");
        map.put("name", "name");
        map.put("age", "23");
        System.out.println(WebParameterUtil.generatorRestStyle("http://www.baidu.com", map));
    }
}
