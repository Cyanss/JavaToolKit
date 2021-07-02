package cyan.toolkit.rest.interceptor;


import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * <p>RestRequestWrapper</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:47 2020/9/9
 */
public class RestRequestWrapper extends HttpServletRequestWrapper {
    private final  ThreadLocal<HttpServletRequest> BODY_HOLDER = new ThreadLocal<>();

    public RestRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        //TODO
        BODY_HOLDER.set(request);
    }

    @Override
    public BufferedReader getReader()throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return BODY_HOLDER.get().getInputStream();
    }
}
