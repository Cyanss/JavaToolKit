package cyan.toolkit.rice;

/**
 * <p>RestInfo</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:06 2021/6/28
 */
public interface RestInfo<I> extends RestId<I> {

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);
}
