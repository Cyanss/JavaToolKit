package cyan.toolkit.chief.simple;

import cyan.toolkit.chief.ChiefModel;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;
import java.util.Optional;

/**
 * <p>SimpleModel</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:40 2020/9/24
 */
@Builder
@AllArgsConstructor
public class SimpleModel extends ChiefModel<SimpleEntity> {
    private Date time;

    public SimpleModel() {
    }

    public SimpleModel(Long id) {
        super(id);
    }

    public SimpleModel(SimpleModel.Builder builder) {
        super(builder);
        this.time = builder.time;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public SimpleEntity toEntity(Boolean isInsert, Long... idArray) {
        SimpleEntity entity = new SimpleEntity();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setDescription(this.getDescription());
        entity.setTime(Optional.ofNullable(this.getTime()).map(Date::getTime).orElse(null));
        if (isInsert) {
            entity.setCreateTime(new Date());
        }
        entity.setUpdateTime(new Date());
        return entity;
    }

    public static class Builder extends ChiefModel.Builder {
        protected Date time;

        public Builder() {
        }

        public SimpleModel.Builder time(Long time) {
            this.time = new Date(time);
            return this;
        }

        public SimpleModel.Builder time(Date time) {
            this.time = time;
            return this;
        }

        public SimpleModel.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public SimpleModel.Builder name(String name) {
            this.name = name;
            return this;
        }

        public SimpleModel.Builder description(String description) {
            this.description = description;
            return this;
        }

        public SimpleModel build() {
            return new SimpleModel(this);
        }
    }
}
