package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ErrorConstant;
import anetwork.channel.NetworkEvent;
import anetwork.channel.statist.StatisticData;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DefaultFinishEvent implements Parcelable, NetworkEvent.FinishEvent {
    public static final Parcelable.Creator<DefaultFinishEvent> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    Object f٥٠٩٤a;

    /* renamed from: b, reason: collision with root package name */
    int f٥٠٩٥b;

    /* renamed from: c, reason: collision with root package name */
    String f٥٠٩٦c;

    /* renamed from: d, reason: collision with root package name */
    StatisticData f٥٠٩٧d;
    public final Request request;
    public final RequestStatistic rs;

    public DefaultFinishEvent(int i10) {
        this(i10, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DefaultFinishEvent a(Parcel parcel) {
        DefaultFinishEvent defaultFinishEvent = new DefaultFinishEvent(0);
        try {
            defaultFinishEvent.f٥٠٩٥b = parcel.readInt();
            defaultFinishEvent.f٥٠٩٦c = parcel.readString();
            defaultFinishEvent.f٥٠٩٧d = (StatisticData) parcel.readSerializable();
        } catch (Throwable unused) {
        }
        return defaultFinishEvent;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object getContext() {
        return this.f٥٠٩٤a;
    }

    @Override // anetwork.channel.NetworkEvent.FinishEvent
    public String getDesc() {
        return this.f٥٠٩٦c;
    }

    @Override // anetwork.channel.NetworkEvent.FinishEvent
    public int getHttpCode() {
        return this.f٥٠٩٥b;
    }

    @Override // anetwork.channel.NetworkEvent.FinishEvent
    public StatisticData getStatisticData() {
        return this.f٥٠٩٧d;
    }

    public void setContext(Object obj) {
        this.f٥٠٩٤a = obj;
    }

    public String toString() {
        return "DefaultFinishEvent [code=" + this.f٥٠٩٥b + ", desc=" + this.f٥٠٩٦c + ", context=" + this.f٥٠٩٤a + ", statisticData=" + this.f٥٠٩٧d + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f٥٠٩٥b);
        parcel.writeString(this.f٥٠٩٦c);
        StatisticData statisticData = this.f٥٠٩٧d;
        if (statisticData != null) {
            parcel.writeSerializable(statisticData);
        }
    }

    public DefaultFinishEvent(int i10, String str, RequestStatistic requestStatistic) {
        this(i10, str, null, requestStatistic);
    }

    public DefaultFinishEvent(int i10, String str, Request request) {
        this(i10, str, request, request != null ? request.f٤٨٤٤a : null);
    }

    private DefaultFinishEvent(int i10, String str, Request request, RequestStatistic requestStatistic) {
        this.f٥٠٩٧d = new StatisticData();
        this.f٥٠٩٥b = i10;
        this.f٥٠٩٦c = str == null ? ErrorConstant.getErrMsg(i10) : str;
        this.request = request;
        this.rs = requestStatistic;
    }
}
