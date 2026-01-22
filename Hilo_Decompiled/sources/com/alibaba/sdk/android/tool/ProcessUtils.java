package com.alibaba.sdk.android.tool;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ProcessUtils {
    private static String a(Context context) {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, context.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, null);
        } catch (Exception e10) {
            b.a("Utils", "getProcessNameByActivityThread error: " + e10);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String b(Context context) {
        Throwable th;
        BufferedReader bufferedReader;
        String str;
        BufferedReader bufferedReader2 = null;
        try {
            File file = new File("/proc/" + Process.myPid() + "/cmdline");
            if (file.exists()) {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    try {
                        bufferedReader2 = bufferedReader;
                        str = bufferedReader.readLine().trim();
                    } catch (Exception e10) {
                        e = e10;
                        b.a("Utils", "getProcessNameByPid error: " + e);
                        if (bufferedReader == null) {
                            return null;
                        }
                        try {
                            bufferedReader.close();
                            return null;
                        } catch (IOException e11) {
                            e11.printStackTrace();
                            return null;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    throw th;
                }
            } else {
                str = null;
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            return str;
        } catch (Exception e14) {
            e = e14;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    private static String c(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return "";
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    public static String getProcessName(Context context) {
        String processName;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
            return processName;
        }
        String a10 = a(context);
        if (!TextUtils.isEmpty(a10)) {
            return a10;
        }
        String b10 = b(context);
        return !TextUtils.isEmpty(b10) ? b10 : c(context);
    }

    public static boolean isMainProcess(Context context) {
        if (context == null) {
            return false;
        }
        return context.getPackageName().equalsIgnoreCase(getProcessName(context));
    }
}
