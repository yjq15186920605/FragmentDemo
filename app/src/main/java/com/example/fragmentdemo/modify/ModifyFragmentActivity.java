package com.example.fragmentdemo.modify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.fragmentdemo.GlobalConstants;
import com.example.fragmentdemo.R;
import com.example.fragmentdemo.fragment.DynamicFragment;

public class ModifyFragmentActivity extends AppCompatActivity {
    private static final String TAG = GlobalConstants.TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_fragment);
    }

    public void addFragment1(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fcv, DynamicFragment.class,null,"myFragment").commit();

    }
    public void addFragment2(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fcv, DynamicFragment.class,null)
                .addToBackStack("myBackStack")
                .setReorderingAllowed(true)
                .commit();
    }
    public void addFragment3(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DynamicFragment dynamicFragment = new DynamicFragment();
        fragmentTransaction.add(R.id.fcv, dynamicFragment)
//                .addToBackStack("myBackStack")
//                .setReorderingAllowed(true)
                .commit();
    }

    public void findFragmentById(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentById(R.id.fcv);
        if(fragment != null){
            Toast.makeText(this,"找到了fragment"+fragment.toString(),Toast.LENGTH_SHORT).show();
            Log.d(TAG, "findFragmentById: 找到了fragment"+fragment.toString());
        }
        else {
            Toast.makeText(this,"没找到fragment",Toast.LENGTH_SHORT).show();
            Log.d(TAG, "findFragmentById: 没找到fragment");
        }

    }

    public void findFragmentByTag(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentByTag("myFragment");
        if(fragment!=null){
            Toast.makeText(this,"找到了fragment"+fragment.toString(),Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"没找到fragment",Toast.LENGTH_SHORT).show();
        }
    }

    public void removeFragment(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fcv);
        if(fragment != null){
            Toast.makeText(this,"找到了fragment，并成功移除",Toast.LENGTH_SHORT).show();
            Log.d(TAG, "findFragmentById: 即将移除fragment"+fragment.toString());
            fragmentTransaction.remove(fragment).commit();

        }
        else {
            Toast.makeText(this,"没找到fragment"+fragment.toString(),Toast.LENGTH_SHORT).show();
            Log.d(TAG, "findFragmentById: 没找到fragment");
        }
    }

    public void replaceFragment(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DynamicFragment dynamicFragment = new DynamicFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DynamicFragment.ARG_PARAM1,"这是新替换的fragment");
        dynamicFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.fcv,dynamicFragment).commit();
    }
}