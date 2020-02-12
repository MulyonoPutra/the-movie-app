package com.example.themovieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.themovieapp.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<MovieModel> dataMovie = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MovieModel movieModel = new MovieModel();
        movieModel.setMovieTitle("Movie Title");
        movieModel.setMoviePoster("https://image.tmdb.org/t/p/w600_and_h900_bestv2/3Nt3v1uzUgfSuVARD1AnI9g9Zl9.jpg");
    }
}
