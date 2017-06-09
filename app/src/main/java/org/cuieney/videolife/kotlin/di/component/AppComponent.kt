package org.cuieney.videolife.kotlin.di.component

import android.content.Context
import dagger.Component
import org.cuieney.videolife.common.api.*
import org.cuieney.videolife.kotlin.di.module.AppModule
import org.cuieney.videolife.kotlin.di.module.RetrofitModule
import javax.inject.Singleton

/**
 * Created by cuieney on 2017/5/22.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, RetrofitModule::class))
interface AppComponent{
     fun getContext(): Context
     fun getKyApiService(): KyApiService
     fun getWyApiService(): WyApiService
     fun getOpApiService(): OpApiService
     fun getKuulaApiService(): KuulaApiService
     fun getVeerApiService(): VeerApiService
}