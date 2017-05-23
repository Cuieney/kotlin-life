package org.cuieney.videolife.kotlin.presenter.contract

import org.cuieney.videolife.entity.EssayDetailBean
import org.cuieney.videolife.entity.YiRenBean.DataBean
import org.cuieney.videolife.kotlin.base.BasePresenter
import org.cuieney.videolife.kotlin.base.BaseView

/**
 * Created by cuieney on 2017/5/23.
 */

interface EssayHomeDetailContract{
    interface View : BaseView {
        fun showContent(essayDetail: EssayDetailBean)
        fun error(throwable: Throwable)
    }

    interface Presenter : BasePresenter {
         fun getEssayDetailData(id: Int, sourceId: Int,view:View)
    }
}
