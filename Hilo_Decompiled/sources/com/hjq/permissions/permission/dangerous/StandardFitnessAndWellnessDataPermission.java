package com.hjq.permissions.permission.dangerous;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class StandardFitnessAndWellnessDataPermission extends HealthDataBasePermission {
    public static final Parcelable.Creator<StandardFitnessAndWellnessDataPermission> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final String f١٢٠١١a;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٢٠١٢b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StandardFitnessAndWellnessDataPermission createFromParcel(Parcel parcel) {
            return new StandardFitnessAndWellnessDataPermission(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public StandardFitnessAndWellnessDataPermission[] newArray(int i10) {
            return new StandardFitnessAndWellnessDataPermission[i10];
        }
    }

    /* synthetic */ StandardFitnessAndWellnessDataPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return this.f١٢٠١٢b;
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f١٢٠١١a);
        parcel.writeInt(this.f١٢٠١٢b);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return this.f١٢٠١١a;
    }

    public StandardFitnessAndWellnessDataPermission(String str, int i10) {
        this.f١٢٠١١a = str;
        this.f١٢٠١٢b = i10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private StandardFitnessAndWellnessDataPermission(Parcel parcel) {
        this(r0, parcel.readInt());
        String readString = parcel.readString();
        Objects.requireNonNull(readString);
    }
}
