package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.wd.doctor.R;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register2Activity extends BaseActivity<Presenter> implements Contract.IView {

    @BindView(R.id.et_personalProfile_register2)
    EditText etPersonalProfileRegister2;
    @BindView(R.id.et_goodField_register2)
    EditText etGoodFieldRegister2;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_register2;
    }

    @Override
    protected void initData() {
        super.initData();
        ToastUtils.init(this);
        etGoodFieldRegister2.addTextChangedListener(new TextWatcher() {
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
                    etGoodFieldRegister2.setText(str1);
                    etGoodFieldRegister2.setSelection(start);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etPersonalProfileRegister2.addTextChangedListener(new TextWatcher() {
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
                    etPersonalProfileRegister2.setText(str1);
                    etPersonalProfileRegister2.setSelection(start);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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

    @OnClick({R.id.img_back, R.id.btn_applyJoin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                break;
            case R.id.btn_applyJoin:
                String personal = etPersonalProfileRegister2.getText().toString();
                String good = etGoodFieldRegister2.getText().toString();
                if (!TextUtils.isEmpty(personal) && !TextUtils.isEmpty(good)) {
                    Intent intent = new Intent(this, Register3Activity.class);
                    startActivity(intent);
                }else {
                    ToastUtils.show("这些选项为必选,不能不答");
                }
                break;
        }
    }
}
