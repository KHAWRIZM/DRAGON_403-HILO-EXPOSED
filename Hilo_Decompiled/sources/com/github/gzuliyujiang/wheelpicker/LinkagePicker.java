package com.github.gzuliyujiang.wheelpicker;

import android.view.View;
import com.github.gzuliyujiang.dialog.ModalDialog;
import com.github.gzuliyujiang.wheelpicker.widget.LinkageWheelLayout;
import r6.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class LinkagePicker extends ModalDialog {

    /* renamed from: k, reason: collision with root package name */
    protected LinkageWheelLayout f٧٩٦٣k;

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void I() {
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void J() {
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected View x() {
        LinkageWheelLayout linkageWheelLayout = new LinkageWheelLayout(this.f٧٩٤١a);
        this.f٧٩٦٣k = linkageWheelLayout;
        return linkageWheelLayout;
    }

    public void setOnLinkagePickedListener(h hVar) {
    }
}
