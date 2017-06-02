package org.cuieney.videolife.kotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import org.cuieney.videolife.entity.YiRenBean.DataBean

/**
 * Created by cuieney on 2017/6/2.
 */
open abstract class BaseAdapter<T>(t:List<T>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items:ArrayList<T>
    init {
        items = ArrayList()
        addNews(t)
    }
    override fun getItemCount(): Int = items.size

    fun addNews(news: List<T>) {
        val initPosition = items.size
        items.addAll(news)
        notifyItemRangeChanged(initPosition, items.size )
    }

    fun clearAndAddNews(news: List<T>) {
        items.clear()
        notifyDataSetChanged()

        items.addAll(news)
        notifyItemRangeInserted(0, items.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getBindViewHolder(holder, position)
    }

    abstract fun getCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    abstract fun getBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)

    var clickListener : OnItemClickListener? = null
    fun setOnClickListener(mClickListener : OnItemClickListener){
        clickListener = mClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, view: View, vh: RecyclerView.ViewHolder)
    }
}