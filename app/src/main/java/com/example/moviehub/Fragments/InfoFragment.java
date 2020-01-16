package com.example.moviehub.Fragments;


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
import android.widget.TextView;

import com.example.moviehub.Network.CrewRequest;
import com.example.moviehub.Network.MovieInfoRequest;
import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.Network.RetrofitClient;
import com.example.moviehub.R;
import com.example.moviehub.adapter.CrewAdapter;
import com.example.moviehub.adapter.GenreAdapter;
import com.example.moviehub.adapter.TrailorAdapter;
import com.example.moviehub.model.Credit;
import com.example.moviehub.model.MovieInfo;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {
    View view;
    RecyclerView genre,crew,trailor;
    ImageView smallimage,largeimage;
    TextView review,showall,number,poster,no,backdrops,moviename,released,runtime,date,language,inwest,earn,production;


    public InfoFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_info, container, false);

        genre=view.findViewById(R.id.genre);
        crew=view.findViewById(R.id.crew);
        trailor=view.findViewById(R.id.trailor);


       genre.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
       crew.setLayoutManager(new GridLayoutManager(getContext(),2));




        smallimage=view.findViewById(R.id.smallimage);
        largeimage=view.findViewById(R.id.largeimage);


        review=view.findViewById(R.id.review);
        showall=view.findViewById(R.id.showall);
        number=view.findViewById(R.id.number);
        poster=view.findViewById(R.id.poster);
        no=view.findViewById(R.id.no);
        backdrops=view.findViewById(R.id.backdrops);

        moviename=view.findViewById(R.id.moviename);
        released=view.findViewById(R.id.released);
        runtime=view.findViewById(R.id.runtime);
        date=view.findViewById(R.id.date);
        language=view.findViewById(R.id.language);
        inwest=view.findViewById(R.id.inwest);
        earn=view.findViewById(R.id.earn);
        production=view.findViewById(R.id.production);


        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MovieInfoRequest.class)
                .getmovierequest(NetworkConstraint.key)
                .enqueue(new Callback<MovieInfo>() {
                    @Override
                    public void onResponse(Call<MovieInfo> call, Response<MovieInfo> response) {{

                        Log.i("adadczc", "onResponse: " + response.toString());
                        Log.i("adadczc", "onResponse: " + response.body());
                        review.setText(response.body().getOverview());
                        moviename.setText(response.body().getOriginalTitle());
                         language.setText(response.body().getOriginalLanguage());
                         released.setText(response.body().getStatus());
                         runtime.setText(response.body().getRuntime().toString());
                         date.setText(response.body().getReleaseDate());
                         inwest.setText(response.body().getBudget().toString());
                         earn.setText(response.body().getRevenue().toString());
                         production.setText(response.body().getProductionCompanies().toString());
                        Picasso.get().load(NetworkConstraint.IMAGE_BASE_URL+response.body().getPosterPath()).into(smallimage);
                        Picasso.get().load(NetworkConstraint.IMAGE_BASE_URL+response.body().getBackdropPath()).into(largeimage);
                        Log.i("xaxxxxad", "onResponse: "+response.body().getOverview());

                        GenreAdapter adapter=new GenreAdapter(getContext(),response.body().getGenres());
                        genre.setAdapter(adapter);

//                        TrailorAdapter trailorAdapter=new TrailorAdapter(getContext(),response.body().)




                    }

                    }

                    @Override
                    public void onFailure(Call<MovieInfo> call, Throwable t) {
                        Log.i("adadczc", "onFailure: "+t.getMessage());

                    }
                });

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(CrewRequest.class)
                .getCrewRequest(NetworkConstraint.key)
                .enqueue(new Callback<Credit>() {
                    @Override
                    public void onResponse(Call<Credit> call, Response<Credit> response) {
                        CrewAdapter adapter=new CrewAdapter(getContext(),response.body().getCrew());
                        crew.setAdapter(adapter);

                        Log.i("dadada", "onResponse: "+response.body().getCrew());
                    }

                    @Override
                    public void onFailure(Call<Credit> call, Throwable t) {

                    }
                });






        // Inflate the layout for this fragment
        return view;
    }


}
