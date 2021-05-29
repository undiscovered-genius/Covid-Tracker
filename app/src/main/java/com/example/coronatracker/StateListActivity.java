package com.example.coronatracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.example.coronatracker.api.ApiStateUtil;
import com.example.coronatracker.api.CountryStats;
import com.example.coronatracker.api.StateStats;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StateListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<StateStats> list;
    private ProgressDialog dialog;
    private EditText searchB;
    private StateAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_list);

        searchB = findViewById(R.id.searchB);
        recyclerView = findViewById(R.id.state);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();

        adapter = new StateAdapter(this,list);
        recyclerView.setAdapter(adapter);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading.....");
        dialog.setCancelable(false);
        dialog.show();

        ApiStateUtil.getApiState().getStateStats().enqueue(new Callback<StateStats>() {
            @Override
            public void onResponse(Call<StateStats> call, Response<StateStats> response) {
                StateStats st = response.body();
                list.addAll((Collection<? extends StateStats>) st.getStatewise());
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<StateStats> call, Throwable t) {
                Toast.makeText(StateListActivity.this,""+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        searchB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String toString) {
        List<StateStats> searchCon = new ArrayList<>();
        for (StateStats con : list){
            if(con.getState().toLowerCase().contains(toString.toLowerCase())){
                searchCon.add(con);
            }
        }
        adapter.stateList(searchCon);
    }
}