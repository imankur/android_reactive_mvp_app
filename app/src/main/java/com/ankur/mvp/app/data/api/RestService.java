package com.ankur.mvp.app.data.api;

import com.ankur.mvp.app.model.QuestionResponse;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ANKUR JAIN on 28-06-2017.
 */

public interface RestService {
    @GET("questions?site=stackoverflow")
    Flowable<QuestionResponse> loadQuestionsByTag(@Query("tagged") String tag);
}
