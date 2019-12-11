package com.wd.doctor.bean;

import java.util.List;

/**
 * describe:SickCircleListBean
 * date:2019/12/11
 * author:任(Lenovo)
 * function:
 */
public class SickCircleListBean {

    /**
     * result : [{"amount":0,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1638,"title":"嘿嘿嘿"},{"amount":0,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1639,"title":"嘿嘿嘿"},{"amount":0,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1640,"title":"嘿嘿嘿"},{"amount":0,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1629,"title":"嘿嘿嘿"},{"amount":0,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1630,"title":"嘿嘿嘿"},{"amount":0,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1631,"title":"嘿嘿嘿"},{"amount":0,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1632,"title":"嘿嘿嘿"},{"amount":0,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1633,"title":"嘿嘿嘿"},{"amount":0,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1634,"title":"嘿嘿嘿"},{"amount":0,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1628,"title":"嘿嘿嘿"}]
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
         * amount : 0
         * detail : 呀呀呀
         * releaseTime : 1575475200000
         * sickCircleId : 1638
         * title : 嘿嘿嘿
         */

        private int amount;
        private String detail;
        private long releaseTime;
        private int sickCircleId;
        private String title;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public int getSickCircleId() {
            return sickCircleId;
        }

        public void setSickCircleId(int sickCircleId) {
            this.sickCircleId = sickCircleId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
