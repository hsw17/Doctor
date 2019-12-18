package com.wd.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.bean.FindSystemImagePicBean;
import com.wd.mvplibrary.utils.Logger;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * describe:MyRecViewChooseImagePicAdapter
 * date:2019/12/16
 * author:任(Lenovo)
 * function:
 */
public class MyRecViewChooseImagePicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FindSystemImagePicBean.ResultBean> list;
    private Context context;

    public MyRecViewChooseImagePicAdapter(List<FindSystemImagePicBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_choose_image_pic, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).sView_choose_image_adapter.setImageURI(list.get(position).getImagePic());
            Logger.e("aaa",position+"");
            Logger.e("aaa",list.size()+"");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onImagePic.setPic(position);
                }
                /*@Override
                public void onClick(View v) {
                    onImagePic.setPic(list.get(position).getImagePic());
                }*/
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sView_choose_image_adapter;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sView_choose_image_adapter = itemView.findViewById(R.id.sView_choose_image_adapter);
        }
    }

    private onImagePic onImagePic;

    public void setOnImagePic(MyRecViewChooseImagePicAdapter.onImagePic onImagePic) {
        this.onImagePic = onImagePic;
    }

    public interface onImagePic{
        //void setPic(String ImagePic);
        void setPic(int position);
    }
}
