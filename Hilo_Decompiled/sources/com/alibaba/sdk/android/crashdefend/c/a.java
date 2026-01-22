package com.alibaba.sdk.android.crashdefend.c;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:34:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a() {
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
                        Log.d("CrashUtils", "getProcessNameByPid error: " + e);
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

    private static String b(Context context) {
        String processName;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
                return processName;
            }
        } catch (Throwable th) {
            Log.e("CrashUtils", "Application gerProcessName error: " + Log.getStackTraceString(th));
        }
        String d10 = d(context);
        if (!TextUtils.isEmpty(d10)) {
            return d10;
        }
        String a10 = a();
        return !TextUtils.isEmpty(a10) ? a10 : c(context);
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

    private static String d(Context context) {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, context.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, null);
        } catch (Exception e10) {
            Log.d("CrashUtils", "getProcessNameByActivityThread error: " + e10);
            return null;
        }
    }

    public static synchronized void a(Context context, com.alibaba.sdk.android.crashdefend.a.a aVar, List<com.alibaba.sdk.android.crashdefend.a.b> list) {
        String str;
        String str2;
        synchronized (a.class) {
            if (context == null || list == null) {
                return;
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (aVar != null) {
                        jSONObject.put("startSerialNumber", aVar.f٦٣٧١a);
                    }
                    try {
                        JSONArray jSONArray = new JSONArray();
                        for (com.alibaba.sdk.android.crashdefend.a.b bVar : list) {
                            if (bVar != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("sdkId", bVar.f٦٣٧٥a);
                                jSONObject2.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, bVar.f٦٣٧٦b);
                                jSONObject2.put("crashLimit", bVar.f٦٣٧٧c);
                                jSONObject2.put("crashCount", bVar.f٦٣٧٨d);
                                jSONObject2.put("waitTime", bVar.f٦٣٧٩e);
                                jSONObject2.put("registerSerialNumber", bVar.f٦٣٨٠f);
                                jSONObject2.put("startSerialNumber", bVar.f٦٣٨١g);
                                jSONObject2.put("restoreCount", bVar.f٦٣٨٢h);
                                jSONObject2.put("nextRestoreInterval", bVar.f٦٣٨٣i);
                                jSONArray.put(jSONObject2);
                            }
                        }
                        jSONObject.put("sdkList", jSONArray);
                    } catch (JSONException e10) {
                        Log.e("CrashUtils", "save sdk json fail:", e10);
                    }
                    String jSONObject3 = jSONObject.toString();
                    fileOutputStream = context.openFileOutput(a(context) ? "com_alibaba_aliyun_crash_defend_sdk_info" : "com_alibaba_aliyun_crash_defend_sdk_info_" + b(context), 0);
                    fileOutputStream.write(jSONObject3.getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException e11) {
                        e = e11;
                        str = "CrashUtils";
                        str2 = "save sdk io fail:";
                        Log.e(str, str2, e);
                    }
                } catch (IOException e12) {
                    b.a("CrashUtils", "save sdk io fail:", e12);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e13) {
                            e = e13;
                            str = "CrashUtils";
                            str2 = "save sdk io fail:";
                            Log.e(str, str2, e);
                        }
                    }
                } catch (Exception e14) {
                    b.a("CrashUtils", "save sdk exception:", e14);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e15) {
                            e = e15;
                            str = "CrashUtils";
                            str2 = "save sdk io fail:";
                            Log.e(str, str2, e);
                        }
                    }
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d7 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean b(Context context, com.alibaba.sdk.android.crashdefend.a.a aVar, List<com.alibaba.sdk.android.crashdefend.a.b> list) {
        String str;
        String str2;
        String str3;
        String str4;
        File filesDir;
        synchronized (a.class) {
            if (context == null || list == null) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            FileInputStream fileInputStream = null;
            try {
                try {
                    try {
                        filesDir = context.getFilesDir();
                    } finally {
                    }
                } catch (FileNotFoundException e10) {
                    b.a("CrashUtils", "load sdk file fail:", e10);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e11) {
                            e = e11;
                            str = "CrashUtils";
                            str2 = "load sdk io fail:";
                            Log.e(str, str2, e);
                            if (sb.length() == 0) {
                            }
                        }
                    }
                }
            } catch (IOException e12) {
                b.a("CrashUtils", "load sdk io fail:", e12);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e13) {
                        e = e13;
                        str = "CrashUtils";
                        str2 = "load sdk io fail:";
                        Log.e(str, str2, e);
                        if (sb.length() == 0) {
                        }
                    }
                }
            } catch (Exception e14) {
                b.a("CrashUtils", "load sdk exception:", e14);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e15) {
                        e = e15;
                        str = "CrashUtils";
                        str2 = "load sdk io fail:";
                        Log.e(str, str2, e);
                        if (sb.length() == 0) {
                        }
                    }
                }
            }
            if (!(a(context) ? new File(filesDir, "com_alibaba_aliyun_crash_defend_sdk_info") : new File(filesDir, "com_alibaba_aliyun_crash_defend_sdk_info_" + b(context))).exists()) {
                return false;
            }
            fileInputStream = context.openFileInput(a(context) ? "com_alibaba_aliyun_crash_defend_sdk_info" : "com_alibaba_aliyun_crash_defend_sdk_info_" + b(context));
            byte[] bArr = new byte[512];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    sb.append(new String(bArr, 0, read));
                } else {
                    try {
                        break;
                    } catch (IOException e16) {
                        e = e16;
                        str = "CrashUtils";
                        str2 = "load sdk io fail:";
                        Log.e(str, str2, e);
                        if (sb.length() == 0) {
                        }
                    }
                }
            }
            fileInputStream.close();
            if (sb.length() == 0) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(sb.toString());
                aVar.f٦٣٧١a = jSONObject.optLong("startSerialNumber", 1L);
                JSONArray jSONArray = jSONObject.getJSONArray("sdkList");
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                    if (jSONObject2 != null) {
                        com.alibaba.sdk.android.crashdefend.a.b bVar = new com.alibaba.sdk.android.crashdefend.a.b();
                        bVar.f٦٣٧٥a = jSONObject2.optString("sdkId", "");
                        bVar.f٦٣٧٦b = jSONObject2.optString(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "");
                        bVar.f٦٣٧٧c = jSONObject2.optInt("crashLimit", -1);
                        bVar.f٦٣٧٨d = jSONObject2.optInt("crashCount", 0);
                        bVar.f٦٣٧٩e = jSONObject2.optInt("waitTime", 0);
                        bVar.f٦٣٨٠f = jSONObject2.optLong("registerSerialNumber", 0L);
                        bVar.f٦٣٨١g = jSONObject2.optLong("startSerialNumber", 0L);
                        bVar.f٦٣٨٢h = jSONObject2.optInt("restoreCount", 0);
                        bVar.f٦٣٨٣i = jSONObject2.optInt("nextRestoreInterval", 0);
                        if (!TextUtils.isEmpty(bVar.f٦٣٧٥a)) {
                            list.add(bVar);
                        }
                    }
                }
            } catch (JSONException e17) {
                e = e17;
                str3 = "CrashUtils";
                str4 = "load sdk json fail:";
                b.a(str3, str4, e);
                return true;
            } catch (Exception e18) {
                e = e18;
                str3 = "CrashUtils";
                str4 = "load sdk exception:";
                b.a(str3, str4, e);
                return true;
            }
            return true;
        }
    }

    private static boolean a(Context context) {
        return context.getPackageName().equalsIgnoreCase(b(context));
    }
}
