package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzjy {
    private static volatile k8.g zza;

    private zzjy() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:8|(4:10|(1:12)|13|14)|15|(4:17|(1:19)|13|14)|20|(2:22|(13:24|25|26|27|28|29|30|31|(1:33)(1:82)|34|(9:36|37|38|39|40|(2:41|(3:43|(3:58|59|60)(7:45|46|(2:48|(1:51))|52|(1:54)|55|56)|57)(1:61))|62|63|64)(1:81)|65|14))|90|25|26|27|28|29|30|31|(0)(0)|34|(0)(0)|65|14) */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0078, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0079, code lost:
    
        android.util.Log.e("HermeticFileOverrides", "no data dir", r0);
        r0 = k8.g.a();
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b A[Catch: all -> 0x0070, Merged into TryCatch #3 {all -> 0x0022, all -> 0x0070, blocks: (B:6:0x0007, B:8:0x000b, B:10:0x0019, B:13:0x0036, B:14:0x0180, B:15:0x0025, B:17:0x002d, B:20:0x003c, B:22:0x0042, B:24:0x0048, B:25:0x0050, B:65:0x017d, B:88:0x0183, B:89:0x0186, B:91:0x0187, B:27:0x0054, B:30:0x0058, B:31:0x0065, B:33:0x006b, B:34:0x0084, B:36:0x008a, B:38:0x0096, B:63:0x015f, B:64:0x0162, B:77:0x0172, B:76:0x016f, B:79:0x0173, B:80:0x0178, B:81:0x0179, B:82:0x0073, B:85:0x0079), top: B:5:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008a A[Catch: all -> 0x0070, Merged into TryCatch #3 {all -> 0x0022, all -> 0x0070, blocks: (B:6:0x0007, B:8:0x000b, B:10:0x0019, B:13:0x0036, B:14:0x0180, B:15:0x0025, B:17:0x002d, B:20:0x003c, B:22:0x0042, B:24:0x0048, B:25:0x0050, B:65:0x017d, B:88:0x0183, B:89:0x0186, B:91:0x0187, B:27:0x0054, B:30:0x0058, B:31:0x0065, B:33:0x006b, B:34:0x0084, B:36:0x008a, B:38:0x0096, B:63:0x015f, B:64:0x0162, B:77:0x0172, B:76:0x016f, B:79:0x0173, B:80:0x0178, B:81:0x0179, B:82:0x0073, B:85:0x0079), top: B:5:0x0007 }, TRY_LEAVE] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0179 A[Catch: all -> 0x0070, Merged into TryCatch #3 {all -> 0x0022, all -> 0x0070, blocks: (B:6:0x0007, B:8:0x000b, B:10:0x0019, B:13:0x0036, B:14:0x0180, B:15:0x0025, B:17:0x002d, B:20:0x003c, B:22:0x0042, B:24:0x0048, B:25:0x0050, B:65:0x017d, B:88:0x0183, B:89:0x0186, B:91:0x0187, B:27:0x0054, B:30:0x0058, B:31:0x0065, B:33:0x006b, B:34:0x0084, B:36:0x008a, B:38:0x0096, B:63:0x015f, B:64:0x0162, B:77:0x0172, B:76:0x016f, B:79:0x0173, B:80:0x0178, B:81:0x0179, B:82:0x0073, B:85:0x0079), top: B:5:0x0007 }, TRY_LEAVE] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0073 A[Catch: all -> 0x0070, Merged into TryCatch #3 {all -> 0x0022, all -> 0x0070, blocks: (B:6:0x0007, B:8:0x000b, B:10:0x0019, B:13:0x0036, B:14:0x0180, B:15:0x0025, B:17:0x002d, B:20:0x003c, B:22:0x0042, B:24:0x0048, B:25:0x0050, B:65:0x017d, B:88:0x0183, B:89:0x0186, B:91:0x0187, B:27:0x0054, B:30:0x0058, B:31:0x0065, B:33:0x006b, B:34:0x0084, B:36:0x008a, B:38:0x0096, B:63:0x015f, B:64:0x0162, B:77:0x0172, B:76:0x016f, B:79:0x0173, B:80:0x0178, B:81:0x0179, B:82:0x0073, B:85:0x0079), top: B:5:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static k8.g zza(Context context) {
        Context context2;
        StrictMode.ThreadPolicy allowThreadDiskReads;
        k8.g a10;
        File file;
        boolean isDeviceProtectedStorage;
        Context createDeviceProtectedStorageContext;
        k8.g gVar = zza;
        if (gVar == null) {
            synchronized (zzjy.class) {
                try {
                    gVar = zza;
                    if (gVar == null) {
                        String str = Build.TYPE;
                        String str2 = Build.TAGS;
                        int i10 = zzka.zza;
                        if (!str.equals("eng")) {
                            if (str.equals("userdebug")) {
                            }
                            gVar = k8.g.a();
                            zza = gVar;
                        }
                        if (!str2.contains("dev-keys")) {
                            if (str2.contains("test-keys")) {
                            }
                            gVar = k8.g.a();
                            zza = gVar;
                        }
                        if (zzjm.zza()) {
                            isDeviceProtectedStorage = context.isDeviceProtectedStorage();
                            if (!isDeviceProtectedStorage) {
                                createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                                context2 = createDeviceProtectedStorageContext;
                                allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                                StrictMode.allowThreadDiskWrites();
                                char c10 = 0;
                                file = new File(context2.getDir("phenotype_hermetic", 0), "overrides.txt");
                                if (!file.exists()) {
                                    a10 = k8.g.d(file);
                                } else {
                                    a10 = k8.g.a();
                                }
                                if (!a10.c()) {
                                    File file2 = (File) a10.b();
                                    try {
                                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                                        try {
                                            SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                                            HashMap hashMap = new HashMap();
                                            while (true) {
                                                String readLine = bufferedReader.readLine();
                                                if (readLine == null) {
                                                    break;
                                                }
                                                String[] split = readLine.split(" ", 3);
                                                if (split.length != 3) {
                                                    StringBuilder sb = new StringBuilder(readLine.length() + 9);
                                                    sb.append("Invalid: ");
                                                    sb.append(readLine);
                                                    Log.e("HermeticFileOverrides", sb.toString());
                                                } else {
                                                    String str3 = new String(split[c10]);
                                                    String decode = Uri.decode(new String(split[1]));
                                                    String str4 = (String) hashMap.get(split[2]);
                                                    if (str4 == null) {
                                                        String str5 = new String(split[2]);
                                                        str4 = Uri.decode(str5);
                                                        if (str4.length() < 1024 || str4 == str5) {
                                                            hashMap.put(str5, str4);
                                                        }
                                                    }
                                                    SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(str3);
                                                    if (simpleArrayMap2 == null) {
                                                        simpleArrayMap2 = new SimpleArrayMap();
                                                        simpleArrayMap.put(str3, simpleArrayMap2);
                                                    }
                                                    simpleArrayMap2.put(decode, str4);
                                                    c10 = 0;
                                                }
                                            }
                                            String obj = file2.toString();
                                            String packageName = context2.getPackageName();
                                            StringBuilder sb2 = new StringBuilder(obj.length() + 28 + String.valueOf(packageName).length());
                                            sb2.append("Parsed ");
                                            sb2.append(obj);
                                            sb2.append(" for Android package ");
                                            sb2.append(packageName);
                                            Log.w("HermeticFileOverrides", sb2.toString());
                                            zzjs zzjsVar = new zzjs(simpleArrayMap);
                                            bufferedReader.close();
                                            gVar = k8.g.d(zzjsVar);
                                        } catch (Throwable th) {
                                            try {
                                                bufferedReader.close();
                                                throw th;
                                            } catch (Throwable th2) {
                                                th.addSuppressed(th2);
                                                throw th;
                                            }
                                        }
                                    } catch (IOException e10) {
                                        throw new RuntimeException(e10);
                                    }
                                } else {
                                    gVar = k8.g.a();
                                }
                                StrictMode.setThreadPolicy(allowThreadDiskReads);
                                zza = gVar;
                            }
                        }
                        context2 = context;
                        allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        StrictMode.allowThreadDiskWrites();
                        char c102 = 0;
                        file = new File(context2.getDir("phenotype_hermetic", 0), "overrides.txt");
                        if (!file.exists()) {
                        }
                        if (!a10.c()) {
                        }
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        zza = gVar;
                    }
                } catch (Throwable th3) {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    throw th3;
                } finally {
                }
            }
        }
        return gVar;
    }
}
