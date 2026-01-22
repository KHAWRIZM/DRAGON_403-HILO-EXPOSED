package com.tencent.qcloud.tuicore.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.qcloud.tuicore.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class RoundCornerImageView extends AppCompatImageView {
    private final PaintFlagsDrawFilter aliasFilter;
    private int leftBottomRadius;
    private int leftTopRadius;
    private final Path path;
    private int radius;
    private final RectF rectF;
    private int rightBottomRadius;
    private int rightTopRadius;

    public RoundCornerImageView(Context context) {
        super(context);
        this.path = new Path();
        this.rectF = new RectF();
        this.aliasFilter = new PaintFlagsDrawFilter(0, 3);
        init(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(Context context, AttributeSet attributeSet) {
        setLayerType(2, null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundCornerImageView);
            this.radius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_corner_radius, 0);
            this.leftTopRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_left_top_corner_radius, 0);
            this.rightTopRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_right_top_corner_radius, 0);
            this.rightBottomRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_right_bottom_corner_radius, 0);
            this.leftBottomRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_left_bottom_corner_radius, 0);
            obtainStyledAttributes.recycle();
        }
        if (this.leftTopRadius == 0) {
            this.leftTopRadius = this.radius;
        }
        if (this.rightTopRadius == 0) {
            this.rightTopRadius = this.radius;
        }
        if (this.rightBottomRadius == 0) {
            this.rightBottomRadius = this.radius;
        }
        if (this.leftBottomRadius == 0) {
            this.leftBottomRadius = this.radius;
        }
    }

    public int getLeftBottomRadius() {
        return this.leftBottomRadius;
    }

    public int getLeftTopRadius() {
        return this.leftTopRadius;
    }

    public int getRadius() {
        return this.radius;
    }

    public int getRightBottomRadius() {
        return this.rightBottomRadius;
    }

    public int getRightTopRadius() {
        return this.rightTopRadius;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDraw(Canvas canvas) {
        this.path.reset();
        canvas.setDrawFilter(this.aliasFilter);
        this.rectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        int i = this.leftTopRadius;
        int i2 = this.rightTopRadius;
        int i3 = this.rightBottomRadius;
        int i4 = this.leftBottomRadius;
        this.path.addRoundRect(this.rectF, new float[]{i, i, i2, i2, i3, i3, i4, i4}, Path.Direction.CW);
        canvas.clipPath(this.path);
        super/*android.widget.ImageView*/.onDraw(canvas);
    }

    public void setLeftBottomRadius(int i) {
        this.leftBottomRadius = i;
    }

    public void setLeftTopRadius(int i) {
        this.leftTopRadius = i;
    }

    public void setRadius(int i) {
        this.radius = i;
        this.leftBottomRadius = i;
        this.rightBottomRadius = i;
        this.rightTopRadius = i;
        this.leftTopRadius = i;
    }

    public void setRightBottomRadius(int i) {
        this.rightBottomRadius = i;
    }

    public void setRightTopRadius(int i) {
        this.rightTopRadius = i;
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.path = new Path();
        this.rectF = new RectF();
        this.aliasFilter = new PaintFlagsDrawFilter(0, 3);
        init(context, attributeSet);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.path = new Path();
        this.rectF = new RectF();
        this.aliasFilter = new PaintFlagsDrawFilter(0, 3);
    }
}
