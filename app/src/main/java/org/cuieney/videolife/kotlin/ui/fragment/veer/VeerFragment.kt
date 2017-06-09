package org.cuieney.videolife.kotlin.ui.fragment.veer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.cuieney.videolife.R
import org.cuieney.videolife.kotlin.base.BaseMainFragment
import org.cuieney.videolife.kotlin.ui.fragment.music.MusicHomeFragment

/**
 * Created by cuieney on 2017/6/7.
 */
class VeerFragment : BaseMainFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.veer_fragment, container, false)
        return view
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_first_container, VeerHomeFragment())
        }
    }
}