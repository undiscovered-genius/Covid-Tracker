package com.example.coronatracker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.coronatracker.api.CountryStats;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.countryViewHolder> {
    private Context context;
    private List<CountryStats> list;

    public CountryAdapter(Context context, List<CountryStats> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public countryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.country_item_layout,parent,false);

        return new countryViewHolder(view);
    }

    public void countryList(List<CountryStats> conList){
        list = conList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull countryViewHolder holder, int position) {

            CountryStats data = list.get(position);
            holder.countryCases.setText(NumberFormat.getInstance().format(Integer.parseInt(data.getCases())));
            holder.countryName.setText(data.getCountry());
            holder.srno.setText(String.valueOf(position+1));
            Map<String, String> img = data.getCountryInfo();
            Glide.with(context).load(img.get("flag")).into(holder.imageView);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.putExtra("country",data.getCountry());
                    context.startActivity(intent);
                }
            });


    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class countryViewHolder extends RecyclerView.ViewHolder{

        private TextView srno,countryName, countryCases;
        private ImageView imageView;
        public countryViewHolder(@NonNull View itemView) {
            super(itemView);
            srno = itemView.findViewById(R.id.srno);
            countryName = itemView.findViewById(R.id.countryName);
            countryCases = itemView.findViewById(R.id.cases);
            imageView = itemView.findViewById(R.id.flag);
        }
    }
}
