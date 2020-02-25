package com.example.moviehub.ui.fragments;


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

import com.example.moviehub.ui.activities.CelebritiesActivity;
import com.example.moviehub.ui.activities.MoviePosterActivity;
import com.example.moviehub.network.MoviesPic;
import com.example.moviehub.network.MoviesRequest;
import com.example.moviehub.network.NetworkConstraint;
import com.example.moviehub.network.RetrofitClient;
import com.example.moviehub.network.TvShowRequest;
import com.example.moviehub.R;
import com.example.moviehub.adapter.CrewAdapter;
import com.example.moviehub.adapter.GenreAdapter;
import com.example.moviehub.adapter.TrailorAdapter;
import com.example.moviehub.model.Credit;
import com.example.moviehub.model.MovieImages;
import com.example.moviehub.model.MovieInfo;
import com.example.moviehub.model.YoutubeConnect;
import com.example.moviehub.utils.Type;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {
    View view;
    View viewer;
    RecyclerView genre, crew, trailor;
    ImageView smallimage, largeimage;
    TextView year,train, timing, review, showall, number, poster, no, backdrops, moviename, released, runtime, date, language, inwest, earn, production;
    String s = "";
    Type.MovieOrTvshow type;
    LinearLayout crewlayout,post,back,layout;



    public InfoFragment(String s, Type.MovieOrTvshow type) {
        this.s = s;
        this.type = type;



    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_info, container, false);

        genre = view.findViewById(R.id.genre);
        crew = view.findViewById(R.id.crew);
        trailor = view.findViewById(R.id.trailor);
        post = view.findViewById(R.id.post);
        back = view.findViewById(R.id.back);
        train = view.findViewById(R.id.train);
        viewer = view.findViewById(R.id.view);


        genre.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        crew.setLayoutManager(new GridLayoutManager(getContext(), 2));
        trailor.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        smallimage = view.findViewById(R.id.smallimage);
        largeimage = view.findViewById(R.id.largeimage);
        year = view.findViewById(R.id.year);
        timing = view.findViewById(R.id.timing);


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

        crewlayout = view.findViewById(R.id.crewlayout);
        layout = view.findViewById(R.id.layout);


        showall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), CelebritiesActivity.class);
                intent.putExtra("id", s);
                intent.putExtra("type", type);
                intent.putExtra("creditType", Type.Credit.CREW);

                getContext().startActivity(intent);

            }
        });

        if (type == Type.MovieOrTvshow.MOVIE)
            getmoviepics();
        else
            gettvpics();




        if (type == Type.MovieOrTvshow.MOVIE) {
            getMovie();
            Log.i("dsdddww", "onCreateView: "+type);
        }
        else {
            getTvShow();
            Log.i("dsdddww", "onCreateView: "+type);
        }

        return view;
    }


    private void gettvpics(){
        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MoviesPic.class)
                .getTvpic(s,NetworkConstraint.key)
                .enqueue(new Callback<MovieImages>() {
                    @Override
                    public void onResponse(Call<MovieImages> call, Response<MovieImages> response) {
                        if (response.body()!=null){
                            layout.setVisibility(View.VISIBLE);
                        }

                        if (response.body()!=null){
                            if (response.body().getData().size()!=0){
                                number.setText(response.body().getData().size()+"");
                                no.setText(response.body().getBackdrops().size()+"");
                                Log.i("dwdsffd", "onResponse: "+response.toString()+"");

                            }

                        }

                        back.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getContext(), MoviePosterActivity.class);
                                intent.putExtra("images",(ArrayList<MovieImages.Data>) (response.body().getBackdrops()));
                                startActivity(intent);
                            }
                        });


                        post.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getContext(), MoviePosterActivity.class);
                                intent.putExtra("images",(ArrayList<MovieImages.Data>) (response.body().getData()));
                                startActivity(intent);
                            }
                        });
                    }


                    @Override
                    public void onFailure(Call<MovieImages> call, Throwable t) {
                        Log.i("dwdsffd", "onResponse: "+t.toString()+"");
                    }
                });
    }

    private void getmoviepics(){

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MoviesPic.class)
                .getMoviespic(s,NetworkConstraint.key)
                .enqueue(new Callback<MovieImages>() {
                    @Override
                    public void onResponse(Call<MovieImages> call, Response<MovieImages> response) {
                        if (response.body()!=null){
                            if (response.body()==null)
                                layout.setVisibility(View.GONE);
                            else
                                layout.setVisibility(View.VISIBLE);
                            number.setText(response.body().getData().size()+"");
                            no.setText(response.body().getBackdrops().size()+"");

                            post.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(getContext(), MoviePosterActivity.class);
                                    intent.putExtra("images",(ArrayList<MovieImages.Data>) (response.body().getData()));
                                    startActivity(intent);
                                }

                            });

                            back.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(getContext(), MoviePosterActivity.class);
                                    intent.putExtra("images",(ArrayList<MovieImages.Data>) (response.body().getBackdrops()));
                                    startActivity(intent);
                                    Log.i("cfdffs", "onClick: "+response.body().getBackdrops());

                                }
                            });




