package cyan.toolkit.javafx;

import cyan.toolkit.rest.util.GeneralUtils;
import javafx.scene.control.TextField;

/**
 * <p>NumberField 集成TextField实现数字输入 官方建议方式</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:12 2020/8/14
 */
public class NumberField extends TextField {
    /** 限定最小值 */
    private Integer minValue = Integer.MIN_VALUE;
    /** 限定最大值 */
    private Integer maxValue = Integer.MAX_VALUE;

    public NumberField() {
    }

    public NumberField(String text) {
        super(text);
    }

    public void replaceText(int start, int end, String text) {
        /** 替换非数字字符 */
        if (!text.matches("[A-Za-z]") && !text.matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")) {
            String value = this.getText();
            if (GeneralUtils.isNotEmpty(value)) {
                if (minValue <= Integer.valueOf(value) && Integer.valueOf(value) <= maxValue) {
                    super.replaceText(start,end,text);
                }else if (minValue > Integer.valueOf(value)) {
                    String minValueText = String.valueOf(minValue);
                    setText(minValueText);
                } else if (maxValue < Integer.valueOf(value)) {
                    String maxValueText = String.valueOf(maxValue);
                    setText(maxValueText);
                }
            } else {
                super.replaceText(start,end,text);
            }
        }

    }

    public void replaceSelection(String text) {
        /** 替换非数字字符 */
        if (!text.matches("[A-Za-z]") && !text.matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")) {
            String value = this.getText();
            if (GeneralUtils.isNotEmpty(value)) {
                if (minValue <= Integer.valueOf(value) && Integer.valueOf(value) <= maxValue) {
                    super.replaceSelection(text);
                }else if (minValue > Integer.valueOf(value)) {
                    String minValueText = String.valueOf(minValue);
                    setText(minValueText);
                } else if (maxValue < Integer.valueOf(value)) {
                    String maxValueText = String.valueOf(maxValue);
                    setText(maxValueText);
                }
            } else {
                super.replaceSelection(text);
            }

        }
    }

    public Integer intValue() {
        return Integer.valueOf(this.getText());
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }
}
