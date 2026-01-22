package com.github.gzuliyujiang.wheelpicker;

import android.view.View;
import com.github.gzuliyujiang.dialog.ModalDialog;
import com.github.gzuliyujiang.wheelpicker.widget.NumberWheelLayout;
import r6.j;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class NumberPicker extends ModalDialog {

    /* renamed from: k, reason: collision with root package name */
    protected NumberWheelLayout f٧٩٦٤k;

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void I() {
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void J() {
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected View x() {
        NumberWheelLayout numberWheelLayout = new NumberWheelLayout(this.f٧٩٤١a);
        this.f٧٩٦٤k = numberWheelLayout;
        return numberWheelLayout;
    }

    public final void setOnNumberPickedListener(j jVar) {
    }
}
