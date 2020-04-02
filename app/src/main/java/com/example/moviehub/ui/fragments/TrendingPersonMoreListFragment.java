package com.example.moviehub.ui.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.moviehub.model.SearchByName;
import com.example.moviehub.network.NetworkConstraint;
import com.example.moviehub.network.RetrofitClient;
import com.example.moviehub.network.SearchRequest;
import com.example.moviehub.network.TrendingRequest;
import com.example.moviehub.R;
import com.example.moviehub.adapter.TrendingPersonListAdapter;
import com.example.moviehub.model.TrendingPersonDetail;
import com.example.moviehub.utils.Type;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendingPersonMoreListFragment extends Fragment {

    View view;
    RecyclerView trendingrecycler;
    AVLoadingIndicatorView trendingloader;
    int page=1;
    TrendingPersonListAdapter adpter;
    private boolean isLoading = false;
    private LinearLayoutManager linearLayoutManager;
    private String query;
    private Type.MoreButton type;
    private TrendingPersonListAdapter adaptr;


    public static TrendingPersonMoreListFragment newInstance(Type.MoreButton type) {
        TrendingPersonMoreListFragment f = new TrendingPersonMoreListFragment();
        Bundle args = new Bundle();
        args.putSerializable("type", type);
        f.setArguments(args);
        return f;
    }

    public static TrendingPersonMoreListFragment newInstance(Type.MoreButton type, String query) {
        TrendingPersonMoreListFragment f = new TrendingPersonMoreListFragment();
        Bundle args = new Bundle();
        args.putSerializable("type", type);
        args.putString("query", query);
        f.setArguments(args);
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_trending_person_more_list, container, false);

        Bundle args = getArguments();
        if(args!=null){
            type = (Type.MoreButton)args.getSerializable("type");
            query = args.getString("query")+" ";
        }


        trendingrecycler=view.findViewById(R.id.trendingrecycler);
        trendingloader=view.findViewById(R.id.trendingloader);

        linearLayoutManager = new LinearLayoutManager(getContext());
        trendingrecycler.setLayoutManager(linearLayoutManager);



        if (type.equals(Type.MoreButton.SEARCH_PEOPLE)){
            searchPerson();
        }else
            loadTrendingPerson();


        addListener();


        return view;
    }


    private void loadTrendingPerson() {
        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(TrendingRequest.class)
                .getTrendingPersonMore(page+"",NetworkConstraint.key)
                .enqueue(new Callback<TrendingPersonDetail>() {
                    @Override
                    public void onResponse(Call<TrendingPersonDetail> call, Response<TrendingPersonDetail> response) {
                        Log.i("rrggdr", "onesponse: "+response.body());
                        if (page==1){
                            Log.i("fffetec", "onResponse: "+2346);
                            adpter=new TrendingPersonListAdapter(getContext(),response.body().getResults());
                            trendingrecycler.setAdapter(adpter);
                        }else {
                            Log.i("defdfdf", "onResponse: "+2324);
                            adpter.addAllResult(response.body().getResults());
                        }

                        trendingloader.setVisibility(View.GONE);
                        isLoading=false;
                        page=   page+ 1;

                    }

                    @Override
                    public void onFailure(Call<TrendingPersonDetail> call, Throwable t) {
                        Log.i("rrggdr", "onesponse: "+t.getMessage());

                    }
                });

    }

    private void addListener() {
        {
            trendingrecycler.setOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override

                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    Log.i("fdfdv", "onScrolled: "+23424);
                    super.onScrolled(recyclerView, dx, dy);

                    int total = linearLayoutManager.getItemCount();
                    int firstVisibleItemCount = linearLayoutManager.findFirstVisibleItemPosition();
                    int lastVisibleItemCount = linearLayoutManager.findLastVisibleItemPosition();

                    //to avoid multiple calls to loadMore() method
                    //maintain a boolean value (isLoading). if loadMore() task started set to true and completes set to false
                    if (!isLoading) {
                        if (total > 0)
                            if ((total - 1) == lastVisibleItemCount){
                                isLoading = true;
                                trendingloader.setVisibility(View.VISIBLE);
                                if (type.equals(Type.MoreButton.SEARCH_PEOPLE)){
                                    searchPerson();
                                }else
                                    loadTrendingPerson();


                            }else
                                trendingloader.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);

                }

            });
        }
    }


    private void searchPerson() {

        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(SearchRequest.class)
                .searchPerson(page + "", query, NetworkConstraint.key)
                .enqueue(new Callback<SearchByName>() {
                    @Override
                    public void onResponse(Call<SearchByName> call, Response<SearchByName> response) {
                        Log.i("sfsfdz", "onResponse: "+ response.body());
                        Log.i("sfsfdz", "onResponse: "+ response.toString());

                        if (page == 1) {
                            Log.i("fsfvfs", "onResponse: "+123);
                            adaptr = new TrendingPersonListAdapter(getContext(),response.body().getResults());
                            trendingrecycler.setAdapter(adaptr);
                        } else {
                            Log.i("fsfvfs", "onResponse: "+123);
                            adaptr.addAllResult(response.body().getResults());
                        }

                        trendingloader.setVisibility(View.GONE);
                        isLoading = false;
                        page = page + 1;
                    }


                    @Override
                    public void onFailure(Call<SearchByName> call, Throwable t) {
                        Log.i("sfsfdz", "onResponse: "+ t.getMessage());
                        trendingloader.setVisibility(View.GONE);
                    }
                });
    }
}
