package com.qiahao.base_common.wedgit.gif;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import java.lang.reflect.Field;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class PathImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Path f١٢٦٥٦a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f١٢٦٥٧b;

    public PathImageView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int a(ViewParent viewParent) {
        if (viewParent != 0 && (viewParent instanceof View)) {
            View view = (View) viewParent;
            int b10 = b(view);
            if (b10 != 0) {
                return b10;
            }
            a(view.getParent());
        }
        return 0;
    }

    private int b(View view) {
        Drawable background = view.getBackground();
        if (background != null) {
            try {
                Field declaredField = background.getClass().getDeclaredField("mColorState");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(background);
                Field declaredField2 = obj.getClass().getDeclaredField("mUseColor");
                declaredField2.setAccessible(true);
                int intValue = ((Integer) declaredField2.get(obj)).intValue();
                if (intValue != 0) {
                    return intValue;
                }
                return 0;
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
                return 0;
            } catch (NoSuchFieldException e11) {
                e11.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    private void c() {
        this.f١٢٦٥٦a = new Path();
        this.f١٢٦٥٧b = new Paint(1);
    }

    private void d() {
        int a10 = a(getParent());
        if (a10 == 0) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.colorBackground});
            int color = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
            a10 = color;
        }
        this.f١٢٦٥٧b.setColor(a10);
    }

    private void setPath(Path path) {
        this.f١٢٦٥٦a.reset();
        this.f١٢٦٥٦a.setFillType(Path.FillType.WINDING);
        this.f١٢٦٥٦a.addPath(path);
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.drawPath(this.f١٢٦٥٦a, this.f١٢٦٥٧b);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        d();
    }

    public PathImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PathImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c();
    }
}
