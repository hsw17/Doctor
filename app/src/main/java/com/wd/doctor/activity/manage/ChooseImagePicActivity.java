package com.wd.doctor.activity.manage;

import android.widget.RadioGroup;

import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.adapter.MyFragmentChooseAdapter;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.fragment.choose.CustomizeFragment;
import com.wd.doctor.fragment.choose.SystemFragment;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

public class ChooseImagePicActivity extends BaseActivity<Presenter> {

    public static final String TAG = "ChooseImagePicActivity";
    @BindView(R2.id.view_pager)
    ViewPager viewPager;
    @BindView(R2.id.radio_group)
    RadioGroup radioGroup;
    private ArrayList<Fragment> list = new ArrayList<>();

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected void initData() {
        super.initData();
        list.add(new SystemFragment());
        list.add(new CustomizeFragment());
        MyFragmentChooseAdapter myFragmentChooseAdapter = new MyFragmentChooseAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(myFragmentChooseAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioGroup.check(radioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setOffscreenPageLimit(2);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_choose_image_pic;
    }
}
