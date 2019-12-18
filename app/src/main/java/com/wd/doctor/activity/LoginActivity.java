package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.wd.doctor.R;
import com.wd.doctor.bean.FindSystemImagePicBean;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.doctor.util.RsaCoder;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.EventBusUtils;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.PwdAndEmail;
import com.wd.mvplibrary.utils.SPUtils;
import com.wd.mvplibrary.utils.ToastUtils;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "LoginActivity";
    @BindView(R.id.et_email_login)
    EditText etEmailLogin;
    @BindView(R.id.et_pwd_login)
    EditText etPwdLogin;
    @BindView(R.id.tg_btn_eye)
    ToggleButton tgBtnEye;
    private List<FindSystemImagePicBean.ResultBean> resultBean;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        super.initData();
        //默认为隐藏
        etPwdLogin.setTransformationMethod(PasswordTransformationMethod.getInstance());
        tgBtnEye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //显示密码
                    etPwdLogin.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    tgBtnEye.setBackgroundResource(R.mipmap.eye);
                }else {
                    //选中时隐藏密码
                    etPwdLogin.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    tgBtnEye.setBackgroundResource(R.mipmap.close_eye);
                }
                //每次显示或者关闭时，密码显示编辑的线不统一在最后，下面是为了统一
                //设置选择
                etPwdLogin.setSelection(etPwdLogin.length());
            }
        });
        PwdAndEmail.isEmail(etEmailLogin.getText().toString());
        PwdAndEmail.isPassword(etPwdLogin.getText().toString());
        etEmailLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().contains(" ")) {
                    String[] str = s.toString().split(" ");
                    String str1 = "";
                    for (int i = 0; i < str.length; i++) {
                        str1 += str[i];
                    }
                    etEmailLogin.setText(str1);
                    etEmailLogin.setSelection(start);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etPwdLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().contains(" ")) {
                    String[] str = s.toString().split(" ");
                    String str1 = "";
                    for (int i = 0; i < str.length; i++) {
                        str1 += str[i];
                    }
                    etPwdLogin.setText(str1);
                    etPwdLogin.setSelection(start);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        SPUtils remember = new SPUtils(this, "remember");
        String email = (String) remember.getSharedPreference("email", "");
        String pwd = (String) remember.getSharedPreference("pwd", "");
        etEmailLogin.setText(email);
        etPwdLogin.setText(pwd);
        ToastUtils.init(this);
    }

    @Override
    public void onSuccess(Object obj) {
        LoginBean loginBean = (LoginBean) obj;
        Logger.e(TAG,loginBean.getMessage());
        SPUtils user = new SPUtils(this, "user");
        user.SharedPreferenceput("doctorId",loginBean.getResult().getId()+"");
        user.SharedPreferenceput("sessionId",loginBean.getResult().getSessionId());
        SPUtils remember = new SPUtils(this, "remember");
        remember.SharedPreferenceput("email",etEmailLogin.getText().toString());
        remember.SharedPreferenceput("pwd",etPwdLogin.getText().toString());
        if ("0000".equals(loginBean.getStatus())) {
            ToastUtils.show(loginBean.getMessage());
            Intent intent = new Intent(this, ShowActivity.class);
            intent.putExtra("name",loginBean.getResult().getName());
            intent.putExtra("inauguralHospital",loginBean.getResult().getInauguralHospital());
            intent.putExtra("jobTitle",loginBean.getResult().getJobTitle());
            intent.putExtra("departmentName",loginBean.getResult().getDepartmentName());
            int whetherHaveImagePic = loginBean.getResult().getWhetherHaveImagePic();
            if (whetherHaveImagePic==1) {
                intent.putExtra("imagePic",loginBean.getResult().getImagePic());
            }else if (whetherHaveImagePic==2){
                presenter.doFindSystem();
                intent.putExtra("imagePic",resultBean.get(1).getImagePic());
            }
            startActivity(intent);
        }else {
            ToastUtils.show(loginBean.getMessage());
        }
    }

    @Override
    public void onSuccessOne(Object one) {
        FindSystemImagePicBean findSystemImagePicBean = (FindSystemImagePicBean) one;
        Logger.e(TAG,findSystemImagePicBean.getMessage());
        resultBean = findSystemImagePicBean.getResult();
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

    @OnClick({R.id.tv_forget_login, R.id.tv_register_login, R.id.btn_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_forget_login:
                Intent intent1 = new Intent(this, ForgetActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_register_login:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                String email = etEmailLogin.getText().toString();
                String pwd = etPwdLogin.getText().toString();
                try {
                    pwd = RsaCoder.encryptByPublicKey(pwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pwd)) {
                    presenter.doLogin(email,pwd);
                } else {
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
