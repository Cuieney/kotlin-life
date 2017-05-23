package org.cuieney.videolife.kotlin.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import org.cuieney.videolife.common.api.KyApiService
import org.cuieney.videolife.common.api.OpApiService
import org.cuieney.videolife.common.api.WyApiService
import org.cuieney.videolife.kotlin.App
import org.cuieney.videolife.kotlin.di.RetrofitHelper
import javax.inject.Singleton


/**
 * Created by cuieney on 2017/5/22.
 */

@Module class AppModule(mApp: App){
    var app: App = mApp

    @Provides
    @Singleton
    fun providesContext(): Context = app

    @Provides
    @Singleton
    fun proviesKyService(retrofitHelper: RetrofitHelper): KyApiService {
        return retrofitHelper.getKyApiService()
    }

    @Provides
    @Singleton
    fun proviesWyService(retrofitHelper: RetrofitHelper): WyApiService {
        return retrofitHelper.getWyApiService()
    }

    @Provides
    @Singleton
    fun proviesOpService(retrofitHelper: RetrofitHelper): OpApiService {
        return retrofitHelper.getOpApiService()
    }

}