package org.cuieney.videolife.ui.adapter;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.BaseRecycerViewAdapter;
import org.cuieney.videolife.common.image.ImageLoader;
import org.cuieney.videolife.entity.MusicListBean;

import java.util.List;

/**
 * Created by cuieney on 17/3/4.
 */

public class MusicAdapter extends BaseRecycerViewAdapter<MusicListBean, RecyclerView.ViewHolder> {
    public MusicAdapter(Context context, List<MusicListBean> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder getCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == R.layout.music_item) {
            return new MusicAdapter.MyViewHoler(inflater.inflate(viewType, parent, false));
        } else {

            return new MusicAdapter.TopHolder(inflater.inflate(viewType, parent, false));
        }
    }

    @Override
    public void getBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHoler) {
            MyViewHoler viewHoler = (MyViewHoler) holder;
            MusicListBean musicListBean = list.get(position);
            ViewCompat.setTransitionName(viewHoler.imageView, String.valueOf(position) + "_image");
            ImageLoader.loadAll(context, musicListBean.getOphoto(), viewHoler.imageView);
            viewHoler.title.setText(musicListBean.getMname());
            viewHoler.description.setText(musicListBean.getMdesc());
            viewHoler.itemView.setOnClickListener(v -> {
                if (mClickListener != null) {
                    mClickListener.onItemClick(position,v,holder);
                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0 || position == 1) {
            return R.layout.top_item;
        }
        return R.layout.music_item;

    }

    public static class MyViewHoler extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;
        public ImageView imageView;
        public ExpandableTextView expandedDesc;

        public MyViewHoler(View itemView) {
            super(itemView);
            title = ((TextView) itemView.findViewById(R.id.title));
            description = ((TextView) itemView.findViewById(R.id.description));
            imageView = ((ImageView) itemView.findViewById(R.id.img));
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
