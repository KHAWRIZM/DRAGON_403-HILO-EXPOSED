package com.tencent.liteav.sdkcommon;

import android.widget.ScrollView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class h implements Runnable {
    private final g a;

    private h(g gVar) {
        this.a = gVar;
    }

    public static Runnable a(g gVar) {
        return new h(gVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScrollView scrollView = this.a.k;
        if (scrollView != null) {
            scrollView.fullScroll(130);
        }
    }
}
