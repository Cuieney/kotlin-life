package org.cuieney.videolife.presenter;

import org.cuieney.videolife.common.api.OpApiService;
import org.cuieney.videolife.common.base.RxPresenter;
import org.cuieney.videolife.common.utils.RxUtil;
import org.cuieney.videolife.entity.EssayDetailBean;
import org.cuieney.videolife.presenter.contract.EssayHomeDetailContract;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by cuieney on 2017/5/17.
 */

public class EssayHomeDetailPresenter extends RxPresenter<EssayHomeDetailContract.View> implements EssayHomeDetailContract.Presenter {

    private OpApiService mRetrofitHelper;

    @Inject
    public EssayHomeDetailPresenter(OpApiService mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getEssayDetailData(int id, int sourceId) {
        Subscription rxSubscription = mRetrofitHelper.getEssayDetail(id,sourceId)
                .compose(RxUtil.rxSchedulerHelper())
                .subscribe(essayDetailBean -> mView.showContent(essayDetailBean), throwable -> mView.error(throwable));
        addSubscrebe(rxSubscription);
    }
}
