package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fragmentdemo.datapass.DataPassTestActivity;
import com.example.fragmentdemo.modify.ModifyFragmentActivity;
import com.example.fragmentdemo.viewpager.ViewPagerTestActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jumpToStaticFragment1(View view) {
        Intent intent = new Intent(this,StaticFragmentActivity.class);
        startActivity(intent);
    }

    public void jumpToDynamicFragment1(View view) {
        Intent intent = new Intent(this,DynamicFragmentActivity.class);
        startActivity(intent);
    }

    public void jumpToFragmentModify(View view) {
        Intent intent = new Intent(this, ModifyFragmentActivity.class);
        startActivity(intent);
    }

    public void toFragmentModifyDataPass(View view) {
        Intent intent = new Intent(this, DataPassTestActivity.class);
        startActivity(intent);
    }

    public void toFragmentNavigation(View view) {
        Intent intent = new Intent(this, FragmentNaviTestActivity.class);
        startActivity(intent);
    }


    public void toViewPagerTest(View view) {
        Intent intent = new Intent(this, ViewPagerTestActivity.class);
        startActivity(intent);
    }
}