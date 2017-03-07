package org.cuieney.videolife.ui.fragment.book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.base.BaseMainFragment;
import org.cuieney.videolife.ui.fragment.music.MusicHomeFragment;

/**
 * Created by paohaile on 17/2/24.
 */

public class BookFragment extends BaseMainFragment {
    public static BookFragment newInstance(){
        Bundle bundle = new Bundle();
        BookFragment bookFragment = new BookFragment();
        bookFragment.setArguments(bundle);
        return bookFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.music_fragment, container, false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_first_container, MusicHomeFragment.newInstance());
        }
    }
}
