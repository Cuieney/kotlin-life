package org.cuieney.videolife.ui.act;

import android.util.Log;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.BaseFragment;
import org.cuieney.videolife.common.base.SimpleActivity;
import org.cuieney.videolife.ui.fragment.book.BookFragment;
import org.cuieney.videolife.ui.fragment.music.MusicFragment;
import org.cuieney.videolife.ui.fragment.newstand.NewstandFragment;
import org.cuieney.videolife.ui.fragment.video.VideoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

import static com.ashokvarma.bottomnavigation.BottomNavigationBar.BACKGROUND_STYLE_RIPPLE;
import static com.ashokvarma.bottomnavigation.BottomNavigationBar.MODE_FIXED;

public class MainActivity extends SimpleActivity  {


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
        mFragments.add(VideoFragment.newInstance());
        mFragments.add(MusicFragment.newInstance());
        mFragments.add(BookFragment.newInstance());
        mFragments.add(NewstandFragment.newInstance());
        loadMultipleRootFragment(R.id.act_container, 0
                ,mFragments.get(0));

        initView();
    }


    private void initView() {

        mNavigationView
                .addItem(new BottomNavigationItem(R.drawable.movie_icon, "movie").setActiveColor("#6c4a41").setInActiveColor("#CCCCCC"))
                .addItem(new BottomNavigationItem(R.drawable.music_icon, "music").setActiveColor("#008867"))
                .addItem(new BottomNavigationItem(R.drawable.book_icon, "book").setActiveColor("#8b6b64"))
                .addItem(new BottomNavigationItem(R.drawable.newspaper_icon, "newstand").setActiveColor("#485A66"))
                .initialise();
        mNavigationView.setBackgroundStyle(BACKGROUND_STYLE_RIPPLE);
        mNavigationView.setMode(MODE_FIXED);
        mNavigationView.setAutoHideEnabled(true);

        mNavigationView.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                showHideFragment(mFragments.get(position), mFragments.get(position == 0 ? mFragments.size() - 1 : position - 1));
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
            }
        });

    }
}

