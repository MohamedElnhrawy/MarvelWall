package com.example.mohamedelnhrawy.marvelwalltask.root;

import com.example.mohamedelnhrawy.marvelwalltask.base.BaseActivity;
import com.example.mohamedelnhrawy.marvelwalltask.base.BaseModule;
import com.example.mohamedelnhrawy.marvelwalltask.network.ApiModule;
import com.example.mohamedelnhrawy.marvelwalltask.ui.main.MainActivity;
import com.example.mohamedelnhrawy.marvelwalltask.ui.main.MainModule;
import com.example.mohamedelnhrawy.marvelwalltask.ui.main.Memoryrepository;
import com.example.mohamedelnhrawy.marvelwalltask.ui.splash.SplashActivity;
import com.example.mohamedelnhrawy.marvelwalltask.ui.splash.SplashModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mohamedelnhrawy on 9/11/18.
 */


@Singleton
@Component(modules = {ApplicationModule.class, SplashModule.class, BaseModule.class,ApiModule.class,MainModule.class})
public interface ApplicationComponent {

    void injectSplash(SplashActivity activity);
    void injectBase(BaseActivity activity);
    void injectMain(MainActivity activity);

    void inject(Memoryrepository memoryrepository);
}
