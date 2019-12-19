package com.wd.doctor.activity.answer;


import android.content.Intent;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.wd.doctor.R;
import com.wd.doctor.adapter.MyAdapter;
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.Logger;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;

public class AnswerActivity extends BaseActivity<Presenter> implements Contract.IView {

    private ArrayList<String> tab = new ArrayList<>();
    public static final String TAG = "AnswerActivity";
    @BindView(R.id.tab_layout_answer)
    TabLayout tabLayoutAnswer;
    @BindView(R.id.view_pager_answer)
    ViewPager viewPagerAnswer;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_answer;
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.doFindDepartment();
    }

    @Override
    public void onSuccess(Object obj) {

    }

    @Override
    public void onSuccessOne(Object one) {
        FindDepartmentBean findDepartmentBean = (FindDepartmentBean) one;
        Logger.e(TAG, findDepartmentBean.getMessage() + "findDepartmentBean");
        List<FindDepartmentBean.ResultBean> result = findDepartmentBean.getResult();
        for (int i = 0; i < result.size(); i++) {
            FindDepartmentBean.ResultBean resultBean = result.get(i);
            tab.add(resultBean.getDepartmentName());
        }
        tabLayoutAnswer.setupWithViewPager(viewPagerAnswer);
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(), tab, result);
        viewPagerAnswer.setAdapter(myAdapter);
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

    @OnClick({R.id.img_back, R.id.img_find_answer})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_find_answer:
                Intent intent = new Intent(this, FindActivity.class);
                startActivity(intent);
                break;
        }
    }
}
