package com.example.moviehub.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonMoviesTvshow {

    @SerializedName("cast")
    @Expose
    private List<Cast> cast = null;
    @SerializedName("crew")
    @Expose
    private List<Crew> crew = null;
    @SerializedName("id")
    @Expose
    private long id;

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public List<Crew> getCrew() {
        return crew;
    }

    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }




    public static class Cast {

        @SerializedName("character")
        @Expose
        private String character;
        @SerializedName("credit_id")
        @Expose
        private String creditId;
        @SerializedName("poster_path")
        @Expose
        private String posterPath;
        @SerializedName("id")
        @Expose
        private long id;
        @SerializedName("video")
        @Expose
        private boolean video;
        @SerializedName("vote_count")
        @Expose
        private long voteCount;
        @SerializedName("adult")
        @Expose
        private boolean adult;
        @SerializedName("backdrop_path")
        @Expose
        private Object backdropPath;
        @SerializedName("genre_ids")
        @Expose
        private List<Long> genreIds = null;
        @SerializedName("original_language")
        @Expose
        private String originalLanguage;
        @SerializedName("original_title")
        @Expose
        private String originalTitle;
        @SerializedName("popularity")
        @Expose
        private double popularity;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("vote_average")
        @Expose
        private long voteAverage;
        @SerializedName("overview")
        @Expose
        private String overview;
        @SerializedName("release_date")
        @Expose
        private String releaseDate;

        public String getCharacter() {
            return character;
        }

        public void setCharacter(String character) {
            this.character = character;
        }

        public String getCreditId() {
            return creditId;
        }

        public void setCreditId(String creditId) {
            this.creditId = creditId;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public long getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(long voteCount) {
            this.voteCount = voteCount;
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public Object getBackdropPath() {
            return backdropPath;
        }

        public void setBackdropPath(Object backdropPath) {
            this.backdropPath = backdropPath;
        }

        public List<Long> getGenreIds() {
            return genreIds;
        }

        public void setGenreIds(List<Long> genreIds) {
            this.genreIds = genreIds;
        }

        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(long voteAverage) {
            this.voteAverage = voteAverage;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

    }

    public static class Crew {

        @SerializedName("id")
        @Expose
        private long id;
        @SerializedName("department")
        @Expose
        private String department;
        @SerializedName("original_language")
        @Expose
        private String originalLanguage;
        @SerializedName("original_title")
        @Expose
        private String originalTitle;
        @SerializedName("job")
        @Expose
        private String job;
        @SerializedName("overview")
        @Expose
        private String overview;
        @SerializedName("vote_count")
        @Expose
        private long voteCount;
        @SerializedName("video")
        @Expose
        private boolean video;
        @SerializedName("release_date")
        @Expose
        private String releaseDate;
        @SerializedName("vote_average")
        @Expose
        private double voteAverage;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("popularity")
        @Expose
        private double popularity;
        @SerializedName("genre_ids")
        @Expose
        private List<Long> genreIds = null;
        @SerializedName("backdrop_path")
        @Expose
        private String backdropPath;
        @SerializedName("adult")
        @Expose
        private boolean adult;
        @SerializedName("poster_path")
        @Expose
        private String posterPath;
        @SerializedName("credit_id")
        @Expose
        private String creditId;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public long getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(long voteCount) {
            this.voteCount = voteCount;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public double getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(double voteAverage) {
            this.voteAverage = voteAverage;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public List<Long> getGenreIds() {
            return genreIds;
        }

        public void setGenreIds(List<Long> genreIds) {
            this.genreIds = genreIds;
        }

        public String getBackdropPath() {
            return backdropPath;
        }

        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public String getCreditId() {
            return creditId;
        }

        public void setCreditId(String creditId) {
            this.creditId = creditId;
        }

    }
}
