package com.example.moviehub.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.moviehub.Activities.ZoomImageActivity;
import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.R;
import com.example.moviehub.model.PersonDetail;
import com.example.moviehub.model.PersonImages;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImageRecycleView> {
    Context context;
    List<PersonImages.Profile>list;

    public ImagesAdapter(Context context,  List<PersonImages.Profile>list){
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public ImageRecycleView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.image,parent,false);
        return new ImageRecycleView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageRecycleView holder, int position) {
        Picasso.get().load(NetworkConstraint.Image_URL+list.get(position).getFilePath()).into(holder.pictures);
        holder.pictures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ZoomImageActivity.class);
                intent.putExtra("profile",list.get(position).getFilePath()+"");
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ImageRecycleView extends RecyclerView.ViewHolder {
       ImageView pictures;
        public ImageRecycleView(@NonNull View itemView) {
            super(itemView);
            pictures=itemView.findViewById(R.id.pictures);
        }
    }
}
