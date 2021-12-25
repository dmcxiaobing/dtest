package com.david.entity;

import java.io.Serializable;

/**
 * @author David Zheng
 * @date 2021/12/13
 *
 */
public class MasterWebJsBean implements Serializable {




    /**
     * 床位号
     */
    private String bedCode;

    /**
     * 呼叫、挂断的消息id
     */
    private String noticeId;

    /**
     * 消息类型
     */
    private String msgType;

    public String getBedCode() {
        return bedCode;
    }

    public void setBedCode(String bedCode) {
        this.bedCode = bedCode;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }
}
