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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.Network.RetrofitClient;
import com.example.moviehub.Network.ReviewRequest;
import com.example.moviehub.R;
import com.example.moviehub.adapter.ReviewAdapter;
import com.example.moviehub.model.Reviews;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewFragment extends Fragment {
    RecyclerView recyclerView;
    View view;
    String s="";


    public ReviewFragment(String s) {
        this.s=s;
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

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(ReviewRequest.class)
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
        return view;
    }

}
