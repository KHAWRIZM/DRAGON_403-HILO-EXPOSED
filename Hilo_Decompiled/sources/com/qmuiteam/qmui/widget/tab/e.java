package com.qmuiteam.qmui.widget.tab;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import ic.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private int f١٣٤٢٦a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٣٤٢٧b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f١٣٤٢٨c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٣٤٢٩d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f١٣٤٣٠e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f١٣٤٣١f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٣٤٣٢g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١٣٤٣٣h;

    /* renamed from: i, reason: collision with root package name */
    private int f١٣٤٣٤i;

    public e(int i10, boolean z10, boolean z11) {
        this(i10, z10, z11, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, Canvas canvas, int i10, int i11) {
        if (this.f١٣٤٣٠e != null) {
            int i12 = this.f١٣٤٣٢g;
            if (i12 != 0 && this.f١٣٤٣٣h) {
                this.f١٣٤٣٣h = false;
                int a10 = dc.d.a(view, i12);
                this.f١٣٤٣٤i = a10;
                d(a10);
            }
            if (this.f١٣٤٢٧b) {
                Rect rect = this.f١٣٤٣٠e;
                rect.top = i10;
                rect.bottom = i10 + this.f١٣٤٢٦a;
            } else {
                Rect rect2 = this.f١٣٤٣٠e;
                rect2.bottom = i11;
                rect2.top = i11 - this.f١٣٤٢٦a;
            }
            Drawable drawable = this.f١٣٤٢٨c;
            if (drawable != null) {
                drawable.setBounds(this.f١٣٤٣٠e);
                this.f١٣٤٢٨c.draw(canvas);
            } else {
                canvas.drawRect(this.f١٣٤٣٠e, this.f١٣٤٣١f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(dc.e eVar, int i10, Resources.Theme theme, a aVar) {
        int c10;
        this.f١٣٤٣٣h = true;
        if (aVar != null && this.f١٣٤٣٢g == 0) {
            int i11 = aVar.f١٣٣٧٨k;
            if (i11 == 0) {
                c10 = aVar.f١٣٣٧٦i;
            } else {
                c10 = i.c(theme, i11);
            }
            d(c10);
        }
    }

    public boolean c() {
        return this.f١٣٤٢٩d;
    }

    protected void d(int i10) {
        Drawable drawable = this.f١٣٤٢٨c;
        if (drawable != null) {
            h2.b.n(drawable, i10);
            return;
        }
        if (this.f١٣٤٣١f == null) {
            Paint paint = new Paint();
            this.f١٣٤٣١f = paint;
            paint.setStyle(Paint.Style.FILL);
        }
        this.f١٣٤٣١f.setColor(i10);
    }

    protected void e(int i10, int i11, int i12) {
        Rect rect = this.f١٣٤٣٠e;
        if (rect == null) {
            this.f١٣٤٣٠e = new Rect(i10, 0, i11 + i10, 0);
        } else {
            rect.left = i10;
            rect.right = i10 + i11;
        }
        if (this.f١٣٤٣٢g == 0) {
            d(i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int i10, int i11, int i12, float f10) {
        e(i10, i11, i12);
    }

    public e(int i10, boolean z10, boolean z11, int i11) {
        this.f١٣٤٣٠e = null;
        this.f١٣٤٣١f = null;
        this.f١٣٤٣٣h = true;
        this.f١٣٤٣٤i = 0;
        this.f١٣٤٢٦a = i10;
        this.f١٣٤٢٧b = z10;
        this.f١٣٤٢٩d = z11;
        this.f١٣٤٣٢g = i11;
    }
}
