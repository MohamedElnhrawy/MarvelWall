package com.example.mohamedelnhrawy.marvelwalltask.ui.splash;

import com.example.mohamedelnhrawy.marvelwalltask.base.*;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

@Module
public class SplashModule {

    @Provides
    public SplashActivityMVP.Presenter ProvideSplashActivityPresenter(SplashActivityMVP.Model model){

        return new SplashActivityPresenter(model);
    }

    @Provides
    public SplashActivityMVP.Model ProvideSplashActivityModel(SplashActivityRepository repository){

        return new SplashActivityModel(repository);
    }

    @Provides
    public SplashActivityRepository ProvideSplashActivityRepository(){
        return new MemoryRepository();
    }
}
