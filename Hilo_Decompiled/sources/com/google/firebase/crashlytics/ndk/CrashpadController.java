package com.google.firebase.crashlytics.ndk;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.r;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.ndk.SessionFiles;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class CrashpadController {
    private static final String APP_METADATA_FILE = "app.json";
    private static final String DEVICE_METADATA_FILE = "device.json";
    private static final String OS_METADATA_FILE = "os.json";
    private static final String SESSION_METADATA_FILE = "session.json";
    private static final String SESSION_START_TIMESTAMP_FILE_NAME = "start-time";
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final Context context;
    private final FileStore fileStore;
    private final NativeApi nativeApi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CrashpadController(Context context, NativeApi nativeApi, FileStore fileStore) {
        this.context = context;
        this.nativeApi = nativeApi;
        this.fileStore = fileStore;
    }

    @RequiresApi(api = 31)
    private static CrashlyticsReport.ApplicationExitInfo convertApplicationExitInfoToModel(ApplicationExitInfo applicationExitInfo) {
        int importance;
        String processName;
        int reason;
        long timestamp;
        int pid;
        long pss;
        long rss;
        CrashlyticsReport.ApplicationExitInfo.Builder builder = CrashlyticsReport.ApplicationExitInfo.builder();
        importance = applicationExitInfo.getImportance();
        CrashlyticsReport.ApplicationExitInfo.Builder importance2 = builder.setImportance(importance);
        processName = applicationExitInfo.getProcessName();
        CrashlyticsReport.ApplicationExitInfo.Builder processName2 = importance2.setProcessName(processName);
        reason = applicationExitInfo.getReason();
        CrashlyticsReport.ApplicationExitInfo.Builder reasonCode = processName2.setReasonCode(reason);
        timestamp = applicationExitInfo.getTimestamp();
        CrashlyticsReport.ApplicationExitInfo.Builder timestamp2 = reasonCode.setTimestamp(timestamp);
        pid = applicationExitInfo.getPid();
        CrashlyticsReport.ApplicationExitInfo.Builder pid2 = timestamp2.setPid(pid);
        pss = applicationExitInfo.getPss();
        CrashlyticsReport.ApplicationExitInfo.Builder pss2 = pid2.setPss(pss);
        rss = applicationExitInfo.getRss();
        return pss2.setRss(rss).setTraceFile(getTraceFileFromApplicationExitInfo(applicationExitInfo)).build();
    }

    @RequiresApi(api = 31)
    @VisibleForTesting
    public static String convertInputStreamToString(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return zipAndEncode(byteArrayOutputStream.toByteArray());
            }
        }
    }

    private CrashlyticsReport.ApplicationExitInfo getApplicationExitInfo(String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return getNativeCrashApplicationExitInfo(str);
        }
        return null;
    }

    private SessionFiles.NativeCore getNativeCore(String str, File file) {
        return new SessionFiles.NativeCore(getSingleFileWithExtension(file, ".dmp"), getApplicationExitInfo(str));
    }

    @RequiresApi(api = 31)
    private CrashlyticsReport.ApplicationExitInfo getNativeCrashApplicationExitInfo(String str) {
        List<ApplicationExitInfo> historicalProcessExitReasons;
        long lastModified;
        historicalProcessExitReasons = ((ActivityManager) this.context.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
        File sessionFile = this.fileStore.getSessionFile(str, SESSION_START_TIMESTAMP_FILE_NAME);
        if (sessionFile == null) {
            lastModified = System.currentTimeMillis();
        } else {
            lastModified = sessionFile.lastModified();
        }
        return getRelevantApplicationExitInfo(lastModified, historicalProcessExitReasons);
    }

    @RequiresApi(api = 31)
    private CrashlyticsReport.ApplicationExitInfo getRelevantApplicationExitInfo(long j10, List<ApplicationExitInfo> list) {
        int reason;
        long timestamp;
        ArrayList arrayList = new ArrayList();
        Iterator<ApplicationExitInfo> it = list.iterator();
        while (it.hasNext()) {
            ApplicationExitInfo a10 = r.a(it.next());
            reason = a10.getReason();
            if (reason == 5) {
                timestamp = a10.getTimestamp();
                if (timestamp >= j10) {
                    arrayList.add(a10);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return convertApplicationExitInfoToModel(r.a(arrayList.get(0)));
    }

    private static File getSingleFileWithExtension(File file, String str) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }
        for (File file2 : listFiles) {
            if (file2.getName().endsWith(str)) {
                return file2;
            }
        }
        return null;
    }

    @RequiresApi(api = 31)
    private static String getTraceFileFromApplicationExitInfo(ApplicationExitInfo applicationExitInfo) {
        InputStream traceInputStream;
        try {
            traceInputStream = applicationExitInfo.getTraceInputStream();
            return convertInputStreamToString(traceInputStream);
        } catch (IOException unused) {
            Logger.getLogger().w("Failed to get input stream from ApplicationExitInfo");
            return null;
        }
    }

    private static void writeSessionJsonFile(FileStore fileStore, String str, String str2, String str3) {
        writeTextFile(new File(fileStore.getNativeSessionDir(str), str3), str2);
    }

    private static void writeTextFile(File file, String str) {
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), UTF_8));
        } catch (IOException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(str);
            CommonUtils.closeOrLog(bufferedWriter, "Failed to close " + file);
        } catch (IOException unused2) {
            bufferedWriter2 = bufferedWriter;
            CommonUtils.closeOrLog(bufferedWriter2, "Failed to close " + file);
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            CommonUtils.closeOrLog(bufferedWriter2, "Failed to close " + file);
            throw th;
        }
    }

    @RequiresApi(api = 31)
    private static String zipAndEncode(byte[] bArr) throws IOException {
        Base64.Encoder encoder;
        String encodeToString;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                encoder = Base64.getEncoder();
                encodeToString = encoder.encodeToString(byteArrayOutputStream.toByteArray());
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
                return encodeToString;
            } finally {
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public SessionFiles getFilesForSession(String str) {
        String str2;
        File nativeSessionDir = this.fileStore.getNativeSessionDir(str);
        File file = new File(nativeSessionDir, "pending");
        Logger.getLogger().v("Minidump directory: " + file.getAbsolutePath());
        File singleFileWithExtension = getSingleFileWithExtension(file, ".dmp");
        Logger logger = Logger.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append("Minidump file ");
        if (singleFileWithExtension != null && singleFileWithExtension.exists()) {
            str2 = "exists";
        } else {
            str2 = "does not exist";
        }
        sb.append(str2);
        logger.v(sb.toString());
        SessionFiles.Builder builder = new SessionFiles.Builder();
        if (nativeSessionDir != null && nativeSessionDir.exists() && file.exists()) {
            builder.nativeCore(getNativeCore(str, file)).metadataFile(getSingleFileWithExtension(nativeSessionDir, ".device_info")).sessionFile(new File(nativeSessionDir, SESSION_METADATA_FILE)).appFile(new File(nativeSessionDir, APP_METADATA_FILE)).deviceFile(new File(nativeSessionDir, DEVICE_METADATA_FILE)).osFile(new File(nativeSessionDir, OS_METADATA_FILE));
        }
        return builder.build();
    }

    public boolean hasCrashDataForSession(String str) {
        SessionFiles.NativeCore nativeCore = getFilesForSession(str).nativeCore;
        if (nativeCore != null && nativeCore.hasCore()) {
            return true;
        }
        return false;
    }

    public boolean initialize(String str, String str2, long j10, StaticSessionData staticSessionData) {
        File nativeSessionDir = this.fileStore.getNativeSessionDir(str);
        if (nativeSessionDir != null) {
            try {
                if (this.nativeApi.initialize(nativeSessionDir.getCanonicalPath(), this.context.getAssets())) {
                    writeBeginSession(str, str2, j10);
                    writeSessionApp(str, staticSessionData.appData());
                    writeSessionOs(str, staticSessionData.osData());
                    writeSessionDevice(str, staticSessionData.deviceData());
                    return true;
                }
                return false;
            } catch (IOException e10) {
                Logger.getLogger().e("Error initializing Crashlytics NDK", e10);
                return false;
            }
        }
        return false;
    }

    public void writeBeginSession(String str, String str2, long j10) {
        writeSessionJsonFile(this.fileStore, str, SessionMetadataJsonSerializer.serializeBeginSession(str, str2, j10), SESSION_METADATA_FILE);
    }

    public void writeSessionApp(String str, StaticSessionData.AppData appData) {
        writeSessionJsonFile(this.fileStore, str, SessionMetadataJsonSerializer.serializeSessionApp(appData.appIdentifier(), appData.versionCode(), appData.versionName(), appData.installUuid(), appData.deliveryMechanism(), appData.developmentPlatformProvider().getDevelopmentPlatform(), appData.developmentPlatformProvider().getDevelopmentPlatformVersion()), APP_METADATA_FILE);
    }

    public void writeSessionDevice(String str, StaticSessionData.DeviceData deviceData) {
        writeSessionJsonFile(this.fileStore, str, SessionMetadataJsonSerializer.serializeSessionDevice(deviceData.arch(), deviceData.model(), deviceData.availableProcessors(), deviceData.totalRam(), deviceData.diskSpace(), deviceData.isEmulator(), deviceData.state(), deviceData.manufacturer(), deviceData.modelClass()), DEVICE_METADATA_FILE);
    }

    public void writeSessionOs(String str, StaticSessionData.OsData osData) {
        writeSessionJsonFile(this.fileStore, str, SessionMetadataJsonSerializer.serializeSessionOs(osData.osRelease(), osData.osCodeName(), osData.isRooted()), OS_METADATA_FILE);
    }
}
