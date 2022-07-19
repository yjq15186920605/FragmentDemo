package com.example.fragmentdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class FragmentDrawerActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    private Toolbar mToolbar;
    private ActionBarDrawerToggle mActionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_drawer2); //两种方式，drawer2改成drawer即可
        mDrawerLayout = findViewById(R.id.drawer);
        mNavigationView = findViewById(R.id.nv_drawer_menu);

        mToolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();


        setHomePage();
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        DrawerFragment homeFragment = DrawerFragment.newInstance("首页","");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fcv,homeFragment).commit();
                        break;
                    case R.id.menu_find:
                        DrawerFragment findFragment = DrawerFragment.newInstance("发现","");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fcv,findFragment).commit();
                        break;
                    case R.id.menu_mine:
                        DrawerFragment mineFragment = DrawerFragment.newInstance("我的","");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fcv,mineFragment).commit();
                        break;
                    default:break;
                }
                if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
                    mDrawerLayout.closeDrawers();
                }

                return true;
            }
        });

    }

    private void setHomePage() {
        DrawerFragment homeFragment = DrawerFragment.newInstance("首页","");
        getSupportFragmentManager().beginTransaction().replace(R.id.fcv,homeFragment).commit();
        mNavigationView.setCheckedItem(R.id.menu_home);
    }

}