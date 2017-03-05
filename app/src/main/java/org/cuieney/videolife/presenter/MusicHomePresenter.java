package org.cuieney.videolife.presenter;

import org.cuieney.videolife.common.api.WyApiService;
import org.cuieney.videolife.common.base.RxPresenter;
import org.cuieney.videolife.common.utils.RxUtil;
import org.cuieney.videolife.presenter.contract.MusicHomeContract;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by cuieney on 17/3/4.
 */

public class MusicHomePresenter extends RxPresenter<MusicHomeContract.View> implements MusicHomeContract.Presenter {
    private WyApiService mRetrofitHelper;

    @Inject
    public MusicHomePresenter(WyApiService mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getMusicData(String pagerNo) {
        Subscription rxSubscription = mRetrofitHelper.getMusicList(pagerNo)
                .compose(RxUtil.rxSchedulerHelper())
                .subscribe(musicListBean -> {
                    mView.showContent(musicListBean);
                }, throwable -> {
                    mView.error(throwable);
                });
        addSubscrebe(rxSubscription);
    }
}
