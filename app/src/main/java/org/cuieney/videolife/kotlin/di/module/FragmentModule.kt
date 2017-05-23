package org.cuieney.videolife.kotlin.di.module

import android.app.Activity
import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import org.cuieney.videolife.di.PerFragment

/**
 * Created by cuieney on 2017/5/22.
 */
@dagger.Module class FragmentModule(fragment: android.support.v4.app.Fragment){
    var mFragment: android.support.v4.app.Fragment = fragment

    @dagger.Provides
    @org.cuieney.videolife.di.PerFragment
    fun provideActivity(): android.app.Activity = mFragment.activity

}