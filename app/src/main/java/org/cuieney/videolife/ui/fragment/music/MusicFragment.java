package org.cuieney.videolife.ui.fragment.music;

import android.os.Bundle;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.BaseFragment;
import org.cuieney.videolife.common.base.BasePresenter;

/**
 * Created by paohaile on 17/2/24.
 */

public class MusicFragment extends BaseFragment {

    public static MusicFragment newInstance(){
        Bundle bundle = new Bundle();
        MusicFragment musicFragment = new MusicFragment();
        musicFragment.setArguments(bundle);
        return musicFragment;
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
