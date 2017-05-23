package org.cuieney.videolife.ui.fragment.music;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.konifar.fab_transformation.FabTransformation;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.image.ImageLoader;
import org.cuieney.videolife.common.utils.DelegatesExt;
import org.cuieney.videolife.common.utils.LogUtil;
import org.cuieney.videolife.common.utils.PreferenceUtil;
import org.cuieney.videolife.entity.MusicListBean;
import org.cuieney.videolife.ui.adapter.MusicItemAdapter;
import org.cuieney.videolife.common.base.BaseBackFragment;
import org.cuieney.videolife.ui.video.JumpUtils;

/**
 * Created by cuieney on 17/3/4.
 */

public class MusicDetailFragment extends BaseBackFragment {

    ImageView mImgDetail;
    Toolbar mToolbar;
    FloatingActionButton mFab;
    private CollapsingToolbarLayout collToolBar;
    private XRecyclerView recycler;
    private MusicListBean dataBean;

    public static MusicDetailFragment newInstance(MusicListBean dataBean) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_ITEM, dataBean);
        MusicDetailFragment fragment = new MusicDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBean = getArguments().getParcelable(ARG_ITEM);
        PreferenceUtil.getInstance(getContext()).putString("JSON",new Gson().toJson(dataBean.getTracks()));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.music_home_detail_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mToolbar = ((Toolbar) view.findViewById(R.id.toolbar));
        collToolBar = ((CollapsingToolbarLayout) view.findViewById(R.id.toolbar_layout));
        mImgDetail = (ImageView) view.findViewById(R.id.img_detail);
        mFab = (FloatingActionButton) view.findViewById(R.id.fab);
        recycler = ((XRecyclerView) view.findViewById(R.id.recycler));

        recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        initColor();
        mToolbar.setTitle("");
        initToolbarNav(mToolbar);
        ImageLoader.loadAll(getActivity(), dataBean.getOphoto(), mImgDetail);
        recycler.setLoadingMoreEnabled(false);
        recycler.setPullRefreshEnabled(false);
        recycler.setAdapter(new MusicItemAdapter(getActivity(), dataBean.getTracks()));
        initHeadView();

        mFab.setOnClickListener(v -> {
            if (mFab.getVisibility() == View.VISIBLE) {
                FabTransformation.with(mFab).setListener(new FabTransformation.OnTransformListener() {
                    @Override
                    public void onStartTransform() {
                    }

                    @Override
                    public void onEndTransform() {
                        JumpUtils.goToMusicPlayer(getActivity(), mImgDetail, dataBean);
                    }
                }).transformTo(mImgDetail);
            }
        });
    }

    private void initHeadView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.music_detial_top_item, null);
        TextView title = (TextView) inflate.findViewById(R.id.title);
        ExpandableTextView expandableTextView = (ExpandableTextView) inflate.findViewById(R.id.expand_text_view);
        expandableTextView.setText(dataBean.getMdesc());
        title.setText(dataBean.getMname());
        recycler.addHeaderView(inflate);
    }

    int color = 0xffffcc00;

    private void initColor() {

        Glide.with(getContext()).load(dataBean.getOphoto()).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {

                Palette.from(resource).generate(palette -> {
                    try {
                        color = palette.getLightMutedSwatch().getRgb();
                    } catch (Exception e) {
                        LogUtil.d(e.getMessage());
                    }
                    collToolBar.setContentScrimColor(color);
                    mFab.setBackgroundTintList(new ColorStateList(new int[][]{new int[0]}, new int[]{color}));

                });

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        FabTransformation.with(mFab).setListener(new FabTransformation.OnTransformListener() {
            @Override
            public void onStartTransform() {

            }

            @Override
            public void onEndTransform() {
                if (mImgDetail.getVisibility() == View.INVISIBLE) {
                    mImgDetail.setVisibility(View.VISIBLE);
                }
            }
        }).transformFrom(mImgDetail);
    }

}