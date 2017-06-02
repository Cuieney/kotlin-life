package org.cuieney.videolife.kotlin.base

import android.content.Context
import me.yokeyword.fragmentation.SupportFragment
import org.cuieney.videolife.kotlin.ui.fragment.video.VideoFragment

/**
 * Created by cuieney on 2017/5/22.
 */
abstract class BaseMainFragment : SupportFragment() {
    protected var _mBackToFirstListener: OnBackToFirstListener? = null

    interface OnBackToFirstListener {
        fun onBackToFirstFragment()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnBackToFirstListener) {
            _mBackToFirstListener = context as OnBackToFirstListener
        } else {
            throw RuntimeException(context.toString() + " must implement OnBackToFirstListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        _mBackToFirstListener = null
    }

    /**
     * 处理回退事件

     * @return
     */
    override fun onBackPressedSupport(): Boolean {
        if (childFragmentManager.backStackEntryCount > 1) {
            popChild()
        } else {
            if (this is VideoFragment) {   // 如果是 第一个Fragment 则退出app
                _mActivity.finish()
            } else {                                    // 如果不是,则回到第一个Fragment
                _mBackToFirstListener!!.onBackToFirstFragment()
            }
        }


        return true
    }

}
