package com.example.themovieapp.adapter;

import android.content.Context;

import com.example.themovieapp.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter {

    private Context context;
    private List <MovieModel> data = new ArrayList<>();

    public MovieAdapter(Context context, List<MovieModel> data) {
        this.context = context;
        this.data = data;
    }
}
