package com.example.mohamedelnhrawy.marvelwalltask.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }


    @Provides
    @Singleton
    public Context ProvideContext(){
        return application;
    }
}
