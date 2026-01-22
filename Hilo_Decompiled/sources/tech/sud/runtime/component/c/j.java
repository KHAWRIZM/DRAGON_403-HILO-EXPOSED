package tech.sud.runtime.component.c;

import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class j {
    private static Method a;
    private static j b;

    private j() {
        a = a(b("android.os.SystemProperties"));
    }

    public static j a() {
        if (b == null) {
            synchronized (j.class) {
                try {
                    if (b == null) {
                        b = new j();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    private Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            tech.sud.runtime.component.h.f.e("SystemProperties", e.getMessage());
            try {
                return ClassLoader.getSystemClassLoader().loadClass(str);
            } catch (ClassNotFoundException e2) {
                tech.sud.runtime.component.h.f.e("SystemProperties", e2.getMessage());
                return null;
            }
        }
    }

    private Method a(Class cls) {
        if (cls != null) {
            try {
                return cls.getMethod("get", String.class);
            } catch (Exception e) {
                tech.sud.runtime.component.h.f.e("SystemProperties", e.getMessage());
            }
        }
        return null;
    }

    public final String a(String str) {
        if (str == null) {
            return "";
        }
        try {
            Method method = a;
            String str2 = (String) (method != null ? method.invoke(null, str) : null);
            if (str2 != null) {
                return str2.trim();
            }
        } catch (Exception unused) {
        }
        return "";
    }
}
