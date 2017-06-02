package org.cuieney.videolife.kotlin.base

import android.support.v7.widget.Toolbar
import me.yokeyword.fragmentation.SupportFragment
import org.cuieney.videolife.R
import org.cuieney.videolife.common.component.EventUtil

/**
 * Created by cuieney on 2017/5/22.
 */
abstract class BaseBackFragment : SupportFragment() {

    protected fun initToolbarNav(toolbar: Toolbar) {
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp)
        toolbar.setNavigationOnClickListener { v -> _mActivity.onBackPressed() }
        toolbar.inflateMenu(R.menu.video_menu)

    }

    override fun onBackPressedSupport(): Boolean {
        EventUtil.sendEvent(false.toString() + "")
        return super.onBackPressedSupport()

    }

    companion object {
        val ARG_ITEM = "arg_item"
    }
}