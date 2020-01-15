package com.example.moviehub.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.R;
import com.example.moviehub.model.Trending;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FrontPageAdapter extends RecyclerView.Adapter<FrontPageAdapter.RecyclerViewHolder> {
    Context  context;
    List<Trending.Result>list;

    public FrontPageAdapter(Context context, List<Trending.Result>list){
        this.context=context;
        this.list=list;

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.view,parent,false);
        return new RecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        Log.i("csccc", "onBindViewHolder: ");

        Picasso.get().load(NetworkConstraint.IMAGE_BASE_URL+list.get(position).getPosterPath()).into(holder.image);
        Log.i("sczczc", "onBindViewHolder: "+NetworkConstraint.BASE_URL+list.get(position).getPosterPath());


        Log.i("csccc", "onBindViewHolder: "+list.get(position).getTitle());

        if(list.get(position).getTitle()==null){
            holder.name.setText(list.get(position).getName());
        }
        else{
            holder.name.setText(list.get(position).getTitle());
        }

        holder.id.setText(list.get(position).getVoteAverage().toString());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView id;


        TextView name;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.name);
            id=itemView.findViewById(R.id.id);
        }
    }
}
