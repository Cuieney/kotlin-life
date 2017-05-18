package org.cuieney.videolife.di;

import org.cuieney.videolife.common.api.OpApiService;
import org.cuieney.videolife.common.api.UrlManager;
import org.cuieney.videolife.common.api.KyApiService;
import org.cuieney.videolife.common.api.WyApiService;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by cuieney on 17/2/28.
 */

public class RetrofitHelper {

    OkHttpClient client;

    private KyApiService kyApiService;
    private WyApiService wyApiService;
    private OpApiService opApiService;

    @Inject
    public RetrofitHelper(OkHttpClient client) {
        this.client = client;
        init();
    }

    private void init() {
        kyApiService = getApiService(UrlManager.KAIYAN_HOST,KyApiService.class);
        wyApiService = getApiService(UrlManager.WANGYI_HOST,WyApiService.class);
        opApiService = getApiService(UrlManager.YIREN_HOST,OpApiService.class);

    }
    private <T> T getApiService(String baseUrl, Class<T> clz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(clz);
    }

    public KyApiService getKyApiService() {
        return kyApiService;
    }

    public WyApiService getWyApiService(){
        return wyApiService;
    }

    public OpApiService getOpApiService() {
        return opApiService;
    }
}
