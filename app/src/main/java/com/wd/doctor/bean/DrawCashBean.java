package com.wd.doctor.bean;

/**
 * describe:DrawCashBean
 * date:2019/12/11
 * author:任(Lenovo)
 * function:提现
 */
public class DrawCashBean {

    /**
     * message : 提现成功
     * status : 0000
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
