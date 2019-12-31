package com.wd.doctor.activity.manage;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.activity.manage.wallet.BindDoctorActivity;
import com.wd.doctor.activity.manage.wallet.DrawCashActivity;
import com.wd.doctor.adapter.MyRecViewIncomeRecordAdapter;
import com.wd.doctor.bean.FindDoctorIncomeRecordListBean;
import com.wd.doctor.bean.FindDoctorWalletBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.SPUtils;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class WalletActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "WalletActivity";
    @BindView(R2.id.tv_bindDoctor)
    TextView tvBindDoctor;
    @BindView(R2.id.tv_balance_wallet)
    TextView tvBalanceWallet;
    @BindView(R2.id.rec_wallet_view)
    RecyclerView recWalletView;
    private int whetherBindBankCard;
    private int whetherBindIdCard;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_wallet;
    }

    @Override
    protected void initData() {
        super.initData();
        SPUtils user = new SPUtils(this, "user");
        String doctorId = (String) user.getSharedPreference("doctorId", "");
        String sessionId = (String) user.getSharedPreference("sessionId", "");
        presenter.doFindDoctorWallet(doctorId,sessionId);
        presenter.doFindDoctorIncomeRecordList(doctorId,sessionId,"1","10");

    }

    @Override
    public void onSuccess(Object obj) {
        FindDoctorWalletBean findDoctorWalletBean = (FindDoctorWalletBean) obj;
        Logger.e(TAG,findDoctorWalletBean.getMessage()+"findDoctorWalletBean");
        FindDoctorWalletBean.ResultBean result = findDoctorWalletBean.getResult();
        tvBalanceWallet.setText(result.getBalance()+"");
        whetherBindBankCard = result.getWhetherBindBankCard();
        whetherBindIdCard = result.getWhetherBindIdCard();
        if (whetherBindBankCard==1&&whetherBindIdCard==1) {
            tvBindDoctor.setText("查看绑定");
        }else {
            tvBindDoctor.setText("去绑定");
        }
    }

    @Override
    public void onSuccessOne(Object one) {
        FindDoctorIncomeRecordListBean findDoctorIncomeRecordListBean = (FindDoctorIncomeRecordListBean) one;
        Logger.e(TAG,findDoctorIncomeRecordListBean.getMessage());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recWalletView.setLayoutManager(linearLayoutManager);
        List<FindDoctorIncomeRecordListBean.ResultBean> result = findDoctorIncomeRecordListBean.getResult();
        MyRecViewIncomeRecordAdapter myRecViewIncomeRecordAdapter = new MyRecViewIncomeRecordAdapter(result, this);
        recWalletView.setAdapter(myRecViewIncomeRecordAdapter);
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

    @OnClick({R.id.img_back, R.id.btn_wallet,R.id.tv_bindDoctor})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.btn_wallet:
                Intent intent = new Intent(this, DrawCashActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_bindDoctor:
                Intent intent1 = new Intent(this, BindDoctorActivity.class);
                intent1.putExtra("whetherBindIdCard",whetherBindIdCard);
                intent1.putExtra("whetherBindBankCard",whetherBindBankCard);
                startActivity(intent1);
                break;
        }
    }
}
