package com.example.mohamedelnhrawy.marvelwalltask.base;

import android.support.annotation.Nullable;

/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

public class BaseActivityPresenter implements BaseActivityMVP.Presenter {

    @Nullable
    BaseActivityMVP.View view;
    BaseActivityMVP.Model model;

    public BaseActivityPresenter(BaseActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(BaseActivityMVP.View view) {
        this.view=view;
    }

    @Override
    public void onDetach() {

        view=null;
    }
}
