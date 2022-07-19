package com.example.fragmentdemo.viewpager.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class MyFragmentStateVPAdapter extends FragmentStatePagerAdapter { //可回收内存，适用于复杂的页面交互

    private List<Fragment> mFragmentList;

    public MyFragmentStateVPAdapter(@NonNull FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList == null ? null : mFragmentList.get(position);

    }

    @Override
    public int getCount() {
        return mFragmentList == null ? 0 : mFragmentList.size();

    }
}
