package com.qiahao.base_common.wedgit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qiahao.base_common.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 32\u00020\u0001:\u00013B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\nJ\u0006\u0010$\u001a\u00020\nJ\u001a\u0010%\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0014J(\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\nH\u0014J\u0010\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u0018H\u0002R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/qiahao/base_common/wedgit/CircleProgress;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mProgress", "mCorner", "mStartAngle", "mBackgroundColor", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "mCenter", "Landroid/graphics/PointF;", "mStart", "mRadius", "", "mBackground", "Landroid/graphics/RectF;", "mClipArcPath", "Landroid/graphics/Path;", "mClipBgPath", "mEnclosingRectF", "mPaint", "Landroid/graphics/Paint;", "setProgress", "", "progress", "getProgress", "init", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "getSectorClip", "sweepAngle", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CircleProgress extends View {
    public static final int PI_RADIUS = 180;
    private int height;

    @Nullable
    private RectF mBackground;
    private int mBackgroundColor;

    @Nullable
    private PointF mCenter;

    @NotNull
    private final Path mClipArcPath;

    @NotNull
    private final Path mClipBgPath;
    private int mCorner;

    @Nullable
    private RectF mEnclosingRectF;

    @NotNull
    private final Paint mPaint;
    private int mProgress;
    private float mRadius;

    @Nullable
    private PointF mStart;
    private int mStartAngle;
    private int width;

    public CircleProgress(@Nullable Context context) {
        super(context);
        this.mClipArcPath = new Path();
        this.mClipBgPath = new Path();
        this.mPaint = new Paint();
    }

    private final Path getSectorClip(float sweepAngle) {
        this.mClipArcPath.reset();
        Path path = this.mClipArcPath;
        PointF pointF = this.mCenter;
        Intrinsics.checkNotNull(pointF);
        float f10 = pointF.x;
        PointF pointF2 = this.mCenter;
        Intrinsics.checkNotNull(pointF2);
        path.moveTo(f10, pointF2.y);
        Path path2 = this.mClipArcPath;
        PointF pointF3 = this.mStart;
        Intrinsics.checkNotNull(pointF3);
        float f11 = pointF3.x;
        PointF pointF4 = this.mStart;
        Intrinsics.checkNotNull(pointF4);
        path2.lineTo(f11, pointF4.y);
        Path path3 = this.mClipArcPath;
        Intrinsics.checkNotNull(this.mCenter);
        double d10 = (sweepAngle * 3.141592653589793d) / 180;
        float cos = (float) (r1.x + (this.mRadius * Math.cos(d10)));
        Intrinsics.checkNotNull(this.mCenter);
        path3.lineTo(cos, (float) (r2.y + (this.mRadius * Math.sin(d10))));
        this.mClipArcPath.close();
        Path path4 = this.mClipArcPath;
        RectF rectF = this.mEnclosingRectF;
        Intrinsics.checkNotNull(rectF);
        float f12 = this.mStartAngle;
        path4.addArc(rectF, f12, sweepAngle - f12);
        return this.mClipArcPath;
    }

    private final void init(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CircleProgress);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.mProgress = obtainStyledAttributes.getInt(R.styleable.CircleProgress_circleProgress, 0);
        this.mCorner = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.CircleProgress_circleCorner, 0);
        this.mStartAngle = obtainStyledAttributes.getInt(R.styleable.CircleProgress_startAngle, 315);
        this.mBackgroundColor = obtainStyledAttributes.getColor(R.styleable.CircleProgress_backgroundColor, Color.argb(90, 90, 90, 90));
        obtainStyledAttributes.recycle();
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.mBackgroundColor);
    }

    /* renamed from: getProgress, reason: from getter */
    public final int getMProgress() {
        return this.mProgress;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        canvas.clipPath(this.mClipBgPath);
        canvas.clipPath(getSectorClip(((this.mProgress * 360) / 100.0f) + this.mStartAngle), Region.Op.DIFFERENCE);
        RectF rectF = this.mBackground;
        Intrinsics.checkNotNull(rectF);
        float f10 = this.mCorner;
        canvas.drawRoundRect(rectF, f10, f10, this.mPaint);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        this.width = w10;
        this.height = h10;
        this.mRadius = (float) Math.sqrt((r9 * r9) + (r11 * r11));
        this.mCenter = new PointF(getPaddingStart() + (((w10 - getPaddingStart()) - getPaddingEnd()) / 2.0f), getPaddingTop() + (((this.height - getPaddingTop()) - getPaddingBottom()) / 2.0f));
        Intrinsics.checkNotNull(this.mCenter);
        double d10 = 180;
        float cos = (float) (r10.x + (this.mRadius * Math.cos((this.mStartAngle * 3.141592653589793d) / d10)));
        Intrinsics.checkNotNull(this.mCenter);
        this.mStart = new PointF(cos, (float) (r11.y + (this.mRadius * Math.sin((this.mStartAngle * 3.141592653589793d) / d10))));
        this.mBackground = new RectF(getPaddingStart(), getPaddingTop(), this.width - getPaddingEnd(), this.height - getPaddingBottom());
        PointF pointF = this.mCenter;
        Intrinsics.checkNotNull(pointF);
        float f10 = pointF.x - this.mRadius;
        PointF pointF2 = this.mCenter;
        Intrinsics.checkNotNull(pointF2);
        float f11 = pointF2.y - this.mRadius;
        PointF pointF3 = this.mCenter;
        Intrinsics.checkNotNull(pointF3);
        float f12 = pointF3.x + this.mRadius;
        PointF pointF4 = this.mCenter;
        Intrinsics.checkNotNull(pointF4);
        this.mEnclosingRectF = new RectF(f10, f11, f12, pointF4.y + this.mRadius);
        this.mClipBgPath.reset();
        Path path = this.mClipBgPath;
        RectF rectF = this.mBackground;
        Intrinsics.checkNotNull(rectF);
        float f13 = this.mCorner;
        path.addRoundRect(rectF, f13, f13, Path.Direction.CW);
    }

    public final void setProgress(int progress) {
        this.mProgress = progress;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgress(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mClipArcPath = new Path();
        this.mClipBgPath = new Path();
        this.mPaint = new Paint();
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgress(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mClipArcPath = new Path();
        this.mClipBgPath = new Path();
        this.mPaint = new Paint();
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgress(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mClipArcPath = new Path();
        this.mClipBgPath = new Path();
        this.mPaint = new Paint();
        init(context, attributeSet);
    }
}
