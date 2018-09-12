package com.example.mohamedelnhrawy.marvelwalltask.ui.main;


import com.example.mohamedelnhrawy.marvelwalltask.network.MarvelAPI;
import com.example.mohamedelnhrawy.marvelwalltask.network.apimodel.MarvelList;
import com.example.mohamedelnhrawy.marvelwalltask.network.callback.ResponseCallback;



/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

public interface MainActivityRepository  {

    void getResultsFromNetwork(MarvelAPI marvelAPI, ResponseCallback responseCallback);

}
