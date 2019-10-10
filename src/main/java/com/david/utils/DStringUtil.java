package com.david.utils;

/**
 * @author David
 * @date 2019/10/10
 * @time 10:05
 */
public class DStringUtil {

    /**
     * 数组转String
     * 采用字符串拼接形式转换，";"分号隔开
     */
    private String arrayTransformString(int[] SafetyMeasure) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < SafetyMeasure.length; i++) {
            sb.append(SafetyMeasure[i] + ";");
        }
        return sb.toString();
    }
}
