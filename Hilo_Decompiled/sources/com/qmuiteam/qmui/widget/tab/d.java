package com.qmuiteam.qmui.widget.tab;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import ic.g;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class d extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f١٣٤٢٢a;

    /* renamed from: b, reason: collision with root package name */
    private Drawable f١٣٤٢٣b;

    /* renamed from: c, reason: collision with root package name */
    private float f١٣٤٢٤c = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٣٤٢٥d;

    public d(Drawable drawable, Drawable drawable2, boolean z10) {
        this.f١٣٤٢٥d = true;
        Drawable mutate = drawable.mutate();
        this.f١٣٤٢٢a = mutate;
        mutate.setCallback(this);
        if (drawable2 != null) {
            Drawable mutate2 = drawable2.mutate();
            this.f١٣٤٢٣b = mutate2;
            mutate2.setCallback(this);
        }
        this.f١٣٤٢٢a.setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
        int intrinsicWidth = this.f١٣٤٢٢a.getIntrinsicWidth();
        int intrinsicHeight = this.f١٣٤٢٢a.getIntrinsicHeight();
        this.f١٣٤٢٢a.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        Drawable drawable3 = this.f١٣٤٢٣b;
        if (drawable3 != null) {
            drawable3.setAlpha(0);
            this.f١٣٤٢٣b.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        this.f١٣٤٢٥d = z10;
    }

    public boolean a() {
        if (this.f١٣٤٢٣b != null) {
            return true;
        }
        return false;
    }

    public void b(float f10, int i10) {
        float b10 = g.b(f10, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        this.f١٣٤٢٤c = b10;
        if (this.f١٣٤٢٣b == null) {
            if (this.f١٣٤٢٥d) {
                h2.b.n(this.f١٣٤٢٢a, i10);
            }
        } else {
            int i11 = (int) ((1.0f - b10) * 255.0f);
            this.f١٣٤٢٢a.setAlpha(i11);
            this.f١٣٤٢٣b.setAlpha(255 - i11);
        }
        invalidateSelf();
    }

    public void c(Drawable drawable, int i10, int i11) {
        this.f١٣٤٢٢a.setCallback(this);
        Drawable mutate = drawable.mutate();
        this.f١٣٤٢٢a = mutate;
        mutate.setCallback(this);
        Drawable drawable2 = this.f١٣٤٢٣b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            this.f١٣٤٢٣b = null;
        }
        if (this.f١٣٤٢٥d) {
            h2.b.n(this.f١٣٤٢٢a, ic.c.a(i10, i11, this.f١٣٤٢٤c));
        }
        invalidateSelf();
    }

    public void d(Drawable drawable) {
        int i10 = (int) ((1.0f - this.f١٣٤٢٤c) * 255.0f);
        this.f١٣٤٢٢a.setCallback(null);
        Drawable mutate = drawable.mutate();
        this.f١٣٤٢٢a = mutate;
        mutate.setCallback(this);
        this.f١٣٤٢٢a.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f١٣٤٢٢a.draw(canvas);
        Drawable drawable = this.f١٣٤٢٣b;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    public void e(Drawable drawable) {
        int i10 = (int) (this.f١٣٤٢٤c * 255.0f);
        Drawable drawable2 = this.f١٣٤٢٣b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        Drawable mutate = drawable.mutate();
        this.f١٣٤٢٣b = mutate;
        mutate.setCallback(this);
        this.f١٣٤٢٣b.setAlpha(i10);
        invalidateSelf();
    }

    public void f(int i10, int i11) {
        if (this.f١٣٤٢٣b == null) {
            h2.b.n(this.f١٣٤٢٢a, ic.c.a(i10, i11, this.f١٣٤٢٤c));
        } else {
            h2.b.n(this.f١٣٤٢٢a, i10);
            h2.b.n(this.f١٣٤٢٣b, i11);
        }
        invalidateSelf();
    }

    public void g(int i10) {
        h2.b.n(this.f١٣٤٢٢a, i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f١٣٤٢٢a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f١٣٤٢٢a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(int i10) {
        Drawable drawable = this.f١٣٤٢٣b;
        if (drawable != null) {
            h2.b.n(drawable, i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(drawable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f١٣٤٢٢a.setBounds(rect);
        Drawable drawable = this.f١٣٤٢٣b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(drawable, runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(drawable, runnable);
        }
    }
}
