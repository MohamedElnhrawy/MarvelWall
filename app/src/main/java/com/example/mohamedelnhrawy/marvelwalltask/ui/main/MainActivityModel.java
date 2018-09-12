package com.example.mohamedelnhrawy.marvelwalltask.ui.main;

import com.example.mohamedelnhrawy.marvelwalltask.network.MarvelAPI;
import com.example.mohamedelnhrawy.marvelwalltask.network.apimodel.Marvel;
import com.example.mohamedelnhrawy.marvelwalltask.network.apimodel.MarvelList;
import com.example.mohamedelnhrawy.marvelwalltask.network.callback.ResponseCallback;

import java.util.List;



/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

public class MainActivityModel implements MainActivityMVP.Model {

    MainActivityRepository repository;

    public MainActivityModel(MainActivityRepository repository) {
        this.repository = repository;
    }


    @Override
    public void getMarvelList(MarvelAPI marvelAPI, ResponseCallback responseCallback) {
        repository.getResultsFromNetwork(marvelAPI,responseCallback);
    }
}
