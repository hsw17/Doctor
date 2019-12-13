package com.wd.doctor.contract;

import com.wd.mvplibrary.base.IBaseView;

/**
 * describe:Contract
 * date:2019/12/11
 * author:任(Lenovo)
 * function:
 */
public interface Contract {
    //V层
    interface IView extends IBaseView {
        void onSuccess(Object obj);
        void onSuccessOne(Object one);
        void onSuccessTwo(Object two);
        void onSuccessThree(Object three);
        void onSuccessFour(Object four);
        void onFail(String str);
    }

    //P层
    interface IPresenter {
        //登录
        void doLogin(String email,String pwd);
        //发送验证码
        void doSendEmail(String email);
        //查询科室
        void doFindDepartment();
        //查询医生职称列表
        void doFindJobTitle();
        //申请入驻
        void doApplyJoin(String email,String code,String pwd1,String pwd2,String name,String inauguralHospital,String departmentName,String jobTitle,String personalProfile,String goodField);
    }

    //M层
    interface IModel{
        void doLogin(String email,String pwd,IModelCallback iModelCallback);
        void doSendEmail(String email,IModelCallback iModelCallback);
        void doFindDepartment(IModelCallback iModelCallback);
        void doFindJobTitle(IModelCallback iModelCallback);
        void doApplyJoin(String email,String code,String pwd1,String pwd2,String name,String inauguralHospital,String departmentName,String jobTitle,String personalProfile,String goodField,IModelCallback iModelCallback);
        interface IModelCallback{
            void onSuccess(Object obj);
            void onSuccessOne(Object one);
            void onSuccessTwo(Object two);
            void onSuccessThree(Object three);
            void onSuccessFour(Object four);
            void onFail(String str);
        }
    }
}
