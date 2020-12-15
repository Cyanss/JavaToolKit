package cyan.toolkit.chief.helper;

import cyan.toolkit.rest.error.ClassUnknownException;
import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rice.clazz.RestClazzHelper;
import cyan.toolkit.rice.model.IdModel;

import java.lang.reflect.Array;
import java.util.List;

/**
 * <p>IdArrayUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:59 2020/9/23
 */
public class IdArrayHelper {

    @SuppressWarnings("unchecked")
    public static<I,M extends IdModel<I>> I id(M model, int index, I... idArray) {
        I id = null;
        /** 优先通过 ResponseBody 关联id */
        if (GeneralUtils.isNotEmpty(model)) {
            id = model.getId();
        } else if (idArray.length > index) {
            id = idArray[index];
        }
        return id;
    }

    @SuppressWarnings("unchecked")
    public static<I,M extends IdModel<I>> I id(List<M> models, int index, I... idArray) {
        I id = null;
        if (GeneralUtils.isNotEmpty(models) && models.size() == 1 ) {
            M model = models.stream().findFirst().get();
            id = id(model,index,idArray);
        }
        return id;
    }

    @SuppressWarnings("unchecked")
    public static <I,M extends IdModel<I>>  void idArray(List<M> models, int index, I... idArray) throws ClassUnknownException {
        /** 当models的数据有且仅有一条不为空的数据 将model的id反向关联 */
        if (GeneralUtils.isNotEmpty(models) && models.size() == 1) {
            M model = models.stream().findFirst().get();
            idArray(model,index,idArray);
        }
    }

    @SuppressWarnings("unchecked")
    public static <I,M extends IdModel<I>> void idArray(M model, int index, I... idArray) throws ClassUnknownException {
        if (GeneralUtils.isNotEmpty(model)) {
            /** 将model的id反向关联 */
            if (idArray.length > index) {
                /** idArray length默认值为1，idArray[0] = null */
                idArray[index] = model.getId();
            } else {
                Class<?> clazz = RestClazzHelper.clazz(model);
                I[] copyIdArray = (I[]) Array.newInstance(clazz, index + 1);
                System.arraycopy(idArray, 0, copyIdArray, 0, idArray.length);
                idArray = copyIdArray;
                idArray[index] = model.getId();
            }
        }
    }
}
