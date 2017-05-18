package org.cuieney.videolife.ui.adapter;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.BaseRecycerViewAdapter;
import org.cuieney.videolife.common.image.ImageLoader;
import org.cuieney.videolife.common.utils.DateUtil;
import org.cuieney.videolife.entity.MusicListBean;
import org.cuieney.videolife.entity.YiRenBean.DataBean;

import java.util.List;

/**
 * Created by cuieney on 2017/5/17.
 */

public class EssayAdapter extends BaseRecycerViewAdapter<DataBean, RecyclerView.ViewHolder> {
    public EssayAdapter(Context context, List<DataBean> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder getCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == R.layout.essay_item) {
            return new EssayAdapter.EssayHolder(inflater.inflate(viewType, parent, false));
        } else {

            return new EssayAdapter.TopHolder(inflater.inflate(viewType, parent, false));
        }
    }

    @Override
    public void getBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof EssayAdapter.EssayHolder) {

            EssayAdapter.EssayHolder viewHoler = (EssayAdapter.EssayHolder) holder;
            DataBean dataBean = list.get(position);
            ImageLoader.loadAll(context, dataBean.getImg_url(), viewHoler.image);
            ViewCompat.setTransitionName(viewHoler.image, String.valueOf(position) + "_image");
            viewHoler.title.setText(dataBean.getTitle());
            if (dataBean.getAuthor() != null) {
                viewHoler.author.setText("文 / "+dataBean.getAuthor().getUser_name());
            }
            viewHoler.subhead.setText(dataBean.getForward());
            if (dataBean.getTag_list() != null) {
                viewHoler.type.setText(dataBean.getTag_list().size() == 0?"- 阅读 -":"- "+dataBean.getTag_list().get(0).getTitle()+" -");
            }
            viewHoler.postTime.setText(DateUtil.formatDate2String(dataBean.getPost_date()));

            viewHoler.itemView.setOnClickListener(v -> {
                if (mClickListener != null) {
                    mClickListener.onItemClick(position,v,holder);
                }
            });
        }

    }


    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return R.layout.top_item;
        }
        return R.layout.essay_item;

    }

    public static class EssayHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView type;
        private final TextView subhead;
        private final TextView postTime;
        private final TextView author;
        public final ImageView image;

        public EssayHolder(View itemView) {
            super(itemView);
            title = ((TextView) itemView.findViewById(R.id.title));
            type = ((TextView) itemView.findViewById(R.id.type));
            subhead = ((TextView) itemView.findViewById(R.id.subhead));
            postTime = ((TextView) itemView.findViewById(R.id.post_time));
            author = ((TextView) itemView.findViewById(R.id.author));
            image = ((ImageView) itemView.findViewById(R.id.image));
        }
    }

    public static class TopHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public TopHolder(View itemView) {
            super(itemView);
            textView = ((TextView) itemView.findViewById(R.id.name));
        }
    }
}
