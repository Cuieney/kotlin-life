package org.cuieney.videolife.common.api;

import org.cuieney.videolife.entity.VeerListBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cuieney on 2017/6/6.
 */

public interface VeerApiService {
    @GET("overall_featured_videos")
    Observable<VeerListBean> getVeer(@Query("days") String days,@Query("page") int page);


    @GET("categories/{id}")
    Observable<VeerListBean> getCatagory(@Path("id")int id,@Query("order") String order, @Query("page") int page);


}
