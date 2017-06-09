package org.cuieney.videolife.kotlin.di.module

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import dagger.Module
import dagger.Provides
import org.cuieney.videolife.di.PerFragment

/**
 * Created by cuieney on 2017/5/22.
 */
@Module class FragmentModule(fragment:Fragment){
    var mFragment: Fragment = fragment

    @Provides
    @PerFragment
    fun provideActivity(): FragmentActivity = mFragment.activity

}