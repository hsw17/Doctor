package com.wd.doctor.activity.manage;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class WalletActivity extends BaseActivity<Presenter> implements Contract.IView {

    @BindView(R.id.tv_bindDoctor)
    TextView tvBindDoctor;
    @BindView(R.id.tv_balance_wallet)
    TextView tvBalanceWallet;
    @BindView(R.id.rec_wallet_view)
    RecyclerView recWalletView;

    @Override
    protected Presenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_wallet;
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

    @OnClick({R.id.img_back, R.id.btn_wallet,R.id.tv_bindDoctor})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.btn_wallet:

                break;
            case R.id.tv_bindDoctor:
                Intent intent1 = new Intent(this, BindDoctorActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
