package com.example.moviehub.adapter;

import com.example.moviehub.model.Result;
import com.example.moviehub.network.NetworkConstraint;
import com.example.moviehub.utils.Type;

import java.util.List;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class MainSliderAdapter extends SliderAdapter {

    Type.UpcomingOrPersonImage upcomingmovieorpersonimage;

    List<Result> results;
    public MainSliderAdapter(List<Result> results, Type.UpcomingOrPersonImage upcomingmovieorpersonimage) {
        this.results=results;
        this.upcomingmovieorpersonimage=upcomingmovieorpersonimage;
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
        if (upcomingmovieorpersonimage==Type.UpcomingOrPersonImage.UPCOMINGMOVIE){
            imageSlideViewHolder.bindImageSlide(NetworkConstraint.Image_URL+results.get(position).getBackdropPath());
        }else {
            imageSlideViewHolder.bindImageSlide(NetworkConstraint.Image_Org+results.get(position).getFile_path()+"");
        }


     }
}
