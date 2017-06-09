package org.cuieney.videolife.kotlin.di

import okhttp3.OkHttpClient
import org.cuieney.videolife.common.api.*
import org.cuieney.videolife.common.utils.DelegatesExt
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * Created by cuieney on 2017/5/19.
 */

class RetrofitHelper @Inject constructor(client: OkHttpClient) {

    var httpClient = client
    fun <T> getApiService(baseUrl: String, cls: Class<T>): T {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        return retrofit.create(cls)
    }


    fun getKyApiService(): KyApiService {
        return getApiService(UrlManager.KAIYAN_HOST, KyApiService::class.java)
    }

    fun getWyApiService(): WyApiService{
        return getApiService(UrlManager.WANGYI_HOST, WyApiService::class.java)
    }

    fun getOpApiService(): OpApiService{
        return getApiService(UrlManager.YIREN_HOST, OpApiService::class.java)
    }

    fun getVeerApiService():VeerApiService{
        return getApiService(UrlManager.VEER_HOST, VeerApiService::class.java)
    }

    fun getKuulaApiService():KuulaApiService{
        return getApiService(UrlManager.KUULA_HOST, KuulaApiService::class.java)
    }
}