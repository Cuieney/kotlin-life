package org.cuieney.videolife.kotlin.common.okhttp

import android.content.Context
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import org.cuieney.videolife.kotlin.common.utils.SystemUtil
import java.io.IOException

/**
 * Created by cuieney on 2017/6/5.
 */
class CacheInterceptor(var context: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (!SystemUtil.isNetworkConnected()) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build()
        }
        val response = chain.proceed(request)
        if (SystemUtil.isNetworkConnected()) {
            val maxAge = 0
            // 有网络时, 不缓存, 最大保存时长为0
            response.newBuilder()
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .removeHeader("Pragma")
                    .build()
        } else {
            // 无网络时，设置超时为4周
            val maxStale = 60 * 60 * 24 * 28
            response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .removeHeader("Pragma")
                    .build()
        }
        return response
    }
}