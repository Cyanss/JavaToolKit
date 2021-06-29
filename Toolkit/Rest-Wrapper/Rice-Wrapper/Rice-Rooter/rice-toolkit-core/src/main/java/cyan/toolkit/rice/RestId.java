package cyan.toolkit.rice;

/**
 * <p>RestId</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:07 2021/6/28
 */
public interface RestId<I> {

    I getId();

    void setId(I id);
}
