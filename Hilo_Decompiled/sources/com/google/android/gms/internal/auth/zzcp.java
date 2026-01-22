package com.google.android.gms.internal.auth;

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
public final class zzcp {
    private static volatile zzdh zza;

    private zzcp() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:6|(5:8|(1:10)|11|12|13)|14|(5:16|(1:18)|11|12|13)|19|(2:21|(1:23))|24|25|26|27|28|29|(1:31)(1:81)|32|(9:34|35|36|37|38|(2:39|(3:41|(3:56|57|58)(7:43|44|(2:46|(1:49))|50|(1:52)|53|54)|55)(1:59))|60|61|62)(1:80)|63|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0070, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0071, code lost:
    
        android.util.Log.e("HermeticFileOverrides", "no data dir", r4);
        r4 = com.google.android.gms.internal.auth.zzdh.zzc();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzdh zza(Context context) {
        zzdh zzdhVar;
        StrictMode.ThreadPolicy allowThreadDiskReads;
        zzdh zzc;
        zzdh zzc2;
        boolean isDeviceProtectedStorage;
        synchronized (zzcp.class) {
            try {
                zzdhVar = zza;
                if (zzdhVar == null) {
                    String str = Build.TYPE;
                    String str2 = Build.TAGS;
                    if (!str.equals("eng")) {
                        if (str.equals("userdebug")) {
                        }
                        zzc2 = zzdh.zzc();
                        zzdhVar = zzc2;
                        zza = zzdhVar;
                    }
                    if (!str2.contains("dev-keys")) {
                        if (str2.contains("test-keys")) {
                        }
                        zzc2 = zzdh.zzc();
                        zzdhVar = zzc2;
                        zza = zzdhVar;
                    }
                    if (zzcc.zzb()) {
                        isDeviceProtectedStorage = context.isDeviceProtectedStorage();
                        if (!isDeviceProtectedStorage) {
                            context = context.createDeviceProtectedStorageContext();
                        }
                    }
                    allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    StrictMode.allowThreadDiskWrites();
                    File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
                    if (file.exists()) {
                        zzc = zzdh.zzd(file);
                    } else {
                        zzc = zzdh.zzc();
                    }
                    if (zzc.zzb()) {
                        Object zza2 = zzc.zza();
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream((File) zza2)));
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
                                        Log.e("HermeticFileOverrides", "Invalid: " + readLine);
                                    } else {
                                        String str3 = new String(split[0]);
                                        String decode = Uri.decode(new String(split[1]));
                                        String str4 = (String) hashMap.get(split[2]);
                                        if (str4 == null) {
                                            String str5 = new String(split[2]);
                                            str4 = Uri.decode(str5);
                                            if (str4.length() < 1024 || str4 == str5) {
                                                hashMap.put(str5, str4);
                                            }
                                        }
                                        if (!simpleArrayMap.containsKey(str3)) {
                                            simpleArrayMap.put(str3, new SimpleArrayMap());
                                        }
                                        ((SimpleArrayMap) simpleArrayMap.get(str3)).put(decode, str4);
                                    }
                                }
                                Log.w("HermeticFileOverrides", "Parsed " + zza2.toString() + " for Android package " + context.getPackageName());
                                zzci zzciVar = new zzci(simpleArrayMap);
                                bufferedReader.close();
                                zzc2 = zzdh.zzd(zzciVar);
                            } finally {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th) {
                                    try {
                                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        } catch (IOException e10) {
                            throw new RuntimeException(e10);
                        }
                    } else {
                        zzc2 = zzdh.zzc();
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    zzdhVar = zzc2;
                    zza = zzdhVar;
                }
            } catch (Throwable th2) {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                throw th2;
            } finally {
            }
        }
        return zzdhVar;
    }
}
