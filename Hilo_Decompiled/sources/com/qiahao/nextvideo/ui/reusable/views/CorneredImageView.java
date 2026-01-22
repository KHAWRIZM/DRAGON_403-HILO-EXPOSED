package com.qiahao.nextvideo.ui.reusable.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0002J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\"\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001b¨\u0006-"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/CorneredImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fillPaint", "Landroid/graphics/Paint;", "pathSize", "Lcom/qiahao/nextvideo/ui/reusable/views/PathSize;", TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH, "Landroid/graphics/Path;", "value", "fillColor", "setFillColor", "(I)V", "topLeftCornerRadius", "", "getTopLeftCornerRadius", "()F", "setTopLeftCornerRadius", "(F)V", "topRightCornerRadius", "getTopRightCornerRadius", "setTopRightCornerRadius", "bottomRightCornerRadius", "getBottomRightCornerRadius", "setBottomRightCornerRadius", "bottomLeftCornerRadius", "getBottomLeftCornerRadius", "setBottomLeftCornerRadius", "commonInit", "", "invalidatePathIfNeeded", "width", "height", "draw", "canvas", "Landroid/graphics/Canvas;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CorneredImageView extends AppCompatImageView {
    private float bottomLeftCornerRadius;
    private float bottomRightCornerRadius;
    private int fillColor;

    @NotNull
    private final Paint fillPaint;

    @Nullable
    private Path path;

    @NotNull
    private final PathSize pathSize;
    private float topLeftCornerRadius;
    private float topRightCornerRadius;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CorneredImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.fillPaint = new Paint();
        this.pathSize = new PathSize(0, 0);
        this.fillColor = Color.parseColor("#FFFFFF");
        Dimens dimens = Dimens.INSTANCE;
        this.topLeftCornerRadius = dimens.getMarginXLarge();
        this.topRightCornerRadius = dimens.getMarginXLarge();
        this.bottomRightCornerRadius = dimens.getMarginXLarge();
        this.bottomLeftCornerRadius = dimens.getMarginXLarge();
        commonInit(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void commonInit(Context context, AttributeSet attrs) {
        setWillNotDraw(false);
        this.fillPaint.setColor(this.fillColor);
        this.fillPaint.setStyle(Paint.Style.FILL);
        if (attrs != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CorneredImageView);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
            this.fillPaint.setColor(obtainStyledAttributes.getColor(1, Color.parseColor("#FFFFFF")));
            float dimension = obtainStyledAttributes.getDimension(0, this.topLeftCornerRadius);
            this.topLeftCornerRadius = dimension;
            this.topRightCornerRadius = dimension;
            this.bottomLeftCornerRadius = dimension;
            this.bottomRightCornerRadius = dimension;
            obtainStyledAttributes.recycle();
        }
    }

    private final void invalidatePathIfNeeded(int width, int height) {
        if (this.path == null || this.pathSize.getWidth() != width || this.pathSize.getHeight() != height) {
            Path path = new Path();
            float f = width;
            float f2 = height;
            Path.Direction direction = Path.Direction.CW;
            path.addRect(0.0f, 0.0f, f, f2, direction);
            Path path2 = new Path();
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            float f3 = this.topLeftCornerRadius;
            float f4 = this.topRightCornerRadius;
            float f5 = this.bottomRightCornerRadius;
            float f6 = this.bottomLeftCornerRadius;
            path2.addRoundRect(rectF, new float[]{f3, f3, f4, f4, f5, f5, f6, f6}, direction);
            path.op(path2, Path.Op.DIFFERENCE);
            this.path = path;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setFillColor(int i) {
        this.fillColor = i;
        this.fillPaint.setColor(i);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super/*android.widget.ImageView*/.draw(canvas);
        invalidatePathIfNeeded(getMeasuredWidth(), getMeasuredHeight());
        Path path = this.path;
        if (path != null) {
            canvas.drawPath(path, this.fillPaint);
        }
    }

    public final float getBottomLeftCornerRadius() {
        return this.bottomLeftCornerRadius;
    }

    public final float getBottomRightCornerRadius() {
        return this.bottomRightCornerRadius;
    }

    public final float getTopLeftCornerRadius() {
        return this.topLeftCornerRadius;
    }

    public final float getTopRightCornerRadius() {
        return this.topRightCornerRadius;
    }

    public final void setBottomLeftCornerRadius(float f) {
        this.bottomLeftCornerRadius = f;
    }

    public final void setBottomRightCornerRadius(float f) {
        this.bottomRightCornerRadius = f;
    }

    public final void setTopLeftCornerRadius(float f) {
        this.topLeftCornerRadius = f;
    }

    public final void setTopRightCornerRadius(float f) {
        this.topRightCornerRadius = f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CorneredImageView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        this.fillPaint = new Paint();
        this.pathSize = new PathSize(0, 0);
        this.fillColor = Color.parseColor("#FFFFFF");
        Dimens dimens = Dimens.INSTANCE;
        this.topLeftCornerRadius = dimens.getMarginXLarge();
        this.topRightCornerRadius = dimens.getMarginXLarge();
        this.bottomRightCornerRadius = dimens.getMarginXLarge();
        this.bottomLeftCornerRadius = dimens.getMarginXLarge();
        commonInit(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CorneredImageView(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        this.fillPaint = new Paint();
        this.pathSize = new PathSize(0, 0);
        this.fillColor = Color.parseColor("#FFFFFF");
        Dimens dimens = Dimens.INSTANCE;
        this.topLeftCornerRadius = dimens.getMarginXLarge();
        this.topRightCornerRadius = dimens.getMarginXLarge();
        this.bottomRightCornerRadius = dimens.getMarginXLarge();
        this.bottomLeftCornerRadius = dimens.getMarginXLarge();
        commonInit(context, attributeSet);
    }
}
