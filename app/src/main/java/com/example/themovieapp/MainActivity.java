package com.example.themovieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import com.example.themovieapp.adapter.MovieAdapter;
import com.example.themovieapp.model.ResponseMovie;
import com.example.themovieapp.model.ResultsItem;
import com.example.themovieapp.retrofit.RetrofitConfig;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<ResultsItem> dataMovie = new ArrayList<>();
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        getDataMovieDB();

        /*set Adapter*/
        recyclerView.setAdapter(new MovieAdapter(MainActivity.this, dataMovie));
        /*set Layout Manager*/
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));

    }

    private void getDataMovieDB() {
        Call<ResponseMovie> request = RetrofitConfig.getApiService().getDataMovie("3a1daf644fcfb442c6fc242d0f1915ab");
        request.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                if (response.isSuccessful()){
                    dataMovie = response.body().getResults();
                    recyclerView.setAdapter(new MovieAdapter(MainActivity.this, dataMovie));
                } else {
                    Toast.makeText(MainActivity.this, "Request Not Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Request Failure" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
