package org.cuieney.videolife.kotlin.presenter

import org.cuieney.videolife.common.api.WyApiService
import org.cuieney.videolife.common.utils.RxUtil
import org.cuieney.videolife.entity.MusicListBean
import org.cuieney.videolife.kotlin.base.RxPresenter
import org.cuieney.videolife.kotlin.presenter.contract.MusicHomeContract
import javax.inject.Inject

/**
 * Created by cuieney on 2017/6/5.
 */
class MusicHomePresenter
@Inject constructor(val retrofitHelper: WyApiService) : RxPresenter(), MusicHomeContract.Presenter {

    override fun getMusicData(date: String, view: MusicHomeContract.View) {
        val rxSubscription = retrofitHelper.getMusicList(date)
                .compose<MutableList<MusicListBean>>(RxUtil.rxSchedulerHelper<MutableList<MusicListBean>>())
                .subscribe({ t -> view.showContent(t) }) { throwable -> view.error(throwable) }
        addSubscrebe(rxSubscription)
    }

}
