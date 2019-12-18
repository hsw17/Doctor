package com.wd.doctor.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wd.doctor.bean.FindSystemImagePicBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

/**
 * describe:MyViewChooseImagePager
 * date:2019/12/18
 * author:任(Lenovo)
 * function:
 */
public class MyViewChooseImagePager extends PagerAdapter {

    private List<FindSystemImagePicBean.ResultBean> list;
    private Context context;

    public MyViewChooseImagePager(List<FindSystemImagePicBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(container.getContext());
        Glide.with(context).load(list.get(position).getImagePic()).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImagePic.setPic(position);
            }
        });
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    private onImagePic onImagePic;

    public void setOnImagePic(onImagePic onImagePic) {
        this.onImagePic = onImagePic;
    }

    public interface onImagePic{
        //void setPic(String ImagePic);
        void setPic(int position);
    }

}
