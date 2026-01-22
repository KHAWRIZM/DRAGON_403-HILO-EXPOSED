package com.tencent.imsdk.common;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import java.io.File;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.regex.Pattern;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class SystemUtil {
    private static final String DEVICE_ID = "DeviceID";
    private static final String DEVICE_INFO = "DeviceInfo";
    private static final String TAG = "SystemUtil";
    private static final int TIME_INTERVAL = 15000;
    private static String buildBrand = "";
    private static String buildManufacturer = "";
    private static String buildModel = "";
    private static String buildVersionRelease = "";
    private static int buildVersionSDKInt = 0;
    private static String currentProcessName = "";
    private static float lastAppCpu = 0.0f;
    private static long lastAppCpuTime = 0;
    private static long lastMemCheckTimeStamps = 0;
    private static int lastMemUsage = 0;
    private static float lastSysCpu = 0.0f;
    private static long lastSysCpuTime = 0;
    private static boolean mFirstTimeRun = true;
    private static CpuUsageMeasurer sCpuUsageMeasurer;
    private static boolean sIsLoadAdvancedEncryptionLibrarySuccess;
    private static boolean sIsLoadLibrarySuccess;
    private static boolean sIsLoadQuicLibrarySuccess;
    private static boolean sRunningMemCheck;

    public static float getAppCpuUsage() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastAppCpuTime < 15000) {
            return lastAppCpu;
        }
        float f = (getProcessCPURate()[0] / 10) / 100.0f;
        lastAppCpu = f;
        lastAppCpuTime = currentTimeMillis;
        return f;
    }

    public static float getAppMemory() {
        int i;
        final long currentTimeMillis = System.currentTimeMillis();
        if (!sRunningMemCheck) {
            long j = lastMemCheckTimeStamps;
            if (j == 0 || currentTimeMillis - j >= 15000) {
                sRunningMemCheck = true;
                AsyncTask.execute(new Runnable() { // from class: com.tencent.imsdk.common.SystemUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        System.currentTimeMillis();
                        boolean unused = SystemUtil.sRunningMemCheck = false;
                        try {
                            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                            Debug.getMemoryInfo(memoryInfo);
                            int totalPss = memoryInfo.getTotalPss();
                            long unused2 = SystemUtil.lastMemCheckTimeStamps = currentTimeMillis;
                            int unused3 = SystemUtil.lastMemUsage = totalPss / LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY;
                        } catch (Exception unused4) {
                        }
                    }
                });
                i = lastMemUsage;
                return i;
            }
        }
        i = lastMemUsage;
        return i;
    }

    public static String getAppName() {
        Context applicationContext = IMContext.getInstance().getApplicationContext();
        PackageManager packageManager = applicationContext.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128);
            packageManager.getApplicationLabel(applicationInfo);
            CharSequence loadLabel = applicationInfo.loadLabel(packageManager);
            if (loadLabel == null || loadLabel.length() <= 0) {
                return "";
            }
            return loadLabel.toString();
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "getAppName exception:" + e.getMessage());
            return "";
        }
    }

    private static String getBuildBrand() {
        if (TextUtils.isEmpty(buildBrand)) {
            buildBrand = Build.BRAND;
        }
        return buildBrand;
    }

    private static String getBuildManufacturer() {
        if (TextUtils.isEmpty(buildManufacturer)) {
            buildManufacturer = Build.MANUFACTURER;
        }
        return buildManufacturer;
    }

    public static String getCurrentProcessName() {
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            String a = z3.a.a();
            currentProcessName = a;
            return a;
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            if (invoke instanceof String) {
                currentProcessName = (String) invoke;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return currentProcessName;
    }

    public static String getDeviceID() {
        Context applicationContext = IMContext.getInstance().getApplicationContext();
        if (applicationContext == null) {
            return "";
        }
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(DEVICE_INFO, 0);
        if (!sharedPreferences.contains(DEVICE_ID)) {
            return UUID.randomUUID().toString();
        }
        String string = sharedPreferences.getString(DEVICE_ID, "");
        if (!Pattern.matches("\\w{8}(-\\w{4}){3}-\\w{12}", string) || TextUtils.isEmpty(string)) {
            return UUID.randomUUID().toString();
        }
        return string;
    }

    public static String getDeviceType() {
        if (TextUtils.isEmpty(buildModel)) {
            buildModel = Build.MODEL;
        }
        return buildModel;
    }

    public static int getInstanceType() {
        if (isBrandXiaoMi()) {
            return HonorResultCode.ADVANCED_RECORD_SUCCESS;
        }
        if (isBrandNewHonor()) {
            return TXLiveConstants.PLAY_EVT_PLAY_END;
        }
        if (isBrandHuawei()) {
            return 2001;
        }
        if (isBrandMeizu()) {
            return 2003;
        }
        if (isBrandOppo()) {
            return 2004;
        }
        if (isBrandVivo()) {
            return TXLiveConstants.PLAY_EVT_PLAY_PROGRESS;
        }
        if (isBrandNIO()) {
            return TXLiveConstants.PLAY_EVT_PLAY_LOADING;
        }
        return 2002;
    }

    static int[] getProcessCPURate() {
        if (sCpuUsageMeasurer == null) {
            sCpuUsageMeasurer = new CpuUsageMeasurer();
        }
        if (mFirstTimeRun) {
            mFirstTimeRun = false;
            sCpuUsageMeasurer.getCpuUsage();
            return new int[]{0, 0};
        }
        return sCpuUsageMeasurer.getCpuUsage();
    }

    public static String getSDKInitPath() {
        Context applicationContext = IMContext.getInstance().getApplicationContext();
        if (applicationContext == null) {
            return "";
        }
        String file = applicationContext.getFilesDir().toString();
        String packageName = applicationContext.getPackageName();
        String currentProcessName2 = getCurrentProcessName();
        if (!TextUtils.isEmpty(currentProcessName2) && !packageName.equals(currentProcessName2)) {
            try {
                int lastIndexOf = currentProcessName2.lastIndexOf(":");
                if (lastIndexOf < 0) {
                    lastIndexOf = currentProcessName2.lastIndexOf(".");
                }
                if (lastIndexOf >= 0) {
                    currentProcessName2 = currentProcessName2.substring(lastIndexOf + 1);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(file);
                String str = File.separator;
                sb2.append(str);
                sb2.append(currentProcessName2);
                sb2.append(str);
                file = sb2.toString();
            } catch (Exception e) {
                Log.e(TAG, "getSDKInitPath exception = " + e);
            }
        }
        Log.d(TAG, "SDK Init Path: " + file);
        return file;
    }

    public static String getSDKLogPath() {
        boolean z;
        Context applicationContext = IMContext.getInstance().getApplicationContext();
        if (applicationContext == null) {
            return "";
        }
        File file = new File("/sdcard/Android/data/" + applicationContext.getPackageName() + "/files/log/tencent/imsdk");
        if (!file.exists()) {
            z = file.mkdirs();
        } else {
            z = true;
        }
        if (!z && (file = applicationContext.getExternalFilesDir(null)) != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(file.getAbsolutePath());
            String str = File.separator;
            sb2.append(str);
            sb2.append("log");
            sb2.append(str);
            sb2.append("tencent");
            sb2.append(str);
            sb2.append("imsdk");
            file = new File(sb2.toString());
            if (!file.exists()) {
                z = file.mkdirs();
            } else {
                z = true;
            }
        }
        if (!z) {
            file = applicationContext.getFilesDir();
            Log.w(TAG, "create log folder failed");
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(file.getAbsolutePath());
        String str2 = File.separator;
        sb3.append(str2);
        String sb4 = sb3.toString();
        String packageName = applicationContext.getPackageName();
        String currentProcessName2 = getCurrentProcessName();
        if (!TextUtils.isEmpty(currentProcessName2) && !packageName.equals(currentProcessName2)) {
            try {
                int lastIndexOf = currentProcessName2.lastIndexOf(":");
                if (lastIndexOf < 0) {
                    lastIndexOf = currentProcessName2.lastIndexOf(".");
                }
                if (lastIndexOf >= 0) {
                    currentProcessName2 = currentProcessName2.substring(lastIndexOf + 1);
                }
                sb4 = sb4 + currentProcessName2 + str2;
            } catch (Exception e) {
                Log.e(TAG, "getSDKLogPath exception = " + e);
            }
        }
        Log.d(TAG, "SDK LOG Path: " + sb4);
        return sb4;
    }

    public static int getSDKVersion() {
        if (buildVersionSDKInt == 0) {
            buildVersionSDKInt = Build.VERSION.SDK_INT;
        }
        return buildVersionSDKInt;
    }

    public static float getSysCpuUsage() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastSysCpuTime < 15000) {
            return lastSysCpu;
        }
        float f = (getProcessCPURate()[1] / 10) / 100.0f;
        lastSysCpu = f;
        lastSysCpuTime = currentTimeMillis;
        return f;
    }

    public static String getSystemVersion() {
        if (TextUtils.isEmpty(buildVersionRelease)) {
            buildVersionRelease = Build.VERSION.RELEASE;
        }
        return buildVersionRelease;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isBrandHuawei() {
        if (!AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI.equalsIgnoreCase(getBuildBrand()) && !AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI.equalsIgnoreCase(getBuildManufacturer()) && !AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR.equalsIgnoreCase(getBuildBrand())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isBrandMeizu() {
        if (!AgooConstants.MESSAGE_SYSTEM_SOURCE_MEIZU.equalsIgnoreCase(getBuildBrand()) && !AgooConstants.MESSAGE_SYSTEM_SOURCE_MEIZU.equalsIgnoreCase(getBuildManufacturer())) {
            return false;
        }
        return true;
    }

    static boolean isBrandNIO() {
        if ("nio".equalsIgnoreCase(getBuildBrand()) && "nio".equalsIgnoreCase(getBuildManufacturer())) {
            return true;
        }
        return false;
    }

    static boolean isBrandNewHonor() {
        if (AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR.equalsIgnoreCase(getBuildBrand()) && AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR.equalsIgnoreCase(getBuildManufacturer())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isBrandOppo() {
        if (!AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO.equalsIgnoreCase(getBuildBrand()) && !AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO.equalsIgnoreCase(getBuildManufacturer()) && !"realme".equalsIgnoreCase(getBuildBrand()) && !"realme".equalsIgnoreCase(getBuildManufacturer()) && !"oneplus".equalsIgnoreCase(getBuildBrand()) && !"oneplus".equalsIgnoreCase(getBuildManufacturer())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isBrandVivo() {
        if (!AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO.equalsIgnoreCase(getBuildBrand()) && !AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO.equalsIgnoreCase(getBuildManufacturer()) && !"iQOO".equalsIgnoreCase(getBuildBrand()) && !"iQOO".equalsIgnoreCase(getBuildManufacturer())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isBrandXiaoMi() {
        if (!AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI.equalsIgnoreCase(getBuildBrand()) && !AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI.equalsIgnoreCase(getBuildManufacturer()) && !"Redmi".equalsIgnoreCase(getBuildBrand()) && !"Redmi".equalsIgnoreCase(getBuildManufacturer())) {
            return false;
        }
        return true;
    }

    public static boolean isQuicPluginLibraryLoaded() {
        return sIsLoadQuicLibrarySuccess;
    }

    public static boolean loadIMLibrary() {
        return loadIMLibrary(null);
    }

    private static boolean loadIMSDKLibrary(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String str2 = str + File.separator + "libImSDK.so";
                System.load(str2);
                Log.i(TAG, "system load so library success: " + str2);
                return true;
            }
            System.loadLibrary("ImSDK");
            Log.i(TAG, "system load so library success, libImSDK.so");
            return true;
        } catch (Exception e) {
            Log.e(TAG, "system load so library failed, " + e.getMessage());
            return false;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "system load so library failed, " + e2.getMessage());
            return false;
        }
    }

    private static boolean loadPluginLibrary(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        String str3 = "lib" + str2 + ".so";
        try {
            if (!TextUtils.isEmpty(str)) {
                String str4 = str + File.separator + str3;
                System.load(str4);
                Log.i(TAG, "system load so library success: " + str4);
                return true;
            }
            System.loadLibrary(str2);
            Log.i(TAG, "system load so library success, " + str3);
            return true;
        } catch (Exception | UnsatisfiedLinkError unused) {
            return false;
        }
    }

    public static String md5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = "";
            for (byte b : MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes())) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = MessageService.MSG_DB_READY_REPORT + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void setBuildBrand(String str) {
        buildBrand = str;
    }

    public static void setBuildManufacturer(String str) {
        buildManufacturer = str;
    }

    public static void setBuildModel(String str) {
        buildModel = str;
    }

    public static void setBuildVersionRelease(String str) {
        buildVersionRelease = str;
    }

    public static void setBuildVersionSDKInt(int i) {
        buildVersionSDKInt = i;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static boolean loadIMLibrary(String str) {
        if (!sIsLoadLibrarySuccess) {
            sIsLoadLibrarySuccess = loadIMSDKLibrary(str);
        }
        if (!sIsLoadQuicLibrarySuccess) {
            sIsLoadQuicLibrarySuccess = loadPluginLibrary(str, "TIMQuicPlugin");
        }
        if (!sIsLoadAdvancedEncryptionLibrarySuccess) {
            sIsLoadAdvancedEncryptionLibrarySuccess = loadPluginLibrary(str, "TIMAdvancedEncryptionPlugin");
        }
        return sIsLoadLibrarySuccess;
    }
}
