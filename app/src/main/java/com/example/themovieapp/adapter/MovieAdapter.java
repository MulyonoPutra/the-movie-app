package com.example.themovieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.themovieapp.DetailMovieActivity;
import com.example.themovieapp.R;
import com.example.themovieapp.model.ResultsItem;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    public static final String DATA_MOVIE = "dataMovie";
    public static final String DATA_EXTRA = "dataExtra";
    private Context context;

    List <ResultsItem> data = new ArrayList<>();

    public MovieAdapter(Context context, List<ResultsItem> data) {
        this.context = context;
        this.data = data;
    }

    /* Untuk menyambungkan dengan Layout item movie*/
    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new MyViewHolder(itemView);
    }

    /* Untuk set data */
    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(data.get(position).getTitle());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + data.get(position).getPosterPath()).into(holder.ivPoster); /*Untuk meload gambar menggunakan library Glide*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent move = new Intent(context, DetailMovieActivity.class);

                /*Untuk mengirim data object yaitu ke DetailMovieActivity */
                Bundle bundle = new Bundle();
                /* Untuk membungkus data yang akan dikirim ke DetailMovieActivity */
                bundle.putParcelable(DATA_MOVIE, Parcels.wrap(data.get(position)));
                move.putExtra(DATA_EXTRA, bundle);

                context.startActivity(move);
            }


        });

    }

    /* Jumlah data */
    @Override
    public int getItemCount() {
        return data.size(); /* -> Untuk menyesuaikan data dengan List */
    }


    /* Mengenalkan komponen didalam item */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView ivPoster;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.item_title);
            ivPoster = itemView.findViewById(R.id.image_movies);
        }
    }
}
