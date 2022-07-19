package com.example.fragmentdemo.viewpager.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentdemo.R;
import com.example.fragmentdemo.viewpager.adapter.MyFragmentStVpTitleAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class VPHomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private List<Fragment> mFragmentList;
    private MyFragmentStVpTitleAdapter mSTVpTitleAdapter;
    private List<String> mTitleList;

    public VPHomeFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static VPHomeFragment newInstance(String param1, String param2) {
        VPHomeFragment fragment = new VPHomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_v_p_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewPager = view.findViewById(R.id.home_vp);
        mTabLayout = view.findViewById(R.id.tab_layout);

        initDta();
        mSTVpTitleAdapter = new MyFragmentStVpTitleAdapter(getChildFragmentManager(),
                mFragmentList,
                mTitleList);

        mViewPager.setAdapter(mSTVpTitleAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initDta() {
        mFragmentList = new ArrayList<>();
        VPFragment fragment1 = VPFragment.newInstance("推荐","");
        VPFragment fragment2 = VPFragment.newInstance("关注","");
        VPFragment fragment3 = VPFragment.newInstance("娱乐","");
        VPFragment fragment4 = VPFragment.newInstance("时政","");
        VPFragment fragment5 = VPFragment.newInstance("汽车","");
        VPFragment fragment6 = VPFragment.newInstance("历史","");
        VPFragment fragment7 = VPFragment.newInstance("地理","");
        VPFragment fragment8 = VPFragment.newInstance("其他","");
        mFragmentList.add(fragment1);
        mFragmentList.add(fragment2);
        mFragmentList.add(fragment3);
        mFragmentList.add(fragment4);
        mFragmentList.add(fragment5);
        mFragmentList.add(fragment6);
        mFragmentList.add(fragment7);
        mFragmentList.add(fragment8);

        mTitleList = new ArrayList<>();
        mTitleList.add("推荐");
        mTitleList.add("关注");
        mTitleList.add("娱乐");
        mTitleList.add("时政");
        mTitleList.add("汽车");
        mTitleList.add("历史");
        mTitleList.add("地理");
        mTitleList.add("其他");



    }
}