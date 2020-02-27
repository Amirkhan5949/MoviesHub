package com.example.moviehub.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public  class MovieImages {

    @SerializedName("id")
    @Expose
    private Long id;
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
