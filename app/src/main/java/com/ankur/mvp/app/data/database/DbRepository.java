package com.ankur.mvp.app.data.database;

import com.ankur.mvp.app.data.BaseRepository;
import com.ankur.mvp.app.model.QuestionResponse;
import javax.inject.Inject;
import io.reactivex.Flowable;

/**
 * Created by ANKUR JAIN on 28-06-2017.
 */

public class DbRepository implements BaseRepository {


    /**
     * To be implemented
     */

    @Inject
    public DbRepository() {
        /**
         * To be implemented
         */
    }

    @Override
    public Flowable<QuestionResponse> getQuestions() {
        return null;
    }
}
