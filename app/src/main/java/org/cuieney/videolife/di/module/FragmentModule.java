package org.cuieney.videolife.di.module;


import android.app.Activity;
import android.support.v4.app.Fragment;

import org.cuieney.videolife.di.PerFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {


    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @PerFragment
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
