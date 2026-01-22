package com.github.gzuliyujiang.wheelpicker;

import android.app.Activity;
import android.view.View;
import com.github.gzuliyujiang.dialog.ModalDialog;
import com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.List;
import r6.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class OptionPicker extends ModalDialog {

    /* renamed from: k, reason: collision with root package name */
    protected OptionWheelLayout f٧٩٦٥k;

    /* renamed from: l, reason: collision with root package name */
    private l f٧٩٦٦l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f٧٩٦٧m;

    /* renamed from: n, reason: collision with root package name */
    private List f٧٩٦٨n;

    /* renamed from: o, reason: collision with root package name */
    private Object f٧٩٦٩o;

    /* renamed from: p, reason: collision with root package name */
    private int f٧٩٧٠p;

    public OptionPicker(Activity activity) {
        super(activity);
        this.f٧٩٦٧m = false;
        this.f٧٩٧٠p = -1;
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void I() {
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void J() {
        if (this.f٧٩٦٦l != null) {
            this.f٧٩٦٦l.a(this.f٧٩٦٥k.getWheelView().getCurrentPosition(), this.f٧٩٦٥k.getWheelView().getCurrentItem());
        }
    }

    public final WheelView K() {
        return this.f٧٩٦٥k.getWheelView();
    }

    protected List L() {
        return null;
    }

    public void M(List list) {
        this.f٧٩٦٨n = list;
        if (this.f٧٩٦٧m) {
            this.f٧٩٦٥k.setData(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.gzuliyujiang.dialog.BaseDialog
    public void f() {
        super.f();
        this.f٧٩٦٧m = true;
        List list = this.f٧٩٦٨n;
        if (list == null || list.size() == 0) {
            this.f٧٩٦٨n = L();
        }
        this.f٧٩٦٥k.setData(this.f٧٩٦٨n);
        Object obj = this.f٧٩٦٩o;
        if (obj != null) {
            this.f٧٩٦٥k.setDefaultValue(obj);
        }
        int i10 = this.f٧٩٧٠p;
        if (i10 != -1) {
            this.f٧٩٦٥k.setDefaultPosition(i10);
        }
    }

    public void setOnOptionPickedListener(l lVar) {
        this.f٧٩٦٦l = lVar;
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected View x() {
        OptionWheelLayout optionWheelLayout = new OptionWheelLayout(this.f٧٩٤١a);
        this.f٧٩٦٥k = optionWheelLayout;
        return optionWheelLayout;
    }
}
