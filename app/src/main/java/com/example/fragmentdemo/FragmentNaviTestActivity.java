package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FragmentNaviTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_navi_test);
    }

    public void toFragmentNormalBottom(View view) {
        Intent intent = new Intent(this,FragmentBottomNav1ctivity.class);
        startActivity(intent);
    }

    public void toFragmentDrawer(View view) {
        Intent intent = new Intent(this,FragmentDrawerActivity.class);
        startActivity(intent);
    }
}