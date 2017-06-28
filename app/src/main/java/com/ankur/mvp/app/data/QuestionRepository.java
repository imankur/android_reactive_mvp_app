package com.ankur.mvp.app.data;


import com.ankur.mvp.app.data.api.RestRepository;
import com.ankur.mvp.app.data.database.DbRepository;
import com.ankur.mvp.app.model.QuestionResponse;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by ANKUR JAIN on 28-06-2017.
 */

public class QuestionRepository implements BaseRepository {

    BaseRepository mApiRepository;
    BaseRepository mDbRepository;

    @Inject
    public QuestionRepository(RestRepository mApiRepository, DbRepository mDbRepository) {
        this.mApiRepository = mApiRepository;
        this.mDbRepository = mDbRepository;
    }

    @Override
    public Flowable<QuestionResponse> getQuestions() {
        if (mDbRepository.getQuestions() == null)
            return mApiRepository.getQuestions();
        else
            return mDbRepository.getQuestions();
    }
}
