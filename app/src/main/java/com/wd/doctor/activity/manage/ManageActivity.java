package com.wd.doctor.activity.manage;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.activity.manage.history.HistoryActivity;
import com.wd.doctor.bean.FindDoctorByIdBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.SPUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class ManageActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "ManageActivity";
    @BindView(R2.id.sView_imagePic_manage)
    ImageView sViewImagePicManage;
    @BindView(R2.id.linear_view)
    RelativeLayout linearView;

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
        presenter.doFindDoctorById(doctorId, sessionId);
    }

    @Override
    public void onSuccess(Object obj) {
        FindDoctorByIdBean findDoctorByIdBean = (FindDoctorByIdBean) obj;
        Logger.e(TAG, findDoctorByIdBean.getMessage() + "findDoctorByIdBean");
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

    @OnClick({R.id.sView_imagePic_manage, R.id.linear_data_manage, R.id.linear_history_manage, R.id.linear_wallet_manage,
            R.id.linear_accept_manage, R.id.linear_reply_manage, R.id.img_back,R.id.tv_change,R.id.tv_finish,R.id.linear_view})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sView_imagePic_manage:
                linearView.setVisibility(View.VISIBLE);
                break;
            case R.id.linear_data_manage:
                Intent intent = new Intent(this, DataActivity.class);
                startActivity(intent);
                break;
            case R.id.linear_history_manage:
                Intent intent1 = new Intent(this, HistoryActivity.class);
                startActivity(intent1);
                break;
            case R.id.linear_wallet_manage:
                Intent intent3 = new Intent(this, WalletActivity.class);
                startActivity(intent3);
                break;
            case R.id.linear_accept_manage:
                break;
            case R.id.linear_reply_manage:
                Intent intent4 = new Intent(this, ReplyActivity.class);
                startActivity(intent4);
                break;
            case R.id.img_back:
                finish();
                break;
            case  R.id.tv_change:
                Intent intent5 = new Intent(this, ChooseImagePicActivity.class);
                startActivity(intent5);
                linearView.setVisibility(View.GONE);
                break;
            case R.id.tv_finish:
                linearView.setVisibility(View.GONE);
                break;
            case R.id.linear_view:
                linearView.setVisibility(View.GONE);
                break;
        }
    }
}
