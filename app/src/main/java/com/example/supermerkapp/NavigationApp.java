package com.example.supermerkapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.supermerkapp.fragments.HomeFragment;
import com.example.supermerkapp.fragments.MapFragment;
import com.example.supermerkapp.fragments.ShopCarFragment;
import com.example.supermerkapp.fragments.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationApp extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    FragmentTransaction transaction;
    Fragment HomeFragment ,MapFragment ,ShopCarFragment,userFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_app);

        HomeFragment = new HomeFragment();
        ShopCarFragment = new ShopCarFragment();
        MapFragment = new MapFragment();
        userFragment = new UserFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragments,MapFragment).commit();


        bottomNavigation=(BottomNavigationView) findViewById(R.id.bottomnav);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                transaction = getSupportFragmentManager().beginTransaction();

                if(menuItem.getItemId()== R.id.nav_home){
                    transaction.replace(R.id.contenedorFragments,HomeFragment).commit();
                }
                if(menuItem.getItemId()== R.id.nav_map){
                    transaction.replace(R.id.contenedorFragments,MapFragment).commit();
                }
                if(menuItem.getItemId()== R.id.nav_user){
                    transaction.replace(R.id.contenedorFragments,userFragment).commit();
                }
                if(menuItem.getItemId()== R.id.nav_shopcar){
                    transaction.replace(R.id.contenedorFragments,ShopCarFragment).commit();
                }

                return true;

            }
        });


    }
}