package com.qhqc.core.basic.widget.svprogresshud.indicator;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001EB\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001fJ\u0006\u0010'\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0005J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001cH&J\b\u0010-\u001a\u00020$H\u0002J\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020/J\b\u00101\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u00020\u0005H\u0016J\b\u00103\u001a\u00020\u0014H\u0016J\u0010\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020\fH\u0014J\u001c\u00106\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0019H&J\u0006\u00107\u001a\u00020$J\u0010\u00108\u001a\u00020$2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u00109\u001a\u00020$2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J&\u0010\u000f\u001a\u00020$2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010@\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010A\u001a\u00020$H\u0016J\b\u0010B\u001a\u00020$H\u0002J\b\u0010C\u001a\u00020$H\u0016J\b\u0010D\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\"\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001f` X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\"\u0010\b¨\u0006F"}, d2 = {"Lcom/qhqc/core/basic/widget/svprogresshud/indicator/Indicator;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Animatable;", "()V", "alpha", "", "color", "getColor", "()I", "setColor", "(I)V", "drawBounds", "Landroid/graphics/Rect;", "getDrawBounds", "()Landroid/graphics/Rect;", "setDrawBounds", "(Landroid/graphics/Rect;)V", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "getHeight", "isStarted", "", "()Z", "mAnimators", "Ljava/util/ArrayList;", "Landroid/animation/ValueAnimator;", "Lkotlin/collections/ArrayList;", "mHasAnimators", "mPaint", "Landroid/graphics/Paint;", "mUpdateListeners", "Ljava/util/HashMap;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Lkotlin/collections/HashMap;", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "getWidth", "addUpdateListener", "", "animator", "updateListener", "centerX", "centerY", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "ensureAnimators", "exactCenterX", "", "exactCenterY", "getAlpha", "getOpacity", "isRunning", "onBoundsChange", "bounds", "onCreateAnimators", "postInvalidate", "setAlpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", ViewHierarchyConstants.DIMENSION_LEFT_KEY, ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "setDrawBoundsFrom", "start", "startAnimators", "stop", "stopAnimators", "Companion", "basic_widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class Indicator extends Drawable implements Animatable {

    @NotNull
    private static final Rect ZERO_BOUNDS_RECT = new Rect();

    @Nullable
    private ArrayList<ValueAnimator> mAnimators;
    private boolean mHasAnimators;

    @NotNull
    private final Paint mPaint;

    @NotNull
    private final HashMap<ValueAnimator, ValueAnimator.AnimatorUpdateListener> mUpdateListeners = new HashMap<>();
    private int alpha = KotlinVersion.MAX_COMPONENT_VALUE;

    @NotNull
    private Rect drawBounds = ZERO_BOUNDS_RECT;

    public Indicator() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    private final void ensureAnimators() {
        if (!this.mHasAnimators) {
            this.mAnimators = onCreateAnimators();
            this.mHasAnimators = true;
        }
    }

    private final boolean isStarted() {
        ArrayList<ValueAnimator> arrayList = this.mAnimators;
        Intrinsics.checkNotNull(arrayList);
        Iterator<ValueAnimator> it = arrayList.iterator();
        if (it.hasNext()) {
            return it.next().isStarted();
        }
        return false;
    }

    private final void startAnimators() {
        ArrayList<ValueAnimator> arrayList = this.mAnimators;
        Intrinsics.checkNotNull(arrayList);
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<ValueAnimator> arrayList2 = this.mAnimators;
            Intrinsics.checkNotNull(arrayList2);
            ValueAnimator valueAnimator = arrayList2.get(i10);
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "get(...)");
            ValueAnimator valueAnimator2 = valueAnimator;
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.mUpdateListeners.get(valueAnimator2);
            if (animatorUpdateListener != null) {
                valueAnimator2.addUpdateListener(animatorUpdateListener);
            }
            valueAnimator2.start();
        }
    }

    private final void stopAnimators() {
        ArrayList<ValueAnimator> arrayList = this.mAnimators;
        if (arrayList != null) {
            Intrinsics.checkNotNull(arrayList);
            Iterator<ValueAnimator> it = arrayList.iterator();
            while (it.hasNext()) {
                ValueAnimator next = it.next();
                if (next != null && next.isStarted()) {
                    next.removeAllUpdateListeners();
                    next.end();
                }
            }
        }
    }

    public final void addUpdateListener(@NotNull ValueAnimator animator, @NotNull ValueAnimator.AnimatorUpdateListener updateListener) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Intrinsics.checkNotNullParameter(updateListener, "updateListener");
        this.mUpdateListeners.put(animator, updateListener);
    }

    public final int centerX() {
        return this.drawBounds.centerX();
    }

    public final int centerY() {
        return this.drawBounds.centerY();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        draw(canvas, this.mPaint);
    }

    public abstract void draw(@NotNull Canvas canvas, @NotNull Paint paint);

    public final float exactCenterX() {
        return this.drawBounds.exactCenterX();
    }

    public final float exactCenterY() {
        return this.drawBounds.exactCenterY();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    public final int getColor() {
        return this.mPaint.getColor();
    }

    @NotNull
    protected final Rect getDrawBounds() {
        return this.drawBounds;
    }

    public final int getHeight() {
        return this.drawBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    public final int getWidth() {
        return this.drawBounds.width();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ArrayList<ValueAnimator> arrayList = this.mAnimators;
        Intrinsics.checkNotNull(arrayList);
        Iterator<ValueAnimator> it = arrayList.iterator();
        if (it.hasNext()) {
            return it.next().isRunning();
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NotNull Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        setDrawBoundsFrom(bounds);
    }

    @Nullable
    public abstract ArrayList<ValueAnimator> onCreateAnimators();

    public final void postInvalidate() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public final void setColor(int i10) {
        this.mPaint.setColor(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    protected final void setDrawBounds(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        this.drawBounds = rect;
    }

    public final void setDrawBoundsFrom(@NotNull Rect drawBounds) {
        Intrinsics.checkNotNullParameter(drawBounds, "drawBounds");
        setDrawBounds(drawBounds.left, drawBounds.top, drawBounds.right, drawBounds.bottom);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        ensureAnimators();
        if (this.mAnimators == null || isStarted()) {
            return;
        }
        startAnimators();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        stopAnimators();
    }

    public final void setDrawBounds(int left, int top, int right, int bottom) {
        this.drawBounds = new Rect(left, top, right, bottom);
    }
}
