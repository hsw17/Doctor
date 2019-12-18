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
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.SPUtils;
import com.wd.mvplibrary.utils.ToastUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register2Activity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "Register2Activity";
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

        //Intent intent = new Intent(this, Register3Activity.class);
        //startActivity(intent);
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
                    SPUtils reg = new SPUtils(this, "reg");
                    String email = (String) reg.getSharedPreference("email", "");
                    String code = (String) reg.getSharedPreference("code", "");
                    String pwd = (String) reg.getSharedPreference("pwd", "");
                    String pwd1 = (String) reg.getSharedPreference("pwd1", "");
                    String name = (String) reg.getSharedPreference("name", "");
                    String hospital = (String) reg.getSharedPreference("hospital", "");
                    String department = (String) reg.getSharedPreference("department", "");
                    String jobTitle = (String) reg.getSharedPreference("jobTitle", "");
                    JSONArray jsonArray = new JSONArray();
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("email",email);
                        jsonObject.put("code",code);
                        jsonObject.put("pwd",pwd);
                        jsonObject.put("pwd1",pwd1);
                        jsonObject.put("name",name);
                        jsonObject.put("hospital",hospital);
                        jsonObject.put("department",department);
                        jsonObject.put("jobTitle",jobTitle);
                        jsonObject.put("personal",personal);
                        jsonObject.put("good",good);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    JSONArray put = jsonArray.put(jsonObject);
                    String s = put.toString();
                    Logger.e(TAG,s);
                }else {
                    ToastUtils.show("这些选项为必选,不能不答");
                }
                break;
        }
    }
}
