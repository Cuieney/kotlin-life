package org.cuieney.videolife.kotlin.presenter

import org.cuieney.videolife.common.api.OpApiService
import org.cuieney.videolife.common.utils.RxUtil
import org.cuieney.videolife.entity.EssayListBean
import org.cuieney.videolife.kotlin.base.RxPresenter
import org.cuieney.videolife.kotlin.presenter.contract.EssayHomeContract

import javax.inject.Inject


/**
 * Created by cuieney on 2017/5/17.
 */

class EssayHomePresenter @Inject
constructor(val mRetrofitHelper: OpApiService) :RxPresenter(), EssayHomeContract.Presenter {

    override fun getEssayData(id: Int,mView: EssayHomeContract.View) {
        val rxSubscription = mRetrofitHelper.getEssayList(id)
                .compose<EssayListBean>(RxUtil.rxSchedulerHelper<EssayListBean>())
                .subscribe({ essayListBean -> mView.showContent(essayListBean.data) }) { throwable -> mView.error(throwable) }
        addSubscrebe(rxSubscription)
    }
}
