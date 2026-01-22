package h2;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j extends i {

    /* renamed from: h, reason: collision with root package name */
    private static Method f١٤٥٠٠h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Drawable drawable) {
        super(drawable);
        g();
    }

    private void g() {
        if (f١٤٥٠٠h == null) {
            try {
                f١٤٥٠٠h = Drawable.class.getDeclaredMethod("isProjected", null);
            } catch (Exception e10) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e10);
            }
        }
    }

    @Override // h2.i
    protected boolean c() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f١٤٤٩٩f.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f١٤٤٩٩f.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f١٤٤٩٩f;
        if (drawable != null && (method = f١٤٥٠٠h) != null) {
            try {
                return ((Boolean) method.invoke(drawable, null)).booleanValue();
            } catch (Exception e10) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e10);
                return false;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f10, float f11) {
        this.f١٤٤٩٩f.setHotspot(f10, f11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i10, int i11, int i12, int i13) {
        this.f١٤٤٩٩f.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // h2.i, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (super.setState(iArr)) {
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // h2.i, android.graphics.drawable.Drawable
    public void setTint(int i10) {
        if (c()) {
            super.setTint(i10);
        } else {
            this.f١٤٤٩٩f.setTint(i10);
        }
    }

    @Override // h2.i, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.f١٤٤٩٩f.setTintList(colorStateList);
        }
    }

    @Override // h2.i, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.f١٤٤٩٩f.setTintMode(mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(k kVar, Resources resources) {
        super(kVar, resources);
        g();
    }
}
