package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzlz implements zznj {
    private static final zzlz zza = new zzlz();

    private zzlz() {
    }

    public static zzlz zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zznj
    public final boolean zzb(Class cls) {
        return zzme.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.zznj
    public final zzni zzc(Class cls) {
        if (zzme.class.isAssignableFrom(cls)) {
            try {
                return (zzni) zzme.zzco(cls.asSubclass(zzme.class)).zzl(3, null, null);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e10);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
    }
}
