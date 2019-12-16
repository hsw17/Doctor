package com.wd.doctor.adapter;

import android.os.Bundle;

import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.fragment.AllFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * describe:MyAdapter
 * date:2019/12/13
 * author:任(Lenovo)
 * function:
 */
public class MyAdapter extends FragmentPagerAdapter {

    private ArrayList<String> tab;
    private List<FindDepartmentBean.ResultBean> list;

    public MyAdapter(@NonNull FragmentManager fm, ArrayList<String> tab,List<FindDepartmentBean.ResultBean> list) {
        super(fm);
        this.tab = tab;
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("departmentId",list.get(position).getId()+"");
        AllFragment allFragment = new AllFragment();
        allFragment.setArguments(bundle);
        return allFragment;
    }

    @Override
    public int getCount() {
        return tab.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tab.get(position);
    }
}
