package com.example.coronatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coronatracker.api.ApiStateUtil;
import com.example.coronatracker.api.StateStats;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VaccinationActivity extends AppCompatActivity {

    private TextView total1, total2, front1, front2, health1, health2, sixty1, sixty2, fortyfive1, fortyfive2, vaccineDate;
    private PieChart vaccinePie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination);

        total1 = findViewById(R.id.total1);
        total2 = findViewById(R.id.total2);
        front1 = findViewById(R.id.front1);
        front2 = findViewById(R.id.front2);
        health1 = findViewById(R.id.health1);
        health2 = findViewById(R.id.health2);
        sixty1 = findViewById(R.id.sixty1);
        sixty2 = findViewById(R.id.sixty2);
        fortyfive1 = findViewById(R.id.fortyfive1);
        fortyfive2 = findViewById(R.id.fortyfive2);
        vaccineDate = findViewById(R.id.vaccineDate);
        vaccinePie = findViewById(R.id.vaccinePie);

        ApiStateUtil.getApiState().getStateStats().enqueue(new Callback<StateStats>() {
            @Override
            public void onResponse(Call<StateStats> call, Response<StateStats> response) {
                StateStats vac = response.body();
                List<StateStats> vlist = new ArrayList<>();
                vlist.addAll(vac.getTested());
                int lst = vlist.size();
                int registration = Integer.parseInt(vlist.get(lst-1).getTotalindividualsregistered());
                int dose1 = Integer.parseInt(vlist.get(lst-1).getFirstdoseadministered());
                int dose2 = Integer.parseInt(vlist.get(lst-1).getSeconddoseadministered());
                int fnt1 = Integer.parseInt(vlist.get(lst-1).getFrontlineworkersvaccinated1stdose());
                int fnt2 = Integer.parseInt(vlist.get(lst-1).getFrontlineworkersvaccinated2nddose());
                int hlth1 = Integer.parseInt(vlist.get(lst-1).getHealthcareworkersvaccinated1stdose());
                int hlth2 = Integer.parseInt(vlist.get(lst-1).getHealthcareworkersvaccinated2nddose());
                int xty1 = Integer.parseInt(vlist.get(lst-1).getOver60years1stdose());
                int xty2 = Integer.parseInt(vlist.get(lst-1).getOver60years2nddose());
                int forty1 = Integer.parseInt(vlist.get(lst-1).getOver45years1stdose());
                int forty2 = Integer.parseInt(vlist.get(lst-1).getOver45years2nddose());

                vaccineDate.setText("Updated on "+vlist.get(lst-1).getUpdatetimestamp());
                total1.setText(NumberFormat.getInstance().format(dose1));
                total2.setText(NumberFormat.getInstance().format(dose2));
                front1.setText(NumberFormat.getInstance().format(fnt1));
                front2.setText(NumberFormat.getInstance().format(fnt2));
                health1.setText(NumberFormat.getInstance().format(hlth1));
                health2.setText(NumberFormat.getInstance().format(hlth2));
                sixty1.setText(NumberFormat.getInstance().format(xty1));
                sixty2.setText(NumberFormat.getInstance().format(xty2));
                fortyfive1.setText(NumberFormat.getInstance().format(forty1));
                fortyfive2.setText(NumberFormat.getInstance().format(forty2));

                vaccinePie.addPieSlice(new PieModel("Registered",registration,getResources().getColor(R.color.pink)));
                vaccinePie.addPieSlice(new PieModel("Dose 1",dose1,getResources().getColor(R.color.blue)));
                vaccinePie.addPieSlice(new PieModel("Dose 2",dose2,getResources().getColor(R.color.green)));
                vaccinePie.startAnimation();
                vaccinePie.startLayoutAnimation();
            }

            @Override
            public void onFailure(Call<StateStats> call, Throwable t) {
                Toast.makeText(VaccinationActivity.this,"Error !"+ t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}