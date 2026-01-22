package qf;

import tech.sud.gip.core.GameInfo;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class f implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ GameInfo b;
    public final /* synthetic */ String c;
    public final /* synthetic */ h d;

    public f(h hVar, int i, GameInfo gameInfo, String str) {
        this.d = hVar;
        this.a = i;
        this.b = gameInfo;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s0.h hVar = this.d.e;
        int i = this.a;
        if (i == 0) {
            hVar.onSuccess(this.b);
        } else {
            hVar.onFailure(i, this.c);
        }
    }
}
