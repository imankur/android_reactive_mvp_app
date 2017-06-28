package com.ankur.mvp.app.data.api;


import com.ankur.mvp.app.data.BaseRepository;
import com.ankur.mvp.app.model.QuestionResponse;

import javax.inject.Inject;

import io.reactivex.Flowable;


/**
 * Created by ANKUR JAIN on 28-06-2017.
 */

public class RestRepository implements BaseRepository {

    private RestService restService;

    @Inject
    public RestRepository(RestService restService) {
        this.restService = restService;
    }

    @Override
    public Flowable<QuestionResponse> getQuestions() {
        return restService.loadQuestionsByTag("android");
    }
}
