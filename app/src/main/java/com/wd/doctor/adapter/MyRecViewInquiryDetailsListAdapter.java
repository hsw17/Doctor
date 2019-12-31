package com.wd.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.bean.FindInquiryDetailsListBean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * describe:MyRecViewInquiryDetalsListAdapter
 * date:2019/12/27
 * author:任(Lenovo)
 * function:
 */
public class MyRecViewInquiryDetailsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FindInquiryDetailsListBean.ResultBean> list;
    private Context context;

    public MyRecViewInquiryDetailsListAdapter(List<FindInquiryDetailsListBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.adapter_inquiry_details_user, parent, false);
            return new MyUserViewHolder(view);
        }else if (viewType == 2){
            View view = LayoutInflater.from(context).inflate(R.layout.adapter_inquiry_details_doctor, parent, false);
            return new MyDoctorViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FindInquiryDetailsListBean.ResultBean resultBean = list.get(position);
        int itemViewType = getItemViewType(position);
        if (itemViewType == 1) {
            if (holder instanceof MyUserViewHolder) {
                ((MyUserViewHolder) holder).sView_sView_details_user.setImageURI(resultBean.getUserHeadPic());
                ((MyUserViewHolder) holder).tv_content_user.setText(resultBean.getContent());
                Date date = new Date(resultBean.getAskTime());
                String day = "";
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                    day = simpleDateFormat.format(date);
                }catch (Exception e){
                    e.printStackTrace();
                }
                ((MyUserViewHolder) holder).tv_time_details_user.setText(day);
            }
        }else if (itemViewType==2){
            if (holder instanceof MyDoctorViewHolder) {
                ((MyDoctorViewHolder) holder).sView_details_doctor.setImageURI(resultBean.getDoctorHeadPic());
                ((MyDoctorViewHolder) holder).tv_content_doctor.setText(resultBean.getContent());
                Date date = new Date(resultBean.getAskTime());
                String day = "";
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                    day = simpleDateFormat.format(date);
                }catch (Exception e){
                    e.printStackTrace();
                }
                ((MyDoctorViewHolder) holder).tv_time_details_doctor.setText(day);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        int direction = list.get(position).getDirection();
        if (direction == 2){
            return 1;
        }else if (direction == 1){
            return 2;
        }
        return super.getItemViewType ( position );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyUserViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sView_sView_details_user;
        TextView tv_content_user,tv_time_details_user;
        public MyUserViewHolder(@NonNull View itemView) {
            super(itemView);
            sView_sView_details_user = itemView.findViewById(R.id.sView_sView_details_user);
            tv_content_user = itemView.findViewById(R.id.tv_content_user);
            tv_time_details_user = itemView.findViewById(R.id.tv_time_details_user);
        }
    }
    public class MyDoctorViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sView_details_doctor;
        TextView tv_content_doctor,tv_time_details_doctor;
        public MyDoctorViewHolder(@NonNull View itemView) {
            super(itemView);
            sView_details_doctor = itemView.findViewById(R.id.sView_details_doctor);
            tv_content_doctor = itemView.findViewById(R.id.tv_content_doctor);
            tv_time_details_doctor = itemView.findViewById(R.id.tv_time_details_doctor);
        }
    }
}
