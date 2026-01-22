package org.android.agoo.control;

import com.taobao.accs.base.TaoBaseService;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
class b implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ String b;
    final /* synthetic */ TaoBaseService.ExtraInfo c;
    final /* synthetic */ AgooFactory d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AgooFactory agooFactory, byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo) {
        this.d = agooFactory;
        this.a = bArr;
        this.b = str;
        this.c = extraInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.msgReceiverPreHandler(this.a, this.b, this.c, true);
    }
}
