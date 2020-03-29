package com.example.moviehub.adapter;

import com.example.moviehub.model.ImageData;
import com.example.moviehub.network.NetworkConstraint;

import java.util.List;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class InfoSliderAdapter extends SliderAdapter {
    List<ImageData> getBackdrops;
    public InfoSliderAdapter ( List<ImageData> getBackdrops){
        this.getBackdrops=getBackdrops;

    }
    @Override
    public int getItemCount() {
        return getBackdrops.size();
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
        imageSlideViewHolder.bindImageSlide(NetworkConstraint.Image_URL+getBackdrops.get(position).getFilePath());

    }
}
