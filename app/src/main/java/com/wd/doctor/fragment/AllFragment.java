package com.wd.doctor.fragment;

import android.content.Intent;
import android.os.Bundle;

import com.wd.doctor.R;
import com.wd.doctor.activity.answer.FindSickCircleInfoActivity;
import com.wd.doctor.adapter.MyRecViewFindSickCircleAdapter;
import com.wd.doctor.bean.FindSickCircleListBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseFragment;
import com.wd.mvplibrary.utils.Logger;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * describe:AllFragment
 * date:2019/12/13
 * author:任(Lenovo)
 * function:
 */
public class AllFragment extends BaseFragment<Presenter> implements Contract.IView {

    private String page = "1";
    private String count = "10";
    public static final String TAG = "AllFragment";
    @BindView(R.id.rec_all_view)
    RecyclerView recAllView;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_all;
    }

    @Override
    protected void initData() {
        super.initData();
        Bundle arguments = getArguments();
        String departmentId = arguments.getString("departmentId");
        presenter.doFindSickCircle(departmentId,page,count);
    }

    @Override
    public void onSuccess(Object obj) {
        FindSickCircleListBean findSickCircleListBean = (FindSickCircleListBean) obj;
        Logger.e(TAG,findSickCircleListBean.getMessage()+"findSickCircleListBean");
        List<FindSickCircleListBean.ResultBean> result = findSickCircleListBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recAllView.setLayoutManager(linearLayoutManager);
        MyRecViewFindSickCircleAdapter myRecViewFindSickCircleAdapter = new MyRecViewFindSickCircleAdapter(result, getContext());
        recAllView.setAdapter(myRecViewFindSickCircleAdapter);
        myRecViewFindSickCircleAdapter.setOnClick(new MyRecViewFindSickCircleAdapter.onClick() {
            @Override
            public void onId(String sickCircleId) {
                Intent intent = new Intent(getContext(), FindSickCircleInfoActivity.class);
                intent.putExtra("sickCircleId",sickCircleId);
                startActivity(intent);
            }
        });
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
}
