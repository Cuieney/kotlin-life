package org.cuieney.videolife.di.module;

import android.app.Activity;


import org.cuieney.videolife.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 这个module把activity暴露给相关联的类。
 * 比如在fragment中使用activity的context。
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity() {
        return mActivity;
    }

}