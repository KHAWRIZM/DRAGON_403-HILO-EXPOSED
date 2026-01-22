package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anetwork.channel.NetworkEvent;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DefaultProgressEvent implements Parcelable, NetworkEvent.ProgressEvent {
    public static final Parcelable.Creator<DefaultProgressEvent> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    int f٥٠٩٨a;

    /* renamed from: b, reason: collision with root package name */
    int f٥٠٩٩b;

    /* renamed from: c, reason: collision with root package name */
    int f٥١٠٠c;

    /* renamed from: d, reason: collision with root package name */
    Object f٥١٠١d;

    /* renamed from: e, reason: collision with root package name */
    byte[] f٥١٠٢e;

    public DefaultProgressEvent() {
    }

    public static DefaultProgressEvent readFromParcel(Parcel parcel) {
        DefaultProgressEvent defaultProgressEvent = new DefaultProgressEvent();
        try {
            defaultProgressEvent.f٥٠٩٨a = parcel.readInt();
            defaultProgressEvent.f٥٠٩٩b = parcel.readInt();
            defaultProgressEvent.f٥١٠٠c = parcel.readInt();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                parcel.readByteArray(bArr);
                defaultProgressEvent.f٥١٠٢e = bArr;
            }
        } catch (Exception unused) {
        }
        return defaultProgressEvent;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // anetwork.channel.NetworkEvent.ProgressEvent
    public byte[] getBytedata() {
        return this.f٥١٠٢e;
    }

    public Object getContext() {
        return this.f٥١٠١d;
    }

    @Override // anetwork.channel.NetworkEvent.ProgressEvent
    public String getDesc() {
        return "";
    }

    @Override // anetwork.channel.NetworkEvent.ProgressEvent
    public int getIndex() {
        return this.f٥٠٩٨a;
    }

    @Override // anetwork.channel.NetworkEvent.ProgressEvent
    public int getSize() {
        return this.f٥٠٩٩b;
    }

    @Override // anetwork.channel.NetworkEvent.ProgressEvent
    public int getTotal() {
        return this.f٥١٠٠c;
    }

    public void setContext(Object obj) {
        this.f٥١٠١d = obj;
    }

    public String toString() {
        return "DefaultProgressEvent [index=" + this.f٥٠٩٨a + ", size=" + this.f٥٠٩٩b + ", total=" + this.f٥١٠٠c + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int i11;
        parcel.writeInt(this.f٥٠٩٨a);
        parcel.writeInt(this.f٥٠٩٩b);
        parcel.writeInt(this.f٥١٠٠c);
        byte[] bArr = this.f٥١٠٢e;
        if (bArr != null) {
            i11 = bArr.length;
        } else {
            i11 = 0;
        }
        parcel.writeInt(i11);
        parcel.writeByteArray(this.f٥١٠٢e);
    }

    public DefaultProgressEvent(int i10, int i11, int i12, byte[] bArr) {
        this.f٥٠٩٨a = i10;
        this.f٥٠٩٩b = i11;
        this.f٥١٠٠c = i12;
        this.f٥١٠٢e = bArr;
    }
}
