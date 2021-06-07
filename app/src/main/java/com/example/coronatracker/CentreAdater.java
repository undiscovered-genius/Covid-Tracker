package com.example.coronatracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CentreAdater extends RecyclerView.Adapter<CentreAdater.centreViewHolder> {
    List<String> name;
    List<String> vaccine;
    List<String> fee;
    List<String> age;
    List<String> dose;
    List<String> dose1;
    List<String> dose2;
    List<String> time;
    LayoutInflater inflater;

    public CentreAdater(Context cxt,List<String> name, List<String> vaccine, List<String> fee, List<String> age, List<String> dose, List<String> dose1, List<String> dose2, List<String> time){

        this.name = name;
        this.vaccine = vaccine;
        this.fee = fee;
        this.age = age;
        this.dose = dose;
        this.dose1 = dose1;
        this.dose2 = dose2;
        this.time = time;
        this.inflater = LayoutInflater.from(cxt);
    }

    @NonNull
    @Override
    public centreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.centre_item_layout,parent,false);
        return new centreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull centreViewHolder holder, int position) {
        centreViewHolder viewHolder = (centreViewHolder) holder;
        viewHolder.centre.setText(name.get(position));
        viewHolder.vac.setText(vaccine.get(position));
        viewHolder.fee.setText(fee.get(position));
        viewHolder.age.setText(age.get(position)+"+");
        viewHolder.dose.setText(dose.get(position));
        viewHolder.dose1.setText(dose1.get(position));
        viewHolder.dose2.setText(dose2.get(position));
        viewHolder.time.setText(time.get(position));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class centreViewHolder extends RecyclerView.ViewHolder{

        TextView centre, vac, fee, age, dose, dose1, dose2,time;

        public centreViewHolder(@NonNull View itemView) {
            super(itemView);
            centre = itemView.findViewById(R.id.centreName);
            vac = itemView.findViewById(R.id.centreVaccine);
            fee = itemView.findViewById(R.id.centreFee);
            age = itemView.findViewById(R.id.centreAge);
            dose = itemView.findViewById(R.id.centreDose);
            dose1 = itemView.findViewById(R.id.centreDose1);
            dose2 = itemView.findViewById(R.id.centreDose2);
            time = itemView.findViewById(R.id.centreTime);
        }
    }
}
