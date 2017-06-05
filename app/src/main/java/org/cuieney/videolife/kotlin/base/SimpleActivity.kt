package org.cuieney.videolife.kotlin.base

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.Toolbar
import android.view.View
import butterknife.ButterKnife
import butterknife.Unbinder
import me.yokeyword.fragmentation.SupportActivity
import android.support.v7.app.AppCompatDelegate.setCompatVectorFromResourcesEnabled
import org.cuieney.videolife.kotlin.App


/**
 * Created by cuieney on 2017/5/22.
 */
abstract class SimpleActivity : SupportActivity() {

    lateinit var mContext: Activity


    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        super.onCreate(savedInstanceState)
        setContentView(layout)
        mContext = this
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
    }

    protected abstract val layout: Int
    protected abstract fun initEventAndData()
}
