package com.example.fragmentdemo.viewpager.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fragmentdemo.R;
import com.example.fragmentdemo.viewpager.adapter.MyFragmentStateVPAdapter;
import com.example.fragmentdemo.viewpager.fragment.VPFragment;
import com.example.fragmentdemo.viewpager.fragment.VPHomeFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class VPFragmentBotTabActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;

    private MyFragmentStateVPAdapter mStateVPAdapter;
    private List<Fragment> mFragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vpfragment_bot_tab);

        mViewPager = findViewById(R.id.vp);
        mBottomNavigationView = findViewById(R.id.bottom_nav_menu);
        initData();
        mStateVPAdapter = new MyFragmentStateVPAdapter(getSupportFragmentManager(),mFragmentList);
        mViewPager.setAdapter(mStateVPAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onPagerSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.menu_find:
                        mViewPager.setCurrentItem(1);

                        break;
                    case R.id.menu_mine:
                        mViewPager.setCurrentItem(2);

                        break;
                    default:break;
                }
                return true;
            }
        });
        BadgeDrawable badge = mBottomNavigationView.getOrCreateBadge(R.id.menu_mine);
        badge.setNumber(100);
        badge.setMaxCharacterCount(3);
        mBottomNavigationView.getOrCreateBadge(R.id.menu_find);


    }

    private void onPagerSelected(int position) {
        switch (position){
            case 0:
                mBottomNavigationView.setSelectedItemId(R.id.menu_home);
                break;
            case 1:
                mBottomNavigationView.removeBadge(R.id.menu_find);
                mBottomNavigationView.setSelectedItemId(R.id.menu_find);

                break;
            case 2:
                mBottomNavigationView.removeBadge(R.id.menu_mine);
                mBottomNavigationView.setSelectedItemId(R.id.menu_mine);

                break;
            default:break;
        }
    }

    private void initData() {
        mFragmentList = new ArrayList<>();
        VPHomeFragment homeFragment = VPHomeFragment.newInstance("首页","");
        mFragmentList.add(homeFragment);

        VPFragment findFragment = new VPFragment().newInstance("发现","");
        VPFragment mineFragment = new VPFragment().newInstance("我的","");
        mFragmentList.add(findFragment);
        mFragmentList.add(mineFragment);


    }
}