package com.taobao.accs.net;

import com.taobao.accs.utl.UtilityImpl;
import org.android.spdy.AccsSSLCallback;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class aa implements AccsSSLCallback {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar) {
        this.a = wVar;
    }

    @Override // org.android.spdy.AccsSSLCallback
    public byte[] getSSLPublicKey(int i, byte[] bArr) {
        return UtilityImpl.a();
    }
}
