package org.cuieney.videolife.kotlin.presenter.contract

import org.cuieney.videolife.entity.VeerListBean
import org.cuieney.videolife.entity.VideoListBean
import org.cuieney.videolife.kotlin.base.BasePresenter
import org.cuieney.videolife.kotlin.base.BaseView

/**
 * Created by cuieney on 2017/6/2.
 */
interface VideoHomeContract {
    interface View : BaseView {
        fun showContent(data: VideoListBean)
        fun error(throwable: Throwable)
    }

    interface Presenter : BasePresenter {
        fun getVideoData(date: String, view: View)
    }
}