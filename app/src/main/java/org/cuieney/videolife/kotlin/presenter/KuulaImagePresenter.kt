package org.cuieney.videolife.kotlin.presenter

import org.cuieney.videolife.common.api.KuulaApiService
import org.cuieney.videolife.common.api.OpApiService
import org.cuieney.videolife.common.utils.RxUtil
import org.cuieney.videolife.entity.KuulaImageBean
import org.cuieney.videolife.entity.KuulaListBean
import org.cuieney.videolife.entity.MusicListBean
import org.cuieney.videolife.kotlin.base.RxPresenter
import org.cuieney.videolife.kotlin.presenter.contract.KuulaHomeContract
import org.cuieney.videolife.kotlin.presenter.contract.KuulaImageContract
import javax.inject.Inject


/**
 * Created by cuieney on 2017/6/8.
 */
class KuulaImagePresenter @Inject
constructor(private val mRetrofitHelper: KuulaApiService): RxPresenter(), KuulaImageContract.Presenter {

    override fun getVrCategoryData(view: KuulaImageContract.View, id: String) {
        addSubscrebe(mRetrofitHelper.getKuulaImage(id)
                .compose<KuulaImageBean>(RxUtil.rxSchedulerHelper<KuulaImageBean>())
                .subscribe({ t -> view.showContent(t) }) { throwable -> view.error(throwable) }
        )
    }

}