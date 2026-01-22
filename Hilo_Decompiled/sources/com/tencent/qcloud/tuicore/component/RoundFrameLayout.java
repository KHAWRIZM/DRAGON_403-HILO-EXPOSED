package com.tencent.qcloud.tuicore.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.qcloud.tuicore.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class RoundFrameLayout extends FrameLayout {
    private final PaintFlagsDrawFilter aliasFilter;
    private int leftBottomRadius;
    private int leftTopRadius;
    private final Path path;
    private int radius;
    private final RectF rectF;
    private int rightBottomRadius;
    private int rightTopRadius;

    public RoundFrameLayout(Context context) {
        super(context);
        this.path = new Path();
        this.rectF = new RectF();
        this.aliasFilter = new PaintFlagsDrawFilter(0, 3);
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setLayerType(2, null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundFrameLayout);
            this.radius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundFrameLayout_corner_radius, 0);
            this.leftTopRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundFrameLayout_left_top_corner_radius, 0);
            this.rightTopRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundFrameLayout_right_top_corner_radius, 0);
            this.rightBottomRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundFrameLayout_right_bottom_corner_radius, 0);
            this.leftBottomRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundFrameLayout_left_bottom_corner_radius, 0);
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

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.path.reset();
        canvas.setDrawFilter(this.aliasFilter);
        this.rectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        int i = this.leftTopRadius;
        int i2 = this.rightTopRadius;
        int i3 = this.rightBottomRadius;
        int i4 = this.leftBottomRadius;
        this.path.addRoundRect(this.rectF, new float[]{i, i, i2, i2, i3, i3, i4, i4}, Path.Direction.CW);
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.path = new Path();
        this.rectF = new RectF();
        this.aliasFilter = new PaintFlagsDrawFilter(0, 3);
        init(context, attributeSet);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.path = new Path();
        this.rectF = new RectF();
        this.aliasFilter = new PaintFlagsDrawFilter(0, 3);
    }
}
