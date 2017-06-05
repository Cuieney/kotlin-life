package org.cuieney.videolife.kotlin.ui.fragment.music

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.cuieney.videolife.R
import org.cuieney.videolife.kotlin.base.BaseMainFragment

/**
 * Created by cuieney on 2017/6/2.
 */
class MusicFragment : BaseMainFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.music_fragment, container, false)
        return view
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_first_container, MusicHomeFragment())
        }
    }
}