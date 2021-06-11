package com.example.coronatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    private TextView total1, total2, front1, front2, health1, health2, sixty1, sixty2, fortyfive1, fortyfive2, vaccineDate, totalRtpcr, todayRtpcr ;
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
        totalRtpcr = findViewById(R.id.totalrtpcr);
        todayRtpcr = findViewById(R.id.todayrtpcr);

        ApiStateUtil.getApiState().getStateStats().enqueue(new Callback<StateStats>() {
            @Override
            public void onResponse(Call<StateStats> call, Response<StateStats> response) {
                StateStats vac = response.body();
                List<StateStats> vlist = new ArrayList<>();
                vlist.addAll(vac.getTested());
                int lst = vlist.size();
                int registration = 0, dose1=0, dose2=0, fnt1=0, fnt2=0, hlth1=0, hlth2=0, xty1=0, xty2=0, forty1=0, forty2=0, ttlrtpcr, tdyrtpcr;
//                if (vlist.get(lst-1).getTotalindividualsregistered().equals("")){
//                    registration = Integer.parseInt(vlist.get(lst-2).getTotalindividualsregistered());
//                    dose1 = Integer.parseInt(vlist.get(lst-2).getFirstdoseadministered());
//                    dose2 = Integer.parseInt(vlist.get(lst-2).getSeconddoseadministered());
//                    fnt1 = Integer.parseInt(vlist.get(lst-2).getFrontlineworkersvaccinated1stdose());
//                    fnt2 = Integer.parseInt(vlist.get(lst-2).getFrontlineworkersvaccinated2nddose());
//                    hlth1 = Integer.parseInt(vlist.get(lst-2).getHealthcareworkersvaccinated1stdose());
//                    hlth2 = Integer.parseInt(vlist.get(lst-2).getHealthcareworkersvaccinated2nddose());
//                    xty1 = Integer.parseInt(vlist.get(lst-2).getOver60years1stdose());
//                    xty2 = Integer.parseInt(vlist.get(lst-2).getOver60years2nddose());
//                    forty1 = Integer.parseInt(vlist.get(lst-2).getOver45years1stdose());
//                    forty2 = Integer.parseInt(vlist.get(lst-2).getOver45years2nddose());
//                    vaccineDate.setText("Updated on "+vlist.get(lst-2).getUpdatetimestamp());
//                }else if (!vlist.get(lst-1).getTotalindividualsregistered().equals("")){
//                    registration = Integer.parseInt(vlist.get(lst-1).getTotalindividualsregistered().equals("")?"0":vlist.get(lst-1).getTotalindividualsregistered());
//                    dose1 = Integer.parseInt(vlist.get(lst-1).getFirstdoseadministered().equals("")?"0":vlist.get(lst-1).getFirstdoseadministered());
//                    dose2 = Integer.parseInt(vlist.get(lst-1).getSeconddoseadministered().equals("")?"0":vlist.get(lst-1).getSeconddoseadministered());
//                    fnt1 = Integer.parseInt(vlist.get(lst-1).getFrontlineworkersvaccinated1stdose().equals("")?"0":vlist.get(lst-1).getFrontlineworkersvaccinated1stdose());
//                    fnt2 = Integer.parseInt(vlist.get(lst-1).getFrontlineworkersvaccinated2nddose().equals("")?"0":vlist.get(lst-1).getFrontlineworkersvaccinated2nddose());
//                    hlth1 = Integer.parseInt(vlist.get(lst-1).getHealthcareworkersvaccinated1stdose().equals("")?"0":vlist.get(lst-1).getHealthcareworkersvaccinated1stdose());
//                    hlth2 = Integer.parseInt(vlist.get(lst-1).getHealthcareworkersvaccinated2nddose().equals("")?"0":vlist.get(lst-1).getHealthcareworkersvaccinated2nddose());
//                    xty1 = Integer.parseInt(vlist.get(lst-1).getOver60years1stdose().equals("")?"0":vlist.get(lst-1).getOver60years1stdose());
//                    xty2 = Integer.parseInt(vlist.get(lst-1).getOver60years2nddose().equals("")?"0":vlist.get(lst-1).getOver60years2nddose());
//                    forty1 = Integer.parseInt(vlist.get(lst-1).getOver45years1stdose().equals("")?"0":vlist.get(lst-1).getOver45years1stdose());
//                    forty2 = Integer.parseInt(vlist.get(lst-1).getOver45years2nddose().equals("")?"0":vlist.get(lst-1).getOver45years2nddose());
//                    vaccineDate.setText("Updated on "+vlist.get(lst-1).getUpdatetimestamp());
//                }else{
                vaccineDate.setText("Updated on "+vlist.get(lst-1).getUpdatetimestamp());
                ttlrtpcr = Integer.parseInt(vlist.get(lst-1).getTotalrtpcrsamplescollectedicmrapplication().equals("")?"0":vlist.get(lst-1).getTotalrtpcrsamplescollectedicmrapplication());
                tdyrtpcr = Integer.parseInt(vlist.get(lst-1).getDailyrtpcrsamplescollectedicmrapplication().equals("")?"0":vlist.get(lst-1).getDailyrtpcrsamplescollectedicmrapplication());
                dose1 = Integer.parseInt(vlist.get(lst-1).getFirstdoseadministered().equals("")?"0":vlist.get(lst-1).getFirstdoseadministered());
                dose2 = Integer.parseInt(vlist.get(lst-1).getSeconddoseadministered().equals("")?"0":vlist.get(lst-1).getSeconddoseadministered());

                int temp = lst;
                while(vlist.get(lst-1).getTotalindividualsregistered().equals("")){ // agar ye kaam nhi kiya toh upper wala uncomment kr dena
                        lst = lst-1;
                }
                registration = Integer.parseInt(vlist.get(lst-1).getTotalindividualsregistered().equals("")?"0":vlist.get(lst-1).getTotalindividualsregistered());

                lst = temp;
                while(vlist.get(lst-1).getFrontlineworkersvaccinated1stdose().equals("")){
                    lst = lst-1;
                }
                fnt1 = Integer.parseInt(vlist.get(lst-1).getFrontlineworkersvaccinated1stdose().equals("")?"0":vlist.get(lst-1).getFrontlineworkersvaccinated1stdose());
                fnt2 = Integer.parseInt(vlist.get(lst-1).getFrontlineworkersvaccinated2nddose().equals("")?"0":vlist.get(lst-1).getFrontlineworkersvaccinated2nddose());

                lst = temp;
                while(vlist.get(lst-1).getHealthcareworkersvaccinated1stdose().equals("")){
                    lst = lst-1;
                }
                hlth1 = Integer.parseInt(vlist.get(lst-1).getHealthcareworkersvaccinated1stdose().equals("")?"0":vlist.get(lst-1).getHealthcareworkersvaccinated1stdose());
                hlth2 = Integer.parseInt(vlist.get(lst-1).getHealthcareworkersvaccinated2nddose().equals("")?"0":vlist.get(lst-1).getHealthcareworkersvaccinated2nddose());

                lst = temp;
                while(vlist.get(lst-1).getOver60years1stdose().equals("")){
                    lst = lst-1;
                }
                xty1 = Integer.parseInt(vlist.get(lst-1).getOver60years1stdose().equals("")?"0":vlist.get(lst-1).getOver60years1stdose());
                xty2 = Integer.parseInt(vlist.get(lst-1).getOver60years2nddose().equals("")?"0":vlist.get(lst-1).getOver60years2nddose());

                lst = temp;
                while(vlist.get(lst-1).getOver45years1stdose().equals("")){
                    lst = lst-1;
                }
                forty1 = Integer.parseInt(vlist.get(lst-1).getOver45years1stdose().equals("")?"0":vlist.get(lst-1).getOver45years1stdose());
                forty2 = Integer.parseInt(vlist.get(lst-1).getOver45years2nddose().equals("")?"0":vlist.get(lst-1).getOver45years2nddose());

//                }

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
                totalRtpcr.setText(NumberFormat.getInstance().format(ttlrtpcr));
                todayRtpcr.setText("( +"+NumberFormat.getInstance().format(tdyrtpcr)+" )");

                vaccinePie.addPieSlice(new PieModel("Registered",registration,getResources().getColor(R.color.violet)));
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