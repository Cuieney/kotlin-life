package org.cuieney.videolife.ui.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.image.ImageLoader;
import org.cuieney.videolife.common.utils.LogUtil;
import org.cuieney.videolife.entity.wyBean.TracksBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;


/**
 * Created by cuieney on 16/6/13.
 */
public class CoverFlowAdapter extends PagerAdapter {
    private List<TracksBean> list;
    private LayoutInflater inflater;
    public Context context;
    private List<WeakReference<View>> viewList;

    public CoverFlowAdapter(List<TracksBean> list, Context context) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        viewList = new ArrayList<WeakReference<View>>();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;
        // 从废弃的里去取 取到则使用 取不到则创建
        if (viewList.size() > 0) {
            if (viewList.get(0) != null) {
                view = initView(viewList.get(0).get(), position);
                viewList.remove(0);
            }
        }
        view = initView(null, position);

        container.addView(view);

        return view;
    }

    private View initView(View view, int position) {
        MyHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.play_music_item, null);
            holder = new MyHolder(view);
            view.setTag(holder);
        } else {
            holder = (MyHolder) view.getTag();
        }
        /**
         * 初始化数据
         */
        if (list != null && position < list.size()) {
            TracksBean musicPlayerItem = list.get(position);
            ImageLoader.loadAll(context, musicPlayerItem.getSongphoto(), holder.bgImage);
            initColor(holder, musicPlayerItem);
        }

        return view;
    }


    int color = 0xffffcc00;

    private void initColor(MyHolder holder, TracksBean tracksBean) {

        Glide.with(context).load(tracksBean.getSongphoto())
                .asBitmap()
                .override(300, 300)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        Palette.from(resource).generate(palette -> {
                            try {
                                color = palette.getLightMutedSwatch().getRgb();
                            } catch (Exception e) {
                                LogUtil.d(e.getMessage());
                            }
                            holder.container.setBackgroundColor(color);
                        });
                    }
                });
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (object instanceof View) {
            View view = (View) object;
            container.removeView(view);
            viewList.add(new WeakReference<View>(view));

        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }


    public static final class MyHolder implements View.OnClickListener {
        public final ImageView bgImage;
        public final ImageView collection;
        public final ImageView download;
        public final ImageView share;
        public final LinearLayout container;
        public View view;

        public MyHolder(View itemView) {
            view = itemView;
            bgImage = ((ImageView) findViewById(R.id.cover_img));
            collection = ((ImageView) findViewById(R.id.collect_icon));
            download = ((ImageView) findViewById(R.id.download_icon));
            share = ((ImageView) findViewById(R.id.share_icon));
            container = ((LinearLayout) findViewById(R.id.container));
//            collection.setOnClickListener(this);
        }

        public View findViewById(int id) {
            return view.findViewById(id);
        }

        @Override
        public void onClick(View v) {
            int positon = (int) v.getTag();
        }


    }

}
