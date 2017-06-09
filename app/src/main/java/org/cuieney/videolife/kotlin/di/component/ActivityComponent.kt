package org.cuieney.videolife.kotlin.di.component

import android.app.Activity
import dagger.Component
import org.cuieney.videolife.di.PerActivity
import org.cuieney.videolife.kotlin.di.module.ActivityModule
import org.cuieney.videolife.kotlin.ui.act.VrActivity

/**
 * Created by cuieney on 2017/5/22.
 */
@PerActivity
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent{
    fun getActivity(): Activity
    fun inject(vrActivity: VrActivity)
}