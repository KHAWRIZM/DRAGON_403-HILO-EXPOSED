package com.tencent.liteav.sdkcommon;

import android.widget.ScrollView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class i implements Runnable {
    private final g a;

    private i(g gVar) {
        this.a = gVar;
    }

    public static Runnable a(g gVar) {
        return new i(gVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScrollView scrollView = this.a.k;
        if (scrollView != null) {
            scrollView.fullScroll(130);
        }
    }
}
