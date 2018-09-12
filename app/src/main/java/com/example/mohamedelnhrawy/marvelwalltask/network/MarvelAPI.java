package com.example.mohamedelnhrawy.marvelwalltask.network;

import com.example.mohamedelnhrawy.marvelwalltask.network.apimodel.Marvel;
import com.example.mohamedelnhrawy.marvelwalltask.network.apimodel.MarvelList;


import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

public interface MarvelAPI {

    @GET("posts")
    Observable<List<Marvel>> getMarvelsObservable();
}
