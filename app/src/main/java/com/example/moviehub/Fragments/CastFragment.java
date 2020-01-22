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

import com.example.moviehub.Network.CrewRequest;
import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.Network.RetrofitClient;
import com.example.moviehub.R;
import com.example.moviehub.adapter.CastAdapter;
import com.example.moviehub.model.Credit;

/**
 * A simple {@link Fragment} subclass.
 */
public class CastFragment extends Fragment {
    RecyclerView castrecyclerView;
    View view;
    String s="";


    public CastFragment(String s) {
        this.s=s;
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_cast, container, false);

        castrecyclerView=view.findViewById(R.id.castrecycler);

        castrecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(CrewRequest.class)
                .getCrewRequest(s,NetworkConstraint.key)
                .enqueue(new Callback<Credit>() {
                    @Override
                    public void onResponse(Call<Credit> call, Response<Credit> response) {
                        CastAdapter adapter=new CastAdapter(getContext(),response.body().getCast());
                        castrecyclerView.setAdapter(adapter);
                        Log.i("dsscc", "onResponse: "+response.body().toString());
                        Log.i("dsscc", "onResponse: "+response.body().getCast());
                    }

                    @Override
                    public void onFailure(Call<Credit> call, Throwable t) {

                    }
                });
        // Inflate the layout for this fragment
        return view;
    }

}
