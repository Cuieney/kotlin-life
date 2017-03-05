package org.cuieney.videolife.common.api;

import org.cuieney.videolife.entity.MusicListBean;
import org.cuieney.videolife.entity.wyBean.TracksBean;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by cuieney on 17/2/28.
 */

public interface WyApiService {

    @GET("mgmagazinelist/r/10/page/{id}/sign=2230926e0bb334c908c9f7fabdaf42014e1afb31c17cd4d53b52fcd3bc34d501&api_key=08b1e567157582019f7fe639c841c42a&timestrap=1488600156")
    Observable<List<MusicListBean>> getMusicList(@Path("id") String id);
}
