package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.adapter.MyRecViewHistoryAdapter;
import com.wd.doctor.adapter.MyRecViewSearchSickCircleAdapter;
import com.wd.doctor.bean.SearchSickCircleBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FindActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "FindActivity";
    @BindView(R.id.et_find)
    EditText etFind;
    @BindView(R.id.img_none_find)
    ImageView imgNoneFind;
    /*@BindView(R.id.rec_history_find)
    RecyclerView recHistoryFind;*/
    @BindView(R.id.tv_history_one)
    TextView tvHistoryOne;
    @BindView(R.id.linear1)
    LinearLayout linear1;
    @BindView(R.id.rec_searchSickCircle_view)
    RecyclerView recSearchSickCircleView;
    @BindView(R.id.linear2)
    LinearLayout linear2;
    private String keyWord;
    private ArrayList<String> list = new ArrayList<>();
    private MyRecViewSearchSickCircleAdapter myRecViewSearchSickCircleAdapter;
    private List<SearchSickCircleBean.ResultBean> result;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_find;
    }

    @Override
    protected void initData() {
        super.initData();
        ToastUtils.init(this);
    }

    @Override
    public void onSuccess(Object obj) {
        SearchSickCircleBean searchSickCircleBean = (SearchSickCircleBean) obj;
        Logger.e(TAG, searchSickCircleBean.getMessage()+"searchSickCircleBean");
        result = searchSickCircleBean.getResult();
        if (result.size()==0) {
            imgNoneFind.setImageResource(R.mipmap.no_search_message);
        }else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recSearchSickCircleView.setLayoutManager(linearLayoutManager);
            myRecViewSearchSickCircleAdapter = new MyRecViewSearchSickCircleAdapter(result,this);
            recSearchSickCircleView.setAdapter(myRecViewSearchSickCircleAdapter);
            imgNoneFind.setVisibility(View.GONE);
            myRecViewSearchSickCircleAdapter.notifyDataSetChanged();
            myRecViewSearchSickCircleAdapter.setOnClick(new MyRecViewSearchSickCircleAdapter.onClick() {
                @Override
                public void onId(String sickCircleId) {
                    Intent intent = new Intent(FindActivity.this, FindSickCircleInfoActivity.class);
                    intent.putExtra("sickCircleId",sickCircleId);
                    startActivity(intent);
                }
            });
        }
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

    @OnClick({R.id.img_back, R.id.tv_find,R.id.tv_history_one})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_find:
                    keyWord = etFind.getText().toString();
                if (!TextUtils.isEmpty(keyWord)) {
                    presenter.doSearchSickCircle(keyWord);
                    ToastUtils.show("正在搜索"+keyWord+"有关的病情");
                    list.add(keyWord);
                    linear1.setVisibility(View.GONE);
                    linear2.setVisibility(View.VISIBLE);
                }else {
                    ToastUtils.show("不能输入空");
                }
                break;
            case R.id.tv_history_one:
                String history_one = tvHistoryOne.toString();
                presenter.doSearchSickCircle(history_one);
                linear1.setVisibility(View.GONE);
                linear2.setVisibility(View.VISIBLE);
                break;
        }
    }
}
