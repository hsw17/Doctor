package com.wd.doctor.bean;

/**
 * describe:ResetUserPwdBean
 * date:2019/12/17
 * author:任(Lenovo)
 * function:重置用户密码（忘记密码用）
 */
public class ResetUserPwdBean {

    /**
     * message : 密码重置成功
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
