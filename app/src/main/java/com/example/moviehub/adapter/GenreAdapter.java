package com.example.moviehub.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moviehub.ui.activities.MovieCatagoryActivity;
import com.example.moviehub.R;
import com.example.moviehub.model.MovieInfo;
import com.example.moviehub.utils.Type;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.GenreViewHolder> {
    Context context;
    List<MovieInfo.Genre>list;
    Type.MovieOrTvshow type;


    public GenreAdapter(Context context,List<MovieInfo.Genre>list, Type.MovieOrTvshow type){
        this.context=context;
        this.list=list;
        this.type=type;



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

        String a=list.get(position).getId()+"";

        holder.crime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, MovieCatagoryActivity.class);
                intent.putExtra("id",a);
                intent.putExtra("mixlisttype", Type.MixListType.GENRE);
                intent.putExtra("type",type);

                context.startActivity(intent);
             }
        });

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
