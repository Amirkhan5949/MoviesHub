package com.example.moviehub.ui.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.moviehub.R;
import com.example.moviehub.adapter.MovieDetailAdapter;
 import com.example.moviehub.ui.activities.SearchActivity;
import com.example.moviehub.utils.Type;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyListFragment extends Fragment {

    TabLayout tablayoumtv;
    FrameLayout framelistmtv;
    ImageView msearch;
    View view;
    private FragmentManager supportFragmentManager;


    public MyListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_my_list, container, false);
        tablayoumtv=view.findViewById(R.id.tablayoutmtv);
        framelistmtv=view.findViewById(R.id.framelistmtv);
        msearch = view.findViewById(R.id.msearchicon);

        tablayoumtv.addTab(tablayoumtv.newTab().setText("Movie"));
        tablayoumtv.addTab(tablayoumtv.newTab().setText("Tv Show"));

        setFragment(new MovieFragment(Type.MovieOrTvshow.MOVIE));
        tablayoumtv.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0 : setFragment(new MovieFragment(Type.MovieOrTvshow.MOVIE));
                    break;
                    case 1 : setFragment(new MovieFragment(Type.MovieOrTvshow.TVSHOW));
                    break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });





        msearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    protected void setFragment(Fragment fragment) {
        FragmentTransaction t = getChildFragmentManager().beginTransaction();
        t.replace(R.id.framelistmtv, fragment);
        t.commit();
    }

}

