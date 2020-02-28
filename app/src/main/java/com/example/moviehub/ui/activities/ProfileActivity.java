package com.example.moviehub.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.moviehub.network.Externalids;
import com.example.moviehub.network.NetworkConstraint;
import com.example.moviehub.network.RetrofitClient;
import com.example.moviehub.R;
import com.example.moviehub.adapter.ProfileAdapter;
import com.example.moviehub.model.PersonExternalDetail;
import com.example.moviehub.utils.Type;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {
    TabLayout tablayout;
    ViewPager viewPage;
    TextView name;
    ImageView fb,twitter,insta,imdb,fullimage,circleimage;
    TextView title_1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fb=findViewById(R.id.fb);
        twitter=findViewById(R.id.twitter);
        insta=findViewById(R.id.insta);
        imdb=findViewById(R.id.imdb);

        circleimage=findViewById(R.id.circleimage);
        name=findViewById(R.id.name);

        setUpAppBar1();


        tablayout=findViewById(R.id.tablayout);
        viewPage=findViewById(R.id.viewpage);
       String a= getIntent().getStringExtra("id");
        String nam= getIntent().getStringExtra("name");
        String photo= getIntent().getStringExtra("photo");
        Type.MovieOrTvshow type = (Type.MovieOrTvshow) getIntent().getSerializableExtra("type");

        Log.i("dadsdsw", "onCreate: "+a);

        Log.i("ssfsfs", "onCreate: "+name);
        Log.i("ssfsfs", "onCreate: "+photo);


        name.setText(nam);
        Picasso.get().load(NetworkConstraint.Image_URL+photo).into(circleimage);


        viewPage.setAdapter(new ProfileAdapter(a,getSupportFragmentManager()));
        tablayout.setupWithViewPager(viewPage);

        Log.i("scsfs", "onCreate: "+a);


        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(Externalids.class)
                .getExternal(a,NetworkConstraint.key)
                .enqueue(new Callback<PersonExternalDetail>() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void onResponse(Call<PersonExternalDetail> call, Response<PersonExternalDetail> response) {

                        if (response.body().getFacebookId()==null)
                            fb.setColorFilter(ContextCompat.getColor(ProfileActivity.this, R.color.gray));

                        else {
                            fb.setColorFilter(ContextCompat.getColor(ProfileActivity.this, R.color.white));
                            fb.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"+response.body().getFacebookId()));
                                    startActivity(browserIntent);
                                }
                            });
                        }

                        if (response.body().getImdbId()==null)
                            imdb.setColorFilter(ContextCompat.getColor(ProfileActivity.this, R.color.gray));
                        else{
                            imdb.setColorFilter(ContextCompat.getColor(ProfileActivity.this, R.color.white));

                            imdb.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.imdb.com/name/"+response.body().getImdbId()));
                                    startActivity(browserIntent);
                                }
                            });
                        }

                        if (response.body().getTwitterId()==null)
                            twitter.setColorFilter(ContextCompat.getColor(ProfileActivity.this, R.color.gray));
                        else{
                            twitter.setColorFilter(ContextCompat.getColor(ProfileActivity.this, R.color.white));
                            twitter.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/"+response.body().getTwitterId()));
                                    startActivity(browserIntent);
                                }
                            });
                        }
                        if (response.body().getInstagramId()==null)
                            insta.setColorFilter(ContextCompat.getColor(ProfileActivity.this, R.color.gray));
                        else{
                            insta.setColorFilter(ContextCompat.getColor(ProfileActivity.this, R.color.white));
                            insta.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"+response.body().getInstagramId()));
                                    startActivity(browserIntent);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFailure(Call<PersonExternalDetail> call, Throwable t) {

                    }
                });
    }

    private void setUpAppBar1() {
        LinearLayout layout = findViewById(R.id.layout);
        title_1 = findViewById(R.id.title_1);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.BaseOnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
                int min_height = ViewCompat.getMinimumHeight(collapsingToolbarLayout) * 2;
                float scale =  ((float)(min_height + verticalOffset) / min_height);

                layout.setScaleX(scale >= 0? scale : 0f);
                layout.setScaleY((scale >= 0) ? scale : 0f);
                layout.setPivotY(200f);

                float f = (float)(Math.abs(verticalOffset / appBarLayout.getTotalScrollRange()));

               if(f>=0.70F&&f<=1){
                   if(title_1.getVisibility()!= View.VISIBLE){
                       title_1.setVisibility(View.VISIBLE);
                   }
                   title_1.setAlpha(f);
               }

               else if(f>=0 &&  f<= 0.70){
                   if(title_1.getVisibility()== View.VISIBLE){
                      // title_1.setVisibility(View.GONE);
                   }
                   title_1.setAlpha(f);

               }
            }
        });
    }

//    private void setUpAppBar() {
//        ((AppBarLayout)(findViewById(R.id.app_bar_layout) ).addOnOffsetChangedListener(
//                object : AppBarLayout.OnOffsetChangedListener {
//            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
//                val min_height: Int = ViewCompat.getMinimumHeight(collapsing_toolbar) * 2
//                val scale = (min_height + verticalOffset).toFloat() / min_height
//
//                layout.setScaleX(if (scale >= 0) scale else 0f)
//                layout.setScaleY(if (scale >= 0) scale else 0f)
//                layout.setPivotY(200f)
//
//                when (Math.abs(verticalOffset / appBarLayout.totalScrollRange.toFloat())) {
//                    in 0.70F..1F -> {
//                        title_1.apply {
//                            if (visibility != View.VISIBLE)
//                                visibility = View.VISIBLE
//
//                            alpha = (Math.abs(verticalOffset / appBarLayout.totalScrollRange.toFloat()))
//                            //animate().setDuration(1000).alpha(Math.abs(verticalOffset / appBarLayout.totalScrollRange.toFloat())/0.5f)
//                        }
//                    }
//
//                    in 0F..0.70F -> {
//                        title_1.apply {
//                            if (visibility == View.VISIBLE)
//                                visibility = View.GONE
//                            animate().setDuration(0).alpha(Math.abs(verticalOffset / appBarLayout.totalScrollRange.toFloat())/0.5f)
//                        }
//                    }
//
//                }
//
//            }
//        }
//        )
//    }

}
