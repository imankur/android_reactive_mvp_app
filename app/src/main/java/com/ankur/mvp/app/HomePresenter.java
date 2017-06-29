package com.ankur.mvp.app;

import com.ankur.mvp.app.data.QuestionRepository;
import com.ankur.mvp.app.model.QuestionResponse;
import javax.inject.Inject;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Sharing Happiness on 6/23/2017.
 */

public class HomePresenter implements HomeContract.Presenter {

    QuestionRepository repository;
    HomeContract.View mView;

    @Inject
    public HomePresenter(HomeContract.View view, QuestionRepository repository) {
        this.repository = repository;
        this.mView = view;
    }

    @Override
    public void start() {
        getQuestions();
    }

    @Override
    public void getQuestions() {
        Flowable<QuestionResponse> respose = repository.getQuestions();
        respose.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<QuestionResponse>() {
                    @Override
                    public void onNext(QuestionResponse questionResponse) {
                        mView.setDataInList(questionResponse.getQuestions());
                    }

                    @Override
                    public void onError(Throwable t) {
                        mView.showErrors();
                    }

                    @Override
                    public void onComplete() {
                        mView.hideProgressBar();
                    }
                });
    }


}