package org.cuieney.videolife.ui.fragment.video;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.BaseFragment;
import org.cuieney.videolife.entity.VideoListBean;
import org.cuieney.videolife.presenter.VideoHomePresenter;
import org.cuieney.videolife.presenter.contract.VideoHomeContract;
import org.cuieney.videolife.ui.adapter.VideoAdapter;
import org.cuieney.videolife.ui.fragment.base.DetailTransition;


import butterknife.BindView;

/**
 * Created by paohaile on 17/2/24.
 */

public class VideoFragment extends BaseFragment<VideoHomePresenter> implements VideoHomeContract.View {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;


    public static VideoFragment newInstance() {
        Bundle bundle = new Bundle();
        VideoFragment videoFragment = new VideoFragment();
        videoFragment.setArguments(bundle);
        return videoFragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.video_fragment;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getVideoData("");
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

    }

    Palette palette;
    Palette.Swatch lightVibrantSwatch;
    int curColor;
    @Override
    public void showContent(VideoListBean videoListBean) {
        Log.e("oye", "showContent: " + videoListBean.getNextPageUrl());
        VideoAdapter adapter = new VideoAdapter(getActivity(), videoListBean.getItemList());
        adapter.setOnItemClickListener((position, view, vh, bitmap) -> {
            if (bitmap != null) {
                palette = Palette.from(bitmap).generate();
                lightVibrantSwatch = palette.getLightVibrantSwatch();
                curColor = lightVibrantSwatch.getRgb();
            }else{
                curColor = Color.parseColor("#46b6ad");
            }
            VideoDetailFragment fragment = VideoDetailFragment.newInstance(
                    videoListBean.getItemList().get(position).getData(),
                    curColor
            );
            // 这里是使用SharedElement的用例

            // LOLLIPOP(5.0)系统的 SharedElement支持有 系统BUG， 这里判断大于 > LOLLIPOP
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                setExitTransition(new Fade());
                fragment.setEnterTransition(new Slide());
                fragment.setSharedElementReturnTransition(new DetailTransition());
                fragment.setSharedElementEnterTransition(new DetailTransition());

                // 25.1.0以下的support包,Material过渡动画只有在进栈时有,返回时没有;
                // 25.1.0+的support包，SharedElement正常
                fragment.transaction()
                        .addSharedElement(((VideoAdapter.MyHolder) vh).imageView, getString(R.string.image_transition))
//                        .addSharedElement(((VideoAdapter.MyHolder) vh).textView,"tv")
                        .commit();
            }
            start(fragment);

        });
        recycler.setAdapter(adapter);
    }

    @Override
    public void error(Throwable throwable) {
        Log.e("oye", "error: ", throwable);
    }
}
