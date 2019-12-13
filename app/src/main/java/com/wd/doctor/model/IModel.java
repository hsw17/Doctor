package com.wd.doctor.model;

import com.wd.doctor.bean.ApplyJoinBean;
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.bean.FindJobTitleListBean;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.SendEmailCodeBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.util.HttpUtil;
import com.wd.mvplibrary.utils.CommonObserver;
import com.wd.mvplibrary.utils.CommonSchedulers;

/**
 * describe:IModel
 * date:2019/12/11
 * author:任(Lenovo)
 * function:
 */
public class IModel implements Contract.IModel {

    @Override
    public void doLogin(String email, String pwd, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doLogin(email,pwd)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<LoginBean>() {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        iModelCallback.onSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doSendEmail(String email, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doSendEmail(email)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<SendEmailCodeBean>() {
                    @Override
                    public void onNext(SendEmailCodeBean sendEmailCodeBean) {
                        iModelCallback.onSuccess(sendEmailCodeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindDepartment(IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindDepartment()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindDepartmentBean>() {
                    @Override
                    public void onNext(FindDepartmentBean findDepartmentBean) {
                        iModelCallback.onSuccessOne(findDepartmentBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindJobTitle(IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindJobTitle()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindJobTitleListBean>() {
                    @Override
                    public void onNext(FindJobTitleListBean findJobTitleListBean) {
                        iModelCallback.onSuccessTwo(findJobTitleListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doApplyJoin(String email, String code, String pwd1, String pwd2, String name, String inauguralHospital, String departmentName, String jobTitle, String personalProfile, String goodField, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doApplyJoin(email,code,pwd1,pwd2,name,inauguralHospital,departmentName,jobTitle,personalProfile,goodField)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<ApplyJoinBean>() {
                    @Override
                    public void onNext(ApplyJoinBean applyJoinBean) {
                        iModelCallback.onSuccess(applyJoinBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }
}
