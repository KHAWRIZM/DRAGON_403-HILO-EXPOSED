package com.aliyun.ams.emas.push.notification;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CPushMessage implements Parcelable {
    public static final Parcelable.Creator<CPushMessage> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f٦٩٠٧a;

    /* renamed from: b, reason: collision with root package name */
    private String f٦٩٠٨b;

    /* renamed from: c, reason: collision with root package name */
    private String f٦٩٠٩c;

    /* renamed from: d, reason: collision with root package name */
    private String f٦٩١٠d;

    /* renamed from: e, reason: collision with root package name */
    private String f٦٩١١e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ CPushMessage(Parcel parcel, a aVar) {
        this(parcel);
    }

    public String a() {
        return this.f٦٩٠٨b;
    }

    public String b() {
        return this.f٦٩١٠d;
    }

    public String c() {
        return this.f٦٩٠٧a;
    }

    public String d() {
        return this.f٦٩٠٩c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f٦٩١١e;
    }

    public void f(String str) {
        this.f٦٩٠٨b = str;
    }

    public void g(String str) {
        this.f٦٩١٠d = str;
    }

    public void i(String str) {
        this.f٦٩٠٧a = str;
    }

    public void j(String str) {
        this.f٦٩٠٩c = str;
    }

    public void l(String str) {
        this.f٦٩١١e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f٦٩٠٨b);
        parcel.writeString(this.f٦٩٠٧a);
        parcel.writeString(this.f٦٩٠٩c);
        parcel.writeString(this.f٦٩١٠d);
        parcel.writeString(this.f٦٩١١e);
    }

    public CPushMessage() {
    }

    private CPushMessage(Parcel parcel) {
        this.f٦٩٠٨b = parcel.readString();
        this.f٦٩٠٧a = parcel.readString();
        this.f٦٩٠٩c = parcel.readString();
        this.f٦٩١٠d = parcel.readString();
        this.f٦٩١١e = parcel.readString();
    }
}
