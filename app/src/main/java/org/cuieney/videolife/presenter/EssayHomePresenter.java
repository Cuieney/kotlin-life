package org.cuieney.videolife.presenter;

import org.cuieney.videolife.common.api.OpApiService;
import org.cuieney.videolife.common.api.WyApiService;
import org.cuieney.videolife.common.base.RxPresenter;
import org.cuieney.videolife.common.utils.RxUtil;
import org.cuieney.videolife.entity.EssayListBean;
import org.cuieney.videolife.entity.VideoListBean;
import org.cuieney.videolife.presenter.contract.EssayHomeContract;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by cuieney on 2017/5/17.
 */

public class EssayHomePresenter extends RxPresenter<EssayHomeContract.View> implements EssayHomeContract.Presenter {

    private OpApiService mRetrofitHelper;

    @Inject
    public EssayHomePresenter(OpApiService mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getEssayData(int id) {
        Subscription rxSubscription = mRetrofitHelper.getEssayList(id)
                .compose(RxUtil.rxSchedulerHelper())
                .subscribe(essayListBean -> mView.showContent(essayListBean.getData()), throwable -> mView.error(throwable));
        addSubscrebe(rxSubscription);
    }
}
