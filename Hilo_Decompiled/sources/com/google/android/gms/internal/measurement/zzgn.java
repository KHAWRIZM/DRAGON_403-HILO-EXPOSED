package com.google.android.gms.internal.measurement;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzgn extends zzme implements zznm {
    private static final zzgn zzd;
    private zzmn zzb = zzme.zzcv();

    static {
        zzgn zzgnVar = new zzgn();
        zzd = zzgnVar;
        zzme.zzcp(zzgn.class, zzgnVar);
    }

    private zzgn() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 != 0) {
            if (i11 != 2) {
                if (i11 != 3) {
                    byte[] bArr = null;
                    if (i11 != 4) {
                        if (i11 == 5) {
                            return zzd;
                        }
                        throw null;
                    }
                    return new zzgm(bArr);
                }
                return new zzgn();
            }
            return zzme.zzcq(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzb"});
        }
        return (byte) 1;
    }
}
