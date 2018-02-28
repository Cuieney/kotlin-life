package org.cuieney.videolife.kotlin.ui.act

import android.graphics.Color
import android.util.Log
import android.view.View
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationBar.BACKGROUND_STYLE_RIPPLE
import com.ashokvarma.bottomnavigation.BottomNavigationBar.MODE_FIXED
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.jaeger.library.StatusBarUtil
import org.cuieney.videolife.R
import kotlinx.android.synthetic.main.design_layout.*
import me.yokeyword.fragmentation.SupportFragment
import org.cuieney.videolife.common.component.EventUtil

import org.cuieney.videolife.common.component.RxBus
import org.cuieney.videolife.kotlin.base.BaseMainFragment
import org.cuieney.videolife.kotlin.base.SimpleActivity
import org.cuieney.videolife.kotlin.ui.fragment.essay.EssayFragment
import org.cuieney.videolife.kotlin.ui.fragment.music.MusicFragment
import org.cuieney.videolife.kotlin.ui.fragment.veer.VeerFragment
import org.cuieney.videolife.kotlin.ui.fragment.video.VideoFragment
import org.greenrobot.eventbus.Subscribe
import java.util.ArrayList

/**
 * Created by cuieney on 2017/6/2.
 */
open class MainActivity : SimpleActivity(), BaseMainFragment.OnBackToFirstListener {
    override val layout: Int = R.layout.design_layout


    lateinit var mFragments: ArrayList<SupportFragment>
    override fun initEventAndData() {
        mFragments = ArrayList<SupportFragment>()
        mFragments.add(VideoFragment())
        mFragments.add(MusicFragment())
        mFragments.add(EssayFragment())
        mFragments.add(VeerFragment())
        loadMultipleRootFragment(R.id.act_container, 0, mFragments[0], mFragments[1], mFragments[2], mFragments[3])

        initView()
    }


    private fun initView() {
        bottom_navigation_bar
                .addItem(BottomNavigationItem(R.drawable.movie_icon, "movie").setActiveColor("#6c4a41").setInActiveColor("#CCCCCC"))
                .addItem(BottomNavigationItem(R.drawable.music_icon, "music").setActiveColor("#008867"))
                .addItem(BottomNavigationItem(R.drawable.book_icon, "essay").setActiveColor("#8b6b64"))
                .addItem(BottomNavigationItem(R.drawable.panorama_icon, "panorama").setActiveColor("#485A66"))
                .initialise()
        bottom_navigation_bar.setBackgroundStyle(BACKGROUND_STYLE_RIPPLE)
        bottom_navigation_bar.setMode(MODE_FIXED)
        bottom_navigation_bar.setAutoHideEnabled(true)

        bottom_navigation_bar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabSelected(position: Int) {
                showHideFragment(mFragments[position])
                when (position) {
                    0 -> StatusBarUtil.setColor(this@MainActivity, Color.parseColor("#6c4a41"))
                    1 -> StatusBarUtil.setColor(this@MainActivity, Color.parseColor("#008867"))
                    2 -> StatusBarUtil.setColor(this@MainActivity, Color.parseColor("#8b6b64"))
                    3 -> StatusBarUtil.setColor(this@MainActivity, Color.parseColor("#485A66"))
                }
            }

            override fun onTabUnselected(position: Int) {}

            override fun onTabReselected(position: Int) {}
        })

    }


    @Subscribe
    fun hide(isHide: String) {
        if (isHide == "true") {
            floating_search_view.setVisibility(View.GONE)
        } else if(isHide == "false"){
            floating_search_view.setVisibility(View.VISIBLE)
        } else if(isHide == "tab_false"){
            floating_search_view.setVisibility(View.VISIBLE)
            bottom_navigation_bar.setVisibility(View.VISIBLE)
        }else if(isHide == "tab_true"){
            floating_search_view.setVisibility(View.GONE)
            bottom_navigation_bar.setVisibility(View.GONE)
        }
    }

    override fun onStart() {
        super.onStart()
        EventUtil.register(this)
    }


    override fun onDestroy() {
        super.onDestroy()
        EventUtil.unregister(this)
    }

    override fun onBackToFirstFragment() {
        bottom_navigation_bar.selectTab(0)
    }
}