package cyan.toolkit.chief.simple;

import cyan.toolkit.chief.entity.InfoEntity;

import javax.persistence.Table;
import java.util.Date;
import java.util.Optional;

/**
 * <p>SimpleEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:41 2020/9/24
 */
@Table(name = "cy_tk_cf_simple")
public class SimpleEntity extends InfoEntity<Long, Date,SimpleEntity> {

    private Long time;

    public SimpleEntity() {
    }

    public SimpleEntity(Long id) {
        super(id);
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public static SimpleEntity toEntity(SimpleModel simple, boolean isInsert) {
        assert simple != null;
        SimpleEntity entity = new SimpleEntity();
        entity.setId(simple.getId());
        entity.setName(simple.getName());
        entity.setDescription(simple.getDescription());
        entity.setTime(Optional.ofNullable(simple.getTime()).map(Date::getTime).orElse(null));
        if (isInsert) {
            entity.setCreateTime(new Date());
        }
        entity.setUpdateTime(new Date());
        return entity;
    }

    public static SimpleModel toModel(SimpleEntity entity){
        assert entity != null;
        SimpleModel.Builder builder = new SimpleModel.Builder();
        builder.id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .time(entity.getTime());
        return new SimpleModel(builder);
    }
}
