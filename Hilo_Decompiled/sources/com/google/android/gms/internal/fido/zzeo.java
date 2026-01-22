package com.google.android.gms.internal.fido;

import android.os.Build;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.text.Typography;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzeo extends zzei {
    static final boolean zza;
    static final boolean zzb;
    static final boolean zzc;
    private static final AtomicReference zzd;
    private static final AtomicLong zze;
    private static final ConcurrentLinkedQueue zzf;
    private volatile zzdp zzg;

    static {
        boolean z10;
        boolean z11;
        String str = Build.FINGERPRINT;
        boolean z12 = false;
        if (str == null || "robolectric".equals(str)) {
            z10 = true;
        } else {
            z10 = false;
        }
        zza = z10;
        String str2 = Build.HARDWARE;
        if ("goldfish".equals(str2) || "ranchu".equals(str2)) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzb = z11;
        String str3 = Build.TYPE;
        if ("eng".equals(str3) || "userdebug".equals(str3)) {
            z12 = true;
        }
        zzc = z12;
        zzd = new AtomicReference();
        zze = new AtomicLong();
        zzf = new ConcurrentLinkedQueue();
    }

    private zzeo(String str) {
        super(str);
        if (!zza && !zzb) {
            if (zzc) {
                this.zzg = zzeu.zzc().zzb(false).zza(zza());
                return;
            } else {
                this.zzg = null;
                return;
            }
        }
        this.zzg = new zzej().zza(zza());
    }

    public static zzdp zzb(String str) {
        AtomicReference atomicReference = zzd;
        if (atomicReference.get() != null) {
            return ((zzek) atomicReference.get()).zza(str);
        }
        int length = str.length();
        while (true) {
            length--;
            if (length >= 0) {
                char charAt = str.charAt(length);
                if (charAt == '$') {
                    str = str.replace(Typography.dollar, '.');
                    break;
                }
                if (charAt == '.') {
                    break;
                }
            } else {
                break;
            }
        }
        zzeo zzeoVar = new zzeo(str);
        zzem.zza.offer(zzeoVar);
        if (zzd.get() != null) {
            while (true) {
                zzeo zzeoVar2 = (zzeo) zzem.zza.poll();
                if (zzeoVar2 == null) {
                    break;
                }
                zzeoVar2.zzg = ((zzek) zzd.get()).zza(zzeoVar2.zza());
            }
            if (((zzen) zzf.poll()) != null) {
                zze.getAndDecrement();
                throw null;
            }
        }
        return zzeoVar;
    }
}
