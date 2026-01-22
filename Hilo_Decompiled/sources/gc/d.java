package gc;

import android.content.res.ColorStateList;
import android.view.View;
import androidx.core.view.y0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class d extends g {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // gc.g
    protected void b(View view, String str, ColorStateList colorStateList) {
        if (view instanceof y0) {
            ((y0) view).setSupportBackgroundTintList(colorStateList);
        } else {
            dc.d.i(view, str);
        }
    }
}
