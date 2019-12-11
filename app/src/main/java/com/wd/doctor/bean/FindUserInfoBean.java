package com.wd.doctor.bean;

/**
 * describe:FindUserInfoBean
 * date:2019/12/11
 * author:任(Lenovo)
 * function:查询用户详细信息
 */
public class FindUserInfoBean {
    /**
     * result : {"age":0,"height":0,"nickName":"Tu_EHSDN","sex":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_3.jpg","userId":2,"weight":0}
     * message : 查询成功
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
         * age : 0
         * height : 0
         * nickName : Tu_EHSDN
         * sex : 1
         * userHeadPic : http://172.17.8.100/images/health/user/head_pic/default/default_head_3.jpg
         * userId : 2
         * weight : 0
         */

        private int age;
        private int height;
        private String nickName;
        private int sex;
        private String userHeadPic;
        private int userId;
        private int weight;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
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

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
