package v9;

import android.os.Build;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    static final String[] f١٨٦٠٧a;

    /* renamed from: b, reason: collision with root package name */
    static final String[] f١٨٦٠٨b;

    /* renamed from: c, reason: collision with root package name */
    static final String[] f١٨٦٠٩c;

    /* renamed from: d, reason: collision with root package name */
    static final String[] f١٨٦١٠d;

    /* renamed from: e, reason: collision with root package name */
    static final String[] f١٨٦١١e;

    /* renamed from: f, reason: collision with root package name */
    static final String[] f١٨٦١٢f;

    /* renamed from: g, reason: collision with root package name */
    static final String[] f١٨٦١٣g;

    /* renamed from: h, reason: collision with root package name */
    static final String[] f١٨٦١٤h;

    /* renamed from: i, reason: collision with root package name */
    static final String[] f١٨٦١٥i;

    /* renamed from: j, reason: collision with root package name */
    static final String[] f١٨٦١٦j;

    /* renamed from: k, reason: collision with root package name */
    static final String[] f١٨٦١٧k;

    /* renamed from: l, reason: collision with root package name */
    static final String[] f١٨٦١٨l;

    /* renamed from: m, reason: collision with root package name */
    static final String[] f١٨٦١٩m = {"ro.flyme.published", "ro.flyme.version.id"};

    /* renamed from: n, reason: collision with root package name */
    static final String[] f١٨٦٢٠n = {"ro.smartisan.sa", "ro.smartisan.version"};

    /* renamed from: o, reason: collision with root package name */
    static final String[] f١٨٦٢١o = {"ro.letv.release.version", "ro.letv.release.version_date", "ro.product.letv_model", "ro.product.letv_name", "sys.letv.fmodelaid", "persist.sys.leui.bootreason", "ro.config.leui_ringtone_slot2", "ro.leui_oem_unlock_enable"};

    /* renamed from: p, reason: collision with root package name */
    static final String[] f١٨٦٢٢p = {"ro.config.lgsi.fp.incremental", "ro.config.lgsi.os.version"};

    /* renamed from: q, reason: collision with root package name */
    static final String[] f١٨٦٢٣q = {"ro.com.zui.version", "ro.zui.version.status", "ro.zui.hardware.displayid", "persist.radio.zui.feature", "ro.config.zuisdk.enabled"};

    /* renamed from: r, reason: collision with root package name */
    private static int f١٨٦٢٤r;

    /* renamed from: s, reason: collision with root package name */
    private static String f١٨٦٢٥s;

    /* renamed from: t, reason: collision with root package name */
    private static String f١٨٦٢٦t;

    static {
        String[] strArr = {"ro.miui.build.region", "ro.miui.region", "ro.vendor.miui.region"};
        f١٨٦٠٧a = strArr;
        String[] strArr2 = {"ro.mi.os.version.name", "ro.mi.os.version.code", "ro.mi.os.version.incremental"};
        f١٨٦٠٨b = strArr2;
        f١٨٦٠٩c = strArr;
        String[] strArr3 = {"ro.miui.ui.version.name", "ro.miui.ui.version.code"};
        f١٨٦١٠d = strArr3;
        f١٨٦١١e = strArr;
        String[] strArr4 = {"ro.build.version.oplusrom", "ro.build.version.opporom"};
        f١٨٦١٢f = strArr4;
        String[] strArr5 = {"ro.vivo.product.version", "ro.vivo.default.version", "ro.vivo.build.version.incremental", "ro.vivo.product.version.incremental", "ro.vivo.build.version", "ro.vivo.system.product.version", "ro.build.software.version"};
        f١٨٦١٣g = strArr5;
        String[] strArr6 = {"msc.config.magic.version", "ro.build.version.magic"};
        f١٨٦١٤h = strArr6;
        String[] strArr7 = {"ro.product.anco.devicetype", "ro.product.os.dist.anco.apiversion", "ro.product.os.dist.anco.releasetype"};
        f١٨٦١٥i = strArr7;
        String[] strArr8 = {"ro.honor.build.display.id", "persist.sys.hiview.base_version", "ro.comp.hl.product_base_version", "ro.build.display.id"};
        f١٨٦١٦j = strArr8;
        String[] strArr9 = {"ro.huawei.build.display.id", "ro.comp.hl.product_base_version", "persist.sys.hiview.base_version", "hw_sc.build.platform.version"};
        f١٨٦١٧k = strArr9;
        String[] strArr10 = {"ro.build.ohos.devicetype", "persist.sys.ohos.osd.cloud.switch"};
        f١٨٦١٨l = strArr10;
        if (b.g(strArr2)) {
            f١٨٦٢٤r = -1248529104;
            f١٨٦٢٥s = "HyperOS";
            f١٨٦٢٦t = d("ro.mi.os.version.incremental");
        } else if (b.g(strArr3)) {
            f١٨٦٢٤r = 2366768;
            f١٨٦٢٥s = "MIUI";
            f١٨٦٢٦t = d("ro.build.version.incremental");
        }
        if (f١٨٦٢٥s == null) {
            String e10 = b.e("ro.build.version.realmeui");
            if (!TextUtils.isEmpty(e10)) {
                f١٨٦٢٤r = -859411254;
                f١٨٦٢٥s = "realmeUI";
                f١٨٦٢٦t = e(e10);
            } else {
                String a10 = b.a(strArr4);
                if (!TextUtils.isEmpty(a10)) {
                    f١٨٦٢٤r = -1680767897;
                    f١٨٦٢٥s = "ColorOS";
                    f١٨٦٢٦t = e(a10);
                }
            }
        }
        if (f١٨٦٢٥s == null) {
            String e11 = b.e("ro.vivo.os.build.display.id");
            if (!TextUtils.isEmpty(e11)) {
                if (e11.toLowerCase().contains("origin")) {
                    f١٨٦٢٤r = 1443687338;
                    f١٨٦٢٥s = "OriginOS";
                    f١٨٦٢٦t = d(strArr5);
                } else if (e11.toLowerCase().contains("funtouch")) {
                    f١٨٦٢٤r = -294058204;
                    f١٨٦٢٥s = "FuntouchOS";
                    f١٨٦٢٦t = d("ro.vivo.os.build.display.id");
                }
            }
        }
        if (f١٨٦٢٥s == null && b.g(strArr6)) {
            f١٨٦٢٤r = -1801284559;
            f١٨٦٢٥s = "MagicOS";
            f١٨٦٢٦t = d(strArr8);
        }
        if (f١٨٦٢٥s == null && b.g(strArr7)) {
            f١٨٦٢٤r = -1214041693;
            f١٨٦٢٥s = "HarmonyOS NEXT ZhuoYiTong";
            f١٨٦٢٦t = "";
        }
        if (f١٨٦٢٥s == null && b.g(strArr10)) {
            f١٨٦٢٤r = 1583864138;
            f١٨٦٢٥s = "HarmonyOS";
            f١٨٦٢٦t = d(strArr9);
        }
        if (f١٨٦٢٥s == null) {
            String e12 = b.e("ro.build.version.emui");
            if (!TextUtils.isEmpty(e12) && e12.toLowerCase().contains("emotionui")) {
                f١٨٦٢٤r = 2132284;
                f١٨٦٢٥s = "EMUI";
                f١٨٦٢٦t = e(e12);
            }
        }
        if (f١٨٦٢٥s == null) {
            String e13 = b.e("ro.build.version.oneui");
            if (!TextUtils.isEmpty(e13)) {
                f١٨٦٢٤r = 76334938;
                f١٨٦٢٥s = "OneUI";
                if (e13.matches("\\d+")) {
                    try {
                        f١٨٦٢٦t = f(Integer.parseInt(e13));
                    } catch (Exception unused) {
                    }
                } else if (e13.matches("\\d+(?:\\.\\d+)+")) {
                    f١٨٦٢٦t = e13;
                }
            }
            if (f١٨٦٢٥s == null || TextUtils.isEmpty(f١٨٦٢٦t)) {
                try {
                    Field declaredField = Build.VERSION.class.getDeclaredField("SEM_PLATFORM_INT");
                    declaredField.setAccessible(true);
                    int i10 = declaredField.getInt(null);
                    f١٨٦٢٤r = 76334938;
                    f١٨٦٢٥s = "OneUI";
                    if (i10 >= 90000) {
                        f١٨٦٢٦t = f(i10 - 90000);
                    }
                } catch (Exception unused2) {
                }
            }
        }
        if (f١٨٦٢٥s == null) {
            String e14 = b.e("ro.oxygen.version");
            if (!TextUtils.isEmpty(e14)) {
                f١٨٦٢٤r = -1363277916;
                f١٨٦٢٥s = "OxygenOS";
                f١٨٦٢٦t = e(e14);
            }
        }
        if (f١٨٦٢٥s == null) {
            String e15 = b.e("ro.rom.version");
            if (!TextUtils.isEmpty(e15)) {
                f١٨٦٢٤r = 2195534;
                f١٨٦٢٥s = "H2OS";
                f١٨٦٢٦t = e(e15);
            }
        }
        if (f١٨٦٢٥s == null && b.g(f١٨٦١٩m)) {
            f١٨٦٢٤r = 67983659;
            f١٨٦٢٥s = "Flyme";
            f١٨٦٢٦t = d("ro.build.display.id");
        }
        if (f١٨٦٢٥s == null && b.h("ro.build.MiFavor_version")) {
            String e16 = b.e("ro.build.display.id");
            if (!TextUtils.isEmpty(e16)) {
                String lowerCase = e16.toLowerCase();
                if (lowerCase.contains("nebulaaios")) {
                    f١٨٦٢٤r = -1668450325;
                    f١٨٦٢٥s = "NebulaAIOS";
                    f١٨٦٢٦t = e(e16);
                } else if (lowerCase.contains("redmagicos")) {
                    f١٨٦٢٤r = -417455456;
                    f١٨٦٢٥s = "RedMagicOS";
                    f١٨٦٢٦t = e(e16);
                } else if (lowerCase.contains("myos")) {
                    f١٨٦٢٤r = 2412720;
                    f١٨٦٢٥s = "MyOS";
                    f١٨٦٢٦t = e(e16);
                } else if (lowerCase.contains("zte")) {
                    f١٨٦٢٤r = -203064298;
                    f١٨٦٢٥s = "MifavorUI";
                    f١٨٦٢٦t = d("ro.build.MiFavor_version");
                }
            }
        }
        if (f١٨٦٢٥s == null) {
            String e17 = b.e("ro.build.nubia.rom.name");
            if (!TextUtils.isEmpty(e17) && e17.toLowerCase().contains("nubiaui")) {
                f١٨٦٢٤r = -2010470489;
                f١٨٦٢٥s = "nubiaUI";
                f١٨٦٢٦t = d("ro.build.nubia.rom.code");
                if (Build.VERSION.SDK_INT >= 27 && a(Build.VERSION.RELEASE) - g() >= 5) {
                    f١٨٦٢٤r = -417455456;
                    f١٨٦٢٥s = "RedMagicOS";
                }
            }
        }
        if (f١٨٦٢٥s == null) {
            String e18 = b.e("ro.config.lgsi.os.name");
            if (!TextUtils.isEmpty(e18) && e18.toLowerCase().contains("zuxos")) {
                f١٨٦٢٤r = 85736225;
                f١٨٦٢٥s = "ZUXOS";
                f١٨٦٢٦t = d(f١٨٦٢٢p);
            } else if (b.g(f١٨٦٢٣q)) {
                f١٨٦٢٤r = 89198;
                f١٨٦٢٥s = "ZUI";
                f١٨٦٢٦t = d("ro.com.zui.version");
            }
        }
        if (f١٨٦٢٥s == null && b.h("ro.asus.rog")) {
            f١٨٦٢٤r = 78153150;
            f١٨٦٢٥s = "ROGUI";
            f١٨٦٢٦t = d("ro.build.version.incremental");
        }
        if (f١٨٦٢٥s == null && b.g(f١٨٦٢٠n)) {
            f١٨٦٢٤r = 1805724132;
            f١٨٦٢٥s = "SmartisanOS";
            f١٨٦٢٦t = d("ro.smartisan.version");
        }
        if (f١٨٦٢٥s == null && b.g(f١٨٦٢١o)) {
            f١٨٦٢٤r = 69017;
            f١٨٦٢٥s = "EUI";
            f١٨٦٢٦t = d("ro.letv.release.version");
        }
        if (f١٨٦٢٥s == null) {
            String e19 = b.e("ro.build.uiversion");
            if (!TextUtils.isEmpty(e19) && e19.toLowerCase().contains("360ui")) {
                f١٨٦٢٤r = 48757121;
                f١٨٦٢٥s = "360UI";
                f١٨٦٢٦t = e(e19);
            }
        }
        if (f١٨٦٢٥s == null) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                Method method = cls.getMethod("getOsBrand", null);
                method.setAccessible(true);
                Object invoke = method.invoke(cls, null);
                if (invoke != null && String.valueOf(invoke).toLowerCase().contains("harmony")) {
                    f١٨٦٢٤r = 1583864138;
                    f١٨٦٢٥s = "HarmonyOS";
                    f١٨٦٢٦t = d(f١٨٦١٧k);
                }
            } catch (Exception unused3) {
            }
        }
        if (f١٨٦٢٥s == null) {
            f١٨٦٢٥s = "";
        }
        if (f١٨٦٢٦t == null) {
            f١٨٦٢٦t = "";
        }
    }

    private static int a(String str) {
        if (str != null && !str.isEmpty()) {
            String[] split = str.split("\\.");
            if (split.length == 0) {
                return -1;
            }
            try {
                return Integer.parseInt(split[0]);
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    private static int b(String str) {
        String group;
        Matcher matcher = Pattern.compile("(\\d+)").matcher(str);
        if (matcher.find() && matcher.groupCount() > 0 && (group = matcher.group(1)) != null) {
            try {
                return Integer.parseInt(group);
            } catch (Exception unused) {
                return 0;
            }
        }
        return 0;
    }

    private static String c(String str) {
        String group;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile("(\\d+(?:\\.\\d+)+)").matcher(str);
        if (!matcher.find() || matcher.groupCount() <= 0 || (group = matcher.group(1)) == null) {
            return "";
        }
        return group;
    }

    private static String d(String... strArr) {
        for (String str : strArr) {
            String c10 = c(b.e(str));
            if (!TextUtils.isEmpty(c10)) {
                return c10;
            }
        }
        for (String str2 : strArr) {
            int b10 = b(b.e(str2));
            if (b10 > 0) {
                return b10 + ".0";
            }
        }
        return "";
    }

    private static String e(String str) {
        String c10 = c(str);
        if (!TextUtils.isEmpty(c10)) {
            return c10;
        }
        int b10 = b(str);
        if (b10 > 0) {
            return b10 + ".0";
        }
        return "";
    }

    private static String f(int i10) {
        int i11 = i10 / 10000;
        int i12 = i10 % 10000;
        int i13 = i10 % 100;
        if (i13 > 0) {
            return i11 + InstructionFileId.DOT + (i12 / 100) + InstructionFileId.DOT + i13;
        }
        return i11 + InstructionFileId.DOT + (i12 / 100);
    }

    public static int g() {
        return a(h());
    }

    public static String h() {
        String str = f١٨٦٢٦t;
        if (str == null) {
            return "";
        }
        return str;
    }

    public static boolean i() {
        if (f١٨٦٢٤r == -1680767897) {
            return true;
        }
        return false;
    }

    public static boolean j() {
        if (f١٨٦٢٤r == 2132284) {
            return true;
        }
        return false;
    }

    public static boolean k() {
        if (f١٨٦٢٤r == -294058204) {
            return true;
        }
        return false;
    }

    public static boolean l() {
        if (f١٨٦٢٤r == 1583864138) {
            return true;
        }
        return false;
    }

    public static boolean m() {
        if (f١٨٦٢٤r == -1248529104) {
            return true;
        }
        return false;
    }

    public static boolean n() {
        if (!m()) {
            return false;
        }
        for (String str : b.f(f١٨٦٠٩c)) {
            if (str.equalsIgnoreCase("cn")) {
                return true;
            }
        }
        return false;
    }

    public static boolean o() {
        return v();
    }

    public static boolean p() {
        if (f١٨٦٢٤r == -1801284559) {
            return true;
        }
        return false;
    }

    public static boolean q() {
        if (f١٨٦٢٤r == 2366768) {
            return true;
        }
        return false;
    }

    public static boolean r() {
        if (!q()) {
            return false;
        }
        for (String str : b.f(f١٨٦١١e)) {
            if (str.equalsIgnoreCase("cn")) {
                return true;
            }
        }
        return false;
    }

    public static boolean s() {
        return v();
    }

    public static boolean t() {
        if (f١٨٦٢٤r == 76334938) {
            return true;
        }
        return false;
    }

    public static boolean u() {
        if (f١٨٦٢٤r == 1805724132) {
            return true;
        }
        return false;
    }

    private static boolean v() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return Boolean.parseBoolean(String.valueOf(cls.getMethod("getBoolean", String.class, Boolean.TYPE).invoke(cls, "persist.sys.miui_optimization", Boolean.valueOf(!"1".equals(String.valueOf(cls.getMethod("get", String.class, String.class).invoke(cls, "ro.miui.cts", "")))))));
        } catch (Exception unused) {
            return true;
        }
    }
}
