package com.taobao.accs.internal;

import android.content.Context;
import com.taobao.accs.ConnectionListener;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class b implements ConnectionListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.taobao.accs.ConnectionListener
    public void onConnect() {
        boolean z;
        if (this.a.c.a.j().e(this.a.b.getPackageName())) {
            z = this.a.c.c;
            if (z) {
                a aVar = this.a;
                ACCSManagerImpl aCCSManagerImpl = aVar.c;
                Context context = aVar.b;
                com.taobao.accs.net.b bVar = aCCSManagerImpl.a;
                aCCSManagerImpl.a(context, bVar.b, bVar.a);
            }
        }
    }

    @Override // com.taobao.accs.ConnectionListener
    public void onDisconnect(int i, String str) {
    }
}
