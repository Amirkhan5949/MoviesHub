package com.example.moviehub.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.example.moviehub.network.NetworkConstraint;
import com.example.moviehub.R;
import com.squareup.picasso.Picasso;

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
