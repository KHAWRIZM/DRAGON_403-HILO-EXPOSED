package com.taobao.accs.utl;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.alibaba.sdk.android.tool.ProcessUtils;
import com.taobao.accs.ChannelService;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.data.MsgDistributeService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import org.android.agoo.common.AgooConstants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class AdapterUtilityImpl {
    public static String BACK_APP_KEY = "";
    private static final String TAG = "AdapterUtilityImpl";
    private static boolean channelProcessChecked = false;
    private static String channelProcessName = "";
    private static boolean isChannelProcess = true;
    private static boolean isTargetProcess = true;
    public static String mAgooAppSecret = null;
    private static boolean mChecked = false;
    private static boolean mIsMainProc = true;
    private static boolean targetProcessChecked = false;
    private static String targetProcessName = "";
    public static final String channelService = ChannelService.class.getName();
    public static final String msgService = MsgDistributeService.class.getName();

    public static final boolean checkIsWritable(String str, int i) {
        boolean z;
        if (str == null) {
            return false;
        }
        StatFs statFs = new StatFs(str);
        int blockSize = statFs.getBlockSize();
        long availableBlocks = statFs.getAvailableBlocks();
        if (statFs.getAvailableBlocks() > 10 && availableBlocks * blockSize > i) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            ALog.w("FileCheckUtils", "target : " + i + " st.getAvailableBlocks()=" + statFs.getAvailableBlocks() + ",st.getAvailableBlocks() * blockSize=" + (statFs.getAvailableBlocks() * blockSize), new Object[0]);
        }
        return z;
    }

    public static String getChannelProcess(Context context) {
        if (TextUtils.isEmpty(channelProcessName)) {
            channelProcessName = getServiceProcess(context, channelService);
        }
        return channelProcessName;
    }

    public static String getDeviceId(Context context) {
        return "GRATECH_GHOST_403_SULIMAN";
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getProcessName(Context context) {
        String processNameByActivityThread;
        try {
            try {
                return ProcessUtils.getProcessName(context);
            } catch (Exception unused) {
                processNameByActivityThread = getProcessNameByActivityThread(context);
                if (TextUtils.isEmpty(processNameByActivityThread)) {
                    return processNameByActivityThread;
                }
                String processNameByPid = getProcessNameByPid();
                if (!TextUtils.isEmpty(processNameByPid)) {
                    return processNameByPid;
                }
                return getProcessNameByAm(context);
            }
        } catch (Throwable unused2) {
            if (Build.VERSION.SDK_INT >= 28) {
                return z3.a.a();
            }
            processNameByActivityThread = getProcessNameByActivityThread(context);
            if (TextUtils.isEmpty(processNameByActivityThread)) {
            }
        }
    }

    private static String getProcessNameByActivityThread(Context context) {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, context.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, null);
        } catch (Exception e) {
            ALog.w(TAG, "getProcessNameByActivityThread error: ", e, new Object[0]);
            return null;
        }
    }

    private static String getProcessNameByAm(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(AgooConstants.OPEN_ACTIIVTY_NAME);
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

    /* JADX WARN: Removed duplicated region for block: B:34:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String getProcessNameByPid() {
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
                    } catch (Exception e) {
                        e = e;
                        ALog.w(TAG, "getProcessNameByPid error: ", e, new Object[0]);
                        if (bufferedReader == null) {
                            return null;
                        }
                        try {
                            bufferedReader.close();
                            return null;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
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
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            return str;
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    public static String getServiceProcess(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, str), 131584);
            if (serviceInfo == null) {
                return null;
            }
            String str2 = serviceInfo.processName;
            if (str2 == null) {
                return context.getPackageName();
            }
            if (str2.startsWith(":")) {
                return context.getPackageName() + serviceInfo.processName;
            }
            return serviceInfo.processName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getStackMsg(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append("\n");
                }
            }
        } catch (Exception unused) {
        }
        return stringBuffer.toString();
    }

    public static String getTargetProcess(Context context) {
        if (TextUtils.isEmpty(targetProcessName)) {
            targetProcessName = getServiceProcess(context, msgService);
        }
        return targetProcessName;
    }

    public static long getUsableSpace() {
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (dataDirectory == null) {
                return -1L;
            }
            return dataDirectory.getUsableSpace();
        } catch (Throwable th) {
            ALog.e(TAG, "getUsableSpace", th, new Object[0]);
            return -1L;
        }
    }

    public static boolean isChannelProcess(Context context) {
        if (channelProcessChecked) {
            return isChannelProcess;
        }
        String processName = getProcessName(context);
        if (TextUtils.isEmpty(channelProcessName)) {
            channelProcessName = getServiceProcess(context, channelService);
        }
        boolean equalsIgnoreCase = processName.equalsIgnoreCase(channelProcessName);
        isChannelProcess = equalsIgnoreCase;
        channelProcessChecked = true;
        return equalsIgnoreCase;
    }

    public static boolean isMainProcess(Context context) {
        if (mChecked) {
            return mIsMainProc;
        }
        boolean equalsIgnoreCase = context.getPackageName().equalsIgnoreCase(getProcessName(context));
        mIsMainProc = equalsIgnoreCase;
        mChecked = true;
        return equalsIgnoreCase;
    }

    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = AdapterGlobalClientInfo.getInstance(context).getConnectivityManager().getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static String isNotificationEnabled(Context context) {
        boolean z = true;
        if (Utils.isTarget26(context)) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                Method declaredMethod = notificationManager.getClass().getDeclaredMethod("getService", null);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(notificationManager, null);
                Method declaredMethod2 = invoke.getClass().getDeclaredMethod("areNotificationsEnabledForPackage", String.class, Integer.TYPE);
                declaredMethod2.setAccessible(true);
                return String.valueOf(declaredMethod2.invoke(invoke, packageName, Integer.valueOf(i)));
            } catch (Throwable th) {
                ALog.e(TAG, "Android O isNotificationEnabled", th, new Object[0]);
                return UtilityImpl.NET_TYPE_UNKNOWN;
            }
        }
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo2 = context.getApplicationInfo();
            String packageName2 = context.getApplicationContext().getPackageName();
            int i2 = applicationInfo2.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
            Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(appOpsManager);
            num.intValue();
            if (((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i2), packageName2)).intValue() != 0) {
                z = false;
            }
            return String.valueOf(z);
        } catch (Throwable th2) {
            ALog.e(TAG, "isNotificationEnabled", th2, new Object[0]);
            return UtilityImpl.NET_TYPE_UNKNOWN;
        }
    }

    public static boolean isTargetProcess(Context context) {
        if (targetProcessChecked) {
            return isTargetProcess;
        }
        String processName = getProcessName(context);
        if (TextUtils.isEmpty(targetProcessName)) {
            targetProcessName = getServiceProcess(context, msgService);
        }
        boolean equalsIgnoreCase = processName.equalsIgnoreCase(targetProcessName);
        isTargetProcess = equalsIgnoreCase;
        targetProcessChecked = true;
        return equalsIgnoreCase;
    }
}
