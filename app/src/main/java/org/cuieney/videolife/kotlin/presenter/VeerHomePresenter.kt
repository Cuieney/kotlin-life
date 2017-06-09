package org.cuieney.videolife.kotlin.presenter

import org.cuieney.videolife.common.api.VeerApiService
import org.cuieney.videolife.common.utils.RxUtil
import org.cuieney.videolife.entity.VeerListBean
import org.cuieney.videolife.kotlin.base.RxPresenter
import org.cuieney.videolife.kotlin.presenter.contract.VeerHomeContract
import org.cuieney.videolife.kotlin.presenter.contract.VideoHomeContract
import javax.inject.Inject

/**
 * Created by cuieney on 2017/6/7.
 */
class VeerHomePresenter @Inject
constructor(val mRetrofitHelper: VeerApiService) : RxPresenter(), VeerHomeContract.Presenter {
    override fun getVrData(view: VeerHomeContract.View, days: String, pageNo: Int) {
        addSubscrebe(
                mRetrofitHelper.getVeer(days, pageNo)
                        .compose<VeerListBean>(RxUtil.rxSchedulerHelper<VeerListBean>())
                        .subscribe({ t: VeerListBean -> view.showContent(t) }) { throwable -> view.error(throwable) }
        )
    }

}
