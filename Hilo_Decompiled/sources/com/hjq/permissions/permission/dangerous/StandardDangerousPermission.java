package com.hjq.permissions.permission.dangerous;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.common.DangerousPermission;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class StandardDangerousPermission extends DangerousPermission {
    public static final Parcelable.Creator<StandardDangerousPermission> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final String f١٢٠٠٨a;

    /* renamed from: b, reason: collision with root package name */
    private final String f١٢٠٠٩b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٢٠١٠c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StandardDangerousPermission createFromParcel(Parcel parcel) {
            return new StandardDangerousPermission(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public StandardDangerousPermission[] newArray(int i10) {
            return new StandardDangerousPermission[i10];
        }
    }

    /* synthetic */ StandardDangerousPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return this.f١٢٠١٠c;
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public String k(Context context) {
        return this.f١٢٠٠٩b;
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f١٢٠٠٨a);
        parcel.writeString(this.f١٢٠٠٩b);
        parcel.writeInt(this.f١٢٠١٠c);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return this.f١٢٠٠٨a;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private StandardDangerousPermission(Parcel parcel) {
        this(r0, parcel.readString(), parcel.readInt());
        String readString = parcel.readString();
        Objects.requireNonNull(readString);
    }

    public StandardDangerousPermission(String str, int i10) {
        this(str, null, i10);
    }

    public StandardDangerousPermission(String str, String str2, int i10) {
        this.f١٢٠٠٨a = str;
        this.f١٢٠٠٩b = str2;
        this.f١٢٠١٠c = i10;
    }
}
