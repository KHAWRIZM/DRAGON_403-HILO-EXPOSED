package com.ruffian.library.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import nc.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class RImageView extends AppCompatImageView {

    /* renamed from: a, reason: collision with root package name */
    private float f١٣٤٦٤a;

    /* renamed from: b, reason: collision with root package name */
    private float f١٣٤٦٥b;

    /* renamed from: c, reason: collision with root package name */
    private float f١٣٤٦٦c;

    /* renamed from: d, reason: collision with root package name */
    private float f١٣٤٦٧d;

    /* renamed from: e, reason: collision with root package name */
    private float f١٣٤٦٨e;

    /* renamed from: f, reason: collision with root package name */
    private float f١٣٤٦٩f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٣٤٧٠g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١٣٤٧١h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f١٣٤٧٢i;

    /* renamed from: j, reason: collision with root package name */
    private ImageView.ScaleType f١٣٤٧٣j;

    /* renamed from: k, reason: collision with root package name */
    private int f١٣٤٧٤k;

    /* renamed from: l, reason: collision with root package name */
    private ColorFilter f١٣٤٧٥l;

    /* renamed from: m, reason: collision with root package name */
    private PorterDuff.Mode f١٣٤٧٦m;

    public RImageView(Context context) {
        this(context, null);
    }

    private void k() {
        if (this.f١٣٤٧٢i == null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (measuredWidth > 0 && measuredHeight > 0) {
                Drawable background = getBackground();
                if (background != null) {
                    background.setBounds(0, 0, measuredWidth, measuredHeight);
                    setImageDrawable(background);
                } else {
                    setImageBitmap(Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ALPHA_8));
                }
            }
        }
    }

    private void l(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.RImageView);
        this.f١٣٤٧١h = obtainStyledAttributes.getBoolean(R.styleable.RImageView_is_circle, false);
        this.f١٣٤٦٤a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RImageView_corner_radius, -1);
        this.f١٣٤٦٥b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RImageView_corner_radius_top_left, 0);
        this.f١٣٤٦٦c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RImageView_corner_radius_top_right, 0);
        this.f١٣٤٦٧d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RImageView_corner_radius_bottom_left, 0);
        this.f١٣٤٦٨e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RImageView_corner_radius_bottom_right, 0);
        this.f١٣٤٦٩f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RImageView_border_width, 0);
        this.f١٣٤٧٠g = obtainStyledAttributes.getColor(R.styleable.RImageView_border_color, -16777216);
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "tint", 0);
        if (attributeResourceValue != 0) {
            this.f١٣٤٧٥l = new PorterDuffColorFilter(getResources().getColor(attributeResourceValue), this.f١٣٤٧٦m);
        }
        int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "tintMode", 0);
        if (attributeIntValue != 0) {
            this.f١٣٤٧٦m = q(attributeIntValue);
        }
        obtainStyledAttributes.recycle();
        p();
    }

    private Drawable m() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i10 = this.f١٣٤٧٤k;
        if (i10 != 0) {
            try {
                drawable = resources.getDrawable(i10);
            } catch (Exception unused) {
                this.f١٣٤٧٤k = 0;
            }
        }
        return a.c(drawable);
    }

    private void o(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof a) {
            ((a) drawable).e(scaleType, this.f١٣٤٦٩f, this.f١٣٤٧٠g, this.f١٣٤٧١h, this.f١٣٤٦٤a, this.f١٣٤٦٥b, this.f١٣٤٦٦c, this.f١٣٤٦٧d, this.f١٣٤٦٨e);
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i10 = 0; i10 < numberOfLayers; i10++) {
                o(layerDrawable.getDrawable(i10), scaleType);
            }
        }
    }

    private void p() {
        o(this.f١٣٤٧٢i, this.f١٣٤٧٣j);
        n();
    }

    private PorterDuff.Mode q(int i10) {
        if (i10 != 3) {
            if (i10 != 5) {
                switch (i10) {
                    case 14:
                        return PorterDuff.Mode.MULTIPLY;
                    case 15:
                        return PorterDuff.Mode.SCREEN;
                    case 16:
                        return PorterDuff.Mode.ADD;
                    default:
                        return PorterDuff.Mode.SRC_ATOP;
                }
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.f١٣٤٧٠g;
    }

    public float getBorderWidth() {
        return this.f١٣٤٦٩f;
    }

    public float getCorner() {
        return this.f١٣٤٦٤a;
    }

    public float getCornerBottomLeft() {
        return this.f١٣٤٦٧d;
    }

    public float getCornerBottomRight() {
        return this.f١٣٤٦٨e;
    }

    public float getCornerTopLeft() {
        return this.f١٣٤٦٥b;
    }

    public float getCornerTopRight() {
        return this.f١٣٤٦٦c;
    }

    public void n() {
        Drawable drawable;
        ColorFilter colorFilter = this.f١٣٤٧٥l;
        if (colorFilter != null && (drawable = this.f١٣٤٧٢i) != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        k();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f١٣٤٧٤k = 0;
        this.f١٣٤٧٢i = a.b(bitmap);
        p();
        super.setImageDrawable(this.f١٣٤٧٢i);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.f١٣٤٧٤k = 0;
        this.f١٣٤٧٢i = a.c(drawable);
        p();
        super.setImageDrawable(this.f١٣٤٧٢i);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i10) {
        if (this.f١٣٤٧٤k != i10) {
            this.f١٣٤٧٤k = i10;
            this.f١٣٤٧٢i = m();
            p();
            super.setImageDrawable(this.f١٣٤٧٢i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageTintList(ColorStateList colorStateList) {
        super.setImageTintList(colorStateList);
        this.f١٣٤٧٥l = new PorterDuffColorFilter(colorStateList.getDefaultColor(), this.f١٣٤٧٦m);
        n();
    }

    @Override // android.widget.ImageView
    public void setImageTintMode(PorterDuff.Mode mode) {
        super.setImageTintMode(mode);
        this.f١٣٤٧٦m = mode;
        n();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        if (this.f١٣٤٧٣j != scaleType) {
            this.f١٣٤٧٣j = scaleType;
            p();
            invalidate();
        }
    }

    public RImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٣٤٦٤a = -1.0f;
        this.f١٣٤٦٥b = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٤٦٦c = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٤٦٧d = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٤٦٨e = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٤٦٩f = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٤٧٠g = -16777216;
        this.f١٣٤٧١h = false;
        this.f١٣٤٧٦m = PorterDuff.Mode.SRC_ATOP;
        l(attributeSet);
    }
}
