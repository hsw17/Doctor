package com.wd.doctor.ap;

import com.wd.doctor.bean.ApplyJoinBean;
import com.wd.doctor.bean.BindDoctorBankCardBean;
import com.wd.doctor.bean.BindDoctorIdCard;
import com.wd.doctor.bean.BindDoctorIdCardBean;
import com.wd.doctor.bean.CheckCodeBean;
import com.wd.doctor.bean.ChooseImagePicBean;
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.bean.FindDoctorBankCardByIdBean;
import com.wd.doctor.bean.FindDoctorByIdBean;
import com.wd.doctor.bean.FindDoctorWalletBean;
import com.wd.doctor.bean.FindHistoryInquiryRecordBean;
import com.wd.doctor.bean.FindInquiryRecordListBean;
import com.wd.doctor.bean.FindJobTitleListBean;
import com.wd.doctor.bean.FindSickCircleInfoBean;
import com.wd.doctor.bean.FindSickCircleListBean;
import com.wd.doctor.bean.FindSystemImagePicBean;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.PublishCommentBean;
import com.wd.doctor.bean.ResetUserPwdBean;
import com.wd.doctor.bean.SearchSickCircleBean;
import com.wd.doctor.bean.SendEmailCodeBean;
import com.wd.doctor.bean.UploadImagePicBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * describe:ApiServer
 * date:2019/12/11
 * author:任(Lenovo)
 * function:
 */
public interface ApiServer {
    @FormUrlEncoded
    @POST("doctor/v1/login")
    Observable<LoginBean> doLogin(@Field("email") String email,@Field("pwd") String pwd);
    @POST("doctor/v1/sendEmailCode")
    Observable<SendEmailCodeBean> doSendEmail(@Query("email") String email);
    @GET("share/knowledgeBase/v1/findDepartment")
    Observable<FindDepartmentBean> doFindDepartment();
    @GET("doctor/v1/findJobTitleList")
    Observable<FindJobTitleListBean> doFindJobTitle();
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("doctor/v1/applyJoin")
    Observable<ApplyJoinBean> doApplyJoin( @Body Map<String,Object> ApplyMap);
    @GET("doctor/v1/findSystemImagePic")
    Observable<FindSystemImagePicBean> doFindSystem();
    @GET("doctor/sickCircle/v1/findSickCircleList")
    Observable<FindSickCircleListBean> doFindSickCircle(@Query("departmentId") String departmentId,@Query("page") String page,@Query("count") String count);
    @GET("doctor/sickCircle/v1/searchSickCircle")
    Observable<SearchSickCircleBean> doSearchSickCircle(@Query("keyWord") String keyWord);
    @GET("doctor/sickCircle/v1/findSickCircleInfo")
    Observable<FindSickCircleInfoBean> doFindSickInfo(@Header("doctorId") String doctorId,@Header("sessionId") String sessionId,@Query("sickCircleId") String sickCircleId);
    @GET("doctor/verify/v1/findDoctorById")
    Observable<FindDoctorByIdBean> doFindDoctorById(@Header("doctorId") String doctorId,@Header("sessionId") String sessionId);
    @POST("doctor/verify/v1/chooseImagePic")
    Observable<ChooseImagePicBean> doChooseImagePic(@Header("doctorId") String doctorId,@Header("sessionId") String sessionId,@Query("imagePic") String imagePic);
    @POST("doctor/sickCircle/verify/v1/publishComment")
    Observable<PublishCommentBean> doPublishComment(@Header("doctorId") String doctorId,@Header("sessionId") String sessionId,@Query("sickCircleId") String sickCircleId,@Query("content") String content);
    @POST("doctor/v1/checkCode")
    Observable<CheckCodeBean> doCheckCode(@Query("email") String email,@Query("code") String code);
    @PUT("doctor/v1/resetUserPwd")
    Observable<ResetUserPwdBean> doResetUserPwd(@Query("email") String email,@Query("pwd1") String pwd1,@Query("pwd2") String pwd2);
    @POST("doctor/verify/v1/bindDoctorBankCard")
    Observable<BindDoctorBankCardBean> doBindDoctorBandCard(@Header("doctorId") String doctorId,@Header("sessionId") String sessionId,@Query("bankCardNumber") String bankCardNumber,@Query("bankName") String bankName,@Query("bankCardType") String bankCardType);
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("doctor/verify/v1/bindDoctorIdCard")
    Observable<BindDoctorIdCardBean> doBindDoctorIdCard(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Body Map<String,Object> BodyMap);
    @GET("doctor/verify/v1/findDoctorWallet")
    Observable<FindDoctorWalletBean> doFindDoctorWallet(@Header("doctorId") String doctorId,@Header("sessionId") String sessionId);
    @Multipart
    @POST("doctor/verify/v1/uploadImagePic")
    Observable<UploadImagePicBean> doFindUploadImagePic(@Header("doctorId") String doctorId,@Header("sessionId") String sessionId,@Part MultipartBody.Part imagePic);
    @GET("doctor/verify/v1/findDoctorBankCardById")
    Observable<FindDoctorBankCardByIdBean> doFindDoctorBankCardById(@Header("doctorId") String doctorId,@Header("sessionId") String sessionId);
    @GET("doctor/inquiry/verify/v1/findInquiryRecordList")
    Observable<FindInquiryRecordListBean> doFindInquiryRecordList(@Header("doctorId") String doctorId,@Header("sessionId") String sessionId);
    @GET("doctor/inquiry/verify/v1/findHistoryInquiryRecord")
    Observable<FindHistoryInquiryRecordBean> doFindHistoryInquiryRecord(@Header("doctorId") String doctorId,@Header("sessionId") String sessionId,@Query("page") String page,@Query("count") String count);
}
