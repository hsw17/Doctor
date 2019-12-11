package com.bw.doctorapp.bean;

import java.util.List;

/**
 * describe:FindJobTitleListBean
 * date:2019/12/10
 * author:任(Lenovo)
 * function:
 */
public class FindJobTitleListBean {

    /**
     * result : [{"id":1,"jobTitle":"主治医师"},{"id":2,"jobTitle":"副主任医师"},{"id":3,"jobTitle":"主任医师"}]
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
         * id : 1
         * jobTitle : 主治医师
         */

        private int id;
        private String jobTitle;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }
    }
}
