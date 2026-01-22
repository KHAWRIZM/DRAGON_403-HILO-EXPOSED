package com.google.android.material.loadingindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.j;
import com.google.android.material.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b extends Drawable implements Drawable.Callback {

    /* renamed from: b, reason: collision with root package name */
    private final Context f٩٣٨٢b;

    /* renamed from: c, reason: collision with root package name */
    private final d f٩٣٨٣c;

    /* renamed from: d, reason: collision with root package name */
    private c f٩٣٨٤d;

    /* renamed from: e, reason: collision with root package name */
    private a f٩٣٨٥e;

    /* renamed from: g, reason: collision with root package name */
    int f٩٣٨٧g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f٩٣٨٨h;

    /* renamed from: a, reason: collision with root package name */
    b8.a f٩٣٨١a = new b8.a();

    /* renamed from: f, reason: collision with root package name */
    Paint f٩٣٨٦f = new Paint();

    b(Context context, d dVar, c cVar, a aVar) {
        this.f٩٣٨٢b = context;
        this.f٩٣٨٣c = dVar;
        this.f٩٣٨٤d = cVar;
        this.f٩٣٨٥e = aVar;
        aVar.j(this);
        setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
    }

    public static b a(Context context, d dVar) {
        b bVar = new b(context, dVar, new c(dVar), new a(dVar));
        bVar.e(j.b(context.getResources(), R.drawable.ic_mtrl_arrow_circle, null));
        return bVar;
    }

    private boolean d() {
        b8.a aVar = this.f٩٣٨١a;
        if (aVar == null || aVar.a(this.f٩٣٨٢b.getContentResolver()) != DownloadProgress.UNKNOWN_PROGRESS) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a b() {
        return this.f٩٣٨٥e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c c() {
        return this.f٩٣٨٤d;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable;
        Rect rect = new Rect();
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            if (d() && (drawable = this.f٩٣٨٨h) != null) {
                drawable.setBounds(bounds);
                this.f٩٣٨٨h.setTint(this.f٩٣٨٣c.f٩٤٠١e[0]);
                this.f٩٣٨٨h.draw(canvas);
            } else {
                canvas.save();
                this.f٩٣٨٤d.a(canvas, bounds);
                this.f٩٣٨٤d.b(canvas, this.f٩٣٨٦f, this.f٩٣٨٣c.f٩٤٠٢f, getAlpha());
                this.f٩٣٨٤d.c(canvas, this.f٩٣٨٦f, this.f٩٣٨٥e.f٩٣٧٩h, getAlpha());
                canvas.restore();
            }
        }
    }

    public void e(Drawable drawable) {
        this.f٩٣٨٨h = drawable;
    }

    public boolean f(boolean z10, boolean z11, boolean z12) {
        boolean visible = super.setVisible(z10, z11);
        this.f٩٣٨٥e.e();
        if (z10 && z12 && !d()) {
            this.f٩٣٨٥e.n();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f٩٣٨٧g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f٩٣٨٤d.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f٩٣٨٤d.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f٩٣٨٧g != i10) {
            this.f٩٣٨٧g = i10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f٩٣٨٦f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        return f(z10, z11, z10);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
