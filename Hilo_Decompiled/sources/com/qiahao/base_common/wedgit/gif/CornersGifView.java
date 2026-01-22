package com.qiahao.base_common.wedgit.gif;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatImageView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.reflect.Field;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class CornersGifView extends AppCompatImageView {

    /* renamed from: a, reason: collision with root package name */
    private Path f١٢٦٤٨a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f١٢٦٤٩b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٢٦٥٠c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٢٦٥١d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٢٦٥٢e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٢٦٥٣f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٢٦٥٤g;

    /* renamed from: h, reason: collision with root package name */
    private float[] f١٢٦٥٥h;

    public CornersGifView(Context context) {
        this(context, null);
    }

    private void k(int i10, int i11) {
        this.f١٢٦٤٨a.reset();
        this.f١٢٦٤٨a.addRoundRect(new RectF(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, i10, i11), this.f١٢٦٥٥h, Path.Direction.CCW);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int l(ViewParent viewParent) {
        if (viewParent != 0 && (viewParent instanceof View)) {
            View view = (View) viewParent;
            int m10 = m(view);
            if (m10 != 0) {
                return m10;
            }
            l(view.getParent());
        }
        return 0;
    }

    private int m(View view) {
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

    private void n() {
        int l10 = l(getParent());
        if (l10 == 0) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.colorBackground});
            int color = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
            l10 = color;
        }
        this.f١٢٦٤٩b.setColor(l10);
    }

    private void o(int i10, int i11, int i12, int i13) {
        float f10 = i10;
        float f11 = i12;
        float f12 = i13;
        float f13 = i11;
        this.f١٢٦٥٥h = new float[]{f10, f10, f11, f11, f12, f12, f13, f13};
        k(getWidth(), getHeight());
        invalidate();
    }

    public int getCornerSize() {
        return this.f١٢٦٥٠c;
    }

    public int getLeftBottomCorner() {
        return this.f١٢٦٥١d;
    }

    public int getLeftTopCorner() {
        return this.f١٢٦٥٢e;
    }

    public int getRightBottomCorner() {
        return this.f١٢٦٥٣f;
    }

    public int getRightTopCorner() {
        return this.f١٢٦٥٤g;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.drawPath(this.f١٢٦٤٨a, this.f١٢٦٤٩b);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        n();
        k(i10, i11);
    }

    public void setCornerSize(int i10) {
        this.f١٢٦٥٠c = i10;
        o(i10, i10, i10, i10);
    }

    public void setLeftBottomCorner(int i10) {
        this.f١٢٦٥١d = i10;
        o(this.f١٢٦٥٢e, i10, this.f١٢٦٥٤g, this.f١٢٦٥٣f);
    }

    public void setLeftTopCorner(int i10) {
        this.f١٢٦٥٢e = i10;
        o(i10, this.f١٢٦٥١d, this.f١٢٦٥٤g, this.f١٢٦٥٣f);
    }

    public void setRightBottomCorner(int i10) {
        this.f١٢٦٥٣f = i10;
        o(this.f١٢٦٥٢e, this.f١٢٦٥١d, this.f١٢٦٥٤g, i10);
    }

    public void setRightTopCorner(int i10) {
        this.f١٢٦٥٤g = i10;
        o(this.f١٢٦٥٢e, this.f١٢٦٥١d, i10, this.f١٢٦٥٣f);
    }

    public CornersGifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CornersGifView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Path path = new Path();
        this.f١٢٦٤٨a = path;
        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        Paint paint = new Paint();
        this.f١٢٦٤٩b = paint;
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qiahao.base_common.R.styleable.CornersGifView);
        this.f١٢٦٥٠c = (int) obtainStyledAttributes.getDimension(com.qiahao.base_common.R.styleable.CornersGifView_cornerGiftSize, DownloadProgress.UNKNOWN_PROGRESS);
        this.f١٢٦٥١d = (int) obtainStyledAttributes.getDimension(com.qiahao.base_common.R.styleable.CornersGifView_leftBottomCorner, DownloadProgress.UNKNOWN_PROGRESS);
        this.f١٢٦٥٢e = (int) obtainStyledAttributes.getDimension(com.qiahao.base_common.R.styleable.CornersGifView_leftTopCorner, DownloadProgress.UNKNOWN_PROGRESS);
        this.f١٢٦٥٣f = (int) obtainStyledAttributes.getDimension(com.qiahao.base_common.R.styleable.CornersGifView_rightBottomCorner, DownloadProgress.UNKNOWN_PROGRESS);
        this.f١٢٦٥٤g = (int) obtainStyledAttributes.getDimension(com.qiahao.base_common.R.styleable.CornersGifView_rightTopCorner, DownloadProgress.UNKNOWN_PROGRESS);
        obtainStyledAttributes.recycle();
        int i11 = this.f١٢٦٥٠c;
        if (i11 == 0) {
            float f10 = this.f١٢٦٥٢e;
            float f11 = this.f١٢٦٥٤g;
            float f12 = this.f١٢٦٥٣f;
            float f13 = this.f١٢٦٥١d;
            this.f١٢٦٥٥h = new float[]{f10, f10, f11, f11, f12, f12, f13, f13};
            return;
        }
        float f14 = i11;
        this.f١٢٦٥٥h = new float[]{f14, f14, f14, f14, f14, f14, f14, f14};
    }
}
