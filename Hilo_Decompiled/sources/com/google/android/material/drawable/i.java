package com.google.android.material.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class i extends s1.c {

    /* renamed from: b, reason: collision with root package name */
    private a f٩٠١٠b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٩٠١١c;

    public i(Drawable drawable, int i10, int i11) {
        super(drawable);
        this.f٩٠١٠b = new a(c(drawable), i10, i11);
    }

    private Drawable.ConstantState c(Drawable drawable) {
        if (drawable != null) {
            return drawable.getConstantState();
        }
        return null;
    }

    @Override // s1.c
    public void b(Drawable drawable) {
        super.b(drawable);
        a aVar = this.f٩٠١٠b;
        if (aVar != null) {
            aVar.f٩٠١٢a = c(drawable);
            this.f٩٠١١c = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f٩٠١٠b.d()) {
            return this.f٩٠١٠b;
        }
        return null;
    }

    @Override // s1.c, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f٩٠١٠b.f٩٠١٤c;
    }

    @Override // s1.c, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f٩٠١٠b.f٩٠١٣b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f٩٠١١c && super.mutate() == this) {
            Drawable a10 = a();
            if (a10 != null) {
                a10.mutate();
            }
            this.f٩٠١٠b = new a(c(a10), this.f٩٠١٠b.f٩٠١٣b, this.f٩٠١٠b.f٩٠١٤c);
            this.f٩٠١١c = true;
        }
        return this;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        private Drawable.ConstantState f٩٠١٢a;

        /* renamed from: b, reason: collision with root package name */
        private final int f٩٠١٣b;

        /* renamed from: c, reason: collision with root package name */
        private final int f٩٠١٤c;

        a(Drawable.ConstantState constantState, int i10, int i11) {
            this.f٩٠١٢a = constantState;
            this.f٩٠١٣b = i10;
            this.f٩٠١٤c = i11;
        }

        boolean d() {
            if (this.f٩٠١٢a != null) {
                return true;
            }
            return false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            Drawable.ConstantState constantState = this.f٩٠١٢a;
            if (constantState != null) {
                return constantState.getChangingConfigurations();
            }
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new i(this.f٩٠١٢a.newDrawable(), this.f٩٠١٣b, this.f٩٠١٤c);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new i(this.f٩٠١٢a.newDrawable(resources), this.f٩٠١٣b, this.f٩٠١٤c);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            return new i(this.f٩٠١٢a.newDrawable(resources, theme), this.f٩٠١٣b, this.f٩٠١٤c);
        }
    }
}
