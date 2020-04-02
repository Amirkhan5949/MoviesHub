package com.example.moviehub.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviehub.R;
import com.example.moviehub.model.Result;
import com.example.moviehub.network.NetworkConstraint;
import com.example.moviehub.ui.activities.AllDetatilActivity;
import com.example.moviehub.utils.Type;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FrontPageAdapter extends RecyclerView.Adapter<FrontPageAdapter.RecyclerViewHolder> {
    Context  context;
     List<Result>list;
     Type.MovieOrTvshow type;


    public FrontPageAdapter(Context context, List<Result>list, Type.MovieOrTvshow type){
        this.context=context;
        this.list=list;
        this.type = type;
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

        holder.image.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(context, AllDetatilActivity.class);
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

                }
                context.startActivity(intent);

            }
        });

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
