package com.example.retrofitreloadacademy.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrofitreloadacademy.R;
import com.example.retrofitreloadacademy.databinding.ActivityMainBinding;
import com.example.retrofitreloadacademy.model.MoviesModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  ActivityMainBinding binding;
  MoviesViewModel moviesViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        ////////////////////view model
        moviesViewModel= ViewModelProviders.of(this).get(MoviesViewModel.class);
        moviesViewModel.getData().observe(this, new Observer<ArrayList<MoviesModel>>() {
            @Override
            public void onChanged(ArrayList<MoviesModel> moviesModels) {
                MoviesAdabter adabter=new MoviesAdabter(moviesModels);
                binding.rvId.setAdapter(adabter);
                binding.rvId.setLayoutManager(new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL,false));
            }
        });
        //////////////////
    }

}