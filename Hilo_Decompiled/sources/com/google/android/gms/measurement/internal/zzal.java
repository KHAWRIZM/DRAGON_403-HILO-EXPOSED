package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzal extends zzjd {
    private Boolean zza;
    private String zzb;
    private zzak zzc;
    private Boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzal(zzib zzibVar) {
        super(zzibVar);
        this.zzc = zzaj.zza;
    }

    public static final long zzF() {
        return ((Long) zzfx.zzd.zzb(null)).longValue();
    }

    public static final int zzG() {
        return Math.max(0, ((Integer) zzfx.zzi.zzb(null)).intValue());
    }

    public static final long zzH() {
        return ((Integer) zzfx.zzk.zzb(null)).intValue();
    }

    public static final long zzI() {
        return ((Long) zzfx.zzR.zzb(null)).longValue();
    }

    public static final long zzJ() {
        return ((Long) zzfx.zzM.zzb(null)).longValue();
    }

    private final String zzK(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e10) {
            this.zzu.zzaV().zzb().zzb("Could not find SystemProperties class", e10);
            return "";
        } catch (IllegalAccessException e11) {
            this.zzu.zzaV().zzb().zzb("Could not access SystemProperties.get()", e11);
            return "";
        } catch (NoSuchMethodException e12) {
            this.zzu.zzaV().zzb().zzb("Could not find SystemProperties.get() method", e12);
            return "";
        } catch (InvocationTargetException e13) {
            this.zzu.zzaV().zzb().zzb("SystemProperties.get() threw an exception", e13);
            return "";
        }
    }

    public final String zzA() {
        return zzK("debug.firebase.analytics.app", "");
    }

    public final String zzB() {
        return zzK("debug.deferred.deeplink", "");
    }

    public final boolean zzC(String str) {
        return "1".equals(this.zzc.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzD(String str) {
        return "1".equals(this.zzc.zza(str, "measurement.event_sampling_enabled"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzE() {
        if (this.zza == null) {
            Boolean zzr = zzr("app_measurement_lite");
            this.zza = zzr;
            if (zzr == null) {
                this.zza = Boolean.FALSE;
            }
        }
        if (!this.zza.booleanValue() && this.zzu.zzp()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzak zzakVar) {
        this.zzc = zzakVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzb() {
        this.zzu.zzaU();
        return "FA";
    }

    public final int zzc() {
        if (this.zzu.zzk().zzag(201500000, true)) {
            return 100;
        }
        return 25;
    }

    public final int zzd(@Size(min = 1) String str) {
        return zzn(str, zzfx.zzX, 25, 100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zze(String str, boolean z10) {
        if (!z10) {
            return 500;
        }
        return zzn(str, zzfx.zzah, 100, 500);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzf(String str, boolean z10) {
        return Math.max(zze(str, z10), 256);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzh(@Size(min = 1) String str) {
        return zzn(str, zzfx.zzW, 500, 2000);
    }

    public final long zzi() {
        this.zzu.zzaU();
        return 130000L;
    }

    public final boolean zzj() {
        if (this.zzd == null) {
            synchronized (this) {
                try {
                    if (this.zzd == null) {
                        zzib zzibVar = this.zzu;
                        ApplicationInfo applicationInfo = zzibVar.zzaY().getApplicationInfo();
                        String myProcessName = ProcessUtils.getMyProcessName();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            boolean z10 = false;
                            if (str != null && str.equals(myProcessName)) {
                                z10 = true;
                            }
                            this.zzd = Boolean.valueOf(z10);
                        }
                        if (this.zzd == null) {
                            this.zzd = Boolean.TRUE;
                            zzibVar.zzaV().zzb().zza("My process not in the list of running processes");
                        }
                    }
                } finally {
                }
            }
        }
        return this.zzd.booleanValue();
    }

    public final String zzk(String str, zzfw zzfwVar) {
        if (TextUtils.isEmpty(str)) {
            return (String) zzfwVar.zzb(null);
        }
        return (String) zzfwVar.zzb(this.zzc.zza(str, zzfwVar.zza()));
    }

    public final long zzl(String str, zzfw zzfwVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Long) zzfwVar.zzb(null)).longValue();
        }
        String zza = this.zzc.zza(str, zzfwVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return ((Long) zzfwVar.zzb(null)).longValue();
        }
        try {
            return ((Long) zzfwVar.zzb(Long.valueOf(Long.parseLong(zza)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) zzfwVar.zzb(null)).longValue();
        }
    }

    public final int zzm(String str, zzfw zzfwVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Integer) zzfwVar.zzb(null)).intValue();
        }
        String zza = this.zzc.zza(str, zzfwVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return ((Integer) zzfwVar.zzb(null)).intValue();
        }
        try {
            return ((Integer) zzfwVar.zzb(Integer.valueOf(Integer.parseInt(zza)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) zzfwVar.zzb(null)).intValue();
        }
    }

    public final int zzn(String str, zzfw zzfwVar, int i10, int i11) {
        return Math.max(Math.min(zzm(str, zzfwVar), i11), i10);
    }

    public final double zzo(String str, zzfw zzfwVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Double) zzfwVar.zzb(null)).doubleValue();
        }
        String zza = this.zzc.zza(str, zzfwVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return ((Double) zzfwVar.zzb(null)).doubleValue();
        }
        try {
            return ((Double) zzfwVar.zzb(Double.valueOf(Double.parseDouble(zza)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) zzfwVar.zzb(null)).doubleValue();
        }
    }

    public final boolean zzp(String str, zzfw zzfwVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Boolean) zzfwVar.zzb(null)).booleanValue();
        }
        String zza = this.zzc.zza(str, zzfwVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return ((Boolean) zzfwVar.zzb(null)).booleanValue();
        }
        return ((Boolean) zzfwVar.zzb(Boolean.valueOf("1".equals(zza)))).booleanValue();
    }

    @VisibleForTesting
    final Bundle zzq() {
        try {
            zzib zzibVar = this.zzu;
            if (zzibVar.zzaY().getPackageManager() == null) {
                zzibVar.zzaV().zzb().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzibVar.zzaY()).getApplicationInfo(zzibVar.zzaY().getPackageName(), 128);
            if (applicationInfo == null) {
                zzibVar.zzaV().zzb().zza("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e10) {
            this.zzu.zzaV().zzb().zzb("Failed to load metadata: Package name not found", e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean zzr(@Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzq = zzq();
        if (zzq == null) {
            this.zzu.zzaV().zzb().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (!zzq.containsKey(str)) {
            return null;
        }
        return Boolean.valueOf(zzq.getBoolean(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzs(@Size(min = 1) String str) {
        Integer valueOf;
        Preconditions.checkNotEmpty("analytics.safelisted_events");
        Bundle zzq = zzq();
        if (zzq == null) {
            this.zzu.zzaV().zzb().zza("Failed to load metadata: Metadata bundle is null");
        } else if (zzq.containsKey("analytics.safelisted_events")) {
            valueOf = Integer.valueOf(zzq.getInt("analytics.safelisted_events"));
            if (valueOf != null) {
                try {
                    String[] stringArray = this.zzu.zzaY().getResources().getStringArray(valueOf.intValue());
                    if (stringArray == null) {
                        return null;
                    }
                    return Arrays.asList(stringArray);
                } catch (Resources.NotFoundException e10) {
                    this.zzu.zzaV().zzb().zzb("Failed to load string array from metadata: resource not found", e10);
                }
            }
            return null;
        }
        valueOf = null;
        if (valueOf != null) {
        }
        return null;
    }

    public final boolean zzt() {
        this.zzu.zzaU();
        Boolean zzr = zzr("firebase_analytics_collection_deactivated");
        if (zzr != null && zzr.booleanValue()) {
            return true;
        }
        return false;
    }

    public final boolean zzu() {
        Boolean zzr = zzr("google_analytics_adid_collection_enabled");
        if (zzr != null && !zzr.booleanValue()) {
            return false;
        }
        return true;
    }

    public final boolean zzv() {
        Boolean zzr = zzr("google_analytics_automatic_screen_reporting_enabled");
        if (zzr != null && !zzr.booleanValue()) {
            return false;
        }
        return true;
    }

    public final zzjh zzw(String str, boolean z10) {
        Object obj;
        Preconditions.checkNotEmpty(str);
        zzib zzibVar = this.zzu;
        Bundle zzq = zzq();
        if (zzq == null) {
            zzibVar.zzaV().zzb().zza("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = zzq.get(str);
        }
        if (obj == null) {
            return zzjh.UNINITIALIZED;
        }
        if (Boolean.TRUE.equals(obj)) {
            return zzjh.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return zzjh.DENIED;
        }
        if (z10 && "eu_consent_policy".equals(obj)) {
            return zzjh.POLICY;
        }
        zzibVar.zzaV().zze().zzb("Invalid manifest metadata for", str);
        return zzjh.UNINITIALIZED;
    }

    public final boolean zzx() {
        Boolean zzr = zzr("google_analytics_sgtm_upload_enabled");
        if (zzr == null) {
            return false;
        }
        return zzr.booleanValue();
    }

    public final void zzy(String str) {
        this.zzb = str;
    }

    public final String zzz() {
        return this.zzb;
    }
}
