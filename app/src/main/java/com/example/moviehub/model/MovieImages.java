package com.example.moviehub.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class MovieImages {

    @SerializedName("id")
    @Expose
    private Long id;

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<ImageData> getData() {
        return data;
    }

    public void setData(List<ImageData> data) {
        this.data = data;
    }

    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;

    @SerializedName("backdrops")
    @Expose
    private List<ImageData> backdrops = null;
    @SerializedName("posters")
    @Expose
    private List<ImageData> data = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ImageData> getBackdrops() {
        return backdrops;
    }

    public void setBackdrops(List<ImageData> backdrops) {
        this.backdrops = backdrops;
    }

    public List<ImageData> getImageData() {
        return data;
    }

    public void setImageData(List<ImageData> data) {
        this.data = data;
    }







}
