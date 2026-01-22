package com.qmuiteam.qmui.widget.dialog;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatDialog;
import dc.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIBaseDialog extends AppCompatDialog {
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private e mSkinManager;

    public QMUIBaseDialog(Context context, int i10) {
        super(context, i10);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.mSkinManager = null;
        supportRequestWindowFeature(1);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Context context = getContext();
        if (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isDestroyed() && !activity.isFinishing()) {
                super.dismiss();
                return;
            }
            return;
        }
        try {
            super.dismiss();
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Dialog
    public LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = super.getLayoutInflater();
        layoutInflater.getFactory2();
        return layoutInflater;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetCancelable(boolean z10) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        e eVar = this.mSkinManager;
        if (eVar != null) {
            eVar.m(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStop() {
        super.onStop();
        e eVar = this.mSkinManager;
        if (eVar != null) {
            eVar.p(this);
        }
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z10) {
        super.setCancelable(z10);
        if (this.cancelable != z10) {
            this.cancelable = z10;
            onSetCancelable(z10);
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z10) {
        super.setCanceledOnTouchOutside(z10);
        if (z10 && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z10;
        this.canceledOnTouchOutsideSet = true;
    }

    public void setSkinManager(e eVar) {
        e eVar2 = this.mSkinManager;
        if (eVar2 != null) {
            eVar2.p(this);
        }
        this.mSkinManager = eVar;
        if (isShowing() && eVar != null) {
            this.mSkinManager.m(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            this.canceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }
}
