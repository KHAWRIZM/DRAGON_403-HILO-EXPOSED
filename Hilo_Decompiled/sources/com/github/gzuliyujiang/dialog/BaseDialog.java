package com.github.gzuliyujiang.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.github.gzuliyujiang.dialog.BaseDialog;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import q6.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class BaseDialog extends Dialog implements DialogInterface.OnShowListener, DialogInterface.OnDismissListener, LifecycleEventObserver {

    /* renamed from: a, reason: collision with root package name */
    protected Activity f٧٩٤١a;

    /* renamed from: b, reason: collision with root package name */
    protected View f٧٩٤٢b;

    public BaseDialog(Activity activity, int i10) {
        super(activity, i10);
        e(activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e(Activity activity) {
        if (activity instanceof LifecycleOwner) {
            ((LifecycleOwner) activity).getLifecycle().addObserver(this);
        }
        this.f٧٩٤١a = activity;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        super.setOnShowListener(this);
        super.setOnDismissListener(this);
        Window window = super.getWindow();
        if (window != null) {
            window.requestFeature(1);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(activity.getResources().getDisplayMetrics().widthPixels, -2);
            window.setGravity(17);
            window.getDecorView().setPadding(0, 0, 0, 0);
        }
        l(null);
        super.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnDismissListener onDismissListener2, DialogInterface dialogInterface) {
        onDismissListener.onDismiss(dialogInterface);
        onDismissListener2.onDismiss(dialogInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(DialogInterface.OnShowListener onShowListener, DialogInterface.OnShowListener onShowListener2, DialogInterface dialogInterface) {
        onShowListener.onShow(dialogInterface);
        onShowListener2.onShow(dialogInterface);
    }

    private void m() {
        View c10 = c();
        this.f٧٩٤٢b = c10;
        c10.setFocusable(true);
        this.f٧٩٤٢b.setFocusableInTouchMode(true);
        setContentView(this.f٧٩٤٢b);
        g();
    }

    protected abstract View c();

    protected void d() {
        try {
            super.dismiss();
            g.a("dialog dismiss");
        } catch (Throwable th) {
            g.a(th);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (!isShowing()) {
            return;
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        g.a("dialog initData");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        h(this.f٧٩٤٢b);
    }

    protected void h(View view) {
        g.a("dialog initView");
    }

    protected void k(Activity activity, Bundle bundle) {
        g.a("dialog onInit");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(Bundle bundle) {
        k(this.f٧٩٤١a, bundle);
    }

    public final void n(int i10, int i11) {
        o(i10, 20, i11);
    }

    public final void o(int i10, int i11, int i12) {
        Drawable drawable;
        View view = this.f٧٩٤٢b;
        if (view == null) {
            return;
        }
        float f10 = view.getResources().getDisplayMetrics().density * i11;
        this.f٧٩٤٢b.setLayerType(1, null);
        if (i10 != 1) {
            if (i10 != 2) {
                drawable = new ColorDrawable(i12);
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(f10);
                gradientDrawable.setColorFilter(new PorterDuffColorFilter(i12, PorterDuff.Mode.SRC_IN));
                drawable = gradientDrawable;
            }
        } else {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f10, f10, f10, f10, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS}, null, null));
            shapeDrawable.setColorFilter(new PorterDuffColorFilter(i12, PorterDuff.Mode.SRC_IN));
            drawable = shapeDrawable;
        }
        this.f٧٩٤٢b.setBackground(drawable);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        g.a("dialog attached to window");
        super.onAttachedToWindow();
        f();
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.a("dialog onCreate");
        if (this.f٧٩٤٢b == null) {
            m();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g.a("dialog detached from window");
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        g.a("dialog onDismiss");
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        g.a("dialog onShow");
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event.equals(Lifecycle.Event.ON_DESTROY)) {
            g.a("dismiss dialog when " + lifecycleOwner.getClass().getName() + " on destroy");
            dismiss();
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }

    public final void p(int i10) {
        getWindow().setGravity(i10);
    }

    public final void q(int i10) {
        getWindow().setLayout(i10, getWindow().getAttributes().height);
    }

    protected void r() {
        try {
            super.show();
            g.a("dialog show");
        } catch (Throwable th) {
            g.a(th);
        }
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(final DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener == null) {
            return;
        }
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: q6.b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                BaseDialog.i(this, onDismissListener, dialogInterface);
            }
        });
    }

    @Override // android.app.Dialog
    public void setOnShowListener(final DialogInterface.OnShowListener onShowListener) {
        if (onShowListener == null) {
            return;
        }
        super.setOnShowListener(new DialogInterface.OnShowListener() { // from class: q6.a
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                BaseDialog.j(this, onShowListener, dialogInterface);
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        if (isShowing()) {
            return;
        }
        r();
    }
}
