package gc;

import android.content.res.Resources;
import android.view.View;
import com.qmuiteam.qmui.widget.QMUIProgressBar;
import com.qmuiteam.qmui.widget.QMUISlider;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class c implements a {
    @Override // gc.a
    public void a(dc.e eVar, View view, Resources.Theme theme, String str, int i10) {
        if (view instanceof QMUIRoundButton) {
            ((QMUIRoundButton) view).setBgData(ic.i.d(view.getContext(), theme, i10));
            return;
        }
        if (view instanceof QMUIProgressBar) {
            view.setBackgroundColor(ic.i.c(theme, i10));
        } else if (view instanceof QMUISlider) {
            ((QMUISlider) view).setBarNormalColor(ic.i.c(theme, i10));
        } else {
            ic.k.g(view, ic.i.g(view.getContext(), theme, i10));
        }
    }
}
