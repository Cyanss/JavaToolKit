package cyan.toolkit.rest;

/**
 * <p>RestInterceptService</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:58 2020/9/9
 */
public abstract class RestInterceptService {

    abstract public void handler(RestInterceptRequest request) throws RestException;

}
