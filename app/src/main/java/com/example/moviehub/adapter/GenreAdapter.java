package com.example.moviehub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moviehub.R;
import com.example.moviehub.model.MovieInfo;

import java.security.AccessController;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static java.security.AccessController.*;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.GenreViewHolder> {
    Context context;
    List<MovieInfo.Genre>list;
    public GenreAdapter(Context context,List<MovieInfo.Genre>list){
        this.context=context;
        this.list=list;

    }
    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.movieinfo,parent,false);
        return new GenreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder holder, int position) {
        holder.crime.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class GenreViewHolder extends RecyclerView.ViewHolder {
        TextView  crime;
        public GenreViewHolder(@NonNull View itemView)
        {
            super(itemView);
            crime=itemView.findViewById(R.id.crime);
        }
    }
}