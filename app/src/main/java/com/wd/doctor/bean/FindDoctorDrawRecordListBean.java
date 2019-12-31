package com.wd.doctor.bean;

import java.util.List;

/**
 * describe:FindDoctorDrawRecordListBean
 * date:2019/12/30
 * author:任(Lenovo)
 * function: 查询用户提现记录
 */
public class FindDoctorDrawRecordListBean {

    /**
     * result : [{"bankCardNumber":"123456789","bankName":"中国银行","createTime":1577668097000,"id":324,"money":0,"remark":"提现","status":2},{"bankCardNumber":"123456789","bankName":"中国银行","createTime":1577668089000,"id":323,"money":0,"remark":"提现","status":2},{"bankCardNumber":"123456789","bankName":"中国银行","createTime":1577350748000,"id":304,"money":2,"remark":"提现","status":2}]
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
         * bankCardNumber : 123456789
         * bankName : 中国银行
         * createTime : 1577668097000
         * id : 324
         * money : 0
         * remark : 提现
         * status : 2
         */

        private String bankCardNumber;
        private String bankName;
        private long createTime;
        private int id;
        private int money;
        private String remark;
        private int status;

        public String getBankCardNumber() {
            return bankCardNumber;
        }

        public void setBankCardNumber(String bankCardNumber) {
            this.bankCardNumber = bankCardNumber;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
