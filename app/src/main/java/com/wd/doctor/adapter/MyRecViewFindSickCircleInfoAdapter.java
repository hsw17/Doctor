package com.wd.doctor.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.bean.FindSickCircleInfoBean;

import java.sql.Date;
import java.text.SimpleDateFormat;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * describe:MyRecViewFindSickCircleInfoAdapter
 * date:2019/12/15
 * author:任(Lenovo)
 * function:
 */
public class MyRecViewFindSickCircleInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private FindSickCircleInfoBean.ResultBean list;
    private Context context;

    public MyRecViewFindSickCircleInfoAdapter(FindSickCircleInfoBean.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_find_sick_info, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            if (list.getPicture()!=null) {
                String picture = list.getPicture();
                String[] split = picture.split(",");
                for (int i = 0; i < split.length; i++) {
                    ((MyViewHolder) holder).sView_picture_find_sick_info.setImageURI(split[i]);
                }
            }
            ((MyViewHolder) holder).tv_authorName_find_sick_info.setText(list.getAuthorName());
            ((MyViewHolder) holder).tv_disease_find_sick_info.setText(list.getDisease());
            ((MyViewHolder) holder).tv_departmentName_find_sick_info.setText(list.getDepartmentName());
            ((MyViewHolder) holder).tv_detaile_find_sick_info.setText(list.getDetail());
            ((MyViewHolder) holder).tv_treatmentHospital_find_sick_info.setText(list.getTreatmentHospital());
            Date date = new Date(list.getTreatmentStartTime());
            String startDay = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                startDay = simpleDateFormat.format(date);
            }catch (Exception e){
                e.printStackTrace();
            }
            ((MyViewHolder) holder).tv_treatmentStartTime_find_sick_info.setText(startDay+"-");
            Date endDate = new Date(list.getTreatmentEndTime());
            String endDay = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd");
                endDay = simpleDateFormat.format(endDate);
            }catch (Exception e){
                e.printStackTrace();
            }
            ((MyViewHolder) holder).tv_treatmentEndTime_find_sick_info.setText(endDay);
            ((MyViewHolder) holder).tv_treatmentProcess_find_sick_info.setText(list.getTreatmentProcess());
        }
    }

    @Override
            public int getItemCount() {
                return 1;
            }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_authorName_find_sick_info,tv_disease_find_sick_info,tv_departmentName_find_sick_info,tv_detaile_find_sick_info,tv_treatmentHospital_find_sick_info,
                tv_treatmentStartTime_find_sick_info,tv_treatmentEndTime_find_sick_info,tv_treatmentProcess_find_sick_info;
        SimpleDraweeView sView_picture_find_sick_info;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_authorName_find_sick_info = itemView.findViewById(R.id.tv_authorName_find_sick_info);
            tv_disease_find_sick_info = itemView.findViewById(R.id.tv_disease_find_sick_info);
            tv_departmentName_find_sick_info = itemView.findViewById(R.id.tv_departmentName_find_sick_info);
            tv_detaile_find_sick_info = itemView.findViewById(R.id.tv_detaile_find_sick_info);
            tv_treatmentHospital_find_sick_info = itemView.findViewById(R.id.tv_treatmentHospital_find_sick_info);
            tv_treatmentStartTime_find_sick_info = itemView.findViewById(R.id.tv_treatmentStartTime_find_sick_info);
            tv_treatmentEndTime_find_sick_info = itemView.findViewById(R.id.tv_treatmentEndTime_find_sick_info);
            tv_treatmentProcess_find_sick_info = itemView.findViewById(R.id.tv_treatmentProcess_find_sick_info);
            sView_picture_find_sick_info = itemView.findViewById(R.id.sView_picture_find_sick_info);
        }
    }
}
