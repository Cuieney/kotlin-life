package org.cuieney.videolife.di.component;

import android.app.Activity;


import org.cuieney.videolife.di.PerFragment;
import org.cuieney.videolife.di.module.FragmentModule;
import org.cuieney.videolife.ui.fragment.essay.EssayHomeDetailFragment;
import org.cuieney.videolife.ui.fragment.essay.EssayHomeFragment;
import org.cuieney.videolife.ui.fragment.music.MusicHomeFragment;
import org.cuieney.videolife.ui.fragment.video.VideoFragment;
import org.cuieney.videolife.ui.fragment.video.VideoHomeFragment;

import dagger.Component;

/**
 * Created by cuieney on 16/8/7.
 */

@PerFragment
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(VideoHomeFragment videoFragment);
    void inject(MusicHomeFragment musicFragment);
    void inject(EssayHomeFragment essayFragment);
    void inject(EssayHomeDetailFragment homeDetailFragment);
}
