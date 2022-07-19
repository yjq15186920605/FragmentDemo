package com.example.fragmentdemo.viewpager.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.fragmentdemo.R;
import com.example.fragmentdemo.viewpager.adapter.MyFragmentVPAdapter;
import com.example.fragmentdemo.viewpager.fragment.VPFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerFragmentActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private MyFragmentVPAdapter mVPAdapter;
    private List<Fragment> mFragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mViewPager = findViewById(R.id.vp2);

        initData();
        mVPAdapter = new MyFragmentVPAdapter(getSupportFragmentManager(),mFragmentList);
        mViewPager.setAdapter(mVPAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(ViewPagerFragmentActivity.this,
                        "你选中了fragment"+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {

        mFragmentList = new ArrayList<>();

        VPFragment fragment1 = VPFragment.newInstance("这是Fragment1","");
        VPFragment fragment2 = VPFragment.newInstance("这是Fragment2","");
        VPFragment fragment3 = VPFragment.newInstance("这是Fragment3","");

        mFragmentList.add(fragment1);
        mFragmentList.add(fragment2);
        mFragmentList.add(fragment3);

    }
}