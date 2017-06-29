package com.ankur.mvp.app;

import com.ankur.mvp.app.data.QuestionRepositoryComponent;
import dagger.Component;

/**
 * Created by Sharing Happiness on 6/23/2017.
 */

@Component(modules = HomePresenterModule.class, dependencies = QuestionRepositoryComponent.class)
public interface HomePresenterComponent {
    void inject(HomeActivity activity);
}
