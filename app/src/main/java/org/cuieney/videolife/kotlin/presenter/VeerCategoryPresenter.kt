package org.cuieney.videolife.kotlin.presenter

import org.cuieney.videolife.common.api.VeerApiService
import org.cuieney.videolife.common.utils.RxUtil
import org.cuieney.videolife.entity.VeerListBean
import org.cuieney.videolife.kotlin.base.RxPresenter
import org.cuieney.videolife.kotlin.presenter.contract.VeerCategoryContract
import org.cuieney.videolife.kotlin.presenter.contract.VeerHomeContract
import org.cuieney.videolife.kotlin.presenter.contract.VideoHomeContract
import javax.inject.Inject

/**
 * Created by cuieney on 2017/6/7.
 */
class VeerCategoryPresenter @Inject
constructor(val mRetrofitHelper: VeerApiService) : RxPresenter(), VeerCategoryContract.Presenter {
    override fun getVrCategoryData(view: VeerCategoryContract.View, id: Int, order: String, pageNo: Int) {
        addSubscrebe(
                mRetrofitHelper.getCatagory(id, order, pageNo)
                        .compose<VeerListBean>(RxUtil.rxSchedulerHelper<VeerListBean>())
                        .subscribe({ t: VeerListBean -> view.showContent(t) }) { throwable -> view.error(throwable) }
        )
    }

}
