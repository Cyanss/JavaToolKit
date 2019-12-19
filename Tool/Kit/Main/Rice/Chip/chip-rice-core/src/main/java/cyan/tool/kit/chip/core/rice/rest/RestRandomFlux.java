package cyan.tool.kit.chip.core.rice.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;


class RestRandomFlux {
    private static final String BASE_SYMBOL = "!@#$%^&*()[]{}\";:+~·=-/,.<>?\\|";
    private static final String BASE_STRING_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String BASE_STRING_LOWER = BASE_STRING_UPPER.toLowerCase();
    private static final String BASE_REGEX = "_";
    private static final String BASE_NUMBER = "0123456789";
    private static final Integer MIN_LENGTH = 3;

    public static synchronized String randomEnum(Integer status) {
        Random random = new Random();
        int length = random.nextInt(10);
        return randomConst(1, length + MIN_LENGTH) + BASE_REGEX + status.toString();
    }

    public static synchronized String randomEnum(Integer status, String baseName) {
        return baseName.toUpperCase() + "_" + randomEnum(status);
    }

    public static synchronized String randomConst(Integer regexLimit, Integer length) {
        /** this length must be greater than two */
        if (length < MIN_LENGTH) {
            length += MIN_LENGTH;
        }
        return randomVariable(regexLimit,BASE_STRING_UPPER,BASE_REGEX,length);
    }

    public static synchronized String randomVariable(Integer regexLimit, String base, String regex, Integer length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < length; i++){
            int index = random.nextInt(base.length());
            stringBuilder.append(base.charAt(index));
        }
        List<Integer> indexList = new ArrayList<>(regexLimit);
        for(int i = 0; i < regexLimit; i++){
            int regexIndex = random.nextInt(length - 1);
            if (regexIndex > 0 && !indexList.contains(regexIndex)) {
                stringBuilder.replace(regexIndex,regexIndex,regex);
                indexList.add(regexIndex);
            } else {
                i--;
            }
        }
        return stringBuilder.toString();
    }

}
