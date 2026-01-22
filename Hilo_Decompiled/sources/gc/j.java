package gc;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import com.qmuiteam.qmui.widget.QMUISlider;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class j extends g {
    @Override // gc.g
    protected void b(View view, String str, ColorStateList colorStateList) {
        if (view instanceof TextView) {
            ((TextView) view).setHintTextColor(colorStateList);
            return;
        }
        if (view instanceof TextInputLayout) {
            ((TextInputLayout) view).setHintTextColor(colorStateList);
        } else if (view instanceof QMUISlider) {
            ((QMUISlider) view).setRecordProgressColor(colorStateList.getDefaultColor());
        } else {
            dc.d.i(view, str);
        }
    }
}
