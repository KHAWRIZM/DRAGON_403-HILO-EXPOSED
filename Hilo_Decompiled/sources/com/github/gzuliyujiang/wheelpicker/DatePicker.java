package com.github.gzuliyujiang.wheelpicker;

import android.view.View;
import com.github.gzuliyujiang.dialog.ModalDialog;
import com.github.gzuliyujiang.wheelpicker.widget.DateWheelLayout;
import r6.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DatePicker extends ModalDialog {

    /* renamed from: k, reason: collision with root package name */
    protected DateWheelLayout f٧٩٥٩k;

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void I() {
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void J() {
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected View x() {
        DateWheelLayout dateWheelLayout = new DateWheelLayout(this.f٧٩٤١a);
        this.f٧٩٥٩k = dateWheelLayout;
        return dateWheelLayout;
    }

    public void setOnDatePickedListener(d dVar) {
    }
}
