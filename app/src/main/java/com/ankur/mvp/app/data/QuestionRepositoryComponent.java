package com.ankur.mvp.app.data;


import com.ankur.mvp.app.data.api.RestServiceModule;

import dagger.Component;

/**
 * Created by ANKUR JAIN on 28-06-2017.
 */
@Component(modules = {QuestionRepositoryModule.class, RestServiceModule.class})
public interface QuestionRepositoryComponent {
    QuestionRepository getRepository();
}
