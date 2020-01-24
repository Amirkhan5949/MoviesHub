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

import com.example.moviehub.Network.DiscoverRequest;
import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.Network.RetrofitClient;
import com.example.moviehub.Network.SimilarMovieRequest;
import com.example.moviehub.R;
import com.example.moviehub.adapter.SimilarMovieAdapter;
import com.example.moviehub.model.DiscoverGenre;
import com.example.moviehub.model.SimilarMovie;
import com.example.moviehub.utils.Type;

import static com.example.moviehub.utils.Type.MixListType.GENRE;
import static com.example.moviehub.utils.Type.MixListType.SIMILAR;

/**
 * A simple {@link Fragment} subclass.
 */
public class MixListFragment extends Fragment {
    RecyclerView recyclerView;
    View view;
    String s="";

    Type.MixListType type;


    public MixListFragment(String s, Type.MixListType type) {
        this.s=s;
        this.type = type;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_similar, container, false);
        recyclerView=view.findViewById(R.id.similarmovierecycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        // Inflate the layout for this fragment


        switch (type){
            case GENRE :
                getGenerMovie();
                break;
            case SIMILAR:
                getSimilarMovie();
                break;
        }




        return view;
    }

    private void getGenerMovie() {
        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(DiscoverRequest.class)
                .getDiscover(NetworkConstraint.key,s)
                .enqueue(new Callback<DiscoverGenre>() {
                    @Override
                    public void onResponse(Call<DiscoverGenre> call, Response<DiscoverGenre> response) {
                        SimilarMovieAdapter adapter=new SimilarMovieAdapter(getContext(),response.body().getResults());
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<DiscoverGenre> call, Throwable t) {

                    }
                });
    }

    private void getSimilarMovie() {
//        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
//                .create(SimilarMovieRequest.class)
//                .getsimilarmovie(s,NetworkConstraint.key)
//                .enqueue(new Callback<SimilarMovie>() {
//                    @Override
//                    public void onResponse(Call<SimilarMovie> call, Response<SimilarMovie> response) {
//                                SimilarMovieAdapter adapter=new SimilarMovieAdapter(getContext(),response.body().getResults());
//                        recyclerView.setAdapter(adapter);
//                    }
//
//                    @Override
//                    public void onFailure(Call<SimilarMovie> call, Throwable t) {
//
//                    }
//                });
    }

}
