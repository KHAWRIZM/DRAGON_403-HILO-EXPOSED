package com.tencent.liteav.videobase.videobase;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class a implements Runnable {
    private final View a;
    private final int b;

    private a(View view, int i) {
        this.a = view;
        this.b = i;
    }

    public static Runnable a(View view, int i) {
        return new a(view, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.setVisibility(this.b);
    }
}
