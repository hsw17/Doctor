package com.wd.doctor.fragment.choose;

import android.content.Intent;
import android.widget.LinearLayout;

import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.activity.manage.ManageActivity;
import com.wd.doctor.adapter.MyViewChooseImagePager;
import com.wd.doctor.bean.ChooseImagePicBean;
import com.wd.doctor.bean.FindSystemImagePicBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseFragment;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.SPUtils;
import com.wd.mvplibrary.utils.ToastUtils;

import java.util.List;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * describe:SystemFragment
 * date:2019/12/22
 * author:任(Lenovo)
 * function:
 */
public class SystemFragment extends BaseFragment<Presenter> implements Contract.IView {
    @BindView(R2.id.view_choose_image_pager)
    ViewPager viewChooseImagePager;
    @BindView(R2.id.tv_ok_choose_image_pic)
    LinearLayout tvOkChooseImagePic;
    public static final String TAG = "SystemFragment";
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
        SPUtils user = new SPUtils(getContext(), "user");
        doctorId = (String) user.getSharedPreference("doctorId", "");
        sessionId = (String) user.getSharedPreference("sessionId", "");
        presenter.doFindSystem();
        ToastUtils.init(getContext());
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_system;
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
        MyViewChooseImagePager myViewChooseImagePager = new MyViewChooseImagePager(result,getContext());
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
            Intent intent = new Intent(getContext(), ManageActivity.class);
            startActivity(intent);
            getActivity().finish();
        }else {
            ToastUtils.show("您并没有选择图片");
        }
    }
}
