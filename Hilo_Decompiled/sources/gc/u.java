package gc;

import android.content.res.ColorStateList;
import android.view.View;
import com.qmuiteam.qmui.qqface.QMUIQQFaceView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class u extends g {
    @Override // gc.g
    protected void b(View view, String str, ColorStateList colorStateList) {
        if (view instanceof QMUIQQFaceView) {
            ((QMUIQQFaceView) view).setLinkUnderLineColor(colorStateList);
        } else {
            dc.d.i(view, str);
        }
    }
}
