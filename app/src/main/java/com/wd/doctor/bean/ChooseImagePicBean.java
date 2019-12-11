package com.wd.doctor.bean;

/**
 * describe:ChooseImagePicBean
 * date:2019/12/11
 * author:任(Lenovo)
 * function:选择系统提供形象照
 */
public class ChooseImagePicBean {

    /**
     * result : http://172.17.8.100/images/health/doctor/system_image_pic/system_image1.jpg
     * message : 上传成功
     * status : 0000
     */

    private String result;
    private String message;
    private String status;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

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
