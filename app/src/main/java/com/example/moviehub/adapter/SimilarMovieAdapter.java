package com.example.moviehub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.R;
import com.example.moviehub.model.SimilarMovie;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SimilarMovieAdapter extends RecyclerView.Adapter<SimilarMovieAdapter.SimlarMovieRecyclerView> {
    Context context;
    List<SimilarMovie.Result>list;

    public SimilarMovieAdapter(Context context,List<SimilarMovie.Result>list){
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public SimlarMovieRecyclerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater   inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.similarmovie,parent,false);
        return new SimlarMovieRecyclerView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimlarMovieRecyclerView holder, int position) {
        Picasso.get().load(NetworkConstraint.IMAGE_BASE_URL+list.get(position).getPosterPath()).into(holder.image);
        holder.year.setText(list.get(position).getReleaseDate());
        holder.name.setText(list.get(position).getTitle());
        holder.rating.setText(list.get(position).getVoteAverage().toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SimlarMovieRecyclerView extends RecyclerView.ViewHolder {
        ImageView image;
        TextView year,name,rating;
        public SimlarMovieRecyclerView(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            year=itemView.findViewById(R.id.year);
            name=itemView.findViewById(R.id.name);
            rating=itemView.findViewById(R.id.rating);
        }
    }
}
