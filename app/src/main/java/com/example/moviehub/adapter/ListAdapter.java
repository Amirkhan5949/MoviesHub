package com.example.moviehub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviehub.R;
import com.example.moviehub.model.MovieInfo;
import com.example.moviehub.model.MyList;
import com.example.moviehub.model.MyListDetail;
import com.example.moviehub.room.DatabaseClient;
import com.example.moviehub.utils.Type;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.listadapterview>{
    Context context;
    List<MyList>  myLists ;
    Type.MovieOrTvshow type;
    MovieInfo movieInfo;




    public ListAdapter(Context context, List<MyList>  myLists, Type.MovieOrTvshow type, MovieInfo movieInfo){
        this.context=context;
        this.myLists=myLists;
        this.type=type;
        this.movieInfo=movieInfo;
     }


    @NonNull
    @Override
    public listadapterview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.listdialouge,parent,false);
        return new listadapterview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listadapterview holder, int position) {

        List<MyListDetail> list =  DatabaseClient.getInstance(context).getAppDatabase(). getmylistdetaildao()
                .checkListDetail(movieInfo.getId(),myLists.get(position).getId());
        boolean isMyListDetailAlready = list.size()>0?true:false;

        List<MovieInfo>list1=DatabaseClient.getInstance(context).getAppDatabase(). getMovieInfoDao()
                .checkMovieinfo(movieInfo.getId());
        boolean isMyMovieinfotAlready = list1.size()>0?true:false;






        holder.listname.setText(myLists.get(position).getName());

        holder.listcheck.setOnCheckedChangeListener(null);
        holder.listcheck.setChecked(isMyListDetailAlready);
        holder.listcheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    if(!isMyMovieinfotAlready){
                        DatabaseClient.getInstance(context).getAppDatabase()
                                .getMovieInfoDao()
                                .insert(movieInfo);

                    }
                     DatabaseClient.getInstance(context).getAppDatabase(). getmylistdetaildao()
                            .insert(new MyListDetail(myLists.get(position).getId(),movieInfo.getId()));



                }
                else {
                    DatabaseClient.getInstance(context).getAppDatabase()
                            .getmylistdetaildao()
                            .delte(myLists.get(position).getId(),movieInfo.getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return myLists.size();
    }

    public class listadapterview extends RecyclerView.ViewHolder {
        TextView listname;
        CheckBox listcheck;
        public listadapterview(@NonNull View itemView) {
          super(itemView);
          listname=itemView.findViewById(R.id.listname);
            listcheck=itemView.findViewById(R.id.listcheck);
      }
  }
}
