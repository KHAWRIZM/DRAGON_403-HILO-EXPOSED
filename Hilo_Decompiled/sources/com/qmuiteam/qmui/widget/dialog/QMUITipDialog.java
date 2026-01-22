package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import com.qmuiteam.qmui.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUITipDialog extends QMUIBaseDialog {
    public QMUITipDialog(Context context) {
        this(context, R.style.QMUI_TipDialog);
    }

    public QMUITipDialog(Context context, int i10) {
        super(context, i10);
        setCanceledOnTouchOutside(false);
    }
}
