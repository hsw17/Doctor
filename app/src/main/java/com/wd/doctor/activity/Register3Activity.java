package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;

import com.wd.doctor.R;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register3Activity extends BaseActivity<Presenter> {

    @Override
    protected Presenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_register3;
    }

    @OnClick(R.id.btn_return)
    public void onClick() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
