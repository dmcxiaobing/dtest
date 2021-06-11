package com.david.test;

import java.util.Random;

public class NameTest {


    /**
     * 获取所有中文文字
     * @return
     */
    private static String getChineseCharacter() {
        int random = new Random().nextInt(0x9FBB - 0x4E00 + 1) + 0x4E00;
        return new String(new char[]{(char) (random)});
    }

    private static final String NAME = "人之初性本善性相近习相远苟不教性乃迁教之道贵以专昔孟母择邻处子不学断机杼窦燕";

    private static String getChineseCharacterFromBook() {
        int random = new Random().nextInt(NAME.length());
        return String.valueOf(NAME.charAt(random));
    }




}
