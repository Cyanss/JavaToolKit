package cyan.toolkit.javafx.configure;

import cyan.toolkit.rest.util.common.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Map;

/**
 * <p>HttpClientInterceptor</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:46 2020/8/14
 */
@Slf4j
@Component
public class HttpClientInterceptor implements ClientHttpRequestInterceptor {
    @Override
    @NonNull
    public ClientHttpResponse intercept(@NonNull HttpRequest httpRequest, @NonNull byte[] bytes, @NonNull ClientHttpRequestExecution execution) throws IOException {
        String url = httpRequest.getURI().getPath();
        log.debug("[HttpRequest]-Url:     {}",url);
        HttpMethod method = httpRequest.getMethod();
        log.debug("[HttpRequest]-Method:  {}", JsonUtils.parserJson(method));
        String query = httpRequest.getURI().getQuery();
        UriComponents uriComponents = UriComponentsBuilder.newInstance().query(query).build();
        MultiValueMap<String, String> queryParams = uriComponents.getQueryParams();
        Map<String, String> params = queryParams.toSingleValueMap();
        log.debug("[HttpRequest]-Params:  {}", JsonUtils.parserJson(params));
        HttpHeaders headers = httpRequest.getHeaders();
        log.debug("[HttpRequest]-Headers: {}",JsonUtils.parserJson(headers));
        String httpRequestBody = new String(bytes);
        log.debug("[HttpRequest]-Body:    {}",httpRequestBody);
        return execution.execute(httpRequest, bytes);
    }
}
