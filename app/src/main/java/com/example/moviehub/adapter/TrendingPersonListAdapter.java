package com.example.moviehub.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.moviehub.model.Result;
import com.example.moviehub.ui.activities.ProfileActivity;
import com.example.moviehub.network.NetworkConstraint;
import com.example.moviehub.R;
import com.example.moviehub.model.TrendingPersonDetail;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;


public class TrendingPersonListAdapter extends RecyclerView.Adapter<TrendingPersonListAdapter.TrendingRecyclerview>{
    Context context;
    List<Result> list;



    public TrendingPersonListAdapter(Context context, List<Result> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public TrendingRecyclerview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cast, parent, false);
        return new TrendingRecyclerview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingRecyclerview holder, int position) {

        Picasso.get().load(NetworkConstraint.IMAGE_BASE_URL + list.get(position).getProfile_path()).into(holder.circleimg);
        holder.name.setText(list.get(position).getName());
        if (list.get(position).getKnownForDepartment()!=null){
            holder.nickname.setText(list.get(position).getKnownForDepartment());
        }else holder.nickname.setVisibility(View.GONE);

        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("dnsdf", "onClick: " + list.get(position).getId());
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("id", list.get(position).getId() + "");
                intent.putExtra("name",list.get(position).getName()+"");
                intent.putExtra("photo",list.get(position).getProfile_path()+"");
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class TrendingRecyclerview extends RecyclerView.ViewHolder {
        CircleImageView circleimg;
        TextView name, nickname;
        LinearLayout linear;


        public TrendingRecyclerview(@NonNull View itemView) {
            super(itemView);
            circleimg = itemView.findViewById(R.id.circleimg);
            name = itemView.findViewById(R.id.name);
            nickname = itemView.findViewById(R.id.nickname);
            linear = itemView.findViewById(R.id.linear);
        }
    }

    public void addAllResult(List<Result> list){
        this.list.addAll(list);
        notifyItemRangeInserted(this.list.size() - list.size(),this.list.size());
        Log.i("ashbdha","saxghvashvx "+(this.list.size() - list.size())+" "+this.list.size() );
    }

}
