package com.wd.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.bean.FindInquiryRecordListBean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * describe:MyRecViewInquiryAdapter
 * date:2019/12/25
 * author:任(Lenovo)
 * function:
 */
public class MyRecViewInquiryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FindInquiryRecordListBean.ResultBean> list;
    private Context context;

    public MyRecViewInquiryAdapter(List<FindInquiryRecordListBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_inquiry, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FindInquiryRecordListBean.ResultBean resultBean = list.get(position);
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).sView_inquiry.setImageURI(resultBean.getUserHeadPic());
            ((MyViewHolder) holder).tv_name_inquiry.setText(resultBean.getNickName());
            ((MyViewHolder) holder).tv_content_inquiry.setText(resultBean.getLastContent());
            Date date = new Date(resultBean.getInquiryTime());
            String InquiryTime = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
                InquiryTime = simpleDateFormat.format(date);
            }catch (Exception e){
                e.printStackTrace();
            }
            ((MyViewHolder) holder).tv_inquiryTime_inquiry.setText(InquiryTime);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click.onRecordId(resultBean.getRecordId(),resultBean.getUserId(),resultBean.getNickName());
                }
            });

        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sView_inquiry;
        TextView tv_name_inquiry,tv_content_inquiry,tv_inquiryTime_inquiry;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sView_inquiry = itemView.findViewById(R.id.sView_inquiry);
            tv_name_inquiry = itemView.findViewById(R.id.tv_name_inquiry);
            tv_content_inquiry = itemView.findViewById(R.id.tv_content_inquiry);
            tv_inquiryTime_inquiry = itemView.findViewById(R.id.tv_inquiryTime_inquiry);
        }
    }

    private click click;

    public void setClick(MyRecViewInquiryAdapter.click click) {
        this.click = click;
    }

    public interface click{
        void onRecordId(int RecordId,int userId,String name);
    }
}
