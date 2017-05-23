package org.cuieney.videolife.ui.fragment.essay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.BaseMainFragment;

/**
 * Created by cuieney on 2017/5/17.
 */

public class EssayFragment extends BaseMainFragment {
    public static EssayFragment newInstance(){
        Bundle bundle = new Bundle();
        EssayFragment essayFragment = new EssayFragment();
        essayFragment.setArguments(bundle);
        return essayFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.essay_fragment, container, false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_first_container, EssayHomeFragment.newInstance());
        }
    }
}