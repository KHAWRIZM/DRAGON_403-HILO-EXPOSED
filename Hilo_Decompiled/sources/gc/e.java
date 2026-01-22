package gc;

import android.content.res.ColorStateList;
import android.view.View;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.QMUISlider;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class e extends g {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // gc.g
    protected void b(View view, String str, ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        if (view instanceof bc.a) {
            ((bc.a) view).setBorderColor(colorStateList.getDefaultColor());
            return;
        }
        if (view instanceof QMUIRadiusImageView) {
            ((QMUIRadiusImageView) view).setBorderColor(colorStateList.getDefaultColor());
            return;
        }
        if (view instanceof QMUIRoundButton) {
            ((QMUIRoundButton) view).setStrokeColors(colorStateList);
        } else if (view instanceof QMUISlider.DefaultThumbView) {
            ((QMUISlider.DefaultThumbView) view).setBorderColor(colorStateList.getDefaultColor());
        } else {
            dc.d.i(view, str);
        }
    }
}
