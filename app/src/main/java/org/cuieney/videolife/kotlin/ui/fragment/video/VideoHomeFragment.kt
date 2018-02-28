package org.cuieney.videolife.kotlin.ui.fragment.video

import android.os.Build
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.transition.Fade
import android.transition.Slide
import android.util.Log
import android.view.View
import org.cuieney.videolife.R
import org.cuieney.videolife.entity.YiRenBean.DataBean
import org.cuieney.videolife.kotlin.base.BaseFragment
import org.cuieney.videolife.kotlin.presenter.EssayHomePresenter
import org.cuieney.videolife.kotlin.presenter.contract.EssayHomeContract
import kotlinx.android.synthetic.main.video_home_fragment.*
import kotlinx.android.synthetic.main.video_item.view.*
import me.yokeyword.fragmentation.SupportFragment
import org.cuieney.videolife.common.base.DetailTransition
import org.cuieney.videolife.common.component.EventUtil
import org.cuieney.videolife.entity.VideoListBean
import org.cuieney.videolife.entity.kaiyanBean.ItemListBean
import org.cuieney.videolife.kotlin.presenter.VideoHomePresenter
import org.cuieney.videolife.kotlin.presenter.contract.VideoHomeContract
import org.cuieney.videolife.kotlin.ui.adapter.BaseAdapter
import org.cuieney.videolife.kotlin.ui.adapter.VideoAdapter
import org.cuieney.videolife.ui.fragment.video.VideoDetailFragment
import org.cuieney.videolife.ui.widget.EndLessOnScrollListener

/**
 * Created by cuieney on 2017/5/31.
 */
class VideoHomeFragment : BaseFragment<VideoHomePresenter>(), VideoHomeContract.View {
    lateinit var date: String
    lateinit var adapter: VideoAdapter
    lateinit var mVideoListBean: ArrayList<ItemListBean>

    override fun showContent(videoListBean: VideoListBean) {

        if (refresh.isRefreshing) {
            refresh.isRefreshing = false
            adapter.clearAndAddNews(videoListBean.getItemList())
            mVideoListBean.clear()
            recycler.adapter = adapter
        } else {
            adapter.addNews(videoListBean.getItemList())
        }
        mVideoListBean.addAll(videoListBean.getItemList())

        val end = videoListBean.getNextPageUrl().lastIndexOf("&num")
        val start = videoListBean.getNextPageUrl().lastIndexOf("date=")
        date = videoListBean.getNextPageUrl().substring(start + 5, end)
    }

    override fun error(throwable: Throwable) {
    }

    override fun initInject() {
        getFragmentComponent().inject(this)
    }

    override fun getLayoutId(): Int = R.layout.video_home_fragment
    override fun initEventAndData() {

        refresh.setProgressViewOffset(false, 100, 200)
        refresh.setOnRefreshListener { mPresenter.getVideoData("",this) }

        val layout = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recycler.layoutManager = layout
        mVideoListBean = java.util.ArrayList<ItemListBean>()

        adapter = VideoAdapter(mVideoListBean)
        adapter.setOnClickListener(object : BaseAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, view: View, vh: RecyclerView.ViewHolder) {
                startChildFragment(mVideoListBean[position],vh as VideoAdapter.MyHolder)
            }
        })
        recycler.adapter = adapter
        recycler.addOnScrollListener(object : EndLessOnScrollListener(layout, 0) {
            override fun onLoadMore() {
                getData(date)
            }
        })
        getData("")
    }

    fun getData(date:String){
        mPresenter.getVideoData(date,this)
    }

    private fun startChildFragment(videoListBean: ItemListBean, vh: VideoAdapter.MyHolder) {
        EventUtil.sendEvent(true.toString() + "")
        val fragment = VideoDetailFragment(
                videoListBean.data)
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
                    .addSharedElement(vh.itemView.img, getString(R.string.image_transition))
                    .start(fragment)
        }else{
            start(fragment)
        }
    }

}