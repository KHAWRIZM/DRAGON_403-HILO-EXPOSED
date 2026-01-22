package gc;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class q extends h {
    @Override // gc.h
    protected void b(View view, String str, Drawable drawable) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            if ("tclSrc".equals(str)) {
                compoundDrawables[0] = drawable;
            } else if ("tctSrc".equals(str)) {
                compoundDrawables[1] = drawable;
            } else if ("tcrSrc".equals(str)) {
                compoundDrawables[2] = drawable;
            } else if ("tcbSrc".equals(str)) {
                compoundDrawables[3] = drawable;
            }
            textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
            return;
        }
        dc.d.i(view, str);
    }
}
