package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkq;
import com.google.android.gms.internal.measurement.zzkr;
import java.io.IOException;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzkr<MessageType extends zzkr<MessageType, BuilderType>, BuilderType extends zzkq<MessageType, BuilderType>> implements zznl {
    protected int zza = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzce(Iterable iterable, List list) {
        zzkq.zzaU(iterable, list);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final zzlg zzcb() {
        try {
            int zzcn = zzcn();
            zzlg zzlgVar = zzlg.zzb;
            byte[] bArr = new byte[zzcn];
            int i10 = zzll.zzb;
            zzlj zzljVar = new zzlj(bArr, 0, zzcn);
            zzcB(zzljVar);
            return zzld.zza(zzljVar, bArr);
        } catch (IOException e10) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e10);
        }
    }

    public final byte[] zzcc() {
        try {
            int zzcn = zzcn();
            byte[] bArr = new byte[zzcn];
            int i10 = zzll.zzb;
            zzlj zzljVar = new zzlj(bArr, 0, zzcn);
            zzcB(zzljVar);
            zzljVar.zzE();
            return bArr;
        } catch (IOException e10) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzcd(zznw zznwVar) {
        throw null;
    }
}
