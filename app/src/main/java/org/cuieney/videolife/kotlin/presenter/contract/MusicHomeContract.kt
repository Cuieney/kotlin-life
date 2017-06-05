package org.cuieney.videolife.kotlin.presenter.contract

import org.cuieney.videolife.entity.MusicListBean
import org.cuieney.videolife.kotlin.base.BasePresenter
import org.cuieney.videolife.kotlin.base.BaseView

/**
 * Created by cuieney on 2017/6/5.
 */
interface MusicHomeContract {
    interface View : BaseView {
        fun showContent(musicListBean: MutableList<MusicListBean>)
        fun error(throwable: Throwable)
    }

    interface Presenter : BasePresenter {
        fun getMusicData(date: String, view: View)
    }
}