package com.example.moviehub.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;




    public class PersonImages {

        @SerializedName("profiles")
        @Expose
        private List<ImageData> profiles = null;
        @SerializedName("id")
        @Expose
        private Long id;

        public List<ImageData> getImageDatas() {
            return profiles;
        }

        public void setImageDatas(List<ImageData> profiles) {
            this.profiles = profiles;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }


}
