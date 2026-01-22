package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.Response;
import anetwork.channel.statist.StatisticData;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class NetworkResponse implements Parcelable, Response {
    public static final Parcelable.Creator<NetworkResponse> CREATOR = new c();

    /* renamed from: a, reason: collision with root package name */
    int f٥١٠٤a;

    /* renamed from: b, reason: collision with root package name */
    byte[] f٥١٠٥b;

    /* renamed from: c, reason: collision with root package name */
    private String f٥١٠٦c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, List<String>> f٥١٠٧d;

    /* renamed from: e, reason: collision with root package name */
    private Throwable f٥١٠٨e;

    /* renamed from: f, reason: collision with root package name */
    private StatisticData f٥١٠٩f;

    public NetworkResponse() {
    }

    public static NetworkResponse readFromParcel(Parcel parcel) {
        NetworkResponse networkResponse = new NetworkResponse();
        try {
            networkResponse.f٥١٠٤a = parcel.readInt();
            networkResponse.f٥١٠٦c = parcel.readString();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                networkResponse.f٥١٠٥b = bArr;
                parcel.readByteArray(bArr);
            }
            networkResponse.f٥١٠٧d = parcel.readHashMap(NetworkResponse.class.getClassLoader());
            try {
                networkResponse.f٥١٠٩f = (StatisticData) parcel.readSerializable();
            } catch (Throwable unused) {
                ALog.i("anet.NetworkResponse", "[readFromParcel] source.readSerializable() error", null, new Object[0]);
            }
        } catch (Exception e10) {
            ALog.w("anet.NetworkResponse", "[readFromParcel]", null, e10, new Object[0]);
        }
        return networkResponse;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // anetwork.channel.Response
    public byte[] getBytedata() {
        return this.f٥١٠٥b;
    }

    @Override // anetwork.channel.Response
    public Map<String, List<String>> getConnHeadFields() {
        return this.f٥١٠٧d;
    }

    @Override // anetwork.channel.Response
    public String getDesc() {
        return this.f٥١٠٦c;
    }

    @Override // anetwork.channel.Response
    public Throwable getError() {
        return this.f٥١٠٨e;
    }

    @Override // anetwork.channel.Response
    public StatisticData getStatisticData() {
        return this.f٥١٠٩f;
    }

    @Override // anetwork.channel.Response
    public int getStatusCode() {
        return this.f٥١٠٤a;
    }

    public void setBytedata(byte[] bArr) {
        this.f٥١٠٥b = bArr;
    }

    public void setConnHeadFields(Map<String, List<String>> map) {
        this.f٥١٠٧d = map;
    }

    public void setDesc(String str) {
        this.f٥١٠٦c = str;
    }

    public void setError(Throwable th) {
        this.f٥١٠٨e = th;
    }

    public void setStatisticData(StatisticData statisticData) {
        this.f٥١٠٩f = statisticData;
    }

    public void setStatusCode(int i10) {
        this.f٥١٠٤a = i10;
        this.f٥١٠٦c = ErrorConstant.getErrMsg(i10);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("NetworkResponse [");
        sb.append("statusCode=");
        sb.append(this.f٥١٠٤a);
        sb.append(", desc=");
        sb.append(this.f٥١٠٦c);
        sb.append(", connHeadFields=");
        sb.append(this.f٥١٠٧d);
        sb.append(", bytedata=");
        byte[] bArr = this.f٥١٠٥b;
        if (bArr != null) {
            str = new String(bArr);
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", error=");
        sb.append(this.f٥١٠٨e);
        sb.append(", statisticData=");
        sb.append(this.f٥١٠٩f);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int i11;
        parcel.writeInt(this.f٥١٠٤a);
        parcel.writeString(this.f٥١٠٦c);
        byte[] bArr = this.f٥١٠٥b;
        if (bArr != null) {
            i11 = bArr.length;
        } else {
            i11 = 0;
        }
        parcel.writeInt(i11);
        if (i11 > 0) {
            parcel.writeByteArray(this.f٥١٠٥b);
        }
        parcel.writeMap(this.f٥١٠٧d);
        StatisticData statisticData = this.f٥١٠٩f;
        if (statisticData != null) {
            parcel.writeSerializable(statisticData);
        }
    }

    public NetworkResponse(int i10) {
        this.f٥١٠٤a = i10;
        this.f٥١٠٦c = ErrorConstant.getErrMsg(i10);
    }
}
