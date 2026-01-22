package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(24)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzch {
    private static final Method zza;
    private static final Method zzb;

    /* JADX WARN: Removed duplicated region for block: B:9:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        Method declaredMethod;
        Method method = null;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                declaredMethod = JobScheduler.class.getDeclaredMethod("scheduleAsPackage", JobInfo.class, String.class, Integer.TYPE, String.class);
            } catch (NoSuchMethodException unused) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
                }
            }
            zza = declaredMethod;
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    method = UserHandle.class.getDeclaredMethod("myUserId", null);
                } catch (NoSuchMethodException unused2) {
                    if (Log.isLoggable("JobSchedulerCompat", 6)) {
                        Log.e("JobSchedulerCompat", "No myUserId method available");
                    }
                }
            }
            zzb = method;
        }
        declaredMethod = null;
        zza = declaredMethod;
        if (Build.VERSION.SDK_INT >= 24) {
        }
        zzb = method;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zza(Context context, JobInfo jobInfo, String str, String str2) {
        int checkSelfPermission;
        Integer num;
        int intValue;
        Method method;
        JobScheduler jobScheduler = (JobScheduler) k8.h.i((JobScheduler) context.getSystemService("jobscheduler"));
        if (zza != null) {
            checkSelfPermission = context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS");
            if (checkSelfPermission == 0) {
                Method method2 = zzb;
                if (method2 != null) {
                    try {
                        num = (Integer) method2.invoke(UserHandle.class, null);
                    } catch (IllegalAccessException | InvocationTargetException e10) {
                        if (Log.isLoggable("JobSchedulerCompat", 6)) {
                            Log.e("JobSchedulerCompat", "myUserId invocation illegal", e10);
                        }
                    }
                    if (num != null) {
                        intValue = num.intValue();
                        method = zza;
                        if (method != null) {
                            try {
                                Integer num2 = (Integer) method.invoke(jobScheduler, jobInfo, "com.google.android.gms", Integer.valueOf(intValue), "UploadAlarm");
                                if (num2 == null) {
                                    return 0;
                                }
                                return num2.intValue();
                            } catch (IllegalAccessException | InvocationTargetException e11) {
                                Log.e("UploadAlarm", "error calling scheduleAsPackage", e11);
                            }
                        }
                        return jobScheduler.schedule(jobInfo);
                    }
                }
                intValue = 0;
                method = zza;
                if (method != null) {
                }
                return jobScheduler.schedule(jobInfo);
            }
        }
        return jobScheduler.schedule(jobInfo);
    }
}
