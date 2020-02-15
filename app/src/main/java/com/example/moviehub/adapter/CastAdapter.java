package com.example.moviehub.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.moviehub.Activities.ProfileActivity;
import com.example.moviehub.Fragments.CastFragment;
import com.example.moviehub.Network.NetworkConstraint;
import com.example.moviehub.R;
import com.example.moviehub.model.Credit;
import com.example.moviehub.utils.Type;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastRecyclerView> {

    Context context;
    Credit credit;
    Type.Credit creditType;
    List<Credit.Cast> cast;
    List<Credit.Crew> crew;


    Type.MovieOrTvshow type;

    public CastAdapter(Context context, Credit credit, Type.MovieOrTvshow type, Type.Credit creditType) {
        this.context = context;
        this.credit = credit;
        this.type = type;
        this.creditType = creditType;
        cast = credit.getCast();
        crew = credit.getCrew();
    }

    @NonNull
    @Override
    public CastRecyclerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cast, parent, false);
        return new CastRecyclerView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastRecyclerView holder, int position) {

        if (creditType==Type.Credit.CAST){

                Picasso.get().load(NetworkConstraint.IMAGE_BASE_URL + cast.get(position).getProfilePath()).into(holder.circleimg);
                holder.name.setText(cast.get(position).getName());
                holder.nickname.setText(cast.get(position).getCharacter());

                holder.linear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i("dnsdf", "onClick: " + cast.get(position).getId());
                        Intent intent = new Intent(context, ProfileActivity.class);
                        intent.putExtra("id", cast.get(position).getId() + "");
                        intent.putExtra("name",cast.get(position).getName()+"");
                        intent.putExtra("photo",cast.get(position).getProfilePath()+"");
                        intent.putExtra("type", type);
                        context.startActivity(intent);
                    }
                });

        }
        else {
            Picasso.get().load(NetworkConstraint.IMAGE_BASE_URL + crew.get(position).getProfilePath()).into(holder.circleimg);
            holder.name.setText(crew.get(position).getName());
//              holder.nickname.setText(crew.get(position).getCharacter());

            holder.linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("ffsff", "onClick: " + crew.get(position).getId());

                    Intent intent = new Intent(context, ProfileActivity.class);
                    intent.putExtra("id", crew.get(position).getId() + "");
                    intent.putExtra("type", type);
                    intent.putExtra("name",crew.get(position).getName()+"");
                    intent.putExtra("photo",crew.get(position).getProfilePath()+"");
                     context.startActivity(intent);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        if (creditType == Type.Credit.CAST)
            return credit.getCast().size();
        else
            return credit.getCrew().size();
    }

    public class CastRecyclerView extends RecyclerView.ViewHolder {

        CircleImageView circleimg;
        TextView name, nickname;
        LinearLayout linear;

        public CastRecyclerView(@NonNull View itemView) {
            super(itemView);
            circleimg = itemView.findViewById(R.id.circleimg);
            name = itemView.findViewById(R.id.name);
            nickname = itemView.findViewById(R.id.nickname);
            linear = itemView.findViewById(R.id.linear);

        }
    }
}
