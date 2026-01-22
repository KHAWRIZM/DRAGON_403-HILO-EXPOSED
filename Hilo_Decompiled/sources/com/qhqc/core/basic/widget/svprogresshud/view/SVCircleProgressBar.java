package com.qhqc.core.basic.widget.svprogresshud.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.qhqc.core.basic.widget.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0014J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0007R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/qhqc/core/basic/widget/svprogresshud/view/SVCircleProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "circleColor", "getCircleColor", "()I", "setCircleColor", "(I)V", "circleProgressColor", "getCircleProgressColor", "setCircleProgressColor", "max", "paint", "Landroid/graphics/Paint;", "progress", "roundWidth", "", "getRoundWidth", "()F", "setRoundWidth", "(F)V", "style", "getMax", "getProgress", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setMax", "setProgress", "Companion", "basic_widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSVCircleProgressBar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SVCircleProgressBar.kt\ncom/qhqc/core/basic/widget/svprogresshud/view/SVCircleProgressBar\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,175:1\n1#2:176\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class SVCircleProgressBar extends View {
    public static final int FILL = 1;
    public static final int STROKE = 0;
    private int circleColor;
    private int circleProgressColor;
    private int max;

    @NotNull
    private final Paint paint;
    private int progress;
    private float roundWidth;
    private final int style;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SVCircleProgressBar(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final int getCircleColor() {
        return this.circleColor;
    }

    public final int getCircleProgressColor() {
        return this.circleProgressColor;
    }

    public final synchronized int getMax() {
        return this.max;
    }

    public final synchronized int getProgress() {
        return this.progress;
    }

    public final float getRoundWidth() {
        return this.roundWidth;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f10 = width;
        int i10 = (int) (f10 - (this.roundWidth / 2));
        this.paint.setAntiAlias(true);
        this.paint.setColor(this.circleColor);
        Paint paint = this.paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.paint.setStrokeWidth(this.roundWidth);
        canvas.drawCircle(f10, f10, i10, this.paint);
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setColor(this.circleProgressColor);
        float f11 = width - i10;
        float f12 = width + i10;
        RectF rectF = new RectF(f11, f11, f12, f12);
        int i11 = this.style;
        if (i11 != 0) {
            if (i11 == 1) {
                this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
                if (this.progress != 0) {
                    canvas.drawArc(rectF, 270.0f, (r0 * 360) / this.max, true, this.paint);
                    return;
                }
                return;
            }
            return;
        }
        this.paint.setStyle(style);
        canvas.drawArc(rectF, 270.0f, (this.progress * 360) / this.max, false, this.paint);
    }

    public final void setCircleColor(int i10) {
        this.circleColor = i10;
    }

    public final void setCircleProgressColor(int i10) {
        this.circleProgressColor = i10;
    }

    public final synchronized void setMax(int max) {
        if (max >= 0) {
            this.max = max;
        } else {
            throw new IllegalArgumentException("max not less than 0");
        }
    }

    public final synchronized void setProgress(int progress) {
        if (progress >= 0) {
            int i10 = this.max;
            if (progress > i10) {
                progress = i10;
            }
            if (progress <= i10) {
                this.progress = progress;
                postInvalidate();
            }
        } else {
            throw new IllegalArgumentException("progress not less than 0");
        }
    }

    public final void setRoundWidth(float f10) {
        this.roundWidth = f10;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SVCircleProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SVCircleProgressBar(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SVCircleProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SVCircleProgressBar);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.circleColor = obtainStyledAttributes.getColor(R.styleable.SVCircleProgressBar_svprogress_roundColor, -16776961);
        this.circleProgressColor = obtainStyledAttributes.getColor(R.styleable.SVCircleProgressBar_svprogress_roundProgressColor, -7829368);
        this.roundWidth = obtainStyledAttributes.getDimension(R.styleable.SVCircleProgressBar_svprogress_roundWidth, 5.0f);
        this.max = obtainStyledAttributes.getInteger(R.styleable.SVCircleProgressBar_svprogress_max, 100);
        this.style = obtainStyledAttributes.getInt(R.styleable.SVCircleProgressBar_svprogress_style, 0);
        obtainStyledAttributes.recycle();
    }
}
