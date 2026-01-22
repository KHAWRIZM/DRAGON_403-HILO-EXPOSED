package com.github.gzuliyujiang.wheelpicker;

import android.view.View;
import com.github.gzuliyujiang.dialog.ModalDialog;
import com.github.gzuliyujiang.wheelpicker.widget.DatimeWheelLayout;
import r6.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DatimePicker extends ModalDialog {

    /* renamed from: k, reason: collision with root package name */
    protected DatimeWheelLayout f٧٩٦٠k;

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void I() {
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void J() {
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected View x() {
        DatimeWheelLayout datimeWheelLayout = new DatimeWheelLayout(this.f٧٩٤١a);
        this.f٧٩٦٠k = datimeWheelLayout;
        return datimeWheelLayout;
    }

    public void setOnDatimePickedListener(f fVar) {
    }
}
