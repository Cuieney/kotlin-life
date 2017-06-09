package org.cuieney.videolife.kotlin.presenter.contract

import org.cuieney.videolife.entity.VeerListBean

/**
 * Created by cuieney on 2017/6/8.
 */
interface VeerCategoryContract{
    interface View{
        fun showContent(veerListBean: VeerListBean)
        fun error(throwable: Throwable)
    }
    interface Presenter{
        fun getVrCategoryData(view:View,id:Int,order:String,pageNo:Int)
    }
}