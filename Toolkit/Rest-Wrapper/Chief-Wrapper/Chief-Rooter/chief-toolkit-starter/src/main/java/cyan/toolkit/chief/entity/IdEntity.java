package cyan.toolkit.chief.entity;

import javax.persistence.Id;

/**
 * <p>IdEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:10 2020/8/20
 */
public class IdEntity extends TimeEntity{
    @Id
    protected Long id;

    public IdEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
