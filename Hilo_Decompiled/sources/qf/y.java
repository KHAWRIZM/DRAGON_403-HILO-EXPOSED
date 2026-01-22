package qf;

import tech.sud.gip.core.ISudListenerGetMGList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class y implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ b d;

    public y(b bVar, int i, String str, String str2) {
        this.d = bVar;
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISudListenerGetMGList iSudListenerGetMGList = this.d.b;
        if (iSudListenerGetMGList != null) {
            int i = this.a;
            if (i == 0) {
                iSudListenerGetMGList.onSuccess(this.b);
            } else {
                iSudListenerGetMGList.onFailure(i, this.c);
            }
        }
    }
}
