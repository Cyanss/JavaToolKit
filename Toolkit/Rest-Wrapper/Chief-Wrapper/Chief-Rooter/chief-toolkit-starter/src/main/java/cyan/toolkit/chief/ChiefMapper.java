package cyan.toolkit.chief;

import cyan.toolkit.chief.mapper.InfoMapper;

import java.util.Date;

/**
 * <p>RestMapper</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:13 2020/11/3
 */
public interface ChiefMapper<E extends ChiefEntity<?>> extends InfoMapper<E,Long, Date> {
}
