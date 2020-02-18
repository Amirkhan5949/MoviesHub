package com.example.moviehub.Fragments;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviehub.Network.MoviesRequest;
import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.Network.RetrofitClient;
import com.example.moviehub.Network.TvShowRequest;
import com.example.moviehub.R;
import com.example.moviehub.adapter.ReviewAdapter;
import com.example.moviehub.model.Reviews;
import com.example.moviehub.utils.Type;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewFragment extends Fragment {
    RecyclerView recyclerView;
    View view;
    String s="";
    Type.MovieOrTvshow type;


    public ReviewFragment(String s, Type.MovieOrTvshow type) {
        this.s=s;
        this.type=type;
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_review, container, false);
        recyclerView=view.findViewById(R.id.reviewrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        // Inflate the layout for this fragment
        
        
        if (type==Type.MovieOrTvshow.MOVIE)
        movieReview();
        else
            tvReview();


        return view;
    }

    private void movieReview() {
        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(MoviesRequest.class)
                .getreviews(s,NetworkConstraint.key)
                .enqueue(new Callback<Reviews>() {
                    @Override
                    public void onResponse(Call<Reviews> call, Response<Reviews> response) {
                        ReviewAdapter  adapter=new ReviewAdapter(getContext(),response.body().getResults());
                        recyclerView.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(Call<Reviews> call, Throwable t) {

                    }
                });
    }

    private void tvReview() {

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(TvShowRequest.class)
                .getreviews(s,NetworkConstraint.key)
                .enqueue(new Callback<Reviews>() {
                    @Override
                    public void onResponse(Call<Reviews> call, Response<Reviews> response) {
                        if (response.body()!=null){
                            Log.i("dsdsfs", "onResponse: "+response.body());
                            ReviewAdapter  adapter=new ReviewAdapter(getContext(),response.body().getResults());
                            Log.i("dsdsfs", "onResponse: "+response.body().getResults());
                            Log.i("dsdsfs", "onResponse: "+response.body());
                            recyclerView.setAdapter(adapter);
                        }

                    }

                    @Override
                    public void onFailure(Call<Reviews> call, Throwable t) {
                        Log.i("dsdsfs", "onFailure: "+t.getMessage());
                    }
                });

    }

}
