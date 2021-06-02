package cyan.toolkit.chief.simple;

import cyan.toolkit.chief.ChiefEntity;

import javax.persistence.Table;

/**
 * <p>SimpleEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:41 2020/9/24
 */
@Table(name = "cy_tk_cf_simple")
public class SimpleEntity extends ChiefEntity<SimpleModel> {

    private Long time;

    public SimpleEntity() {
    }

    public SimpleEntity(Long id) {
        super(id);
    }

    @Override
    public SimpleModel toModel() {
        SimpleModel.Builder builder = new SimpleModel.Builder();
        builder.id(this.id)
                .name(this.name)
                .description(this.description)
                .time(this.time);
        return new SimpleModel(builder);
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

}
