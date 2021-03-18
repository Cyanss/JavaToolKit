package cyan.toolkit.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>RestAdvice</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:35 2020/9/9
 */
public interface RestExceptionAdvice {

    default void preExceptionHandle(Exception exception, HttpServletRequest request, HttpServletResponse response)  {
    }

    default void doRestExceptionHandle(RestException exception, HttpServletRequest request, HttpServletResponse response)  {
    }

    default void doExceptionHandle(Exception exception, HttpServletRequest request, HttpServletResponse response)  {
    }
}
