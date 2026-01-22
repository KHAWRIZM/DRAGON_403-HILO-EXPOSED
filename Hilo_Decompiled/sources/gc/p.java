package gc;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import com.qmuiteam.qmui.qqface.QMUIQQFaceView;
import com.qmuiteam.qmui.widget.QMUIProgressBar;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class p extends g {
    @Override // gc.g
    protected void b(View view, String str, ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(colorStateList);
            return;
        }
        if (view instanceof QMUIQQFaceView) {
            ((QMUIQQFaceView) view).setTextColor(colorStateList.getDefaultColor());
        } else if (view instanceof QMUIProgressBar) {
            ((QMUIProgressBar) view).setTextColor(colorStateList.getDefaultColor());
        } else {
            dc.d.i(view, str);
        }
    }
}
