package anet.channel.session;

import android.content.Context;
import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import org.android.spdy.AccsSSLCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j implements AccsSSLCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f٤٩١٧a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(TnetSpdySession tnetSpdySession) {
        this.f٤٩١٧a = tnetSpdySession;
    }

    public byte[] getSSLPublicKey(int i10, byte[] bArr) {
        byte[] bArr2;
        Context context;
        try {
            TnetSpdySession tnetSpdySession = this.f٤٩١٧a;
            ISecurity iSecurity = tnetSpdySession.G;
            context = tnetSpdySession.f٤٦١١a;
            bArr2 = iSecurity.decrypt(context, ISecurity.CIPHER_ALGORITHM_AES128, "tnet_pksg_key", bArr);
            if (bArr2 != null) {
                try {
                    if (ALog.isPrintLog(2)) {
                        ALog.i("getSSLPublicKey", null, "decrypt", new String(bArr2));
                    }
                } catch (Throwable th) {
                    th = th;
                    ALog.e("awcn.TnetSpdySession", "getSSLPublicKey", null, th, new Object[0]);
                    return bArr2;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bArr2 = null;
        }
        return bArr2;
    }
}
