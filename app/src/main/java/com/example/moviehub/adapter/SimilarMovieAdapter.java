package com.example.moviehub.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.moviehub.network.NetworkConstraint;
import com.example.moviehub.ui.activities.AllDetatilActivity;
import com.example.moviehub.R;
import com.example.moviehub.model.Result;
import com.example.moviehub.utils.Type;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SimilarMovieAdapter extends RecyclerView.Adapter<SimilarMovieAdapter.SimlarMovieRecyclerView> {
    Context context;
    List<Result>list;

    Type.MovieOrTvshow type;

    public SimilarMovieAdapter(Context context,List<Result>list,Type.MovieOrTvshow type){
        this.context=context;
        this.list=list;
        this.type=type;
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


        String a=list.get(position).getReleaseDate();
        if (a!=null&&a.length()>5){
            String b=a.substring(0,4);
            holder.year.setText(b);
        }



        if(type==Type.MovieOrTvshow.MOVIE)
            holder.name.setText(list.get(position).getTitle());
        else
            holder.name.setText(list.get(position).getOriginal_name());

        holder.rating.setText(list.get(position).getVoteAverage().toString());

        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, AllDetatilActivity.class);
                intent.putExtra("id",list.get(position).getId()+"");
                intent.putExtra("type",type);
                if (list.get(position).getTitle()==null){
                    intent.putExtra("name",list.get(position).getName()+"");
                }else if (list.get(position).getTitle()!=null){
                    intent.putExtra("name",list.get(position).getTitle()+"");
                }else if (list.get(position).getOriginal_name()==null){
                    intent.putExtra("name",list.get(position).getOriginalTitle()+"");
                }
                else if (list.get(position).getOriginal_name()!=null){
                    intent.putExtra("name",list.get(position).getOriginal_name()+"");

                }                 context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SimlarMovieRecyclerView extends RecyclerView.ViewHolder {
        ImageView image;
        TextView year,name,rating;
        LinearLayout ll;
        public SimlarMovieRecyclerView(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            year=itemView.findViewById(R.id.year);
            name=itemView.findViewById(R.id.name);
            rating=itemView.findViewById(R.id.rating);
            ll=itemView.findViewById(R.id.ll);
        }
    }


    public void addAllResult(List<Result> list){
        this.list.addAll(list);
        notifyItemRangeInserted(this.list.size() - list.size(),this.list.size());
        Log.i("ashbdha","saxghvashvx "+(this.list.size() - list.size())+" "+this.list.size() );
    }

}
