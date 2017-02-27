package org.cuieney.videolife.ui.fragment.video;

import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import com.konifar.fab_transformation.FabTransformation;

import org.cuieney.videolife.App;
import org.cuieney.videolife.R;
import org.cuieney.videolife.common.image.ImageLoader;
import org.cuieney.videolife.common.utils.DateUtil;
import org.cuieney.videolife.entity.kaiyanBean.DataBean;
import org.cuieney.videolife.ui.fragment.base.BaseBackFragment;
import org.cuieney.videolife.ui.widget.IMediaController;
import org.cuieney.videolife.ui.widget.IjkVideoView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import io.vov.vitamio.widget.VideoView;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Created by cuieney on 17/2/25.
 */

public class VideoDetailFragment extends BaseBackFragment {

    private static final String ARG_ITEM = "arg_item";
    ImageView mImgDetail;
    Toolbar mToolbar;
    ImageView bgImage;
    TextView title;
    TextView type;
    TextView description;
    FloatingActionButton mFab;


    private DataBean dataBean;
    private int fabColor;
    private IjkVideoView videoView;
    private int SIZE_DEFAULT;
    private int SIZE_4_3;
    private int SIZE_16_9;
    private int currentSize;


    public static VideoDetailFragment newInstance(DataBean dataBean, int color) {

        Bundle args = new Bundle();
        args.putParcelable(ARG_ITEM, dataBean);
        args.putInt("color", color);
        VideoDetailFragment fragment = new VideoDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBean = getArguments().getParcelable(ARG_ITEM);
        fabColor = getArguments().getInt("color", Color.parseColor("#46b6ad"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_home_detail, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mToolbar = ((Toolbar) view.findViewById(R.id.toolbar));
        mImgDetail = (ImageView) view.findViewById(R.id.img_detail);
        bgImage = (ImageView) view.findViewById(R.id.bg_image);
        title = (TextView) view.findViewById(R.id.title);
        type = (TextView) view.findViewById(R.id.type);
        description = (TextView) view.findViewById(R.id.description);
        mFab = (FloatingActionButton) view.findViewById(R.id.fab);
        videoView = ((IjkVideoView) view.findViewById(R.id.video_view));


        mFab.setBackgroundTintList(new ColorStateList(new int[][]{new int[0]}, new int[]{0xffffcc00}));

        mToolbar.setTitle("");
        initToolbarNav(mToolbar);
        ImageLoader.loadAll(getActivity(), dataBean.getCover().getDetail(), mImgDetail);
        ImageLoader.loadAll(getActivity(), dataBean.getCover().getBlurred(), bgImage);
        title.setText(dataBean.getTitle());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#").append(dataBean.getCategory())
                .append(" ")
                .append(" / ")
                .append(" ")
                .append(DateUtil.formatTime2(dataBean.getDuration()));
        type.setText(stringBuilder.toString());
        description.setText(dataBean.getDescription());

        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        new Thread(() -> {
            try {
                videoView.setVideoPath(getRedirectUrl(dataBean.getPlayUrl()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        mFab.setOnClickListener(v -> {
            if (mFab.getVisibility() == View.VISIBLE) {
                FabTransformation.with(mFab).transformTo(mImgDetail);
                videoView.start();
            }
        });
    }

    private String getRedirectUrl(String path) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL(path)
                .openConnection();
        conn.setInstanceFollowRedirects(false);
        conn.setConnectTimeout(5000);
        return conn.getHeaderField("Location");
    }

    private void fullChangeScreen() {
        if (getActivity().getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {// 切换为竖屏
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    public void setScreenRate(int rate) {
        int width = 0;
        int height = 0;

        if (getActivity().getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {// 横屏
            if (rate == SIZE_DEFAULT) {
                width = videoView.getmVideoWidth();
                height = videoView.getmVideoHeight();
            } else if (rate == SIZE_4_3) {
                width = App.SCREEN_HEIGHT / 3 * 4;
                height = App.SCREEN_HEIGHT;
            } else if (rate == SIZE_16_9) {
                width = App.SCREEN_HEIGHT / 9 * 16;
                height = App.SCREEN_HEIGHT;
            }
        } else { //竖屏
            if (rate == SIZE_DEFAULT) {
                width = videoView.getmVideoWidth();
                height = videoView.getmVideoHeight();
            } else if (rate == SIZE_4_3) {
                width = App.SCREEN_WIDTH;
                height = App.SCREEN_WIDTH * 3 / 4;
            } else if (rate == SIZE_16_9) {
                width = App.SCREEN_WIDTH;
                height = App.SCREEN_WIDTH * 9 / 16;
            }
        }
        if (width > 0 && height > 0) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) videoView.getmRenderView().getView().getLayoutParams();
            lp.width = width;
            lp.height = height;
            videoView.getmRenderView().getView().setLayoutParams(lp);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //重新获取屏幕宽高
        App.getInstance().getScreenSize();
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {//切换为横屏
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) videoView.getLayoutParams();
            lp.height = App.SCREEN_HEIGHT;
            lp.width = App.SCREEN_WIDTH;
            videoView.setLayoutParams(lp);
        } else {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) videoView.getLayoutParams();
            lp.height = App.SCREEN_WIDTH * 9 / 16;
            lp.width = App.SCREEN_WIDTH;
            videoView.setLayoutParams(lp);
        }
        setScreenRate(currentSize);
    }
}
