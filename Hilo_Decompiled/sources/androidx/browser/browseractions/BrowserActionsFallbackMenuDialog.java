package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import z2.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class BrowserActionsFallbackMenuDialog extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private final View f١٧١١a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f١٧١٢a;

        a(boolean z10) {
            this.f١٧١٢a = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f١٧١٢a) {
                BrowserActionsFallbackMenuDialog.super.dismiss();
            }
        }
    }

    private void b(boolean z10) {
        float f10;
        long j10;
        float f11 = 1.0f;
        if (z10) {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f10 = 1.0f;
        }
        if (!z10) {
            f11 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (z10) {
            j10 = 250;
        } else {
            j10 = 150;
        }
        this.f١٧١١a.setScaleX(f10);
        this.f١٧١١a.setScaleY(f10);
        this.f١٧١١a.animate().scaleX(f11).scaleY(f11).setDuration(j10).setInterpolator(new c()).setListener(new a(z10)).start();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        b(false);
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.app.Dialog
    public void show() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        b(true);
        super.show();
    }
}
