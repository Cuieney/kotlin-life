package org.cuieney.videolife.kotlin.ui.adapter

import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.cuieney.videolife.R
import org.cuieney.videolife.entity.YiRenBean.DataBean
import kotlinx.android.synthetic.main.essay_item.view.*
import org.cuieney.videolife.common.image.ImageLoader
import org.cuieney.videolife.common.utils.DateUtil
import org.cuieney.videolife.ui.adapter.EssayAdapter

/**
 * Created by cuieney on 2017/5/23.
 */
class EssayAdapter(item:ArrayList<DataBean>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items:ArrayList<DataBean>
    init {
        items = ArrayList()
        addNews(item)
    }
    override fun getItemCount(): Int = items.size

    fun addNews(news: List<DataBean>) {
        val initPosition = items.size
        items.addAll(news)
        notifyItemRangeChanged(initPosition, items.size )
    }

    fun clearAndAddNews(news: List<DataBean>) {
        items.clear()
        notifyDataSetChanged()

        items.addAll(news)
        notifyItemRangeInserted(0, items.size)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is EssayHomeHolder) {
            holder.bindData(items[position],position)
            holder.itemView.setOnClickListener {
                clickListener.onItemClick(position,it,holder)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == R.layout.essay_item) {
            return EssayHomeHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
        } else {

            return TopHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
        }

    }

    override fun getItemViewType(position: Int): Int {

        if (position == 0) {
            return R.layout.top_item
        }
        return R.layout.essay_item

    }

    class EssayHomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindData(dataBean:DataBean,position: Int){
            ImageLoader.loadAll(itemView.context, dataBean.getImg_url(),itemView.image)
            ViewCompat.setTransitionName(itemView.image, position.toString() + "_image")
            itemView.title.text = dataBean.title
            var author = dataBean.author.user_name
            itemView.author.text = "文 / $author"
            itemView.subhead.text = dataBean.forward

            itemView.type.text = if(dataBean.getTag_list().size == 0) "- 阅读 -" else "- " + dataBean.getTag_list().get(0).getTitle() + " -"
            itemView.post_time.text = DateUtil.formatDate2String(dataBean.getPost_date())
        }
    }

    class TopHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView

        init {
            textView = itemView.findViewById(R.id.name) as TextView
        }
    }

    fun setOnClickListener(mClickListener :OnItemClickListener){
        clickListener = mClickListener
    }

    lateinit var clickListener :OnItemClickListener
    interface OnItemClickListener {
        fun onItemClick(position: Int, view: View, vh: RecyclerView.ViewHolder)
    }

}