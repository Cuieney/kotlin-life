package org.cuieney.videolife.kotlin.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.cuieney.videolife.common.okhttp.CacheInterceptor
import org.cuieney.videolife.common.okhttp.CookiesManager
import org.cuieney.videolife.common.utils.AppConfig
import org.cuieney.videolife.di.HttpLoggingInterceptor
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*

/**
 * Created by cuieney on 2017/5/22.
 */
@dagger.Module class RetrofitModule(ctx: android.content.Context){
    var context: android.content.Context = ctx

    @dagger.Provides
    fun provideGson(): com.google.gson.Gson = com.google.gson.GsonBuilder().serializeNulls().create();

    class XtmImp: javax.net.ssl.X509TrustManager {
        override fun checkClientTrusted(p0: Array<out java.security.cert.X509Certificate>?, p1: String?) {
        }

        override fun checkServerTrusted(p0: Array<out java.security.cert.X509Certificate>?, p1: String?) {
        }

        override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
            val x509Certificates:Array<java.security.cert.X509Certificate> = arrayOf()
            return x509Certificates
        }

    }

    class DO_NOT_VERIFY_IMP: javax.net.ssl.HostnameVerifier {
        override fun verify(p0: String?, p1: javax.net.ssl.SSLSession?): Boolean {
            return true
        }

    }

    @dagger.Provides
    fun provideOkhttpClient(cache: okhttp3.Cache, cacheInterceptor: org.cuieney.videolife.common.okhttp.CacheInterceptor, cookiesManager: org.cuieney.videolife.common.okhttp.CookiesManager): okhttp3.OkHttpClient {
        var xtm : org.cuieney.videolife.kotlin.di.module.RetrofitModule.XtmImp = org.cuieney.videolife.kotlin.di.module.RetrofitModule.XtmImp()
        var sslContext = javax.net.ssl.SSLContext.getInstance("SSL")
        try {
            sslContext.init(null, arrayOf<javax.net.ssl.TrustManager>(xtm), java.security.SecureRandom())
        } catch (e: java.security.NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: java.security.KeyManagementException) {
            e.printStackTrace()
        }
        var DO_NOT_VERIFY = org.cuieney.videolife.kotlin.di.module.RetrofitModule.DO_NOT_VERIFY_IMP()

        var loggingInterceptor: org.cuieney.videolife.di.HttpLoggingInterceptor = org.cuieney.videolife.di.HttpLoggingInterceptor();
        loggingInterceptor.level = org.cuieney.videolife.di.HttpLoggingInterceptor.Level.BODY
        return okhttp3.OkHttpClient().newBuilder()
                .cache(cache)//添加缓存
                .addInterceptor(loggingInterceptor)
                .addInterceptor(cacheInterceptor)
                .sslSocketFactory(sslContext.getSocketFactory())
                .hostnameVerifier(DO_NOT_VERIFY)
//                .cookieJar(cookiesManager)
                .build();

    }

    @dagger.Provides
    fun providesCacheInterceptor(): org.cuieney.videolife.common.okhttp.CacheInterceptor {
        return org.cuieney.videolife.common.okhttp.CacheInterceptor(context)
    }

    @dagger.Provides
    fun provideCache(): okhttp3.Cache {
        return okhttp3.Cache(context.getExternalFilesDir(org.cuieney.videolife.common.utils.AppConfig.DEFAULT_JOSN_CACHE), AppConfig.DEFAULT_CACHE_SIZE)
    }

    @dagger.Provides
    fun providesCookies(): org.cuieney.videolife.common.okhttp.CookiesManager {
        return org.cuieney.videolife.common.okhttp.CookiesManager()
    }
}