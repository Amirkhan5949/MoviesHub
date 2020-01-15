package com.example.moviehub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CrewAdapter extends RecyclerView.Adapter<CrewAdapter.CrewRecyclerView>{
    Context context;

    public CrewAdapter(Context context){
        this.context=context;

    }
    @NonNull
    @Override
    public CrewRecyclerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater=LayoutInflater.from(parent,getcontext());
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CrewRecyclerView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CrewRecyclerView extends RecyclerView.ViewHolder {
        public CrewRecyclerView(@NonNull View itemView) {
            super(itemView);
        }
    }
}
