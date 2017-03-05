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

    private int mChildCount = 0;

//    @Override
//    public void notifyDataSetChanged() {
//        mChildCount = getCount();
//        super.notifyDataSetChanged();
//    }
//
//    @Override
//    public int getItemPosition(Object object)   {
//        if ( mChildCount > 0) {
//            mChildCount --;
//            return POSITION_NONE;
//        }
//        return super.getItemPosition(object);
//    }

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



    class HomeAdapter extends PagerAdapter {
        private List<TracksBean> list;
        private LayoutInflater inflater;
        public Context context;

        public HomeAdapter(List<TracksBean> list, LayoutInflater inflater, Context context) {
            this.list = list;
            this.inflater = inflater;
            this.context = context;
        }

        // 当前viewPager里面有多少个条目
        LinkedList<View> convertView=new LinkedList<View>();
        @Override
        public int getCount() {
            return	Integer.MAX_VALUE;
        }
        /* 判断返回的对象和 加载view对象的关系 */
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ImageView view=(ImageView) object;
            convertView.add(view);// 把移除的对象 添加到缓存集合中
            container.removeView(view);
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = null;
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
//            ImageLoader.loadAll(context, musicPlayerItem.getSongphoto(), holder.bgImage);
//            initColor(holder, musicPlayerItem);
            }

            return view;
        }
    }

}
