package com.example.moviehub.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.moviehub.ui.activities.ProfileActivity;
import com.example.moviehub.network.NetworkConstraint;
import com.example.moviehub.R;
import com.example.moviehub.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class TrendingPersonAdapter extends RecyclerView.Adapter<TrendingPersonAdapter.Personview> {
    Context context;
    List<Result> list;

    public TrendingPersonAdapter(Context context, List<Result> list ){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public Personview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.circle,parent,false);

        return new Personview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Personview holder, int position) {

        holder.trendingname.setText(list.get(position).getName());
        Log.i("sffdfdfd", "onBindViewHolder: "+list.get(position).getId());
        Picasso.get().load(NetworkConstraint.Image_URL+list.get(position).getProfile_path()).into(holder.circleImageView);

        holder.llayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
                    Intent intent = new Intent(context, ProfileActivity.class);
                    intent.putExtra("id", list.get(position).getId()+"");
                    intent.putExtra("name",list.get(position).getName()+"");
                    intent.putExtra("photo",list.get(position).getProfile_path()+"");

                     context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Personview extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;
        TextView trendingname;
        LinearLayout llayout;
        public Personview(@NonNull View itemView) {
            super(itemView);
            circleImageView=itemView.findViewById(R.id.circleimage);
            trendingname=itemView.findViewById(R.id.trendingname);
            llayout=itemView.findViewById(R.id.llayout);
        }

    }
}
