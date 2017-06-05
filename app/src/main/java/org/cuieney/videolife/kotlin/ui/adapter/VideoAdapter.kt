package org.cuieney.videolife.kotlin.ui.adapter

import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.video_item.view.*
import org.cuieney.videolife.R
import org.cuieney.videolife.common.image.ImageLoader
import org.cuieney.videolife.common.utils.DateUtil
import org.cuieney.videolife.entity.kaiyanBean.ItemListBean

/**
 * Created by cuieney on 2017/6/2.
 *
 */
class VideoAdapter(t: List<ItemListBean>) : BaseAdapter<ItemListBean>(t) {


    override fun getBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyHolder) {
            holder.bindData(items[position],position)
            holder.itemView.setOnClickListener({ v ->
                if (clickListener != null) {
                    clickListener?.onItemClick(position, v, holder)
                }
            })
        }
    }

    override fun getCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == R.layout.video_item) {
            return MyHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
        } else {
            return TopHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
        }
    }


    override fun getItemViewType(position: Int): Int {

        if (items.get(position).getType() == "video") {
            if (position == 0) {
                return R.layout.top_item
            }
            return R.layout.video_item
        } else {
            return R.layout.null_item
        }
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(data: ItemListBean,position: Int) {
            ImageLoader.loadAll(itemView.context, data.data.cover.detail, itemView.img)
            ViewCompat.setTransitionName(itemView.img, position.toString() + "_image")
            itemView.title.text = data.data.title
            val category = data.data.category
            val time = DateUtil.formatTime2(data.data.duration.toLong())
            itemView.description.text = "#$category / $time"
        }
    }


    class TopHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}