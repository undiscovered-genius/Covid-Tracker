package com.example.coronatracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coronatracker.api.ApiCentreUtil;
import com.example.coronatracker.api.ApiState;
import com.example.coronatracker.api.CentreStats;
import com.example.coronatracker.api.StateStats;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class CentreActivity extends AppCompatActivity {

    private TextView date;
    private EditText pincode;
    private Button find;
    private RecyclerView recyclerView;
    private List<CentreStats> list;
    private List<String> name,vac,fee,age,dose,dose1,dose2,time;
    CentreAdater centreAdater;
    DatePickerDialog.OnDateSetListener setListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre);

        date = findViewById(R.id.vacDate);
        pincode = findViewById(R.id.pincode);
        find = findViewById(R.id.find);
        recyclerView = findViewById(R.id.vaccineView);
        list = new ArrayList<>();
        name = new ArrayList<>();
        vac = new ArrayList<>();
        fee = new ArrayList<>();
        age = new ArrayList<>();
        dose = new ArrayList<>();
        dose1 = new ArrayList<>();
        dose2 = new ArrayList<>();
        time = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        final int yyyy = calendar.get(Calendar.YEAR);
        final  int mm = calendar.get(Calendar.MONTH);
        final int dd = calendar.get(Calendar.DAY_OF_MONTH);

        ApiCentreUtil.getApiCentre().getCentreStats().enqueue(new Callback<CentreStats>() {
            @Override
            public void onResponse(Call<CentreStats> call, Response<CentreStats> response) {
                Toast.makeText(CentreActivity.this,"working",Toast.LENGTH_SHORT).show();
                CentreStats cs = response.body();

                List<CentreStats> centreStatsList = new ArrayList<>();
                centreStatsList.addAll((Collection<? extends CentreStats>)cs.getSessions());

                for(int i=0; i<list.size(); i++){
                    name.add(list.get(i).getName());

                    vac.add(list.get(i).getVaccine());
                    fee.add(list.get(i).getFee());
                    age.add(list.get(i).getMin_age_limit());
                    dose.add(list.get(i).getAvailable_capacity());
                    dose1.add(list.get(i).getAvailable_capacity_dose1());
                    dose2.add(list.get(i).getAvailable_capacity_dose2());
                    time.add(list.get(i).getFrom()+"-"+list.get(i).getTo());
                }
            }

            @Override
            public void onFailure(Call<CentreStats> call, Throwable t) {
                Toast.makeText(CentreActivity.this,"Error"+t,Toast.LENGTH_SHORT).show();
            }
        });

        centreAdater = new CentreAdater(CentreActivity.this,name,vac,fee,age,dose,dose1,dose2,time);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(CentreActivity.this,1,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter((RecyclerView.Adapter) centreAdater);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(CentreActivity.this, android.R.style.Theme_Holo_Dialog_NoActionBar_MinWidth,setListner,yyyy,mm,dd);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String DATE = null;
                DATE = dayOfMonth+"-"+month+"-"+year;

                if (month < 10 && dayOfMonth >= 10){
                    DATE = dayOfMonth+"-0"+month+"-"+year;
                }else  if (month < 10 && dayOfMonth < 10){
                    DATE = "0"+dayOfMonth+"-0"+month+"-"+year;
                }else if (dayOfMonth < 10 && month >= 10){
                    DATE = "0"+dayOfMonth+"-"+month+"-"+year;
                }

                date.setText(DATE);
            }
        };

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pin = pincode.getText().toString();
                String dt = date.getText().toString();

                if (pin.isEmpty() || !(pin.length() == 6)){
                    pincode.setError("Enter a 6-digit pincode");
                }else if (dt.isEmpty()){
                    date.setError("Select a Date");
                }else{
                    Toast.makeText(CentreActivity.this,"working",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}