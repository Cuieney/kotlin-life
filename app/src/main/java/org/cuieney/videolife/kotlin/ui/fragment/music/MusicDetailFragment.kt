package org.cuieney.videolife.kotlin.ui.fragment.music

import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.graphics.Palette
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.google.gson.Gson
import com.konifar.fab_transformation.FabTransformation
import com.ms.square.android.expandabletextview.ExpandableTextView
import org.cuieney.videolife.R
import org.cuieney.videolife.common.image.ImageLoader
import org.cuieney.videolife.common.utils.DelegatesExt.preference
import org.cuieney.videolife.entity.MusicListBean
import org.cuieney.videolife.kotlin.base.BaseBackFragment
import kotlinx.android.synthetic.main.music_home_detail_fragment.*
import org.cuieney.videolife.common.utils.LogUtil
import org.cuieney.videolife.entity.wyBean.TracksBean
import org.cuieney.videolife.kotlin.ui.adapter.MusicItemAdapter
import org.cuieney.videolife.kotlin.common.utils.JumpUtils

/**
 * Created by cuieney on 2017/6/5.
 */
class MusicDetailFragment(dataBean: MusicListBean) : BaseBackFragment() {

    lateinit var dataBean: MusicListBean
    init {
        val bundle = Bundle()
        bundle.putParcelable(ARG_ITEM,dataBean)
        arguments = bundle
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBean = arguments.getParcelable(ARG_ITEM)
        preference(context,"JSON", Gson().toJson(dataBean.tracks))
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater!!.inflate(R.layout.music_home_detail_fragment, container, false)
        return inflate
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    fun initView() {
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        initColor()
        toolbar.title = ""
        initToolbarNav(toolbar)
        ImageLoader.loadAll(activity, dataBean.ophoto, img_detail)
        recycler.setLoadingMoreEnabled(false)
        recycler.setPullRefreshEnabled(false)
        recycler.adapter = MusicItemAdapter(dataBean.tracks as ArrayList<TracksBean>)
        initHeadView()

        fab.setOnClickListener({ v ->
            if (fab.visibility == View.VISIBLE) {
                FabTransformation.with(fab).setListener(object : FabTransformation.OnTransformListener {
                    override fun onStartTransform() {}

                    override fun onEndTransform() {
                        JumpUtils.goToMusicPlayer(activity,img_detail, dataBean)
                    }
                }).transformTo(img_detail)
            }
        })
    }

    private fun initHeadView() {
        val inflate = LayoutInflater.from(context).inflate(R.layout.music_detial_top_item, null)
        val title = inflate.findViewById(R.id.title) as TextView
        val expandableTextView = inflate.findViewById(R.id.expand_text_view) as ExpandableTextView
        expandableTextView.text = dataBean.mdesc
        title.text = dataBean.mname
        recycler.addHeaderView(inflate)
    }

    internal var color = 0xffffcc00.toInt()
    private fun initColor() {
        Glide.with(context).load(dataBean.ophoto).asBitmap().into(object : SimpleTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, glideAnimation: GlideAnimation<in Bitmap>) {

                Palette.from(resource).generate { palette ->
                    try {
                        color = palette.lightMutedSwatch!!.rgb
                    } catch (e: Exception) {
                        LogUtil.d(e.message)
                    }

                    toolbar_layout.setContentScrimColor(color)
                    fab.backgroundTintList = ColorStateList(arrayOf(IntArray(0)), intArrayOf(color))

                }

            }
        })
    }


}