package com.coloros.ocs.base.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.coloros.ocs.base.internal.safeparcel.AbstractSafeParcelable;
import h5.b;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class Status extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f٧٦٠٦a;

    /* renamed from: b, reason: collision with root package name */
    private int f٧٦٠٧b;

    /* renamed from: c, reason: collision with root package name */
    private String f٧٦٠٨c;

    /* renamed from: d, reason: collision with root package name */
    private PendingIntent f٧٦٠٩d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Status(int i10, int i11, String str, PendingIntent pendingIntent) {
        this.f٧٦٠٦a = i10;
        this.f٧٦٠٧b = i11;
        this.f٧٦٠٨c = str;
        this.f٧٦٠٩d = pendingIntent;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Status) {
            Status status = (Status) obj;
            if (this.f٧٦٠٦a == status.f٧٦٠٦a && this.f٧٦٠٧b == status.f٧٦٠٧b && b.b(this.f٧٦٠٨c, status.f٧٦٠٨c) && b.b(this.f٧٦٠٩d, status.f٧٦٠٩d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f٧٦٠٦a), Integer.valueOf(this.f٧٦٠٧b), this.f٧٦٠٨c, this.f٧٦٠٩d});
    }

    public String toString() {
        b.a a10 = b.a(this);
        String str = this.f٧٦٠٨c;
        if (str == null) {
            str = i5.a.a(this.f٧٦٠٧b);
        }
        return a10.a("statusCode", str).a("resolution", this.f٧٦٠٩d).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int c10 = j5.b.c(parcel, 20293);
        j5.b.b(parcel, 1, this.f٧٦٠٧b);
        j5.b.b(parcel, 1000, this.f٧٦٠٦a);
        String str = this.f٧٦٠٨c;
        if (str != null) {
            int c11 = j5.b.c(parcel, 2);
            parcel.writeString(str);
            j5.b.a(parcel, c11);
        }
        PendingIntent pendingIntent = this.f٧٦٠٩d;
        if (pendingIntent != null) {
            int c12 = j5.b.c(parcel, 3);
            pendingIntent.writeToParcel(parcel, i10);
            j5.b.a(parcel, c12);
        }
        j5.b.a(parcel, c10);
    }
}
