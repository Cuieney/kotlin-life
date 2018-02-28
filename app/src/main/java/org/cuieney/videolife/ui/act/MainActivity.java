package org.cuieney.videolife.ui.act;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.jaeger.library.StatusBarUtil;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.BaseMainFragment;
import org.cuieney.videolife.common.base.SimpleActivity;
import org.cuieney.videolife.common.component.EventUtil;
import org.cuieney.videolife.common.utils.DelegatesExt;
import org.cuieney.videolife.kotlin.App;
import org.cuieney.videolife.kotlin.ui.fragment.video.VideoHomeFragment;
import org.cuieney.videolife.ui.fragment.essay.EssayFragment;
import org.cuieney.videolife.ui.fragment.music.MusicFragment;
import org.cuieney.videolife.ui.fragment.video.VideoFragment;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

import static com.ashokvarma.bottomnavigation.BottomNavigationBar.BACKGROUND_STYLE_RIPPLE;
import static com.ashokvarma.bottomnavigation.BottomNavigationBar.MODE_FIXED;

public class MainActivity extends SimpleActivity implements BaseMainFragment.OnBackToFirstListener {


    private static final String TAG = "Main";
    @BindView(R.id.floating_search_view)
    FloatingSearchView mSearchView;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mNavigationView;

    List<SupportFragment> mFragments;

    @Override
    protected int getLayout() {
        return R.layout.design_layout;
    }

    @Override
    protected void initEventAndData() {
        mFragments = new ArrayList<>();
        mFragments.add(new VideoHomeFragment());
        mFragments.add(MusicFragment.newInstance());
        mFragments.add(new EssayFragment());
        mFragments.add(VideoFragment.newInstance());
        loadMultipleRootFragment(R.id.act_container, 0
                , mFragments.get(0)
                , mFragments.get(1)
                , mFragments.get(2)
                , mFragments.get(3)

        );

        initView();
    }


    private void initView() {
        mNavigationView
                .addItem(new BottomNavigationItem(R.drawable.movie_icon, "movie").setActiveColor("#6c4a41").setInActiveColor("#CCCCCC"))
                .addItem(new BottomNavigationItem(R.drawable.music_icon, "music").setActiveColor("#008867"))
                .addItem(new BottomNavigationItem(R.drawable.book_icon, "essay").setActiveColor("#8b6b64"))
                .addItem(new BottomNavigationItem(R.drawable.newspaper_icon, "newstand").setActiveColor("#485A66"))
                .initialise();
        mNavigationView.setBackgroundStyle(BACKGROUND_STYLE_RIPPLE);
        mNavigationView.setMode(MODE_FIXED);
        mNavigationView.setAutoHideEnabled(true);

        mNavigationView.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                showHideFragment(mFragments.get(position));
                switch (position) {
                    case 0:
                        StatusBarUtil.setColor(MainActivity.this, Color.parseColor("#6c4a41"));
                        break;
                    case 1:
                        StatusBarUtil.setColor(MainActivity.this, Color.parseColor("#008867"));
                        break;
                    case 2:
                        StatusBarUtil.setColor(MainActivity.this, Color.parseColor("#8b6b64"));
                        break;
                    case 3:
                        StatusBarUtil.setColor(MainActivity.this, Color.parseColor("#485A66"));
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {
            }

            @Override
            public void onTabReselected(int position) {
            }
        });

    }


    @Subscribe
    public void hide(String isHide) {
        if (isHide.equals("true")) {
            mSearchView.setVisibility(View.GONE);
        } else {
            mSearchView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventUtil.register(this);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventUtil.unregister(this);
    }

    @Override
    public void onBackToFirstFragment() {
        mNavigationView.selectTab(0);
    }
}
