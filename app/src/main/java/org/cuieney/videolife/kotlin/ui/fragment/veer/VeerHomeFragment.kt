package org.cuieney.videolife.kotlin.ui.fragment.veer

import android.content.Intent
import android.os.Build
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.transition.Fade
import android.transition.Slide
import android.view.View
import kotlinx.android.synthetic.main.essay_item.view.*
import kotlinx.android.synthetic.main.music_home_fragment.*
import kotlinx.android.synthetic.main.music_item.view.*
import me.yokeyword.fragmentation.SupportFragment
import org.cuieney.videolife.R
import org.cuieney.videolife.common.base.DetailTransition
import org.cuieney.videolife.common.component.EventUtil
import org.cuieney.videolife.entity.KuulaListBean
import org.cuieney.videolife.entity.YiRenBean.DataBean
import org.cuieney.videolife.kotlin.base.BaseFragment
import org.cuieney.videolife.kotlin.presenter.KuulaHomePresenter
import org.cuieney.videolife.kotlin.presenter.contract.KuulaHomeContract
import org.cuieney.videolife.kotlin.ui.act.VrActivity
import org.cuieney.videolife.kotlin.ui.adapter.BaseAdapter
import org.cuieney.videolife.kotlin.ui.adapter.EssayAdapter
import org.cuieney.videolife.kotlin.ui.adapter.KuulaAdapter
import org.cuieney.videolife.kotlin.ui.fragment.EssayHomeDetailFragment
import org.cuieney.videolife.ui.widget.EndLessOnScrollListener
import java.util.ArrayList

/**
 * Created by cuieney on 2017/6/7.
 *
 */

class VeerHomeFragment : BaseFragment<KuulaHomePresenter>(), KuulaHomeContract.View {

    lateinit var mKuulaList: ArrayList<KuulaListBean.PayloadBean.PostsBean>
    lateinit var adapter: KuulaAdapter
    var pager = 0

    override fun showContent(kuulaListBean: KuulaListBean) {
        mKuulaList.add(0, KuulaListBean.PayloadBean.PostsBean())
        mKuulaList.add(0, KuulaListBean.PayloadBean.PostsBean())
        if (refresh.isRefreshing) {
            refresh.isRefreshing = false
            pager = 0
            mKuulaList.clear()
            adapter.clearAndAddNews(kuulaListBean.payload.posts)
            recycler.adapter = adapter
        } else {
            adapter.addNews(kuulaListBean.payload.posts)
            pager++
        }
        mKuulaList.addAll(kuulaListBean.payload.posts)
    }

    override fun error(throwable: Throwable) {
    }

    override fun initInject() {
        getFragmentComponent().inject(this)
    }


    fun getDate(index: Int) {
        mPresenter.getVrCategoryData(this, index)
    }

    override fun getLayoutId(): Int = R.layout.veer_home_fragment

    override fun initEventAndData() {
        refresh.setProgressViewOffset(false, 100, 200)
        refresh.setOnRefreshListener { getDate(0) }
        val layout = GridLayoutManager(activity, 2)
        recycler.layoutManager = layout
        recycler.addOnScrollListener(object : EndLessOnScrollListener(layout, 1) {
            override fun onLoadMore() {
                getDate(pager)
            }
        })
        mKuulaList = ArrayList<KuulaListBean.PayloadBean.PostsBean>()
        adapter = KuulaAdapter(mKuulaList)
        recycler.adapter = adapter
        adapter.setOnClickListener(object : BaseAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, view: View, vh: RecyclerView.ViewHolder) {
                startChildFragment(mKuulaList[position], vh)
            }
        })
        getDate(pager)
    }



    private fun startChildFragment(dataBean: KuulaListBean.PayloadBean.PostsBean, vh: RecyclerView.ViewHolder) {
        startActivity(Intent(mContext,VrActivity::class.java).putExtra("id",dataBean.id))
//        EventUtil.sendEvent("tab_true")
//        val fragment = VeerDetailFragment(dataBean.id)
//        // 这里是使用SharedElement的用例
//
//        // LOLLIPOP(5.0)系统的 SharedElement支持有 系统BUG， 这里判断大于 > LOLLIPOP
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
//            exitTransition = Fade()
//            fragment.enterTransition = Slide()
//            fragment.sharedElementReturnTransition = DetailTransition()
//            fragment.sharedElementEnterTransition = DetailTransition()
//
//            // 25.1.0以下的support包,Material过渡动画只有在进栈时有,返回时没有;
//            // 25.1.0+的support包，SharedElement正常
//            fragment.transaction()
//                    .addSharedElement((vh as KuulaAdapter.MyViewHoler).itemView.img, getString(R.string.image_transition))
//                    .commit<SupportFragment>()
//        }
//        start(fragment)
    }
}