package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.wd.doctor.R;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;

import androidx.annotation.NonNull;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<Presenter> {

    private int count = 3;

    @Override
    protected Presenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        Message message = handler.obtainMessage(1);
        handler.sendMessageDelayed(message,1000);
    }

    @OnClick(R.id.relative_main)
    public void onClick() {
        count = 0;
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    count--;
                    if (count > 0){
                        Message message = handler.obtainMessage(1);
                        handler.sendMessageDelayed(message,1000);
                    }else{
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
            }
        }
    };
}
