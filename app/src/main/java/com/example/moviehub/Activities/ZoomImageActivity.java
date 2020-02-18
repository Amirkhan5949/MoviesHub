package com.example.moviehub.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.R;
import com.example.moviehub.adapter.ImagesAdapter;
import com.example.moviehub.model.PersonImages;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ZoomImageActivity extends AppCompatActivity {

    ImageView zoom;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_image);

       String pic= getIntent().getStringExtra("profile");

        zoom=findViewById(R.id.zoom);
        pager=findViewById(R.id.pager);
        Picasso.get().load(NetworkConstraint.Image_Org+pic).into(zoom);

        zoom.setOnTouchListener(new ImageMatrixTouchHandler(this));
//        zoom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(ZoomImageActivity.this,MoviePosterActivity.class);
//
//            }
//        });
     }
}
