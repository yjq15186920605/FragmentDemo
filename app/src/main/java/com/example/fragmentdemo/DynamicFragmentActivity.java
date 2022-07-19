package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.fragmentdemo.fragment.DynamicFragment;

public class DynamicFragmentActivity extends AppCompatActivity {
    private static final String TAG = GlobalConstants.TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        Log.d(TAG, "onCreate: DynamicFragmentActivity");
//        Log.d(TAG, "onCreate: savedInstance"+savedInstanceState);

        if (savedInstanceState == null){  //防止重复添加
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            Bundle bundle = new Bundle();
            bundle.putString(DynamicFragment.ARG_PARAM1,"这是动态Fragment");
            fragmentTransaction.add(R.id.fcv, DynamicFragment.class,bundle)
                    .setReorderingAllowed(true)
//                    .addToBackStack(null)    //防止返回键退不出当前activity
                    .commit();
        }


    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: DynamicFragmentActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: DynamicFragmentActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: DynamicFragmentActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: DynamicFragmentActivity");
    }
}