package org.android.agoo.control;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ AgooFactory c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AgooFactory agooFactory, String str, String str2) {
        this.c = agooFactory;
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.updateMsgStatus(this.a, this.b);
    }
}
