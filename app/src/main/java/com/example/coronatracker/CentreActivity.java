package com.example.coronatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class CentreActivity extends AppCompatActivity {

    private TextView date;
    DatePickerDialog.OnDateSetListener setListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre);

        date = findViewById(R.id.vacDate);

        Calendar calendar = Calendar.getInstance();
        final int yyyy = calendar.get(Calendar.YEAR);
        final  int mm = calendar.get(Calendar.MONTH);
        final int dd = calendar.get(Calendar.DAY_OF_MONTH);

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
    }
}