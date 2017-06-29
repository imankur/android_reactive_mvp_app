package com.ankur.mvp.app.data;

import com.ankur.mvp.app.data.api.RestRepository;
import javax.inject.Named;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ANKUR JAIN on 28-06-2017.
 */
@Module
public class QuestionRepositoryModule {
    @Provides
    @Named("rest")
    BaseRepository getRestRepo(RestRepository rest) {
        return rest;
    }
}
