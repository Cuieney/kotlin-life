package org.cuieney.videolife.kotlin.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import me.yokeyword.fragmentation.SupportFragment
import org.cuieney.videolife.kotlin.App
import org.cuieney.videolife.kotlin.di.component.DaggerAppComponent
import org.cuieney.videolife.kotlin.di.component.DaggerFragmentComponent
import org.cuieney.videolife.kotlin.di.component.FragmentComponent
import org.cuieney.videolife.kotlin.di.module.AppModule
import org.cuieney.videolife.kotlin.di.module.FragmentModule
import org.cuieney.videolife.kotlin.di.module.RetrofitModule
import javax.inject.Inject

/**
 * Created by cuieney on 2017/5/22.
 */
abstract class BaseFragment<T:BasePresenter> : SupportFragment(),BaseView{
    @Inject
    lateinit var mPresenter: T
    lateinit var mView: View
    lateinit var mActivity: Activity
    lateinit var mContext: Context
    lateinit var mUnBinder: Unbinder
    var isInited :Boolean = false

    override fun onAttach(context: Context) {
        mActivity = context as Activity
        mContext = context
        super.onAttach(context)
    }


    protected fun getFragmentComponent(): FragmentComponent {

        return DaggerFragmentComponent.builder()
                .appComponent(App.instance.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build()
    }

    protected fun getFragmentModule(): FragmentModule {
        return FragmentModule(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater!!.inflate(getLayoutId(), null)
        initInject()
        return mView
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mUnBinder = ButterKnife.bind(this, view!!)
        if (savedInstanceState == null) {
            if (!isHidden) {
                isInited = true
                initEventAndData()
            }
        } else {
            if (!isHidden) {
                isInited = true
                initEventAndData()
            }
        }
    }


    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!isInited && !hidden) {
            isInited = true
            initEventAndData()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mUnBinder.unbind()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    protected abstract fun initInject()
    protected abstract fun getLayoutId(): Int
    protected abstract fun initEventAndData()
}