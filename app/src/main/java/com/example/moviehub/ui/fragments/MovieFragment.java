package com.example.moviehub.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviehub.R;
import com.example.moviehub.adapter.MyListMovieAdapter;
import com.example.moviehub.model.MyList;
import com.example.moviehub.room.DatabaseClient;
import com.example.moviehub.utils.Type;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    RecyclerView recyclermovie;
    View view;
    Type.MovieOrTvshow type;

    public MovieFragment(Type.MovieOrTvshow type) {
        this.type=type;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_movie2, container, false);
        recyclermovie=view.findViewById(R.id.recyclermovie);
        recyclermovie.setLayoutManager(new LinearLayoutManager(getContext()));
        List<MyList> myLists = DatabaseClient.getInstance(getContext()).getAppDatabase()
                .getmylistdao()
                .getAll(type);

        Log.i("dsvhch", "onCreateView: "+myLists.toString());

        recyclermovie.setAdapter(new MyListMovieAdapter(getContext(),myLists,type));
        return view;
    }
}
