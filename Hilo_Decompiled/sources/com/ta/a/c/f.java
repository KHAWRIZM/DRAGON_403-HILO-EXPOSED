package com.ta.a.c;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class f {
    private static boolean b;
    private static boolean c;

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m١٢٨a() {
        return b;
    }

    public static void b(String str, Object... objArr) {
        if (c) {
            Log.d(g(), a(str, objArr));
        }
    }

    public static void e() {
        if (b) {
            Log.d(g(), a((String) null, new Object[0]));
        }
    }

    private static String g() {
        String str;
        String str2;
        StackTraceElement a = a();
        if (a == null) {
            str = "";
            str2 = str;
        } else {
            String className = a.getClassName();
            if (TextUtils.isEmpty(className)) {
                str2 = "";
            } else {
                str2 = className.substring(className.lastIndexOf(46) + 1);
            }
            str = a.getMethodName();
        }
        return "Utdid." + str2 + "." + str + "." + String.valueOf(Process.myPid()) + "." + (Thread.currentThread().getId() + "");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m١٢٧a(String str, Object... objArr) {
        if (b) {
            Log.d(g(), a(str, objArr));
        }
    }

    public static void b(String str, Throwable th, Object... objArr) {
        if (c) {
            Log.e(g(), a(str, objArr), th);
        }
    }

    public static void a(String str, Throwable th, Object... objArr) {
        if (b) {
            Log.e(g(), a(str, objArr), th);
        }
    }

    private static String a(Object obj, Object obj2) {
        if (obj == null) {
            obj = "";
        }
        if (obj2 == null) {
            obj2 = "";
        }
        return String.format("%s:%s", obj, obj2);
    }

    private static String a(String str, Object... objArr) {
        int i = 0;
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (str == null) {
            str = "-";
        }
        sb2.append(String.format("[%s] ", str));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                sb2.append(a(objArr[i], objArr[i2]));
                if (i2 < length - 1) {
                    sb2.append(",");
                }
                i += 2;
            }
            if (i == objArr.length - 1) {
                sb2.append(objArr[i]);
            }
        }
        return sb2.toString();
    }

    private static StackTraceElement a() {
        try {
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(f.class.getName())) {
                    return stackTraceElement;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
