package com.tencent.liteav.sdkcommon;

import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class k implements View.OnClickListener {
    private final g a;

    private k(g gVar) {
        this.a = gVar;
    }

    public static View.OnClickListener a(g gVar) {
        return new k(gVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.a(false);
    }
}
