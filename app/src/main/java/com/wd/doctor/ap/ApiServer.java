package com.wd.doctor.ap;

import com.wd.doctor.bean.ApplyJoinBean;
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.bean.FindDoctorByIdBean;
import com.wd.doctor.bean.FindJobTitleListBean;
import com.wd.doctor.bean.FindSickCircleInfoBean;
import com.wd.doctor.bean.FindSickCircleListBean;
import com.wd.doctor.bean.FindSystemImagePicBean;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.SearchSickCircleBean;
import com.wd.doctor.bean.SendEmailCodeBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
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
    @POST("doctor/v1/applyJoin")
    Observable<ApplyJoinBean> doApplyJoin(@Part("email") String email,@Part("code") String code,@Part("pwd1") String pwd1,@Part("pwd2") String pwd2,@Part("name") String name,
            @Part("inauguralHospital") String inauguralHospital,@Part("departmentName") String departmentName,@Part("jobTitle") String jobTitle,@Part("personalProfile") String personalProfile,
            @Part("goodField") String goodField);
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
}
