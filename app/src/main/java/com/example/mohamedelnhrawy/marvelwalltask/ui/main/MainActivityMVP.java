package com.example.mohamedelnhrawy.marvelwalltask.ui.main;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.example.mohamedelnhrawy.marvelwalltask.network.MarvelAPI;
import com.example.mohamedelnhrawy.marvelwalltask.network.apimodel.Marvel;
import com.example.mohamedelnhrawy.marvelwalltask.network.apimodel.MarvelList;
import com.example.mohamedelnhrawy.marvelwalltask.network.callback.ResponseCallback;

import java.util.List;



/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

public interface MainActivityMVP {

    interface View{
        void updateData();
        void setUpRecyclerView(RecyclerView recyclerView);
        void showSnackbar(String error);
        void setupSwipeRefresh(SwipeRefreshLayout swiperefresh);
    }

    interface Presenter{
        void LoadData(MarvelAPI marvelAPI, ResponseCallback responseCallback);
        void setView(MainActivityMVP.View view);
        void onDetach();
    }

    interface Model{

        void getMarvelList(MarvelAPI marvelAPI,ResponseCallback responseCallback);
    }

}
