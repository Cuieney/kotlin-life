package org.cuieney.videolife.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.TimeUtils;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.BaseRecycerViewAdapter;
import org.cuieney.videolife.common.image.ImageLoader;
import org.cuieney.videolife.common.utils.DateUtil;
import org.cuieney.videolife.entity.VideoListBean;
import org.cuieney.videolife.entity.kaiyanBean.DataBean;
import org.cuieney.videolife.entity.kaiyanBean.ItemListBean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cuieney on 17/2/24.
 */

public class VideoAdapter extends BaseRecycerViewAdapter<ItemListBean, RecyclerView.ViewHolder> {

    public List<Bitmap> mBitmap;
    private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

    public VideoAdapter(Context context, List<ItemListBean> list) {
        super(context, list);
        mBitmap = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getType().equals("video")) {
            if (position == 0) {
                return R.layout.top_item;
            }
            return R.layout.video_item;
        } else {
            return R.layout.null_item;
        }
    }

    @Override
    public RecyclerView.ViewHolder getCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == R.layout.video_item) {
            return new MyHolder(inflater.inflate(viewType, parent, false));
        }
        return new TopHolder(inflater.inflate(viewType, parent, false));
    }

    @Override
    public void getBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemListBean itemListBean = list.get(position);
        if (holder instanceof MyHolder) {
            MyHolder myHolder = (MyHolder) holder;
            ViewCompat.setTransitionName(myHolder.imageView, String.valueOf(position) + "_image");
            DataBean data = itemListBean.getData();
            ImageLoader.loadAll(context, data.getCover().getDetail(), myHolder.imageView);


            myHolder.itemView.setOnClickListener(v -> {
                if (mClickListener != null) {
                    mClickListener.onItemClick(position, v, myHolder);
                }
            });


            myHolder.textView.setText(data.getTitle());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("#").append(data.getCategory())
                    .append(" ")
                    .append(" / ")
                    .append(" ")
                    .append(DateUtil.formatTime2(data.getDuration()));
            myHolder.description.setText(stringBuilder.toString());
        }
    }


    public static class MyHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView description;
        public ImageView imageView;

        public MyHolder(View itemView) {
            super(itemView);
            textView = ((TextView) itemView.findViewById(R.id.title));
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
