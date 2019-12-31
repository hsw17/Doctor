package com.wd.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.bean.FindDoctorDrawRecordListBean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * describe:MyRecViewDrawRecordListAdaoter
 * date:2019/12/30
 * author:任(Lenovo)
 * function:
 */
public class MyRecViewDrawRecordListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FindDoctorDrawRecordListBean.ResultBean> list;
    private Context context;

    public MyRecViewDrawRecordListAdapter(List<FindDoctorDrawRecordListBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_draw_record_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FindDoctorDrawRecordListBean.ResultBean resultBean = list.get(position);
        if (holder instanceof MyViewHolder) {
            Date date = new Date(resultBean.getCreateTime());
            String month = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
                month = simpleDateFormat.format(date);
            }catch (Exception e){
                e.printStackTrace();
            }
            ((MyViewHolder) holder).tv_money_draw_record_list.setText(month);
            Date date1 = new Date(resultBean.getCreateTime());
            String year = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
                year = simpleDateFormat.format(date);
            }catch (Exception e){
                e.printStackTrace();
            }
            ((MyViewHolder) holder).tv_year_record.setText(year);
            ((MyViewHolder) holder).tv_money_draw_record_list.setText(resultBean.getMoney()+"元");
            ((MyViewHolder) holder).tv_remark.setText(resultBean.getRemark());
            ((MyViewHolder) holder).tv_bankName.setText(resultBean.getBankName());
            ((MyViewHolder) holder).tv_bankCardNumber.setText(resultBean.getBankCardNumber()+"");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_month_draw_record,tv_year_record,tv_money_draw_record_list,tv_remark,tv_bankName,tv_bankCardNumber;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_month_draw_record = itemView.findViewById(R.id.tv_month_draw_record);
            tv_year_record = itemView.findViewById(R.id.tv_year_record);
            tv_money_draw_record_list = itemView.findViewById(R.id.tv_money_draw_record_list);
            tv_remark = itemView.findViewById(R.id.tv_remark);
            tv_bankName = itemView.findViewById(R.id.tv_bankName);
            tv_bankCardNumber = itemView.findViewById(R.id.tv_bankCardNumber);
        }
    }
}
