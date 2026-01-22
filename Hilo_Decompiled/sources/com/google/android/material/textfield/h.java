package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class h extends f8.i {
    b J;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c extends h {
        c(b bVar) {
            super(bVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // f8.i
        public void w(Canvas canvas) {
            if (this.J.f١٠٢٠٧x.isEmpty()) {
                super.w(canvas);
                return;
            }
            canvas.save();
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutRect(this.J.f١٠٢٠٧x);
            } else {
                canvas.clipRect(this.J.f١٠٢٠٧x, Region.Op.DIFFERENCE);
            }
            super.w(canvas);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static h C0(b bVar) {
        return new c(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h D0(f8.o oVar) {
        if (oVar == null) {
            oVar = new f8.o();
        }
        return C0(new b(oVar, new RectF()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E0() {
        return !this.J.f١٠٢٠٧x.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F0() {
        G0(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
    }

    void G0(float f10, float f11, float f12, float f13) {
        if (f10 != this.J.f١٠٢٠٧x.left || f11 != this.J.f١٠٢٠٧x.top || f12 != this.J.f١٠٢٠٧x.right || f13 != this.J.f١٠٢٠٧x.bottom) {
            this.J.f١٠٢٠٧x.set(f10, f11, f12, f13);
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H0(RectF rectF) {
        G0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // f8.i, android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.J = new b(this.J);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b extends i.c {

        /* renamed from: x, reason: collision with root package name */
        private final RectF f١٠٢٠٧x;

        @Override // f8.i.c, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            h C0 = h.C0(this);
            C0.invalidateSelf();
            return C0;
        }

        private b(f8.o oVar, RectF rectF) {
            super(oVar, null);
            this.f١٠٢٠٧x = rectF;
        }

        private b(b bVar) {
            super(bVar);
            this.f١٠٢٠٧x = bVar.f١٠٢٠٧x;
        }
    }

    private h(b bVar) {
        super(bVar);
        this.J = bVar;
    }
}
