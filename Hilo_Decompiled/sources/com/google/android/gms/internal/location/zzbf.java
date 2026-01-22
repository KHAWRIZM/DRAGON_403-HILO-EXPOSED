package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzbf implements Parcelable.Creator<zzbe> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbe createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        double d10 = 0.0d;
        double d11 = 0.0d;
        long j10 = 0;
        int i10 = 0;
        short s10 = 0;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        int i11 = 0;
        int i12 = -1;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 2:
                    j10 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 3:
                    s10 = SafeParcelReader.readShort(parcel, readHeader);
                    break;
                case 4:
                    d10 = SafeParcelReader.readDouble(parcel, readHeader);
                    break;
                case 5:
                    d11 = SafeParcelReader.readDouble(parcel, readHeader);
                    break;
                case 6:
                    f10 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 7:
                    i10 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 8:
                    i11 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 9:
                    i12 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzbe(str, i10, s10, d10, d11, f10, j10, i11, i12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbe[] newArray(int i10) {
        return new zzbe[i10];
    }
}
