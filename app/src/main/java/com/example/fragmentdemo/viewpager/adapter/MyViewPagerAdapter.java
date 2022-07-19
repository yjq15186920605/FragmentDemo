package com.example.fragmentdemo.viewpager.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MyViewPagerAdapter extends PagerAdapter {

    private List<ImageView> mImageView;

    public MyViewPagerAdapter(List<ImageView> mImageView) {
        this.mImageView = mImageView;
    }

    @Override
    public int getCount() {
        return mImageView == null?0:mImageView.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public MyViewPagerAdapter() {
        super();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = mImageView.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


}
