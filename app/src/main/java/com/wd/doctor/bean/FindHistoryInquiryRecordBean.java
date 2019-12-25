package com.wd.doctor.bean;

import java.util.List;

/**
 * describe:FindHistoryInquiryRecordBean
 * date:2019/12/25
 * author:任(Lenovo)
 * function:查询医生历史问诊记录列表
 */
public class FindHistoryInquiryRecordBean {
    /**
     * result : [{"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","inquiryTime":1577255520000,"nickName":"细嫩","recordId":3872,"status":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-23/IC143T20191223162428.jpg","userId":434}]
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
         * doctorHeadPic : http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg
         * inquiryTime : 1577255520000
         * nickName : 细嫩
         * recordId : 3872
         * status : 1
         * userHeadPic : http://172.17.8.100/images/health/user/head_pic/2019-12-23/IC143T20191223162428.jpg
         * userId : 434
         */

        private String doctorHeadPic;
        private long inquiryTime;
        private String nickName;
        private int recordId;
        private int status;
        private String userHeadPic;
        private int userId;

        public String getDoctorHeadPic() {
            return doctorHeadPic;
        }

        public void setDoctorHeadPic(String doctorHeadPic) {
            this.doctorHeadPic = doctorHeadPic;
        }

        public long getInquiryTime() {
            return inquiryTime;
        }

        public void setInquiryTime(long inquiryTime) {
            this.inquiryTime = inquiryTime;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getRecordId() {
            return recordId;
        }

        public void setRecordId(int recordId) {
            this.recordId = recordId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getUserHeadPic() {
            return userHeadPic;
        }

        public void setUserHeadPic(String userHeadPic) {
            this.userHeadPic = userHeadPic;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
