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
import com.example.moviehub.utils.Type;
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





    public static PhotosFragment newInstance(String filePath) {
        PhotosFragment f = new PhotosFragment();
        Bundle args = new Bundle();
        args.putString("filePath",filePath);
         f.setArguments(args);
        return f;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Bundle args = getArguments();
        if(args!=null){
            filePath=args.getString("filePath");
        }


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
