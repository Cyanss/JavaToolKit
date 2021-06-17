package cyan.toolkit.rest.interceptor;

import cyan.toolkit.rest.util.common.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <p>RestInterceptHolder</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:22 2020/9/9
 */
public class RestInterceptHolder {

    public static String getRequestParam(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> requestMap = new HashMap<>();
        Iterator<Map.Entry<String, String[]>> iterator = parameterMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String[]> entry = iterator.next();
            requestMap.put(entry.getKey(), entry.getValue()[0]);
        }
        return JsonUtils.parseJson(requestMap);
    }

    public static String getRequestBody(HttpServletRequest request) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = request.getReader();
        String string;
        while ((string = bufferedReader.readLine()) != null) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
