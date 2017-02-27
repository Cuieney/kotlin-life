package org.cuieney.videolife.ui.fragment.newstand;

import android.os.Bundle;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.BaseFragment;
import org.cuieney.videolife.common.base.BasePresenter;

/**
 * Created by paohaile on 17/2/24.
 */

public class NewstandFragment extends BaseFragment {

    public static NewstandFragment newInstance(){
        Bundle bundle = new Bundle();
        NewstandFragment newstandFragment = new NewstandFragment();
        newstandFragment.setArguments(bundle);
        return newstandFragment;
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
