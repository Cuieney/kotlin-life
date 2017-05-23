package org.cuieney.videolife.kotlin.base

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import butterknife.ButterKnife
import butterknife.Unbinder
import me.yokeyword.fragmentation.SupportActivity
import org.cuieney.videolife.App

/**
 * Created by cuieney on 2017/5/22.
 */
abstract class SimpleActivity : SupportActivity() {

    lateinit var mContext: Activity
    lateinit var mUnBinder: Unbinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        mUnBinder = ButterKnife.bind(this)
        mContext = this
        App.getInstance().addActivity(this)
        initEventAndData()
    }

    protected fun setToolBar(toolbar: Toolbar, title: String) {
        toolbar.title = title
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressedSupport() }
    }

    override fun onDestroy() {
        super.onDestroy()
        App.getInstance().removeActivity(this)
        mUnBinder.unbind()
    }

    protected abstract val layout: Int
    protected abstract fun initEventAndData()
}
