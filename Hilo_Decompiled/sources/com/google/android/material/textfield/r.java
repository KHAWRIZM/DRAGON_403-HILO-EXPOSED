package com.google.android.material.textfield;

import android.widget.EditText;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class r {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(EditText editText) {
        if (editText.getInputType() != 0) {
            return true;
        }
        return false;
    }
}
