package com.wd.doctor.activity.manage.history;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wd.doctor.R;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;

public class FindUserInfoActivity extends BaseActivity<Presenter> implements Contract.IView {

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_find_user_info;
    }

    @Override
    public void onSuccess(Object obj) {

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
}
