package com.ankur.mvp.app.data;


import com.ankur.mvp.app.model.QuestionResponse;

import io.reactivex.Flowable;

/**
 * Created by ANKUR JAIN on 28-06-2017.
 */

public interface BaseRepository {
    public Flowable<QuestionResponse> getQuestions();
}
