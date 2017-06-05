package org.cuieney.videolife.kotlin.ui.adapter

import android.content.Context
import android.graphics.Bitmap
import android.support.v4.view.PagerAdapter
import android.support.v7.graphics.Palette
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import org.cuieney.videolife.common.utils.LogUtil
import org.cuieney.videolife.entity.wyBean.TracksBean
import java.lang.ref.WeakReference
import kotlinx.android.synthetic.main.play_music_item.view.*
import org.cuieney.videolife.R
import org.cuieney.videolife.common.image.ImageLoader
import java.util.ArrayList

/**
 * Created by cuieney on 2017/6/5.
 */
class CoverFlowAdapter(private val list: List<TracksBean>?, var context: Context) : PagerAdapter() {
    private val inflater: LayoutInflater
    private val viewList: MutableList<WeakReference<View>>

    init {
        this.inflater = LayoutInflater.from(context)
        viewList = ArrayList<WeakReference<View>>()
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view: View? = null
        // 从废弃的里去取 取到则使用 取不到则创建
        if (viewList.size > 0) {
            if (viewList[0] != null) {
                view = initView(viewList[0].get(), position)
                viewList.removeAt(0)
            }
        }
        view = initView(null, position)

        container.addView(view)

        return view
    }

    private fun initView(view: View?, position: Int): View {
        var view = view
        var holder: MyHolder? = null
        if (view == null) {
            view = inflater.inflate(R.layout.play_music_item, null)
            holder = MyHolder(view)
            view!!.tag = holder
        } else {
            holder = view.tag as MyHolder
        }
        /**
         * 初始化数据
         */
        if (list != null && position < list.size) {
            val musicPlayerItem = list[position]
            ImageLoader.loadAll(context, musicPlayerItem.songphoto, holder.bgImage)
            initColor(holder, musicPlayerItem)
        }

        return view
    }


    internal var color = 0xffffcc00.toInt()

    private fun initColor(holder: MyHolder, tracksBean: TracksBean) {

        Glide.with(context).load(tracksBean.songphoto)
                .asBitmap()
                .override(300, 300)
                .into(object : SimpleTarget<Bitmap>() {
                    override fun onResourceReady(resource: Bitmap, glideAnimation: GlideAnimation<in Bitmap>) {
                        Palette.from(resource).generate { palette ->
                            try {
                                color = palette.lightMutedSwatch!!.rgb
                            } catch (e: Exception) {
//                                LogUtil.d(e.message)
                            }

                            holder.container.setBackgroundColor(color)
                        }
                    }
                })
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        if (`object` is View) {
            val view = `object`
            container.removeView(view)
            viewList.add(WeakReference(view))

        }
    }

    override fun getCount(): Int {
        return list!!.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }


    class MyHolder(var view: View) : View.OnClickListener {
        val bgImage: ImageView
        val collection: ImageView
        val download: ImageView
        val share: ImageView
        val container: LinearLayout

        init {
            bgImage = findViewById(R.id.cover_img) as ImageView
            collection = findViewById(R.id.collect_icon) as ImageView
            download = findViewById(R.id.download_icon) as ImageView
            share = findViewById(R.id.share_icon) as ImageView
            container = findViewById(R.id.container) as LinearLayout
            //            collection.setOnClickListener(this);
        }

        fun findViewById(id: Int): View {
            return view.findViewById(id)
        }

        override fun onClick(v: View) {
            val positon = v.tag as Int
        }


    }

}