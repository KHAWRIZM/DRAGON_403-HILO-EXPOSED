package tech.sud.gip.core;

import d1.a;
import e.d;
import qf.x;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class ISudAPPD {
    public static void d() {
        if (d.f != 1) {
            a.a = true;
        }
    }

    public static void e(int i) {
        x xVar;
        if (d.f != i && (xVar = d.b) != null) {
            xVar.f();
        }
        d.f = i;
        d.b.getClass();
        x.z();
    }
}
