package org.cuieney.videolife.kotlin.ui.fragment

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
import kotlinx.android.synthetic.main.essay_home_fragment.*
import kotlinx.android.synthetic.main.essay_item.view.*
import me.yokeyword.fragmentation.SupportFragment
import org.cuieney.videolife.common.base.DetailTransition
import org.cuieney.videolife.common.component.EventUtil
import org.cuieney.videolife.kotlin.presenter.contract.EssayHomeContract
import org.cuieney.videolife.kotlin.ui.adapter.EssayAdapter
import org.cuieney.videolife.ui.widget.EndLessOnScrollListener

/**
 * Created by cuieney on 2017/5/22.
 */
class EssayHomeFragment : BaseFragment<EssayHomePresenter>(), EssayHomeContract.View {

    override fun showContent(dataBeanList: List<DataBean>) {
        if (refresh.isRefreshing) {
            refresh.isRefreshing = false
            pager = 0
            adapter.clearAndAddNews(dataBeanList)
            mEssayList.clear()
            recycler.adapter = adapter
        } else {
            adapter.addNews(dataBeanList)
            val size = dataBeanList.size
            val id = dataBeanList[size - 1].id
            Log.e("oye", "showContent: " + id)
            pager = Integer.parseInt(id)
        }
        mEssayList.addAll(dataBeanList)
    }

    override fun error(throwable: Throwable) {
        Log.e("oey",throwable.message)
    }


    lateinit var mEssayList: ArrayList<DataBean>
    var pager = 0
    lateinit var adapter: EssayAdapter

    override fun initInject() {
        getFragmentComponent().inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.essay_home_fragment
    }


    override fun initEventAndData() {
        refresh.setProgressViewOffset(false, 100, 200)
        refresh.setOnRefreshListener {
            getDate()
        }
        val layout = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
        recycler.layoutManager = layout
        recycler.addOnScrollListener(object : EndLessOnScrollListener(layout,1){
            override fun onLoadMore() {
                getDate()
            }

        })

        mEssayList = arrayListOf()
        adapter = EssayAdapter(mEssayList)
        recycler.adapter = adapter

        adapter.setOnClickListener(object :EssayAdapter.OnItemClickListener{
            override fun onItemClick(position: Int, view: View, vh: RecyclerView.ViewHolder) {
                startChildFragment(mEssayList[position],vh)
            }
        })

        getDate()
    }

    fun getDate() {
        mPresenter.getEssayData(pager, this)
    }

    private fun startChildFragment(dataBean: DataBean, vh: RecyclerView.ViewHolder) {
        EventUtil.sendEvent(true.toString() + "")
        var id = dataBean.id
        var sourceId = dataBean.item_id
        val fragment = EssayHomeDetailFragment(id, sourceId)
        // 这里是使用SharedElement的用例

        // LOLLIPOP(5.0)系统的 SharedElement支持有 系统BUG， 这里判断大于 > LOLLIPOP
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            exitTransition = Fade()
            fragment.enterTransition = Slide()
            fragment.sharedElementReturnTransition = DetailTransition()
            fragment.sharedElementEnterTransition = DetailTransition()

            // 25.1.0以下的support包,Material过渡动画只有在进栈时有,返回时没有;
            // 25.1.0+的support包，SharedElement正常
//            fragment.transaction()
//                    .addSharedElement((vh as EssayAdapter.EssayHomeHolder).itemView.image, getString(R.string.image_transition))
//                    .commit<SupportFragment>()

            extraTransaction()
                    .addSharedElement((vh as EssayAdapter.EssayHomeHolder).itemView.image, getString(R.string.image_transition))
                    .start(fragment)
        }else{
            start(fragment)
        }
    }

}
