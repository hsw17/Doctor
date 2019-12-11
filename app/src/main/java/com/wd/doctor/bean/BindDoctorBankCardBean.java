package com.wd.doctor.bean;

/**
 * describe:BindDoctorBankCardBean
 * date:2019/12/11
 * author:任(Lenovo)
 * function:绑定银行卡
 */
public class BindDoctorBankCardBean {

    /**
     * message : 绑定成功
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
