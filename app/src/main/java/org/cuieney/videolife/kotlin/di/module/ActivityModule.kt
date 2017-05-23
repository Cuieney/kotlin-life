package org.cuieney.videolife.kotlin.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import org.cuieney.videolife.di.PerActivity

/**
 * Created by cuieney on 2017/5/19.
 */
@dagger.Module class ActivityModule constructor(activity: android.app.Activity){
    var act : android.app.Activity = activity

    @dagger.Provides
    @org.cuieney.videolife.di.PerActivity
    fun provideActivity(): android.app.Activity = act

}