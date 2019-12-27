package com.wd.doctor.activity.manage.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.adapter.MyBindDoctorBankCardAdapter;
import com.wd.doctor.bean.FindDoctorBankCardByIdBean;
import com.wd.doctor.bean.FindDoctorIdCardInfoBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.doctor.util.RsaCoder;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.SPUtils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BindDoctorActivity extends BaseActivity<Presenter> implements Contract.IView {

    @BindView(R2.id.img_id_card)
    ImageView imgIdCard;
    @BindView(R2.id.rec_id_card_view)
    LinearLayout recIdCardView;
    @BindView(R2.id.img_bank_card)
    ImageView imgBankCard;
    @BindView(R2.id.tv_bank_card)
    TextView tvBankCard;
    @BindView(R2.id.tv_id_card)
    TextView tvIdCard;
    @BindView(R2.id.rec_bank_card_view)
    RecyclerView recBankCardView;
    @BindView(R.id.tv_name_id_card)
    TextView tvNameIdCard;
    @BindView(R.id.tv_sex_id_card)
    TextView tvSexIdCard;
    @BindView(R.id.tv_nation_id_card)
    TextView tvNationIdCard;
    @BindView(R.id.tv_idNumber_id_card)
    TextView tvIdNumberIdCard;
    private int whetherBindBankCard;
    private int whetherBindIdCard;
    public static final String TAG = "BindDoctorActivity";
    private String name;
    private String sex;
    private String nation;
    private String idNumber;

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
        Logger.e("aaa", whetherBindIdCard + "");
        Logger.e("bbb", whetherBindBankCard + "");
        if (whetherBindIdCard == 2) {
            imgIdCard.setImageResource(R.mipmap.id_card_front);
        } else if (whetherBindIdCard == 1) {
            tvIdCard.setVisibility(View.GONE);
            presenter.doFindDoctorIdCardInfo(doctorId, sessionId);
            imgIdCard.setImageResource(R.mipmap.id_card);
            recIdCardView.setVisibility(View.VISIBLE);
        }
        if (whetherBindBankCard == 2) {
            imgBankCard.setImageResource(R.mipmap.bank_card_front);
        } else if (whetherBindBankCard == 1) {
            tvBankCard.setVisibility(View.GONE);
            presenter.doFindDoctorBankCardById(doctorId, sessionId);
            imgBankCard.setImageResource(R.mipmap.bank_card);
            recBankCardView.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onSuccessOne(Object one) {
        FindDoctorBankCardByIdBean findDoctorBankCardByIdBean = (FindDoctorBankCardByIdBean) one;
        Logger.e(TAG, findDoctorBankCardByIdBean.getMessage() + "findDoctorBankCardByIdBean");
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
        FindDoctorIdCardInfoBean findDoctorIdCardInfoBean = (FindDoctorIdCardInfoBean) two;
        Logger.e(TAG, findDoctorIdCardInfoBean.getMessage() + "findDoctorIdCardInfoBean");
        /*LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recIdCardView.setLayoutManager(linearLayoutManager);
        FindDoctorIdCardInfoBean.ResultBean result = findDoctorIdCardInfoBean.getResult();
        MyBindDoctorIdCardAdapter myBindDoctorIdCardAdapter = new MyBindDoctorIdCardAdapter(result, this);
        recIdCardView.setAdapter(myBindDoctorIdCardAdapter);*/
        FindDoctorIdCardInfoBean.ResultBean result = findDoctorIdCardInfoBean.getResult();
        try {
            name = RsaCoder.decryptByPublicKey(result.getName());
            sex = RsaCoder.decryptByPublicKey(result.getSex());
            nation = RsaCoder.decryptByPublicKey(result.getNation());
            idNumber = RsaCoder.decryptByPublicKey(result.getIdNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
        tvNameIdCard.setText(name);
        tvSexIdCard.setText(sex);
        tvNationIdCard.setText(nation+"族");
        tvIdNumberIdCard.setText(idNumber);
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
                Intent intent1 = new Intent(this, BankCradActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
