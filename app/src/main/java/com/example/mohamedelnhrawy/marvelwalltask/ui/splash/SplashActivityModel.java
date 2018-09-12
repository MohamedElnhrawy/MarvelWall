package com.example.mohamedelnhrawy.marvelwalltask.ui.splash;

/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

public class SplashActivityModel implements SplashActivityMVP.Model {

    SplashActivityRepository repository;

    public SplashActivityModel(SplashActivityRepository repository) {
        this.repository = repository;
    }
}
