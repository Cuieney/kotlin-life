package org.cuieney.videolife.kotlin.base

import org.cuieney.videolife.common.component.RxBus
import rx.Subscription
import rx.functions.Action1
import rx.subscriptions.CompositeSubscription

/**
 * Created by cuieney on 2017/5/22.
 */
open class RxPresenter : BasePresenter {

     var mCompositeSubscription: CompositeSubscription? = null

     fun unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription!!.unsubscribe()
        }
    }

     fun addSubscrebe(subscription: Subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = CompositeSubscription()
        }
        mCompositeSubscription!!.add(subscription)
    }

     fun <U> addRxBusSubscribe(eventType: Class<U>, act: Action1<U>) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = CompositeSubscription()
        }
        mCompositeSubscription!!.add(RxBus.getDefault().toDefaultObservable(eventType, act))
    }

}