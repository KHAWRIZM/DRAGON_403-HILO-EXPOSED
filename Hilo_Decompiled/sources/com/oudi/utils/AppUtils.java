package com.oudi.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.liulishuo.okdownload.DownloadTask;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AppUtils {
    private static Application sApplication;
    private static final ExecutorService UTIL_POOL = Executors.newFixedThreadPool(3);
    private static final Handler UTIL_HANDLER = new Handler(Looper.getMainLooper());

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface Callback<T> {
        void onCall(T t10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static abstract class Task<Result> implements Runnable {
        private static final int CANCELLED = 2;
        private static final int COMPLETING = 1;
        private static final int EXCEPTIONAL = 3;
        private static final int NEW = 0;
        private final Callback<Result> mCallback;
        private volatile int state = 0;

        public Task(Callback<Result> callback) {
            this.mCallback = callback;
        }

        public void cancel() {
            this.state = 2;
        }

        public abstract Result doInBackground();

        public boolean isCanceled() {
            if (this.state == 2) {
                return true;
            }
            return false;
        }

        public boolean isDone() {
            if (this.state != 0) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                final Result doInBackground = doInBackground();
                if (this.state != 0) {
                    return;
                }
                this.state = 1;
                AppUtils.UTIL_HANDLER.post(new Runnable() { // from class: com.oudi.utils.AppUtils.Task.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Task.this.mCallback.onCall(doInBackground);
                    }
                });
            } catch (Throwable unused) {
                if (this.state != 0) {
                    return;
                }
                this.state = 3;
            }
        }
    }

    private AppUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int compareVersionNames(String str) {
        String versionName = getVersionName();
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int i10 = 0;
        if (versionName.equals(str)) {
            return 0;
        }
        String[] split = versionName.split("\\.");
        String[] split2 = str.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i11 = 0;
        while (true) {
            if (i11 >= min) {
                break;
            }
            int parseInt = Integer.parseInt(split[i11]);
            int parseInt2 = Integer.parseInt(split2[i11]);
            if (parseInt < parseInt2) {
                i10 = 1;
                break;
            }
            if (parseInt > parseInt2) {
                i10 = -1;
                break;
            }
            i11++;
        }
        if (i10 == 0 && split.length != split2.length) {
            if (split.length > split2.length) {
                return -1;
            }
            return 1;
        }
        return i10;
    }

    public static <T> Task<T> doAsync(Task<T> task) {
        UTIL_POOL.execute(task);
        return task;
    }

    public static void fixSoftInputLeaks(Window window) {
        InputMethodManager inputMethodManager = (InputMethodManager) getApp().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        String[] strArr = {"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"};
        for (int i10 = 0; i10 < 4; i10++) {
            try {
                Field declaredField = InputMethodManager.class.getDeclaredField(strArr[i10]);
                if (declaredField != null) {
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(inputMethodManager);
                    if ((obj instanceof View) && ((View) obj).getRootView() == window.getDecorView().getRootView()) {
                        declaredField.set(inputMethodManager, null);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static Application getApp() {
        Application application = sApplication;
        if (application != null) {
            return application;
        }
        Application applicationByReflect = getApplicationByReflect();
        init(applicationByReflect);
        return applicationByReflect;
    }

    private static Application getApplicationByReflect() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getApplication", null).invoke(cls.getMethod("currentActivityThread", null).invoke(null, null), null);
            if (invoke != null) {
                return (Application) invoke;
            }
            throw new NullPointerException("u should init first");
        } catch (ClassNotFoundException e10) {
            e10.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (NoSuchMethodException e12) {
            e12.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (InvocationTargetException e13) {
            e13.printStackTrace();
            throw new NullPointerException("u should init first");
        }
    }

    public static String getCurrentProcessName() {
        String currentProcessNameByFile = getCurrentProcessNameByFile();
        if (!TextUtils.isEmpty(currentProcessNameByFile)) {
            return currentProcessNameByFile;
        }
        String currentProcessNameByAms = getCurrentProcessNameByAms();
        if (!TextUtils.isEmpty(currentProcessNameByAms)) {
            return currentProcessNameByAms;
        }
        return getCurrentProcessNameByReflect();
    }

    private static String getCurrentProcessNameByAms() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String str;
        ActivityManager activityManager = (ActivityManager) getApp().getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() != 0) {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid && (str = runningAppProcessInfo.processName) != null) {
                    return str;
                }
            }
        }
        return "";
    }

    private static String getCurrentProcessNameByFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String trim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return trim;
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    private static String getCurrentProcessNameByReflect() {
        try {
            Application app = getApp();
            Field field = app.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            Object obj = field.get(app);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            return (String) obj2.getClass().getDeclaredMethod("getProcessName", null).invoke(obj2, null);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    private static PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    public static int getVersionCode() {
        PackageInfo packageInfo = getPackageInfo(getApp());
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static String getVersionName() {
        PackageInfo packageInfo = getPackageInfo(getApp());
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return "";
    }

    public static void init(Context context) {
        if (context == null) {
            init(getApplicationByReflect());
        } else {
            init((Application) context.getApplicationContext());
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            UTIL_HANDLER.post(runnable);
        }
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j10) {
        UTIL_HANDLER.postDelayed(runnable, j10);
    }

    public static void init(Application application) {
        if (sApplication != null) {
            sApplication = application;
        } else if (application == null) {
            sApplication = getApplicationByReflect();
        } else {
            sApplication = application;
        }
    }
}
