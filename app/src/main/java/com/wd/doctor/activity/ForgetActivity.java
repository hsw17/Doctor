package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.bean.SendEmailCodeBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "ForgetActivity";
    @BindView(R2.id.new_email)
    EditText newEmail;
    @BindView(R2.id.edit_code)
    EditText editCode;
    private String email;
    private String code;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_forget;
    }

    @Override
    protected void initData() {
        super.initData();
        ToastUtils.init(this);

    }

    @Override
    public void onSuccess(Object obj) {
        SendEmailCodeBean sendEmailCodeBean = (SendEmailCodeBean) obj;
        Logger.e(TAG,sendEmailCodeBean.getMessage());
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

    @OnClick({R.id.img_back, R.id.btn_email, R.id.next})
    public void onClick(View view) {
        email = newEmail.getText().toString();
        code = editCode.getText().toString();
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.btn_email:
                if (!TextUtils.isEmpty(email)) {
                    presenter.doSendEmail(email);
                }
                else {
                    ToastUtils.show("请输入您的邮箱号");
                }
                break;
            case R.id.next:

                if (!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(code)) {
                    Intent intent = new Intent(this,ResetUserPwdActivity.class);
                    intent.putExtra("email", email);
                    startActivity(intent);
                }else {
                    ToastUtils.show("不能不输入邮箱与验证码");
                }
                break;
        }
    }
}
