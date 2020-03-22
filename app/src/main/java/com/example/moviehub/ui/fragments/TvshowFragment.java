package com.example.moviehub.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
public class TvshowFragment extends Fragment {

    RecyclerView tvshowrecycler;
    View view;
    public TvshowFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_tvshow, container, false);
        tvshowrecycler=view.findViewById(R.id.tvshowrecycler);
        tvshowrecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        List<MyList> myLists = DatabaseClient.getInstance(getContext()).getAppDatabase()
                .getmylistdao()
                .getAll(Type.MovieOrTvshow.TVSHOW);

        tvshowrecycler.setAdapter(new MyListMovieAdapter(getContext(),myLists,Type.MovieOrTvshow.TVSHOW));
        return view;
    }
}
