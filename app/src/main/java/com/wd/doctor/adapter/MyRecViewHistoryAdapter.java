package com.wd.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wd.doctor.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * describe:MyRecViewHistoryAdapter
 * date:2019/12/14
 * author:任(Lenovo)
 * function:
 */
public class MyRecViewHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<String> list;
    private Context context;

    public MyRecViewHistoryAdapter(ArrayList<String> list, Context context) {
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
        if (holder instanceof MyViewHolder) {
            String[] split = list.toString().split(",");
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
            }
            ((MyViewHolder) holder).tv_history.setText(list.toString());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_history;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_history = itemView.findViewById(R.id.tv_history);
        }
    }
}
