package com.tencent.liteav.videobase.videobase;

import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class b implements Runnable {
    private final View a;

    private b(View view) {
        this.a = view;
    }

    public static Runnable a(View view) {
        return new b(view);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.requestLayout();
    }
}
