package gc;

import android.view.View;
import com.qmuiteam.qmui.widget.QMUIProgressBar;
import com.qmuiteam.qmui.widget.QMUISlider;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class m extends f {
    @Override // gc.f
    protected void b(View view, String str, int i10) {
        if (view instanceof QMUIProgressBar) {
            ((QMUIProgressBar) view).setProgressColor(i10);
        } else if (view instanceof QMUISlider) {
            ((QMUISlider) view).setBarProgressColor(i10);
        } else {
            dc.d.i(view, str);
        }
    }
}
