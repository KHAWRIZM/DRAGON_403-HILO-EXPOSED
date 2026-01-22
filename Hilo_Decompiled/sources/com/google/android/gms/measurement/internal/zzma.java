package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.GuardedBy;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzma extends zzg {

    @VisibleForTesting
    protected zzlt zza;
    private volatile zzlt zzb;
    private volatile zzlt zzc;
    private final Map zzd;

    @GuardedBy("activityLock")
    private com.google.android.gms.internal.measurement.zzdf zze;

    @GuardedBy("activityLock")
    private volatile boolean zzf;
    private volatile zzlt zzg;
    private zzlt zzh;

    @GuardedBy("activityLock")
    private boolean zzi;
    private final Object zzj;

    public zzma(zzib zzibVar) {
        super(zzibVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    private final void zzA(zzlt zzltVar, boolean z10, long j10) {
        boolean z11;
        zzib zzibVar = this.zzu;
        zzibVar.zzw().zzc(zzibVar.zzaZ().elapsedRealtime());
        if (zzltVar != null && zzltVar.zzd) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (zzibVar.zzh().zzb.zzd(z11, z10, j10) && zzltVar != null) {
            zzltVar.zzd = false;
        }
    }

    private final zzlt zzB(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        Preconditions.checkNotNull(zzdfVar);
        Integer valueOf = Integer.valueOf(zzdfVar.zza);
        Map map = this.zzd;
        zzlt zzltVar = (zzlt) map.get(valueOf);
        if (zzltVar == null) {
            zzlt zzltVar2 = new zzlt(null, zzi(zzdfVar.zzb, "Activity"), this.zzu.zzk().zzd());
            map.put(valueOf, zzltVar2);
            zzltVar = zzltVar2;
        }
        if (this.zzg != null) {
            return this.zzg;
        }
        return zzltVar;
    }

    private final void zzy(String str, zzlt zzltVar, boolean z10) {
        zzlt zzltVar2;
        zzlt zzltVar3;
        String str2;
        if (this.zzb == null) {
            zzltVar2 = this.zzc;
        } else {
            zzltVar2 = this.zzb;
        }
        zzlt zzltVar4 = zzltVar2;
        if (zzltVar.zzb == null) {
            if (str != null) {
                str2 = zzi(str, "Activity");
            } else {
                str2 = null;
            }
            zzltVar3 = new zzlt(zzltVar.zza, str2, zzltVar.zzc, zzltVar.zze, zzltVar.zzf);
        } else {
            zzltVar3 = zzltVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzltVar3;
        zzib zzibVar = this.zzu;
        zzibVar.zzaW().zzj(new zzlv(this, zzltVar3, zzltVar4, zzibVar.zzaZ().elapsedRealtime(), z10));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzz(zzlt zzltVar, zzlt zzltVar2, long j10, boolean z10, Bundle bundle) {
        boolean z11;
        Bundle bundle2;
        String str;
        long j11;
        long j12;
        zzg();
        boolean z12 = false;
        if (zzltVar2 != null) {
            if (zzltVar2.zzc == zzltVar.zzc && Objects.equals(zzltVar2.zzb, zzltVar.zzb) && Objects.equals(zzltVar2.zza, zzltVar.zza)) {
                z11 = false;
                if (z10 && this.zza != null) {
                    z12 = true;
                }
                if (z11) {
                    if (bundle != null) {
                        bundle2 = new Bundle(bundle);
                    } else {
                        bundle2 = new Bundle();
                    }
                    Bundle bundle3 = bundle2;
                    zzpo.zzav(zzltVar, bundle3, true);
                    if (zzltVar2 != null) {
                        String str2 = zzltVar2.zza;
                        if (str2 != null) {
                            bundle3.putString("_pn", str2);
                        }
                        String str3 = zzltVar2.zzb;
                        if (str3 != null) {
                            bundle3.putString("_pc", str3);
                        }
                        bundle3.putLong("_pi", zzltVar2.zzc);
                    }
                    if (z12) {
                        zznz zznzVar = this.zzu.zzh().zzb;
                        long j13 = j10 - zznzVar.zzb;
                        zznzVar.zzb = j10;
                        if (j13 > 0) {
                            this.zzu.zzk().zzak(bundle3, j13);
                        }
                    }
                    zzib zzibVar = this.zzu;
                    if (!zzibVar.zzc().zzv()) {
                        bundle3.putLong("_mst", 1L);
                    }
                    boolean z13 = zzltVar.zze;
                    if (true != z13) {
                        str = "auto";
                    } else {
                        str = "app";
                    }
                    long currentTimeMillis = zzibVar.zzaZ().currentTimeMillis();
                    if (z13) {
                        j11 = currentTimeMillis;
                        long j14 = zzltVar.zzf;
                        if (j14 != 0) {
                            j12 = j14;
                            this.zzu.zzj().zzG(str, "_vs", j12, bundle3);
                        }
                    } else {
                        j11 = currentTimeMillis;
                    }
                    j12 = j11;
                    this.zzu.zzj().zzG(str, "_vs", j12, bundle3);
                }
                if (z12) {
                    zzA(this.zza, true, j10);
                }
                this.zza = zzltVar;
                if (zzltVar.zze) {
                    this.zzh = zzltVar;
                }
                this.zzu.zzt().zzG(zzltVar);
            }
        }
        z11 = true;
        if (z10) {
            z12 = true;
        }
        if (z11) {
        }
        if (z12) {
        }
        this.zza = zzltVar;
        if (zzltVar.zze) {
        }
        this.zzu.zzt().zzG(zzltVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return false;
    }

    public final zzlt zzh(boolean z10) {
        zzb();
        zzg();
        if (!z10) {
            return this.zza;
        }
        zzlt zzltVar = this.zza;
        if (zzltVar != null) {
            return zzltVar;
        }
        return this.zzh;
    }

    @VisibleForTesting
    final String zzi(String str, String str2) {
        String str3;
        if (str == null) {
            return "Activity";
        }
        String[] split = str.split("\\.");
        int length = split.length;
        if (length > 0) {
            str3 = split[length - 1];
        } else {
            str3 = "";
        }
        zzib zzibVar = this.zzu;
        if (str3.length() > zzibVar.zzc().zze(null, false)) {
            return str3.substring(0, zzibVar.zzc().zze(null, false));
        }
        return str3;
    }

    public final void zzj(Bundle bundle, long j10) {
        String str;
        String str2;
        zzlt zzltVar;
        String str3;
        synchronized (this.zzj) {
            try {
                if (!this.zzi) {
                    this.zzu.zzaV().zzh().zza("Cannot log screen view event when the app is in the background.");
                    return;
                }
                String string = bundle.getString(FirebaseAnalytics.Param.SCREEN_NAME);
                if (string != null && (string.length() <= 0 || string.length() > this.zzu.zzc().zze(null, false))) {
                    this.zzu.zzaV().zzh().zzb("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle.getString(FirebaseAnalytics.Param.SCREEN_CLASS);
                if (string2 != null && (string2.length() <= 0 || string2.length() > this.zzu.zzc().zze(null, false))) {
                    this.zzu.zzaV().zzh().zzb("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                }
                if (string2 == null) {
                    com.google.android.gms.internal.measurement.zzdf zzdfVar = this.zze;
                    if (zzdfVar != null) {
                        str3 = zzi(zzdfVar.zzb, "Activity");
                    } else {
                        str3 = "Activity";
                    }
                    string2 = str3;
                }
                zzlt zzltVar2 = this.zzb;
                if (this.zzf && zzltVar2 != null) {
                    this.zzf = false;
                    boolean equals = Objects.equals(zzltVar2.zzb, string2);
                    boolean equals2 = Objects.equals(zzltVar2.zza, string);
                    if (equals && equals2) {
                        this.zzu.zzaV().zzh().zza("Ignoring call to log screen view event with duplicate parameters.");
                        return;
                    }
                }
                zzib zzibVar = this.zzu;
                zzgr zzk = zzibVar.zzaV().zzk();
                if (string == null) {
                    str = Constants.NULL_VERSION_ID;
                } else {
                    str = string;
                }
                if (string2 == null) {
                    str2 = Constants.NULL_VERSION_ID;
                } else {
                    str2 = string2;
                }
                zzk.zzc("Logging screen view with name, class", str, str2);
                if (this.zzb == null) {
                    zzltVar = this.zzc;
                } else {
                    zzltVar = this.zzb;
                }
                zzlt zzltVar3 = new zzlt(string, string2, zzibVar.zzk().zzd(), true, j10);
                this.zzb = zzltVar3;
                this.zzc = zzltVar;
                this.zzg = zzltVar3;
                zzibVar.zzaW().zzj(new zzlu(this, bundle, zzltVar3, zzltVar, zzibVar.zzaZ().elapsedRealtime()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public final void zzk(com.google.android.gms.internal.measurement.zzdf zzdfVar, @Size(max = 36, min = 1) String str, @Size(max = 36, min = 1) String str2) {
        String str3;
        zzib zzibVar = this.zzu;
        if (!zzibVar.zzc().zzv()) {
            zzibVar.zzaV().zzh().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzlt zzltVar = this.zzb;
        if (zzltVar == null) {
            zzibVar.zzaV().zzh().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        Map map = this.zzd;
        Integer valueOf = Integer.valueOf(zzdfVar.zza);
        if (map.get(valueOf) == null) {
            zzibVar.zzaV().zzh().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zzi(zzdfVar.zzb, "Activity");
        }
        String str4 = zzltVar.zzb;
        String str5 = zzltVar.zza;
        boolean equals = Objects.equals(str4, str2);
        boolean equals2 = Objects.equals(str5, str);
        if (equals && equals2) {
            zzibVar.zzaV().zzh().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > zzibVar.zzc().zze(null, false))) {
            zzibVar.zzaV().zzh().zzb("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > zzibVar.zzc().zze(null, false))) {
            zzibVar.zzaV().zzh().zzb("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzgr zzk = zzibVar.zzaV().zzk();
        if (str == null) {
            str3 = Constants.NULL_VERSION_ID;
        } else {
            str3 = str;
        }
        zzk.zzc("Setting current screen to name, class", str3, str2);
        zzlt zzltVar2 = new zzlt(str, str2, zzibVar.zzk().zzd());
        map.put(valueOf, zzltVar2);
        zzy(zzdfVar.zzb, zzltVar2, true);
    }

    public final zzlt zzl() {
        return this.zzb;
    }

    public final void zzm(com.google.android.gms.internal.measurement.zzdf zzdfVar, Bundle bundle) {
        Bundle bundle2;
        if (this.zzu.zzc().zzv() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(Integer.valueOf(zzdfVar.zza), new zzlt(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    public final void zzn(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        Object obj = this.zzj;
        synchronized (obj) {
            this.zzi = true;
            if (!Objects.equals(zzdfVar, this.zze)) {
                synchronized (obj) {
                    this.zze = zzdfVar;
                    this.zzf = false;
                    zzib zzibVar = this.zzu;
                    if (zzibVar.zzc().zzv()) {
                        this.zzg = null;
                        zzibVar.zzaW().zzj(new zzlz(this));
                    }
                }
            }
        }
        zzib zzibVar2 = this.zzu;
        if (!zzibVar2.zzc().zzv()) {
            this.zzb = this.zzg;
            zzibVar2.zzaW().zzj(new zzlw(this));
            return;
        }
        zzy(zzdfVar.zzb, zzB(zzdfVar), false);
        zzd zzw = this.zzu.zzw();
        zzib zzibVar3 = zzw.zzu;
        zzibVar3.zzaW().zzj(new zzc(zzw, zzibVar3.zzaZ().elapsedRealtime()));
    }

    public final void zzp(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        zzib zzibVar = this.zzu;
        long elapsedRealtime = zzibVar.zzaZ().elapsedRealtime();
        if (!zzibVar.zzc().zzv()) {
            this.zzb = null;
            zzibVar.zzaW().zzj(new zzlx(this, elapsedRealtime));
        } else {
            zzlt zzB = zzB(zzdfVar);
            this.zzc = this.zzb;
            this.zzb = null;
            zzibVar.zzaW().zzj(new zzly(this, zzB, elapsedRealtime));
        }
    }

    public final void zzq(com.google.android.gms.internal.measurement.zzdf zzdfVar, Bundle bundle) {
        zzlt zzltVar;
        if (this.zzu.zzc().zzv() && bundle != null && (zzltVar = (zzlt) this.zzd.get(Integer.valueOf(zzdfVar.zza))) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzltVar.zzc);
            bundle2.putString("name", zzltVar.zza);
            bundle2.putString("referrer_name", zzltVar.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    public final void zzs(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        synchronized (this.zzj) {
            try {
                if (Objects.equals(this.zze, zzdfVar)) {
                    this.zze = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!this.zzu.zzc().zzv()) {
            return;
        }
        this.zzd.remove(Integer.valueOf(zzdfVar.zza));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzt(Bundle bundle, zzlt zzltVar, zzlt zzltVar2, long j10) {
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        zzz(zzltVar, zzltVar2, j10, true, this.zzu.zzk().zzF(null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, null, false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzu(zzlt zzltVar, zzlt zzltVar2, long j10, boolean z10, Bundle bundle) {
        zzz(zzltVar, zzltVar2, j10, z10, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzv(zzlt zzltVar, boolean z10, long j10) {
        zzA(zzltVar, false, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzlt zzw() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzx(zzlt zzltVar) {
        this.zzh = null;
    }
}
