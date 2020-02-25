package com.example.moviehub.ui.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.example.moviehub.R;
//import com.example.moviehub.adapter.MainSliderAdapter;


public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




//
//        class PicassoImageLoadingService implements ImageLoadingService {
//            public Context context;
//
//            public PicassoImageLoadingService(Context context) {
//                this.context = context;
//            }
//
//            @Override
//            public void loadImage(String url, ImageView imageView) {
//                Picasso.get().load(url).into(imageView);
//            }
//
//            @Override
//            public void loadImage(int resource, ImageView imageView) {
//                Picasso.get().load(resource).into(imageView);
//            }
//
//            @Override
//            public void loadImage(String url, int placeHolder, int errorDrawable, ImageView imageView) {
//                Picasso.get().load(url).placeholder(placeHolder).error(errorDrawable).into(imageView);
//            }
//        }
//
//        Slider.init((ImageLoadingService) PicassoImageLoadingService);
//        banner_slider1.setAdapter(new TrendingPersonAdapter(MainActivity.this,));







    }


}
