package org.cuieney.videolife.common.api;

import org.cuieney.videolife.entity.KuulaImageBean;
import org.cuieney.videolife.entity.KuulaListBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cuieney on 2017/6/8.
 */

public interface KuulaApiService {
    @GET("?action=explore&tag=featured&limit=12&time=0&app=vr")
    Observable<KuulaListBean> getKuulaList(@Query("offset") int offset);

    @GET("?action=get&app=vr")
    Observable<KuulaImageBean> getKuulaImage(@Query("id") String id);

}
