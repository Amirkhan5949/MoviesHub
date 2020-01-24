package com.example.moviehub.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.R;
import com.squareup.picasso.Picasso;

public class ZoomImageActivity extends AppCompatActivity {

    ImageView zoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_image);

       String pic= getIntent().getStringExtra("profile");

        zoom=findViewById(R.id.zoom);
        Picasso.get().load(NetworkConstraint.Image_Org+pic).into(zoom);

        zoom.setOnTouchListener(new ImageMatrixTouchHandler(this));
    }
}
