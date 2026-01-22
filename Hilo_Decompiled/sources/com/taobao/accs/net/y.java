package com.taobao.accs.net;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class y implements Runnable {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.a = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.q();
        if (this.a.H != null) {
            this.a.H.setCloseReason("shut down");
        }
        synchronized (this.a.t) {
            try {
                this.a.t.notifyAll();
            } catch (Exception unused) {
            }
        }
    }
}
