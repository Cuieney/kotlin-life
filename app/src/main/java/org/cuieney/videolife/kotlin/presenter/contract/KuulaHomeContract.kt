package org.cuieney.videolife.kotlin.presenter.contract

import org.cuieney.videolife.entity.KuulaListBean
import org.cuieney.videolife.entity.VeerListBean

/**
 * Created by cuieney on 2017/6/8.
 */
interface KuulaHomeContract{
    interface View{
        fun showContent(kuulaListBean: KuulaListBean)
        fun error(throwable: Throwable)
    }
    interface Presenter{
        fun getVrCategoryData(view:View,offset:Int)
    }
}