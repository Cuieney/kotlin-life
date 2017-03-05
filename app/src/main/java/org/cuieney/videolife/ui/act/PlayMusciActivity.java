package org.cuieney.videolife.ui.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.SimpleActivity;
import org.cuieney.videolife.entity.MusicListBean;
import org.cuieney.videolife.entity.wyBean.TracksBean;
import org.cuieney.videolife.ui.adapter.CoverFlowAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cuieney on 17/3/5.
 */

public class PlayMusciActivity extends AppCompatActivity {
    public static final String DATA = "DATA";
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.share)
    ImageView share;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.controller)
    RelativeLayout controller;
    @BindView(R.id.current_time)
    TextView currentTime;
    @BindView(R.id.progress)
    SeekBar progress;
    @BindView(R.id.total_time)
    TextView totalTime;
    @BindView(R.id.progress_controller)
    LinearLayout progressController;
    @BindView(R.id.viewpager)
    ViewPager mVpcontent;

    private MusicListBean tracksBean;
    private List<TracksBean> nowPlayList;
    private CoverFlowAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_play_music);
        ButterKnife.bind(this);
        initEventAndData();
    }

    protected void initEventAndData() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        tracksBean = extras.getParcelable(DATA);
        initGallery();
        initListener();
    }

    private void initListener() {
        back.setOnClickListener(v -> finish());
    }


    private void initGallery() {
        final List<TracksBean> nowPlayList = tracksBean.getTracks();

        if (nowPlayList == null || nowPlayList.size() == 0) {
            return;
        }
        this.nowPlayList = nowPlayList;


        adapter = new CoverFlowAdapter(nowPlayList, this);
        mVpcontent.setAdapter(adapter);
        mVpcontent.setOffscreenPageLimit(3);
        mVpcontent.setPageTransformer(true, new ScalePageTransformer());

        mVpcontent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(final int position) {
                title.setText(nowPlayList.get(position).getSongname());
                name.setText(nowPlayList.get(position).getSonger());
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {

                }
            }
        });

    }


    public class ScalePageTransformer implements ViewPager.PageTransformer {
        private static final String TAG = "ScalePageTransformer";
        public static final float MAX_SCALE = 1.0f;
        public static final float MIN_SCALE = 0.8f;

        @Override
        public void transformPage(View page, float position) {

            if (position < -1) {
                position = -1;
            } else if (position > 1) {
                position = 1;
            }

            float tempScale = position < 0 ? 1 + position : 1 - position;

            float slope = (MAX_SCALE - MIN_SCALE) / 1;
            //一个公式
            float scaleValue = MIN_SCALE + tempScale * slope;

            //设置缩放比例
            page.setScaleX(scaleValue);
            page.setScaleY(scaleValue);
            //设置透明度
            page.setAlpha(scaleValue);
        }
    }

}
