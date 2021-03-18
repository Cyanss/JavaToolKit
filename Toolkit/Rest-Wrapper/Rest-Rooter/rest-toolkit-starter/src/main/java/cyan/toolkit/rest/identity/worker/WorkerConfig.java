package cyan.toolkit.rest.identity.worker;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Objects;

/**
 * <p>WorkerConfig</p>
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c) 2016-2021
 * @date created on 9:06 2020/12/15
 */
@Builder
@AllArgsConstructor
public class WorkerConfig {
    private Long workerId;
    private Long centerId;

    public WorkerConfig() {
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public Long getCenterId() {
        return centerId;
    }

    public void setCenterId(Long centerId) {
        this.centerId = centerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerConfig that = (WorkerConfig) o;
        return Objects.equals(workerId, that.workerId) &&
                Objects.equals(centerId, that.centerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerId, centerId);
    }
}
