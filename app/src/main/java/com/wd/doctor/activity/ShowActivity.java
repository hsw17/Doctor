package com.wd.doctor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wd.doctor.R;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;

public class ShowActivity extends BaseActivity<Presenter> {

    @Override
    protected Presenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_show;
    }
}
