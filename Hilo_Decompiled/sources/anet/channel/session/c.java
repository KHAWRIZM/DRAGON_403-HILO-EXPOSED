package anet.channel.session;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class c implements HostnameVerifier {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f٤٩٠٦a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.f٤٩٠٦a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f٤٩٠٦a, sSLSession);
    }
}
