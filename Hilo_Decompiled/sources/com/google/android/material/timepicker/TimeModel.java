package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final c f١٠٣٢٠a;

    /* renamed from: b, reason: collision with root package name */
    private final c f١٠٣٢١b;

    /* renamed from: c, reason: collision with root package name */
    final int f١٠٣٢٢c;

    /* renamed from: d, reason: collision with root package name */
    int f١٠٣٢٣d;

    /* renamed from: e, reason: collision with root package name */
    int f١٠٣٢٤e;

    /* renamed from: f, reason: collision with root package name */
    int f١٠٣٢٥f;

    /* renamed from: g, reason: collision with root package name */
    int f١٠٣٢٦g;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TimeModel[] newArray(int i10) {
            return new TimeModel[i10];
        }
    }

    public TimeModel(int i10, int i11, int i12, int i13) {
        this.f١٠٣٢٣d = i10;
        this.f١٠٣٢٤e = i11;
        this.f١٠٣٢٥f = i12;
        this.f١٠٣٢٢c = i13;
        this.f١٠٣٢٦g = c(i10);
        this.f١٠٣٢٠a = new c(59);
        this.f١٠٣٢١b = new c(i13 == 1 ? 23 : 12);
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return b(resources, charSequence, "%02d");
    }

    public static String b(Resources resources, CharSequence charSequence, String str) {
        try {
            return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static int c(int i10) {
        return i10 >= 12 ? 1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        if (this.f١٠٣٢٣d == timeModel.f١٠٣٢٣d && this.f١٠٣٢٤e == timeModel.f١٠٣٢٤e && this.f١٠٣٢٢c == timeModel.f١٠٣٢٢c && this.f١٠٣٢٥f == timeModel.f١٠٣٢٥f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f١٠٣٢٢c), Integer.valueOf(this.f١٠٣٢٣d), Integer.valueOf(this.f١٠٣٢٤e), Integer.valueOf(this.f١٠٣٢٥f)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f١٠٣٢٣d);
        parcel.writeInt(this.f١٠٣٢٤e);
        parcel.writeInt(this.f١٠٣٢٥f);
        parcel.writeInt(this.f١٠٣٢٢c);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
