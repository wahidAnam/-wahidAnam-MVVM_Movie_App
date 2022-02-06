package com.example.movieapp.View.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.movieapp.R;
import com.example.movieapp.Service.Model.Result;
import com.example.movieapp.ViewModel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView movieRV;
    private MovieListViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieRV = findViewById(R.id.movieRV);


        mViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);

        mViewModel.getTopRatedMovieLists().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {

            }
        });
    }
}