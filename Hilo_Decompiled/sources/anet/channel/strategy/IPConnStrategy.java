package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.l;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class IPConnStrategy implements IConnStrategy, Serializable {
    public static final int SOURCE_AMDC = 0;
    public static final int SOURCE_CUSTOMIZED = 2;
    public static final int SOURCE_LOCAL_DNS = 1;
    public static final int TYPE_IP_TO_HOST = -1;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_STATIC_BANDWITDH = 0;

    /* renamed from: a, reason: collision with root package name */
    volatile int f٤٩٤٤a = 1;

    /* renamed from: b, reason: collision with root package name */
    volatile int f٤٩٤٥b = 1;

    /* renamed from: c, reason: collision with root package name */
    transient boolean f٤٩٤٦c;
    public volatile int cto;
    public volatile int heartbeat;
    public final String ip;
    public final int port;
    public final ConnProtocol protocol;
    public volatile int retry;
    public volatile int rto;

    private IPConnStrategy(String str, int i10, ConnProtocol connProtocol, int i11, int i12, int i13, int i14) {
        this.ip = str;
        this.port = i10;
        this.protocol = connProtocol;
        this.cto = i11;
        this.rto = i12;
        this.retry = i13;
        this.heartbeat = i14;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IPConnStrategy a(String str, l.a aVar) {
        ConnProtocol valueOf = ConnProtocol.valueOf(aVar);
        if (valueOf == null) {
            return null;
        }
        return a(str, aVar.f٥٠١٦a, valueOf, aVar.f٥٠١٨c, aVar.f٥٠١٩d, aVar.f٥٠٢٠e, aVar.f٥٠٢١f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IPConnStrategy)) {
            return false;
        }
        IPConnStrategy iPConnStrategy = (IPConnStrategy) obj;
        if (this.port == iPConnStrategy.port && this.ip.equals(iPConnStrategy.ip) && this.protocol.equals(iPConnStrategy.protocol)) {
            return true;
        }
        return false;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getConnectionTimeout() {
        return this.cto;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getHeartbeat() {
        return this.heartbeat;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public String getIp() {
        return this.ip;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpSource() {
        return this.f٤٩٤٥b;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpType() {
        return this.f٤٩٤٤a;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getPort() {
        return this.port;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public ConnProtocol getProtocol() {
        return this.protocol;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getReadTimeout() {
        return this.rto;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getRetryTimes() {
        return this.retry;
    }

    public int getUniqueId() {
        return hashCode();
    }

    public int hashCode() {
        return ((((527 + this.ip.hashCode()) * 31) + this.port) * 31) + this.protocol.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append('{');
        sb.append(this.ip);
        if (this.f٤٩٤٤a == 0) {
            sb.append("(*)");
        }
        sb.append(' ');
        sb.append(this.port);
        sb.append(' ');
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IPConnStrategy a(String str, int i10, ConnProtocol connProtocol, int i11, int i12, int i13, int i14) {
        if (TextUtils.isEmpty(str) || connProtocol == null || i10 <= 0) {
            return null;
        }
        return new IPConnStrategy(str, i10, connProtocol, i11, i12, i13, i14);
    }
}
