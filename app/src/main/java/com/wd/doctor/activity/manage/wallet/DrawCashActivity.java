package com.wd.doctor.activity.manage.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.activity.manage.WalletActivity;
import com.wd.doctor.bean.DrawCashBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.SPUtils;
import com.wd.mvplibrary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DrawCashActivity extends BaseActivity<Presenter> implements Contract.IView {

    @BindView(R.id.tv_DrawRecordList)
    TextView tvDrawRecordList;
    @BindView(R.id.et_draw_cash)
    EditText etDrawCash;
    private String doctorId;
    private String sessionId;
    public static final String TAG = "DrawCashActivity";

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_draw_cash;
    }

    @Override
    protected void initData() {
        super.initData();
        SPUtils user = new SPUtils(this, "user");
        doctorId = (String) user.getSharedPreference("doctorId", "");
        sessionId = (String) user.getSharedPreference("sessionId", "");
        etDrawCash.addTextChangedListener(new TextWatcher() {
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
                    etDrawCash.setText(str1);
                    etDrawCash.setSelection(start);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etDrawCash.setInputType(InputType.TYPE_CLASS_NUMBER);
        ToastUtils.init(this);
    }

    @OnClick({R.id.img_back, R.id.btn_draw_cash,R.id.tv_DrawRecordList})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.btn_draw_cash:
                String money = etDrawCash.getText().toString();
                presenter.doDrawCash(doctorId,sessionId,money);
                break;
            case R.id.tv_DrawRecordList:
                Intent intent = new Intent(this, DrawRecordListActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onSuccess(Object obj) {

    }

    @Override
    public void onSuccessOne(Object one) {

    }

    @Override
    public void onSuccessTwo(Object two) {
        DrawCashBean drawCashBean = (DrawCashBean) two;
        Logger.e(TAG,drawCashBean.getMessage());
        if ("0000".equals(drawCashBean.getStatus())) {
            ToastUtils.show(drawCashBean.getMessage());
            Intent intent = new Intent(this, WalletActivity.class);
            startActivity(intent);
            finish();
        }
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
