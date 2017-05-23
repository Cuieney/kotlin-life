package org.cuieney.videolife.kotlin

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import org.cuieney.videolife.di.module.ActivityModule
import org.cuieney.videolife.kotlin.di.component.AppComponent
import org.cuieney.videolife.kotlin.di.component.DaggerActivityComponent
import org.cuieney.videolife.kotlin.di.component.DaggerAppComponent
import org.cuieney.videolife.kotlin.di.module.AppModule
import org.cuieney.videolife.kotlin.di.module.RetrofitModule
import kotlin.properties.Delegates

/**
 * Created by cuieney on 2017/5/19.
 */
class App : Application() {

    companion object {
        var instance: App by Delegates.notNull()
        var allActivities: MutableList<Activity> by Delegates.notNull<MutableList<Activity>>()
        lateinit var appComponent:AppComponent
    }
    init {
        instance  = this
        appComponent =  DaggerAppComponent.builder()
                .appModule(AppModule(instance))
                .retrofitModule(RetrofitModule(instance))
                .build()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
    }

    fun addActivity(act:Activity){
        allActivities.add(act)
    }

    fun removeActivity(act:Activity){
        allActivities.remove(act)
    }

    fun exitApp(){
        for(act in allActivities){
            act.finish()
        }
        android.os.Process.killProcess(android.os.Process.myPid())
        System.exit(0)
    }


}