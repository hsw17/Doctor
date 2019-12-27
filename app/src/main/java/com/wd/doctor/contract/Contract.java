package com.wd.doctor.contract;

import com.wd.mvplibrary.base.IBaseView;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

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
        void doApplyJoin(Map<String,Object> ApplyMap);
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
        //选择系统提供形象照
        void doChooseImagePic(String doctorId,String sessionId,String imagePic);
        //发表评论
        void doPublishComment(String doctorId,String sessionId,String sickCircleId,String content);
        //重置用户密码（忘记密码用）
        void doResetUserPwd(String email,String pwd1,String pwd2);
        //查询医生钱包
        void doFindDoctorWallet(String doctorId,String sessionId);
        //绑定身份证
        void doBindDoctorIdCard(String doctorId, String sessionId, Map<String,Object> BodyMap);
        //绑定银行卡
        void doBindDoctorBandCard(String doctorId,String sessionId,String bankCardNumber,String bankName,String bankCardType);
        //上传头像
        void doFindUploadImagePic(String doctorId,String sessionId, MultipartBody.Part imagePic);
        //查询银行卡
        void doFindDoctorBankCardById(String doctorId,String sessionId);
        //查询医生的问诊记录列表
        void doFindInquiryRecordList(String doctorId,String sessionId);
        //查询医生历史问诊记录列表
        void doFindHistoryInquiryRecord(String doctorId,String sessionId,String page,String count);
        //查询问诊聊天记录
        void doFindInquiryDetailsList(String doctorId,String sessionId,String inquiryId,String page,String count);
        //发送消息
        void doPushMessage(String doctorId,String sessionId,String inquiryId,String content,String type,String userId);
        //查询医生收支记录
        void doFindDoctorIncomeRecordList(String doctorId,String sessionId,String page,String count);
        //提现
        void doDrawCash(String doctorId,String sessionId,String money);
        //查询医生身份证信息
        void doFindDoctorIdCardInfo(String doctorId,String sessionId);
    }

    //M层
    interface IModel{
        void doLogin(String email,String pwd,IModelCallback iModelCallback);
        void doSendEmail(String email,IModelCallback iModelCallback);
        void doFindDepartment(IModelCallback iModelCallback);
        void doFindJobTitle(IModelCallback iModelCallback);
        void doApplyJoin(Map<String,Object> ApplyMap,IModelCallback iModelCallback);
        void doFindSystem(IModelCallback iModelCallback);
        void doFindSickCircle(String departmentId,String page,String count,IModelCallback iModelCallback);
        void doSearchSickCircle(String keyWord,IModelCallback iModelCallback);
        void doFindSickInfo(String doctorId,String sessionId,String sickCircleId,IModelCallback iModelCallback);
        void doFindDoctorById(String doctorId,String sessionId,IModelCallback iModelCallback);
        void doChooseImagePic(String doctorId,String sessionId,String imagePic,IModelCallback iModelCallback);
        void doPublishComment(String doctorId,String sessionId,String sickCircleId,String content,IModelCallback iModelCallback);
        void doCheckCode(String email,String code,IModelCallback iModelCallback);
        void doResetUserPwd(String email,String pwd1,String pwd2,IModelCallback iModelCallback);
        void doFindDoctorWallet(String doctorId,String sessionId,IModelCallback iModelCallback);
        void doBindDoctorIdCard(String doctorId,String sessionId,Map<String,Object> BodyMap,IModelCallback iModelCallback);
        void doBindDoctorBandCard(String doctorId,String sessionId,String bankCardNumber,String bankName,String bankCardType,IModelCallback iModelCallback);
        void doFindUploadImagePic(String doctorId,String sessionId, MultipartBody.Part imagePic,IModelCallback iModelCallback);
        void doFindDoctorBankCardById(String doctorId,String sessionId,IModelCallback iModelCallback);
        void doFindInquiryRecordList(String doctorId,String sessionId,IModelCallback iModelCallback);
        void doFindHistoryInquiryRecord(String doctorId,String sessionId,String page,String count,IModelCallback iModelCallback);
        void doFindInquiryDetailsList(String doctorId,String sessionId,String inquiryId,String page,String count,IModelCallback iModelCallback);
        void doPushMessage(String doctorId,String sessionId,String inquiryId,String content,String type,String userId,IModelCallback iModelCallback);
        void doFindDoctorIncomeRecordList(String doctorId,String sessionId,String page,String count,IModelCallback iModelCallback);
        void doDrawCash(String doctorId,String sessionId,String money,IModelCallback iModelCallback);
        void doFindDoctorIdCardInfo(String doctorId,String sessionId,IModelCallback iModelCallback);
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
