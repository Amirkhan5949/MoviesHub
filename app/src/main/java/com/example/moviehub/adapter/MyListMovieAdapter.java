package com.example.moviehub.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviehub.R;
import com.example.moviehub.model.MyList;
import com.example.moviehub.room.DatabaseClient;
import com.example.moviehub.utils.Type;

import java.util.List;

public class MyListMovieAdapter extends RecyclerView.Adapter<MyListMovieAdapter.MyListMovieviewholder> {
    Context context;
    List<MyList> myLists;

    public MyListMovieAdapter(Context context, List<MyList> myLists) {
        this.context=context;
        this.myLists=myLists;
    }

    @NonNull
    @Override
    public MyListMovieviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.mylistmovie,parent,false);
        return new MyListMovieviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyListMovieviewholder holder, int position) {
        holder.listname.setText(myLists.get(position).getName());
        Log.i("cddfgf", "onBindViewHolder: "+myLists.get(position).getName());
        holder.mno.setText(myLists.get(position).getSize()+"");
        Log.i("fefdfdd", "onBindViewHolder: "+myLists.get(position).getSize()+"");
    }

    @Override
    public int getItemCount() {
        return myLists.size();
    }

    public class MyListMovieviewholder extends RecyclerView.ViewHolder {
        TextView mno,listname;
        ImageView imageavni;
        public MyListMovieviewholder(@NonNull View itemView) {
            super(itemView);
            mno=itemView.findViewById(R.id.mno);
            listname=itemView.findViewById(R.id.listname);
            imageavni=itemView.findViewById(R.id.imageavni);
        }
    }


}
