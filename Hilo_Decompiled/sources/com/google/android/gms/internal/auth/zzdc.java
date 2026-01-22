package com.google.android.gms.internal.auth;

import android.content.Context;
import android.net.Uri;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzdc {
    public static final /* synthetic */ int zzd = 0;
    private static volatile zzda zze;
    private static volatile boolean zzf;
    final zzcz zzb;
    final String zzc;
    private final Object zzj;
    private volatile int zzk = -1;
    private volatile Object zzl;
    private static final Object zza = new Object();
    private static final AtomicReference zzg = new AtomicReference();
    private static final zzde zzh = new zzde(new Object() { // from class: com.google.android.gms.internal.auth.zzcu
    });
    private static final AtomicInteger zzi = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdc(zzcz zzczVar, String str, Object obj, boolean z10, zzdb zzdbVar) {
        if (zzczVar.zza != null) {
            this.zzb = zzczVar;
            this.zzc = str;
            this.zzj = obj;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    public static void zzc() {
        zzi.incrementAndGet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004a, code lost:
    
        throw r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void zzd(final Context context) {
        if (zze == null && context != null) {
            Object obj = zza;
            synchronized (obj) {
                try {
                    if (zze == null) {
                        synchronized (obj) {
                            zzda zzdaVar = zze;
                            Context applicationContext = context.getApplicationContext();
                            if (applicationContext != null) {
                                context = applicationContext;
                            }
                            if (zzdaVar != null) {
                                if (zzdaVar.zza() != context) {
                                }
                            }
                            zzcg.zzd();
                            zzdd.zzc();
                            zzco.zze();
                            zze = new zzcd(context, zzdo.zza(new zzdj() { // from class: com.google.android.gms.internal.auth.zzct
                                @Override // com.google.android.gms.internal.auth.zzdj
                                public final Object zza() {
                                    Context context2 = context;
                                    int i10 = zzdc.zzd;
                                    return zzcp.zza(context2);
                                }
                            }));
                            zzi.incrementAndGet();
                        }
                    }
                } finally {
                }
            }
        }
    }

    abstract Object zza(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:14:0x0043 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x0028, B:14:0x0043, B:16:0x0049, B:18:0x0053, B:20:0x0074, B:22:0x007c, B:24:0x0084, B:26:0x008a, B:29:0x009c, B:31:0x00a2, B:32:0x009a, B:34:0x00a8, B:36:0x00ac, B:39:0x00b4, B:40:0x00b7, B:41:0x00bb, B:44:0x0068, B:45:0x00c0, B:46:0x00c5, B:49:0x00c6), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c0 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x0028, B:14:0x0043, B:16:0x0049, B:18:0x0053, B:20:0x0074, B:22:0x007c, B:24:0x0084, B:26:0x008a, B:29:0x009c, B:31:0x00a2, B:32:0x009a, B:34:0x00a8, B:36:0x00ac, B:39:0x00b4, B:40:0x00b7, B:41:0x00bb, B:44:0x0068, B:45:0x00c0, B:46:0x00c5, B:49:0x00c6), top: B:4:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzb() {
        String str;
        zzcl zza2;
        Object obj;
        String str2;
        Object zzb;
        int i10 = zzi.get();
        if (this.zzk < i10) {
            synchronized (this) {
                try {
                    if (this.zzk < i10) {
                        zzda zzdaVar = zze;
                        zzdh zzc = zzdh.zzc();
                        Object obj2 = null;
                        if (zzdaVar != null) {
                            zzc = (zzdh) zzdaVar.zzb().zza();
                            if (zzc.zzb()) {
                                zzci zzciVar = (zzci) zzc.zza();
                                zzcz zzczVar = this.zzb;
                                str = zzciVar.zza(zzczVar.zza, null, zzczVar.zzc, this.zzc);
                                if (zzdaVar == null) {
                                    Uri uri = this.zzb.zza;
                                    if (uri != null) {
                                        if (zzcq.zza(zzdaVar.zza(), uri)) {
                                            zza2 = zzcg.zza(zzdaVar.zza().getContentResolver(), this.zzb.zza, new Runnable() { // from class: com.google.android.gms.internal.auth.zzcs
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    zzdc.zzc();
                                                }
                                            });
                                        } else {
                                            zza2 = null;
                                        }
                                    } else {
                                        zza2 = zzdd.zza(zzdaVar.zza(), null, new Runnable() { // from class: com.google.android.gms.internal.auth.zzcs
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                zzdc.zzc();
                                            }
                                        });
                                    }
                                    if (zza2 != null && (zzb = zza2.zzb(this.zzc)) != null) {
                                        obj = zza(zzb);
                                    } else {
                                        obj = null;
                                    }
                                    if (obj == null) {
                                        if (!this.zzb.zzd) {
                                            zzco zza3 = zzco.zza(zzdaVar.zza());
                                            if (this.zzb.zzd) {
                                                str2 = null;
                                            } else {
                                                str2 = this.zzc;
                                            }
                                            String zzb2 = zza3.zzb(str2);
                                            if (zzb2 != null) {
                                                obj2 = zza(zzb2);
                                            }
                                        }
                                        if (obj2 == null) {
                                            obj = this.zzj;
                                        } else {
                                            obj = obj2;
                                        }
                                    }
                                    if (zzc.zzb()) {
                                        if (str == null) {
                                            obj = this.zzj;
                                        } else {
                                            obj = zza(str);
                                        }
                                    }
                                    this.zzl = obj;
                                    this.zzk = i10;
                                } else {
                                    throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                                }
                            }
                        }
                        str = null;
                        if (zzdaVar == null) {
                        }
                    }
                } finally {
                }
            }
        }
        return this.zzl;
    }
}
