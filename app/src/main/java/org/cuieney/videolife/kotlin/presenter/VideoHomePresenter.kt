package org.cuieney.videolife.kotlin.presenter

import org.cuieney.videolife.common.api.KyApiService
import org.cuieney.videolife.common.utils.RxUtil
import org.cuieney.videolife.entity.VideoListBean
import org.cuieney.videolife.kotlin.base.RxPresenter
import org.cuieney.videolife.kotlin.presenter.contract.VideoHomeContract
import javax.inject.Inject

/**
 * Created by cuieney on 2017/6/2.
 */
class VideoHomePresenter
@Inject constructor(val retrofitHelper: KyApiService) : RxPresenter(), VideoHomeContract.Presenter {

    override fun getVideoData(date: String, view: VideoHomeContract.View) {
        val rxSubscription = retrofitHelper.getVideoList(date)
                .compose<VideoListBean>(RxUtil.rxSchedulerHelper<VideoListBean>())
                .subscribe({ t -> view.showContent(t) }) { throwable -> view.error(throwable) }
        addSubscrebe(rxSubscription)
    }
}