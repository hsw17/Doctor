package com.wd.doctor.activity.manage.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.adapter.MyBindDoctorBankCardAdapter;
import com.wd.doctor.bean.FindDoctorBankCardByIdBean;
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

public class BindDoctorActivity extends BaseActivity<Presenter> implements Contract.IView {

    @BindView(R.id.img_id_card)
    ImageView imgIdCard;
    @BindView(R.id.rec_id_card_view)
    RecyclerView recIdCardView;
    @BindView(R.id.img_bank_card)
    ImageView imgBankCard;
    @BindView(R.id.tv_bank_card)
    TextView tvBankCard;
    @BindView(R.id.tv_id_card)
    TextView tvIdCard;
    @BindView(R.id.rec_bank_card_view)
    RecyclerView recBankCardView;
    private int whetherBindBankCard;
    private int whetherBindIdCard;
    public static final String TAG = "BindDoctorActivity";

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_bind_doctor;
    }

    @Override
    protected void initData() {
        super.initData();
        SPUtils user = new SPUtils(this, "user");
        String doctorId = (String) user.getSharedPreference("doctorId", "");
        String sessionId = (String) user.getSharedPreference("sessionId", "");
        Intent intent = getIntent();
        whetherBindIdCard = intent.getIntExtra("whetherBindIdCard", 0);
        whetherBindBankCard = intent.getIntExtra("whetherBindBankCard", 0);
        Logger.e("aaa",whetherBindIdCard+"");
        Logger.e("bbb",whetherBindBankCard+"");
        if (whetherBindIdCard==2){
            imgIdCard.setImageResource(R.mipmap.id_card_front);
        }else if (whetherBindIdCard==1){
            tvIdCard.setVisibility(View.GONE);
        }
        if (whetherBindBankCard==2) {
            imgBankCard.setImageResource(R.mipmap.bank_card_front);
        }else if (whetherBindBankCard==1){
            tvBankCard.setVisibility(View.GONE);
            presenter.doFindDoctorBankCardById(doctorId,sessionId);
            imgBankCard.setImageResource(R.mipmap.bank_card);
            recBankCardView.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onSuccessOne(Object one) {
        FindDoctorBankCardByIdBean findDoctorBankCardByIdBean = (FindDoctorBankCardByIdBean) one;
        Logger.e(TAG,findDoctorBankCardByIdBean.getMessage()+"findDoctorBankCardByIdBean");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recBankCardView.setLayoutManager(linearLayoutManager);
        FindDoctorBankCardByIdBean.ResultBean result = findDoctorBankCardByIdBean.getResult();
        MyBindDoctorBankCardAdapter myBindDoctorBankCardAdapter = new MyBindDoctorBankCardAdapter(result, this);
        recBankCardView.setAdapter(myBindDoctorBankCardAdapter);
    }
    @Override
    public void onSuccess(Object obj) {

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

    @OnClick({R.id.img_back, R.id.tv_id_card, R.id.tv_bank_card})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_id_card:
                Intent intent = new Intent(this, IdCardActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_bank_card:
                break;
        }
    }
}
