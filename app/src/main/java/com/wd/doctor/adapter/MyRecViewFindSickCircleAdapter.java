package com.wd.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wd.doctor.R;
import com.wd.doctor.bean.FindSickCircleListBean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * describe:MyRecViewFindSickCircleAdapter
 * date:2019/12/13
 * author:任(Lenovo)
 * function:
 */
public class MyRecViewFindSickCircleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FindSickCircleListBean.ResultBean> list;
    private Context context;

    public MyRecViewFindSickCircleAdapter(List<FindSickCircleListBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_find_sick_circle, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FindSickCircleListBean.ResultBean resultBean = list.get(position);
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).tv_detail_find_sick_circle.setText(resultBean.getDetail());
            ((MyViewHolder) holder).tv_title_find_sick_circle.setText(resultBean.getTitle());
            Date date = new Date(resultBean.getReleaseTime());
            String day = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                day = simpleDateFormat.format(date);
            }catch (Exception e){
                e.printStackTrace();
            }
            ((MyViewHolder) holder).tv_releaseTime_find_sick_circle.setText(day);
            if (resultBean.getAmount() != 0) {
                Glide.with(context).load(R.mipmap.h_currency).into(((MyViewHolder) holder).img_find_sick_circle);
                ((MyViewHolder) holder).tv_amount_find_sick_circle.setText(resultBean.getAmount()+"");
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.onId(resultBean.getSickCircleId()+"");
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_detail_find_sick_circle,tv_title_find_sick_circle,tv_releaseTime_find_sick_circle,tv_amount_find_sick_circle;
        ImageView img_find_sick_circle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_detail_find_sick_circle = itemView.findViewById(R.id.tv_detail_find_sick_circle);
            tv_title_find_sick_circle = itemView.findViewById(R.id.tv_title_find_sick_circle);
            tv_releaseTime_find_sick_circle = itemView.findViewById(R.id.tv_releaseTime_find_sick_circle);
            tv_amount_find_sick_circle = itemView.findViewById(R.id.tv_amount_find_sick_circle);
            img_find_sick_circle = itemView.findViewById(R.id.img_find_sick_circle);
        }
    }

    private onClick onClick;

    public void setOnClick(MyRecViewFindSickCircleAdapter.onClick onClick) {
        this.onClick = onClick;
    }

    public interface onClick{
        void onId(String sickCircleId);
    }
}
