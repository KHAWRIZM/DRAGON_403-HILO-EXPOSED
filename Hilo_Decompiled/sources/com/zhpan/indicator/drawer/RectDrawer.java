package com.zhpan.indicator.drawer;

import android.animation.ArgbEvaluator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.zhpan.indicator.option.IndicatorOptions;
import com.zhpan.indicator.utils.IndicatorUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/zhpan/indicator/drawer/RectDrawer;", "Lcom/zhpan/indicator/drawer/BaseDrawer;", "indicatorOptions", "Lcom/zhpan/indicator/option/IndicatorOptions;", "(Lcom/zhpan/indicator/option/IndicatorOptions;)V", "mRectF", "Landroid/graphics/RectF;", "getMRectF$indicator_release", "()Landroid/graphics/RectF;", "setMRectF$indicator_release", "(Landroid/graphics/RectF;)V", "drawCheckedSlider", "", "canvas", "Landroid/graphics/Canvas;", "drawColorSlider", "drawInequalitySlider", "pageSize", "", "drawRect", "rx", "", "ry", "drawScaleSlider", "i", "drawSmoothSlider", "drawUncheckedSlider", "drawWormSlider", "onDraw", "indicator_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class RectDrawer extends BaseDrawer {

    @NotNull
    private RectF mRectF;

    public RectDrawer(@NotNull IndicatorOptions indicatorOptions) {
        super(indicatorOptions);
        this.mRectF = new RectF();
    }

    private final void drawCheckedSlider(Canvas canvas) {
        getMPaint().setColor(getMIndicatorOptions().getCheckedSliderColor());
        int slideMode = getMIndicatorOptions().getSlideMode();
        if (slideMode != 2) {
            if (slideMode != 3) {
                if (slideMode == 5) {
                    drawColorSlider(canvas);
                    return;
                }
                return;
            }
            drawWormSlider(canvas);
            return;
        }
        drawSmoothSlider(canvas);
    }

    private final void drawColorSlider(Canvas canvas) {
        int currentPosition = getMIndicatorOptions().getCurrentPosition();
        float slideProgress = getMIndicatorOptions().getSlideProgress();
        float f = currentPosition;
        float minWidth = (getMinWidth() * f) + (f * getMIndicatorOptions().getSliderGap());
        if (getArgbEvaluator() == null) {
            setArgbEvaluator$indicator_release(new ArgbEvaluator());
        }
        if (slideProgress < 0.99d) {
            ArgbEvaluator argbEvaluator = getArgbEvaluator();
            if (argbEvaluator != null) {
                Object evaluate = argbEvaluator.evaluate(slideProgress, Integer.valueOf(getMIndicatorOptions().getCheckedSliderColor()), Integer.valueOf(getMIndicatorOptions().getNormalSliderColor()));
                Paint mPaint = getMPaint();
                if (evaluate != null) {
                    mPaint.setColor(((Integer) evaluate).intValue());
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                }
            }
            this.mRectF.set(minWidth, 0.0f, getMinWidth() + minWidth, getMIndicatorOptions().getSliderHeight());
            drawRect(canvas, getMIndicatorOptions().getSliderHeight(), getMIndicatorOptions().getSliderHeight());
        }
        float sliderGap = minWidth + getMIndicatorOptions().getSliderGap() + getMIndicatorOptions().getNormalSliderWidth();
        if (currentPosition == getMIndicatorOptions().getPageSize() - 1) {
            sliderGap = 0.0f;
        }
        ArgbEvaluator argbEvaluator2 = getArgbEvaluator();
        if (argbEvaluator2 != null) {
            Object evaluate2 = argbEvaluator2.evaluate(1 - slideProgress, Integer.valueOf(getMIndicatorOptions().getCheckedSliderColor()), Integer.valueOf(getMIndicatorOptions().getNormalSliderColor()));
            Paint mPaint2 = getMPaint();
            if (evaluate2 != null) {
                mPaint2.setColor(((Integer) evaluate2).intValue());
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
        }
        this.mRectF.set(sliderGap, 0.0f, getMinWidth() + sliderGap, getMIndicatorOptions().getSliderHeight());
        drawRect(canvas, getMIndicatorOptions().getSliderHeight(), getMIndicatorOptions().getSliderHeight());
    }

    private final void drawInequalitySlider(Canvas canvas, int pageSize) {
        float minWidth;
        int normalSliderColor;
        float f = 0.0f;
        for (int i = 0; i < pageSize; i++) {
            if (i == getMIndicatorOptions().getCurrentPosition()) {
                minWidth = getMaxWidth();
            } else {
                minWidth = getMinWidth();
            }
            Paint mPaint = getMPaint();
            if (i == getMIndicatorOptions().getCurrentPosition()) {
                normalSliderColor = getMIndicatorOptions().getCheckedSliderColor();
            } else {
                normalSliderColor = getMIndicatorOptions().getNormalSliderColor();
            }
            mPaint.setColor(normalSliderColor);
            this.mRectF.set(f, 0.0f, f + minWidth, getMIndicatorOptions().getSliderHeight());
            drawRect(canvas, getMIndicatorOptions().getSliderHeight(), getMIndicatorOptions().getSliderHeight());
            f += minWidth + getMIndicatorOptions().getSliderGap();
        }
    }

    private final void drawScaleSlider(Canvas canvas, int i) {
        float f;
        int checkedSliderColor = getMIndicatorOptions().getCheckedSliderColor();
        float sliderGap = getMIndicatorOptions().getSliderGap();
        float sliderHeight = getMIndicatorOptions().getSliderHeight();
        int currentPosition = getMIndicatorOptions().getCurrentPosition();
        float normalSliderWidth = getMIndicatorOptions().getNormalSliderWidth();
        float checkedSliderWidth = getMIndicatorOptions().getCheckedSliderWidth();
        if (getArgbEvaluator() == null) {
            setArgbEvaluator$indicator_release(new ArgbEvaluator());
        }
        if (i < currentPosition) {
            getMPaint().setColor(getMIndicatorOptions().getNormalSliderColor());
            if (currentPosition == getMIndicatorOptions().getPageSize() - 1) {
                float f2 = i;
                f = (f2 * normalSliderWidth) + (f2 * sliderGap) + ((checkedSliderWidth - normalSliderWidth) * getMIndicatorOptions().getSlideProgress());
            } else {
                float f3 = i;
                f = (f3 * normalSliderWidth) + (f3 * sliderGap);
            }
            this.mRectF.set(f, 0.0f, normalSliderWidth + f, sliderHeight);
            drawRect(canvas, sliderHeight, sliderHeight);
            return;
        }
        if (i == currentPosition) {
            getMPaint().setColor(checkedSliderColor);
            float slideProgress = getMIndicatorOptions().getSlideProgress();
            if (currentPosition == getMIndicatorOptions().getPageSize() - 1) {
                ArgbEvaluator argbEvaluator = getArgbEvaluator();
                if (argbEvaluator != null) {
                    Object evaluate = argbEvaluator.evaluate(slideProgress, Integer.valueOf(checkedSliderColor), Integer.valueOf(getMIndicatorOptions().getNormalSliderColor()));
                    Paint mPaint = getMPaint();
                    if (evaluate != null) {
                        mPaint.setColor(((Integer) evaluate).intValue());
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                    }
                }
                float pageSize = ((getMIndicatorOptions().getPageSize() - 1) * (getMIndicatorOptions().getSliderGap() + normalSliderWidth)) + checkedSliderWidth;
                this.mRectF.set((pageSize - checkedSliderWidth) + ((checkedSliderWidth - normalSliderWidth) * slideProgress), 0.0f, pageSize, sliderHeight);
                drawRect(canvas, sliderHeight, sliderHeight);
            } else {
                float f4 = 1;
                if (slideProgress < f4) {
                    ArgbEvaluator argbEvaluator2 = getArgbEvaluator();
                    if (argbEvaluator2 != null) {
                        Object evaluate2 = argbEvaluator2.evaluate(slideProgress, Integer.valueOf(checkedSliderColor), Integer.valueOf(getMIndicatorOptions().getNormalSliderColor()));
                        Paint mPaint2 = getMPaint();
                        if (evaluate2 != null) {
                            mPaint2.setColor(((Integer) evaluate2).intValue());
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                        }
                    }
                    float f5 = i;
                    float f6 = (f5 * normalSliderWidth) + (f5 * sliderGap);
                    this.mRectF.set(f6, 0.0f, f6 + normalSliderWidth + ((checkedSliderWidth - normalSliderWidth) * (f4 - slideProgress)), sliderHeight);
                    drawRect(canvas, sliderHeight, sliderHeight);
                }
            }
            if (currentPosition == getMIndicatorOptions().getPageSize() - 1) {
                if (slideProgress > 0) {
                    ArgbEvaluator argbEvaluator3 = getArgbEvaluator();
                    if (argbEvaluator3 != null) {
                        Object evaluate3 = argbEvaluator3.evaluate(1 - slideProgress, Integer.valueOf(checkedSliderColor), Integer.valueOf(getMIndicatorOptions().getNormalSliderColor()));
                        Paint mPaint3 = getMPaint();
                        if (evaluate3 != null) {
                            mPaint3.setColor(((Integer) evaluate3).intValue());
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                        }
                    }
                    this.mRectF.set(0.0f, 0.0f, normalSliderWidth + 0.0f + ((checkedSliderWidth - normalSliderWidth) * slideProgress), sliderHeight);
                    drawRect(canvas, sliderHeight, sliderHeight);
                    return;
                }
                return;
            }
            if (slideProgress > 0) {
                ArgbEvaluator argbEvaluator4 = getArgbEvaluator();
                if (argbEvaluator4 != null) {
                    Object evaluate4 = argbEvaluator4.evaluate(1 - slideProgress, Integer.valueOf(checkedSliderColor), Integer.valueOf(getMIndicatorOptions().getNormalSliderColor()));
                    Paint mPaint4 = getMPaint();
                    if (evaluate4 != null) {
                        mPaint4.setColor(((Integer) evaluate4).intValue());
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                    }
                }
                float f7 = i;
                float f8 = (f7 * normalSliderWidth) + (f7 * sliderGap) + normalSliderWidth + sliderGap + checkedSliderWidth;
                this.mRectF.set((f8 - normalSliderWidth) - ((checkedSliderWidth - normalSliderWidth) * slideProgress), 0.0f, f8, sliderHeight);
                drawRect(canvas, sliderHeight, sliderHeight);
                return;
            }
            return;
        }
        if (currentPosition + 1 != i || getMIndicatorOptions().getSlideProgress() == 0.0f) {
            getMPaint().setColor(getMIndicatorOptions().getNormalSliderColor());
            float f9 = i;
            float minWidth = (getMinWidth() * f9) + (f9 * sliderGap) + (checkedSliderWidth - getMinWidth());
            this.mRectF.set(minWidth, 0.0f, getMinWidth() + minWidth, sliderHeight);
            drawRect(canvas, sliderHeight, sliderHeight);
        }
    }

    private final void drawSmoothSlider(Canvas canvas) {
        int currentPosition = getMIndicatorOptions().getCurrentPosition();
        float sliderGap = getMIndicatorOptions().getSliderGap();
        float sliderHeight = getMIndicatorOptions().getSliderHeight();
        float f = currentPosition;
        float maxWidth = (getMaxWidth() * f) + (f * sliderGap) + ((getMaxWidth() + sliderGap) * getMIndicatorOptions().getSlideProgress());
        this.mRectF.set(maxWidth, 0.0f, getMaxWidth() + maxWidth, sliderHeight);
        drawRect(canvas, sliderHeight, sliderHeight);
    }

    private final void drawUncheckedSlider(Canvas canvas, int pageSize) {
        for (int i = 0; i < pageSize; i++) {
            getMPaint().setColor(getMIndicatorOptions().getNormalSliderColor());
            float f = i;
            float maxWidth = (getMaxWidth() * f) + (f * getMIndicatorOptions().getSliderGap()) + (getMaxWidth() - getMinWidth());
            this.mRectF.set(maxWidth, 0.0f, getMinWidth() + maxWidth, getMIndicatorOptions().getSliderHeight());
            drawRect(canvas, getMIndicatorOptions().getSliderHeight(), getMIndicatorOptions().getSliderHeight());
        }
    }

    private final void drawWormSlider(Canvas canvas) {
        float sliderHeight = getMIndicatorOptions().getSliderHeight();
        float slideProgress = getMIndicatorOptions().getSlideProgress();
        int currentPosition = getMIndicatorOptions().getCurrentPosition();
        float sliderGap = getMIndicatorOptions().getSliderGap() + getMIndicatorOptions().getNormalSliderWidth();
        float coordinateX = IndicatorUtils.INSTANCE.getCoordinateX(getMIndicatorOptions(), getMaxWidth(), currentPosition);
        float f = 2;
        this.mRectF.set((RangesKt.coerceAtLeast(((slideProgress - 0.5f) * sliderGap) * 2.0f, 0.0f) + coordinateX) - (getMIndicatorOptions().getNormalSliderWidth() / f), 0.0f, coordinateX + RangesKt.coerceAtMost(slideProgress * sliderGap * 2.0f, sliderGap) + (getMIndicatorOptions().getNormalSliderWidth() / f), sliderHeight);
        drawRect(canvas, sliderHeight, sliderHeight);
    }

    public abstract void drawRect(@NotNull Canvas canvas, float rx, float ry);

    @NotNull
    /* renamed from: getMRectF$indicator_release, reason: from getter */
    public final RectF getMRectF() {
        return this.mRectF;
    }

    @Override // com.zhpan.indicator.drawer.IDrawer
    public void onDraw(@NotNull Canvas canvas) {
        int pageSize = getMIndicatorOptions().getPageSize();
        if (pageSize > 1 || (getMIndicatorOptions().getShowIndicatorOneItem() && pageSize == 1)) {
            if (isWidthEquals() && getMIndicatorOptions().getSlideMode() != 0) {
                drawUncheckedSlider(canvas, pageSize);
                drawCheckedSlider(canvas);
            } else {
                if (getMIndicatorOptions().getSlideMode() == 4) {
                    for (int i = 0; i < pageSize; i++) {
                        drawScaleSlider(canvas, i);
                    }
                    return;
                }
                drawInequalitySlider(canvas, pageSize);
            }
        }
    }

    public final void setMRectF$indicator_release(@NotNull RectF rectF) {
        this.mRectF = rectF;
    }
}
