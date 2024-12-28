package com.example.spacego.missiondata;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.example.spacego.R;
import com.example.spacego.databaseaccess.Space_Data;
import com.example.spacego.fragments.LaunchDetails;
import com.example.spacego.fragments.MissionDetails;
import com.example.spacego.fragments.TechnicalDetails;
import com.example.spacego.fragments.TimeDetails;
import com.example.spacego.viewmodel.SpaceViewmodel;
import com.example.spacego.viewpager.ViewpagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class FullDataActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ViewpagerAdapter viewpagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_full_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        MissionDetails missionDetailsFragment = new MissionDetails();
        LaunchDetails launchDetails = new LaunchDetails();
        TechnicalDetails technicalDetails = new TechnicalDetails();
        TimeDetails timeDetails = new TimeDetails();

        // Get the Space_Data from the Intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("Item")) {
            Space_Data item = intent.getParcelableExtra("Item");
            if (item != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("Item", item);
                missionDetailsFragment.setArguments(bundle);
                launchDetails.setArguments(bundle);
                technicalDetails.setArguments(bundle);
                timeDetails.setArguments(bundle);
            }
        }

        viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(), getLifecycle());

        viewpagerAdapter.removeFragment(0);
        viewpagerAdapter.addFragment(missionDetailsFragment, 0);

        viewpagerAdapter.removeFragment(1);
        viewpagerAdapter.addFragment(launchDetails, 1);

        viewpagerAdapter.removeFragment(2);
        viewpagerAdapter.addFragment(technicalDetails,2);

        viewpagerAdapter.removeFragment(3);
        viewpagerAdapter.addFragment(timeDetails, 3);

        viewPager2.setAdapter(viewpagerAdapter);

        String[] tabNames = {
                "Mission Details",
                "Launch Info",
                "Technical Details",
                "Time and Accessibility"
        };

        new TabLayoutMediator(tabLayout, viewPager2, (tab,position) -> {
            if (position >= 0 && position < tabNames.length) {
                tab.setText(tabNames[position]); // Set tab name based on position
            }
        }).attach();
    }
}