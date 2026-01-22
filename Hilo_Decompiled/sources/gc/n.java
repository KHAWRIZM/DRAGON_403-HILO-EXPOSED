package gc;

import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class n extends f {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // gc.f
    protected void b(View view, String str, int i10) {
        if (view instanceof bc.a) {
            if ("topSeparator".equals(str)) {
                ((bc.a) view).i(i10);
                return;
            }
            if ("bottomSeparator".equals(str)) {
                ((bc.a) view).d(i10);
                return;
            } else if ("LeftSeparator".equals(str)) {
                ((bc.a) view).f(i10);
                return;
            } else {
                if ("rightSeparator".equals(str)) {
                    ((bc.a) view).j(i10);
                    return;
                }
                return;
            }
        }
        dc.d.i(view, str);
    }
}
