package gc;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class s extends g {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // gc.g
    protected void b(View view, String str, ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (Build.VERSION.SDK_INT >= 23) {
                textView.setCompoundDrawableTintList(colorStateList);
                return;
            }
            if (textView instanceof androidx.core.widget.p) {
                ((androidx.core.widget.p) textView).setSupportCompoundDrawablesTintList(colorStateList);
                return;
            }
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            for (int i10 = 0; i10 < compoundDrawables.length; i10++) {
                Drawable drawable = compoundDrawables[i10];
                if (drawable != null) {
                    Drawable mutate = drawable.mutate();
                    ic.f.b(mutate, colorStateList.getDefaultColor());
                    compoundDrawables[i10] = mutate;
                }
            }
            textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
            return;
        }
        dc.d.i(view, str);
    }
}
