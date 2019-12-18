package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wd.doctor.R;
import com.wd.doctor.bean.ResetUserPwdBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.doctor.util.RsaCoder;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetUserPwdActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "ResetUserPwdActivity";
    @BindView(R.id.tv_pwd1)
    EditText tvPwd1;
    @BindView(R.id.tv_pwd2)
    EditText tvPwd2;
    private String email;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_reset_user_pwd;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        ToastUtils.init(this);
    }

    @Override
    public void onSuccess(Object obj) {

    }

    @Override
    public void onSuccessOne(Object one) {

    }

    @Override
    public void onSuccessTwo(Object two) {
        ResetUserPwdBean resetUserPwdBean = (ResetUserPwdBean) two;
        Logger.e(TAG,resetUserPwdBean.getMessage()+"resetUserPwdBean");
        ToastUtils.show(resetUserPwdBean.getMessage());
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

    @OnClick({R.id.img_back, R.id.finish})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.finish:
                String pwd1 = tvPwd1.getText().toString();
                String pwd2 = tvPwd2.getText().toString();
                try {
                    pwd1 = RsaCoder.encryptByPublicKey(pwd1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    pwd2 = RsaCoder.encryptByPublicKey(pwd2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!TextUtils.isEmpty(pwd1) && !TextUtils.isEmpty(pwd2)) {
                    presenter.doResetUserPwd(email,pwd1,pwd1);
                }
                break;
        }
    }
}
