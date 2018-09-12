package com.example.mohamedelnhrawy.marvelwalltask.ui.main;

import android.util.Log;

import com.example.mohamedelnhrawy.marvelwalltask.network.MarvelAPI;
import com.example.mohamedelnhrawy.marvelwalltask.network.apimodel.Marvel;
import com.example.mohamedelnhrawy.marvelwalltask.network.apimodel.MarvelList;
import com.example.mohamedelnhrawy.marvelwalltask.network.callback.ResponseCallback;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

public class Memoryrepository implements MainActivityRepository {



    @Override
    public void getResultsFromNetwork(MarvelAPI marvelAPI,final ResponseCallback responseCallback) {
        Observable<List<Marvel>> observable=marvelAPI.getMarvelsObservable();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Marvel>>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {
                        responseCallback.onError(e.getMessage());
                    }
                    @Override
                    public void onNext(List<Marvel> marvels) {
                        Log.e("size",""+marvels.size());
                        responseCallback.onsuccess(marvels);
                    }
                });
    }


}
