package com.example.mohamedelnhrawy.marvelwalltask.base;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

@Module
public class BaseModule {

    @Provides
    public BaseActivityMVP.Presenter ProvideBaseActivityPresenter(BaseActivityMVP.Model model){

        return new BaseActivityPresenter(model);
    }

    @Provides
    public BaseActivityMVP.Model ProvideBaseActivityModel(BaseActivityRepository repository){

        return new BaseActivityModel(repository);
    }

    @Provides
    public BaseActivityRepository ProvideBaseActivityRepository(){
        return new MemoryRepository();
    }

}
