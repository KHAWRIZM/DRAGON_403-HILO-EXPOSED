package com.coloros.ocs.base.common;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class Feature implements Parcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f٧٦٠٤a;

    /* renamed from: b, reason: collision with root package name */
    private long f٧٦٠٥b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Feature(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
            return new Feature[i10];
        }
    }

    protected Feature(Parcel parcel) {
        this.f٧٦٠٤a = parcel.readString();
        this.f٧٦٠٥b = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f٧٦٠٤a);
        parcel.writeLong(this.f٧٦٠٥b);
    }
}
