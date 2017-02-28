package org.cuieney.videolife.common.okhttp;

import android.content.Context;


import org.cuieney.videolife.common.net.NetWorkUtil;
import org.cuieney.videolife.common.utils.SystemUtil;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * 项目名称：ProjectFunction
 * 类描述： Okhttp缓存设置
 * 创建人：zhangwei
 * 创建时间：16/6/19 下午2:21
 * 修改人：zhangwei
 * 修改时间：16/6/19 下午2:21
 * 修改备注：
 */
public class CacheInterceptor implements Interceptor {
    public Context context;

    public CacheInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!SystemUtil.isNetworkConnected()) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }
        Response response = chain.proceed(request);
        if (SystemUtil.isNetworkConnected()) {
            int maxAge = 0;
            // 有网络时, 不缓存, 最大保存时长为0
            response.newBuilder()
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .removeHeader("Pragma")
                    .build();
        } else {
            // 无网络时，设置超时为4周
            int maxStale = 60 * 60 * 24 * 28;
            response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .removeHeader("Pragma")
                    .build();
        }
        return response;
    }
}