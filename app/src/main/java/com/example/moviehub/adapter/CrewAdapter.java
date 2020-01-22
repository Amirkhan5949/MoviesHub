package com.example.moviehub.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moviehub.R;
import com.example.moviehub.model.Credit;
import com.example.moviehub.model.Credit;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CrewAdapter extends RecyclerView.Adapter<CrewAdapter.CrewRecyclerView>{
//   Context mContext;
    Context context;
    List<Credit.Crew>list;

    public CrewAdapter(Context context, List<Credit.Crew>list){
        this.context=context;
        this.list=list;

    }

//    public CrewAdapter (Context mContext) {
//        super();
//        this.mContext = mContext;
//    }

    @NonNull
    @Override
    public CrewRecyclerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.crew,parent,false);
        return new CrewRecyclerView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CrewRecyclerView holder, int position) {
        holder.name.setText(list.get(position).getName());
        Log.i("sfsfssf", "onBindViewHolder: "+list.get(position).getName());
        holder.Profession.setText(list.get(position).getDepartment());
        Log.i("sfsfssf", "onBindViewHolder: "+list.get(position).getDepartment());



    }

    @Override
    public int getItemCount() {

                if(list.size()>6){
                    return 6;
                }
                else {
                    return list.size();
                }
    }


    public class CrewRecyclerView extends RecyclerView.ViewHolder {

        TextView name,Profession;
        public CrewRecyclerView(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            Profession=itemView.findViewById(R.id.profession);

        }
    }
}
