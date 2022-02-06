package com.example.movieapp.View.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.R;
import com.example.movieapp.Service.Model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context context;
    private List<Result> mList;

    public MovieAdapter(Context context, List<Result> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(context).inflate(R.layout.movie_row_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.titleTV.setText(mList.get(position).getTitle());
        holder.ratingTV.setText(mList.get(position).getVoteAverage().toString());
        holder.raleasedateTV.setText(mList.get(position).getReleaseDate());

        Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+mList.get(position).getPosterPath()).into(holder.avatarID);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView avatarID;
        private TextView titleTV,ratingTV,raleasedateTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            avatarID = itemView.findViewById(R.id.avatarID);
            titleTV = itemView.findViewById(R.id.titleTV);
            ratingTV = itemView.findViewById(R.id.ratingTV);
            raleasedateTV = itemView.findViewById(R.id.raleasedateTV);

        }
    }
}
