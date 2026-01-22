package anet.channel.util;

import java.net.Inet6Address;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public int f٥٠٨٢a;

    /* renamed from: b, reason: collision with root package name */
    public Inet6Address f٥٠٨٣b;

    public f(Inet6Address inet6Address, int i10) {
        this.f٥٠٨٢a = i10;
        this.f٥٠٨٣b = inet6Address;
    }

    public String toString() {
        return this.f٥٠٨٣b.getHostAddress() + "/" + this.f٥٠٨٢a;
    }
}