//                        Log.i("djvknv", "onResponse: "+response.body().getData().size());
                            Log.i("djvknv", "onResponse: "+response.body() );
                        }
                        }


                    @Override
                    public void onFailure(Call<MovieImages> call, Throwable t) {
                        Log.i("scdd", "onFailure: "+t.getMessage());

                    }
                });


    }


    private void getTvShow() {

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(TvShowRequest.class)
                .gettvrequest(s, NetworkConstraint.key)
                .enqueue(new Callback<MovieInfo>() {
                    @Override
                    public void onResponse(Call<MovieInfo> call, Response<MovieInfo> response) {
                        {
                            if (response.body()!=null){

                                Log.i("dhsgdhsgfv", "onResponse: " + response.toString());
                                Log.i("dhsgdhsgfv", "onResponse: " + response.body());
                                review.setText(response.body().getOverview());


                                if (type == Type.MovieOrTvshow.TVSHOW) {
                                    moviename.setText(response.body().getOriginal_name().toString());
                                }
                                language.setText(response.body().getOriginalLanguage());
                                released.setText(response.body().getStatus());
                                if (response.body().getEpisode_run_time().size()!=0){
                                    runtime.setText(response.body().getEpisode_run_time().get(0)+"");

                                }
                                date.setText(response.body().getFirst_air_date());

                                Log.i("sccccccdscsds", "onResponse: " + response.body().getReleaseDate());
                                Picasso.get().load(NetworkConstraint.IMAGE_BASE_URL + response.body().getPosterPath()).into(smallimage);
                                Picasso.get().load(NetworkConstraint.Image_URL + response.body().getBackdropPath()).into(largeimage);
                                Log.i("xaxxxxad", "onResponse: " + response.body().getBackdropPath());

                                GenreAdapter adapter = new GenreAdapter(getContext(), response.body().getGenres(), Type.MovieOrTvshow.TVSHOW);
                                genre.setAdapter(adapter);


                                String name = "";
                                for (MovieInfo.ProductionCompany x : response.body().getProductionCompanies()) {
                                    name = name + x.getName() + ",";
                                    Log.i("sscscsc", "onResponse: " + name);
                                }


                                if (name.length()!=0){
                                    production.setText(name.substring(0, name.length() - 1) + "");

                                    Log.i("sscscsc", "onResponse: " + name.substring(0, name.length() - 1));
                                    Log.i("sscscsc", "onResponse: " + response.toString());

                                }

                                String a = response.body().getFirst_air_date();
                                if (a!=null){
                                    String b = a.substring(0, 4);
                                    year.setText(b);
                                    Log.i("ssdefef", "onResponse: "+a);


                                }

                                Log.i("sscscsc", "onResponse: " + response.body().getReleaseDate());
                                Log.i("sscscsc", "onResponse: " + response.toString());


                                List<Integer> runtime = response.body().getEpisode_run_time();
                                Log.i("dshfhdbs", "onResponse: " + response.body().getEpisode_run_time().size());
                                if (runtime.size() > 0) {
                                    int t = response.body().getEpisode_run_time().get(0);
                                    int hours = t / 60; //since both are ints, you get an int
                                    int minutes = t % 60;
                                    System.out.printf("%d:%02d", hours, minutes);
                                    Log.i("dshfhdbs", "onResponse: " + response.body().getEpisode_run_time().toString());

                                    timing.setText(hours + " hour " + minutes + " minute");
                                    Log.i("dshfhdbs", hours + " hour " + minutes + " minute");

                                }
                            }
                        }
                            }


                    @Override
                    public void onFailure(Call<MovieInfo> call, Throwable t) {
                        Log.i("adadczc", "onFailure: " + t.getMessage());

                    }
                });

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(TvShowRequest.class)
                .getCrewRequest(s, NetworkConstraint.key)
                .enqueue(new Callback<Credit>() {
                    @Override
                    public void onResponse(Call<Credit> call, Response<Credit> response) {

                        if (response.body()!=null){
                            if (response.body().getCrew().size() == 0) {
                                crewlayout.setVisibility(View.GONE);
                            } else {
                                crewlayout.setVisibility(View.VISIBLE);
                                CrewAdapter adapter = new CrewAdapter(getContext(), response.body().getCrew());
                                crew.setAdapter(adapter);
                            }


                            Log.i("nscssknssks", "onResponse: " + response.body().getCrew());
                            Log.i("nscssknssks", "onResponse: " + response.toString());

                        }
                        }


                    @Override
                    public void onFailure(Call<Credit> call, Throwable t) {
                        Log.i("nscssknssks", "onFailure: " + t.getMessage());

                    }
                });

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(TvShowRequest.class)
                .getYoutubeRequest(s, NetworkConstraint.key)
                .enqueue(new Callback<YoutubeConnect>() {
                    @Override
                    public void onResponse(Call<YoutubeConnect> call, Response<YoutubeConnect> response) {

                        Log.i("jhjbjh", "onResponse: ");
                        if (response.body()!=null&&response.body().getResults().size()!=0){
                            if (response.body().getResults()!=null){
                                TrailorAdapter adapter = new TrailorAdapter(getContext(), response.body().getResults());
                                trailor.setAdapter(adapter);
                                trailor.setVisibility(View.VISIBLE);
                                train.setVisibility(View.VISIBLE);
                                viewer.setVisibility(View.VISIBLE);
                                Log.i("zzzzcdds", "onResponse: "+response.body().getResults());
                            }else {
                                trailor.setVisibility(View.GONE);
                            }

                        }


                    }

                    @Override
                    public void onFailure(Call<YoutubeConnect> call, Throwable t) {

                    }
                });


    }

    private void getMovie() {

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MoviesRequest.class)
                .getmovierequest(s, NetworkConstraint.key)
                .enqueue(new Callback<MovieInfo>() {
                    @Override
                    public void onResponse(Call<MovieInfo> call, Response<MovieInfo> response) {
                        {

                            if (response.body()!=null){
                                Log.i("adadczc", "onResponse: " + response.body().getOverview());
                                Log.i("adadczc", "onResponse: " + response.body());
                                review.setText(response.body().getOverview());

                                if (type == Type.MovieOrTvshow.MOVIE) {
                                    moviename.setText(response.body().getOriginalTitle());

                                } else {

                                }
                                language.setText(response.body().getOriginalLanguage());
                                released.setText(response.body().getStatus());
                                runtime.setText(response.body().getRuntime().toString());
                                date.setText(response.body().getReleaseDate());
                                inwest.setText(response.body().getBudget().toString());
                                earn.setText(response.body().getRevenue().toString());


                                Log.i("sccccccdscsds", "onResponse: " + response.body().getReleaseDate());
                                Picasso.get().load(NetworkConstraint.IMAGE_BASE_URL + response.body().getPosterPath()).into(smallimage);
                                Picasso.get().load(NetworkConstraint.Image_URL + response.body().getBackdropPath()).into(largeimage);
                                Log.i("xaxxxxad", "onResponse: " + response.body().getBackdropPath());

                                GenreAdapter adapter = new GenreAdapter(getContext(), response.body().getGenres(), Type.MovieOrTvshow.MOVIE);
                                genre.setAdapter(adapter);


                                String name = "";
                                for (MovieInfo.ProductionCompany x : response.body().getProductionCompanies()) {
                                    name = name + x.getName() + ",";
                                    Log.i("adsfs", "onResponse: " + name);
                                }


                                if (name.length()!=0)
                                    production.setText(name.substring(0, name.length() - 1) + ".");

                                String a = response.body().getReleaseDate();
                                String b = a.substring(0, 4);
                                year.setText(b);

                                int t = Integer.parseInt(response.body().getRuntime().toString());


                                int hours = t / 60; //since both are ints, you get an int
                                int minutes = t % 60;
                                System.out.printf("%d:%02d", hours, minutes);


                                timing.setText(hours + " hour " + minutes + " minute");


                                Log.i("sdssc", "onResponse: " + b);

                            }

                        }

                    }


                    @Override
                    public void onFailure(Call<MovieInfo> call, Throwable t) {
                        Log.i("adadczc", "onFailure: " + t.getMessage());

                    }
                });

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MoviesRequest.class)
                .getCrewRequest(s, NetworkConstraint.key)
                .enqueue(new Callback<Credit>() {
                    @Override
                    public void onResponse(Call<Credit> call, Response<Credit> response) {
                        CrewAdapter adapter = new CrewAdapter(getContext(), response.body().getCrew());
                        crew.setAdapter(adapter);

                        Log.i("dadada", "onResponse: " + response.body() );

                    }

                    @Override
                    public void onFailure(Call<Credit> call, Throwable t) {

                    }
                });

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MoviesRequest.class)
                .getYoutubeRequest(s, NetworkConstraint.key)
                .enqueue(new Callback<YoutubeConnect>() {
                    @Override
                    public void onResponse(Call<YoutubeConnect> call, Response<YoutubeConnect> response) {

                        Log.i("jhjbjh", "onResponse: ");

                        if (response.body().getResults()!=null){
                            TrailorAdapter adapter = new TrailorAdapter(getContext(), response.body().getResults());
                            trailor.setAdapter(adapter);
                            trailor.setVisibility(View.VISIBLE);
                            train.setVisibility(View.VISIBLE);
                            viewer.setVisibility(View.VISIBLE);
                        }else {
                            trailor.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(Call<YoutubeConnect> call, Throwable t) {

                    }
                });
    }


}