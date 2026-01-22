package com.google.android.gms.dynamite;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import io.agora.rtc.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@KeepForSdk
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class DynamiteModule {

    @KeepForSdk
    public static final int LOCAL = -1;

    @KeepForSdk
    public static final int NONE = 0;

    @KeepForSdk
    public static final int NO_SELECTION = 0;

    @KeepForSdk
    public static final int REMOTE = 1;
    private static Boolean zzb = null;
    private static String zzc = null;
    private static boolean zzd = false;
    private static int zze = -1;
    private static Boolean zzf;
    private static zzp zzk;
    private static zzq zzl;
    private final Context zzj;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();

    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = new zzf();

    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL = new zzg();

    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();

    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();

    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();

    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    public static final VersionPolicy zza = new zzl();

    @DynamiteApi
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    @KeepForSdk
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzo zzoVar) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzo zzoVar) {
            super(str, th);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface VersionPolicy {

        @KeepForSdk
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z10) throws LoadingException;
        }

        @KeepForSdk
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static class SelectionResult {

            @KeepForSdk
            public int localVersion = 0;

            @KeepForSdk
            public int remoteVersion = 0;

            @KeepForSdk
            public int selection = 0;
        }

        @KeepForSdk
        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    @KeepForSdk
    public static int getLocalVersion(Context context, String str) {
        try {
            Class<?> loadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!Objects.equal(declaredField.get(null), str)) {
                Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
                return 0;
            }
            return declaredField2.getInt(null);
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e10) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e10.getMessage())));
            return 0;
        }
    }

    @KeepForSdk
    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    /* JADX WARN: Not initialized variable reg: 17, insn: 0x0226: MOVE (r6 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]) (LINE:551), block:B:168:0x0226 */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x027b  */
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        zzm zzmVar;
        zzm zzmVar2;
        int i10;
        DynamiteModule zzc2;
        IObjectWrapper zzh2;
        DynamiteModule dynamiteModule;
        zzq zzqVar;
        boolean z10;
        IObjectWrapper zze2;
        Cursor cursor;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            ThreadLocal threadLocal = zzg;
            zzm zzmVar3 = (zzm) threadLocal.get();
            zzm zzmVar4 = new zzm(null);
            threadLocal.set(zzmVar4);
            ThreadLocal threadLocal2 = zzh;
            Long l10 = (Long) threadLocal2.get();
            long longValue = l10.longValue();
            try {
                threadLocal2.set(Long.valueOf(SystemClock.uptimeMillis()));
                VersionPolicy.SelectionResult selectModule = versionPolicy.selectModule(context, str, zzi);
                Log.i("DynamiteModule", "Considering local module " + str + CertificateUtil.DELIMITER + selectModule.localVersion + " and remote module " + str + CertificateUtil.DELIMITER + selectModule.remoteVersion);
                int i11 = selectModule.selection;
                if (i11 != 0) {
                    if (i11 == -1) {
                        if (selectModule.localVersion != 0) {
                            i11 = -1;
                        }
                    }
                    if (i11 != 1 || selectModule.remoteVersion != 0) {
                        if (i11 == -1) {
                            zzc2 = zzc(applicationContext, str);
                            zzmVar2 = zzmVar3;
                        } else {
                            try {
                                if (i11 == 1) {
                                    try {
                                        try {
                                            int i12 = selectModule.remoteVersion;
                                            try {
                                                try {
                                                    try {
                                                        synchronized (DynamiteModule.class) {
                                                            try {
                                                                if (zzf(context)) {
                                                                    Boolean bool = zzb;
                                                                    if (bool != null) {
                                                                        if (bool.booleanValue()) {
                                                                            Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i12);
                                                                            synchronized (DynamiteModule.class) {
                                                                                try {
                                                                                    zzqVar = zzl;
                                                                                } catch (Throwable th) {
                                                                                    th = th;
                                                                                    while (true) {
                                                                                        try {
                                                                                            break;
                                                                                        } catch (Throwable th2) {
                                                                                            th = th2;
                                                                                        }
                                                                                    }
                                                                                    throw th;
                                                                                }
                                                                            }
                                                                            if (zzqVar != null) {
                                                                                zzm zzmVar5 = (zzm) threadLocal.get();
                                                                                if (zzmVar5 != null && zzmVar5.zza != null) {
                                                                                    Context applicationContext2 = context.getApplicationContext();
                                                                                    Cursor cursor2 = zzmVar5.zza;
                                                                                    ObjectWrapper.wrap(null);
                                                                                    synchronized (DynamiteModule.class) {
                                                                                        zzmVar2 = zzmVar3;
                                                                                        if (zze >= 2) {
                                                                                            z10 = true;
                                                                                        } else {
                                                                                            z10 = false;
                                                                                        }
                                                                                    }
                                                                                    if (z10) {
                                                                                        Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                                                        zze2 = zzqVar.zzf(ObjectWrapper.wrap(applicationContext2), str, i12, ObjectWrapper.wrap(cursor2));
                                                                                    } else {
                                                                                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                                                        zze2 = zzqVar.zze(ObjectWrapper.wrap(applicationContext2), str, i12, ObjectWrapper.wrap(cursor2));
                                                                                    }
                                                                                    Context context2 = (Context) ObjectWrapper.unwrap(zze2);
                                                                                    if (context2 != null) {
                                                                                        dynamiteModule = new DynamiteModule(context2);
                                                                                    } else {
                                                                                        throw new LoadingException("Failed to get module context", null);
                                                                                    }
                                                                                } else {
                                                                                    throw new LoadingException("No result cursor", null);
                                                                                }
                                                                            } else {
                                                                                throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                                                            }
                                                                        } else {
                                                                            zzmVar2 = zzmVar3;
                                                                            Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i12);
                                                                            zzp zzg2 = zzg(context);
                                                                            if (zzg2 != null) {
                                                                                int zze3 = zzg2.zze();
                                                                                if (zze3 >= 3) {
                                                                                    zzm zzmVar6 = (zzm) threadLocal.get();
                                                                                    if (zzmVar6 != null) {
                                                                                        zzh2 = zzg2.zzi(ObjectWrapper.wrap(context), str, i12, ObjectWrapper.wrap(zzmVar6.zza));
                                                                                    } else {
                                                                                        throw new LoadingException("No cached result cursor holder", null);
                                                                                    }
                                                                                } else if (zze3 == 2) {
                                                                                    Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                                                    zzh2 = zzg2.zzj(ObjectWrapper.wrap(context), str, i12);
                                                                                } else {
                                                                                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                                                    zzh2 = zzg2.zzh(ObjectWrapper.wrap(context), str, i12);
                                                                                }
                                                                                Object unwrap = ObjectWrapper.unwrap(zzh2);
                                                                                if (unwrap != null) {
                                                                                    dynamiteModule = new DynamiteModule((Context) unwrap);
                                                                                } else {
                                                                                    throw new LoadingException("Failed to load remote module.", null);
                                                                                }
                                                                            } else {
                                                                                throw new LoadingException("Failed to create IDynamiteLoader.", null);
                                                                            }
                                                                        }
                                                                        zzc2 = dynamiteModule;
                                                                    } else {
                                                                        throw new LoadingException("Failed to determine which loading route to use.", null);
                                                                    }
                                                                } else {
                                                                    throw new LoadingException("Remote loading disabled", null);
                                                                }
                                                            } catch (Throwable th3) {
                                                                th = th3;
                                                                throw th;
                                                            }
                                                        }
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                    }
                                                } catch (RemoteException e10) {
                                                    e = e10;
                                                    throw new LoadingException("Failed to load remote module.", e, null);
                                                } catch (LoadingException e11) {
                                                    throw e11;
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    CrashUtils.addDynamiteErrorToDropBox(context, th);
                                                    throw new LoadingException("Failed to load remote module.", th, null);
                                                }
                                            } catch (RemoteException e12) {
                                                e = e12;
                                                throw new LoadingException("Failed to load remote module.", e, null);
                                            } catch (LoadingException e13) {
                                                throw e13;
                                            } catch (Throwable th6) {
                                                th = th6;
                                                CrashUtils.addDynamiteErrorToDropBox(context, th);
                                                throw new LoadingException("Failed to load remote module.", th, null);
                                            }
                                        } catch (LoadingException e14) {
                                            e = e14;
                                            Log.w("DynamiteModule", "Failed to load remote module: " + e.getMessage());
                                            i10 = selectModule.localVersion;
                                            if (i10 == 0 && versionPolicy.selectModule(context, str, new zzn(i10, 0)).selection == -1) {
                                                zzc2 = zzc(applicationContext, str);
                                                if (longValue != 0) {
                                                }
                                                cursor = zzmVar4.zza;
                                                if (cursor != null) {
                                                }
                                                zzg.set(zzmVar2);
                                                return zzc2;
                                            }
                                            throw new LoadingException("Remote load failed. No local fallback found.", e, null);
                                        }
                                    } catch (LoadingException e15) {
                                        e = e15;
                                        zzmVar2 = zzmVar3;
                                        Log.w("DynamiteModule", "Failed to load remote module: " + e.getMessage());
                                        i10 = selectModule.localVersion;
                                        if (i10 == 0) {
                                        }
                                        throw new LoadingException("Remote load failed. No local fallback found.", e, null);
                                    } catch (Throwable th7) {
                                        th = th7;
                                        if (longValue == 0) {
                                            zzh.remove();
                                        } else {
                                            zzh.set(l10);
                                        }
                                        Cursor cursor3 = zzmVar4.zza;
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                        zzg.set(zzmVar3);
                                        throw th;
                                    }
                                } else {
                                    throw new LoadingException("VersionPolicy returned invalid code:" + i11, null);
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                zzmVar3 = zzmVar;
                            }
                        }
                        if (longValue != 0) {
                            zzh.remove();
                        } else {
                            zzh.set(l10);
                        }
                        cursor = zzmVar4.zza;
                        if (cursor != null) {
                            cursor.close();
                        }
                        zzg.set(zzmVar2);
                        return zzc2;
                    }
                }
                throw new LoadingException("No acceptable module " + str + " found. Local version is " + selectModule.localVersion + " and remote version is " + selectModule.remoteVersion + InstructionFileId.DOT, null);
            } catch (Throwable th9) {
                th = th9;
            }
        } else {
            throw new LoadingException("null application Context", null);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x01bf -> B:24:0x01c4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x01c1 -> B:24:0x01c4). Please report as a decompilation issue!!! */
    public static int zza(Context context, String str, boolean z10) {
        Field declaredField;
        Throwable th;
        RemoteException e10;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = zzb;
                Cursor cursor2 = null;
                int i10 = 0;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e11) {
                        Log.w("DynamiteModule", "Failed to load module via V2: " + e11.toString());
                        bool = Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader == ClassLoader.getSystemClassLoader()) {
                            bool = Boolean.FALSE;
                        } else if (classLoader != null) {
                            try {
                                zzd(classLoader);
                            } catch (LoadingException unused) {
                            }
                            bool = Boolean.TRUE;
                        } else {
                            if (!zzf(context)) {
                                return 0;
                            }
                            if (!zzd) {
                                Boolean bool2 = Boolean.TRUE;
                                if (!bool2.equals(null)) {
                                    try {
                                        int zzb2 = zzb(context, str, z10, true);
                                        String str2 = zzc;
                                        if (str2 != null && !str2.isEmpty()) {
                                            ClassLoader zza2 = zzb.zza();
                                            if (zza2 == null) {
                                                if (Build.VERSION.SDK_INT >= 29) {
                                                    b.a();
                                                    String str3 = zzc;
                                                    Preconditions.checkNotNull(str3);
                                                    zza2 = a.a(str3, ClassLoader.getSystemClassLoader());
                                                } else {
                                                    String str4 = zzc;
                                                    Preconditions.checkNotNull(str4);
                                                    zza2 = new zzc(str4, ClassLoader.getSystemClassLoader());
                                                }
                                            }
                                            zzd(zza2);
                                            declaredField.set(null, zza2);
                                            zzb = bool2;
                                            return zzb2;
                                        }
                                        return zzb2;
                                    } catch (LoadingException unused2) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    }
                                }
                            }
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        }
                        zzb = bool;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return zzb(context, str, z10, false);
                    } catch (LoadingException e12) {
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e12.getMessage());
                        return 0;
                    }
                }
                zzp zzg2 = zzg(context);
                try {
                    if (zzg2 != null) {
                        try {
                            int zze2 = zzg2.zze();
                            if (zze2 >= 3) {
                                zzm zzmVar = (zzm) zzg.get();
                                if (zzmVar != null && (cursor = zzmVar.zza) != null) {
                                    i10 = cursor.getInt(0);
                                } else {
                                    Cursor cursor3 = (Cursor) ObjectWrapper.unwrap(zzg2.zzk(ObjectWrapper.wrap(context), str, z10, ((Long) zzh.get()).longValue()));
                                    if (cursor3 != null) {
                                        try {
                                            if (cursor3.moveToFirst()) {
                                                int i11 = cursor3.getInt(0);
                                                if (i11 <= 0 || !zze(cursor3)) {
                                                    cursor2 = cursor3;
                                                }
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                i10 = i11;
                                            }
                                        } catch (RemoteException e13) {
                                            e10 = e13;
                                            cursor2 = cursor3;
                                            Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e10.getMessage());
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            return i10;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            cursor2 = cursor3;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                }
                            } else if (zze2 == 2) {
                                Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                i10 = zzg2.zzg(ObjectWrapper.wrap(context), str, z10);
                            } else {
                                Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                i10 = zzg2.zzf(ObjectWrapper.wrap(context), str, z10);
                            }
                        } catch (RemoteException e14) {
                            e10 = e14;
                        }
                    }
                    return i10;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable th4) {
            CrashUtils.addDynamiteErrorToDropBox(context, th4);
            throw th4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0141, code lost:
    
        r4.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x013d: MOVE (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:318), block:B:110:0x013d */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int zzb(Context context, String str, boolean z10, boolean z11) throws LoadingException {
        Cursor cursor;
        Cursor query;
        MatrixCursor matrixCursor;
        Cursor cursor2 = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        try {
            try {
                long longValue = ((Long) zzh.get()).longValue();
                String str2 = "api_force_staging";
                boolean z12 = true;
                if (true != z10) {
                    str2 = "api";
                }
                Uri build = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(str2).appendPath(str).appendQueryParameter("requestStartUptime", String.valueOf(longValue)).build();
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(build);
                boolean z13 = false;
                if (acquireUnstableContentProviderClient != null) {
                    try {
                        query = acquireUnstableContentProviderClient.query(build, null, null, null, null);
                    } catch (RemoteException unused) {
                    } catch (Throwable th) {
                        acquireUnstableContentProviderClient.release();
                        throw th;
                    }
                    if (query != null) {
                        try {
                            int count = query.getCount();
                            int columnCount = query.getColumnCount();
                            matrixCursor = new MatrixCursor(query.getColumnNames(), count);
                            for (int i10 = 0; i10 < count; i10++) {
                                if (query.moveToPosition(i10)) {
                                    Object[] objArr4 = new Object[columnCount];
                                    for (int i11 = 0; i11 < columnCount; i11++) {
                                        int type = query.getType(i11);
                                        if (type != 0) {
                                            if (type != 1) {
                                                if (type != 2) {
                                                    if (type != 3) {
                                                        if (type == 4) {
                                                            objArr4[i11] = query.getBlob(i11);
                                                        } else {
                                                            throw new RemoteException("Unknown column type");
                                                        }
                                                    } else {
                                                        objArr4[i11] = query.getString(i11);
                                                    }
                                                } else {
                                                    objArr4[i11] = Double.valueOf(query.getDouble(i11));
                                                }
                                            } else {
                                                objArr4[i11] = Long.valueOf(query.getLong(i11));
                                            }
                                        } else {
                                            objArr4[i11] = null;
                                        }
                                    }
                                    matrixCursor.addRow(objArr4);
                                } else {
                                    throw new RemoteException("Cursor read incomplete (ContentProvider dead?)");
                                }
                            }
                            query.close();
                            acquireUnstableContentProviderClient.release();
                            if (matrixCursor != null) {
                                try {
                                    if (matrixCursor.moveToFirst()) {
                                        int i12 = matrixCursor.getInt(0);
                                        if (i12 > 0) {
                                            synchronized (DynamiteModule.class) {
                                                try {
                                                    zzc = matrixCursor.getString(2);
                                                    int columnIndex = matrixCursor.getColumnIndex("loaderVersion");
                                                    if (columnIndex >= 0) {
                                                        zze = matrixCursor.getInt(columnIndex);
                                                    }
                                                    int columnIndex2 = matrixCursor.getColumnIndex("disableStandaloneDynamiteLoader2");
                                                    if (columnIndex2 >= 0) {
                                                        if (matrixCursor.getInt(columnIndex2) == 0) {
                                                            z12 = false;
                                                        }
                                                        zzd = z12;
                                                        z13 = z12;
                                                    }
                                                } finally {
                                                }
                                            }
                                            if (zze(matrixCursor)) {
                                                matrixCursor = null;
                                            }
                                        }
                                        if (z11 && z13) {
                                            throw new LoadingException("forcing fallback to container DynamiteLoader impl", objArr2 == true ? 1 : 0);
                                        }
                                        return i12;
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                    if (e instanceof LoadingException) {
                                        throw e;
                                    }
                                    throw new LoadingException("V2 version check failed: " + e.getMessage(), e, objArr == true ? 1 : 0);
                                }
                            }
                            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                            throw new LoadingException("Failed to connect to dynamite module ContentResolver.", objArr3 == true ? 1 : 0);
                        } finally {
                            try {
                                query.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                    }
                    acquireUnstableContentProviderClient.release();
                }
                matrixCursor = null;
                if (matrixCursor != null) {
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new LoadingException("Failed to connect to dynamite module ContentResolver.", objArr3 == true ? 1 : 0);
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    private static DynamiteModule zzc(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzq zzqVar;
        zzo zzoVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder == null) {
                zzqVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzq) {
                    zzqVar = (zzq) queryLocalInterface;
                } else {
                    zzqVar = new zzq(iBinder);
                }
            }
            zzl = zzqVar;
        } catch (ClassNotFoundException e10) {
            e = e10;
            throw new LoadingException("Failed to instantiate dynamite loader", e, zzoVar);
        } catch (IllegalAccessException e11) {
            e = e11;
            throw new LoadingException("Failed to instantiate dynamite loader", e, zzoVar);
        } catch (InstantiationException e12) {
            e = e12;
            throw new LoadingException("Failed to instantiate dynamite loader", e, zzoVar);
        } catch (NoSuchMethodException e13) {
            e = e13;
            throw new LoadingException("Failed to instantiate dynamite loader", e, zzoVar);
        } catch (InvocationTargetException e14) {
            e = e14;
            throw new LoadingException("Failed to instantiate dynamite loader", e, zzoVar);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzm zzmVar = (zzm) zzg.get();
        if (zzmVar != null && zzmVar.zza == null) {
            zzmVar.zza = cursor;
            return true;
        }
        return false;
    }

    private static boolean zzf(Context context) {
        int i10;
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(zzf)) {
            return true;
        }
        boolean z10 = false;
        if (zzf == null) {
            PackageManager packageManager = context.getPackageManager();
            if (true != PlatformVersion.isAtLeastQ()) {
                i10 = 0;
            } else {
                i10 = 268435456;
            }
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider("com.google.android.gms.chimera", i10);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z10 = true;
            }
            zzf = Boolean.valueOf(z10);
            if (z10 && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & Constants.ERR_WATERMARK_READ) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!z10) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z10;
    }

    private static zzp zzg(Context context) {
        zzp zzpVar;
        synchronized (DynamiteModule.class) {
            zzp zzpVar2 = zzk;
            if (zzpVar2 != null) {
                return zzpVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzpVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzp) {
                        zzpVar = (zzp) queryLocalInterface;
                    } else {
                        zzpVar = new zzp(iBinder);
                    }
                }
                if (zzpVar != null) {
                    zzk = zzpVar;
                    return zzpVar;
                }
            } catch (Exception e10) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e10.getMessage());
            }
            return null;
        }
    }

    @KeepForSdk
    public Context getModuleContext() {
        return this.zzj;
    }

    @KeepForSdk
    public IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e10) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e10, null);
        }
    }
}
