package org.cuieney.videolife.di.component;

import android.app.Activity;


import org.cuieney.videolife.di.PerActivity;
import org.cuieney.videolife.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by cuieney on 16/8/7.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();


}
