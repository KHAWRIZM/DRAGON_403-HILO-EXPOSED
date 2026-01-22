package com.google.android.material.circularreveal;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.circularreveal.c;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final a f٨٧٨٨a;

    /* renamed from: b, reason: collision with root package name */
    private final View f٨٧٨٩b;

    /* renamed from: c, reason: collision with root package name */
    private final Path f٨٧٩٠c;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f٨٧٩١d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f٨٧٩٢e;

    /* renamed from: f, reason: collision with root package name */
    private c.e f٨٧٩٣f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f٨٧٩٤g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٨٧٩٥h;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface a {
        void e(Canvas canvas);

        boolean l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(a aVar) {
        this.f٨٧٨٨a = aVar;
        View view = (View) aVar;
        this.f٨٧٨٩b = view;
        view.setWillNotDraw(false);
        this.f٨٧٩٠c = new Path();
        this.f٨٧٩١d = new Paint(7);
        Paint paint = new Paint(1);
        this.f٨٧٩٢e = paint;
        paint.setColor(0);
    }

    private void d(Canvas canvas) {
        if (o()) {
            Rect bounds = this.f٨٧٩٤g.getBounds();
            float width = this.f٨٧٩٣f.f٨٨٠٠a - (bounds.width() / 2.0f);
            float height = this.f٨٧٩٣f.f٨٨٠١b - (bounds.height() / 2.0f);
            canvas.translate(width, height);
            this.f٨٧٩٤g.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    private float g(c.e eVar) {
        return z7.a.c(eVar.f٨٨٠٠a, eVar.f٨٨٠١b, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.f٨٧٨٩b.getWidth(), this.f٨٧٨٩b.getHeight());
    }

    private void i() {
        this.f٨٧٨٩b.invalidate();
    }

    private boolean n() {
        boolean z10;
        c.e eVar = this.f٨٧٩٣f;
        if (eVar != null && !eVar.a()) {
            z10 = false;
        } else {
            z10 = true;
        }
        return !z10;
    }

    private boolean o() {
        if (!this.f٨٧٩٥h && this.f٨٧٩٤g != null && this.f٨٧٩٣f != null) {
            return true;
        }
        return false;
    }

    private boolean p() {
        if (!this.f٨٧٩٥h && Color.alpha(this.f٨٧٩٢e.getColor()) != 0) {
            return true;
        }
        return false;
    }

    public void a() {
    }

    public void b() {
    }

    public void c(Canvas canvas) {
        if (n()) {
            this.f٨٧٨٨a.e(canvas);
            if (p()) {
                canvas.drawRect(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.f٨٧٨٩b.getWidth(), this.f٨٧٨٩b.getHeight(), this.f٨٧٩٢e);
            }
        } else {
            this.f٨٧٨٨a.e(canvas);
            if (p()) {
                canvas.drawRect(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.f٨٧٨٩b.getWidth(), this.f٨٧٨٩b.getHeight(), this.f٨٧٩٢e);
            }
        }
        d(canvas);
    }

    public Drawable e() {
        return this.f٨٧٩٤g;
    }

    public int f() {
        return this.f٨٧٩٢e.getColor();
    }

    public c.e h() {
        c.e eVar = this.f٨٧٩٣f;
        if (eVar == null) {
            return null;
        }
        c.e eVar2 = new c.e(eVar);
        if (eVar2.a()) {
            eVar2.f٨٨٠٢c = g(eVar2);
        }
        return eVar2;
    }

    public boolean j() {
        if (this.f٨٧٨٨a.l() && !n()) {
            return true;
        }
        return false;
    }

    public void k(Drawable drawable) {
        this.f٨٧٩٤g = drawable;
        this.f٨٧٨٩b.invalidate();
    }

    public void l(int i10) {
        this.f٨٧٩٢e.setColor(i10);
        this.f٨٧٨٩b.invalidate();
    }

    public void m(c.e eVar) {
        if (eVar == null) {
            this.f٨٧٩٣f = null;
        } else {
            c.e eVar2 = this.f٨٧٩٣f;
            if (eVar2 == null) {
                this.f٨٧٩٣f = new c.e(eVar);
            } else {
                eVar2.c(eVar);
            }
            if (z7.a.e(eVar.f٨٨٠٢c, g(eVar), 1.0E-4f)) {
                this.f٨٧٩٣f.f٨٨٠٢c = Float.MAX_VALUE;
            }
        }
        i();
    }
}
