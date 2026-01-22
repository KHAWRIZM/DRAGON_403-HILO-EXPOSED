package gc;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class o extends h {
    @Override // gc.h
    protected void b(View view, String str, Drawable drawable) {
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(drawable);
        } else if (view instanceof CompoundButton) {
            ((CompoundButton) view).setButtonDrawable(drawable);
        } else {
            dc.d.i(view, str);
        }
    }
}
