package org.cuieney.videolife.kotlin.base

import android.app.Activity
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT
import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.Toolbar
import android.view.View
import butterknife.ButterKnife
import butterknife.Unbinder
import me.yokeyword.fragmentation.SupportActivity
import android.support.v7.app.AppCompatDelegate.setCompatVectorFromResourcesEnabled
import com.jaeger.library.StatusBarUtil
import me.yokeyword.fragmentation.Fragmentation
import org.cuieney.videolife.kotlin.App


/**
 * Created by cuieney on 2017/5/22.
 */
abstract class SimpleActivity : SupportActivity() {

    lateinit var mContext: Activity


    override fun onCreate(savedInstanceState: Bundle?) {
//        val decorView = window.decorView
//        val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//        decorView.systemUiVisibility = option
//        StatusBarUtil.setTransparent(this)
//        requestedOrientation = SCREEN_ORIENTATION_REVERSE_PORTRAIT
//        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
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
