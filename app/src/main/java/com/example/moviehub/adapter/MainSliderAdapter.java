package com.example.moviehub.adapter;

import com.example.moviehub.model.Result;
import com.example.moviehub.network.NetworkConstraint;

import java.util.List;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class MainSliderAdapter extends SliderAdapter {

    List<Result> results;
    public MainSliderAdapter(List<Result> results) {
        this.results=results;
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {

        imageSlideViewHolder.bindImageSlide(NetworkConstraint.Image_Org+results.get(position).getBackdropPath());

     }
}
