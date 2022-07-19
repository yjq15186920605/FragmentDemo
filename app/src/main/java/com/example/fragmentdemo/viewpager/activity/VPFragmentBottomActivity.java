package com.example.fragmentdemo.viewpager.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragmentdemo.R;
import com.example.fragmentdemo.viewpager.adapter.MyFragmentVPAdapter;
import com.example.fragmentdemo.viewpager.fragment.VPFragment;

import java.util.ArrayList;
import java.util.List;

public class VPFragmentBottomActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager mViewPager;
    private ImageView ivHome,ivFind,ivMine;
    private TextView tvHome,tvFind,tvMine;
    private LinearLayout llHome,llFind,llMine;

    private MyFragmentVPAdapter mVPAdapter;
    private List<Fragment> mFragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vpfragment_bottom);
        initView();
        initData();
        mVPAdapter = new MyFragmentVPAdapter(getSupportFragmentManager(),mFragmentList);
        mViewPager.setAdapter(mVPAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(VPFragmentBottomActivity.this,"页面"+position,Toast.LENGTH_SHORT).show();

                onViewPagerSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //默认进入选中首页
        onViewPagerSelected(0);

        llHome.setOnClickListener(this);
        llFind.setOnClickListener(this);
        llMine.setOnClickListener(this);
    }

    private void onViewPagerSelected(int position) {

        resetBottomStatue();
        switch (position){
            case 0:
                ivHome.setSelected(true);
                tvHome.setTextColor(getResources().getColor(R.color.purple_200));
                break;
            case 1:
                ivFind.setSelected(true);
                tvFind.setTextColor(getResources().getColor(R.color.purple_200));
                break;
            case 2:
                ivMine.setSelected(true);
                tvMine.setTextColor(getResources().getColor(R.color.purple_200));
                break;
            default:
                break;
        }
    }

    private void resetBottomStatue() {
        ivHome.setSelected(false);
        tvHome.setTextColor(getResources().getColor(R.color.gray));
        ivFind.setSelected(false);
        tvFind.setTextColor(getResources().getColor(R.color.gray));
        ivMine.setSelected(false);
        tvMine.setTextColor(getResources().getColor(R.color.gray));

    }

    private void initData() {
        mFragmentList = new ArrayList<>();
        VPFragment fragmentHome = VPFragment.newInstance("首页","");
        VPFragment fragmentFind = VPFragment.newInstance("发现","");
        VPFragment fragmentMine = VPFragment.newInstance("我的","");

        mFragmentList.add(fragmentHome);
        mFragmentList.add(fragmentFind);
        mFragmentList.add(fragmentMine);


    }

    private void initView() {

        mViewPager = findViewById(R.id.vp);

        ivHome = findViewById(R.id.iv_home);
        ivFind = findViewById(R.id.iv_find);
        ivMine = findViewById(R.id.iv_mine);

        llHome = findViewById(R.id.ll_home);
        llFind = findViewById(R.id.ll_find);
        llMine = findViewById(R.id.ll_mine);

        tvHome = findViewById(R.id.tv_home);
        tvFind = findViewById(R.id.tv_find);
        tvMine = findViewById(R.id.tv_mine);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.ll_home:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.ll_find:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.ll_mine:
                mViewPager.setCurrentItem(2);
                break;
            default:
                break;
        }
    }
}