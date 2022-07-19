package com.example.fragmentdemo.datapass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fragmentdemo.R;
import com.example.fragmentdemo.datapass.fragment.DataPassFragment;

public class DataPassTestActivity extends AppCompatActivity {

    private TextView tvReceive;
    private String mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pass_test);
        tvReceive = findViewById(R.id.tv_receive);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fcv, DataPassFragment.class,null)
                .commitNow();

        Fragment fragment = fragmentManager.findFragmentById(R.id.fcv);
        if (fragment != null){
            ((DataPassFragment)fragment).setFragmentDataChangeListener(new DataPassFragment.OnFragmentDataChangeListener() {
                @Override
                public void onFragmentDataChange(String data) {
                    mData = data;
                    tvReceive.setText(mData);
                }
            });
        }



    }

    public void setReceive(String data){
        mData = data;
        tvReceive.setText(mData);
    }

    public void passDataByConstruct(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        DataPassFragment dataPassFragment = new DataPassFragment("这是构造方法传递的数据");
        fragmentTransaction.replace(R.id.fcv,dataPassFragment).commit();

    }

    public void passDataByMethod(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fcv);
        if (fragment != null){
            ((DataPassFragment)fragment).setParam1("这是普通public方法传递的数据");
        }
    }

    public void passDataByArgument(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DataPassFragment dataPassFragment = new DataPassFragment();
        Bundle bundle = new Bundle();
        bundle.putString("data","这是通过argument传递的数据");
        bundle.putInt("int data",10);
        dataPassFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fcv,dataPassFragment).commit();
    }


    public void passDataByInterface(View view) {
        if (mDataChangeListener != null){
            mDataChangeListener.onDataChange("这是通过接口传递的数据");
        }


    }
    private OnDataChangeListener mDataChangeListener;
    public void setOnDataChangeListener(OnDataChangeListener dataChangeListener){
        mDataChangeListener = dataChangeListener;
    }

    public void toFragmentBetween(View view) {
        Intent intent = new Intent(this,FragmentPassBetweenActivity.class);
        startActivity(intent);
    }

    public interface OnDataChangeListener{
        void onDataChange(String data);
    }
}