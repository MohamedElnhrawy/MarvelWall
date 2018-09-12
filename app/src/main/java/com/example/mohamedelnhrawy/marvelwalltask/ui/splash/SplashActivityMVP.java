package com.example.mohamedelnhrawy.marvelwalltask.ui.splash;

/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

public interface SplashActivityMVP {

    interface View{

        void openMainActivity();
    }

    interface Presenter{
       void setView(SplashActivityMVP.View view);
       void onDetach();
    }

    interface Model{

    }
}
