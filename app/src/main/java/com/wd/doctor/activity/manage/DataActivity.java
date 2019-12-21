package com.wd.doctor.activity.manage;

import android.os.Bundle;
import android.widget.TextView;

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

public class DataActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "DataActivity";
    @BindView(R.id.tv_name_data)
    TextView tvNameData;
    @BindView(R.id.tv_hospital_data)
    TextView tvHospitalData;
    @BindView(R.id.tv_department_data)
    TextView tvDepartmentData;
    @BindView(R.id.tv_jobTitle_data)
    TextView tvJobTitleData;
    @BindView(R.id.tv_personal_data)
    TextView tvPersonalData;
    @BindView(R.id.tv_goodField_data)
    TextView tvGoodFieldData;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_data;
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
        tvDepartmentData.setText(result.getDepartmentName());
        tvGoodFieldData.setText(result.getGoodField());
        tvHospitalData.setText(result.getInauguralHospital());
        tvJobTitleData.setText(result.getJobTitle());
        tvNameData.setText(result.getName());
        tvPersonalData.setText(result.getPersonalProfile());
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

    @OnClick(R.id.img_back)
    public void onClick() {
        finish();
    }
}
