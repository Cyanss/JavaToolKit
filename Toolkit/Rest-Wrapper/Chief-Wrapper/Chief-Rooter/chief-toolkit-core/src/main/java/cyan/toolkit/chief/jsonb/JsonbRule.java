package cyan.toolkit.chief.jsonb;

import cyan.toolkit.chief.builder.SqlBuilder;
import cyan.toolkit.chief.builder.SqlBuilders;
import cyan.toolkit.rest.util.common.GeneralUtils;
import org.springframework.lang.NonNull;

import java.io.Serializable;

/**
 * <p>JsonbRule</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:43 2021/5/7
 */
public abstract class JsonbRule<R extends JsonbRule<R>> implements Serializable {
    /** 属性名 */
    protected String name;

    public JsonbRule() {
    }

    public JsonbRule(String name) {
        this.name = name;
    }

    public JsonbRule(JsonbRule.Builder builder) {
        this.name = builder.name;
    }

    abstract public String toSql(@NonNull String alias);

    abstract public String toSql(@NonNull String alias, @NonNull String variable);

    public String target(String target, String name, String value, ValueType type) {
        return target(target,name,value,type.getValue());
    }

    public String target(String target, String name, String value, String type) {
        SqlBuilder targetBuilder = SqlBuilders.newSqlBuilder();
        if (GeneralUtils.isNotEmpty(name) && GeneralUtils.isNotEmpty(value)) {
            targetBuilder.append("((").append(target);
            targetBuilder.append(" #>'{").append(name);
            targetBuilder.append("}') ->>'").append(value);
            targetBuilder.append("')::").append(type);
        }
        return targetBuilder.toString();
    }

    public abstract static class Builder<R extends JsonbRule<R>> {
        protected String name;

        public Builder() {
        }

        public JsonbRule.Builder name(String name) {
            this.name = name;
            return this;
        }

        abstract public R build();
    }
}
