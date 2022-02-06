package com.example.movieapp.Service.Repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.Service.Model.MovieModel;
import com.example.movieapp.Service.Model.Result;
import com.example.movieapp.Service.Network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    public static Context mcontext;
    public static MovieRepository instance;
    public MovieModel movieModel;
    public List<Result> mResult;
    MutableLiveData mLiveData;

    public static MovieRepository getInstance(Context context) {

        if (instance == null) {
            mcontext = context;
            instance = new MovieRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Result>> getTopRatedMovieList() {
        if (mLiveData == null) {

            mLiveData = new MutableLiveData();
        }
        RetrofitClient.getApiInterface().getTopRatedMovieList().enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

                movieModel = response.body();
                mResult = movieModel.getResults();
                mLiveData.postValue(mResult);
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });

        return mLiveData;
    }
}
