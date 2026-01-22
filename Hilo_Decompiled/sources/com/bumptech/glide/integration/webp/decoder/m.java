package com.bumptech.glide.integration.webp.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.webp.decoder.r;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class m extends Drawable implements r.b, Animatable {

    /* renamed from: a, reason: collision with root package name */
    private final a f٧٣٤٥a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٧٣٤٦b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٧٣٤٧c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٧٣٤٨d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٧٣٤٩e;

    /* renamed from: f, reason: collision with root package name */
    private int f٧٣٥٠f;

    /* renamed from: g, reason: collision with root package name */
    private int f٧٣٥١g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٧٣٥٢h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f٧٣٥٣i;

    /* renamed from: j, reason: collision with root package name */
    private Rect f٧٣٥٤j;

    /* renamed from: k, reason: collision with root package name */
    private List f٧٣٥٥k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        final p4.d f٧٣٥٦a;

        /* renamed from: b, reason: collision with root package name */
        final r f٧٣٥٧b;

        public a(p4.d dVar, r rVar) {
            this.f٧٣٥٦a = dVar;
            this.f٧٣٥٧b = rVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new m(this);
        }
    }

    public m(Context context, j jVar, p4.d dVar, m4.m mVar, int i10, int i11, Bitmap bitmap) {
        this(new a(dVar, new r(Glide.get(context), jVar, i10, i11, mVar, bitmap)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect d() {
        if (this.f٧٣٥٤j == null) {
            this.f٧٣٥٤j = new Rect();
        }
        return this.f٧٣٥٤j;
    }

    private Paint h() {
        if (this.f٧٣٥٣i == null) {
            this.f٧٣٥٣i = new Paint(2);
        }
        return this.f٧٣٥٣i;
    }

    private void k() {
        List list = this.f٧٣٥٥k;
        if (list != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((androidx.vectordrawable.graphics.drawable.b) this.f٧٣٥٥k.get(i10)).b(this);
            }
        }
    }

    private void m() {
        this.f٧٣٥٠f = 0;
    }

    private void p() {
        f5.k.a(!this.f٧٣٤٨d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f٧٣٤٥a.f٧٣٥٧b.f() == 1) {
            invalidateSelf();
        } else if (!this.f٧٣٤٦b) {
            this.f٧٣٤٦b = true;
            this.f٧٣٤٥a.f٧٣٥٧b.s(this);
            invalidateSelf();
        }
    }

    private void q() {
        this.f٧٣٤٦b = false;
        this.f٧٣٤٥a.f٧٣٥٧b.t(this);
    }

    @Override // com.bumptech.glide.integration.webp.decoder.r.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f٧٣٥٠f++;
        }
        int i10 = this.f٧٣٥١g;
        if (i10 != -1 && this.f٧٣٥٠f >= i10) {
            stop();
            k();
        }
    }

    public ByteBuffer c() {
        return this.f٧٣٤٥a.f٧٣٥٧b.b();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (j()) {
            return;
        }
        if (this.f٧٣٥٢h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.f٧٣٥٢h = false;
        }
        canvas.drawBitmap(this.f٧٣٤٥a.f٧٣٥٧b.c(), (Rect) null, d(), h());
    }

    public Bitmap e() {
        return this.f٧٣٤٥a.f٧٣٥٧b.e();
    }

    public int f() {
        return this.f٧٣٤٥a.f٧٣٥٧b.f();
    }

    public int g() {
        return this.f٧٣٤٥a.f٧٣٥٧b.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f٧٣٤٥a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f٧٣٤٥a.f٧٣٥٧b.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f٧٣٤٥a.f٧٣٥٧b.l();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public int i() {
        return this.f٧٣٤٥a.f٧٣٥٧b.k();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f٧٣٤٦b;
    }

    boolean j() {
        return this.f٧٣٤٨d;
    }

    public void l() {
        this.f٧٣٤٨d = true;
        this.f٧٣٤٥a.f٧٣٥٧b.a();
    }

    public void n(m4.m mVar, Bitmap bitmap) {
        this.f٧٣٤٥a.f٧٣٥٧b.p(mVar, bitmap);
    }

    public void o(int i10) {
        int i11 = -1;
        if (i10 <= 0 && i10 != -1 && i10 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to LOOP_FOREVER, or equal to LOOP_INTRINSIC");
        }
        if (i10 == 0) {
            int i12 = this.f٧٣٤٥a.f٧٣٥٧b.i();
            if (i12 != 0) {
                i11 = i12;
            }
            this.f٧٣٥١g = i11;
            return;
        }
        this.f٧٣٥١g = i10;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f٧٣٥٢h = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        h().setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        f5.k.a(!this.f٧٣٤٨d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f٧٣٤٩e = z10;
        if (!z10) {
            q();
        } else if (this.f٧٣٤٧c) {
            p();
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f٧٣٤٧c = true;
        m();
        if (this.f٧٣٤٩e) {
            p();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f٧٣٤٧c = false;
        q();
    }

    m(a aVar) {
        this.f٧٣٥١g = -1;
        this.f٧٣٤٩e = true;
        this.f٧٣٤٥a = (a) f5.k.d(aVar);
        o(0);
    }
}
