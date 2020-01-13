package com.example.moviehub;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.Network.RetrofitClient;
import com.example.moviehub.Network.TrendingRequest;
import com.example.moviehub.adapter.RecyclerViewAdapter;
import com.example.moviehub.model.Trending;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler=findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));



        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(TrendingRequest.class)
                .getTrending(NetworkConstraint.key)
                .enqueue(new Callback<Trending>() {
                    @Override
                    public void onResponse(Call<Trending> call, Response<Trending> response) {

                        Log.i("dadacc", "onResponse: "+response.body().getResults());
                        Log.i("dadacc", "onResponse: "+response.toString());
                        recycler.setAdapter(new RecyclerViewAdapter(MainActivity.this,response.body().getResults()));

                    }

                    @Override
                    public void onFailure(Call<Trending> call, Throwable t) {
                        Log.i("dadacc", "onFailure: "+t.getMessage());

                    }
                });





    }
}
