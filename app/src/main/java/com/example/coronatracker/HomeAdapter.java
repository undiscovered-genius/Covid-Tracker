package com.example.coronatracker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.homeViewHolder> {

    List<String> titles;
    List<Integer> images;
    LayoutInflater inflater;

    public HomeAdapter(Context cxt, List<String> titles, List<Integer> images){
        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(cxt);
    }

    @NonNull
    @Override
    public homeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.home_item_layout,parent,false);
        return new homeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull homeViewHolder holder, int position) {
        homeViewHolder viewHolder = (homeViewHolder) holder;
        viewHolder.textView.setText(titles.get(position));
        viewHolder.imageView.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class homeViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public homeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itemLogo);
            textView = itemView.findViewById(R.id.homeItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (textView.getText() == "Worldwide Tracker"){
                        Intent display = new Intent(v.getContext(),MainActivity.class);
                        v.getContext().startActivity(display);
                    }else if (textView.getText() == "Statewise Tracker"){
                        Intent display = new Intent(v.getContext(),StateActivity.class);
                        v.getContext().startActivity(display);

                    }else if (textView.getText() == "Vaccination Tracker"){
                        Intent display = new Intent(v.getContext(),VaccinationActivity.class);
                        v.getContext().startActivity(display);
//                        Toast.makeText(v.getContext(),"Comming Soon!",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
