package com.example.retrofitreloadacademy.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofitreloadacademy.model.ApiServices;
import com.example.retrofitreloadacademy.model.MoviesModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesViewModel extends ViewModel {
    MutableLiveData<ArrayList<MoviesModel>> arrayListMutableLiveData=new MutableLiveData<>();
    public MutableLiveData<ArrayList<MoviesModel>> getData(){
        ApiServices apiServices=WebServiceClient.getRetrofit().create(ApiServices.class);
        Call<ArrayList<MoviesModel>>call=apiServices.getMovies();
        call.enqueue(new Callback<ArrayList<MoviesModel>>() {
            @Override
            public void onResponse(Call<ArrayList<MoviesModel>> call, Response<ArrayList<MoviesModel>> response) {
                arrayListMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<MoviesModel>> call, Throwable t) {

            }
        });
        return arrayListMutableLiveData;
    }

}
