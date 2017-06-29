package com.ankur.mvp.app.data.api;

import javax.inject.Named;
import dagger.Module;
import dagger.Provides;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ANKUR JAIN on 28-06-2017.
 */
@Module
public class RestServiceModule {
    private static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    @Provides
    @Named(BASE_URL)
    String provideBaseUrl() {
        return BASE_URL;
    }

    @Provides
//    @Singleton
    CallAdapter.Factory provideRxJavaAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
//    @Singleton
    Converter.Factory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
//    @Singleton
    Retrofit provideRetrofit(@Named(BASE_URL) String baseUrl, Converter.Factory converterFactory,
                             CallAdapter.Factory callAdapterFactory) {
        return new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build();
    }

    @Provides
//    @Singleton
    RestService provideQuestionService(Retrofit retrofit) {
        return retrofit.create(RestService.class);
    }
}
