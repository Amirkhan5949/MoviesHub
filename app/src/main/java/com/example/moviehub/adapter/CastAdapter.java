package com.example.moviehub.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.moviehub.Activities.ProfileActivity;
import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.R;
import com.example.moviehub.model.Credit;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastRecyclerView> {

    Context context;
    List<Credit.Cast>list;

    public CastAdapter(Context context, List<Credit.Cast>list){
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public CastRecyclerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.cast,parent,false);
        return new CastRecyclerView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastRecyclerView holder, int position) {
        Picasso.get().load(NetworkConstraint.IMAGE_BASE_URL+list.get(position).getProfilePath()).into(holder.circleimg);
        holder.name.setText(list.get(position).getName());
        holder.nickname.setText(list.get(position).getCharacter());

        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ProfileActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CastRecyclerView extends RecyclerView.ViewHolder {

        CircleImageView circleimg;
        TextView name,nickname;
        LinearLayout linear;
     public CastRecyclerView(@NonNull View itemView) {
         super(itemView);
         circleimg=itemView.findViewById(R.id.circleimg);
         name=itemView.findViewById(R.id.name);
         nickname=itemView.findViewById(R.id.nickname);
         linear=itemView.findViewById(R.id.linear);

     }
 }
}
