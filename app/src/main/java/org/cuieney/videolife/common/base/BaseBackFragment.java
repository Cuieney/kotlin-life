package org.cuieney.videolife.common.base;

import android.support.v7.widget.Toolbar;

import org.cuieney.videolife.R;
import org.cuieney.videolife.common.component.EventUtil;

import me.yokeyword.fragmentation.SupportFragment;


/**
 * Created by cuieney on 16/2/7.
 */
public abstract class BaseBackFragment extends SupportFragment {
    protected static final String ARG_ITEM = "arg_item";

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
