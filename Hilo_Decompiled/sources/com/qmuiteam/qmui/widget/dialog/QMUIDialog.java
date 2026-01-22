package com.qmuiteam.qmui.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import com.qmuiteam.qmui.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIDialog extends QMUIBaseDialog {
    private Context mBaseContext;

    public QMUIDialog(Context context) {
        this(context, R.style.QMUI_Dialog);
    }

    private void init() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }

    public void showWithImmersiveCheck(Activity activity) {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        if ((systemUiVisibility & 1024) != 1024 && (systemUiVisibility & 4) != 4) {
            super.show();
            return;
        }
        window.setFlags(8, 8);
        window.getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility());
        super.show();
        window.clearFlags(8);
    }

    public QMUIDialog(Context context, int i10) {
        super(context, i10);
        this.mBaseContext = context;
        init();
    }

    public void showWithImmersiveCheck() {
        Context context = this.mBaseContext;
        if (!(context instanceof Activity)) {
            super.show();
        } else {
            showWithImmersiveCheck((Activity) context);
        }
    }
}
