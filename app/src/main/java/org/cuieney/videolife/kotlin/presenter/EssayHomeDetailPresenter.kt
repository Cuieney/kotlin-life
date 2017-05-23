package org.cuieney.videolife.kotlin.presenter

import org.cuieney.videolife.common.api.OpApiService
import org.cuieney.videolife.common.utils.RxUtil
import org.cuieney.videolife.entity.EssayDetailBean
import org.cuieney.videolife.kotlin.base.RxPresenter
import org.cuieney.videolife.kotlin.presenter.contract.EssayHomeDetailContract
import javax.inject.Inject

/**
 * Created by cuieney on 2017/5/23.
 */
class EssayHomeDetailPresenter @Inject
constructor(private val mRetrofitHelper: OpApiService) : RxPresenter(), EssayHomeDetailContract.Presenter {

    override fun getEssayDetailData(id: Int, sourceId: Int,mView:EssayHomeDetailContract.View) {
        val rxSubscription = mRetrofitHelper.getEssayDetail(id, sourceId)
                .compose(RxUtil.rxSchedulerHelper<EssayDetailBean>())
                .subscribe({ essayDetailBean -> mView.showContent(essayDetailBean) }) { throwable -> mView.error(throwable) }
        addSubscrebe(rxSubscription)
    }
}