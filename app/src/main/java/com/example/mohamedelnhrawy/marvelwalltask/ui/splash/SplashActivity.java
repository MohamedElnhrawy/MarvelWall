package com.example.mohamedelnhrawy.marvelwalltask.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mohamedelnhrawy.marvelwalltask.R;
import com.example.mohamedelnhrawy.marvelwalltask.base.BaseActivity;
import com.example.mohamedelnhrawy.marvelwalltask.root.App;
import com.example.mohamedelnhrawy.marvelwalltask.ui.main.MainActivity;
import com.example.mohamedelnhrawy.marvelwalltask.utils.AppConstants;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashActivityMVP.View {

    @Inject
    SplashActivityMVP.Presenter presenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ((App) getApplication()).getComponent().injectSplash(this);
        openMainActivity();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    @Override
    public void openMainActivity() {
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(MainActivity.getStartIntent(SplashActivity.this));
                finish();
            }
        }, AppConstants.SPLASH_DISPLAY_LENGTH);
    }
}
