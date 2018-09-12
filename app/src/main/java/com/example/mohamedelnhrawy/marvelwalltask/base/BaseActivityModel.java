package com.example.mohamedelnhrawy.marvelwalltask.base;

/**
 * Created by mohamedelnhrawy on 9/11/18.
 */

public class BaseActivityModel implements BaseActivityMVP.Model {

    BaseActivityRepository repository;

    public BaseActivityModel(BaseActivityRepository repository) {
        this.repository = repository;
    }


}
