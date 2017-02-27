package org.cuieney.videolife.ui.fragment.book;

import android.os.Bundle;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.BaseFragment;
import org.cuieney.videolife.common.base.BasePresenter;

/**
 * Created by paohaile on 17/2/24.
 */

public class BookFragment extends BaseFragment {
    public static BookFragment newInstance(){
        Bundle bundle = new Bundle();
        BookFragment bookFragment = new BookFragment();
        bookFragment.setArguments(bundle);
        return bookFragment;
    }


    @Override
    protected void initInject() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.video_fragment;
    }

    @Override
    protected void initEventAndData() {

    }

}
