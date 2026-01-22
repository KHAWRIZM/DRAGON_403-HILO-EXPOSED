package com.coloros.ocs.base.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import j5.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcelable parcelable;
        int readInt = parcel.readInt();
        int b10 = j5.a.b(parcel, readInt);
        int dataPosition = parcel.dataPosition();
        if ((readInt & 65535) == 20293) {
            int i10 = b10 + dataPosition;
            if (i10 >= dataPosition && i10 <= parcel.dataSize()) {
                int i11 = 0;
                String str = null;
                PendingIntent pendingIntent = null;
                int i12 = 0;
                while (parcel.dataPosition() < i10) {
                    int readInt2 = parcel.readInt();
                    int i13 = readInt2 & 65535;
                    if (i13 != 1) {
                        if (i13 != 2) {
                            if (i13 != 3) {
                                if (i13 != 1000) {
                                    parcel.setDataPosition(parcel.dataPosition() + j5.a.b(parcel, readInt2));
                                } else {
                                    i11 = j5.a.a(parcel, readInt2);
                                }
                            } else {
                                Parcelable.Creator creator = PendingIntent.CREATOR;
                                int b11 = j5.a.b(parcel, readInt2);
                                int dataPosition2 = parcel.dataPosition();
                                if (b11 == 0) {
                                    parcelable = null;
                                } else {
                                    parcelable = (Parcelable) creator.createFromParcel(parcel);
                                    parcel.setDataPosition(dataPosition2 + b11);
                                }
                                pendingIntent = (PendingIntent) parcelable;
                            }
                        } else {
                            int b12 = j5.a.b(parcel, readInt2);
                            int dataPosition3 = parcel.dataPosition();
                            if (b12 == 0) {
                                str = null;
                            } else {
                                String readString = parcel.readString();
                                parcel.setDataPosition(dataPosition3 + b12);
                                str = readString;
                            }
                        }
                    } else {
                        i12 = j5.a.a(parcel, readInt2);
                    }
                }
                if (parcel.dataPosition() == i10) {
                    return new Status(i11, i12, str, pendingIntent);
                }
                throw new a.C٠١٧٣a("Overread allowed size end=".concat(String.valueOf(i10)));
            }
            throw new a.C٠١٧٣a("Size read is invalid start=" + dataPosition + " end=" + i10);
        }
        throw new a.C٠١٧٣a("Expected object header. Got 0x" + Integer.toHexString(readInt));
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
        return new Status[i10];
    }
}
