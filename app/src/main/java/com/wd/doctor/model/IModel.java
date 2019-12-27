package com.wd.doctor.model;

import com.wd.doctor.bean.ApplyJoinBean;
import com.wd.doctor.bean.BindDoctorBankCardBean;
import com.wd.doctor.bean.BindDoctorIdCardBean;
import com.wd.doctor.bean.CheckCodeBean;
import com.wd.doctor.bean.ChooseImagePicBean;
import com.wd.doctor.bean.DrawCashBean;
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.bean.FindDoctorBankCardByIdBean;
import com.wd.doctor.bean.FindDoctorByIdBean;
import com.wd.doctor.bean.FindDoctorIdCardInfoBean;
import com.wd.doctor.bean.FindDoctorIncomeRecordListBean;
import com.wd.doctor.bean.FindDoctorWalletBean;
import com.wd.doctor.bean.FindHistoryInquiryRecordBean;
import com.wd.doctor.bean.FindInquiryDetailsListBean;
import com.wd.doctor.bean.FindInquiryRecordListBean;
import com.wd.doctor.bean.FindJobTitleListBean;
import com.wd.doctor.bean.FindSickCircleInfoBean;
import com.wd.doctor.bean.FindSickCircleListBean;
import com.wd.doctor.bean.FindSystemImagePicBean;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.PublishCommentBean;
import com.wd.doctor.bean.PushMessageBean;
import com.wd.doctor.bean.ResetUserPwdBean;
import com.wd.doctor.bean.SearchSickCircleBean;
import com.wd.doctor.bean.SendEmailCodeBean;
import com.wd.doctor.bean.UploadImagePicBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.util.HttpUtil;
import com.wd.mvplibrary.utils.CommonObserver;
import com.wd.mvplibrary.utils.CommonSchedulers;

import java.util.Map;

