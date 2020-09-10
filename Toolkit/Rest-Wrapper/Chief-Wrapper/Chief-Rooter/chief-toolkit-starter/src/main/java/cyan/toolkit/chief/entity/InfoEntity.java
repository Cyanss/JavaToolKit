package cyan.toolkit.chief.entity;

/**
 * <p>InfoEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:11 2020/8/20
 */
public class InfoEntity extends IdEntity {
    /** 事物名称 */
    protected String name;
    /** 事物描述 */
    protected String description;

    public InfoEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
