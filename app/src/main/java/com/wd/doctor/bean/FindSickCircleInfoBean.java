package com.wd.doctor.bean;

/**
 * describe:FindSickCircleInfoBean
 * date:2019/12/15
 * author:任(Lenovo)
 * function: 病友圈详情展示
 */
public class FindSickCircleInfoBean {

    /**
     * result : {"amount":0,"authorName":"","departmentId":,"departmentName":"","detail":"","disease":"","id":1649,"picture":"http://172.17.8.100/images/health/user/sickCircle/2019-12-05/f8KQys20191205184924.png","title":"","treatmentEndTime":1575475200000,"treatmentHospital":"","treatmentProcess":"","treatmentStartTime":1575475200000,"userId":397,"whetherContent":2}
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
         * amount : 0
         * authorName : 杨立朝最帅
         * departmentId : 6
         * departmentName : 耳鼻喉科
         * detail : 基督教
         * disease : 慢性中耳炎
         * id : 1649
         * picture : http://172.17.8.100/images/health/user/sickCircle/2019-12-05/f8KQys20191205184924.png
         * title : 就能死
         * treatmentEndTime : 1575475200000
         * treatmentHospital : 包子吧
         * treatmentProcess : 那些年
         * treatmentStartTime : 1575475200000
         * userId : 397
         * whetherContent : 2
         */

        private int amount;
        private String authorName;
        private int departmentId;
        private String departmentName;
        private String detail;
        private String disease;
        private int id;
        private String picture;
        private String title;
        private long treatmentEndTime;
        private String treatmentHospital;
        private String treatmentProcess;
        private long treatmentStartTime;
        private int userId;
        private int whetherContent;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

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

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getDisease() {
            return disease;
        }

        public void setDisease(String disease) {
            this.disease = disease;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getTreatmentEndTime() {
            return treatmentEndTime;
        }

        public void setTreatmentEndTime(long treatmentEndTime) {
            this.treatmentEndTime = treatmentEndTime;
        }

        public String getTreatmentHospital() {
            return treatmentHospital;
        }

        public void setTreatmentHospital(String treatmentHospital) {
            this.treatmentHospital = treatmentHospital;
        }

        public String getTreatmentProcess() {
            return treatmentProcess;
        }

        public void setTreatmentProcess(String treatmentProcess) {
            this.treatmentProcess = treatmentProcess;
        }

        public long getTreatmentStartTime() {
            return treatmentStartTime;
        }

        public void setTreatmentStartTime(long treatmentStartTime) {
            this.treatmentStartTime = treatmentStartTime;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getWhetherContent() {
            return whetherContent;
        }

        public void setWhetherContent(int whetherContent) {
            this.whetherContent = whetherContent;
        }
    }
}
