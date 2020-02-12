package com.example.themovieapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.themovieapp.R;
import com.example.themovieapp.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Context context;
    private List <MovieModel> data = new ArrayList<>();

    public MovieAdapter(Context context, List<MovieModel> data) {
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
        holder.tvTitle.setText(data.get(position).getMovieTitle());
        Glide.with(context).load(data.get(position).getMoviePoster()).into(holder.ivPoster); /*Untuk meload gambar menggunakan library Glide*/


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
