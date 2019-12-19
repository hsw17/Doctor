package com.wd.doctor.activity.manage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BindDoctorActivity extends BaseActivity<Presenter> implements Contract.IView {

    @BindView(R.id.img_id_card)
    ImageView imgIdCard;
    @BindView(R.id.rec_id_card_view)
    RecyclerView recIdCardView;
    @BindView(R.id.img_bank_card)
    ImageView imgBankCard;
    @BindView(R.id.tv_bank_card)
    TextView tvBankCard;
    @BindView(R.id.rec_bank_card_view)
    RecyclerView recBankCardView;

    @Override
    protected Presenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_bind_doctor;
    }

    @Override
    public void onSuccess(Object obj) {

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

    @OnClick({R.id.img_back, R.id.relative_id_card, R.id.relative_bank_card})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                break;
            case R.id.relative_id_card:
                break;
            case R.id.relative_bank_card:
                break;
        }
    }
}
