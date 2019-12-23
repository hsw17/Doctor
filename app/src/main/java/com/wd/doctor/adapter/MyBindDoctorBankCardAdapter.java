package com.wd.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.bean.FindDoctorBankCardByIdBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * describe:MyBindDoctorBankCard
 * date:2019/12/23
 * author:任(Lenovo)
 * function:
 */
public class MyBindDoctorBankCardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private FindDoctorBankCardByIdBean.ResultBean list;
    private Context context;

    public MyBindDoctorBankCardAdapter(FindDoctorBankCardByIdBean.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_bind_doctor_bank_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).tv_bankCardNumber_bank_card.setText(list.getBankCardNumber());
            ((MyViewHolder) holder).tv_bankName_bank_card.setText(list.getBankName());
            int bankCardType = list.getBankCardType();
            if (bankCardType==1) {
                ((MyViewHolder) holder).tv_bankCardType_bank_card.setText("借记卡");
            }else if (bankCardType==2){
                ((MyViewHolder) holder).tv_bankCardType_bank_card.setText("信用卡");
            }
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_bankName_bank_card,tv_bankCardType_bank_card,tv_bankCardNumber_bank_card;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_bankName_bank_card = itemView.findViewById(R.id.tv_bankName_bank_card);
            tv_bankCardType_bank_card = itemView.findViewById(R.id.tv_bankCardType_bank_card);
            tv_bankCardNumber_bank_card = itemView.findViewById(R.id.tv_bankCardNumber_bank_card);
        }
    }

}
