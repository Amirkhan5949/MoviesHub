package com.example.moviehub.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.moviehub.Activities.CelebritiesActivity;
import com.example.moviehub.Network.CrewRequest;
import com.example.moviehub.Network.MovieInfoRequest;
import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.Network.RetrofitClient;
import com.example.moviehub.Network.YoutubeRequest;
import com.example.moviehub.R;
import com.example.moviehub.adapter.CrewAdapter;
import com.example.moviehub.adapter.GenreAdapter;
import com.example.moviehub.adapter.TrailorAdapter;
import com.example.moviehub.model.Credit;
import com.example.moviehub.model.MovieInfo;
import com.example.moviehub.model.YoutubeConnect;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.DialogPlusBuilder;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {
    View view;
    RecyclerView genre, crew, trailor;
    ImageView smallimage, largeimage;
    TextView year,timing,review, showall, number, poster, no, backdrops, moviename, released, runtime, date, language, inwest, earn, production;
    String s = "";



    public InfoFragment(String s ) {
         this.s =s;


    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_info, container, false);

        genre = view.findViewById(R.id.genre);
        crew = view.findViewById(R.id.crew);
        trailor = view.findViewById(R.id.trailor);




        genre.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        crew.setLayoutManager(new GridLayoutManager(getContext(), 2));


        trailor.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        smallimage = view.findViewById(R.id.smallimage);
        largeimage = view.findViewById(R.id.largeimage);
        year=view.findViewById(R.id.year);
        timing=view.findViewById(R.id.timing);


        review = view.findViewById(R.id.review);
        showall = view.findViewById(R.id.showall);
        number = view.findViewById(R.id.number);
        poster = view.findViewById(R.id.poster);
        no = view.findViewById(R.id.no);
        backdrops = view.findViewById(R.id.backdrops);

        moviename = view.findViewById(R.id.moviename);
        released = view.findViewById(R.id.released);
        runtime = view.findViewById(R.id.runtime);
        date = view.findViewById(R.id.date);
        language = view.findViewById(R.id.language);
        inwest = view.findViewById(R.id.inwest);
        earn = view.findViewById(R.id.earn);
        production = view.findViewById(R.id.production);



        showall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), CelebritiesActivity.class);
                intent.putExtra("id",s);
                getContext().startActivity(intent);

            }
        });




        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MovieInfoRequest.class)
                .getmovierequest(s,NetworkConstraint.key)
                .enqueue(new Callback<MovieInfo>() {
                    @Override
                    public void onResponse(Call<MovieInfo> call, Response<MovieInfo> response) {
                        {

                            Log.i("adadczc", "onResponse: " + response.body().getOverview());
                            Log.i("adadczc", "onResponse: " + response.body());
                            review.setText(response.body().getOverview());
                            moviename.setText(response.body().getOriginalTitle());
                            language.setText(response.body().getOriginalLanguage());
                            released.setText(response.body().getStatus());
                            runtime.setText(response.body().getRuntime().toString());
                            date.setText(response.body().getReleaseDate());
                            inwest.setText(response.body().getBudget().toString());
                            earn.setText(response.body().getRevenue().toString());


                            Log.i("sccccccdscsds", "onResponse: "+response.body().getReleaseDate());
                            Picasso.get().load(NetworkConstraint.IMAGE_BASE_URL + response.body().getPosterPath()).into(smallimage);
                            Picasso.get().load(NetworkConstraint.Image_URL + response.body().getBackdropPath()).into(largeimage);
                            Log.i("xaxxxxad", "onResponse: " +response.body().getBackdropPath()) ;

                            GenreAdapter adapter = new GenreAdapter(getContext(), response.body().getGenres());
                            genre.setAdapter(adapter);


                            String name = "";
                            for (MovieInfo.ProductionCompany x : response.body().getProductionCompanies()) {
                                name = name + x.getName() + ",";
                                Log.i("adsfs", "onResponse: " + name);
                            }

                            production.setText(name.substring(0, name.length() - 1) + ".");

                            String a=response.body().getReleaseDate();
                            String b=a.substring(0,4);
                            year.setText(b);

                            int t= Integer.parseInt(response.body().getRuntime().toString());


                            int hours = t / 60; //since both are ints, you get an int
                            int minutes = t % 60;
                            System.out.printf("%d:%02d", hours, minutes);


                            timing.setText(hours +" hours "+minutes+" minutes");



                            Log.i("sdssc", "onResponse: "+b);

                        }

                    }

                    @Override
                    public void onFailure(Call<MovieInfo> call, Throwable t) {
                        Log.i("adadczc", "onFailure: " + t.getMessage());

                    }
                });

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(CrewRequest.class)
                .getCrewRequest(s,NetworkConstraint.key)
                .enqueue(new Callback<Credit>() {
                    @Override
                    public void onResponse(Call<Credit> call, Response<Credit> response) {
                        CrewAdapter adapter = new CrewAdapter(getContext(), response.body().getCrew());
                        crew.setAdapter(adapter);

                        Log.i("dadada", "onResponse: " + response.body().getCrew());

                    }

                    @Override
                    public void onFailure(Call<Credit> call, Throwable t) {

                    }
                });

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(YoutubeRequest.class)
                .getYoutubeRequest(s,NetworkConstraint.key)
                .enqueue(new Callback<YoutubeConnect>() {
                    @Override
                    public void onResponse(Call<YoutubeConnect> call, Response<YoutubeConnect> response) {

                        Log.i("jhjbjh", "onResponse: ");

                        TrailorAdapter adapter = new TrailorAdapter(getContext(), response.body().getResults());
                        trailor.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(Call<YoutubeConnect> call, Throwable t) {

                    }
                });


         return view;
    }


}
