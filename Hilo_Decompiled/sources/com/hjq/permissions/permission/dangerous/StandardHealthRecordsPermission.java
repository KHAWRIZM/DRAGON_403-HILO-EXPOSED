package com.hjq.permissions.permission.dangerous;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class StandardHealthRecordsPermission extends HealthDataBasePermission {
    public static final Parcelable.Creator<StandardHealthRecordsPermission> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final String f١٢٠١٣a;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٢٠١٤b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StandardHealthRecordsPermission createFromParcel(Parcel parcel) {
            return new StandardHealthRecordsPermission(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public StandardHealthRecordsPermission[] newArray(int i10) {
            return new StandardHealthRecordsPermission[i10];
        }
    }

    /* synthetic */ StandardHealthRecordsPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return this.f١٢٠١٤b;
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f١٢٠١٣a);
        parcel.writeInt(this.f١٢٠١٤b);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return this.f١٢٠١٣a;
    }

    public StandardHealthRecordsPermission(String str, int i10) {
        this.f١٢٠١٣a = str;
        this.f١٢٠١٤b = i10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private StandardHealthRecordsPermission(Parcel parcel) {
        this(r0, parcel.readInt());
        String readString = parcel.readString();
        Objects.requireNonNull(readString);
    }
}
