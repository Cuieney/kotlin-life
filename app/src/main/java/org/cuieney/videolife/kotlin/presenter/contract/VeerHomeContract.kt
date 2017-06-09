package org.cuieney.videolife.kotlin.presenter.contract

import org.cuieney.videolife.entity.MusicListBean
import org.cuieney.videolife.entity.VeerListBean

/**
 * Created by cuieney on 2017/6/7.
 */
interface VeerHomeContract{
    interface View{
        fun showContent(veerListBean: VeerListBean)
        fun error(throwable: Throwable)
    }
    interface Presenter{
        fun getVrData(view:View,days:String,pageNo:Int)
    }
}