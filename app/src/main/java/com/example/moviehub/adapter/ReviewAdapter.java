package com.example.moviehub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moviehub.R;
import com.example.moviehub.model.Reviews;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewRecylerView>{
    Context context;
    List<Reviews.Result>list;

    public ReviewAdapter(Context context,List<Reviews.Result>list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ReviewRecylerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.review,parent,false);
        return new ReviewRecylerView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewRecylerView holder, int position) {
        holder.name.setText(list.get(position).getAuthor());
        holder.moviereview.setText(list.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ReviewRecylerView extends RecyclerView.ViewHolder {
        TextView name,moviereview;
        public ReviewRecylerView(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            moviereview=itemView.findViewById(R.id.moviereview);
        }
    }
}
