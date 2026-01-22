package com.coloros.ocs.base.common;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class AuthResult implements Parcelable {
    public static final Parcelable.Creator<AuthResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f٧٥٩٥a;

    /* renamed from: b, reason: collision with root package name */
    private int f٧٥٩٦b;

    /* renamed from: c, reason: collision with root package name */
    private int f٧٥٩٧c;

    /* renamed from: d, reason: collision with root package name */
    private int f٧٥٩٨d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f٧٥٩٩e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AuthResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
            return new AuthResult[i10];
        }
    }

    protected AuthResult(Parcel parcel) {
        this.f٧٥٩٥a = parcel.readString();
        this.f٧٥٩٦b = parcel.readInt();
        this.f٧٥٩٧c = parcel.readInt();
        this.f٧٥٩٨d = parcel.readInt();
        this.f٧٥٩٩e = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f٧٥٩٥a);
        parcel.writeInt(this.f٧٥٩٦b);
        parcel.writeInt(this.f٧٥٩٧c);
        parcel.writeInt(this.f٧٥٩٨d);
        parcel.writeByteArray(this.f٧٥٩٩e);
    }
}
