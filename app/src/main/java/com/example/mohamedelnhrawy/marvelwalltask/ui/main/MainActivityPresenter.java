package com.example.mohamedelnhrawy.marvelwalltask.ui.main;

import com.example.mohamedelnhrawy.marvelwalltask.network.MarvelAPI;
import com.example.mohamedelnhrawy.marvelwalltask.network.apimodel.Marvel;
import com.example.mohamedelnhrawy.marvelwalltask.network.apimodel.MarvelList;
import com.example.mohamedelnhrawy.marvelwalltask.network.callback.ResponseCallback;




/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

public class MainActivityPresenter implements MainActivityMVP.Presenter {

    MainActivityMVP.View view;
    MainActivityMVP.Model model;

    public MainActivityPresenter(MainActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void LoadData(ResponseCallback responseCallback) {
     model.getMarvelList(responseCallback);
    }



    @Override
    public void setView(MainActivityMVP.View view) {
        this.view=view;
    }

    @Override
    public void onDetach() {
        view=null;
    }


}
