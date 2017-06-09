package org.cuieney.videolife.kotlin.ui.adapter

import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import org.cuieney.videolife.R
import org.cuieney.videolife.common.base.BaseRecycerViewAdapter
import org.cuieney.videolife.common.image.ImageLoader
import org.cuieney.videolife.entity.MusicListBean
import kotlinx.android.synthetic.main.music_item.view.*
import org.cuieney.videolife.common.api.UrlManager
import org.cuieney.videolife.entity.KuulaListBean

/**
 * Created by cuieney on 2017/6/5.
 */
class KuulaAdapter(t:ArrayList<KuulaListBean.PayloadBean.PostsBean>):BaseAdapter<KuulaListBean.PayloadBean.PostsBean>(t){

    override fun getCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == R.layout.music_item) {
            return MyViewHoler(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
        } else {

            return TopHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
        }
    }

    override fun getBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHoler) {
            holder.bindData(items[position],position)
            holder.itemView.setOnClickListener { v ->
                clickListener?.onItemClick(position, v, holder)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        if (position == 0 || position == 1) {
            return R.layout.top_item
        }
        return R.layout.music_item

    }

    class MyViewHoler(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(data:KuulaListBean.PayloadBean.PostsBean,position: Int){
            ViewCompat.setTransitionName(itemView.img, position.toString() + "_image")
            ImageLoader.loadAll(itemView.context, UrlManager.getKuulaCover(data.uuid), itemView.img)
            itemView.title.setText(data.user.name)
            itemView.description.setText(data.description)

        }

    }

    class TopHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}