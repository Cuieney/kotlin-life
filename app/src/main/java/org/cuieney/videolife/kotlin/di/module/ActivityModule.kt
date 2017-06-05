package org.cuieney.videolife.kotlin.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import org.cuieney.videolife.di.PerActivity

/**
 * Created by cuieney on 2017/5/19.
 */
@Module class ActivityModule constructor(activity: Activity){
    var act : Activity = activity

    @Provides
    @PerActivity
    fun provideActivity(): android.app.Activity = act

}