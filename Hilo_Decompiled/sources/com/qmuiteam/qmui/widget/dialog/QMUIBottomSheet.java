package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d1;
import androidx.core.view.d2;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIPriorityLinearLayout;
import ic.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIBottomSheet extends QMUIBaseDialog {
    private static final String TAG = "QMUIBottomSheet";
    private boolean mAnimateToCancel;
    private boolean mAnimateToDismiss;
    private QMUIBottomSheetBehavior<QMUIBottomSheetRootLayout> mBehavior;
    private e mOnBottomSheetShowListener;
    private QMUIBottomSheetRootLayout mRootView;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a extends BottomSheetBehavior.g {
        a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onSlide(View view, float f10) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onStateChanged(View view, int i10) {
            if (i10 == 5) {
                if (QMUIBottomSheet.this.mAnimateToCancel) {
                    QMUIBottomSheet.this.cancel();
                } else if (QMUIBottomSheet.this.mAnimateToDismiss) {
                    QMUIBottomSheet.this.dismiss();
                } else {
                    QMUIBottomSheet.this.cancel();
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (QMUIBottomSheet.this.mBehavior.getState() == 2) {
                return;
            }
            QMUIBottomSheet qMUIBottomSheet = QMUIBottomSheet.this;
            if (qMUIBottomSheet.cancelable && qMUIBottomSheet.isShowing() && QMUIBottomSheet.this.shouldWindowCloseOnTouchOutside()) {
                QMUIBottomSheet.this.cancel();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QMUIBottomSheet.this.mBehavior.c(3);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface e {
    }

    public QMUIBottomSheet(Context context) {
        this(context, R.style.QMUI_BottomSheet);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalStateException("Use addContentView(View, QMUIPriorityLinearLayout.LayoutParams) for replacement");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.mBehavior.getState() == 5) {
            this.mAnimateToCancel = false;
            super.cancel();
        } else {
            this.mAnimateToCancel = true;
            this.mBehavior.c(5);
        }
    }

    @Override // com.qmuiteam.qmui.widget.dialog.QMUIBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.mBehavior.getState() == 5) {
            this.mAnimateToDismiss = false;
            super.dismiss();
        } else {
            this.mAnimateToDismiss = true;
            this.mBehavior.c(5);
        }
    }

    public QMUIBottomSheetBehavior<QMUIBottomSheetRootLayout> getBehavior() {
        return this.mBehavior;
    }

    protected n.i getInsetHandler() {
        return n.f١٤٩٠٥a;
    }

    public QMUIBottomSheetRootLayout getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
        d1.n0(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.widget.dialog.QMUIBaseDialog
    public void onSetCancelable(boolean z10) {
        super.onSetCancelable(z10);
        this.mBehavior.V0(z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.widget.dialog.QMUIBaseDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        if (this.mBehavior.getState() == 5) {
            this.mBehavior.c(4);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view) {
        throw new IllegalStateException("Use addContentView(View, ConstraintLayout.LayoutParams) for replacement");
    }

    public void setFitNav(boolean z10) {
        if (z10) {
            this.mRootView.setFitsSystemWindows(true);
            n.e(this.mRootView, d2.m.e(), getInsetHandler(), true, true, false);
        } else {
            this.mRootView.setFitsSystemWindows(false);
            n.i(this.mRootView, null, true);
        }
        this.mRootView.requestApplyInsets();
    }

    public void setOnBottomSheetShowListener(e eVar) {
    }

    public void setRadius(int i10) {
        this.mRootView.e(i10, 3);
    }

    protected void setToExpandWhenShow() {
        this.mRootView.postOnAnimation(new d());
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.mBehavior.getState() != 3) {
            setToExpandWhenShow();
        }
        this.mAnimateToCancel = false;
        this.mAnimateToDismiss = false;
    }

    public QMUIBottomSheet(Context context, int i10) {
        super(context, i10);
        this.mAnimateToCancel = false;
        this.mAnimateToDismiss = false;
        ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.qmui_bottom_sheet_dialog, (ViewGroup) null);
        this.mRootView = (QMUIBottomSheetRootLayout) viewGroup.findViewById(R.id.bottom_sheet);
        QMUIBottomSheetBehavior<QMUIBottomSheetRootLayout> qMUIBottomSheetBehavior = new QMUIBottomSheetBehavior<>();
        this.mBehavior = qMUIBottomSheetBehavior;
        qMUIBottomSheetBehavior.V0(this.cancelable);
        this.mBehavior.e0(new a());
        this.mBehavior.Y0(0);
        this.mBehavior.t1(false);
        this.mBehavior.c1(true);
        ((CoordinatorLayout.f) this.mRootView.getLayoutParams()).o(this.mBehavior);
        viewGroup.findViewById(R.id.touch_outside).setOnClickListener(new b());
        this.mRootView.setOnTouchListener(new c());
        super.setContentView(viewGroup, new ViewGroup.LayoutParams(-1, -1));
    }

    public void addContentView(View view, QMUIPriorityLinearLayout.a aVar) {
        this.mRootView.addView(view, aVar);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int i10) {
        throw new IllegalStateException("Use addContentView(int) for replacement");
    }

    public void addContentView(View view) {
        QMUIPriorityLinearLayout.a aVar = new QMUIPriorityLinearLayout.a(-1, -2);
        aVar.d(1);
        this.mRootView.addView(view, aVar);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalStateException("Use addContentView(View, QMUIPriorityLinearLayout.LayoutParams) for replacement");
    }

    public void addContentView(int i10) {
        LayoutInflater.from(this.mRootView.getContext()).inflate(i10, (ViewGroup) this.mRootView, true);
    }
}
