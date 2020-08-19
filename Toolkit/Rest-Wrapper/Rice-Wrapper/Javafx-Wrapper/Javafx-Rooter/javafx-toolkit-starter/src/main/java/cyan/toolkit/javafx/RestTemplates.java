package cyan.toolkit.javafx;

import cyan.toolkit.rest.RestErrorStatus;
import cyan.toolkit.rest.RestException;
import cyan.toolkit.rest.RestResult;
import cyan.toolkit.rest.error.json.JsonParseBeanException;
import cyan.toolkit.rest.error.often.FieldNullException;
import cyan.toolkit.rest.util.GeneralUtils;
import cyan.toolkit.rest.util.JsonUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

/**
 * <p>GxRestTemplateManager</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:12 2020/8/14
 */
@Component
public class RestTemplates implements InitializingBean {
    @Autowired
    private RestTemplate restTemplate;

    private static RestTemplates INSTANCE;

    @Override
    public void afterPropertiesSet() {
        INSTANCE = this;
    }

    public static <K, V> MultiValueMap<K, V> emptyMap() {
        return new LinkedMultiValueMap<>(0);
    }

    public static <K, V> MultiValueMap<K, V> singletonMap(K key, V value) {
        LinkedMultiValueMap<K, V> singletonMap = new LinkedMultiValueMap<>(1);
        singletonMap.add(key,value);
        return singletonMap;
    }

    public static <K, V> MultiValueMap<K, List<V>> singletonListMap(K key, V value) {
        LinkedMultiValueMap<K, List<V>> singletonMap = new LinkedMultiValueMap<>(1);
        singletonMap.add(key,Collections.singletonList(value));
        return singletonMap;
    }

    public static String post(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return post(url, headers);
    }

    public static String post(String url, HttpHeaders headers) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity<>(headers);
        return post(url, httpEntity);
    }

    public static String post(String url, HttpEntity httpEntity) {
        return INSTANCE.restTemplate.postForObject(url, httpEntity, String.class);
    }

    public static String post(String url, MultiValueMap<String, String> params) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity<>(headers);
        return post(url, httpEntity, params);
    }

    public static String post(String url, Object body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity<>(body, headers);
        return post(url, httpEntity);
    }

    public static String post(String url, HttpHeaders headers, MultiValueMap<String, String> params) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity<>(headers);
        return post(url, httpEntity, params);
    }

    public static String post(String url, HttpEntity httpEntity, MultiValueMap<String, String> params) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParams(params);
        return INSTANCE.restTemplate.postForObject(builder.toUriString(), httpEntity, String.class);
    }

    public static String post(String url, Object body, HttpHeaders headers) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity<>(body, headers);
        return post(url, httpEntity);
    }

    public static String post(String url, Object body, MultiValueMap<String, String> params) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity<>(body, headers);
        return post(url, httpEntity, params);
    }

    public static String post(String url, Object body, HttpHeaders headers, MultiValueMap<String, String> params) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity<>(body, headers);
        return post(url, httpEntity, params);
    }

    public static String get(String url) {
        return INSTANCE.restTemplate.getForObject(url, String.class);
    }

    public static String get(String url, MultiValueMap<String, String> params) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParams(params);
        return INSTANCE.restTemplate.getForObject(builder.toUriString(), String.class);
    }

    public static <T> T parser(String response, Class<T> clazz) throws RestException {
        /** 解析返回体，返回token */
        if (GeneralUtils.isEmpty(response)) {
            throw new FieldNullException("response","请求无数据返回！");
        }
        RestResult result = JsonUtils.parserBean(response, RestResult.class);
        if (GeneralUtils.isEmpty(result)) {
            throw new JsonParseBeanException(response,"请求数据解析错误！[Response]: ".concat(response));
        }
        if (!RestErrorStatus.SUCCESS.getStatus().equals(result.getStatus())) {
            throw new JavaFxException(result.getStatus(), "请求返回错误，[Message]: " + result.getMessage());
        }
        Object data = result.getData();
        if (GeneralUtils.isEmpty(data)) {
            throw new FieldNullException("data","请求返回数据为空！[Message]: ".concat(result.getMessage()));
        }
        String login = JsonUtils.parserJson(data);
        T bean = JsonUtils.parserBean(login, clazz);
        if (GeneralUtils.isEmpty(bean)) {
            throw new JsonParseBeanException(login,"请求数据解析错误！[Data]: ".concat(String.valueOf(data)));
        }
        return bean;
    }
}
