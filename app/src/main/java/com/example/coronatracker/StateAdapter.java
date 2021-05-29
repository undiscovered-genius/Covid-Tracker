package com.example.coronatracker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronatracker.api.StateStats;

import java.text.NumberFormat;
import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.stateViewHolder> {
    private Context context;
    private List<StateStats> list;

    public StateAdapter(Context context, List<StateStats> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public stateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.state_item_layout,parent,false);

        return new StateAdapter.stateViewHolder(view);
    }

    public void stateList(List<StateStats> conList){
        list = conList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull stateViewHolder holder, int position) {
        StateStats data = list.get(position);
        holder.stateCases.setText(NumberFormat.getInstance().format(Integer.parseInt(data.getConfirmed())));
        holder.stateName.setText(data.getState());
        holder.sno.setText(String.valueOf(position+1));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StateActivity.class);
                intent.putExtra("state",data.getState());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class stateViewHolder extends RecyclerView.ViewHolder{
        private TextView sno,stateName, stateCases;
        public stateViewHolder(@NonNull View itemView) {
            super(itemView);
            sno = itemView.findViewById(R.id.sno);
            stateName = itemView.findViewById(R.id.stateName);
            stateCases = itemView.findViewById(R.id.stateCases);
        }
    }
}
