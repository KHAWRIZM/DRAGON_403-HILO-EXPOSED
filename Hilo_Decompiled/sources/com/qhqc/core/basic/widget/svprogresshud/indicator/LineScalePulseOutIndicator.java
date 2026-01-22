package com.qhqc.core.basic.widget.svprogresshud.indicator;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/qhqc/core/basic/widget/svprogresshud/indicator/LineScalePulseOutIndicator;", "Lcom/qhqc/core/basic/widget/svprogresshud/indicator/LineScaleIndicator;", "()V", "mScaleYFloats", "", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "onCreateAnimators", "Ljava/util/ArrayList;", "Landroid/animation/ValueAnimator;", "Lkotlin/collections/ArrayList;", "basic_widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class LineScalePulseOutIndicator extends LineScaleIndicator {

    @NotNull
    private float[] mScaleYFloats = {1.0f, 0.7f, 0.4f, 0.6f, 1.0f};

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateAnimators$lambda$0(LineScalePulseOutIndicator this$0, int i10, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        float[] fArr = this$0.mScaleYFloats;
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        fArr[i10] = ((Float) animatedValue).floatValue();
        this$0.postInvalidate();
    }

    @Override // com.qhqc.core.basic.widget.svprogresshud.indicator.LineScaleIndicator, com.qhqc.core.basic.widget.svprogresshud.indicator.Indicator
    public void draw(@NotNull Canvas canvas, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        float width = getWidth() / 11.0f;
        float height = getHeight() / 2.0f;
        for (int i10 = 0; i10 < 5; i10++) {
            canvas.save();
            float f10 = 2;
            float f11 = width / f10;
            canvas.translate((((i10 * 2) + 2) * width) - f11, height);
            canvas.scale(1.0f, this.mScaleYFloats[i10]);
            canvas.drawRoundRect(new RectF((-width) / f10, (-getHeight()) / 2.5f, f11, getHeight() / 2.5f), 5.0f, 5.0f, paint);
            canvas.restore();
        }
    }

    @Override // com.qhqc.core.basic.widget.svprogresshud.indicator.LineScaleIndicator, com.qhqc.core.basic.widget.svprogresshud.indicator.Indicator
    @Nullable
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        long[] jArr = {500, 250, 0, 250, 500};
        for (final int i10 = 0; i10 < 5; i10++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            ofFloat.setDuration(900L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(jArr[i10]);
            Intrinsics.checkNotNull(ofFloat);
            addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() { // from class: com.qhqc.core.basic.widget.svprogresshud.indicator.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LineScalePulseOutIndicator.onCreateAnimators$lambda$0(LineScalePulseOutIndicator.this, i10, valueAnimator);
                }
            });
            arrayList.add(ofFloat);
        }
        return arrayList;
    }
}
