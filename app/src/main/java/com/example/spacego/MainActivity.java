package com.example.spacego;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.spacego.fragments.CommunityFragment;
import com.example.spacego.fragments.MissionFragment;
import com.example.spacego.fragments.ProfileFragment;
import com.example.spacego.fragments.TicketFragment;
import com.example.spacego.fragments.TrainingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    private final NavigationBarView.OnItemSelectedListener itemSelectedListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int item_id = item.getItemId();

            if (item_id == R.id.nav_missions){
                loadFragment(new MissionFragment());
            } else if (item_id == R.id.nav_ticket) {
                loadFragment(new TicketFragment());
            } else if (item_id == R.id.nav_community) {
                loadFragment(new CommunityFragment());
            } else if (item_id == R.id.nav_training) {
                loadFragment(new TrainingFragment());
            } else if (item_id == R.id.nav_profile) {
                loadFragment(new ProfileFragment());
            }else {
                return false;
            }
            return true;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (savedInstanceState == null){
            loadFragment(new MissionFragment());
        }


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(itemSelectedListener);
    }

    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(
                R.id.space_layout, fragment
        ).commit();
    }
}