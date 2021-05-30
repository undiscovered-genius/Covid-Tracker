package com.example.coronatracker;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coronatracker.api.ApiStateUtil;
import com.example.coronatracker.api.StateStats;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StateActivity extends AppCompatActivity {

    private TextView stateDate, stotalConfirm, stodayConfirm, stotalActive, stotalRecover, stodayRecover, stotalDeath, stodayDeath, stotalTest;
    private List<StateStats> slist;
    private PieChart statePie;
    String state = "Maharashtra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);

        stateDate = findViewById(R.id.stateDate);
        stotalConfirm = findViewById(R.id.stotalConfirm);
        stodayConfirm = findViewById(R.id.stodayConfirm);
        stotalActive = findViewById(R.id.stotalActive);
        stotalRecover = findViewById(R.id.stotalRecover);
        stodayRecover = findViewById(R.id.stodayRecover);
        stotalDeath = findViewById(R.id.stotalDeath);
        stodayDeath = findViewById(R.id.stodayDeath);
//        stotalTest = findViewById(R.id.stotalTest);
        TextView sName = findViewById(R.id.sName);
        slist = new ArrayList<StateStats>();
        statePie = findViewById(R.id.statePie);

        if (getIntent().getStringExtra("state") != null){
            state = getIntent().getStringExtra("state");
        }
        if(state.toLowerCase().equals("total")){
            sName.setText("India");
        }else{
            sName.setText(state);
        }

        sName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StateActivity.this,StateListActivity.class));
            }
        });

        ApiStateUtil.getApiState().getStateStats().enqueue(new Callback<StateStats>() {
            @Override
            public void onResponse(Call<StateStats> call, Response<StateStats> response) {
                StateStats st = response.body();
                System.out.println("output"+st);

                    List<StateStats> statewise = new ArrayList<>();
                    statewise.addAll((Collection<? extends StateStats>) st.getStatewise());
                    for (int j=0;j<statewise.size();j++){
//                        if (statewise.get(j).getState().equals("Total")){
//                            List<StateStats> datewise = new ArrayList<>();
//                            datewise.addAll((Collection<? extends StateStats>) st.getStatewise());
//                        }else{
//                        }
                        if(statewise.get(j).getState().equals(state)){
                            int confirm = Integer.parseInt(statewise.get(j).getConfirmed());
                            int active = Integer.parseInt(statewise.get(j).getActive());
                            int recovered = Integer.parseInt(statewise.get(j).getRecovered());
                            int death = Integer.parseInt(statewise.get(j).getDeaths());

                            setText(statewise.get(j).getLastupdatedtime());

                            stotalActive.setText(NumberFormat.getInstance().format(active));
                            stotalConfirm.setText(NumberFormat.getInstance().format(confirm));
                            stotalDeath.setText(NumberFormat.getInstance().format(death));
                            stotalRecover.setText(NumberFormat.getInstance().format(recovered));

                            stodayDeath.setText("( +"+NumberFormat.getInstance().format(Integer.parseInt(statewise.get(j).getDeltadeaths()))+" )");
                            stodayConfirm.setText("( +"+NumberFormat.getInstance().format(Integer.parseInt(statewise.get(j).getDeltaconfirmed()))+" )");
                            stodayRecover.setText("( +"+NumberFormat.getInstance().format(Integer.parseInt(statewise.get(j).getDeltarecovered()))+" )");

                            statePie.addPieSlice(new PieModel("Confirmed",confirm,getResources().getColor(R.color.yellow)));
                            statePie.addPieSlice(new PieModel("Active",active,getResources().getColor(R.color.blue_pie)));
                            statePie.addPieSlice(new PieModel("Recovered",recovered,getResources().getColor(R.color.green_pie)));
                            statePie.addPieSlice(new PieModel("Deceased",death,getResources().getColor(R.color.red_pie)));

                            statePie.startAnimation();
                        }
                    }
            }

            @Override
            public void onFailure(Call<StateStats> call, Throwable t) {
                Toast.makeText(StateActivity.this,"Error !"+ t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setText(String lastupdatedtime) {
        stateDate.setText("Updated on "+lastupdatedtime);
    }
}