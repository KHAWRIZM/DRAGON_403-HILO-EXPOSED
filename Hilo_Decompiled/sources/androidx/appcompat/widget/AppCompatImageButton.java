package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AppCompatImageButton extends ImageButton implements androidx.core.view.y0 {

    /* renamed from: a, reason: collision with root package name */
    private final c f١٢٦٧a;

    /* renamed from: b, reason: collision with root package name */
    private final j f١٢٦٨b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٢٦٩c;

    public AppCompatImageButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        c cVar = this.f١٢٦٧a;
        if (cVar != null) {
            cVar.b();
        }
        j jVar = this.f١٢٦٨b;
        if (jVar != null) {
            jVar.c();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        c cVar = this.f١٢٦٧a;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        c cVar = this.f١٢٦٧a;
        if (cVar != null) {
            return cVar.d();
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportImageTintList() {
        j jVar = this.f١٢٦٨b;
        if (jVar != null) {
            return jVar.d();
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportImageTintMode() {
        j jVar = this.f١٢٦٨b;
        if (jVar != null) {
            return jVar.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        if (this.f١٢٦٨b.f() && super.hasOverlappingRendering()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        c cVar = this.f١٢٦٧a;
        if (cVar != null) {
            cVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        c cVar = this.f١٢٦٧a;
        if (cVar != null) {
            cVar.g(i10);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        j jVar = this.f١٢٦٨b;
        if (jVar != null) {
            jVar.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        j jVar = this.f١٢٦٨b;
        if (jVar != null && drawable != null && !this.f١٢٦٩c) {
            jVar.h(drawable);
        }
        super.setImageDrawable(drawable);
        j jVar2 = this.f١٢٦٨b;
        if (jVar2 != null) {
            jVar2.c();
            if (!this.f١٢٦٩c) {
                this.f١٢٦٨b.b();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i10) {
        super.setImageLevel(i10);
        this.f١٢٦٩c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        this.f١٢٦٨b.i(i10);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        j jVar = this.f١٢٦٨b;
        if (jVar != null) {
            jVar.c();
        }
    }

    @Override // androidx.core.view.y0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        c cVar = this.f١٢٦٧a;
        if (cVar != null) {
            cVar.i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        c cVar = this.f١٢٦٧a;
        if (cVar != null) {
            cVar.j(mode);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintList(ColorStateList colorStateList) {
        j jVar = this.f١٢٦٨b;
        if (jVar != null) {
            jVar.j(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        j jVar = this.f١٢٦٨b;
        if (jVar != null) {
            jVar.k(mode);
        }
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i10) {
        super(m0.b(context), attributeSet, i10);
        this.f١٢٦٩c = false;
        l0.a(this, getContext());
        c cVar = new c(this);
        this.f١٢٦٧a = cVar;
        cVar.e(attributeSet, i10);
        j jVar = new j(this);
        this.f١٢٦٨b = jVar;
        jVar.g(attributeSet, i10);
    }
}
