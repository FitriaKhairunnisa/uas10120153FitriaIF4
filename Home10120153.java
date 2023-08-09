package com.example.uas10120153fitriaif4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.uas10120153fitriaif4.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

class Home10120153 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home10120153);
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);

        final HomeFragment10120153 HomeFragment10120153 = new HomeFragment10120153();
        final ProfileFragment10120153 ProfileFragment10120153 = new ProfileFragment10120153();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.home) {
                    setFragment(HomeFragment10120153);
                    return true;
                } else if (id == R.id.profile) {
                    setFragment(ProfileFragment10120153);
                    return true;
                }
                return false;
            }
        });

        navigationView.setSelectedItemId(R.id.home);
    }

    private void setFragment(HomeFragment10120153 homeFragment10120153) {
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }


    private class HomeFragment10120153 {
    }
}
