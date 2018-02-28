package org.cuieney.videolife.ui.fragment.video;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.BaseFragment;
import org.cuieney.videolife.common.component.EventUtil;
import org.cuieney.videolife.common.utils.LogUtil;
import org.cuieney.videolife.entity.VideoListBean;
import org.cuieney.videolife.entity.kaiyanBean.ItemListBean;
import org.cuieney.videolife.presenter.VideoHomePresenter;
import org.cuieney.videolife.presenter.contract.VideoHomeContract;
import org.cuieney.videolife.ui.adapter.VideoAdapter;
import org.cuieney.videolife.common.base.DetailTransition;
import org.cuieney.videolife.ui.widget.EndLessOnScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by cuieney on 17/2/27.
 */

public class VideoHomeFragment extends BaseFragment<VideoHomePresenter> implements VideoHomeContract.View {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private String date;
    private VideoAdapter adapter;
    private List<ItemListBean> mVideoListBean;

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

        refresh.setProgressViewOffset(false, 100, 200);
        refresh.setOnRefreshListener(() -> {
            mPresenter.getVideoData("");
        });

        LinearLayoutManager layout = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layout);
        mVideoListBean = new ArrayList<>();

        adapter = new VideoAdapter(getActivity(), mVideoListBean);
        adapter.setOnItemClickListener((position, view, vh) -> startChildFragment(mVideoListBean.get(position), (VideoAdapter.MyHolder) vh));
        recycler.setAdapter(adapter);
        recycler.addOnScrollListener(new EndLessOnScrollListener(layout,0) {
            @Override
            public void onLoadMore() {
                mPresenter.getVideoData(date);
            }
        });
        mPresenter.getVideoData("");

    }

    @Override
    public void showContent(VideoListBean videoListBean) {
        if (refresh.isRefreshing()) {
            refresh.setRefreshing(false);
            mVideoListBean.clear();
            adapter.clear();
            adapter.addAll(videoListBean.getItemList());
            recycler.setAdapter(adapter);
        }else{
            adapter.addAll(videoListBean.getItemList());
        }
        mVideoListBean.addAll(videoListBean.getItemList());

        int end = videoListBean.getNextPageUrl().lastIndexOf("&num");
        int start = videoListBean.getNextPageUrl().lastIndexOf("date=");
        date = videoListBean.getNextPageUrl().substring(start + 5, end);



    }
    private void startChildFragment(ItemListBean videoListBean, VideoAdapter.MyHolder vh) {
        EventUtil.sendEvent(true + "");
        VideoDetailFragment fragment = VideoDetailFragment.newInstance(
                videoListBean.getData());
        // 这里是使用SharedElement的用例

        // LOLLIPOP(5.0)系统的 SharedElement支持有 系统BUG， 这里判断大于 > LOLLIPOP
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            setExitTransition(new Fade());
            fragment.setEnterTransition(new Slide());
            fragment.setSharedElementReturnTransition(new DetailTransition());
            fragment.setSharedElementEnterTransition(new DetailTransition());

            // 25.1.0以下的support包,Material过渡动画只有在进栈时有,返回时没有;
            // 25.1.0+的support包，SharedElement正常
//            fragment.transaction()
//                    .addSharedElement(vh.imageView, getString(R.string.image_transition))
////                        .addSharedElement(((VideoAdapter.MyHolder) vh).textView,"tv")
//                    .commit();
        }
        start(fragment);
    }

    @Override
    public void error(Throwable throwable) {
        Log.e("oye", "error: ", throwable);
    }
}
