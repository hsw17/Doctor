package com.wd.doctor.adapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

/**
 * describe:MyFragmentChooseAdapter
 * date:2019/12/22
 * author:任(Lenovo)
 * function:
 */
public class MyFragmentChooseAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list;

    public MyFragmentChooseAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
