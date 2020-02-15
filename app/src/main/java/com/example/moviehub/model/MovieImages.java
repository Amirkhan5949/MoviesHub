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
    private List<Data> backdrops = null;
    @SerializedName("posters")
    @Expose
    private List<Data> data = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Data> getBackdrops() {
        return backdrops;
    }

    public void setBackdrops(List<Data> backdrops) {
        this.backdrops = backdrops;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }






    public static class Data implements Serializable {

        @SerializedName("aspect_ratio")
        @Expose
        private Double aspectRatio;
        @SerializedName("file_path")
        @Expose
        private String filePath;
        @SerializedName("height")
        @Expose
        private Long height;
        @SerializedName("iso_639_1")
        @Expose
        private String iso6391;
        @SerializedName("vote_average")
        @Expose
        private Double voteAverage;
        @SerializedName("vote_count")
        @Expose
        private Long voteCount;
        @SerializedName("width")
        @Expose
        private Long width;

        public Double getAspectRatio() {
            return aspectRatio;
        }

        public void setAspectRatio(Double aspectRatio) {
            this.aspectRatio = aspectRatio;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public Long getHeight() {
            return height;
        }

        public void setHeight(Long height) {
            this.height = height;
        }

        public String getIso6391() {
            return iso6391;
        }

        public void setIso6391(String iso6391) {
            this.iso6391 = iso6391;
        }

        public Double getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(Double voteAverage) {
            this.voteAverage = voteAverage;
        }

        public Long getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(Long voteCount) {
            this.voteCount = voteCount;
        }

        public Long getWidth() {
            return width;
        }

        public void setWidth(Long width) {
            this.width = width;
        }

    }
}
