package com.example.moviehub.ui.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviehub.ui.activities.ForMoreActivity;
import com.example.moviehub.ui.activities.MoreActivity;
import com.example.moviehub.ui.activities.SearchActivity;

import com.example.moviehub.R;
import com.example.moviehub.utils.Type;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
    View view;
    CardView rmovies,rtvshows,rpersons,searchkey;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_search, container, false);
        rmovies=view.findViewById(R.id.rmovies);
        rtvshows=view.findViewById(R.id.rtvshow);
        rpersons=view.findViewById(R.id.rperson);
        searchkey=view.findViewById(R.id.searchkey);



        searchkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });


        rmovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), ForMoreActivity.class);
                intent.putExtra("type", Type.MoreButton.TRENDINGMOVIES);
                startActivity(intent);
            }
        });

        rtvshows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), ForMoreActivity.class);
                intent.putExtra("type", Type.MoreButton.TRENDINGTVSHOW);
                startActivity(intent);
            }
        });
        rpersons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), MoreActivity.class);
                intent.putExtra("type", Type.MoreButton.TRENDINGPERSON);
                startActivity(intent);
            }
        });
        return view;
    }

}
