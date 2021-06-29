package cyan.toolkit.chief;

import cyan.toolkit.chief.mapper.IdMapper;

/**
 * <p>RestMapper</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:13 2020/11/3
 */
public interface ChiefIdMapper<E extends ChiefIdEntity<?,?>> extends IdMapper<E,Long> {
}
