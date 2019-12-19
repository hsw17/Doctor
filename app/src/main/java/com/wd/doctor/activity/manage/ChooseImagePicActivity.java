package com.wd.doctor.activity.manage;

import android.content.Intent;

import com.wd.doctor.R;
import com.wd.doctor.activity.manage.ManageActivity;
import com.wd.doctor.adapter.MyViewChooseImagePager;
import com.wd.doctor.bean.ChooseImagePicBean;
import com.wd.doctor.bean.FindSystemImagePicBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.SPUtils;
import com.wd.mvplibrary.utils.ToastUtils;

import java.util.List;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;

public class ChooseImagePicActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG ="ChooseImagePicActivity";
    @BindView(R.id.view_choose_image_pager)
    ViewPager viewChooseImagePager;
    private String doctorId;
    private String sessionId;
    private String imagePic;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected void initData() {
        super.initData();
        SPUtils user = new SPUtils(this, "user");
        doctorId = (String) user.getSharedPreference("doctorId", "");
        sessionId = (String) user.getSharedPreference("sessionId", "");
        presenter.doFindSystem();
        ToastUtils.init(this);

    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_choose_image_pic;
    }

    @Override
    public void onSuccess(Object obj) {
        ChooseImagePicBean chooseImagePicBean = (ChooseImagePicBean) obj;
        Logger.e(TAG,chooseImagePicBean.getMessage());
    }

    @Override
    public void onSuccessOne(Object one) {
        FindSystemImagePicBean findSystemImagePicBean = (FindSystemImagePicBean) one;
        Logger.e(TAG,findSystemImagePicBean.getMessage()+"findSystemImagePicBean");
        List<FindSystemImagePicBean.ResultBean> result = findSystemImagePicBean.getResult();
        MyViewChooseImagePager myViewChooseImagePager = new MyViewChooseImagePager(result,this);
        viewChooseImagePager.setAdapter(myViewChooseImagePager);
        myViewChooseImagePager.setOnImagePic(new MyViewChooseImagePager.onImagePic() {
            @Override
            public void setPic(int position) {
                imagePic = result.get(position).getImagePic();
                Logger.e(TAG, imagePic);
            }
        });
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

    @OnClick(R.id.tv_ok_choose_image_pic)
    public void onClick() {
        if (imagePic!=null) {
            presenter.doChooseImagePic(doctorId,sessionId,imagePic);
            Intent intent = new Intent(this, ManageActivity.class);
            startActivity(intent);
            finish();
        }else {
            ToastUtils.show("您并没有选择图片");
        }
    }

}
