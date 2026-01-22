package com.google.android.gms.internal.common;

import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class zzae extends zzaf {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(int i10) {
    }

    public final zzae zza(Object obj) {
        int i10;
        obj.getClass();
        int length = this.zza.length;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        if (i12 >= 0) {
            if (i12 <= length) {
                i10 = length;
            } else {
                i10 = (length >> 1) + length + 1;
                if (i10 < i12) {
                    int highestOneBit = Integer.highestOneBit(i11);
                    i10 = highestOneBit + highestOneBit;
                }
                if (i10 < 0) {
                    i10 = Integer.MAX_VALUE;
                }
            }
            if (i10 > length || this.zzc) {
                this.zza = Arrays.copyOf(this.zza, i10);
                this.zzc = false;
            }
            Object[] objArr = this.zza;
            int i13 = this.zzb;
            this.zzb = i13 + 1;
            objArr[i13] = obj;
            return this;
        }
        throw new IllegalArgumentException("cannot store more than MAX_VALUE elements");
    }
}
