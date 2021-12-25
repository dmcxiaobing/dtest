package com.david.test;

import com.david.entity.MasterWebJsBean;
import com.david.utils.FastJsonUtil;

/**
 * @author David
 * @date 2019/9/5
 * @time 20:57
 */
public class JsonTest {

    public static void main(String[] args) {
        String json = "{\"bedCode\":\"26\",\"noticeId\":\"2c57d421a9794585a851800a4008e0bc\"}";
        MasterWebJsBean bean = FastJsonUtil.jsonToObject(json, MasterWebJsBean.class);
        System.out.println(bean.getBedCode());
        System.out.println(bean.getNoticeId());
    }
}
