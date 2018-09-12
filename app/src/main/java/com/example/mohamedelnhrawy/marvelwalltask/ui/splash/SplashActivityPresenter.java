package com.example.mohamedelnhrawy.marvelwalltask.ui.splash;

/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

public class SplashActivityPresenter implements SplashActivityMVP.Presenter {

    SplashActivityMVP.View view;
    SplashActivityMVP.Model model;

    public SplashActivityPresenter(SplashActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(SplashActivityMVP.View view) {
        this.view=view;
    }

    @Override
    public void onDetach() {
        view=null;
    }
}
