package com.github.gzuliyujiang.wheelpicker;

import android.view.View;
import com.github.gzuliyujiang.wheelpicker.widget.CarPlateWheelLayout;
import r6.c;
import r6.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class CarPlatePicker extends LinkagePicker {
    @Override // com.github.gzuliyujiang.wheelpicker.LinkagePicker, com.github.gzuliyujiang.dialog.ModalDialog
    protected void J() {
    }

    @Override // com.github.gzuliyujiang.wheelpicker.LinkagePicker
    @Deprecated
    public void setOnLinkagePickedListener(h hVar) {
        throw new UnsupportedOperationException("Use setOnCarPlatePickedListener instead");
    }

    @Override // com.github.gzuliyujiang.wheelpicker.LinkagePicker, com.github.gzuliyujiang.dialog.ModalDialog
    protected View x() {
        CarPlateWheelLayout carPlateWheelLayout = new CarPlateWheelLayout(this.f٧٩٤١a);
        this.f٧٩٦٣k = carPlateWheelLayout;
        return carPlateWheelLayout;
    }

    public void setOnCarPlatePickedListener(c cVar) {
    }
}
