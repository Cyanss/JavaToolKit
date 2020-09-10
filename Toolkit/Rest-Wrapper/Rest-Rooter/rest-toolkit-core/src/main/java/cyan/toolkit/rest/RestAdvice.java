package cyan.toolkit.rest;

/**
 * <p>RestAdvice</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:35 2020/9/9
 */
public interface RestAdvice {

    default void preErrorHandle(Error error) {
    }

    default void afterRestErrorHandle(RestError restError) {
    }

    default void afterErrorHandle(Error error) {
    }

    default void preExceptionHandle(Exception exception) {
    }

    default void afterRestExceptionHandle(RestException restException) {
    }

    default void afterExceptionHandle(Exception exception) {
    }
}
