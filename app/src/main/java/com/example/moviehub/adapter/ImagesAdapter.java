package com.example.moviehub.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.moviehub.model.ImageData;
import com.example.moviehub.ui.activities.MoviePosterActivity;
import com.example.moviehub.ui.activities.ZoomImageActivity;
import com.example.moviehub.network.NetworkConstraint;
import com.example.moviehub.R;
import com.example.moviehub.model.PersonImages;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImageRecycleView> {
    Context context;
    List<ImageData> list;

    public ImagesAdapter(Context context,  List<ImageData>list){
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
                Intent intent=new Intent(context, MoviePosterActivity.class);
                intent.putExtra("images",(ArrayList<ImageData>) (list));
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
