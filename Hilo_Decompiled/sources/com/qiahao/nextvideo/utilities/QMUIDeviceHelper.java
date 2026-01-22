package com.qiahao.nextvideo.utilities;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.android.agoo.common.AgooConstants;

@SuppressLint({"PrivateApi"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class QMUIDeviceHelper {
    private static final String ESSENTIAL = "essential";
    private static final String FLYME = "flyme";
    private static final String KEY_FLYME_VERSION_NAME = "ro.build.display.id";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String TAG = "QMUIDeviceHelper";
    private static final String ZTEC2016 = "zte c2016";
    private static final String ZUKZ1 = "zuk z1";
    private static String sFlymeVersionName;
    private static String sMiuiVersionName;
    private static final String[] MEIZUBOARD = {"m9", "M9", "mx", "MX"};
    private static boolean sIsTabletChecked = false;
    private static boolean sIsTabletValue = false;
    private static final String BRAND = Build.BRAND.toLowerCase();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v8 */
    static {
        FileInputStream fileInputStream;
        Exception e;
        Properties properties = new Properties();
        ?? r6 = 26;
        if (Build.VERSION.SDK_INT < 26) {
            Closeable closeable = null;
            try {
                try {
                    fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                    try {
                        properties.load(fileInputStream);
                        r6 = fileInputStream;
                    } catch (Exception e2) {
                        e = e2;
                        DebugToolsKt.printf(TAG, e, "read file error");
                        r6 = fileInputStream;
                        StringUtilityKt.close(r6);
                        Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                        sMiuiVersionName = getLowerCaseName(properties, declaredMethod, KEY_MIUI_VERSION_NAME);
                        sFlymeVersionName = getLowerCaseName(properties, declaredMethod, KEY_FLYME_VERSION_NAME);
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable = r6;
                    StringUtilityKt.close(closeable);
                    throw th;
                }
            } catch (Exception e3) {
                fileInputStream = null;
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                StringUtilityKt.close(closeable);
                throw th;
            }
            StringUtilityKt.close(r6);
        }
        try {
            Method declaredMethod2 = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            sMiuiVersionName = getLowerCaseName(properties, declaredMethod2, KEY_MIUI_VERSION_NAME);
            sFlymeVersionName = getLowerCaseName(properties, declaredMethod2, KEY_FLYME_VERSION_NAME);
        } catch (Exception e4) {
            DebugToolsKt.printf(TAG, e4, "read SystemProperties error");
        }
    }

    private static boolean _isTablet(Context context) {
        if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
            return true;
        }
        return false;
    }

    @TargetApi(19)
    private static boolean checkOp(Context context, int i) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            Class<?> cls = appOpsManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            if (((Integer) cls.getDeclaredMethod("checkOp", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String getLowerCaseName(Properties properties, Method method, String str) {
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

    public static boolean isEssentialPhone() {
        return BRAND.contains(ESSENTIAL);
    }

    public static boolean isFloatWindowOpAllowed(Context context) {
        return checkOp(context, 24);
    }

    public static boolean isFlyme() {
        if (!TextUtils.isEmpty(sFlymeVersionName) && sFlymeVersionName.contains(FLYME)) {
            return true;
        }
        return false;
    }

    public static boolean isFlymeLowerThan(int i) {
        return isFlymeLowerThan(i, 0, 0);
    }

    public static boolean isHuawei() {
        String str = BRAND;
        if (!str.contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI) && !str.contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR)) {
            return false;
        }
        return true;
    }

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(sMiuiVersionName);
    }

    public static boolean isMIUIV5() {
        return "v5".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV6() {
        return "v6".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV7() {
        return "v7".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV8() {
        return "v8".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV9() {
        return "v9".equals(sMiuiVersionName);
    }

    public static boolean isMeizu() {
        if (!isPhone(MEIZUBOARD) && !isFlyme()) {
            return false;
        }
        return true;
    }

    public static boolean isOppo() {
        return BRAND.contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO);
    }

    private static boolean isPhone(String[] strArr) {
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

    public static boolean isTablet(Context context) {
        if (sIsTabletChecked) {
            return sIsTabletValue;
        }
        boolean _isTablet = _isTablet(context);
        sIsTabletValue = _isTablet;
        sIsTabletChecked = true;
        return _isTablet;
    }

    public static boolean isVivo() {
        String str = BRAND;
        if (!str.contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO) && !str.contains("bbk")) {
            return false;
        }
        return true;
    }

    public static boolean isXiaomi() {
        return Build.MANUFACTURER.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI);
    }

    public static boolean isZTKC2016() {
        String str = Build.MODEL;
        if (str != null && str.toLowerCase().contains(ZTEC2016)) {
            return true;
        }
        return false;
    }

    public static boolean isZUKZ1() {
        String str = Build.MODEL;
        if (str != null && str.toLowerCase().contains(ZUKZ1)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:10|(2:12|(8:14|15|16|(1:21)|22|(2:25|(1:27))|29|(1:34)(1:32)))|37|15|16|(2:19|21)|22|(2:25|(0))|29|(0)|34) */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isFlymeLowerThan(int i, int i2, int i3) {
        boolean z;
        Matcher matcher;
        String str = sFlymeVersionName;
        if (str != null && !str.equals("")) {
            try {
                matcher = Pattern.compile("(\\d+\\.){2}\\d").matcher(sFlymeVersionName);
            } catch (Throwable unused) {
            }
            if (matcher.find()) {
                String group = matcher.group();
                if (group.length() > 0) {
                    String[] split = group.split("\\.");
                    if (split.length >= 1) {
                        if (Integer.parseInt(split[0]) < i) {
                            z = true;
                            if (split.length >= 2 && i2 > 0 && Integer.parseInt(split[1]) < i) {
                                z = true;
                            }
                            if (split.length >= 3 && i3 > 0) {
                                if (Integer.parseInt(split[2]) < i) {
                                    z = true;
                                }
                            }
                            return !isMeizu() && z;
                        }
                    }
                    z = false;
                    if (split.length >= 2) {
                        z = true;
                    }
                    if (split.length >= 3) {
                        if (Integer.parseInt(split[2]) < i) {
                        }
                    }
                    if (isMeizu()) {
                    }
                }
            }
        }
        z = false;
        if (isMeizu()) {
        }
    }
}
