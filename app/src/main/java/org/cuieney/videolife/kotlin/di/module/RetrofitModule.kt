package org.cuieney.videolife.kotlin.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import org.cuieney.videolife.common.okhttp.CookiesManager
import org.cuieney.videolife.common.utils.AppConfig
import org.cuieney.videolife.di.HttpLoggingInterceptor
import org.cuieney.videolife.kotlin.common.okhttp.CacheInterceptor
import java.security.cert.X509Certificate

/**
 * Created by cuieney on 2017/5/22.
 */
@Module class RetrofitModule(ctx: android.content.Context){
    var context: android.content.Context = ctx

    @Provides
    fun provideGson(): Gson = GsonBuilder().serializeNulls().create();

    class XtmImp: javax.net.ssl.X509TrustManager {
        override fun checkClientTrusted(p0: Array<out X509Certificate>?, p1: String?) {
        }

        override fun checkServerTrusted(p0: Array<out X509Certificate>?, p1: String?) {
        }

        override fun getAcceptedIssuers(): Array<X509Certificate> {
            val x509Certificates:Array<X509Certificate> = arrayOf()
            return x509Certificates
        }

    }

    class DO_NOT_VERIFY_IMP: javax.net.ssl.HostnameVerifier {
        override fun verify(p0: String?, p1: javax.net.ssl.SSLSession?): Boolean {
            return true
        }

    }

    @Provides
    fun provideOkhttpClient(cache: Cache, cacheInterceptor: CacheInterceptor, cookiesManager: CookiesManager): okhttp3.OkHttpClient {
        val xtm : RetrofitModule.XtmImp = RetrofitModule.XtmImp()
        val sslContext = javax.net.ssl.SSLContext.getInstance("SSL")
        try {
            sslContext.init(null, arrayOf<javax.net.ssl.TrustManager>(xtm), java.security.SecureRandom())
        } catch (e: java.security.NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: java.security.KeyManagementException) {
            e.printStackTrace()
        }
        val DO_NOT_VERIFY = RetrofitModule.DO_NOT_VERIFY_IMP()

        val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor();
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return okhttp3.OkHttpClient().newBuilder()
                .cache(cache)//添加缓存
                .addInterceptor(loggingInterceptor)
                .addInterceptor(cacheInterceptor)
                .sslSocketFactory(sslContext.getSocketFactory())
                .hostnameVerifier(DO_NOT_VERIFY)
//                .cookieJar(cookiesManager)
                .build();

    }

    @Provides
    fun providesCacheInterceptor(): CacheInterceptor {
        return CacheInterceptor(context)
    }

    @Provides
    fun provideCache(): okhttp3.Cache {
        return okhttp3.Cache(context.getExternalFilesDir(AppConfig.DEFAULT_JOSN_CACHE), AppConfig.DEFAULT_CACHE_SIZE)
    }

    @Provides
    fun providesCookies(): CookiesManager {
        return CookiesManager()
    }
}