package org.cuieney.videolife.kotlin.ui.fragment.video

import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.graphics.Palette
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.konifar.fab_transformation.FabTransformation
import org.cuieney.videolife.R
import org.cuieney.videolife.entity.kaiyanBean.DataBean
import org.cuieney.videolife.kotlin.base.BaseBackFragment
import kotlinx.android.synthetic.main.video_home_detail_fragment.*
import org.cuieney.videolife.common.image.ImageLoader
import org.cuieney.videolife.common.utils.DateUtil
import org.cuieney.videolife.common.utils.LogUtil
import org.cuieney.videolife.kotlin.common.utils.JumpUtils

/**
 * Created by cuieney on 2017/6/2.
 */
class VideoDetailFragment(dataBean: DataBean) :BaseBackFragment(){

    lateinit var dataBean:DataBean
    init {
        val bundle = Bundle()
        bundle.putParcelable(ARG_ITEM,dataBean)
        arguments = bundle
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBean = arguments.getParcelable(ARG_ITEM)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater!!.inflate(R.layout.video_home_detail_fragment, container, false)
        return inflate
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    fun initView(){
        fab.setBackgroundTintList(ColorStateList(arrayOf(IntArray(0)), intArrayOf(0xffffcc00.toInt())))
        toolbar.title = ""

        initToolbarNav(toolbar)
        ImageLoader.loadAll(activity, dataBean.cover.detail, img_detail)
        ImageLoader.loadAll(activity, dataBean.cover.blurred, bg_image)
        title.text = dataBean.title
        val stringBuilder = StringBuilder()
        stringBuilder.append("#").append(dataBean.category)
                .append(" ")
                .append(" / ")
                .append(" ")
                .append(DateUtil.formatTime2(dataBean.duration.toLong()))
        type.text = stringBuilder.toString()
        description.text = dataBean.description

        fab.setOnClickListener({ v ->
            if (fab.getVisibility() == View.VISIBLE) {
                FabTransformation.with(fab).setListener(object : FabTransformation.OnTransformListener {
                    override fun onStartTransform() {}

                    override fun onEndTransform() {
                        JumpUtils.goToVideoPlayer(activity, img_detail, dataBean)
                    }
                }).transformTo(img_detail)
            }
        })

        initColor()

    }


    internal var color = 0xffffcc00.toInt()

    private fun initColor() {

        Glide.with(context).load(dataBean.cover.blurred).asBitmap().into(object : SimpleTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, glideAnimation: GlideAnimation<in Bitmap>) {

                Palette.from(resource).generate { palette ->
                    try {
                        color = palette.darkMutedSwatch!!.rgb
                    } catch (e: Exception) {
//                        LogUtil.d(e.message)
                    }

                    toolbar_layout.setContentScrimColor(color)
                    fab.setBackgroundTintList(ColorStateList(arrayOf(IntArray(0)), intArrayOf(color)))

                }

            }
        })
    }

    override fun onResume() {
        super.onResume()
        FabTransformation.with(fab).setListener(object : FabTransformation.OnTransformListener {
            override fun onStartTransform() {

            }

            override fun onEndTransform() {
                if (img_detail.getVisibility() == View.INVISIBLE) {
                    img_detail.setVisibility(View.VISIBLE)
                }
            }
        }).transformFrom(img_detail)
    }
}