package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.res.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class p0 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f١٦٢٤a;

    /* renamed from: b, reason: collision with root package name */
    private final TypedArray f١٦٢٥b;

    /* renamed from: c, reason: collision with root package name */
    private TypedValue f١٦٢٦c;

    private p0(Context context, TypedArray typedArray) {
        this.f١٦٢٤a = context;
        this.f١٦٢٥b = typedArray;
    }

    public static p0 t(Context context, int i10, int[] iArr) {
        return new p0(context, context.obtainStyledAttributes(i10, iArr));
    }

    public static p0 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new p0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static p0 v(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11) {
        return new p0(context, context.obtainStyledAttributes(attributeSet, iArr, i10, i11));
    }

    public boolean a(int i10, boolean z10) {
        return this.f١٦٢٥b.getBoolean(i10, z10);
    }

    public int b(int i10, int i11) {
        return this.f١٦٢٥b.getColor(i10, i11);
    }

    public ColorStateList c(int i10) {
        int resourceId;
        ColorStateList a10;
        if (this.f١٦٢٥b.hasValue(i10) && (resourceId = this.f١٦٢٥b.getResourceId(i10, 0)) != 0 && (a10 = r1.a.a(this.f١٦٢٤a, resourceId)) != null) {
            return a10;
        }
        return this.f١٦٢٥b.getColorStateList(i10);
    }

    public float d(int i10, float f10) {
        return this.f١٦٢٥b.getDimension(i10, f10);
    }

    public int e(int i10, int i11) {
        return this.f١٦٢٥b.getDimensionPixelOffset(i10, i11);
    }

    public int f(int i10, int i11) {
        return this.f١٦٢٥b.getDimensionPixelSize(i10, i11);
    }

    public Drawable g(int i10) {
        int resourceId;
        if (this.f١٦٢٥b.hasValue(i10) && (resourceId = this.f١٦٢٥b.getResourceId(i10, 0)) != 0) {
            return r1.a.b(this.f١٦٢٤a, resourceId);
        }
        return this.f١٦٢٥b.getDrawable(i10);
    }

    public Drawable h(int i10) {
        int resourceId;
        if (this.f١٦٢٥b.hasValue(i10) && (resourceId = this.f١٦٢٥b.getResourceId(i10, 0)) != 0) {
            return f.b().d(this.f١٦٢٤a, resourceId, true);
        }
        return null;
    }

    public float i(int i10, float f10) {
        return this.f١٦٢٥b.getFloat(i10, f10);
    }

    public Typeface j(int i10, int i11, h.e eVar) {
        int resourceId = this.f١٦٢٥b.getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f١٦٢٦c == null) {
            this.f١٦٢٦c = new TypedValue();
        }
        return androidx.core.content.res.h.i(this.f١٦٢٤a, resourceId, this.f١٦٢٦c, i11, eVar);
    }

    public int k(int i10, int i11) {
        return this.f١٦٢٥b.getInt(i10, i11);
    }

    public int l(int i10, int i11) {
        return this.f١٦٢٥b.getInteger(i10, i11);
    }

    public int m(int i10, int i11) {
        return this.f١٦٢٥b.getLayoutDimension(i10, i11);
    }

    public int n(int i10, int i11) {
        return this.f١٦٢٥b.getResourceId(i10, i11);
    }

    public String o(int i10) {
        return this.f١٦٢٥b.getString(i10);
    }

    public CharSequence p(int i10) {
        return this.f١٦٢٥b.getText(i10);
    }

    public CharSequence[] q(int i10) {
        return this.f١٦٢٥b.getTextArray(i10);
    }

    public TypedArray r() {
        return this.f١٦٢٥b;
    }

    public boolean s(int i10) {
        return this.f١٦٢٥b.hasValue(i10);
    }

    public TypedValue w(int i10) {
        return this.f١٦٢٥b.peekValue(i10);
    }

    public void x() {
        this.f١٦٢٥b.recycle();
    }
}
