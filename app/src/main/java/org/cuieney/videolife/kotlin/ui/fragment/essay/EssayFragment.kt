package org.cuieney.videolife.kotlin.ui.fragment.essay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.cuieney.videolife.R
import org.cuieney.videolife.kotlin.base.BaseMainFragment
import org.cuieney.videolife.kotlin.ui.fragment.EssayHomeFragment

/**
 * Created by cuieney on 2017/5/22.
 */
class EssayFragment: BaseMainFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.essay_fragment, container, false)
        return view
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        if (findChildFragment(EssayHomeFragment::class.java) == null) {
            loadRootFragment(R.id.fl_first_container, EssayHomeFragment())
        }
    }
}