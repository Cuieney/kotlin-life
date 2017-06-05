package org.cuieney.videolife.kotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.music_detail_item.view.*
import org.cuieney.videolife.R
import org.cuieney.videolife.entity.wyBean.TracksBean

/**
 * Created by cuieney on 2017/6/5.
 */
class MusicItemAdapter(t: ArrayList<TracksBean>) : BaseAdapter<TracksBean>(t) {
    override fun getCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.music_detail_item, parent, false))
    }

    override fun getBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHolder) {
            holder.bindData(items[position], position)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(data: TracksBean, position: Int) {
            val pos = position+1
            itemView.title_num.text = "$pos"
            itemView.title.text = data.songname
            itemView.title_dis.text = data.songer
        }
    }
}