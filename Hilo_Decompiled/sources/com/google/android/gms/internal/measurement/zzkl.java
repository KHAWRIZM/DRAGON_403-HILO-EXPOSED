package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import k8.k;
import k8.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzkl {
    public static final /* synthetic */ int zzc = 0;
    private static final Object zzd = new Object();
    private static volatile zzkg zze;
    private static volatile boolean zzf;
    private static final AtomicInteger zzh;
    final zzkf zza;
    final String zzb;
    private Object zzg;
    private volatile int zzi = -1;
    private volatile Object zzj;
    private volatile boolean zzk;

    static {
        new AtomicReference();
        k8.h.j(zzkj.zza, "BuildInfo must be non-null");
        zzh = new AtomicInteger();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzkl(zzkf zzkfVar, String str, Object obj, boolean z10, byte[] bArr) {
        if (zzkfVar.zza != null) {
            this.zza = zzkfVar;
            this.zzb = str;
            this.zzg = obj;
            this.zzk = false;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0047, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004c, code lost:
    
        throw r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void zzb(final Context context) {
        if (zze == null && context != null) {
            Object obj = zzd;
            synchronized (obj) {
                try {
                    if (zze == null) {
                        synchronized (obj) {
                            zzkg zzkgVar = zze;
                            Context applicationContext = context.getApplicationContext();
                            if (applicationContext != null) {
                                context = applicationContext;
                            }
                            if (zzkgVar != null) {
                                if (zzkgVar.zza() != context) {
                                }
                            }
                            if (zzkgVar != null) {
                                zzjq.zzd();
                                zzkn.zzb();
                                zzjx.zzc();
                            }
                            zze = new zzjn(context, l.a(new k() { // from class: com.google.android.gms.internal.measurement.zzkk
                                @Override // k8.k
                                public final /* synthetic */ Object get() {
                                    int i10 = zzkl.zzc;
                                    return zzjy.zza(context);
                                }
                            }));
                            zzh.incrementAndGet();
                        }
                    }
                } finally {
                }
            }
        }
    }

    public static void zzc() {
        zzh.incrementAndGet();
    }

    abstract Object zza(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005b A[Catch: all -> 0x0047, TryCatch #0 {all -> 0x0047, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x001e, B:13:0x0034, B:16:0x0050, B:18:0x005b, B:20:0x0065, B:22:0x0088, B:24:0x0090, B:27:0x00b7, B:30:0x00bf, B:31:0x00c2, B:32:0x00c6, B:33:0x0099, B:35:0x009d, B:37:0x00ad, B:39:0x00b3, B:43:0x0076, B:46:0x00ca), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0099 A[Catch: all -> 0x0047, TryCatch #0 {all -> 0x0047, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x001e, B:13:0x0034, B:16:0x0050, B:18:0x005b, B:20:0x0065, B:22:0x0088, B:24:0x0090, B:27:0x00b7, B:30:0x00bf, B:31:0x00c2, B:32:0x00c6, B:33:0x0099, B:35:0x009d, B:37:0x00ad, B:39:0x00b3, B:43:0x0076, B:46:0x00ca), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0076 A[Catch: all -> 0x0047, TryCatch #0 {all -> 0x0047, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x001e, B:13:0x0034, B:16:0x0050, B:18:0x005b, B:20:0x0065, B:22:0x0088, B:24:0x0090, B:27:0x00b7, B:30:0x00bf, B:31:0x00c2, B:32:0x00c6, B:33:0x0099, B:35:0x009d, B:37:0x00ad, B:39:0x00b3, B:43:0x0076, B:46:0x00ca), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzd() {
        String str;
        boolean z10;
        Uri uri;
        zzju zza;
        Object obj;
        String zze2;
        Object zze3;
        int i10 = zzh.get();
        if (this.zzi < i10) {
            synchronized (this) {
                try {
                    if (this.zzi < i10) {
                        zzkg zzkgVar = zze;
                        k8.g a10 = k8.g.a();
                        Object obj2 = null;
                        if (zzkgVar != null && zzkgVar.zzb() != null) {
                            a10 = (k8.g) ((k) k8.h.i(zzkgVar.zzb())).get();
                            if (a10.c()) {
                                zzjs zzjsVar = (zzjs) a10.b();
                                zzkf zzkfVar = this.zza;
                                str = zzjsVar.zza(zzkfVar.zza, null, zzkfVar.zzc, this.zzb);
                                if (zzkgVar == null) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                k8.h.o(z10, "Must call PhenotypeFlagInitializer.maybeInit() first");
                                zzkf zzkfVar2 = this.zza;
                                uri = zzkfVar2.zza;
                                if (uri == null) {
                                    if (zzjz.zza(zzkgVar.zza(), uri)) {
                                        zza = zzjq.zza(zzkgVar.zza().getContentResolver(), uri, zzki.zza);
                                    } else {
                                        zza = null;
                                    }
                                } else {
                                    zza = zzkn.zza(zzkgVar.zza(), (String) k8.h.i(null), zzkh.zza);
                                }
                                if (zza == null && (zze3 = zza.zze(this.zzb)) != null) {
                                    obj = zza(zze3);
                                } else {
                                    obj = null;
                                }
                                if (obj == null) {
                                    if (!zzkfVar2.zzd && (zze2 = zzjx.zza(zzkgVar.zza()).zze(this.zzb)) != null) {
                                        obj2 = zza(zze2);
                                    }
                                    if (obj2 == null) {
                                        obj = this.zzg;
                                    } else {
                                        obj = obj2;
                                    }
                                }
                                if (a10.c()) {
                                    if (str == null) {
                                        obj = this.zzg;
                                    } else {
                                        obj = zza(str);
                                    }
                                }
                                this.zzj = obj;
                                this.zzi = i10;
                            }
                        }
                        str = null;
                        if (zzkgVar == null) {
                        }
                        k8.h.o(z10, "Must call PhenotypeFlagInitializer.maybeInit() first");
                        zzkf zzkfVar22 = this.zza;
                        uri = zzkfVar22.zza;
                        if (uri == null) {
                        }
                        if (zza == null) {
                        }
                        obj = null;
                        if (obj == null) {
                        }
                        if (a10.c()) {
                        }
                        this.zzj = obj;
                        this.zzi = i10;
                    }
                } finally {
                }
            }
        }
        return this.zzj;
    }
}
