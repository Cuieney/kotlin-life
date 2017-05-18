package org.cuieney.videolife.ui.fragment.essay;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.BaseFragment;
import org.cuieney.videolife.common.component.EventUtil;
import org.cuieney.videolife.entity.EssayDetailBean;
import org.cuieney.videolife.presenter.EssayHomeDetailPresenter;
import org.cuieney.videolife.presenter.contract.EssayHomeDetailContract;

import butterknife.BindView;

/**
 * Created by cuieney on 2017/5/17.
 */

public class EssayHomeDetailFragment extends BaseFragment<EssayHomeDetailPresenter> implements EssayHomeDetailContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.author)
    TextView author;
    @BindView(R.id.web_view)
    WebView webView;

    private int id;
    private int sourceId;

    public static EssayHomeDetailFragment newInstance(String id, String sourceId) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", Integer.parseInt(id));
        bundle.putInt("sourceId", Integer.parseInt(sourceId));
        EssayHomeDetailFragment homeDetailFragment = new EssayHomeDetailFragment();
        homeDetailFragment.setArguments(bundle);
        return homeDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        id = arguments.getInt("id");
        sourceId = arguments.getInt("sourceId");
    }

    @Override
    public void showContent(EssayDetailBean dataBeanList) {
        title.setText(dataBeanList.getData().getHp_title());
        author.setText("文 / " + dataBeanList.getData().getHp_author());
        String html = dataBeanList.getData().getHp_content();

        webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBlockNetworkImage(false);

        webView.loadDataWithBaseURL(null, html, "text/html", "utf-8",
                null);

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
        return R.layout.essay_home_detail_fragment;
    }

    @Override
    protected void initEventAndData() {
        toolbar.setTitle("一个阅读");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        initToolbarNav(toolbar);
        mPresenter.getEssayDetailData(sourceId, id);
    }

    protected void initToolbarNav(Toolbar toolbar) {
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(v -> {
            _mActivity.onBackPressed();
        });
        toolbar.inflateMenu(R.menu.video_menu);
    }

    @Override
    public boolean onBackPressedSupport() {
        EventUtil.sendEvent(false + "");
        return super.onBackPressedSupport();

    }

}
