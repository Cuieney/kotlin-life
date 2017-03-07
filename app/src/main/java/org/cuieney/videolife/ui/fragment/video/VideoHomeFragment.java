package org.cuieney.videolife.ui.fragment.video;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.BaseFragment;
import org.cuieney.videolife.common.component.EventUtil;
import org.cuieney.videolife.entity.VideoListBean;
import org.cuieney.videolife.presenter.VideoHomePresenter;
import org.cuieney.videolife.presenter.contract.VideoHomeContract;
import org.cuieney.videolife.ui.adapter.VideoAdapter;
import org.cuieney.videolife.common.base.DetailTransition;

import butterknife.BindView;

/**
 * Created by cuieney on 17/2/27.
 */

public class VideoHomeFragment extends BaseFragment<VideoHomePresenter> implements VideoHomeContract.View  {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;


    public static VideoHomeFragment newInstance() {
        Bundle bundle = new Bundle();
        VideoHomeFragment videoFragment = new VideoHomeFragment();
        videoFragment.setArguments(bundle);
        return videoFragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.video_home_fragment;
    }

    @Override
    protected void initEventAndData() {
        refresh.setProgressViewOffset(false,100,200);
        mPresenter.getVideoData("");
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        refresh.setOnRefreshListener(() -> mPresenter.getVideoData(""));
    }

    @Override
    public void showContent(VideoListBean videoListBean) {
        if (refresh.isRefreshing()) {
            refresh.setRefreshing(false);
        }
        VideoAdapter adapter = new VideoAdapter(getActivity(), videoListBean.getItemList());
        adapter.setOnItemClickListener((position, view, vh) -> {
            startChildFragment(videoListBean, position, (VideoAdapter.MyHolder) vh);
        });
        recycler.setAdapter(adapter);
    }

    private void startChildFragment(VideoListBean videoListBean, int position, VideoAdapter.MyHolder vh) {
        EventUtil.sendEvent(true+"");
        VideoDetailFragment fragment = VideoDetailFragment.newInstance(
                videoListBean.getItemList().get(position).getData());
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
                    .addSharedElement(vh.imageView, getString(R.string.image_transition))
//                        .addSharedElement(((VideoAdapter.MyHolder) vh).textView,"tv")
                    .commit();
        }
        start(fragment);
    }

    @Override
    public void error(Throwable throwable) {
        Log.e("oye", "error: ", throwable);
    }
}
