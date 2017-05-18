package org.cuieney.videolife.di.component;


import android.content.Context;

import org.cuieney.videolife.common.api.KyApiService;
import org.cuieney.videolife.common.api.OpApiService;
import org.cuieney.videolife.common.api.WyApiService;
import org.cuieney.videolife.di.module.AppModule;
import org.cuieney.videolife.di.module.RetrofitModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cuieney on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, RetrofitModule.class})
public interface AppComponent {
    Context getContext();
    KyApiService getKyApiService();
    WyApiService getWyApiService();
    OpApiService getOpApiService();
}
