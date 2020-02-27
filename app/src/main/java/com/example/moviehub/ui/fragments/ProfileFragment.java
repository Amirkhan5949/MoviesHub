package com.example.moviehub.ui.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moviehub.model.ImageData;
import com.example.moviehub.model.MovieImages;
import com.example.moviehub.network.NetworkConstraint;
import com.example.moviehub.network.PersonRequest;

import com.example.moviehub.network.RetrofitClient;
import com.example.moviehub.R;
import com.example.moviehub.adapter.ImagesAdapter;
import com.example.moviehub.model.PersonDetail;
import com.example.moviehub.model.PersonImages;
import com.example.moviehub.ui.activities.MoviePosterActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    TextView birth,sincefrom,knownas,bio;
    RecyclerView images;
    View view;
    String personid;




    public static ProfileFragment newInstance(String personid) {
        ProfileFragment f = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString("personid",personid);
        f.setArguments(args);
        return f;
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_profile, container, false);
        birth=view.findViewById(R.id.birth);
        sincefrom=view.findViewById(R.id.sincefrom);
        knownas=view.findViewById(R.id.knownas);
        bio=view.findViewById(R.id.bio);
        images=view.findViewById(R.id.images);

        Bundle args = getArguments();
        if (args!=null){
            personid=args.getString("personid") ;
        }



        images.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(PersonRequest.class)
                .getPersondetail(personid,NetworkConstraint.key)
                .enqueue(new Callback<PersonDetail>() {
                    @Override
                    public void onResponse(Call<PersonDetail> call, Response<PersonDetail> response) {

                        birth.setText(response.body().getBirthday());
                        sincefrom.setText(response.body().getPlaceOfBirth());
                        knownas.setText(response.body().getAlsoKnownAs().toString());
                        bio.setText(response.body().getBiography());


                    }

                    @Override
                    public void onFailure(Call<PersonDetail> call, Throwable t) {

                    }
                });
        Log.i("sfseee", "onCreateView: "+personid);

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(PersonRequest.class)
                .getPersonImgRequest(personid,NetworkConstraint.key)
                .enqueue(new Callback<PersonImages>() {
                    @Override
                    public void onResponse(Call<PersonImages> call, Response<PersonImages> response) {
                        ImagesAdapter adapter=new ImagesAdapter(getContext(),response.body().getImageDatas());
                        images.setAdapter(adapter);

                        Log.i("sscscscfe", "onResponse: "+response.body().toString());




                    }

                    @Override
                    public void onFailure(Call<PersonImages> call, Throwable t) {
                        Log.i("sscscscfe", "onResponse: "+t.toString());
                    }
                });

        return view;
    }

}
