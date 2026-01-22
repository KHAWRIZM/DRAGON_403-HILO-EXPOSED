package com.bumptech.glide.load.resource.gif;

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
import com.bumptech.glide.load.resource.gif.g;
import f5.k;
import java.nio.ByteBuffer;
import java.util.List;
import m4.m;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c extends Drawable implements g.b, Animatable {

    /* renamed from: a, reason: collision with root package name */
    private final a f٧٤٧٦a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٧٤٧٧b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٧٤٧٨c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٧٤٧٩d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٧٤٨٠e;

    /* renamed from: f, reason: collision with root package name */
    private int f٧٤٨١f;

    /* renamed from: g, reason: collision with root package name */
    private int f٧٤٨٢g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٧٤٨٣h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f٧٤٨٤i;

    /* renamed from: j, reason: collision with root package name */
    private Rect f٧٤٨٥j;

    /* renamed from: k, reason: collision with root package name */
    private List f٧٤٨٦k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        final g f٧٤٨٧a;

        a(g gVar) {
            this.f٧٤٨٧a = gVar;
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
            return new c(this);
        }
    }

    public c(Context context, l4.a aVar, m mVar, int i10, int i11, Bitmap bitmap) {
        this(new a(new g(Glide.get(context), aVar, i10, i11, mVar, bitmap)));
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
        if (this.f٧٤٨٥j == null) {
            this.f٧٤٨٥j = new Rect();
        }
        return this.f٧٤٨٥j;
    }

    private Paint h() {
        if (this.f٧٤٨٤i == null) {
            this.f٧٤٨٤i = new Paint(2);
        }
        return this.f٧٤٨٤i;
    }

    private void j() {
        List list = this.f٧٤٨٦k;
        if (list != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((androidx.vectordrawable.graphics.drawable.b) this.f٧٤٨٦k.get(i10)).b(this);
            }
        }
    }

    private void l() {
        this.f٧٤٨١f = 0;
    }

    private void n() {
        k.a(!this.f٧٤٧٩d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f٧٤٧٦a.f٧٤٨٧a.f() == 1) {
            invalidateSelf();
        } else if (!this.f٧٤٧٧b) {
            this.f٧٤٧٧b = true;
            this.f٧٤٧٦a.f٧٤٨٧a.r(this);
            invalidateSelf();
        }
    }

    private void o() {
        this.f٧٤٧٧b = false;
        this.f٧٤٧٦a.f٧٤٨٧a.s(this);
    }

    @Override // com.bumptech.glide.load.resource.gif.g.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f٧٤٨١f++;
        }
        int i10 = this.f٧٤٨٢g;
        if (i10 != -1 && this.f٧٤٨١f >= i10) {
            j();
            stop();
        }
    }

    public ByteBuffer c() {
        return this.f٧٤٧٦a.f٧٤٨٧a.b();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f٧٤٧٩d) {
            return;
        }
        if (this.f٧٤٨٣h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.f٧٤٨٣h = false;
        }
        canvas.drawBitmap(this.f٧٤٧٦a.f٧٤٨٧a.c(), (Rect) null, d(), h());
    }

    public Bitmap e() {
        return this.f٧٤٧٦a.f٧٤٨٧a.e();
    }

    public int f() {
        return this.f٧٤٧٦a.f٧٤٨٧a.f();
    }

    public int g() {
        return this.f٧٤٧٦a.f٧٤٨٧a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f٧٤٧٦a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f٧٤٧٦a.f٧٤٨٧a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f٧٤٧٦a.f٧٤٨٧a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public int i() {
        return this.f٧٤٧٦a.f٧٤٨٧a.j();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f٧٤٧٧b;
    }

    public void k() {
        this.f٧٤٧٩d = true;
        this.f٧٤٧٦a.f٧٤٨٧a.a();
    }

    public void m(m mVar, Bitmap bitmap) {
        this.f٧٤٧٦a.f٧٤٨٧a.o(mVar, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f٧٤٨٣h = true;
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
        k.a(!this.f٧٤٧٩d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f٧٤٨٠e = z10;
        if (!z10) {
            o();
        } else if (this.f٧٤٧٨c) {
            n();
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f٧٤٧٨c = true;
        l();
        if (this.f٧٤٨٠e) {
            n();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f٧٤٧٨c = false;
        o();
    }

    c(a aVar) {
        this.f٧٤٨٠e = true;
        this.f٧٤٨٢g = -1;
        this.f٧٤٧٦a = (a) k.d(aVar);
    }
}
