package v9;

import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b {
    public static String a(String[] strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            String e10 = e(str);
            if (!e10.isEmpty()) {
                return e10;
            }
        }
        return "";
    }

    private static String b(String str) {
        Class<?> cls = Class.forName("android.os.SystemProperties");
        return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
    }

    private static String c(String str) {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader2.readLine();
                if (readLine != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused) {
                    }
                    return readLine;
                }
                try {
                    bufferedReader2.close();
                } catch (IOException unused2) {
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String d(String str) {
        FileInputStream fileInputStream = null;
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream2 = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            try {
                properties.load(fileInputStream2);
                String property = properties.getProperty(str, "");
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return property;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String e(String str) {
        String str2;
        if (str != null && !str.isEmpty()) {
            try {
                str2 = b(str);
            } catch (Exception unused) {
                str2 = null;
            }
            if (str2 != null && !str2.isEmpty()) {
                return str2;
            }
            try {
                str2 = c(str);
            } catch (IOException unused2) {
            }
            if (str2 != null && !str2.isEmpty()) {
                return str2;
            }
            try {
                str2 = d(str);
            } catch (IOException unused3) {
            }
            if (str2 != null && !str2.isEmpty()) {
                return str2;
            }
        }
        return "";
    }

    public static String[] f(String[] strArr) {
        if (strArr == null) {
            return new String[0];
        }
        String[] strArr2 = new String[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            strArr2[i10] = e(strArr[i10]);
        }
        return strArr2;
    }

    public static boolean g(String[] strArr) {
        if (strArr == null) {
            return false;
        }
        for (String str : strArr) {
            if (h(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(String str) {
        return !TextUtils.isEmpty(e(str));
    }
}
