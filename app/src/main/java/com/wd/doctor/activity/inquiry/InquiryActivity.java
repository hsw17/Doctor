package com.wd.doctor.activity.inquiry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.adapter.MyRecViewInquiryAdapter;
import com.wd.doctor.bean.FindInquiryRecordListBean;
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

public class InquiryActivity extends BaseActivity<Presenter> implements Contract.IView {

    @BindView(R2.id.rec_inquiry_view)
    RecyclerView recInquiryView;
    @BindView(R2.id.img_inquiry_view)
    ImageView imgInquiryView;
    @BindView(R2.id.tv_none)
    TextView tvNone;
    private String doctorId;
    private String sessionId;
    public static final String TAG = "InquiryActivity";

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_inquiry;
    }

    @Override
    protected void initData() {
        super.initData();
        SPUtils user = new SPUtils(this, "user");
        doctorId = (String) user.getSharedPreference("doctorId", "");
        sessionId = (String) user.getSharedPreference("sessionId", "");
        presenter.doFindInquiryRecordList(doctorId,sessionId);
    }

    @Override
    public void onSuccess(Object obj) {
        FindInquiryRecordListBean findInquiryRecordListBean = (FindInquiryRecordListBean) obj;
        Logger.e(TAG,findInquiryRecordListBean.getMessage());
        if (findInquiryRecordListBean.getResult().size()!=0) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recInquiryView.setLayoutManager(linearLayoutManager);
            List<FindInquiryRecordListBean.ResultBean> result = findInquiryRecordListBean.getResult();
            MyRecViewInquiryAdapter myRecViewInquiryAdapter = new MyRecViewInquiryAdapter(result, this);
            recInquiryView.setAdapter(myRecViewInquiryAdapter);
            myRecViewInquiryAdapter.setClick(new MyRecViewInquiryAdapter.click() {
                @Override
                public void onStatus(int status) {

                }

                @Override
                public void onRecordId(int RecordId, int userId) {
                    Intent intent = new Intent(InquiryActivity.this, FindInquiryDetailsListActivity.class);
                    intent.putExtra("RecordId",RecordId);
                    intent.putExtra("userId",userId);
                    startActivity(intent);
                }
            });
        }else {
            imgInquiryView.setImageResource(R.mipmap.none_bg);
            tvNone.setText("嘤~空空如也");
        }

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

    @OnClick({R.id.img_back, R.id.rec_inquiry_view})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.rec_inquiry_view:
                break;
        }
    }
}
