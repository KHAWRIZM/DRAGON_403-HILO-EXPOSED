package com.scwang.smart.refresh.layout.simple;

import android.graphics.PointF;
import android.view.View;
import vc.j;
import wc.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a implements j {
    public PointF a;
    public j b;
    public boolean c = true;

    @Override // vc.j
    public boolean a(View view) {
        j jVar = this.b;
        if (jVar != null) {
            return jVar.a(view);
        }
        return c.b(view, this.a);
    }

    @Override // vc.j
    public boolean b(View view) {
        j jVar = this.b;
        if (jVar != null) {
            return jVar.b(view);
        }
        return c.a(view, this.a, this.c);
    }
}
