package com.example.moviehub.ui.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.example.moviehub.network.NetworkConstraint;
import com.example.moviehub.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotosFragment extends Fragment {
    ImageView photos;
    View  view;
    String filePath;
    AVLoadingIndicatorView avi;


    public PhotosFragment() {
        // Required empty public constructor
    }

    public PhotosFragment(String filePath) {
        this.filePath=filePath;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_photos2, container, false);
        photos=view.findViewById(R.id.photos);
        avi=view.findViewById(R.id.avi);
        Picasso.get().load(NetworkConstraint.Image_URL+filePath).into(photos);


        avi.setVisibility(View.VISIBLE);
        Picasso.get()
                .load(NetworkConstraint.Image_URL+filePath)
                .into(photos, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.i("defes", "onSuccess: "+234);
                        avi.setVisibility(View.GONE);

                    }

                    @Override
                    public void onError(Exception e) {

                    }


                });


        photos.setOnTouchListener(new ImageMatrixTouchHandler(getContext()));

        return view;
    }

}
