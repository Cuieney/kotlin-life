package org.cuieney.videolife.ui.fragment.newstand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.BaseMainFragment;
import org.cuieney.videolife.ui.fragment.video.VideoHomeFragment;

/**
 * Created by paohaile on 17/2/24.
 */

public class NewstandFragment extends BaseMainFragment {

    public static NewstandFragment newInstance(){
        Bundle bundle = new Bundle();
        NewstandFragment newstandFragment = new NewstandFragment();
        newstandFragment.setArguments(bundle);
        return newstandFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fragment, container, false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_first_container, NewstandHomeFragment.newInstance());
        }
    }

}
