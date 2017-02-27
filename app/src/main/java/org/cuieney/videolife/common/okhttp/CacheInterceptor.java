package org.cuieney.videolife.common.okhttp;

import android.content.Context;


import org.cuieney.videolife.common.net.NetWorkUtil;

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
        if (!NetWorkUtil.isNetworkAvailable(context)) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }
        Response originalResponse = chain.proceed(request);
        if (NetWorkUtil.isNetworkAvailable(context)) {
            //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
            String cacheControl = request.cacheControl().toString();
            return originalResponse.newBuilder()
                    .header("Cache-Control", cacheControl)
                    .removeHeader("Pragma")
                    .build();
        } else {
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                    .removeHeader("Pragma")
                    .build();
        }
    }
}