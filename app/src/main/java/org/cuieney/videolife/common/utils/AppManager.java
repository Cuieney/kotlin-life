package org.cuieney.videolife.common.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.ConcurrentModificationException;
import java.util.Stack;

/**
 * Created by cuieney on 16/12/5.
 */
public class AppManager {

    // Activity栈
    private static Stack<Activity> activityStack;
    // 单例模式

    private AppManager() {
    }

    private static class InstanceHolder {
        private static AppManager instance = new AppManager();
    }

    /**
     * 单一实例
     */
    public static AppManager getAppManager() {
        return InstanceHolder.instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            if (activityStack != null) {
                activityStack.remove(activity);
                activity.finish();
                activity = null;
            }
        }
    }

    public boolean getLastAcitivty(Class<?> cls){
        try {
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(cls)) {
                    return true;
                }
            }

        } catch (ConcurrentModificationException e) {
        }
        return false;
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        try {
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(cls)) {
                    finishActivity(activity);
                }
            }

        } catch (ConcurrentModificationException e) {
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0; i < activityStack.size(); i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityMgr = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
        }
    }
}
