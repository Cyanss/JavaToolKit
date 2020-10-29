package cyan.toolkit.chief.simple;

import cyan.toolkit.rice.model.InfoModel;

import java.util.Date;

/**
 * <p>SimpleModel</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 15:40 2020/9/24
 */
public class SimpleModel extends InfoModel<Long,SimpleModel> {
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


    public static class Builder extends InfoModel.Builder<Long,SimpleModel> {
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
