package org.cuieney.videolife.kotlin.ui.fragment.music

import android.os.Build
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.transition.Fade
import android.transition.Slide
import android.view.View
import org.cuieney.videolife.R
import org.cuieney.videolife.entity.MusicListBean
import org.cuieney.videolife.kotlin.base.BaseFragment
import org.cuieney.videolife.kotlin.presenter.MusicHomePresenter
import org.cuieney.videolife.kotlin.presenter.contract.MusicHomeContract
import kotlinx.android.synthetic.main.music_home_fragment.*
import kotlinx.android.synthetic.main.music_item.view.*
import me.yokeyword.fragmentation.SupportFragment
import org.cuieney.videolife.common.base.DetailTransition
import org.cuieney.videolife.common.component.EventUtil
import org.cuieney.videolife.kotlin.ui.adapter.BaseAdapter
import org.cuieney.videolife.kotlin.ui.adapter.MusicAdapter
import org.cuieney.videolife.ui.widget.EndLessOnScrollListener
import java.util.*

/**
 * Created by cuieney on 2017/6/5.
 */
class MusicHomeFragment : BaseFragment<MusicHomePresenter>(), MusicHomeContract.View {

    lateinit var mMusicList: ArrayList<MusicListBean>
    lateinit var adapter: MusicAdapter
    var pager = 1


    override fun showContent(musicListBean: MutableList<MusicListBean>) {
        musicListBean.add(0, MusicListBean())
        musicListBean.add(0, MusicListBean())
        if (refresh.isRefreshing) {
            refresh.isRefreshing = false
            pager = 1
            mMusicList.clear()
            adapter.clearAndAddNews(musicListBean)
            recycler.adapter = adapter
        } else {
            adapter.addNews(musicListBean)
            pager++
        }
        mMusicList.addAll(musicListBean)
    }

    override fun error(throwable: Throwable) {

    }

    override fun initInject() {
        getFragmentComponent().inject(this)
    }

    override fun getLayoutId(): Int = R.layout.music_home_fragment

    override fun initEventAndData() {
        refresh.setProgressViewOffset(false, 100, 200)
        refresh.setOnRefreshListener { getDate("1") }
        val layout = GridLayoutManager(activity, 2)
        recycler.layoutManager = layout
        recycler.addOnScrollListener(object : EndLessOnScrollListener(layout, 1) {
            override fun onLoadMore() {
                getDate(pager.toString())
            }
        })
        mMusicList = ArrayList<MusicListBean>()
        adapter = MusicAdapter(mMusicList)
        recycler.adapter = adapter
        adapter.setOnClickListener(object : BaseAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, view: View, vh: RecyclerView.ViewHolder) {
                startChildFragment(mMusicList[position], vh)
            }
        })
        getDate(pager.toString())
    }

    fun getDate(index: String) {
        mPresenter.getMusicData(index, this)
    }

    private fun startChildFragment(musicListBean: MusicListBean, vh: RecyclerView.ViewHolder) {
        EventUtil.sendEvent(true.toString() + "")
        val fragment = MusicDetailFragment(
                musicListBean
        )
        // 这里是使用SharedElement的用例

        // LOLLIPOP(5.0)系统的 SharedElement支持有 系统BUG， 这里判断大于 > LOLLIPOP
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            exitTransition = Fade()
            fragment.enterTransition = Slide()
            fragment.sharedElementReturnTransition = DetailTransition()
            fragment.sharedElementEnterTransition = DetailTransition()

            // 25.1.0以下的support包,Material过渡动画只有在进栈时有,返回时没有;
            // 25.1.0+的support包，SharedElement正常
            extraTransaction()
                    .addSharedElement((vh as MusicAdapter.MyViewHoler).itemView.img, getString(R.string.image_transition))
                    .start(fragment)
        }else{
            start(fragment)
        }
    }

}