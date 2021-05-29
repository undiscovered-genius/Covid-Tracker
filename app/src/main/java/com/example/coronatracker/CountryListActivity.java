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

import com.example.coronatracker.api.ApiUtilities;
import com.example.coronatracker.api.CountryStats;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<CountryStats> list;
    private ProgressDialog dialog;
    private EditText searchBar;
    private CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        searchBar = findViewById(R.id.search);
        recyclerView = findViewById(R.id.country);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();

        adapter = new CountryAdapter(this,list);
        recyclerView.setAdapter(adapter);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading.....");
        dialog.setCancelable(false);
        dialog.show();

        ApiUtilities.getApiInterface().getCountryStats().enqueue(new Callback<List<CountryStats>>() {
            @Override
            public void onResponse(Call<List<CountryStats>> call, Response<List<CountryStats>> response) {
                list.addAll(response.body());
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<CountryStats>> call, Throwable t) {
                Toast.makeText(CountryListActivity.this,""+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        searchBar.addTextChangedListener(new TextWatcher() {
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
        List<CountryStats> searchCon = new ArrayList<>();
        for (CountryStats con : list){
            if(con.getCountry().toLowerCase().contains(toString.toLowerCase())){
                searchCon.add(con);
            }
        }
        adapter.countryList(searchCon);
    }
}