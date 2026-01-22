package com.taobao.accs.net;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class z implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar, String str) {
        this.b = wVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2 = this.a;
        if (str2 != null) {
            str = this.b.N;
            if (str2.equals(str) && this.b.s == 2) {
                this.b.J = false;
                this.b.L = true;
                this.b.q();
                this.b.H.setCloseReason("conn timeout");
            }
        }
    }
}
