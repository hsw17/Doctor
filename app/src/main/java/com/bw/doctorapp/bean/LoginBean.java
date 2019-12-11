package com.bw.doctorapp.bean;

/**
 * describe:LoginBean
 * date:2019/12/11
 * author:任(Lenovo)
 * function:
 */
public class LoginBean {

    /**
     * result : {"departmentId":5,"departmentName":"小儿科","id":155,"inauguralHospital":"清华大学附属医院","jiGuangPwd":"MwYhbjsY8d6MyOaaZbMiFD876kF+a7Gasa4WckVpEoADO5iFArEtr3CuHJaOeu3YouRn66yAmyCNpxhBbjXO4DWAmJjDHGy45JAQE+Z4m3JU/+X8ta0/cylWEEswYw8WDlmrwPdbvAv0MLEqgxeVk7CP/h2dv9YIb7g+NhNISdA=","jobTitle":"主任","name":"任二","reviewStatus":2,"sessionId":"1551576023482814155","userName":"rTOf6N1340073785","whetherHaveImagePic":2}
     * message : 登录成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
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

    public static class ResultBean {
        /**
         * departmentId : 5
         * departmentName : 小儿科
         * id : 155
         * inauguralHospital : 清华大学附属医院
         * jiGuangPwd : MwYhbjsY8d6MyOaaZbMiFD876kF+a7Gasa4WckVpEoADO5iFArEtr3CuHJaOeu3YouRn66yAmyCNpxhBbjXO4DWAmJjDHGy45JAQE+Z4m3JU/+X8ta0/cylWEEswYw8WDlmrwPdbvAv0MLEqgxeVk7CP/h2dv9YIb7g+NhNISdA=
         * jobTitle : 主任
         * name : 任二
         * reviewStatus : 2
         * sessionId : 1551576023482814155
         * userName : rTOf6N1340073785
         * whetherHaveImagePic : 2
         */

        private int departmentId;
        private String departmentName;
        private int id;
        private String inauguralHospital;
        private String jiGuangPwd;
        private String jobTitle;
        private String name;
        private int reviewStatus;
        private String sessionId;
        private String userName;
        private int whetherHaveImagePic;

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getInauguralHospital() {
            return inauguralHospital;
        }

        public void setInauguralHospital(String inauguralHospital) {
            this.inauguralHospital = inauguralHospital;
        }

        public String getJiGuangPwd() {
            return jiGuangPwd;
        }

        public void setJiGuangPwd(String jiGuangPwd) {
            this.jiGuangPwd = jiGuangPwd;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getReviewStatus() {
            return reviewStatus;
        }

        public void setReviewStatus(int reviewStatus) {
            this.reviewStatus = reviewStatus;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getWhetherHaveImagePic() {
            return whetherHaveImagePic;
        }

        public void setWhetherHaveImagePic(int whetherHaveImagePic) {
            this.whetherHaveImagePic = whetherHaveImagePic;
        }
    }
}
