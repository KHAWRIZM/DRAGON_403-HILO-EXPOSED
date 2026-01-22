package com.coloros.ocs.base.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class CapabilityInfo implements Parcelable {
    public static final Parcelable.Creator<CapabilityInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private List f٧٦٠٠a;

    /* renamed from: b, reason: collision with root package name */
    private int f٧٦٠١b;

    /* renamed from: c, reason: collision with root package name */
    private AuthResult f٧٦٠٢c;

    /* renamed from: d, reason: collision with root package name */
    private IBinder f٧٦٠٣d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CapabilityInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
            return new CapabilityInfo[i10];
        }
    }

    protected CapabilityInfo(Parcel parcel) {
        this.f٧٦٠٠a = parcel.readArrayList(Feature.class.getClassLoader());
        this.f٧٦٠١b = parcel.readInt();
        this.f٧٦٠٢c = (AuthResult) parcel.readParcelable(AuthResult.class.getClassLoader());
        this.f٧٦٠٣d = parcel.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeList(this.f٧٦٠٠a);
        parcel.writeInt(this.f٧٦٠١b);
        parcel.writeParcelable(this.f٧٦٠٢c, 0);
        parcel.writeStrongBinder(this.f٧٦٠٣d);
    }
}
