package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zznk extends zzg {
    private final zzne zza;
    private zzga zzb;
    private volatile Boolean zzc;
    private final zzay zzd;
    private ScheduledExecutorService zze;
    private final zzof zzf;
    private final List zzg;
    private final zzay zzh;

    /* JADX INFO: Access modifiers changed from: protected */
    public zznk(zzib zzibVar) {
        super(zzibVar);
        this.zzg = new ArrayList();
        this.zzf = new zzof(zzibVar.zzaZ());
        this.zza = new zzne(this);
        this.zzd = new zzml(this, zzibVar);
        this.zzh = new zzmp(this, zzibVar);
    }

    private final boolean zzad() {
        this.zzu.zzaU();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzae, reason: merged with bridge method [inline-methods] */
    public final void zzV() {
        zzg();
        this.zzf.zza();
        this.zzu.zzc();
        this.zzd.zzb(((Long) zzfx.zzY.zzb(null)).longValue());
    }

    private final void zzaf(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzh()) {
            runnable.run();
            return;
        }
        List list = this.zzg;
        long size = list.size();
        zzib zzibVar = this.zzu;
        zzibVar.zzc();
        if (size >= 1000) {
            zzibVar.zzaV().zzb().zza("Discarding data. Max runnable queue size reached");
            return;
        }
        list.add(runnable);
        this.zzh.zzb(60000L);
        zzI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzag, reason: merged with bridge method [inline-methods] */
    public final void zzX() {
        zzg();
        zzgr zzk = this.zzu.zzaV().zzk();
        List list = this.zzg;
        zzk.zzb("Processing queued up service tasks", Integer.valueOf(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e10) {
                this.zzu.zzaV().zzb().zzb("Task exception while flushing queue", e10);
            }
        }
        this.zzg.clear();
        this.zzh.zzd();
    }

    private final zzr zzah(boolean z10) {
        Pair zzb;
        zzib zzibVar = this.zzu;
        zzibVar.zzaU();
        zzgh zzv = this.zzu.zzv();
        String str = null;
        if (z10) {
            zzib zzibVar2 = zzibVar.zzaV().zzu;
            if (zzibVar2.zzd().zzb != null && (zzb = zzibVar2.zzd().zzb.zzb()) != null && zzb != zzhg.zza) {
                String valueOf = String.valueOf(zzb.second);
                String str2 = (String) zzb.first;
                StringBuilder sb = new StringBuilder(valueOf.length() + 1 + String.valueOf(str2).length());
                sb.append(valueOf);
                sb.append(CertificateUtil.DELIMITER);
                sb.append(str2);
                str = sb.toString();
            }
        }
        return zzv.zzh(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzA(zzpk zzpkVar) {
        zzg();
        zzb();
        zzad();
        zzaf(new zzmf(this, zzah(true), this.zzu.zzm().zzj(zzpkVar), zzpkVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzB() {
        zzg();
        zzb();
        zzr zzah = zzah(false);
        zzad();
        this.zzu.zzm().zzh();
        zzaf(new zzmg(this, zzah));
    }

    public final void zzC(AtomicReference atomicReference) {
        zzg();
        zzb();
        zzaf(new zzmh(this, atomicReference, zzah(false)));
    }

    public final void zzD(com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        zzg();
        zzb();
        zzaf(new zzmi(this, zzah(false), zzcuVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzE() {
        zzg();
        zzb();
        zzr zzah = zzah(true);
        zzad();
        this.zzu.zzc().zzp(null, zzfx.zzbc);
        this.zzu.zzm().zzn();
        zzaf(new zzmj(this, zzah, true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzF() {
        zzg();
        zzb();
        zzaf(new zzmk(this, zzah(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzG(zzlt zzltVar) {
        zzg();
        zzb();
        zzaf(new zzmm(this, zzltVar));
    }

    public final void zzH(Bundle bundle) {
        boolean z10;
        zzg();
        zzb();
        zzbe zzbeVar = new zzbe(bundle);
        zzad();
        if (this.zzu.zzc().zzp(null, zzfx.zzbc) && this.zzu.zzm().zzl(zzbeVar)) {
            z10 = true;
        } else {
            z10 = false;
        }
        zzaf(new zzmn(this, true, zzah(false), z10, zzbeVar, bundle));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzI() {
        zzg();
        zzb();
        if (!zzh()) {
            if (!zzK()) {
                zzib zzibVar = this.zzu;
                if (!zzibVar.zzc().zzE()) {
                    zzibVar.zzaU();
                    List<ResolveInfo> queryIntentServices = zzibVar.zzaY().getPackageManager().queryIntentServices(new Intent().setClassName(zzibVar.zzaY(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                    if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                        Intent intent = new Intent("com.google.android.gms.measurement.START");
                        Context zzaY = zzibVar.zzaY();
                        zzibVar.zzaU();
                        intent.setComponent(new ComponentName(zzaY, "com.google.android.gms.measurement.AppMeasurementService"));
                        this.zza.zza(intent);
                        return;
                    }
                    zzibVar.zzaV().zzb().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                    return;
                }
                return;
            }
            this.zza.zzc();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean zzJ() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzK() {
        Boolean valueOf;
        zzg();
        zzb();
        if (this.zzc == null) {
            zzg();
            zzb();
            zzib zzibVar = this.zzu;
            zzhg zzd = zzibVar.zzd();
            zzd.zzg();
            boolean z10 = false;
            if (!zzd.zzd().contains("use_service")) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(zzd.zzd().getBoolean("use_service", false));
            }
            boolean z11 = true;
            if (valueOf == null || !valueOf.booleanValue()) {
                zzibVar.zzaU();
                if (this.zzu.zzv().zzo() != 1) {
                    zzibVar.zzaV().zzk().zza("Checking service availability");
                    int zzai = zzibVar.zzk().zzai(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                    if (zzai != 0) {
                        if (zzai != 1) {
                            if (zzai != 2) {
                                if (zzai != 3) {
                                    if (zzai != 9) {
                                        if (zzai != 18) {
                                            zzibVar.zzaV().zze().zzb("Unexpected service status", Integer.valueOf(zzai));
                                        } else {
                                            zzibVar.zzaV().zze().zza("Service updating");
                                        }
                                    } else {
                                        zzibVar.zzaV().zze().zza("Service invalid");
                                    }
                                } else {
                                    zzibVar.zzaV().zze().zza("Service disabled");
                                }
                            } else {
                                zzibVar.zzaV().zzj().zza("Service container out of date");
                                if (zzibVar.zzk().zzah() >= 17443) {
                                    if (valueOf != null) {
                                        z11 = false;
                                    }
                                    z10 = z11;
                                }
                            }
                            z11 = false;
                        } else {
                            zzibVar.zzaV().zzk().zza("Service missing");
                        }
                        if (z10 && zzibVar.zzc().zzE()) {
                            zzibVar.zzaV().zzb().zza("No way to upload. Consider using the full version of Analytics");
                        } else if (z11) {
                            zzhg zzd2 = zzibVar.zzd();
                            zzd2.zzg();
                            SharedPreferences.Editor edit = zzd2.zzd().edit();
                            edit.putBoolean("use_service", z10);
                            edit.apply();
                        }
                        z11 = z10;
                    } else {
                        zzibVar.zzaV().zzk().zza("Service available");
                    }
                }
                z10 = true;
                if (z10) {
                }
                if (z11) {
                }
                z11 = z10;
            }
            this.zzc = Boolean.valueOf(z11);
        }
        return this.zzc.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzL(zzga zzgaVar) {
        zzg();
        Preconditions.checkNotNull(zzgaVar);
        this.zzb = zzgaVar;
        zzV();
        zzX();
    }

    public final void zzM() {
        zzg();
        zzb();
        zzne zzneVar = this.zza;
        zzneVar.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzu.zzaY(), zzneVar);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    public final void zzN(com.google.android.gms.internal.measurement.zzcu zzcuVar, zzbg zzbgVar, String str) {
        zzg();
        zzb();
        zzib zzibVar = this.zzu;
        if (zzibVar.zzk().zzai(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzibVar.zzaV().zze().zza("Not bundling data. Service unavailable or out of date");
            zzibVar.zzk().zzao(zzcuVar, new byte[0]);
        } else {
            zzaf(new zzmo(this, zzbgVar, str, zzcuVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzO() {
        zzg();
        zzb();
        if (!zzK() || this.zzu.zzk().zzah() >= ((Integer) zzfx.zzaJ.zzb(null)).intValue()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzP() {
        zzg();
        zzb();
        if (!zzK() || this.zzu.zzk().zzah() >= 241200) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzQ() {
        zzga zzgaVar = this.zzb;
        if (zzgaVar == null) {
            this.zzu.zzaV().zzb().zza("Failed to send storage consent settings to service");
            return;
        }
        try {
            zzr zzah = zzah(false);
            Preconditions.checkNotNull(zzah);
            zzgaVar.zzy(zzah);
            zzV();
        } catch (RemoteException e10) {
            this.zzu.zzaV().zzb().zzb("Failed to send storage consent settings to the service", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzR() {
        zzga zzgaVar = this.zzb;
        if (zzgaVar == null) {
            this.zzu.zzaV().zzb().zza("Failed to send Dma consent settings to service");
            return;
        }
        try {
            zzr zzah = zzah(false);
            Preconditions.checkNotNull(zzah);
            zzgaVar.zzz(zzah);
            zzV();
        } catch (RemoteException e10) {
            this.zzu.zzaV().zzb().zzb("Failed to send Dma consent settings to the service", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzS(AtomicReference atomicReference, zzr zzrVar, Bundle bundle) {
        zzga zzgaVar;
        synchronized (atomicReference) {
            try {
                zzgaVar = this.zzb;
            } catch (RemoteException e10) {
                this.zzu.zzaV().zzb().zzb("Failed to request trigger URIs; remote exception", e10);
                atomicReference.notifyAll();
            }
            if (zzgaVar == null) {
                this.zzu.zzaV().zzb().zza("Failed to request trigger URIs; not connected to service");
                return;
            }
            Preconditions.checkNotNull(zzrVar);
            zzgaVar.zzD(zzrVar, bundle, new zzmd(this, atomicReference));
            zzV();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzT(AtomicReference atomicReference, zzr zzrVar, zzon zzonVar) {
        zzga zzgaVar;
        synchronized (atomicReference) {
            try {
                zzgaVar = this.zzb;
            } catch (RemoteException e10) {
                this.zzu.zzaV().zzb().zzb("[sgtm] Failed to get upload batches; remote exception", e10);
                atomicReference.notifyAll();
            }
            if (zzgaVar == null) {
                this.zzu.zzaV().zzb().zza("[sgtm] Failed to get upload batches; not connected to service");
                return;
            }
            Preconditions.checkNotNull(zzrVar);
            zzgaVar.zzB(zzrVar, zzonVar, new zzme(this, atomicReference));
            zzV();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzU(zzr zzrVar, zzaf zzafVar) {
        zzga zzgaVar = this.zzb;
        if (zzgaVar == null) {
            this.zzu.zzaV().zzb().zza("[sgtm] Discarding data. Failed to update batch upload status.");
            return;
        }
        try {
            zzgaVar.zzC(zzrVar, zzafVar);
            zzV();
        } catch (RemoteException e10) {
            this.zzu.zzaV().zzb().zzc("[sgtm] Failed to update batch upload status, rowId, exception", Long.valueOf(zzafVar.zza), e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzW(ComponentName componentName) {
        zzg();
        if (this.zzb != null) {
            this.zzb = null;
            this.zzu.zzaV().zzk().zzb("Disconnected from device MeasurementService", componentName);
            zzg();
            zzI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzne zzY() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzga zzZ() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaa(zzga zzgaVar) {
        this.zzb = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ScheduledExecutorService zzab() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzac(ScheduledExecutorService scheduledExecutorService) {
        this.zze = scheduledExecutorService;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return false;
    }

    public final boolean zzh() {
        zzg();
        zzb();
        if (this.zzb != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzi() {
        zzg();
        zzb();
        zzaf(new zzmq(this, zzah(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzj(boolean z10) {
        zzg();
        zzb();
        if (zzO()) {
            zzaf(new zzmr(this, zzah(false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzk(boolean z10) {
        zzg();
        zzb();
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznj
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznk.this.zzQ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzl() {
        zzg();
        zzb();
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznf
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznk.this.zzR();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzm(zzga zzgaVar, AbstractSafeParcelable abstractSafeParcelable, zzr zzrVar) {
        int i10;
        String str;
        long j10;
        long j11;
        long j12;
        zzg();
        zzb();
        zzad();
        zzib zzibVar = this.zzu;
        zzibVar.zzc();
        zzr zzrVar2 = zzrVar;
        int i11 = 0;
        int i12 = 100;
        for (int i13 = 100; i11 < 1001 && i12 == i13; i13 = 100) {
            zzib zzibVar2 = this.zzu;
            ArrayList arrayList = new ArrayList();
            List zzm = zzibVar2.zzm().zzm(i13);
            if (zzm != null) {
                arrayList.addAll(zzm);
                i12 = zzm.size();
            } else {
                i12 = 0;
            }
            if (abstractSafeParcelable != null && i12 < i13) {
                arrayList.add(new zzgj(abstractSafeParcelable, zzrVar2.zzc, zzrVar2.zzj));
            }
            String str2 = null;
            boolean zzp = zzibVar.zzc().zzp(null, zzfx.zzaO);
            int size = arrayList.size();
            int i14 = 0;
            while (i14 < size) {
                zzgj zzgjVar = (zzgj) arrayList.get(i14);
                AbstractSafeParcelable abstractSafeParcelable2 = zzgjVar.zza;
                zzal zzc = zzibVar.zzc();
                zzfw zzfwVar = zzfx.zzbc;
                if (zzc.zzp(str2, zzfwVar)) {
                    String str3 = zzgjVar.zzb;
                    if (!TextUtils.isEmpty(str3)) {
                        i10 = i14;
                        zzrVar2 = new zzr(zzrVar2.zza, zzrVar2.zzb, str3, zzgjVar.zzc, zzrVar2.zzd, zzrVar2.zze, zzrVar2.zzf, zzrVar2.zzg, zzrVar2.zzh, zzrVar2.zzi, zzrVar2.zzk, zzrVar2.zzl, zzrVar2.zzm, zzrVar2.zzn, zzrVar2.zzo, zzrVar2.zzp, zzrVar2.zzq, zzrVar2.zzr, zzrVar2.zzs, zzrVar2.zzt, zzrVar2.zzu, zzrVar2.zzv, zzrVar2.zzw, zzrVar2.zzx, zzrVar2.zzy, zzrVar2.zzz, zzrVar2.zzA, zzrVar2.zzB, zzrVar2.zzC, zzrVar2.zzD, zzrVar2.zzE);
                        zzr zzrVar3 = zzrVar2;
                        if (!(abstractSafeParcelable2 instanceof zzbg)) {
                            if (zzp) {
                                try {
                                    zzib zzibVar3 = this.zzu;
                                    long currentTimeMillis = zzibVar3.zzaZ().currentTimeMillis();
                                    try {
                                        j12 = currentTimeMillis;
                                        j11 = zzibVar3.zzaZ().elapsedRealtime();
                                    } catch (RemoteException e10) {
                                        e = e10;
                                        j11 = 0;
                                        j10 = currentTimeMillis;
                                        this.zzu.zzaV().zzb().zzb("Failed to send event to the service", e);
                                        if (zzp && j10 != 0) {
                                            zzib zzibVar4 = this.zzu;
                                            zzgp.zza(zzibVar4).zzb(36301, 13, j10, zzibVar4.zzaZ().currentTimeMillis(), (int) (zzibVar4.zzaZ().elapsedRealtime() - j11));
                                        }
                                        str = null;
                                        str2 = str;
                                        i14 = i10 + 1;
                                        zzrVar2 = zzrVar3;
                                    }
                                } catch (RemoteException e11) {
                                    e = e11;
                                    j10 = 0;
                                    j11 = 0;
                                }
                            } else {
                                j12 = 0;
                                j11 = 0;
                            }
                            try {
                                zzgaVar.zze((zzbg) abstractSafeParcelable2, zzrVar3);
                                if (zzp) {
                                    zzibVar.zzaV().zzk().zza("Logging telemetry for logEvent from database");
                                    zzib zzibVar5 = this.zzu;
                                    zzgp.zza(zzibVar5).zzb(36301, 0, j12, zzibVar5.zzaZ().currentTimeMillis(), (int) (zzibVar5.zzaZ().elapsedRealtime() - j11));
                                }
                            } catch (RemoteException e12) {
                                e = e12;
                                j10 = j12;
                                this.zzu.zzaV().zzb().zzb("Failed to send event to the service", e);
                                if (zzp) {
                                    zzib zzibVar42 = this.zzu;
                                    zzgp.zza(zzibVar42).zzb(36301, 13, j10, zzibVar42.zzaZ().currentTimeMillis(), (int) (zzibVar42.zzaZ().elapsedRealtime() - j11));
                                }
                                str = null;
                                str2 = str;
                                i14 = i10 + 1;
                                zzrVar2 = zzrVar3;
                            }
                        } else if (abstractSafeParcelable2 instanceof zzpk) {
                            try {
                                zzgaVar.zzf((zzpk) abstractSafeParcelable2, zzrVar3);
                            } catch (RemoteException e13) {
                                this.zzu.zzaV().zzb().zzb("Failed to send user property to the service", e13);
                            }
                        } else if (abstractSafeParcelable2 instanceof zzah) {
                            try {
                                zzgaVar.zzn((zzah) abstractSafeParcelable2, zzrVar3);
                            } catch (RemoteException e14) {
                                this.zzu.zzaV().zzb().zzb("Failed to send conditional user property to the service", e14);
                            }
                        } else {
                            zzib zzibVar6 = this.zzu;
                            str = null;
                            if (zzibVar6.zzc().zzp(null, zzfwVar) && (abstractSafeParcelable2 instanceof zzbe)) {
                                try {
                                    zzgaVar.zzu(((zzbe) abstractSafeParcelable2).zzf(), zzrVar3);
                                } catch (RemoteException e15) {
                                    this.zzu.zzaV().zzb().zzb("Failed to send default event parameters to the service", e15);
                                }
                            } else {
                                zzibVar6.zzaV().zzb().zza("Discarding data. Unrecognized parcel type.");
                            }
                            str2 = str;
                            i14 = i10 + 1;
                            zzrVar2 = zzrVar3;
                        }
                        str = null;
                        str2 = str;
                        i14 = i10 + 1;
                        zzrVar2 = zzrVar3;
                    }
                }
                i10 = i14;
                zzr zzrVar32 = zzrVar2;
                if (!(abstractSafeParcelable2 instanceof zzbg)) {
                }
                str = null;
                str2 = str;
                i14 = i10 + 1;
                zzrVar2 = zzrVar32;
            }
            i11++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzn(zzbg zzbgVar, String str) {
        Preconditions.checkNotNull(zzbgVar);
        zzg();
        zzb();
        zzad();
        zzaf(new zzms(this, true, zzah(true), this.zzu.zzm().zzi(zzbgVar), zzbgVar, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzp(zzah zzahVar) {
        Preconditions.checkNotNull(zzahVar);
        zzg();
        zzb();
        this.zzu.zzaU();
        zzaf(new zzmt(this, true, zzah(true), this.zzu.zzm().zzk(zzahVar), new zzah(zzahVar), zzahVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzq(AtomicReference atomicReference, String str, String str2, String str3) {
        zzg();
        zzb();
        zzaf(new zzmu(this, atomicReference, null, str2, str3, zzah(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzs(com.google.android.gms.internal.measurement.zzcu zzcuVar, String str, String str2) {
        zzg();
        zzb();
        zzaf(new zzmv(this, str, str2, zzah(false), zzcuVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzt(AtomicReference atomicReference, String str, String str2, String str3, boolean z10) {
        zzg();
        zzb();
        zzaf(new zzmw(this, atomicReference, null, str2, str3, zzah(false), z10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzu(com.google.android.gms.internal.measurement.zzcu zzcuVar, String str, String str2, boolean z10) {
        zzg();
        zzb();
        zzaf(new zzmb(this, str, str2, zzah(false), z10, zzcuVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzv(AtomicReference atomicReference, boolean z10) {
        zzg();
        zzb();
        zzaf(new zzmc(this, atomicReference, zzah(false), z10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzw(final AtomicReference atomicReference, final Bundle bundle) {
        zzg();
        zzb();
        final zzr zzah = zzah(false);
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzng
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznk.this.zzS(atomicReference, zzah, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzx(final AtomicReference atomicReference, final zzon zzonVar) {
        zzg();
        zzb();
        final zzr zzah = zzah(false);
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznh
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznk.this.zzT(atomicReference, zzah, zzonVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzy(final zzaf zzafVar) {
        zzg();
        zzb();
        final zzr zzah = zzah(true);
        Preconditions.checkNotNull(zzah);
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzni
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznk.this.zzU(zzah, zzafVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzao zzz() {
        zzg();
        zzb();
        zzga zzgaVar = this.zzb;
        if (zzgaVar == null) {
            zzI();
            this.zzu.zzaV().zzj().zza("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzr zzah = zzah(false);
        Preconditions.checkNotNull(zzah);
        try {
            zzao zzw = zzgaVar.zzw(zzah);
            zzV();
            return zzw;
        } catch (RemoteException e10) {
            this.zzu.zzaV().zzb().zzb("Failed to get consents; remote exception", e10);
            return null;
        }
    }
}
