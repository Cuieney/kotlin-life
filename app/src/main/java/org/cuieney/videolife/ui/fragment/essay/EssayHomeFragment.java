package org.cuieney.videolife.ui.fragment.essay;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.BaseFragment;
import org.cuieney.videolife.common.base.DetailTransition;
import org.cuieney.videolife.common.component.EventUtil;
import org.cuieney.videolife.common.utils.LogUtil;
import org.cuieney.videolife.entity.EssayListBean;
import org.cuieney.videolife.entity.MusicListBean;
import org.cuieney.videolife.entity.YiRenBean.DataBean;
import org.cuieney.videolife.presenter.EssayHomePresenter;
import org.cuieney.videolife.presenter.contract.EssayHomeContract;
import org.cuieney.videolife.ui.adapter.EssayAdapter;
import org.cuieney.videolife.ui.adapter.MusicAdapter;
import org.cuieney.videolife.ui.fragment.music.MusicDetailFragment;
import org.cuieney.videolife.ui.fragment.video.VideoHomeFragment;
import org.cuieney.videolife.ui.widget.EndLessOnScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by cuieney on 2017/5/17.
 */

public class EssayHomeFragment extends BaseFragment<EssayHomePresenter> implements EssayHomeContract.View {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private List<DataBean> mEssayList;
    private int pager = 0;
    private EssayAdapter adapter;

    public static EssayHomeFragment newInstance() {
        Bundle bundle = new Bundle();
        EssayHomeFragment essayHomeFragment = new EssayHomeFragment();
        essayHomeFragment.setArguments(bundle);
        return essayHomeFragment;
    }

    @Override
    public void showContent(List<DataBean> dataBeanList) {
        if (refresh.isRefreshing()) {
            refresh.setRefreshing(false);
            pager = 0;
            adapter.clear();
            mEssayList.clear();
            adapter.addAll(dataBeanList);
            recycler.setAdapter(adapter);
        }else{
            adapter.addAll(dataBeanList);
            int size = dataBeanList.size();
            String id = dataBeanList.get(size - 1).getId();
            Log.e("oye", "showContent: "+id );
            pager = Integer.parseInt(id);
        }
        mEssayList.addAll(dataBeanList);
    }

    @Override
    public void error(Throwable throwable) {
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.essay_home_fragment;
    }

    @Override
    protected void initEventAndData() {

        refresh.setProgressViewOffset(false,100,200);
        refresh.setOnRefreshListener(() -> mPresenter.getEssayData(0));
        LinearLayoutManager layout = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layout);
        recycler.addOnScrollListener(new EndLessOnScrollListener(layout,1) {
            @Override
            public void onLoadMore() {
                mPresenter.getEssayData(pager);
            }
        });
        mEssayList = new ArrayList<>();
        adapter = new EssayAdapter(getActivity(),mEssayList);
        recycler.setAdapter(adapter);
        adapter.setOnItemClickListener((position, view, vh) -> {
            startChildFragment(mEssayList.get(position),vh);
        });

        mPresenter.getEssayData(pager);
    }

    private void startChildFragment(DataBean dataBean, RecyclerView.ViewHolder vh) {
        EventUtil.sendEvent(true + "");
        EssayHomeDetailFragment fragment = EssayHomeDetailFragment.newInstance(dataBean.getId(),dataBean.getItem_id());
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
//                    .addSharedElement(((EssayAdapter.EssayHolder) vh).image, getString(R.string.image_transition))
//                    .commit();
        }
        start(fragment);
    }

}
