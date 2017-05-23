package org.cuieney.videolife;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import org.cuieney.videolife.di.component.AppComponent;
import org.cuieney.videolife.di.component.DaggerAppComponent;
import org.cuieney.videolife.di.module.AppModule;
import org.cuieney.videolife.di.module.RetrofitModule;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by cuieney on 17/2/21.
 */

public class App extends Application {

    private AppComponent appComponent;
    private static App app;
    private Set<Activity> allActivities;

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;

    public static App getInstance() {
        return app;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    public void getScreenSize() {
        WindowManager windowManager = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if(SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }



    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initAppComponent();
//        AutoLayoutConifg.getInstance().useDeviceSize();
//        getScreenSize();

//        //内存泄漏检测
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }
//        LeakCanary.install(this);
//        BlockCanary.install(this, new AppBlockCanaryContext()).start();

//        CrashHandler.getInstance().initCrashHandler(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .retrofitModule(new RetrofitModule(this))
                .build();
    }
}
