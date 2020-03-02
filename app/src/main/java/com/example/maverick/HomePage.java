package com.example.maverick;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {


    private BottomNavigationView mMainNav;
    private FrameLayout frameLayout;
    HomeFragment homeFragment;
    NotificationFragment notificationFragment;
    UserFragment userFragment;
    SettingFragment settingFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        mMainNav = findViewById(R.id.main_nav);
        frameLayout = findViewById(R.id.main_frame);
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        homeFragment = new HomeFragment();
                        fragmentChanger(homeFragment);
                        break;
                    case R.id.nav_notif:
                        notificationFragment = new NotificationFragment();
                        fragmentChanger(notificationFragment);
                        break;
                    case R.id.nav_user:
                        userFragment = new UserFragment();
                        fragmentChanger(userFragment);
                        break;
                    case R.id.nav_setting:
                       settingFragment = new SettingFragment();
                       fragmentChanger(settingFragment);
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);


                }
                return false;
            }
        });
    }

    public void fragmentChanger(Fragment fragment)
    {
        frameLayout.removeAllViews();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }

}
