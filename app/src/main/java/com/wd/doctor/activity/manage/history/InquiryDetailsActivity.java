package com.wd.doctor.activity.manage.history;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.adapter.MyRecViewInquiryDetailsListAdapter;
import com.wd.doctor.bean.FindInquiryDetailsListBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.SPUtils;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InquiryDetailsActivity extends BaseActivity<Presenter> implements Contract.IView {

    @BindView(R.id.rec_view_inquiry_details)
    RecyclerView recViewInquiryDetails;
    public static final String TAG = "InquiryDetailsActivity";
    @BindView(R.id.tv_name_details)
    TextView tvNameDetails;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_inquiry_details;
    }

    @Override
    protected void initData() {
        super.initData();
        SPUtils user = new SPUtils(this, "user");
        String doctorId = (String) user.getSharedPreference("doctorId", "");
        String sessionId = (String) user.getSharedPreference("sessionId", "");
        Intent intent = getIntent();
        String inquiryId = intent.getStringExtra("inquiryId");
        String nickName = intent.getStringExtra("nickName");
        presenter.doFindInquiryDetailsList(doctorId, sessionId, inquiryId, "1", "10");
        tvNameDetails.setText(nickName);
    }

    @Override
    public void onSuccess(Object obj) {
        FindInquiryDetailsListBean findInquiryDetailsListBean = (FindInquiryDetailsListBean) obj;
        Logger.e(TAG, findInquiryDetailsListBean.getMessage());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recViewInquiryDetails.setLayoutManager(linearLayoutManager);
        List<FindInquiryDetailsListBean.ResultBean> result = findInquiryDetailsListBean.getResult();
        MyRecViewInquiryDetailsListAdapter myRecViewInquiryDetailsListAdapter = new MyRecViewInquiryDetailsListAdapter(result, this);
        recViewInquiryDetails.setAdapter(myRecViewInquiryDetailsListAdapter);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
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

    @OnClick(R.id.img_back)
    public void onClick() {
        finish();
    }
}
