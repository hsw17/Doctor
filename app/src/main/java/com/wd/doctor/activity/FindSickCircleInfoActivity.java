package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.adapter.MyRecViewFindSickCircleInfoAdapter;
import com.wd.doctor.bean.FindSickCircleInfoBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.SPUtils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FindSickCircleInfoActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "FindSickCircleInfoActivity";
    @BindView(R.id.tv_title_find_sick_info)
    TextView tvTitleFindSickInfo;
    @BindView(R.id.rec_find_sick_info_view)
    RecyclerView recFindSickInfoView;
    @BindView(R.id.tv_amount_find_sick_info)
    TextView tvAmountFindSickInfo;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_find_sick_circle_info;
    }

    @Override
    protected void initData() {
        super.initData();
        SPUtils user = new SPUtils(this, "user");
        String doctorId = (String) user.getSharedPreference("doctorId", "");
        String sessionId = (String) user.getSharedPreference("sessionId", "");
        Intent intent = getIntent();
        String sickCircleId = intent.getStringExtra("sickCircleId");
        presenter.doFindSickInfo(doctorId,sessionId,sickCircleId);
    }

    @Override
    public void onSuccess(Object obj) {
        FindSickCircleInfoBean findSickCircleInfoBean = (FindSickCircleInfoBean) obj;
        Logger.e(TAG,findSickCircleInfoBean.getMessage()+"findSickCircleInfoBean");
        FindSickCircleInfoBean.ResultBean result = findSickCircleInfoBean.getResult();
        tvTitleFindSickInfo.setText(result.getDetail());
        tvAmountFindSickInfo.setText(result.getAmount()+"H币");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recFindSickInfoView.setLayoutManager(linearLayoutManager);
        MyRecViewFindSickCircleInfoAdapter myRecViewFindSickCircleInfoAdapter = new MyRecViewFindSickCircleInfoAdapter(result, this);
        recFindSickInfoView.setAdapter(myRecViewFindSickCircleInfoAdapter);
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

    @OnClick({R.id.img_back, R.id.tv_resolve_find_sick_info})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_resolve_find_sick_info:

                break;
        }
    }
}
