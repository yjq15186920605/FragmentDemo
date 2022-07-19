package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentBottomNav1ctivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llHome,llFind,llMine;
    private ImageView ivHome,ivFind,ivMine;
    private TextView tvHome,tvFind,tvMine;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_bottom_nav1ctivity);

        initView();
        initEvent();
    }

    private void initEvent() {
        //添加Fragment
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        TestNavFragment fragment = TestNavFragment.newInstance("这是首页","");
        fragmentTransaction.replace(R.id.fcv_fragment,fragment).commit();
        ivHome.setSelected(true);
        tvHome.setTextColor(getResources().getColor(R.color.purple_200));

        setBottomItemSelected(R.id.ll_home);

        llHome.setOnClickListener(this);
        llFind.setOnClickListener(this);
        llMine.setOnClickListener(this);

    }

    private void initView() {
        llHome = findViewById(R.id.ll_home);
        llFind = findViewById(R.id.ll_find);
        llMine = findViewById(R.id.ll_mine);

        ivHome = findViewById(R.id.iv_home);
        ivFind = findViewById(R.id.iv_find);
        ivMine = findViewById(R.id.iv_mine);

        tvHome = findViewById(R.id.tv_home);
        tvFind = findViewById(R.id.tv_find);
        tvMine = findViewById(R.id.tv_mine);



    }
    private void resetBottomState(){
        ivHome.setSelected(false);
        tvHome.setTextColor(getResources().getColor(R.color.gray));
        ivFind.setSelected(false);
        tvFind.setTextColor(getResources().getColor(R.color.gray));
        ivMine.setSelected(false);
        tvMine.setTextColor(getResources().getColor(R.color.gray));
    }

    private void setBottomItemSelected(int id){
        switch (id){
            case R.id.ll_home:
                ivHome.setSelected(true);
                tvHome.setTextColor(getResources().getColor(R.color.purple_200));
                break;
            case R.id.ll_find:
                ivFind.setSelected(true);
                tvFind.setTextColor(getResources().getColor(R.color.purple_200));
                break;
            case R.id.ll_mine:
                ivMine.setSelected(true);
                tvMine.setTextColor(getResources().getColor(R.color.purple_200));
                break;
            default:
                break;
        }
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        resetBottomState();
        setBottomItemSelected(view.getId());
        switch (id){
            case R.id.ll_home:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                TestNavFragment fragment = TestNavFragment.newInstance("这是首页","");
                fragmentTransaction.replace(R.id.fcv_fragment,fragment).commit();
                break;
            case R.id.ll_find:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                TestNavFragment findFragment = TestNavFragment.newInstance("这是发现页","");
                fragmentTransaction.replace(R.id.fcv_fragment,findFragment).commit();
                break;
            case R.id.ll_mine:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                TestNavFragment mineFragment = TestNavFragment.newInstance("这是我的页","");
                fragmentTransaction.replace(R.id.fcv_fragment,mineFragment).commit();
                break;
            default:
                break;
        }
    }
}