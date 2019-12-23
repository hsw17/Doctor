package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.doctor.R;
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.bean.FindJobTitleListBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.EventBusUtils;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.SPUtils;
import com.wd.mvplibrary.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.GridLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register1Activity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "Register1Activity";
    @BindView(R.id.et_name_register1)
    EditText etNameRegister1;
    @BindView(R.id.et_inauguralHospital_register1)
    EditText etInauguralHospitalRegister1;
    @BindView(R.id.et_departmentName_register1)
    TextView etDepartmentNameRegister1;
    @BindView(R.id.et_jobTitle_register1)
    TextView etJobTitleRegister1;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_register1;
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    public void onSuccess(Object obj) {

    }

    @Override
    public void onSuccessOne(Object one) {
        FindDepartmentBean findDepartmentBean = (FindDepartmentBean) one;
        Logger.e(TAG, findDepartmentBean.getMessage() + "findDepartmentBean");

    }

    @Override
    public void onSuccessTwo(Object two) {
        FindJobTitleListBean findJobTitleListBean = (FindJobTitleListBean) two;
        Logger.e(TAG, findJobTitleListBean.getMessage() + "findJobTitleListBean");

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

    @OnClick({R.id.relative_departmentName, R.id.relative_jobTitle, R.id.btn_next_register1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.relative_departmentName:
                presenter.doFindDepartment();
                break;
            case R.id.relative_jobTitle:
                presenter.doFindJobTitle();
                break;
            case R.id.btn_next_register1:
                String name = etNameRegister1.getText().toString();
                String hospital = etInauguralHospitalRegister1.getText().toString();
                /*String department = etDepartmentNameRegister1.toString();
                String jobTitle = etJobTitleRegister1.toString();*/
                String department = "小儿科";
                String jobTitle = "主任";
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(hospital) && !TextUtils.isEmpty(department) && !TextUtils.isEmpty(jobTitle)) {
                    Intent intent = new Intent(this, RegisterActivity.class);
                    SPUtils reg = new SPUtils(this, "reg");
                    reg.SharedPreferenceput("name",name);
                    reg.SharedPreferenceput("hospital",hospital);
                    reg.SharedPreferenceput("department",department);
                    reg.SharedPreferenceput("jobTitle",jobTitle);
                    startActivity(intent);
                }else {
                    ToastUtils.show("这些选项为必选,不能不答");
                }
                break;
        }
    }
}
