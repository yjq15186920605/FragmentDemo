package com.example.fragmentdemo.datapass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragmentdemo.R;
import com.example.fragmentdemo.datapass.fragment.FragmentPassA;
import com.example.fragmentdemo.datapass.fragment.FragmentPassB;

public class FragmentPassBetweenActivity extends AppCompatActivity {


    public FragmentPassA fragmentA;
    public FragmentPassB fragmentB;

    public FragmentPassA getFragmentA(){
        return fragmentA;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_pass_between);

        fragmentA = new FragmentPassA();
        fragmentB = new FragmentPassB();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fcv_a,fragmentA).commit();


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fcv_b,fragmentB).commit();

    }


}