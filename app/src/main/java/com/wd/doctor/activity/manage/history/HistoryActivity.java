package com.wd.doctor.activity.manage.history;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.activity.inquiry.InquiryActivity;
import com.wd.doctor.adapter.MyRecViewHistoryAdapter;
import com.wd.doctor.bean.FindHistoryInquiryRecordBean;
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

public class HistoryActivity extends BaseActivity<Presenter> implements Contract.IView {

    @BindView(R2.id.rec_view_history)
    RecyclerView recViewHistory;
    public static final String TAG = "HistoryActivity";

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_history;
    }

    @Override
    protected void initData() {
        super.initData();
        SPUtils user = new SPUtils(this, "user");
        String doctorId = (String) user.getSharedPreference("doctorId", "");
        String sessionId = (String) user.getSharedPreference("sessionId", "");
        presenter.doFindHistoryInquiryRecord(doctorId, sessionId, "1", "10");
    }

    @Override
    public void onSuccess(Object obj) {
        FindHistoryInquiryRecordBean findHistoryInquiryRecordBean = (FindHistoryInquiryRecordBean) obj;
        Logger.e(TAG,findHistoryInquiryRecordBean.getMessage());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recViewHistory.setLayoutManager(linearLayoutManager);
        List<FindHistoryInquiryRecordBean.ResultBean> result = findHistoryInquiryRecordBean.getResult();
        MyRecViewHistoryAdapter myRecViewHistoryAdapter = new MyRecViewHistoryAdapter(result, this);
        recViewHistory.setAdapter(myRecViewHistoryAdapter);
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

    @OnClick({R.id.img_back, R.id.tv_GiftList})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_GiftList:
                break;
        }
    }
}
