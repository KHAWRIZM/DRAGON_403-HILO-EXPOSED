package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Calendar f٨٨٣١a;

    /* renamed from: b, reason: collision with root package name */
    final int f٨٨٣٢b;

    /* renamed from: c, reason: collision with root package name */
    final int f٨٨٣٣c;

    /* renamed from: d, reason: collision with root package name */
    final int f٨٨٣٤d;

    /* renamed from: e, reason: collision with root package name */
    final int f٨٨٣٥e;

    /* renamed from: f, reason: collision with root package name */
    final long f٨٨٣٦f;

    /* renamed from: g, reason: collision with root package name */
    private String f٨٨٣٧g;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Month createFromParcel(Parcel parcel) {
            return Month.c(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Month[] newArray(int i10) {
            return new Month[i10];
        }
    }

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar f10 = c0.f(calendar);
        this.f٨٨٣١a = f10;
        this.f٨٨٣٢b = f10.get(2);
        this.f٨٨٣٣c = f10.get(1);
        this.f٨٨٣٤d = f10.getMaximum(7);
        this.f٨٨٣٥e = f10.getActualMaximum(5);
        this.f٨٨٣٦f = f10.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Month c(int i10, int i11) {
        Calendar r10 = c0.r();
        r10.set(1, i10);
        r10.set(2, i11);
        return new Month(r10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Month d(long j10) {
        Calendar r10 = c0.r();
        r10.setTimeInMillis(j10);
        return new Month(r10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Month e() {
        return new Month(c0.p());
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Month month) {
        return this.f٨٨٣١a.compareTo(month.f٨٨٣١a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        if (this.f٨٨٣٢b == month.f٨٨٣٢b && this.f٨٨٣٣c == month.f٨٨٣٣c) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(int i10) {
        int i11 = this.f٨٨٣١a.get(7);
        if (i10 <= 0) {
            i10 = this.f٨٨٣١a.getFirstDayOfWeek();
        }
        int i12 = i11 - i10;
        if (i12 < 0) {
            return i12 + this.f٨٨٣٤d;
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long g(int i10) {
        Calendar f10 = c0.f(this.f٨٨٣١a);
        f10.set(5, i10);
        return f10.getTimeInMillis();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f٨٨٣٢b), Integer.valueOf(this.f٨٨٣٣c)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(long j10) {
        Calendar f10 = c0.f(this.f٨٨٣١a);
        f10.setTimeInMillis(j10);
        return f10.get(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j() {
        if (this.f٨٨٣٧g == null) {
            this.f٨٨٣٧g = j.l(this.f٨٨٣١a.getTimeInMillis());
        }
        return this.f٨٨٣٧g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long l() {
        return this.f٨٨٣١a.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month n(int i10) {
        Calendar f10 = c0.f(this.f٨٨٣١a);
        f10.add(2, i10);
        return new Month(f10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p(Month month) {
        if (this.f٨٨٣١a instanceof GregorianCalendar) {
            return ((month.f٨٨٣٣c - this.f٨٨٣٣c) * 12) + (month.f٨٨٣٢b - this.f٨٨٣٢b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f٨٨٣٣c);
        parcel.writeInt(this.f٨٨٣٢b);
    }
}
