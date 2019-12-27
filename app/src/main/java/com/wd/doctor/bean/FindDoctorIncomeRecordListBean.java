package com.wd.doctor.bean;

import java.util.List;

/**
 * describe:FindDoctorIncomeRecordListBean
 * date:2019/12/26
 * author:任(Lenovo)
 * function:查询医生收支记录
 */
public class FindDoctorIncomeRecordListBean {

    /**
     * result : [{"direction":1,"incomeType":1,"money":500,"recordTime":1577289600000},{"direction":1,"incomeType":1,"money":500,"recordTime":1577289600000},{"direction":1,"incomeType":1,"money":500,"recordTime":1577289600000},{"direction":1,"incomeType":1,"money":500,"recordTime":1577289600000},{"direction":1,"incomeType":1,"money":500,"recordTime":1577289600000}]
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
         * direction : 1
         * incomeType : 1
         * money : 500
         * recordTime : 1577289600000
         */

        private int direction;
        private int incomeType;
        private int money;
        private long recordTime;

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }

        public int getIncomeType() {
            return incomeType;
        }

        public void setIncomeType(int incomeType) {
            this.incomeType = incomeType;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public long getRecordTime() {
            return recordTime;
        }

        public void setRecordTime(long recordTime) {
            this.recordTime = recordTime;
        }
    }
}
