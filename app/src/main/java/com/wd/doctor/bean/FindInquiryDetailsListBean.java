package com.wd.doctor.bean;

import java.util.List;

/**
 * describe:FindInquiryDetailsListBean
 * date:2019/12/26
 * author:任(Lenovo)
 * function:查询问诊聊天记录
 */
public class FindInquiryDetailsListBean {

    /**
     * result : [{"askTime":1577258742000,"content":"我不怎么好","direction":2,"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","msgType":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-23/IC143T20191223162428.jpg"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * askTime : 1577258742000
         * content : 我不怎么好
         * direction : 2
         * doctorHeadPic : http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg
         * msgType : 1
         * userHeadPic : http://172.17.8.100/images/health/user/head_pic/2019-12-23/IC143T20191223162428.jpg
         */

        private long askTime;
        private String content;
        private int direction;
        private String doctorHeadPic;
        private int msgType;
        private String userHeadPic;

        public long getAskTime() {
            return askTime;
        }

        public void setAskTime(long askTime) {
            this.askTime = askTime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }

        public String getDoctorHeadPic() {
            return doctorHeadPic;
        }

        public void setDoctorHeadPic(String doctorHeadPic) {
            this.doctorHeadPic = doctorHeadPic;
        }

        public int getMsgType() {
            return msgType;
        }

        public void setMsgType(int msgType) {
            this.msgType = msgType;
        }

        public String getUserHeadPic() {
            return userHeadPic;
        }

        public void setUserHeadPic(String userHeadPic) {
            this.userHeadPic = userHeadPic;
        }
    }
}
