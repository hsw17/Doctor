package com.wd.doctor.activity.manage;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import com.wd.doctor.R;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReplyActivity extends BaseActivity<Presenter> {

    @BindView(R.id.item_switch)
    Switch itemSwitch;

    @Override
    protected Presenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_reply;
    }

    @OnClick({R.id.img_back, R.id.item_switch})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.item_switch:
                break;
        }
    }
}
