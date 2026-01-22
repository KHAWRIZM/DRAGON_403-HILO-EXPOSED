package h2;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class i extends Drawable implements Drawable.Callback, h, g {

    /* renamed from: g, reason: collision with root package name */
    static final PorterDuff.Mode f١٤٤٩٣g = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    private int f١٤٤٩٤a;

    /* renamed from: b, reason: collision with root package name */
    private PorterDuff.Mode f١٤٤٩٥b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٤٤٩٦c;

    /* renamed from: d, reason: collision with root package name */
    k f١٤٤٩٧d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f١٤٤٩٨e;

    /* renamed from: f, reason: collision with root package name */
    Drawable f١٤٤٩٩f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(k kVar, Resources resources) {
        this.f١٤٤٩٧d = kVar;
        e(resources);
    }

    private k d() {
        return new k(this.f١٤٤٩٧d);
    }

    private void e(Resources resources) {
        Drawable.ConstantState constantState;
        k kVar = this.f١٤٤٩٧d;
        if (kVar != null && (constantState = kVar.f١٤٥٠٢b) != null) {
            b(constantState.newDrawable(resources));
        }
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        k kVar = this.f١٤٤٩٧d;
        ColorStateList colorStateList = kVar.f١٤٥٠٣c;
        PorterDuff.Mode mode = kVar.f١٤٥٠٤d;
        if (colorStateList != null && mode != null) {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f١٤٤٩٦c || colorForState != this.f١٤٤٩٤a || mode != this.f١٤٤٩٥b) {
                setColorFilter(colorForState, mode);
                this.f١٤٤٩٤a = colorForState;
                this.f١٤٤٩٥b = mode;
                this.f١٤٤٩٦c = true;
                return true;
            }
        } else {
            this.f١٤٤٩٦c = false;
            clearColorFilter();
        }
        return false;
    }

    @Override // h2.h
    public final Drawable a() {
        return this.f١٤٤٩٩f;
    }

    @Override // h2.h
    public final void b(Drawable drawable) {
        Drawable drawable2 = this.f١٤٤٩٩f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f١٤٤٩٩f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            k kVar = this.f١٤٤٩٧d;
            if (kVar != null) {
                kVar.f١٤٥٠٢b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected abstract boolean c();

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f١٤٤٩٩f.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int i10;
        int changingConfigurations = super.getChangingConfigurations();
        k kVar = this.f١٤٤٩٧d;
        if (kVar != null) {
            i10 = kVar.getChangingConfigurations();
        } else {
            i10 = 0;
        }
        return changingConfigurations | i10 | this.f١٤٤٩٩f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        k kVar = this.f١٤٤٩٧d;
        if (kVar != null && kVar.a()) {
            this.f١٤٤٩٧d.f١٤٥٠١a = getChangingConfigurations();
            return this.f١٤٤٩٧d;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f١٤٤٩٩f.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f١٤٤٩٩f.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f١٤٤٩٩f.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return b.f(this.f١٤٤٩٩f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f١٤٤٩٩f.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f١٤٤٩٩f.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f١٤٤٩٩f.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f١٤٤٩٩f.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f١٤٤٩٩f.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f١٤٤٩٩f.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return b.h(this.f١٤٤٩٩f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        k kVar;
        if (c() && (kVar = this.f١٤٤٩٧d) != null) {
            colorStateList = kVar.f١٤٥٠٣c;
        } else {
            colorStateList = null;
        }
        if ((colorStateList != null && colorStateList.isStateful()) || this.f١٤٤٩٩f.isStateful()) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f١٤٤٩٩f.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable.ConstantState constantState;
        if (!this.f١٤٤٩٨e && super.mutate() == this) {
            this.f١٤٤٩٧d = d();
            Drawable drawable = this.f١٤٤٩٩f;
            if (drawable != null) {
                drawable.mutate();
            }
            k kVar = this.f١٤٤٩٧d;
            if (kVar != null) {
                Drawable drawable2 = this.f١٤٤٩٩f;
                if (drawable2 != null) {
                    constantState = drawable2.getConstantState();
                } else {
                    constantState = null;
                }
                kVar.f١٤٥٠٢b = constantState;
            }
            this.f١٤٤٩٨e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f١٤٤٩٩f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        return b.m(this.f١٤٤٩٩f, i10);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i10) {
        return this.f١٤٤٩٩f.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f١٤٤٩٩f.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        b.j(this.f١٤٤٩٩f, z10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i10) {
        this.f١٤٤٩٩f.setChangingConfigurations(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f١٤٤٩٩f.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        this.f١٤٤٩٩f.setDither(z10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.f١٤٤٩٩f.setFilterBitmap(z10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        boolean state = this.f١٤٤٩٩f.setState(iArr);
        if (!f(iArr) && !state) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f١٤٤٩٧d.f١٤٥٠٣c = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f١٤٤٩٧d.f١٤٥٠٤d = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        if (!super.setVisible(z10, z11) && !this.f١٤٤٩٩f.setVisible(z10, z11)) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Drawable drawable) {
        this.f١٤٤٩٧d = d();
        b(drawable);
    }
}
