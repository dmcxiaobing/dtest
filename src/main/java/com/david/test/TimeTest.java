package com.david.test;


import com.david.utils.DateUtil;
import org.junit.Test;

/**
 * @author David
 * @date 2019/9/5
 * @time 21:02
 */
public class TimeTest {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void MillisToDate() {

        System.out.println(DateUtil.transforMillisecondToMinute(1567555328323L));
    }
}