import io.reactivex.internal.observers.BlockingBaseObserver;
import okhttp3.MultipartBody;

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
    public void doApplyJoin(Map<String,Object> ApplyMap, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doApplyJoin(ApplyMap)
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

    @Override
    public void doFindSystem(IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindSystem()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindSystemImagePicBean>() {
                    @Override
                    public void onNext(FindSystemImagePicBean findSystemImagePicBean) {
                        iModelCallback.onSuccessOne(findSystemImagePicBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindSickCircle(String departmentId,String page,String count, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindSickCircle(departmentId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindSickCircleListBean>() {
                    @Override
                    public void onNext(FindSickCircleListBean findSickCircleListBean) {
                        iModelCallback.onSuccess(findSickCircleListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doSearchSickCircle(String keyWord, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doSearchSickCircle(keyWord)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<SearchSickCircleBean>() {
                    @Override
                    public void onNext(SearchSickCircleBean searchSickCircleBean) {
                        iModelCallback.onSuccess(searchSickCircleBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindSickInfo(String doctorId, String sessionId, String sickCircleId, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindSickInfo(doctorId,sessionId,sickCircleId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindSickCircleInfoBean>() {
                    @Override
                    public void onNext(FindSickCircleInfoBean findSickCircleInfoBean) {
                        iModelCallback.onSuccess(findSickCircleInfoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindDoctorById(String doctorId, String sessionId, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindDoctorById(doctorId,sessionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindDoctorByIdBean>() {
                    @Override
                    public void onNext(FindDoctorByIdBean findDoctorByIdBean) {
                        iModelCallback.onSuccess(findDoctorByIdBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doChooseImagePic(String doctorId, String sessionId, String imagePic, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doChooseImagePic(doctorId,sessionId,imagePic)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<ChooseImagePicBean>() {
                    @Override
                    public void onNext(ChooseImagePicBean chooseImagePicBean) {
                        iModelCallback.onSuccess(chooseImagePicBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doPublishComment(String doctorId, String sessionId, String sickCircleId, String content, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doPublishComment(doctorId,sessionId,sickCircleId,content)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<PublishCommentBean>() {
                    @Override
                    public void onNext(PublishCommentBean publishCommentBean) {
                        iModelCallback.onSuccessOne(publishCommentBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doCheckCode(String email, String code, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doCheckCode(email,code)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CheckCodeBean>() {
                    @Override
                    public void onNext(CheckCodeBean checkCodeBean) {
                        iModelCallback.onSuccessOne(checkCodeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doResetUserPwd(String email, String pwd1, String pwd2, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doResetUserPwd(email,pwd1,pwd2)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<ResetUserPwdBean>() {
                    @Override
                    public void onNext(ResetUserPwdBean resetUserPwdBean) {
                        iModelCallback.onSuccessTwo(resetUserPwdBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindDoctorWallet(String doctorId, String sessionId, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindDoctorWallet(doctorId,sessionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindDoctorWalletBean>() {
                    @Override
                    public void onNext(FindDoctorWalletBean findDoctorWalletBean) {
                        iModelCallback.onSuccess(findDoctorWalletBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doBindDoctorIdCard(String doctorId, String sessionId, Map<String,Object> BodyMap, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doBindDoctorIdCard(doctorId,sessionId,BodyMap)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<BindDoctorIdCardBean>() {
                    @Override
                    public void onNext(BindDoctorIdCardBean bindDoctorIdCardBean) {
                        iModelCallback.onSuccess(bindDoctorIdCardBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }
    @Override
    public void doBindDoctorBandCard(String doctorId, String sessionId, String bankCardNumber, String bankName, String bankCardType, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doBindDoctorBandCard(doctorId,sessionId,bankCardNumber,bankName,bankCardType)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<BindDoctorBankCardBean>() {
                    @Override
                    public void onNext(BindDoctorBankCardBean bindDoctorBankCardBean) {
                        iModelCallback.onSuccessOne(bindDoctorBankCardBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindUploadImagePic(String doctorId, String sessionId, MultipartBody.Part imagePic, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindUploadImagePic(doctorId,sessionId,imagePic)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<UploadImagePicBean>() {
                    @Override
                    public void onNext(UploadImagePicBean uploadImagePicBean) {
                        iModelCallback.onSuccess(uploadImagePicBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindDoctorBankCardById(String doctorId, String sessionId,IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindDoctorBankCardById(doctorId,sessionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindDoctorBankCardByIdBean>() {
                    @Override
                    public void onNext(FindDoctorBankCardByIdBean findDoctorBankCardByIdBean) {
                        iModelCallback.onSuccessOne(findDoctorBankCardByIdBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindInquiryRecordList(String doctorId, String sessionId, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindInquiryRecordList(doctorId,sessionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindInquiryRecordListBean>() {
                    @Override
                    public void onNext(FindInquiryRecordListBean findInquiryRecordListBean) {
                        iModelCallback.onSuccess(findInquiryRecordListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindHistoryInquiryRecord(String doctorId, String sessionId, String page, String count, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindHistoryInquiryRecord(doctorId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindHistoryInquiryRecordBean>() {
                    @Override
                    public void onNext(FindHistoryInquiryRecordBean findHistoryInquiryRecordBean) {
                        iModelCallback.onSuccess(findHistoryInquiryRecordBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindInquiryDetailsList(String doctorId, String sessionId, String inquiryId, String page, String count, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindInquiryDetailsList(doctorId,sessionId,inquiryId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindInquiryDetailsListBean>() {
                    @Override
                    public void onNext(FindInquiryDetailsListBean findInquiryDetailsListBean) {
                        iModelCallback.onSuccess(findInquiryDetailsListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doPushMessage(String doctorId, String sessionId, String inquiryId, String content, String type, String userId, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doPushMessage(doctorId,sessionId,inquiryId,content,type,userId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<PushMessageBean>() {
                    @Override
                    public void onNext(PushMessageBean pushMessageBean) {
                        iModelCallback.onSuccessOne(pushMessageBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindDoctorIncomeRecordList(String doctorId, String sessionId, String page, String count, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindDoctorIncomeRecordList(doctorId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindDoctorIncomeRecordListBean>() {
                    @Override
                    public void onNext(FindDoctorIncomeRecordListBean findDoctorIncomeRecordListBean) {
                        iModelCallback.onSuccessOne(findDoctorIncomeRecordListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doDrawCash(String doctorId, String sessionId, String money, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doDrawCash(doctorId,sessionId,money)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DrawCashBean>() {
                    @Override
                    public void onNext(DrawCashBean drawCashBean) {
                        iModelCallback.onSuccessTwo(drawCashBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindDoctorIdCardInfo(String doctorId, String sessionId, IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindDoctorIdCardInfo(doctorId,sessionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindDoctorIdCardInfoBean>() {
                    @Override
                    public void onNext(FindDoctorIdCardInfoBean findDoctorIdCardInfoBean) {
                        iModelCallback.onSuccessTwo(findDoctorIdCardInfoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }


}
