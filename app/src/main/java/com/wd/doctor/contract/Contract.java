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
        //查询系统形象照
        void doFindSystem();
        //查询病友圈详情
        void doFindSickCircle(String departmentId,String page,String count);
        //根据关键词查询病友圈
        void doSearchSickCircle(String keyWord);
        //查询病友圈详情
        void doFindSickInfo(String doctorId,String sessionId,String sickCircleId);
        //根据医生id查询医生信息
        void doFindDoctorById(String doctorId,String sessionId);
    }

    //M层
    interface IModel{
        void doLogin(String email,String pwd,IModelCallback iModelCallback);
        void doSendEmail(String email,IModelCallback iModelCallback);
        void doFindDepartment(IModelCallback iModelCallback);
        void doFindJobTitle(IModelCallback iModelCallback);
        void doApplyJoin(String email,String code,String pwd1,String pwd2,String name,String inauguralHospital,String departmentName,String jobTitle,String personalProfile,String goodField,IModelCallback iModelCallback);
        void doFindSystem(IModelCallback iModelCallback);
        void doFindSickCircle(String departmentId,String page,String count,IModelCallback iModelCallback);
        void doSearchSickCircle(String keyWord,IModelCallback iModelCallback);
        void doFindSickInfo(String doctorId,String sessionId,String sickCircleId,IModelCallback iModelCallback);
        void doFindDoctorById(String doctorId,String sessionId,IModelCallback iModelCallback);
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
