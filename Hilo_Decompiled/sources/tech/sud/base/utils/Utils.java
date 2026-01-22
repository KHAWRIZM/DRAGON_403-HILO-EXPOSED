package tech.sud.base.utils;

import android.app.Application;
import android.content.Context;
import java.lang.reflect.Field;
import tech.sud.gip.logger.SudLogger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class Utils {
    public static final String _TAG = "SudGIP Utils";
    private static Application sApp;

    private static Object getActivityThread() {
        Object activityThreadInActivityThreadStaticField = getActivityThreadInActivityThreadStaticField();
        if (activityThreadInActivityThreadStaticField != null) {
            return activityThreadInActivityThreadStaticField;
        }
        return getActivityThreadInActivityThreadStaticMethod();
    }

    private static Object getActivityThreadInActivityThreadStaticField() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            SudLogger.e(_TAG, "getActivityThreadInActivityThreadStaticField: " + e.getMessage());
            return null;
        }
    }

    private static Object getActivityThreadInActivityThreadStaticMethod() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null).invoke(null, null);
        } catch (Exception e) {
            SudLogger.e(_TAG, "getActivityThreadInActivityThreadStaticMethod: " + e.getMessage());
            return null;
        }
    }

    public static Application getApp() {
        Application application = sApp;
        if (application != null) {
            return application;
        }
        init(getApplicationByReflect());
        if (sApp != null) {
            SudLogger.d(_TAG, UtilsBridge.getCurrentProcessName() + " reflect app success.");
            return sApp;
        }
        throw new NullPointerException("reflect failed.");
    }

    private static Application getApplicationByReflect() {
        Object invoke;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object activityThread = getActivityThread();
            if (activityThread == null || (invoke = cls.getMethod("getApplication", null).invoke(activityThread, null)) == null) {
                return null;
            }
            return (Application) invoke;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void init(Application application) {
        if (application == null) {
            SudLogger.d(_TAG, "app is null.");
            return;
        }
        Application application2 = sApp;
        if (application2 == null) {
            sApp = application;
        } else {
            if (application2.equals(application)) {
                return;
            }
            sApp = application;
        }
    }

    public static void initContext(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                init((Application) applicationContext);
            }
        }
    }
}
