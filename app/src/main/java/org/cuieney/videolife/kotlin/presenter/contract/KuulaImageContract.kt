package org.cuieney.videolife.kotlin.presenter.contract

import org.cuieney.videolife.entity.KuulaImageBean
import org.cuieney.videolife.entity.KuulaListBean
import org.cuieney.videolife.entity.VeerListBean

/**
 * Created by cuieney on 2017/6/8.
 */
interface KuulaImageContract{
    interface View{
        fun showContent(kuulaImageBean: KuulaImageBean)
        fun error(throwable: Throwable)
    }
    interface Presenter{
        fun getVrCategoryData(view:View,id:String)
    }
}