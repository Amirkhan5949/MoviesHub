package com.example.moviehub.model;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trending {

    @SerializedName("page")
    @Expose
    private Long page;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("total_pages")
    @Expose
    private Long totalPages;
    @SerializedName("total_results")
    @Expose
    private Long totalResults;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }



}
