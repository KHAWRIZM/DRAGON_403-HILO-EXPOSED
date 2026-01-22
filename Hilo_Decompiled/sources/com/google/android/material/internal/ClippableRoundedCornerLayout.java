package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ClippableRoundedCornerLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private Path f٩١٧٨a;

    /* renamed from: b, reason: collision with root package name */
    private float[] f٩١٧٩b;

    public ClippableRoundedCornerLayout(Context context) {
        super(context);
        this.f٩١٧٩b = new float[]{DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS};
    }

    public void a() {
        this.f٩١٧٨a = null;
        this.f٩١٧٩b = new float[]{DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS};
        invalidate();
    }

    public void b(float f10, float f11, float f12, float f13, float[] fArr) {
        d(new RectF(f10, f11, f12, f13), fArr);
    }

    public void c(Rect rect, float[] fArr) {
        b(rect.left, rect.top, rect.right, rect.bottom, fArr);
    }

    public void d(RectF rectF, float[] fArr) {
        if (this.f٩١٧٨a == null) {
            this.f٩١٧٨a = new Path();
        }
        this.f٩١٧٩b = fArr;
        this.f٩١٧٨a.reset();
        this.f٩١٧٨a.addRoundRect(rectF, fArr, Path.Direction.CW);
        this.f٩١٧٨a.close();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f٩١٧٨a == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.f٩١٧٨a);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public void e(float[] fArr) {
        b(getLeft(), getTop(), getRight(), getBottom(), fArr);
    }

    public float[] getCornerRadii() {
        return this.f٩١٧٩b;
    }

    public ClippableRoundedCornerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٩١٧٩b = new float[]{DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS};
    }

    public ClippableRoundedCornerLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٩١٧٩b = new float[]{DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS};
    }
}
