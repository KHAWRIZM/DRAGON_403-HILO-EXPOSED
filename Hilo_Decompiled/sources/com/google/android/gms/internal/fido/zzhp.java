package com.google.android.gms.internal.fido;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzhp implements Comparable {
    private final zzhp zzc(Class cls) throws zzho {
        if (cls.isInstance(this)) {
            return (zzhp) cls.cast(this);
        }
        throw new zzho("Expected a " + cls.getName() + " value, but got " + getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte b10) {
        return (b10 >> 5) & 7;
    }

    public static zzhk zzg(long j10) {
        return new zzhk(j10);
    }

    public static zzhn zzi(String str) {
        return new zzhn(str);
    }

    public static zzhp zzj(byte... bArr) throws zzhj {
        bArr.getClass();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Arrays.copyOf(bArr, bArr.length));
        return zzhq.zza(byteArrayInputStream, new zzhs(byteArrayInputStream));
    }

    public static zzhp zzk(InputStream inputStream) throws zzhj {
        return zzhq.zza(inputStream, new zzhs(inputStream));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int zza();

    /* JADX INFO: Access modifiers changed from: protected */
    public int zzb() {
        return 0;
    }

    public final zzhi zze() throws zzho {
        return (zzhi) zzc(zzhi.class);
    }

    public final zzhk zzf() throws zzho {
        return (zzhk) zzc(zzhk.class);
    }

    public final zzhm zzh() throws zzho {
        return (zzhm) zzc(zzhm.class);
    }
}
