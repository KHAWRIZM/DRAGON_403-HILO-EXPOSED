package com.github.gzuliyujiang.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import com.github.gzuliyujiang.dialog.BottomDialog;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import q6.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class BottomDialog extends BaseDialog {

    /* renamed from: c, reason: collision with root package name */
    protected View f٧٩٤٣c;

    public BottomDialog(Activity activity, int i10) {
        super(activity, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean v(View view, int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // com.github.gzuliyujiang.dialog.BaseDialog
    public void l(Bundle bundle) {
        super.l(bundle);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        q(this.f٧٩٤١a.getResources().getDisplayMetrics().widthPixels);
        p(80);
    }

    @Override // com.github.gzuliyujiang.dialog.BaseDialog, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        w();
        super.onDismiss(dialogInterface);
    }

    @Override // com.github.gzuliyujiang.dialog.BaseDialog, android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        super.onShow(dialogInterface);
        if (u()) {
            t();
        }
    }

    protected void t() {
        try {
            getWindow().setDimAmount(DownloadProgress.UNKNOWN_PROGRESS);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            Point point = new Point();
            this.f٧٩٤١a.getWindowManager().getDefaultDisplay().getRealSize(point);
            layoutParams.height = point.y - this.f٧٩٤١a.getResources().getDimensionPixelSize(this.f٧٩٤١a.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
            layoutParams.gravity = 48;
            if (Build.VERSION.SDK_INT >= 28) {
                layoutParams.layoutInDisplayCutoutMode = 1;
            }
            layoutParams.systemUiVisibility = 1280;
            layoutParams.type = 1000;
            layoutParams.format = -3;
            layoutParams.token = this.f٧٩٤١a.getWindow().getDecorView().getWindowToken();
            layoutParams.softInputMode = 18;
            View view = new View(this.f٧٩٤١a);
            this.f٧٩٤٣c = view;
            view.setBackgroundColor(2130706432);
            this.f٧٩٤٣c.setFitsSystemWindows(false);
            this.f٧٩٤٣c.setOnKeyListener(new View.OnKeyListener() { // from class: q6.d
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view2, int i10, KeyEvent keyEvent) {
                    boolean v10;
                    v10 = BottomDialog.this.v(view2, i10, keyEvent);
                    return v10;
                }
            });
            this.f٧٩٤١a.getWindowManager().addView(this.f٧٩٤٣c, layoutParams);
            g.a("dialog add mask view");
        } catch (Throwable th) {
            g.a(th);
        }
    }

    protected boolean u() {
        return true;
    }

    protected void w() {
        if (this.f٧٩٤٣c == null) {
            g.a("mask view is null");
            return;
        }
        try {
            this.f٧٩٤١a.getWindowManager().removeViewImmediate(this.f٧٩٤٣c);
            g.a("dialog remove mask view");
        } catch (Throwable th) {
            g.a(th);
        }
    }
}
