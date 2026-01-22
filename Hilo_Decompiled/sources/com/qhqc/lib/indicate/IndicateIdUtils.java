package com.qhqc.lib.indicate;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0006\u0010\u0007\u001a\u00020\u0005J\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0003J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0003J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0005H\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/qhqc/lib/indicate/IndicateIdUtils;", "", "<init>", "()V", "LOCAL_FILE_NAME", "", "getLocalFilePath", "getAndroidId", "getMediaDrmId", "bytesToHex", "bytes", "", "buildDeviceUUID", "loadSdCardUUId", "fileName", "saveSDCardUUid", "", "uuid", "loadUUId", "makeFilePath", "Ljava/io/File;", "filePath", "makeRootDirectory", "", "getAppSignature", "context", "Landroid/content/Context;", "getSimInfo", "Lorg/json/JSONObject;", "lib_deviceIndicate_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class IndicateIdUtils {

    @NotNull
    public static final IndicateIdUtils INSTANCE = new IndicateIdUtils();

    @NotNull
    private static final String LOCAL_FILE_NAME = "indicate.log";

    private IndicateIdUtils() {
    }

    private final String buildDeviceUUID() {
        String androidId = getAndroidId();
        if (Intrinsics.areEqual("9774d56d682e549c", androidId)) {
            Random random = new Random();
            androidId = Integer.toHexString(random.nextInt()) + Integer.toHexString(random.nextInt()) + Integer.toHexString(random.nextInt());
        }
        String uuid = new UUID(androidId.hashCode(), BuildInfoUtil.INSTANCE.getBuildInfo().hashCode()).toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        return uuid;
    }

    private final String bytesToHex(byte[] bytes) {
        return ArraysKt.joinToString$default(bytes, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.qhqc.lib.indicate.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence bytesToHex$lambda$1;
                bytesToHex$lambda$1 = IndicateIdUtils.bytesToHex$lambda$1(((Byte) obj).byteValue());
                return bytesToHex$lambda$1;
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence bytesToHex$lambda$1(byte b10) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final String getLocalFilePath() {
        if (Build.VERSION.SDK_INT >= 29) {
            String str = null;
            File externalFilesDir = IndicateService.INSTANCE.getMContext().getExternalFilesDir(null);
            if (externalFilesDir != null) {
                str = externalFilesDir.getAbsolutePath();
            }
            return str + File.separator + "com.qhlog.indicate/log/";
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "com.qhlog.indicate/log/";
    }

    private final String loadSdCardUUId(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return "";
        }
        try {
            if (!Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted")) {
                return "";
            }
            File file = new File(getLocalFilePath() + fileName);
            if (file.isDirectory()) {
                LogUtils.e$default(LogUtils.INSTANCE, "Error on read File: " + fileName + " is not exist.", null, 2, null);
                return "";
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
            LogUtils.d$default(LogUtils.INSTANCE, "read the file:content = " + readLine, null, 2, null);
            if (readLine == null) {
                return "";
            }
            return readLine;
        } catch (Exception e10) {
            LogUtils.e$default(LogUtils.INSTANCE, "Error on write File:" + e10, null, 2, null);
            return null;
        }
    }

    static /* synthetic */ String loadSdCardUUId$default(IndicateIdUtils indicateIdUtils, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = LOCAL_FILE_NAME;
        }
        return indicateIdUtils.loadSdCardUUId(str);
    }

    private final File makeFilePath(String filePath, String fileName) {
        File file;
        makeRootDirectory(filePath);
        try {
            file = new File(filePath + fileName);
        } catch (Exception e10) {
            e = e10;
            file = null;
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e11) {
            e = e11;
            LogUtils logUtils = LogUtils.INSTANCE;
            StringBuilder sb = new StringBuilder();
            sb.append(e);
            LogUtils.e$default(logUtils, sb.toString(), null, 2, null);
            return file;
        }
        return file;
    }

    private final void makeRootDirectory(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e10) {
            LogUtils logUtils = LogUtils.INSTANCE;
            StringBuilder sb = new StringBuilder();
            sb.append(e10);
            LogUtils.e$default(logUtils, sb.toString(), null, 2, null);
        }
    }

    private final boolean saveSDCardUUid(String uuid, String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return false;
        }
        try {
            if (!Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted")) {
                return false;
            }
            String localFilePath = getLocalFilePath();
            makeFilePath(localFilePath, fileName);
            String str = localFilePath + fileName;
            File file = new File(str);
            if (!file.exists()) {
                LogUtils.d$default(LogUtils.INSTANCE, "Create the file:" + str, null, 2, null);
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
            bufferedWriter.write(uuid);
            bufferedWriter.flush();
            bufferedWriter.close();
            LogUtils.d$default(LogUtils.INSTANCE, "Save the file:" + str, null, 2, null);
            return true;
        } catch (Exception e10) {
            LogUtils.e$default(LogUtils.INSTANCE, "Error on write File:" + e10, null, 2, null);
            return false;
        }
    }

    static /* synthetic */ boolean saveSDCardUUid$default(IndicateIdUtils indicateIdUtils, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = LOCAL_FILE_NAME;
        }
        return indicateIdUtils.saveSDCardUUid(str, str2);
    }

    @NotNull
    public final String getAndroidId() {
        String string = Settings.Secure.getString(IndicateService.INSTANCE.getMContext().getContentResolver(), "android_id");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Nullable
    public final String getAppSignature(@NotNull Context context) {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        SigningInfo signingInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 28) {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728);
            } else {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            }
            if (i10 >= 28) {
                signingInfo = packageInfo.signingInfo;
                if (signingInfo != null) {
                    signatureArr = signingInfo.getApkContentsSigners();
                } else {
                    signatureArr = null;
                }
            } else {
                signatureArr = packageInfo.signatures;
            }
            if (signatureArr != null && signatureArr.length != 0) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(signatureArr[0].toByteArray());
                return Base64.encodeToString(messageDigest.digest(), 2);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Nullable
    public final String getMediaDrmId() {
        try {
            MediaDrm mediaDrm = new MediaDrm(UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"));
            try {
                byte[] propertyByteArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
                Intrinsics.checkNotNullExpressionValue(propertyByteArray, "getPropertyByteArray(...)");
                String bytesToHex = INSTANCE.bytesToHex(propertyByteArray);
                AutoCloseableKt.closeFinally(mediaDrm, null);
                return bytesToHex;
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    @NotNull
    public final JSONObject getSimInfo(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        JSONObject jSONObject = new JSONObject();
        try {
            Object systemService = context.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            jSONObject.put("state", telephonyManager.getSimState());
            if (telephonyManager.getSimState() == 5) {
                jSONObject.put("countryIso", telephonyManager.getSimCountryIso());
                jSONObject.put("networkCountryIso", telephonyManager.getNetworkCountryIso());
                jSONObject.put("operator", telephonyManager.getSimOperator());
                jSONObject.put("operatorName", telephonyManager.getSimOperatorName());
                jSONObject.put("networkOperator", telephonyManager.getNetworkOperator());
                jSONObject.put("networkOperatorName", telephonyManager.getNetworkOperatorName());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Nullable
    public final String loadUUId() {
        String loadSdCardUUId$default;
        LogUtils logUtils;
        SharedPreferences sharedPreferences;
        String string;
        String str = "";
        try {
            loadSdCardUUId$default = loadSdCardUUId$default(this, null, 1, null);
            logUtils = LogUtils.INSTANCE;
            LogUtils.d$default(logUtils, "sd_card_uuid: " + loadSdCardUUId$default, null, 2, null);
            sharedPreferences = IndicateService.INSTANCE.getMContext().getSharedPreferences("com.qhlog.indicate", 0);
            string = sharedPreferences.getString("indicate_uuid", "");
            LogUtils.d$default(logUtils, "sp_uuid: " + string, null, 2, null);
        } catch (Exception e10) {
            e = e10;
        }
        if (loadSdCardUUId$default != null) {
            if (loadSdCardUUId$default.length() == 0) {
            }
            if ((string != null || string.length() == 0) && loadSdCardUUId$default != null && loadSdCardUUId$default.length() != 0) {
                try {
                    sharedPreferences.edit().putString("indicate_uuid", loadSdCardUUId$default).apply();
                    LogUtils.d$default(logUtils, "save_sp_from_sd_card: " + loadSdCardUUId$default, null, 2, null);
                    return loadSdCardUUId$default;
                } catch (Exception e11) {
                    e = e11;
                    str = loadSdCardUUId$default;
                }
            } else {
                if ((loadSdCardUUId$default == null || loadSdCardUUId$default.length() == 0) && string != null && string.length() != 0) {
                    saveSDCardUUid$default(this, string, null, 2, null);
                    try {
                        LogUtils.d$default(logUtils, "save_sd_card_from_sp: " + string, null, 2, null);
                        return string;
                    } catch (Exception e12) {
                        e = e12;
                        str = string;
                    }
                }
                return loadSdCardUUId$default;
            }
            LogUtils.e$default(LogUtils.INSTANCE, "Error on loadUUId:" + e, null, 2, null);
            return str;
        }
        if (string != null) {
            if (string.length() == 0) {
            }
            if (string != null) {
            }
            sharedPreferences.edit().putString("indicate_uuid", loadSdCardUUId$default).apply();
            LogUtils.d$default(logUtils, "save_sp_from_sd_card: " + loadSdCardUUId$default, null, 2, null);
            return loadSdCardUUId$default;
        }
        str = buildDeviceUUID();
        saveSDCardUUid$default(this, str, null, 2, null);
        sharedPreferences.edit().putString("indicate_uuid", str).apply();
        LogUtils.d$default(logUtils, "build_indicate_uuid: " + str, null, 2, null);
        return str;
    }
}
