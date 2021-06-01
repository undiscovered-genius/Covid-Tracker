package com.example.coronatracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    List<String> titles;
    List<Integer> images;
    HomeAdapter homeAdapter;
    RecyclerView recyclerView;
    SwitchCompat switchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        switchCompat = findViewById(R.id.modeSwitch);
        recyclerView = findViewById(R.id.homeView);
        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("Worldwide Tracker");
        titles.add("Statewise Tracker");
        titles.add("Vaccination Tracker");
        titles.add("Vaccine Centere");
        titles.add("Precautions");
        images.add(R.drawable.globe);
        images.add(R.drawable.india);
        images.add(R.drawable.vaccine);
        images.add(R.drawable.tracker);
        images.add(R.drawable.precaution);

        homeAdapter = new HomeAdapter(this,titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter((RecyclerView.Adapter) homeAdapter);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }
}