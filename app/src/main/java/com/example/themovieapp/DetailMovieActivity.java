package com.example.themovieapp;

import android.os.Bundle;
import com.bumptech.glide.Glide;
import com.example.themovieapp.adapter.MovieAdapter;
import com.example.themovieapp.model.ResultsItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.parceler.Parcels;

public class DetailMovieActivity extends AppCompatActivity {

    public ResultsItem dataMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /* Untuk menerima data yang dikirim dari MovieAdapter */
        Bundle bundle = getIntent().getBundleExtra(MovieAdapter.DATA_EXTRA);
        /* Membuka bungkus yang dikirim dari MovieAdapter */
        dataMovie = Parcels.unwrap(bundle.getParcelable(MovieAdapter.DATA_MOVIE));

        getSupportActionBar().setTitle(dataMovie.getTitle());

        ImageView backdropImageView = findViewById(R.id.detail_backdrop);
        TextView descriptionsTextView = findViewById(R.id.detail_descriptions);

        Glide.with(DetailMovieActivity.this).
                load("https://image.tmdb.org/t/p/w500" + dataMovie.getBackdropPath()).into(backdropImageView);
        descriptionsTextView.setText(dataMovie.getOverview());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
