package anet.channel.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.monitor.NetworkSpeed;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.status.NetworkStatusHelper;
import com.ta.utdid2.device.UTDevice;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class Utils {
    private static final String TAG = "awcn.Utils";
    public static Context context;

    public static Context getAppContext() {
        Context context2 = context;
        if (context2 != null) {
            return context2;
        }
        synchronized (Utils.class) {
            Context context3 = context;
            if (context3 != null) {
                return context3;
            }
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", null).invoke(cls, null);
                context = (Context) invoke.getClass().getMethod("getApplication", null).invoke(invoke, null);
            } catch (Exception e10) {
                ALog.w(TAG, "getAppContext", null, e10, new Object[0]);
            }
            return context;
        }
    }

    public static String getDeviceId(Context context2) {
        return UTDevice.getUtdid(context2);
    }

    public static String getMainProcessName(Context context2) {
        if (context2 == null) {
            return "";
        }
        try {
            return context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).applicationInfo.processName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static float getNetworkTimeFactor() {
        float f10;
        NetworkStatusHelper.NetworkStatus status = NetworkStatusHelper.getStatus();
        if (status != NetworkStatusHelper.NetworkStatus.G4 && status != NetworkStatusHelper.NetworkStatus.WIFI) {
            f10 = 1.0f;
        } else {
            f10 = 0.8f;
        }
        if (anet.channel.monitor.b.a().b() == NetworkSpeed.Fast.getCode()) {
            return f10 * 0.75f;
        }
        return f10;
    }

    public static String getProcessName(Context context2, int i10) {
        String str = "";
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context2.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == i10) {
                        str = runningAppProcessInfo.processName;
                        break;
                    }
                }
            } else {
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_GET_PROCESS_NULL, ErrorConstant.formatMsg(ErrorConstant.ERROR_GET_PROCESS_NULL, "BuildVersion=" + String.valueOf(Build.VERSION.SDK_INT)), "rt"));
            }
        } catch (Exception e10) {
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_GET_PROCESS_NULL, e10.toString(), "rt"));
        }
        if (TextUtils.isEmpty(str)) {
            return getProcessNameNew(i10);
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0087, code lost:
    
        r10 = r3[8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008b, code lost:
    
        r7.close();
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0092, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0093, code lost:
    
        anet.channel.util.ALog.e(anet.channel.util.Utils.TAG, "getProcessNameNew ", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00dd A[Catch: IOException -> 0x00d9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00d9, blocks: (B:65:0x00d5, B:58:0x00dd), top: B:64:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String getProcessNameNew(int i10) {
        BufferedReader bufferedReader;
        DataOutputStream dataOutputStream;
        Process exec;
        String str;
        String str2 = "ps  |  grep  " + i10;
        try {
            exec = Runtime.getRuntime().exec("sh");
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        } catch (Exception e10) {
            e = e10;
            bufferedReader = null;
            dataOutputStream = null;
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
            dataOutputStream = null;
        }
        try {
            dataOutputStream = new DataOutputStream(exec.getOutputStream());
            try {
                try {
                    dataOutputStream.writeBytes(str2 + "  &\n");
                    dataOutputStream.flush();
                    dataOutputStream.writeBytes("exit\n");
                    exec.waitFor();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String[] split = readLine.replaceAll("\\s+", "  ").split("  ");
                            if (split.length >= 9 && !TextUtils.isEmpty(split[1]) && split[1].trim().equals(String.valueOf(i10))) {
                                break;
                            }
                        } else {
                            try {
                                bufferedReader.close();
                                dataOutputStream.close();
                                return "";
                            } catch (IOException e11) {
                                ALog.e(TAG, "getProcessNameNew ", null, e11, new Object[0]);
                                return "";
                            }
                        }
                    }
                    return str;
                } catch (Exception e12) {
                    e = e12;
                    ALog.e(TAG, "getProcessNameNew ", null, e, new Object[0]);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e13) {
                            ALog.e(TAG, "getProcessNameNew ", null, e13, new Object[0]);
                            return "";
                        }
                    }
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                        return "";
                    }
                    return "";
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e14) {
                        ALog.e(TAG, "getProcessNameNew ", null, e14, new Object[0]);
                        throw th;
                    }
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e15) {
            e = e15;
            dataOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            if (bufferedReader != null) {
            }
            if (dataOutputStream != null) {
            }
            throw th;
        }
    }

    public static String getStackMsg(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString() + "\n");
                }
            }
        } catch (Exception e10) {
            ALog.e(TAG, "getStackMsg", null, e10, new Object[0]);
        }
        return stringBuffer.toString();
    }

    public static Object invokeStaticMethodThrowException(String str, String str2, Class<?>[] clsArr, Object... objArr) throws Exception {
        Method declaredMethod;
        if (str == null || str2 == null) {
            return null;
        }
        Class<?> cls = Class.forName(str);
        if (clsArr != null) {
            declaredMethod = cls.getDeclaredMethod(str2, clsArr);
        } else {
            declaredMethod = cls.getDeclaredMethod(str2, null);
        }
        if (declaredMethod == null) {
            return null;
        }
        declaredMethod.setAccessible(true);
        if (objArr != null) {
            return declaredMethod.invoke(cls, objArr);
        }
        return declaredMethod.invoke(cls, null);
    }
}
