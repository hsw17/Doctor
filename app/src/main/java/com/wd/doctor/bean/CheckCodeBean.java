package com.wd.doctor.bean;

/**
 * describe:CheckCodeBean
 * date:2019/12/11
 * author:任(Lenovo)
 * function:校验验证码
 */
public class CheckCodeBean {

    /**
     * message : 验证通过
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
