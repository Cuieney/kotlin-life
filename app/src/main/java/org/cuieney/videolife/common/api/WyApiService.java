package org.cuieney.videolife.common.api;

import org.cuieney.videolife.entity.MusicListBean;
import org.cuieney.videolife.entity.VideoListBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cuieney on 17/2/28.
 */

public interface WyApiService {

    @GET("/ting?from=android&version=5.6.5.6&format=json&method=baidu.ting.diy.gedan")
    Observable<MusicListBean> getMusicList(@Query("page_size") String pageSie, @Query("page_no") String pageNo);
}
