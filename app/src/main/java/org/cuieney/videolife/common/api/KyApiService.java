package org.cuieney.videolife.common.api;

import org.cuieney.videolife.entity.VideoListBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cuieney on 17/2/28.
 */

public interface KyApiService {
    @GET("tabs/selected")
    Observable<VideoListBean> getVideoList(@Query("date") String date);
}
