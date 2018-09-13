package com.example.mohamedelnhrawy.marvelwalltask.ui.main;



import com.example.mohamedelnhrawy.marvelwalltask.network.MarvelAPI;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

@Module
public class MainModule {

    @Provides
    public MainActivityMVP.Presenter ProvideMainActivityPresenter(MainActivityMVP.Model model){

        return new MainActivityPresenter(model);
    }

    @Provides
    public MainActivityMVP.Model ProvideMainhActivityModel(MainActivityRepository repository){

        return new MainActivityModel(repository);
    }

    @Provides
    public MainActivityRepository ProvideMainActivityRepository(MarvelAPI marvelAPI){
        return new Memoryrepository(marvelAPI);
    }
}
