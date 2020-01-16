package cyan.tool.kit.generate.starter.identity.worker;

import cyan.tool.kit.rice.core.actuator.SupplierActuator;
import lombok.Data;

import java.util.Date;

/**
 * <p>RiceTime</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:46 2020/1/9
 */
@Data
class IdentityWorkerTime implements SupplierActuator {
    public static final Long EPOCH = 1288834974657L;
    private Long time;

    public IdentityWorkerTime() {
        this.time = System.currentTimeMillis() - EPOCH;
    }

    public IdentityWorkerTime(Long time) {
        this.time = time - EPOCH;
    }

    public IdentityWorkerTime(Date time) {
        this.time = time.getTime() - EPOCH;
    }

    public static Long next(Long lastTime) {
        Long time = new IdentityWorkerTime().getTime();
        while (time <= lastTime) {
            time = new IdentityWorkerTime().getTime();
        }
        return time;
    }

    @Override
    public IdentityWorkerTime get() {
        return this;
    }
}
