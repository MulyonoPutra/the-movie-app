package com.example.themovieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.themovieapp.adapter.MovieAdapter;
import com.example.themovieapp.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<MovieModel> dataMovie = new ArrayList<>();
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        MovieModel movieModel = new MovieModel();
        movieModel.setMovieTitle("Movie Title");
        movieModel.setMoviePoster("https://image.tmdb.org/t/p/w600_and_h900_bestv2/3Nt3v1uzUgfSuVARD1AnI9g9Zl9.jpg");

        for (int i = 0; i < 20; i++) {
            dataMovie.add(movieModel);
        }

        /*set Adapter*/
        recyclerView.setAdapter(new MovieAdapter(MainActivity.this, dataMovie));
        /*set Layout Manager*/
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
    }
}
