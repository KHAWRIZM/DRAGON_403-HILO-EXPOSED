package anet.channel.entity;

import anet.channel.strategy.IConnStrategy;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final IConnStrategy f٤٧٦٣a;

    /* renamed from: b, reason: collision with root package name */
    public int f٤٧٦٤b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f٤٧٦٥c = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f٤٧٦٦d;

    /* renamed from: e, reason: collision with root package name */
    private String f٤٧٦٧e;

    public a(String str, String str2, IConnStrategy iConnStrategy) {
        this.f٤٧٦٣a = iConnStrategy;
        this.f٤٧٦٦d = str;
        this.f٤٧٦٧e = str2;
    }

    public String a() {
        IConnStrategy iConnStrategy = this.f٤٧٦٣a;
        if (iConnStrategy != null) {
            return iConnStrategy.getIp();
        }
        return null;
    }

    public int b() {
        IConnStrategy iConnStrategy = this.f٤٧٦٣a;
        if (iConnStrategy != null) {
            return iConnStrategy.getPort();
        }
        return 0;
    }

    public ConnType c() {
        IConnStrategy iConnStrategy = this.f٤٧٦٣a;
        if (iConnStrategy != null) {
            return ConnType.valueOf(iConnStrategy.getProtocol());
        }
        return ConnType.HTTP;
    }

    public int d() {
        IConnStrategy iConnStrategy = this.f٤٧٦٣a;
        if (iConnStrategy == null || iConnStrategy.getConnectionTimeout() == 0) {
            return 20000;
        }
        return this.f٤٧٦٣a.getConnectionTimeout();
    }

    public int e() {
        IConnStrategy iConnStrategy = this.f٤٧٦٣a;
        if (iConnStrategy == null || iConnStrategy.getReadTimeout() == 0) {
            return 20000;
        }
        return this.f٤٧٦٣a.getReadTimeout();
    }

    public String f() {
        return this.f٤٧٦٦d;
    }

    public int g() {
        IConnStrategy iConnStrategy = this.f٤٧٦٣a;
        if (iConnStrategy != null) {
            return iConnStrategy.getHeartbeat();
        }
        return 45000;
    }

    public String h() {
        return this.f٤٧٦٧e;
    }

    public String toString() {
        return "ConnInfo [ip=" + a() + ",port=" + b() + ",type=" + c() + ",hb" + g() + "]";
    }
}
