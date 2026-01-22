package com.tencent.liteav.sdkcommon;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class j implements View.OnClickListener {
    private final g a;
    private final Button b;

    private j(g gVar, Button button) {
        this.a = gVar;
        this.b = button;
    }

    public static View.OnClickListener a(g gVar, Button button) {
        return new j(gVar, button);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        g gVar = this.a;
        boolean z = gVar.m;
        if (!z) {
            gVar.b.height = gVar.n / 2;
        } else {
            WindowManager.LayoutParams layoutParams = gVar.b;
            int i = gVar.n;
            layoutParams.height = i;
            int i2 = layoutParams.y;
            int i3 = i + i2;
            int i4 = gVar.a.heightPixels;
            if (i3 > i4) {
                layoutParams.height = i4 - i2;
            }
        }
        gVar.m = !z;
        gVar.f.updateViewLayout(gVar.g, gVar.b);
        ViewGroup.LayoutParams layoutParams2 = gVar.k.getLayoutParams();
        layoutParams2.height = gVar.b();
        gVar.k.setLayoutParams(layoutParams2);
        gVar.d.post(l.a(gVar));
    }
}
