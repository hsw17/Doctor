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
import android.widget.ToggleButton;

import com.wd.doctor.R;
import com.wd.doctor.bean.SendEmailCodeBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.EventBusUtils;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.PwdAndEmail;
import com.wd.mvplibrary.utils.SPUtils;
import com.wd.mvplibrary.utils.ToastUtils;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "RegisterActivity";
    @BindView(R.id.et_email_register)
    EditText etEmailRegister;
    @BindView(R.id.et_pwd_register)
    EditText etPwdRegister;
    @BindView(R.id.tg_btn_pwd_eye)
    ToggleButton tgBtnPwdEye;
    @BindView(R.id.et_pwd1_register)
    EditText etPwd1Register;
    @BindView(R.id.tg_btn_pwd1_eye)
    ToggleButton tgBtnPwd1Eye;
    @BindView(R.id.et_code_register)
    EditText etCodeRegister;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initData() {
        super.initData();
        ToastUtils.init(this);
        //默认为隐藏
        etPwdRegister.setTransformationMethod(PasswordTransformationMethod.getInstance());
        tgBtnPwdEye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //显示密码
                    etPwdRegister.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    tgBtnPwdEye.setBackgroundResource(R.mipmap.eye);
                }else {
                    //选中时隐藏密码
                    etPwdRegister.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    tgBtnPwdEye.setBackgroundResource(R.mipmap.close_eye);
                }
                //每次显示或者关闭时，密码显示编辑的线不统一在最后，下面是为了统一
                //设置选择
                etPwdRegister.setSelection(etPwdRegister.length());
            }
        });
        etPwd1Register.setTransformationMethod(PasswordTransformationMethod.getInstance());
        tgBtnPwd1Eye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //显示密码
                    etPwd1Register.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    tgBtnPwd1Eye.setBackgroundResource(R.mipmap.eye);
                }else {
                    //选中时隐藏密码
                    etPwd1Register.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    tgBtnPwd1Eye.setBackgroundResource(R.mipmap.close_eye);
                }
                //每次显示或者关闭时，密码显示编辑的线不统一在最后，下面是为了统一
                //设置选择
                etPwd1Register.setSelection(etPwd1Register.length());
            }
        });
        PwdAndEmail.isEmail(etEmailRegister.getText().toString());
        PwdAndEmail.isPassword(etPwdRegister.getText().toString());
        PwdAndEmail.isPassword(etPwd1Register.getText().toString());
        etEmailRegister.addTextChangedListener(new TextWatcher() {
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
                    etEmailRegister.setText(str1);
                    etEmailRegister.setSelection(start);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etCodeRegister.addTextChangedListener(new TextWatcher() {
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
                    etCodeRegister.setText(str1);
                    etCodeRegister.setSelection(start);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etPwdRegister.addTextChangedListener(new TextWatcher() {
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
                    etPwdRegister.setText(str1);
                    etPwdRegister.setSelection(start);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etPwd1Register.addTextChangedListener(new TextWatcher() {
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
                    etPwd1Register.setText(str1);
                    etPwd1Register.setSelection(start);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ToastUtils.init(this);
    }

    @Override
    public void onSuccess(Object obj) {
        SendEmailCodeBean sendEmailCodeBean = (SendEmailCodeBean) obj;
        Logger.e(TAG,sendEmailCodeBean.getMessage()+"sendEmailCodeBean");
        ToastUtils.show(sendEmailCodeBean.getMessage());
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

    @OnClick({R.id.btn_code_register, R.id.btn_next_register})
    public void onClick(View view) {
        String email = etEmailRegister.getText().toString();
        String code = etCodeRegister.getText().toString();
        String pwd = etPwdRegister.getText().toString();
        String pwd1 = etPwd1Register.getText().toString();
        switch (view.getId()) {
            case R.id.btn_code_register:
                presenter.doSendEmail(email);
                break;
            case R.id.btn_next_register:
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(code) && !TextUtils.isEmpty(pwd) && !TextUtils.isEmpty(pwd1)) {
                    Intent intent = new Intent(this, Register1Activity.class);
                    HashMap<String,String> map = new HashMap<>();
                    map.put("email_register",email);
                    map.put("code_register",code);
                    map.put("pwd_register",pwd);
                    map.put("pwd1_register",pwd1);
                    EventBusUtils.postSticky(map);
                    startActivity(intent);
                }else {
                    ToastUtils.show("这些选项为必选,不能不答");
                }
                break;
        }
    }
}
