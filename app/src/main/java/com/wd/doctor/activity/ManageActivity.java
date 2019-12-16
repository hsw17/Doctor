package com.wd.doctor.activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.bean.FindDoctorByIdBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.SPUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ManageActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "ManageActivity";
    @BindView(R.id.sView_imagePic_manage)
    ImageView sViewImagePicManage;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_manage;
    }

    @Override
    protected void initData() {
        super.initData();
        SPUtils user = new SPUtils(this, "user");
        String doctorId = (String) user.getSharedPreference("doctorId", "");
        String sessionId = (String) user.getSharedPreference("sessionId", "");
        presenter.doFindDoctorById(doctorId,sessionId);
    }

    @Override
    public void onSuccess(Object obj) {
        FindDoctorByIdBean findDoctorByIdBean = (FindDoctorByIdBean) obj;
        Logger.e(TAG,findDoctorByIdBean.getMessage()+"findDoctorByIdBean");
        FindDoctorByIdBean.ResultBean result = findDoctorByIdBean.getResult();
        Glide.with(this).load(result.getImagePic()).into(sViewImagePicManage);
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

    }

    @OnClick({R.id.sView_imagePic_manage, R.id.linear_data_manage, R.id.linear_history_manage, R.id.linear_wallet_manage, R.id.linear_accept_manage, R.id.linear_reply_manage, R.id.img_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sView_imagePic_manage:
                break;
            case R.id.linear_data_manage:
                break;
            case R.id.linear_history_manage:
                break;
            case R.id.linear_wallet_manage:
                break;
            case R.id.linear_accept_manage:
                break;
            case R.id.linear_reply_manage:
                break;
            case R.id.img_back:
                break;
        }
    }
}
