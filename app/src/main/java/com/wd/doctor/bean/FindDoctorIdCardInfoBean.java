package com.wd.doctor.bean;

/**
 * describe:FindDoctorIdCardInfoBean
 * date:2019/12/26
 * author:任(Lenovo)
 * function:查询医生身份证信息
 */
public class FindDoctorIdCardInfoBean {

    /**
     * result : {"idNumber":"Tsz7wCOFE0BuEa7/W8GbDN8lPslXdyG2/G97VbD9KagGdLnjapdMf+Xgp06wK+Z7LkIGNk4UAts4Amtlpjqh5sAnEBokOOoBsA2zy+7SwiUCE1LmgE6quChnIVxr6lC6Jq9qhh4Zq1ptulAxutdG6F583CrMi9kKLsEI9Ynhbkg=","name":"kplu+1/7ZaftDc2sgQX4pPtrv3QS2IRkrmyqW+Ov05Eje8z8HqpC397qt6ay6wo3QAajFkwlLU/54Hu7K/JS5ZX7nBjfhmv09rNTGHPtFLp0fXeKYLEywRnRr968Xydqa1EIUdolFBv7KGXa5kYMaHYXe3oWaIB9q0KXKWZBpl8=","nation":"hnujmt+e/cKXjnQY35qYeGTpbKByW9W8GvooFEm9ljYZfsoBWmGIvoR+fQ+MOEezvr9wWGNiecf/dYwSykQhZIn6jddGbOBp6PPkF56QYYRSot/O6sMMDFKWp2t1BI34uFLPJJow65l3fzuX5LzJDjGVnuQdieznoxLC0pKx0Ig=","sex":"lihIj522nrHyuweP57iS3iAX7YOJNtvR2McfuNf+qZv0LYzgYsbn0jWYE9ogyilujwFMmSIt6LJk+9dGPLTQ/0l7siRaVAN33fPNRdDrGI+LHyCGAVylBNtQcEWXFiFbYW6OBQOrsOUBJvJkMvdDzMdHWG5f3cT5yUDnecLNRig="}
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
         * idNumber : Tsz7wCOFE0BuEa7/W8GbDN8lPslXdyG2/G97VbD9KagGdLnjapdMf+Xgp06wK+Z7LkIGNk4UAts4Amtlpjqh5sAnEBokOOoBsA2zy+7SwiUCE1LmgE6quChnIVxr6lC6Jq9qhh4Zq1ptulAxutdG6F583CrMi9kKLsEI9Ynhbkg=
         * name : kplu+1/7ZaftDc2sgQX4pPtrv3QS2IRkrmyqW+Ov05Eje8z8HqpC397qt6ay6wo3QAajFkwlLU/54Hu7K/JS5ZX7nBjfhmv09rNTGHPtFLp0fXeKYLEywRnRr968Xydqa1EIUdolFBv7KGXa5kYMaHYXe3oWaIB9q0KXKWZBpl8=
         * nation : hnujmt+e/cKXjnQY35qYeGTpbKByW9W8GvooFEm9ljYZfsoBWmGIvoR+fQ+MOEezvr9wWGNiecf/dYwSykQhZIn6jddGbOBp6PPkF56QYYRSot/O6sMMDFKWp2t1BI34uFLPJJow65l3fzuX5LzJDjGVnuQdieznoxLC0pKx0Ig=
         * sex : lihIj522nrHyuweP57iS3iAX7YOJNtvR2McfuNf+qZv0LYzgYsbn0jWYE9ogyilujwFMmSIt6LJk+9dGPLTQ/0l7siRaVAN33fPNRdDrGI+LHyCGAVylBNtQcEWXFiFbYW6OBQOrsOUBJvJkMvdDzMdHWG5f3cT5yUDnecLNRig=
         */

        private String idNumber;
        private String name;
        private String nation;
        private String sex;

        public String getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
