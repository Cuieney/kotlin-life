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
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by paohaile on 17/2/24.
 */

public class VideoAdapter extends BaseRecycerViewAdapter<ItemListBean, RecyclerView.ViewHolder> {
    private OnItemClickListener mClickListener;
    public List<Bitmap> mBitmap;
    private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

    public VideoAdapter(Context context, List<ItemListBean> list) {
        super(context, list);
        mBitmap = new ArrayList<>();
//        initBitmap();
    }

    private void initBitmap() {
        fixedThreadPool.execute(() -> {
            for (int i = 0; i < list.size(); i++) {
                DataBean data = list.get(i).getData();
                if (data.getType().equals("video")) {

                    try {
                        mBitmap.add(Glide.with(context)
                                .load(data.getCover().getDetail())
                                .asBitmap()
                                .into(500, 500)
                                .get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
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

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder getCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == R.layout.video_item) {
            MyHolder myHolder = new MyHolder(inflater.inflate(viewType, parent, false));
            return myHolder;
        }
        return new TopHolder(inflater.inflate(viewType, parent, false));
    }

    @Override
    public void getBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemListBean itemListBean = list.get(position);
        if (holder instanceof MyHolder) {
            MyHolder myHolder = (MyHolder) holder;
            ViewCompat.setTransitionName(myHolder.imageView, String.valueOf(position) + "_image");
//            ViewCompat.setTransitionName(myHolder.textView, String.valueOf(position) + "_tv");

            DataBean data = itemListBean.getData();

            ImageLoader.loadAll(context, data.getCover().getDetail(), myHolder.imageView);


            myHolder.itemView.setOnClickListener(v -> {
                if (mClickListener != null) {
                    mClickListener.onItemClick(position, v, myHolder, null);
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


    public class MyHolder extends RecyclerView.ViewHolder {
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


    public class TopHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public TopHolder(View itemView) {
            super(itemView);
            textView = ((TextView) itemView.findViewById(R.id.name));
        }
    }

}
