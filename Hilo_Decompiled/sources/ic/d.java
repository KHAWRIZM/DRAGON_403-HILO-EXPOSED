package ic;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class d {

    /* renamed from: c, reason: collision with root package name */
    private static String f١٤٨٥٥c;

    /* renamed from: d, reason: collision with root package name */
    private static String f١٤٨٥٦d;

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f١٤٨٥٣a = {"m9", "M9", "mx", "MX"};

    /* renamed from: b, reason: collision with root package name */
    private static FileFilter f١٤٨٥٤b = new a();

    /* renamed from: e, reason: collision with root package name */
    private static boolean f١٤٨٥٧e = false;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f١٤٨٥٨f = false;

    /* renamed from: g, reason: collision with root package name */
    private static final String f١٤٨٥٩g = Build.BRAND.toLowerCase();

    /* renamed from: h, reason: collision with root package name */
    private static long f١٤٨٦٠h = -1;

    /* renamed from: i, reason: collision with root package name */
    private static long f١٤٨٦١i = -1;

    /* renamed from: j, reason: collision with root package name */
    private static long f١٤٨٦٢j = -1;

    /* renamed from: k, reason: collision with root package name */
    private static double f١٤٨٦٣k = -1.0d;

    /* renamed from: l, reason: collision with root package name */
    private static int f١٤٨٦٤l = -1;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f١٤٨٦٥m = false;

    /* renamed from: n, reason: collision with root package name */
    private static ic.a f١٤٨٦٦n = new b();

    /* renamed from: o, reason: collision with root package name */
    private static ic.a f١٤٨٦٧o = new c();

    /* renamed from: p, reason: collision with root package name */
    private static ic.a f١٤٨٦٨p = new C٠١٦٩d();

    /* renamed from: q, reason: collision with root package name */
    private static ic.a f١٤٨٦٩q = new e();

    /* renamed from: r, reason: collision with root package name */
    private static ic.a f١٤٨٧٠r = new f();

    /* renamed from: s, reason: collision with root package name */
    private static ic.a f١٤٨٧١s = new g();

    /* renamed from: t, reason: collision with root package name */
    private static ic.a f١٤٨٧٢t = new h();

    /* renamed from: u, reason: collision with root package name */
    private static ic.a f١٤٨٧٣u = new i();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class b extends ic.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ic.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean b(Void r22) {
            boolean z10;
            d.f();
            if (!TextUtils.isEmpty(d.f١٤٨٥٦d) && d.f١٤٨٥٦d.contains("flyme")) {
                z10 = true;
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class c extends ic.a {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ic.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean b(Void r12) {
            boolean z10;
            d.f();
            if (!d.m(d.f١٤٨٥٣a) && !d.h()) {
                z10 = false;
            } else {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* renamed from: ic.d$d, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class C٠١٦٩d extends ic.a {
        C٠١٦٩d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ic.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean b(Void r22) {
            return Boolean.valueOf(Build.MANUFACTURER.toLowerCase().equals("xiaomi"));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class e extends ic.a {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ic.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean b(Void r22) {
            boolean z10;
            if (!d.f١٤٨٥٩g.contains("vivo") && !d.f١٤٨٥٩g.contains("bbk")) {
                z10 = false;
            } else {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class f extends ic.a {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ic.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean b(Void r22) {
            return Boolean.valueOf(d.f١٤٨٥٩g.contains("oppo"));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class g extends ic.a {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ic.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean b(Void r22) {
            boolean z10;
            if (!d.f١٤٨٥٩g.contains("huawei") && !d.f١٤٨٥٩g.contains("honor")) {
                z10 = false;
            } else {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class h extends ic.a {
        h() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ic.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean b(Void r22) {
            return Boolean.valueOf(d.f١٤٨٥٩g.contains("essential"));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class i extends ic.a {
        i() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ic.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean b(Context context) {
            boolean z10 = false;
            if (d.j() && Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static void f() {
        FileInputStream fileInputStream;
        Exception e10;
        if (f١٤٨٦٥m) {
            return;
        }
        f١٤٨٦٥m = true;
        Properties properties = new Properties();
        ?? r42 = 26;
        if (Build.VERSION.SDK_INT < 26) {
            Closeable closeable = null;
            try {
                try {
                    fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                    try {
                        properties.load(fileInputStream);
                        r42 = fileInputStream;
                    } catch (Exception e11) {
                        e10 = e11;
                        yb.b.b("QMUIDeviceHelper", e10, "read file error", new Object[0]);
                        r42 = fileInputStream;
                        ic.g.a(r42);
                        Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                        f١٤٨٥٥c = g(properties, declaredMethod, "ro.miui.ui.version.name");
                        f١٤٨٥٦d = g(properties, declaredMethod, "ro.build.display.id");
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable = r42;
                    ic.g.a(closeable);
                    throw th;
                }
            } catch (Exception e12) {
                fileInputStream = null;
                e10 = e12;
            } catch (Throwable th2) {
                th = th2;
                ic.g.a(closeable);
                throw th;
            }
            ic.g.a(r42);
        }
        try {
            Method declaredMethod2 = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            f١٤٨٥٥c = g(properties, declaredMethod2, "ro.miui.ui.version.name");
            f١٤٨٥٦d = g(properties, declaredMethod2, "ro.build.display.id");
        } catch (Exception e13) {
            yb.b.b("QMUIDeviceHelper", e13, "read SystemProperties error", new Object[0]);
        }
    }

    private static String g(Properties properties, Method method, String str) {
        String property = properties.getProperty(str);
        if (property == null) {
            try {
                property = (String) method.invoke(null, str);
            } catch (Exception unused) {
            }
        }
        if (property != null) {
            return property.toLowerCase();
        }
        return property;
    }

    public static boolean h() {
        return ((Boolean) f١٤٨٦٦n.a(null)).booleanValue();
    }

    public static boolean i() {
        return ((Boolean) f١٤٨٧١s.a(null)).booleanValue();
    }

    public static boolean j() {
        f();
        return !TextUtils.isEmpty(f١٤٨٥٥c);
    }

    public static boolean k() {
        return ((Boolean) f١٤٨٦٧o.a(null)).booleanValue();
    }

    public static boolean l() {
        return ((Boolean) f١٤٨٧٠r.a(null)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m(String[] strArr) {
        f();
        String str = Build.BOARD;
        if (str == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean n() {
        return ((Boolean) f١٤٨٦٩q.a(null)).booleanValue();
    }

    public static boolean o() {
        return ((Boolean) f١٤٨٦٨p.a(null)).booleanValue();
    }
}
