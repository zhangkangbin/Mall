package com.z.baselibrary.tool;

import android.app.Activity;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * Activity管理和应用程序退出
 */
public class ActivityManager {

    private static Stack<Activity> mActivityStack;
    private volatile  static ActivityManager mActivityManager;  //volatile修饰的变量
    private final String TAG = ActivityManager.class.getSimpleName();

    public static ActivityManager getInstance() {
        if (mActivityManager == null) {
            synchronized (ActivityManager.class){
                if (mActivityManager == null) {
                    mActivityManager = new ActivityManager();
                }
            }
        }
        return mActivityManager;
    }

    /**
     * @param activity
     * @return void
     * @Title: addActivity
     * @Description: 添加Activity到堆栈(这里用一句话描述这个方法的作用)
     */
    public void addActivity(Activity activity) {
        if (mActivityStack == null) {
            mActivityStack = new Stack<>();
        }
        mActivityStack.add(activity);
    }

    /**
     * 查找获取某个activity
     *
     * @param getActivityCLS
     * @return
     */
    public Activity getActivity(Class<?> getActivityCLS) {
        if (mActivityStack == null || mActivityStack.size() <= 0)
            return null;

        for (Activity activity : mActivityStack) {
            if (activity != null && activity.getClass().equals(getActivityCLS)) {
                return activity;
            }
        }

        return null;
    }

    /**
     * @return Activity
     * @Title: getTopActivity
     * @Description: 获取栈顶Activity(堆栈中最后一个压入的)(这里用一句话描述这个方法的作用)
     */
    public Activity getTopActivity() {
        return mActivityStack == null ? null : mActivityStack.lastElement();
    }

    /**
     * @return void
     * @Title: killTopActivity
     * @Description: 结束栈顶Activity(堆栈中最后一个压入的)(这里用一句话描述这个方法的作用)
     */
    public void killTopActivity() {
        Activity activity = mActivityStack == null ? null : mActivityStack.lastElement();
        killActivity(activity);
    }

    /**
     * @param activity
     * @return void
     * @Title: killActivity
     * @Description: 结束指定的Activity(这里用一句话描述这个方法的作用)
     */
    public void killActivity(Activity activity) {
        try {
            if (activity == null)
                return;
            mActivityStack.remove(activity);
            activity.finish();
            activity = null;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    /**
     * @param cls
     * @return void
     * @Title: killThisActivity
     * @Description: 结束指定类名的Activity
     * 注：必须用iterator.remove，否则java.util.ConcurrentModificationException
     * (这里用一句话描述这个方法的作用)
     */
    public void killThisActivity(Class<?> cls) {
        if (mActivityStack == null || mActivityStack.size() <= 0)
            return;

        for (Activity activity : mActivityStack) {
            if (activity != null && activity.getClass().equals(cls)) {
                killActivity(activity);
                break;
            }
        }
    }

    /**
     * @param cls
     * @return void
     * @Title: killOtherAllActivity
     * @Description: 结束非指定类名的其它所有Activity(如：只要保留MainActivity)(这里用一句话描述这个方法的作用)
     */
    public void killOtherAllActivity(Class<?> cls) {
        if (mActivityStack == null || mActivityStack.size() <= 0)
            return;

        Iterator<Activity> it = mActivityStack.iterator();
        while (it.hasNext()) {
            Activity activity = it.next();
            if (activity != null && !activity.getClass().equals(cls)) {
                activity.finish();
                it.remove();
            }
        }
    }

    /**
     * @return void
     * @Title: killAllActivity
     * @Description: 结束所有Activity(这里用一句话描述这个方法的作用)
     */
    public void killAllActivity() {
     //   Logger.getLogger().logD("mytest","killAllActivity");
        if (mActivityStack == null || mActivityStack.size() <= 0)
            return;

        Iterator<Activity> it = mActivityStack.iterator();
        while (it.hasNext()) {
            Activity activity = it.next();
            if (activity != null)
                activity.finish();
        }
        mActivityStack.clear();
    }

    /**
     * @return void
     * @Title: isContainsThisActivity
     * @Description:是否包含这个Activity(这里用一句话描述这个方法的作用)
     */
    public boolean isContainsThisActivity(Class<?> cls) {
        if (mActivityStack == null || mActivityStack.size() <= 0)
            return false;

        for (Activity activity : mActivityStack) {
            if (activity.getClass().equals(cls))
                return true;
        }
        return false;
    }

    /**
     * @return void
     * @Title: AppExit
     * @Description: 退出应用程序(这里用一句话描述这个方法的作用)<br>
     * android2.2版本之后则不能再使用restartPackage()方法，
     * 而应该使用killBackgroundProcesses()方法 <br>
     */
    public void AppExit() {
        try {
            killAllActivity();
            System.exit(0);
            // android.os.Process.killProcess(android.os.Process.myPid());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
         //   log.logCacheE(TAG, "AppExit");
        }
    }

/*    *//**
     * 打印信息
     *//*
    public void printlnStackInfo() {
        if (mActivityStack == null || mActivityStack.size() <= 0) {
           // log.logE(TAG, " :: printlnStack ::  stack= null !!!");
            return;
        }
        for (Activity activity : mActivityStack) {
            // log.logE(TAG, " :: printlnStack ::  activity= " + activity.getClass().getSimpleName());
        }
    }*/
}
