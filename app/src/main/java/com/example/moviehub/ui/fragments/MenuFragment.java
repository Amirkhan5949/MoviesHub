package com.example.moviehub.ui.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.moviehub.R;
import com.example.moviehub.ui.activities.AppinfoActivity;
import com.example.moviehub.ui.activities.BookmarkActivity;
import com.example.moviehub.ui.activities.SearchActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    View view;
    LinearLayout bookmark,rate,share,info;
    ImageView msearch;



    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_menu, container, false);
        bookmark=view.findViewById(R.id.bookmark);
        rate=view.findViewById(R.id.rate);
        share=view.findViewById(R.id.share);
        info=view.findViewById(R.id.info);
        msearch = view.findViewById(R.id.msearchicon);

        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("cvdgdg", "onClick: "+3435);
                Intent intent=new Intent(getContext(), BookmarkActivity.class);
                startActivity(intent);
            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=PackageName")));

            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"I suggest this app for you : https://play.google.com/store/apps/details?id=com.android.chrome");
                intent.setType("text/plain");
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), AppinfoActivity.class);
                startActivity(intent);
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

}
