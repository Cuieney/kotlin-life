package org.cuieney.videolife.common.api;

import org.cuieney.videolife.entity.EssayDetailBean;
import org.cuieney.videolife.entity.EssayListBean;
import org.cuieney.videolife.entity.VideoListBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cuieney on 2017/5/17.
 */
public interface OpApiService {
    @GET("channel/reading/more/{id}?platform=ios&uuid=850717CA-9EF7-429E-92B3-6B88B479A476&user_id=&version=v4.2.1")
    Observable<EssayListBean> getEssayList(@Path("id") int id);


    @GET("essay/{id}?platform=ios&uuid=850717CA-9EF7-429E-92B3-6B88B479A476&user_id=&version=v4.2.1&source=channel_reading")
    Observable<EssayDetailBean> getEssayDetail(@Path("id") int id, @Query("source_id") int sourceId);

}
