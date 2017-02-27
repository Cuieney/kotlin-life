package org.cuieney.videolife.di.module;

import android.content.Context;


import org.cuieney.videolife.App;
import org.cuieney.videolife.common.api.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
public class AppModule {

    public final App mApp;


    public AppModule(App mApp) {
        this.mApp = mApp;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return mApp;
    }

    @Provides
    ApiService providesApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

}
