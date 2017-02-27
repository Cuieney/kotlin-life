package org.cuieney.videolife.common.api;


import org.cuieney.videolife.entity.VideoListBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {

    @GET("https://baobab.kaiyanapp.com/api/v4/tabs/selected")
    Observable<VideoListBean> getVideoList(@Query("date") String date);
}
