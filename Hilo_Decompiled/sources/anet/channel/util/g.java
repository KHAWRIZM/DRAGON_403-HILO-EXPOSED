package anet.channel.util;

import android.util.Base64;
import com.facebook.internal.security.CertificateUtil;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static g f٥٠٨٤a;

    /* renamed from: b, reason: collision with root package name */
    private final Proxy f٥٠٨٥b;

    /* renamed from: c, reason: collision with root package name */
    private final String f٥٠٨٦c;

    /* renamed from: d, reason: collision with root package name */
    private final String f٥٠٨٧d;

    public g(String str, int i10, String str2, String str3) {
        this.f٥٠٨٥b = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i10));
        this.f٥٠٨٦c = str2;
        this.f٥٠٨٧d = str3;
    }

    public static g a() {
        return f٥٠٨٤a;
    }

    public Proxy b() {
        return this.f٥٠٨٥b;
    }

    public String c() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f٥٠٨٦c);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(this.f٥٠٨٧d);
        String encodeToString = Base64.encodeToString(sb.toString().getBytes(), 0);
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append("Basic ");
        sb2.append(encodeToString);
        return sb2.toString();
    }
}
