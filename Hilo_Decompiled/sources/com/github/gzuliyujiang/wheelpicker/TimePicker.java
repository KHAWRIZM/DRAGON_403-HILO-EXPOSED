package com.github.gzuliyujiang.wheelpicker;

import android.view.View;
import com.github.gzuliyujiang.dialog.ModalDialog;
import com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout;
import r6.n;
import r6.p;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class TimePicker extends ModalDialog {

    /* renamed from: k, reason: collision with root package name */
    protected TimeWheelLayout f٧٩٧٥k;

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void I() {
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void J() {
        this.f٧٩٧٥k.getSelectedHour();
        this.f٧٩٧٥k.getSelectedMinute();
        this.f٧٩٧٥k.getSelectedSecond();
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected View x() {
        TimeWheelLayout timeWheelLayout = new TimeWheelLayout(this.f٧٩٤١a);
        this.f٧٩٧٥k = timeWheelLayout;
        return timeWheelLayout;
    }

    public void setOnTimeMeridiemPickedListener(n nVar) {
    }

    public void setOnTimePickedListener(p pVar) {
    }
}
