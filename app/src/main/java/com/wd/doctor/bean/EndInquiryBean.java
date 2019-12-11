package com.wd.doctor.bean;

/**
 * describe:EndInquiryBean
 * date:2019/12/11
 * author:任(Lenovo)
 * function:
 */
public class EndInquiryBean {
    /**
     * message : 该问诊已结束,不能重复操作
     * status : 8002
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
