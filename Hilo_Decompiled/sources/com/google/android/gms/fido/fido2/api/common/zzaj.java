package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.fido.zzgx;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzaj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        zzgx zzl;
        zzgx zzl2;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzgx zzgxVar = null;
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        int i10 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                if (fieldId != 2) {
                    if (fieldId != 3) {
                        if (fieldId != 4) {
                            SafeParcelReader.skipUnknownField(parcel, readHeader);
                        } else {
                            i10 = SafeParcelReader.readInt(parcel, readHeader);
                        }
                    } else {
                        bArr3 = SafeParcelReader.createByteArray(parcel, readHeader);
                    }
                } else {
                    bArr2 = SafeParcelReader.createByteArray(parcel, readHeader);
                }
            } else {
                bArr = SafeParcelReader.createByteArray(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        if (bArr == null) {
            zzl = null;
        } else {
            zzl = zzgx.zzl(bArr, 0, bArr.length);
        }
        if (bArr2 == null) {
            zzl2 = null;
        } else {
            zzl2 = zzgx.zzl(bArr2, 0, bArr2.length);
        }
        if (bArr3 != null) {
            zzgxVar = zzgx.zzl(bArr3, 0, bArr3.length);
        }
        return new zzai(zzl, zzl2, zzgxVar, i10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzai[i10];
    }
}
