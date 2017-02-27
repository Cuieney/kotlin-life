package org.cuieney.videolife.ui.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.cuieney.videolife.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by YoKeyword on 16/2/7.
 */
public class BaseBackFragment extends BaseFragment {

    protected void initToolbarNav(Toolbar toolbar) {
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(v ->pop());
        toolbar.inflateMenu(R.menu.video_menu);
    }


}
