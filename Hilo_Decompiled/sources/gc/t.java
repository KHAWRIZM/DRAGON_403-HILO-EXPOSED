package gc;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.qmuiteam.qmui.widget.QMUILoadingView;
import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class t extends g {
    @Override // gc.g
    protected void b(View view, String str, ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        if (view instanceof QMUILoadingView) {
            ((QMUILoadingView) view).setColor(colorStateList.getDefaultColor());
            return;
        }
        if (view instanceof QMUIPullRefreshLayout.RefreshView) {
            ((QMUIPullRefreshLayout.RefreshView) view).setColorSchemeColors(colorStateList.getDefaultColor());
            return;
        }
        if (view instanceof ImageView) {
            androidx.core.widget.g.c((ImageView) view, colorStateList);
        } else if (view instanceof CompoundButton) {
            androidx.core.widget.c.d((CompoundButton) view, colorStateList);
        } else {
            dc.d.i(view, str);
        }
    }
}
