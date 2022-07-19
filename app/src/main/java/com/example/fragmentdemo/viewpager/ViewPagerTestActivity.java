package com.example.fragmentdemo.viewpager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fragmentdemo.R;
import com.example.fragmentdemo.viewpager.activity.VPFragmentBotTabActivity;
import com.example.fragmentdemo.viewpager.activity.VPFragmentBottomActivity;
import com.example.fragmentdemo.viewpager.activity.VPFragmentBottomNavActivity;
import com.example.fragmentdemo.viewpager.activity.ViewPagerActivity;
import com.example.fragmentdemo.viewpager.activity.ViewPagerFragmentActivity;

public class ViewPagerTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_test);
    }

    public void toViewPager(View view) {
        Intent intent = new Intent(this, ViewPagerActivity.class);
        startActivity(intent);
    }

    public void toViewPagerFragment(View view) {
        Intent intent = new Intent(this, ViewPagerFragmentActivity.class);
        startActivity(intent);
    }

    public void toViewPagerFragmentBottom(View view) {
        Intent intent = new Intent(this, VPFragmentBottomActivity.class);
        startActivity(intent);
    }

    public void toViewPagerFragmentBottomNavigationView(View view) {
        Intent intent = new Intent(this, VPFragmentBottomNavActivity.class);
        startActivity(intent);
    }

    public void toViewPagerFragmentBottomNavigationViewTabLayout(View view) {
        Intent intent = new Intent(this, VPFragmentBotTabActivity.class);
        startActivity(intent);
    }
}