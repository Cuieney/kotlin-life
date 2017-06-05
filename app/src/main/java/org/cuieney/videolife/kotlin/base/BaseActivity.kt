package org.cuieney.videolife.kotlin.base

import android.app.Activity
import android.os.Bundle
import butterknife.ButterKnife
import butterknife.Unbinder
import me.yokeyword.fragmentation.SupportActivity
import org.cuieney.videolife.kotlin.App
import org.cuieney.videolife.kotlin.di.component.ActivityComponent
import org.cuieney.videolife.kotlin.di.component.DaggerActivityComponent
import org.cuieney.videolife.kotlin.di.module.ActivityModule
import javax.inject.Inject

/**
 * Created by cuieney on 2017/5/22.
 */

abstract class BaseActivity<T : BasePresenter> : SupportActivity(), BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var mContext: Activity

    private lateinit var mUnBinder: Unbinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        mUnBinder = ButterKnife.bind(this)
        mContext = this
        initInject()
        initEventAndData()
    }

    override fun onDestroy() {
        super.onDestroy()
        mUnBinder.unbind()
    }

    protected fun getActivityComponent(): ActivityComponent {
        return DaggerActivityComponent.builder()
                .appComponent(App.appComponent)
                .activityModule(getActivityModule())
                .build()
    }

    protected fun getActivityModule(): ActivityModule {
        return ActivityModule(this)
    }


    protected abstract fun initInject()
    protected abstract fun getLayout(): Int
    protected abstract fun initEventAndData()
}