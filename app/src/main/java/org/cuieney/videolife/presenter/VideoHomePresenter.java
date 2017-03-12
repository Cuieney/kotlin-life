package org.cuieney.videolife.presenter;

import org.cuieney.videolife.common.api.KyApiService;
import org.cuieney.videolife.common.base.RxPresenter;
import org.cuieney.videolife.common.utils.RxUtil;
import org.cuieney.videolife.presenter.contract.VideoHomeContract;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by cuieney on 17/2/24.
 */

public class VideoHomePresenter extends RxPresenter<VideoHomeContract.View> implements VideoHomeContract.Presenter{

    private KyApiService mRetrofitHelper;

    @Inject
    public VideoHomePresenter(KyApiService mRetrofitHelper) {
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
