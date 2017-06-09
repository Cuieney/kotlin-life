package org.cuieney.videolife.kotlin.presenter

import org.cuieney.videolife.common.api.KuulaApiService
import org.cuieney.videolife.common.api.OpApiService
import org.cuieney.videolife.common.utils.RxUtil
import org.cuieney.videolife.entity.KuulaListBean
import org.cuieney.videolife.entity.MusicListBean
import org.cuieney.videolife.kotlin.base.RxPresenter
import org.cuieney.videolife.kotlin.presenter.contract.KuulaHomeContract
import javax.inject.Inject


/**
 * Created by cuieney on 2017/6/8.
 */
class KuulaHomePresenter @Inject
constructor(private val mRetrofitHelper: KuulaApiService): RxPresenter(), KuulaHomeContract.Presenter {

    override fun getVrCategoryData(view: KuulaHomeContract.View, offset: Int) {
        addSubscrebe(mRetrofitHelper.getKuulaList(offset)
                .compose<KuulaListBean>(RxUtil.rxSchedulerHelper<KuulaListBean>())
                .subscribe({ t -> view.showContent(t) }) { throwable -> view.error(throwable) }
        )
    }

}