package com.wd.doctor.bean;

/*
 *@auther:王晓义
 *@Date: 2019/12/11
 *@Time:14:51
 *@Description:发表评论
 **/
public class PublishCommentBean {

    /**
     * message : 发表成功
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
