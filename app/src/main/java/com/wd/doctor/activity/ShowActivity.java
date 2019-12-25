package com.wd.doctor.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wd.doctor.R;
import com.wd.doctor.activity.answer.AnswerActivity;
import com.wd.doctor.activity.inquiry.InquiryActivity;
import com.wd.doctor.activity.manage.ManageActivity;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ShowActivity extends BaseActivity<Presenter> {


    @BindView(R.id.tv_name_show)
    TextView tvNameShow;
    @BindView(R.id.tv_inauguralHospital_show)
    TextView tvInauguralHospitalShow;
    @BindView(R.id.tv_jobTitle_show)
    TextView tvJobTitleShow;
    @BindView(R.id.tv_departmentName_show)
    TextView tvDepartmentNameShow;
    @BindView(R.id.tv_inquiry_show)
    RelativeLayout tvInquiryShow;
    @BindView(R.id.tv_answer_show)
    RelativeLayout tvAnswerShow;

    @BindView(R.id.tv_manage_show)
    RelativeLayout tvManageShow;
    @BindView(R.id.sView_show)
    ImageView sViewShow;

    @Override
    protected Presenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_show;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String imagePic = intent.getStringExtra("imagePic");
        String departmentName = intent.getStringExtra("departmentName");
        String inauguralHospital = intent.getStringExtra("inauguralHospital");
        String jobTitle = intent.getStringExtra("jobTitle");

        Glide.with(this).load(imagePic).into(sViewShow);
        tvDepartmentNameShow.setText(departmentName);
        tvInauguralHospitalShow.setText(inauguralHospital);
        tvNameShow.setText(name);
        tvJobTitleShow.setText(jobTitle);
    }

    @OnClick({R.id.tv_inquiry_show, R.id.tv_answer_show, R.id.tv_manage_show})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_inquiry_show:
                Intent intent = new Intent(this, InquiryActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_answer_show:
                Intent intent1 = new Intent(this, AnswerActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_manage_show:
                Intent intent2 = new Intent(this, ManageActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
