package com.oudi.utils;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class PermissionPageUtils {
    private static final String TAG = "PermissionPageManager";

    private static void doStartApplicationWithPackageName(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(packageInfo.packageName);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        Log.e(TAG, "resolveinfoList" + queryIntentActivities.size());
        for (int i10 = 0; i10 < queryIntentActivities.size(); i10++) {
            Log.e(TAG, queryIntentActivities.get(i10).activityInfo.packageName + queryIntentActivities.get(i10).activityInfo.name);
        }
        ResolveInfo next = queryIntentActivities.iterator().next();
        if (next != null) {
            ActivityInfo activityInfo = next.activityInfo;
            String str2 = activityInfo.packageName;
            String str3 = activityInfo.name;
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(str2, str3));
            try {
                context.startActivity(intent2);
            } catch (Exception e11) {
                goIntentSetting(context);
                e11.printStackTrace();
            }
        }
    }

    private static Intent getAppDetailSettingIntent(Context context) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    private static String getMiuiVersion() {
        Throwable th;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
                try {
                    String readLine = bufferedReader.readLine();
                    bufferedReader.close();
                    try {
                        bufferedReader.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                    return readLine;
                } catch (IOException e11) {
                    e = e11;
                    e.printStackTrace();
                    try {
                        bufferedReader.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    bufferedReader2.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
                throw th;
            }
        } catch (IOException e14) {
            e = e14;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2.close();
            throw th;
        }
    }

    private static void goCoolpadMainager(Context context) {
        doStartApplicationWithPackageName(context, "com.yulong.android.security:remote");
    }

    private static void goHuaWeiMainager(Context context) {
        try {
            Intent intent = new Intent(context.getPackageName());
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            context.startActivity(intent);
        } catch (Exception e10) {
            Toast.makeText(context, AppUtils.getApp().getString(R.string.utils_jump_failed), 1).show();
            e10.printStackTrace();
            goIntentSetting(context);
        }
    }

    private static void goIntentSetting(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        try {
            context.startActivity(intent);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private static void goLGMainager(Context context) {
        try {
            Intent intent = new Intent(context.getPackageName());
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity"));
            context.startActivity(intent);
        } catch (Exception e10) {
            Toast.makeText(context, AppUtils.getApp().getString(R.string.utils_jump_failed), 1).show();
            e10.printStackTrace();
            goIntentSetting(context);
        }
    }

    private static void goMeizuMainager(Context context) {
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, context.getPackageName());
            context.startActivity(intent);
        } catch (ActivityNotFoundException e10) {
            e10.printStackTrace();
            goIntentSetting(context);
        }
    }

    private static void goOppoMainager(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.oppo.safe");
        if (launchIntentForPackage != null) {
            context.startActivity(launchIntentForPackage);
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        context.startActivity(intent);
    }

    private static void goSangXinMainager(Context context) {
        goIntentSetting(context);
    }

    private static void goSonyMainager(Context context) {
        try {
            Intent intent = new Intent(context.getPackageName());
            intent.setComponent(new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity"));
            context.startActivity(intent);
        } catch (Exception e10) {
            Toast.makeText(context, AppUtils.getApp().getString(R.string.utils_jump_failed), 1).show();
            e10.printStackTrace();
            goIntentSetting(context);
        }
    }

    private static void goVivoMainager(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.iqoo.secure");
        if (launchIntentForPackage != null) {
            context.startActivity(launchIntentForPackage);
        }
    }

    private static void goXiaoMiMainager(Context context) {
        String miuiVersion = getMiuiVersion();
        Log.d(TAG, "goMiaoMiMainager --- rom : " + miuiVersion);
        Intent intent = new Intent();
        if (!"V6".equals(miuiVersion) && !"V7".equals(miuiVersion)) {
            if (!"V8".equals(miuiVersion) && !"V9".equals(miuiVersion)) {
                goIntentSetting(context);
            } else {
                intent.setAction("miui.intent.action.APP_PERM_EDITOR");
                intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                intent.putExtra("extra_pkgname", context.getPackageName());
            }
        } else {
            intent.setAction("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }

    public static void jumpPermissionPage(Context context) {
        String str = Build.MANUFACTURER;
        str.getClass();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1678088054:
                if (str.equals("Coolpad")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1675632421:
                if (str.equals("Xiaomi")) {
                    c10 = 1;
                    break;
                }
                break;
            case 2427:
                if (str.equals("LG")) {
                    c10 = 2;
                    break;
                }
                break;
            case 2432928:
                if (str.equals("OPPO")) {
                    c10 = 3;
                    break;
                }
                break;
            case 2582855:
                if (str.equals("Sony")) {
                    c10 = 4;
                    break;
                }
                break;
            case 3620012:
                if (str.equals("vivo")) {
                    c10 = 5;
                    break;
                }
                break;
            case 74224812:
                if (str.equals("Meizu")) {
                    c10 = 6;
                    break;
                }
                break;
            case 1864941562:
                if (str.equals("samsung")) {
                    c10 = 7;
                    break;
                }
                break;
            case 2141820391:
                if (str.equals("HUAWEI")) {
                    c10 = '\b';
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                goCoolpadMainager(context);
                return;
            case 1:
                goXiaoMiMainager(context);
                return;
            case 2:
                goLGMainager(context);
                return;
            case 3:
                goOppoMainager(context);
                return;
            case 4:
                goSonyMainager(context);
                return;
            case 5:
                goVivoMainager(context);
                return;
            case 6:
                goMeizuMainager(context);
                return;
            case 7:
                goSangXinMainager(context);
                return;
            case '\b':
                goHuaWeiMainager(context);
                return;
            default:
                goIntentSetting(context);
                return;
        }
    }

    public static void startSettingActivity(Context context) {
        jumpPermissionPage(context);
    }

    public String getManufacturer() {
        return Build.MANUFACTURER;
    }
}
