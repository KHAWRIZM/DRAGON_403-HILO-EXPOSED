package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkq;
import com.google.android.gms.internal.measurement.zzkr;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzkq<MessageType extends zzkr<MessageType, BuilderType>, BuilderType extends zzkq<MessageType, BuilderType>> implements zznk {
    private static void zza(List list, int i10) {
        int size = list.size() - i10;
        StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 26);
        sb.append("Element at index ");
        sb.append(size);
        sb.append(" is null.");
        String sb2 = sb.toString();
        int size2 = list.size();
        while (true) {
            size2--;
            if (size2 >= i10) {
                list.remove(size2);
            } else {
                throw new NullPointerException(sb2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzaU(Iterable iterable, List list) {
        byte[] bArr = zzmo.zzb;
        iterable.getClass();
        if (iterable instanceof zzmw) {
            List zza = ((zzmw) iterable).zza();
            zzmw zzmwVar = (zzmw) list;
            int size = list.size();
            for (Object obj : zza) {
                if (obj == null) {
                    int size2 = zzmwVar.size() - size;
                    StringBuilder sb = new StringBuilder(String.valueOf(size2).length() + 26);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    int size3 = zzmwVar.size();
                    while (true) {
                        size3--;
                        if (size3 < size) {
                            break;
                        } else {
                            zzmwVar.remove(size3);
                        }
                    }
                    throw new NullPointerException(sb2);
                }
                if (obj instanceof zzlg) {
                    zzmwVar.zzb();
                } else if (obj instanceof byte[]) {
                    byte[] bArr2 = (byte[]) obj;
                    zzlg.zzh(bArr2, 0, bArr2.length);
                    zzmwVar.zzb();
                } else {
                    zzmwVar.add((String) obj);
                }
            }
            return;
        }
        if (!(iterable instanceof zzns)) {
            if (iterable instanceof Collection) {
                int size4 = ((Collection) iterable).size();
                if (list instanceof ArrayList) {
                    ((ArrayList) list).ensureCapacity(list.size() + size4);
                } else if (list instanceof zznu) {
                    ((zznu) list).zze(list.size() + size4);
                }
            }
            int size5 = list.size();
            if ((iterable instanceof List) && (iterable instanceof RandomAccess)) {
                List list2 = (List) iterable;
                int size6 = list2.size();
                for (int i10 = 0; i10 < size6; i10++) {
                    Object obj2 = list2.get(i10);
                    if (obj2 == null) {
                        zza(list, size5);
                    }
                    list.add(obj2);
                }
                return;
            }
            for (Object obj3 : iterable) {
                if (obj3 == null) {
                    zza(list, size5);
                }
                list.add(obj3);
            }
            return;
        }
        list.addAll((Collection) iterable);
    }

    @Override // 
    public abstract zzkq zzaR();

    public zzkq zzaS(byte[] bArr, int i10, int i11) throws zzmq {
        throw null;
    }

    public zzkq zzaT(byte[] bArr, int i10, int i11, zzlq zzlqVar) throws zzmq {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zznk
    public final /* synthetic */ zznk zzaV(byte[] bArr, zzlq zzlqVar) throws zzmq {
        return zzaT(bArr, 0, bArr.length, zzlqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznk
    public final /* synthetic */ zznk zzaW(byte[] bArr) throws zzmq {
        return zzaS(bArr, 0, bArr.length);
    }
}
