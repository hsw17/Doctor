package com.wd.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.bean.FindDoctorIncomeRecordListBean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * describe:MyRecViewIncomeRecord
 * date:2019/12/26
 * author:任(Lenovo)
 * function:
 */
public class MyRecViewIncomeRecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FindDoctorIncomeRecordListBean.ResultBean> list;
    private Context context;

    public MyRecViewIncomeRecordAdapter(List<FindDoctorIncomeRecordListBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_income_record, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FindDoctorIncomeRecordListBean.ResultBean resultBean = list.get(position);
        if (holder instanceof MyViewHolder) {
            int incomeType = resultBean.getIncomeType();
            if (incomeType==1) {
                ((MyViewHolder) holder).tv_incomeType_record.setText("问诊资询");
            }else if (incomeType==2){
                ((MyViewHolder) holder).tv_incomeType_record.setText("病友圈建议被采纳");
            }else if (incomeType==3){
                ((MyViewHolder) holder).tv_incomeType_record.setText("收到的礼物");
            }else if (incomeType==4){
                ((MyViewHolder) holder).tv_incomeType_record.setText("提现");
            }
            Date date = new Date(resultBean.getRecordTime());
            String day = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                day = simpleDateFormat.format(date);
            }catch (Exception e){
                e.printStackTrace();
            }
            ((MyViewHolder) holder).tv_recordTime_record.setText(day);
            int direction = resultBean.getDirection();
            if (direction==1) {
                ((MyViewHolder) holder).tv_direction_record.setText("+");
            }else if (direction==2){
                ((MyViewHolder) holder).tv_direction_record.setText("-");
            }
            ((MyViewHolder) holder).tv_money_record.setText(resultBean.getMoney()+"");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_incomeType_record,tv_recordTime_record,tv_direction_record,tv_money_record;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_incomeType_record = itemView.findViewById(R.id.tv_incomeType_record);
            tv_recordTime_record = itemView.findViewById(R.id.tv_recordTime_record);
            tv_direction_record = itemView.findViewById(R.id.tv_direction_record);
            tv_money_record = itemView.findViewById(R.id.tv_money_record);
        }
    }
}
