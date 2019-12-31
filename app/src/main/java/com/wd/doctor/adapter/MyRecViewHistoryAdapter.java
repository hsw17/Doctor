package com.wd.doctor.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.activity.manage.history.FindUserInfoActivity;
import com.wd.doctor.activity.manage.history.HistoryActivity;
import com.wd.doctor.activity.manage.history.InquiryDetailsActivity;
import com.wd.doctor.bean.FindHistoryInquiryRecordBean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * describe:MyRecViewHistoryAdapter
 * date:2019/12/14
 * author:任(Lenovo)
 * function:
 */
public class MyRecViewHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FindHistoryInquiryRecordBean.ResultBean> list;
    private Context context;

    public MyRecViewHistoryAdapter(List<FindHistoryInquiryRecordBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_history, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FindHistoryInquiryRecordBean.ResultBean resultBean = list.get(position);
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).sView_history_adapter.setImageURI(resultBean.getUserHeadPic());
            ((MyViewHolder) holder).tv_name_history_adapter.setText(resultBean.getNickName());
            Date date = new Date(resultBean.getInquiryTime());
            String day = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                day = simpleDateFormat.format(date);
            }catch (Exception e){
                e.printStackTrace();
            }
            ((MyViewHolder) holder).tv_time_history_adapter.setText(day);
            int status = resultBean.getStatus();
            if (status==1) {
                ((MyViewHolder) holder).btn_Evaluate_history_adapter.setVisibility(View.VISIBLE);
            }else if (status==2){
                ((MyViewHolder) holder).tv_Evaluate_history_adapter.setVisibility(View.VISIBLE);
            }
            ((MyViewHolder) holder).btn_InquiryDetails_history_adapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, InquiryDetailsActivity.class);
                    intent.putExtra("inquiryId",list.get(position).getRecordId()+"");
                    intent.putExtra("nickName",list.get(position).getNickName());
                    context.startActivity(intent);
                }
            });
            ((MyViewHolder) holder).sView_history_adapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FindUserInfoActivity.class);
                    intent.putExtra("userId",resultBean.getUserId()+"");
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sView_history_adapter;
        TextView tv_name_history_adapter,tv_time_history_adapter,tv_Evaluate_history_adapter;
        Button btn_InquiryDetails_history_adapter,btn_Evaluate_history_adapter;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sView_history_adapter = itemView.findViewById(R.id.sView_history_adapter);
            tv_name_history_adapter = itemView.findViewById(R.id.tv_name_history_adapter);
            tv_time_history_adapter = itemView.findViewById(R.id.tv_time_history_adapter);
            btn_InquiryDetails_history_adapter = itemView.findViewById(R.id.btn_InquiryDetails_history_adapter);
            btn_Evaluate_history_adapter = itemView.findViewById(R.id.btn_Evaluate_history_adapter);
            tv_Evaluate_history_adapter = itemView.findViewById(R.id.tv_Evaluate_history_adapter);
        }
    }
}
