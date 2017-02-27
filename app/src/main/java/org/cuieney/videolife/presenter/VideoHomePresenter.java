package org.cuieney.videolife.presenter;

import org.cuieney.videolife.common.api.ApiService;
import org.cuieney.videolife.common.base.RxPresenter;
import org.cuieney.videolife.common.utils.RxUtil;
import org.cuieney.videolife.presenter.contract.VideoHomeContract;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by cuieney on 17/2/24.
 */

public class VideoHomePresenter extends RxPresenter<VideoHomeContract.View> implements VideoHomeContract.Presenter{

    private ApiService mRetrofitHelper;

    @Inject
    public VideoHomePresenter(ApiService mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getVideoData(String date) {
        Subscription rxSubscription = mRetrofitHelper.getVideoList(date)
                .compose(RxUtil.rxSchedulerHelper())
                .subscribe(videoListBean -> {
                    mView.showContent(videoListBean);
                }, throwable -> {
                    mView.error(throwable);
                });
        addSubscrebe(rxSubscription);
    }
}
