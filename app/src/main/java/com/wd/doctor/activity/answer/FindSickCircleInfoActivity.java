package com.wd.doctor.activity.answer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.adapter.MyRecViewFindSickCircleInfoAdapter;
import com.wd.doctor.bean.FindSickCircleInfoBean;
import com.wd.doctor.bean.PublishCommentBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.SPUtils;
import com.wd.mvplibrary.utils.ToastUtils;

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
    @BindView(R.id.et_find_sick_info)
    EditText etFindSickInfo;
    @BindView(R.id.linear1)
    LinearLayout Linear1;
    @BindView(R.id.linear2)
    LinearLayout Linear2;
    @BindView(R.id.tv_content_find_sick_circle_info)
    TextView tvContentFindSickCircleInfo;
    @BindView(R.id.linear_find_sick_circle_info)
    LinearLayout linearFindSickCircleInfo;
    private String doctorId;
    private String sessionId;
    private String sickCircleId;

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
        doctorId = (String) user.getSharedPreference("doctorId", "");
        sessionId = (String) user.getSharedPreference("sessionId", "");
        Intent intent = getIntent();
        sickCircleId = intent.getStringExtra("sickCircleId");
        presenter.doFindSickInfo(doctorId, sessionId, sickCircleId);
        ToastUtils.init(this);
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
        int whetherContent = result.getWhetherContent();
        if (whetherContent==1) {
            Linear2.setVisibility(View.VISIBLE);
            tvContentFindSickCircleInfo.setText(result.getContent());
            linearFindSickCircleInfo.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSuccessOne(Object one) {
        PublishCommentBean publishCommentBean = (PublishCommentBean) one;
        Logger.e(TAG,publishCommentBean.getMessage()+"publishCommentBean");
        if (publishCommentBean.getStatus().equals("0000")) {
            ToastUtils.show(publishCommentBean.getMessage());
        }else {
            ToastUtils.show(publishCommentBean.getMessage());
        }
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

    @OnClick({R.id.img_back, R.id.tv_resolve_find_sick_info,R.id.relative_find_sick_circle_info,R.id.tv_expression,R.id.tv_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_resolve_find_sick_info:
                Linear1.setVisibility(View.VISIBLE);
                break;
            case R.id.relative_find_sick_circle_info:
                Linear1.setVisibility(View.GONE);
                break;
            case R.id.tv_expression:

                break;
            case R.id.tv_send:
                String content = etFindSickInfo.getText().toString();
                presenter.doPublishComment(doctorId,sessionId,sickCircleId,content);
                Linear1.setVisibility(View.GONE);
                Linear2.setVisibility(View.VISIBLE);
                tvContentFindSickCircleInfo.setText(content);
                linearFindSickCircleInfo.setVisibility(View.GONE);
                break;
        }
    }
}
