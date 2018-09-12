package com.example.mohamedelnhrawy.marvelwalltask.network;

import com.example.mohamedelnhrawy.marvelwalltask.utils.AppConstants;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

@Module
public class ApiModule {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Provides
    public OkHttpClient provideClient(){
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().readTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS).addInterceptor(interceptor).build();
    }

    @Provides
    public Retrofit provideRetrofit(String base_url,OkHttpClient client){
        return new Retrofit.Builder().baseUrl(base_url).client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    public MarvelAPI provideMarvelService(){
        return provideRetrofit(BASE_URL,provideClient()).create(MarvelAPI.class);
    }
}
