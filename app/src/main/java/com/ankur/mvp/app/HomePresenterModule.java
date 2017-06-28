package com.ankur.mvp.app;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Sharing Happiness on 6/23/2017.
 */

@Module
public class HomePresenterModule {

    private HomeContract.View view;

    public HomePresenterModule(HomeContract.View view) {
        this.view = view;
    }

    @Provides
    public HomeContract.View provideView() {
        return view;
    }
}

