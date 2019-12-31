package com.wd.doctor.activity.manage.wallet;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.wd.doctor.R;
import com.wd.doctor.adapter.MyRecViewDrawRecordListAdapter;
import com.wd.doctor.bean.FindDoctorDrawRecordListBean;
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

public class DrawRecordListActivity extends BaseActivity<Presenter> implements Contract.IView {
    @BindView(R.id.rec_view_draw_record)
    RecyclerView recViewDrawRecord;
    public static final String TAG = "DrawRecordListActivity";

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_draw_record_list;
    }

    @Override
    protected void initData() {
        super.initData();
        SPUtils user = new SPUtils(this, "user");
        String doctorId = (String) user.getSharedPreference("doctorId", "");
        String sessionId = (String) user.getSharedPreference("sessionId", "");
        presenter.doFindDoctorDrawRecordList(doctorId,sessionId,"1","10");
    }

    @Override
    public void onSuccess(Object obj) {
        FindDoctorDrawRecordListBean findDoctorDrawRecordListBean = (FindDoctorDrawRecordListBean) obj;
        Logger.e(TAG,findDoctorDrawRecordListBean.getMessage());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recViewDrawRecord.setLayoutManager(linearLayoutManager);
        List<FindDoctorDrawRecordListBean.ResultBean> result = findDoctorDrawRecordListBean.getResult();
        MyRecViewDrawRecordListAdapter myRecViewDrawRecordListAdapter = new MyRecViewDrawRecordListAdapter(result, this);
        recViewDrawRecord.setAdapter(myRecViewDrawRecordListAdapter);
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
