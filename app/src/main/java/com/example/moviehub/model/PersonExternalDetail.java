package com.example.moviehub.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonExternalDetail {

        @SerializedName("id")
        @Expose
        private Long id;
        @SerializedName("twitter_id")
        @Expose
        private String twitterId;
        @SerializedName("facebook_id")
        @Expose
        private String facebookId;
        @SerializedName("tvrage_id")
        @Expose
        private Long tvrageId;
        @SerializedName("instagram_id")
        @Expose
        private String instagramId;
        @SerializedName("freebase_mid")
        @Expose
        private String freebaseMid;
        @SerializedName("imdb_id")
        @Expose
        private String imdbId;
        @SerializedName("freebase_id")
        @Expose
        private String freebaseId;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTwitterId() {
            return twitterId;
        }

        public void setTwitterId(String twitterId) {
            this.twitterId = twitterId;
        }

        public String getFacebookId() {
            return facebookId;
        }

        public void setFacebookId(String facebookId) {
            this.facebookId = facebookId;
        }

        public Long getTvrageId() {
            return tvrageId;
        }

        public void setTvrageId(Long tvrageId) {
            this.tvrageId = tvrageId;
        }

        public String getInstagramId() {
            return instagramId;
        }

        public void setInstagramId(String instagramId) {
            this.instagramId = instagramId;
        }

        public String getFreebaseMid() {
            return freebaseMid;
        }

        public void setFreebaseMid(String freebaseMid) {
            this.freebaseMid = freebaseMid;
        }

        public String getImdbId() {
            return imdbId;
        }

        public void setImdbId(String imdbId) {
            this.imdbId = imdbId;
        }

        public String getFreebaseId() {
            return freebaseId;
        }

        public void setFreebaseId(String freebaseId) {
            this.freebaseId = freebaseId;
        }

    }



