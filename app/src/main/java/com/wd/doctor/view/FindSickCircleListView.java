package com.wd.doctor.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wd.doctor.R;

import androidx.annotation.Nullable;

/**
 * describe:FindSickCircleListView
 * date:2019/12/13
 * author:任(Lenovo)
 * function:
 */
public class FindSickCircleListView extends LinearLayout {

    private EditText et_find;
    private TextView tv_find;

    public FindSickCircleListView(Context context) {
        super(context);
        init(context);
    }

    public FindSickCircleListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
        initData(context,attrs);
    }

    public FindSickCircleListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        initData(context,attrs);
    }

    //调用自定义属性
    private void initData(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FindSickCircleListView);
        String hint = typedArray.getString(R.styleable.FindSickCircleListView_hint);
        if (!TextUtils.isEmpty(hint)) {
            et_find.setHint(hint);
        }
        int color = typedArray.getColor(R.styleable.FindSickCircleListView_text_color, Color.GRAY);
        et_find.setTextColor(color);
        float text_size = typedArray.getDimension(R.styleable.FindSickCircleListView_text_size, 12);
        et_find.setTextSize(text_size);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_find, this, true);
        et_find = view.findViewById(R.id.et_find);
        tv_find = view.findViewById(R.id.tv_find);
        String tag = et_find.getText().toString();
        tv_find.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onLiner.onLinear(tag);
            }
        });
    }

    private onLiner onLiner;

    public void setOnLiner(FindSickCircleListView.onLiner onLiner) {
        this.onLiner = onLiner;
    }

    public interface onLiner{
        void onLinear(String tag);
    }
}
