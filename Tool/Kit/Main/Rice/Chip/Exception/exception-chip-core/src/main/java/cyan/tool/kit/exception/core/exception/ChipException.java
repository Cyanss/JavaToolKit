package cyan.tool.kit.exception.core.exception;

import cyan.tool.kit.exception.core.exception.status.IChipStatus;
import lombok.Getter;

/**
 * <p>ChipException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:25 2019/12/13
 */
@Getter
public class ChipException extends RuntimeException implements IChipStatus {


    @Override
    public Integer getStatus() {
        return null;
    }
}
