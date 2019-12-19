package com.wd.doctor.presenter;

import com.wd.doctor.contract.Contract;
import com.wd.doctor.model.IModel;
import com.wd.mvplibrary.base.BasePresenter;
import com.wd.mvplibrary.utils.Logger;

/**
 * describe:Presenter
 * date:2019/12/11
 * author:任(Lenovo)
 * function:
 */
public class Presenter extends BasePresenter<Contract.IView> implements Contract.IPresenter {

    private IModel iModel;

    @Override
    protected void initModel() {
        iModel = new IModel();
    }

    @Override
    public void doLogin(String email, String pwd) {
        iModel.doLogin(email, pwd, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessOne(Object one) {

            }

            @Override
            public void onSuccessTwo(Object two) {

            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doSendEmail(String email) {
        iModel.doSendEmail(email, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessOne(Object one) {

            }

            @Override
            public void onSuccessTwo(Object two) {

            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doFindDepartment() {
        iModel.doFindDepartment(new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessOne(Object one) {
                getView().onSuccessOne(one);
            }

            @Override
            public void onSuccessTwo(Object two) {

            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doFindJobTitle() {
        iModel.doFindJobTitle(new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessOne(Object one) {

            }

            @Override
            public void onSuccessTwo(Object two) {
                getView().onSuccessTwo(two);
            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doApplyJoin(String email, String code, String pwd1, String pwd2, String name, String inauguralHospital, String departmentName, String jobTitle, String personalProfile, String goodField) {
        iModel.doApplyJoin(email, code, pwd1, pwd2, name, inauguralHospital, departmentName, jobTitle, personalProfile, goodField, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessOne(Object one) {

            }

            @Override
            public void onSuccessTwo(Object two) {

            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doFindSystem() {
        iModel.doFindSystem(new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessOne(Object one) {
                getView().onSuccessOne(one);
            }

            @Override
            public void onSuccessTwo(Object two) {

            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
                Logger.e("aaa",str);
            }
        });
    }

    @Override
    public void doFindSickCircle(String departmentId,String page,String count) {
        iModel.doFindSickCircle(departmentId, page, count, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessOne(Object one) {

            }

            @Override
            public void onSuccessTwo(Object two) {

            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doSearchSickCircle(String keyWord) {
        iModel.doSearchSickCircle(keyWord, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessOne(Object one) {

            }

            @Override
            public void onSuccessTwo(Object two) {

            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doFindSickInfo(String doctorId, String sessionId, String sickCircleId) {
        iModel.doFindSickInfo(doctorId, sessionId, sickCircleId, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessOne(Object one) {

            }

            @Override
            public void onSuccessTwo(Object two) {

            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doFindDoctorById(String doctorId, String sessionId) {
        iModel.doFindDoctorById(doctorId, sessionId, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessOne(Object one) {

            }

            @Override
            public void onSuccessTwo(Object two) {

            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doChooseImagePic(String doctorId, String sessionId, String imagePic) {
        iModel.doChooseImagePic(doctorId, sessionId, imagePic, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessOne(Object one) {

            }

            @Override
            public void onSuccessTwo(Object two) {

            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doPublishComment(String doctorId, String sessionId, String sickCircleId, String content) {
        iModel.doPublishComment(doctorId, sessionId, sickCircleId, content, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessOne(Object one) {
                getView().onSuccessOne(one);
            }

            @Override
            public void onSuccessTwo(Object two) {

            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doResetUserPwd(String email, String pwd1, String pwd2) {
        iModel.doResetUserPwd(email, pwd1, pwd2, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessOne(Object one) {

            }

            @Override
            public void onSuccessTwo(Object two) {
                getView().onSuccessTwo(two);
            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doFindDoctorWallet(String doctorId, String sessionId) {
        iModel.doFindDoctorWallet(doctorId, sessionId, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessOne(Object one) {

            }

            @Override
            public void onSuccessTwo(Object two) {

            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doBindDoctorIdCard(String doctorId, String sessionId, String doctorId1, String name, String sex, String nation, String birthday, String address, String idNumber, String issueOffice) {
        iModel.doBindDoctorIdCard(doctorId, sessionId, doctorId1, name, sex, nation, birthday, address, idNumber, issueOffice, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessOne(Object one) {

            }

            @Override
            public void onSuccessTwo(Object two) {

            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doBindDoctorBandCard(String doctorId, String sessionId, String bankCardNumber, String bankName, String bankCardType) {
        iModel.doBindDoctorBandCard(doctorId, sessionId, bankCardNumber, bankName, bankCardType, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessOne(Object one) {
                getView().onSuccess(one);
            }

            @Override
            public void onSuccessTwo(Object two) {

            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }
}
