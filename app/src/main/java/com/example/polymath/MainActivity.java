package com.example.polymath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.polymath.Fragments.PlaneFragment;
import com.example.polymath.Fragments.ProfileFragment;
import com.example.polymath.Fragments.SolidFragment;
import com.example.polymath.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        info = findViewById(R.id.info);

        replaceFragment(new PlaneFragment());

        binding.bottomNavigationView.setItemIconTintList(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.plane) {
                replaceFragment(new PlaneFragment());
                info.setText("Choose the Shape!");
            } else if (item.getItemId() == R.id.solid) {
                replaceFragment(new SolidFragment());
                info.setText("Choose the Shape!");
            } else if (item.getItemId() == R.id.profile) {
                replaceFragment(new ProfileFragment());
                info.setText("You’re Cool!");
            }
            return true;
        });

    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);

        // Pass data to ProfileFragment if it's being replaced
        if (fragment instanceof ProfileFragment) {
            Intent intent = getIntent();
            String name = intent.getStringExtra("nameUser");
            String email = intent.getStringExtra("emailUser");
            fragmentTransaction.replace(R.id.frame_layout, ProfileFragment.newInstance(name, email));
        } else {
            fragmentTransaction.replace(R.id.frame_layout, fragment);
        }

        fragmentTransaction.commit();
    }

}