package com.example.fragmentdemo.viewpager.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fragmentdemo.R;
import com.example.fragmentdemo.viewpager.adapter.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private MyViewPagerAdapter mMyViewPagerAdapter;
    private List<ImageView> mImageViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mViewPager = findViewById(R.id.vp);

        inintData();
        mMyViewPagerAdapter = new MyViewPagerAdapter(mImageViews);
        mViewPager.setAdapter(mMyViewPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(ViewPagerActivity.this,"这是第"+position+"页",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void inintData() {
        ImageView imageView1 = new ImageView(this);
        imageView1.setImageResource(R.drawable.shenli);

        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.drawable.ganyu);

        ImageView imageView3 = new ImageView(this);
        imageView3.setImageResource(R.drawable.bachong);

        ImageView imageView4 = new ImageView(this);
        imageView4.setImageResource(R.drawable.youla);

        mImageViews = new ArrayList<>();
        mImageViews.add(imageView1);
        mImageViews.add(imageView2);
        mImageViews.add(imageView3);
        mImageViews.add(imageView4);


    }
}