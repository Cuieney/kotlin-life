package org.cuieney.videolife.kotlin.presenter.contract

import org.cuieney.videolife.entity.YiRenBean.DataBean
import org.cuieney.videolife.kotlin.base.BasePresenter
import org.cuieney.videolife.kotlin.base.BaseView


/**
 * Created by cuieney on 2017/5/17.
 */
interface EssayHomeContract {
    interface View : BaseView {
        fun showContent(dataBeanList: List<DataBean>)
        fun error(throwable: Throwable)
    }

    interface Presenter : BasePresenter {
        fun getEssayData(id: Int,mView: View)
    }
}
