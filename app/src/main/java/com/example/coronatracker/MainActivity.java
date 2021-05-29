package com.example.coronatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coronatracker.api.ApiUtilities;
import com.example.coronatracker.api.CountryStats;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView date, totalConfirm, todayConfirm, totalActive, totalRecover, todayRecover, totalDeath, todayDeath, totalTest;
    private List<CountryStats> list;
    private PieChart pieChart;
    String country = "India";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = findViewById(R.id.date);
        totalConfirm = findViewById(R.id.totalConfirm);
        totalActive = findViewById(R.id.totalActive);
        totalRecover = findViewById(R.id.totalRecover);
        totalDeath = findViewById(R.id.totalDeath);
        totalTest = findViewById(R.id.totalTest);
        todayConfirm = findViewById(R.id.todayConfirm);
        todayRecover = findViewById(R.id.todayRecover);
        todayDeath = findViewById(R.id.todayDeath);
        pieChart = findViewById(R.id.pieChart);

        list = new ArrayList<>();
        if (getIntent().getStringExtra("country") != null){
            country = getIntent().getStringExtra("country");
        }
        TextView cName = findViewById(R.id.cName);
        cName.setText(country);

        cName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CountryListActivity.class));
            }
        });

        ApiUtilities.getApiInterface().getCountryStats()
                .enqueue(new Callback<List<CountryStats>>() {
                    @Override
                    public void onResponse(Call<List<CountryStats>> call, Response<List<CountryStats>> response) {
                        list.addAll(response.body());

                        for (int i=0;i<list.size();i++){
                            if(list.get(i).getCountry().equals(country)){
                                int confirm = Integer.parseInt(list.get(i).getCases());
                                int active = Integer.parseInt(list.get(i).getActive());
                                int recovered = Integer.parseInt(list.get(i).getRecovered());
                                int death = Integer.parseInt(list.get(i).getDeaths());

                                setText(list.get(i).getUpdated());

                                totalActive.setText(NumberFormat.getInstance().format(active));
                                totalConfirm.setText(NumberFormat.getInstance().format(confirm));
                                totalDeath.setText(NumberFormat.getInstance().format(death));
                                totalRecover.setText(NumberFormat.getInstance().format(recovered));
                                totalTest.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTests())));

                                todayDeath.setText("( +"+NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayDeaths()))+" )");
                                todayConfirm.setText("( +"+NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayCases()))+" )");
                                todayRecover.setText("( +"+NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayRecovered()))+" )");

                                pieChart.addPieSlice(new PieModel("Confirmed",confirm,getResources().getColor(R.color.yellow)));
                                pieChart.addPieSlice(new PieModel("Active",active,getResources().getColor(R.color.blue_pie)));
                                pieChart.addPieSlice(new PieModel("Recovered",recovered,getResources().getColor(R.color.green_pie)));
                                pieChart.addPieSlice(new PieModel("Deceased",death,getResources().getColor(R.color.red_pie)));

                                pieChart.startAnimation();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<CountryStats>> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"Error !"+ t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void setText(String updated) {
        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        long milliseconds = Long.parseLong(updated);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        date.setText("Updated on "+dateFormat.format(calendar.getTime()));
    }
}