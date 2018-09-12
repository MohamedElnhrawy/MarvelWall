package com.example.mohamedelnhrawy.marvelwalltask.root;

import android.app.Application;

import com.example.mohamedelnhrawy.marvelwalltask.base.BaseModule;
import com.example.mohamedelnhrawy.marvelwalltask.network.ApiModule;
import com.example.mohamedelnhrawy.marvelwalltask.ui.main.MainModule;
import com.example.mohamedelnhrawy.marvelwalltask.ui.splash.SplashModule;

/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

public class App extends Application {


    ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component=DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .baseModule(new BaseModule())
                .splashModule(new SplashModule())
                .apiModule(new ApiModule())
                .mainModule(new MainModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
