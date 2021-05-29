package com.example.coronatracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    List<String> titles;
    List<Integer> images;
    HomeAdapter homeAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.homeView);
        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("Worldwide Tracker");
        titles.add("Statewise Tracker");
        titles.add("Vaccination Tracker");
        images.add(R.drawable.globe);
        images.add(R.drawable.india);
        images.add(R.drawable.vaccine);

        homeAdapter = new HomeAdapter(this,titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter((RecyclerView.Adapter) homeAdapter);
    }
}