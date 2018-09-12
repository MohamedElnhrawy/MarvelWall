package com.example.mohamedelnhrawy.marvelwalltask.base;

import android.support.annotation.StringRes;

/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

public interface BaseActivityMVP {

    interface View{
        void showLoading();

        void hideLoading();


        void onError(@StringRes int resId);

        void onError(String message);

        void showMessage(String message);

        void showMessage(@StringRes int resId);

        boolean isNetworkConnected();

        void hideKeyboard();

        void showSnackBar(String message);
    }

    interface Presenter{

        void setView(BaseActivityMVP.View view);
        void onDetach();

    }

    interface Model{

    }
}
