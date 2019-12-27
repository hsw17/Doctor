package com.wd.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.bean.FindDoctorBankCardByIdBean;
import com.wd.doctor.bean.FindDoctorIdCardInfoBean;
import com.wd.doctor.util.RsaCoder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * describe:MyBindDoctorBankCard
 * date:2019/12/23
 * author:任(Lenovo)
 * function:
 */
public class MyBindDoctorIdCardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private FindDoctorIdCardInfoBean.ResultBean list;
    private Context context;
    private String name;
    private String sex;
    private String nation;
    private String idNumber;

    public MyBindDoctorIdCardAdapter(FindDoctorIdCardInfoBean.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_bind_doctor_id_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            try {
                name = RsaCoder.decryptByPublicKey(list.getName());
                sex = RsaCoder.decryptByPublicKey(list.getSex());
                nation = RsaCoder.decryptByPublicKey(list.getNation());
                idNumber = RsaCoder.decryptByPublicKey(list.getIdNumber());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ((MyViewHolder) holder).tv_name_id_card.setText(name);
            ((MyViewHolder) holder).tv_sex_id_card.setText(sex);
            ((MyViewHolder) holder).tv_nation_id_card.setText(nation);
            ((MyViewHolder) holder).tv_idNumber_id_card.setText(idNumber);
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name_id_card,tv_sex_id_card,tv_nation_id_card,tv_idNumber_id_card;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name_id_card = itemView.findViewById(R.id.tv_name_id_card);
            tv_sex_id_card = itemView.findViewById(R.id.tv_sex_id_card);
            tv_nation_id_card = itemView.findViewById(R.id.tv_nation_id_card);
            tv_idNumber_id_card = itemView.findViewById(R.id.tv_idNumber_id_card);
        }
    }

}
