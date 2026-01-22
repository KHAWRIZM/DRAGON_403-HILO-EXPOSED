package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Month f٨٨٠٥a;

    /* renamed from: b, reason: collision with root package name */
    private final Month f٨٨٠٦b;

    /* renamed from: c, reason: collision with root package name */
    private final DateValidator f٨٨٠٧c;

    /* renamed from: d, reason: collision with root package name */
    private Month f٨٨٠٨d;

    /* renamed from: e, reason: collision with root package name */
    private final int f٨٨٠٩e;

    /* renamed from: f, reason: collision with root package name */
    private final int f٨٨١٠f;

    /* renamed from: g, reason: collision with root package name */
    private final int f٨٨١١g;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface DateValidator extends Parcelable {
        boolean w(long j10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), parcel.readInt(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints[] newArray(int i10) {
            return new CalendarConstraints[i10];
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b {

        /* renamed from: f, reason: collision with root package name */
        static final long f٨٨١٢f = c0.a(Month.c(1900, 0).f٨٨٣٦f);

        /* renamed from: g, reason: collision with root package name */
        static final long f٨٨١٣g = c0.a(Month.c(2100, 11).f٨٨٣٦f);

        /* renamed from: a, reason: collision with root package name */
        private long f٨٨١٤a;

        /* renamed from: b, reason: collision with root package name */
        private long f٨٨١٥b;

        /* renamed from: c, reason: collision with root package name */
        private Long f٨٨١٦c;

        /* renamed from: d, reason: collision with root package name */
        private int f٨٨١٧d;

        /* renamed from: e, reason: collision with root package name */
        private DateValidator f٨٨١٨e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(CalendarConstraints calendarConstraints) {
            this.f٨٨١٤a = f٨٨١٢f;
            this.f٨٨١٥b = f٨٨١٣g;
            this.f٨٨١٨e = DateValidatorPointForward.a(Long.MIN_VALUE);
            this.f٨٨١٤a = calendarConstraints.f٨٨٠٥a.f٨٨٣٦f;
            this.f٨٨١٥b = calendarConstraints.f٨٨٠٦b.f٨٨٣٦f;
            this.f٨٨١٦c = Long.valueOf(calendarConstraints.f٨٨٠٨d.f٨٨٣٦f);
            this.f٨٨١٧d = calendarConstraints.f٨٨٠٩e;
            this.f٨٨١٨e = calendarConstraints.f٨٨٠٧c;
        }

        public CalendarConstraints a() {
            Month d10;
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f٨٨١٨e);
            Month d11 = Month.d(this.f٨٨١٤a);
            Month d12 = Month.d(this.f٨٨١٥b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l10 = this.f٨٨١٦c;
            if (l10 == null) {
                d10 = null;
            } else {
                d10 = Month.d(l10.longValue());
            }
            return new CalendarConstraints(d11, d12, dateValidator, d10, this.f٨٨١٧d, null);
        }

        public b b(long j10) {
            this.f٨٨١٦c = Long.valueOf(j10);
            return this;
        }
    }

    /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i10, a aVar) {
        this(month, month2, dateValidator, month3, i10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        if (this.f٨٨٠٥a.equals(calendarConstraints.f٨٨٠٥a) && this.f٨٨٠٦b.equals(calendarConstraints.f٨٨٠٦b) && androidx.core.util.f.a(this.f٨٨٠٨d, calendarConstraints.f٨٨٠٨d) && this.f٨٨٠٩e == calendarConstraints.f٨٨٠٩e && this.f٨٨٠٧c.equals(calendarConstraints.f٨٨٠٧c)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month f(Month month) {
        if (month.compareTo(this.f٨٨٠٥a) < 0) {
            return this.f٨٨٠٥a;
        }
        if (month.compareTo(this.f٨٨٠٦b) > 0) {
            return this.f٨٨٠٦b;
        }
        return month;
    }

    public DateValidator g() {
        return this.f٨٨٠٧c;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f٨٨٠٥a, this.f٨٨٠٦b, this.f٨٨٠٨d, Integer.valueOf(this.f٨٨٠٩e), this.f٨٨٠٧c});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month i() {
        return this.f٨٨٠٦b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f٨٨٠٩e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f٨٨١١g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month n() {
        return this.f٨٨٠٨d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month p() {
        return this.f٨٨٠٥a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        return this.f٨٨١٠f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v(long j10) {
        if (this.f٨٨٠٥a.g(1) <= j10) {
            Month month = this.f٨٨٠٦b;
            if (j10 <= month.g(month.f٨٨٣٥e)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f٨٨٠٥a, 0);
        parcel.writeParcelable(this.f٨٨٠٦b, 0);
        parcel.writeParcelable(this.f٨٨٠٨d, 0);
        parcel.writeParcelable(this.f٨٨٠٧c, 0);
        parcel.writeInt(this.f٨٨٠٩e);
    }

    private CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i10) {
        Objects.requireNonNull(month, "start cannot be null");
        Objects.requireNonNull(month2, "end cannot be null");
        Objects.requireNonNull(dateValidator, "validator cannot be null");
        this.f٨٨٠٥a = month;
        this.f٨٨٠٦b = month2;
        this.f٨٨٠٨d = month3;
        this.f٨٨٠٩e = i10;
        this.f٨٨٠٧c = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i10 >= 0 && i10 <= c0.r().getMaximum(7)) {
            this.f٨٨١١g = month.p(month2) + 1;
            this.f٨٨١٠f = (month2.f٨٨٣٣c - month.f٨٨٣٣c) + 1;
            return;
        }
        throw new IllegalArgumentException("firstDayOfWeek is not valid");
    }
}
