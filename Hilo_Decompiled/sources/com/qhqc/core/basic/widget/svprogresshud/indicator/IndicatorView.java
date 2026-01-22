package com.qhqc.core.basic.widget.svprogresshud.indicator;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qhqc.core.basic.widget.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 [2\u00020\u0001:\u0001[B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201J\u0018\u00102\u001a\u00020/2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000204H\u0017J\b\u00106\u001a\u00020/H\u0014J\u0006\u00107\u001a\u00020/J*\u00108\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020/H\u0014J\b\u0010=\u001a\u00020/H\u0014J\u0010\u0010>\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0014J\u0018\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\tH\u0014J(\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0014J\u0018\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020\u00012\u0006\u0010I\u001a\u00020\tH\u0014J\b\u0010J\u001a\u00020/H\u0002J\u000e\u0010K\u001a\u00020/2\u0006\u0010L\u001a\u00020\tJ\u0010\u0010M\u001a\u00020/2\b\u0010N\u001a\u0004\u0018\u00010OJ\u0010\u0010P\u001a\u00020/2\u0006\u0010Q\u001a\u00020\tH\u0016J\u0006\u0010R\u001a\u00020/J\u0006\u0010S\u001a\u00020/J\u0006\u0010T\u001a\u00020/J\u0006\u0010U\u001a\u00020/J\u0006\u0010V\u001a\u00020/J\u0018\u0010W\u001a\u00020/2\u0006\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\tH\u0002J\b\u0010X\u001a\u00020/H\u0002J\u0010\u0010Y\u001a\u00020\u00182\u0006\u0010Z\u001a\u00020;H\u0014R(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001a\u0010&\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\u000e\u0010)\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/qhqc/core/basic/widget/svprogresshud/indicator/IndicatorView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "d", "Lcom/qhqc/core/basic/widget/svprogresshud/indicator/Indicator;", "indicator", "getIndicator", "()Lcom/qhqc/core/basic/widget/svprogresshud/indicator/Indicator;", "setIndicator", "(Lcom/qhqc/core/basic/widget/svprogresshud/indicator/Indicator;)V", "mDelayedHide", "Ljava/lang/Runnable;", "mDelayedShow", "mDismissed", "", "mIndicator", "mIndicatorColor", "mMaxHeight", "getMMaxHeight", "()I", "setMMaxHeight", "(I)V", "mMaxWidth", "getMMaxWidth", "setMMaxWidth", "mMinHeight", "getMMinHeight", "setMMinHeight", "mMinWidth", "getMMinWidth", "setMMinWidth", "mPostedHide", "mPostedShow", "mShouldStartAnimationDrawable", "mStartTime", "", "drawTrack", "", "canvas", "Landroid/graphics/Canvas;", "drawableHotspotChanged", "x", "", "y", "drawableStateChanged", "hide", "init", "invalidateDrawable", "dr", "Landroid/graphics/drawable/Drawable;", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onVisibilityChanged", "changedView", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "removeCallbacks", "setIndicatorColor", "color", "setIndicatorName", "indicatorName", "", "setVisibility", "v", "show", "smoothToHide", "smoothToShow", "startAnimation", "stopAnimation", "updateDrawableBounds", "updateDrawableState", "verifyDrawable", "who", "Companion", "basic_widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class IndicatorView extends View {

    @NotNull
    private static final LineScaleIndicator DEFAULT_INDICATOR = new LineScaleIndicator();
    private static final int MIN_DELAY = 500;
    private static final int MIN_SHOW_TIME = 500;

    @NotNull
    private static final String TAG = "AVLoadingIndicatorView";

    @NotNull
    private final Runnable mDelayedHide;

    @NotNull
    private final Runnable mDelayedShow;
    private boolean mDismissed;

    @Nullable
    private Indicator mIndicator;
    private int mIndicatorColor;
    private int mMaxHeight;
    private int mMaxWidth;
    private int mMinHeight;
    private int mMinWidth;
    private boolean mPostedHide;
    private boolean mPostedShow;
    private boolean mShouldStartAnimationDrawable;
    private long mStartTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndicatorView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mStartTime = -1L;
        this.mDelayedHide = new Runnable() { // from class: com.qhqc.core.basic.widget.svprogresshud.indicator.a
            @Override // java.lang.Runnable
            public final void run() {
                IndicatorView.mDelayedHide$lambda$0(IndicatorView.this);
            }
        };
        this.mDelayedShow = new Runnable() { // from class: com.qhqc.core.basic.widget.svprogresshud.indicator.b
            @Override // java.lang.Runnable
            public final void run() {
                IndicatorView.mDelayedShow$lambda$1(IndicatorView.this);
            }
        };
        init(context, null, 0, 0);
    }

    private final void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mMinWidth = 24;
        this.mMaxWidth = 48;
        this.mMinHeight = 24;
        this.mMaxHeight = 48;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.IndicatorView, defStyleAttr, defStyleRes);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_minWidth, this.mMinWidth);
        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_maxWidth, this.mMaxWidth);
        this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_minHeight, this.mMinHeight);
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_maxHeight, this.mMaxHeight);
        String string = obtainStyledAttributes.getString(R.styleable.IndicatorView_indicatorName);
        this.mIndicatorColor = obtainStyledAttributes.getColor(R.styleable.IndicatorView_indicatorColor, -1);
        setIndicatorName(string);
        if (this.mIndicator == null) {
            setIndicator(DEFAULT_INDICATOR);
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mDelayedHide$lambda$0(IndicatorView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mPostedHide = false;
        this$0.mStartTime = -1L;
        this$0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mDelayedShow$lambda$1(IndicatorView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mPostedShow = false;
        if (!this$0.mDismissed) {
            this$0.mStartTime = System.currentTimeMillis();
            this$0.setVisibility(0);
        }
    }

    private final void removeCallbacks() {
        removeCallbacks(this.mDelayedHide);
        removeCallbacks(this.mDelayedShow);
    }

    private final void updateDrawableBounds(int w10, int h10) {
        int i10;
        int paddingRight = w10 - (getPaddingRight() + getPaddingLeft());
        int paddingTop = h10 - (getPaddingTop() + getPaddingBottom());
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            Intrinsics.checkNotNull(indicator);
            int intrinsicWidth = indicator.getIntrinsicWidth();
            Intrinsics.checkNotNull(this.mIndicator);
            float intrinsicHeight = intrinsicWidth / r1.getIntrinsicHeight();
            float f10 = paddingRight;
            float f11 = paddingTop;
            float f12 = f10 / f11;
            int i11 = 0;
            if (intrinsicHeight != f12) {
                if (f12 > intrinsicHeight) {
                    int i12 = (int) (f11 * intrinsicHeight);
                    int i13 = (paddingRight - i12) / 2;
                    i11 = i13;
                    paddingRight = i12 + i13;
                } else {
                    int i14 = (int) (f10 * (1 / intrinsicHeight));
                    int i15 = (paddingTop - i14) / 2;
                    int i16 = i14 + i15;
                    i10 = i15;
                    paddingTop = i16;
                    Indicator indicator2 = this.mIndicator;
                    Intrinsics.checkNotNull(indicator2);
                    indicator2.setBounds(i11, i10, paddingRight, paddingTop);
                }
            }
            i10 = 0;
            Indicator indicator22 = this.mIndicator;
            Intrinsics.checkNotNull(indicator22);
            indicator22.setBounds(i11, i10, paddingRight, paddingTop);
        }
    }

    private final void updateDrawableState() {
        int[] drawableState = getDrawableState();
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            Intrinsics.checkNotNull(indicator);
            if (indicator.isStateful()) {
                Indicator indicator2 = this.mIndicator;
                Intrinsics.checkNotNull(indicator2);
                indicator2.setState(drawableState);
            }
        }
    }

    public final void drawTrack(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            int save = canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop());
            indicator.draw(canvas);
            canvas.restoreToCount(save);
            if (this.mShouldStartAnimationDrawable) {
                indicator.start();
                this.mShouldStartAnimationDrawable = false;
            }
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float x10, float y10) {
        super.drawableHotspotChanged(x10, y10);
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            Intrinsics.checkNotNull(indicator);
            indicator.setHotspot(x10, y10);
        }
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
    }

    @Nullable
    /* renamed from: getIndicator, reason: from getter */
    public final Indicator getMIndicator() {
        return this.mIndicator;
    }

    public final int getMMaxHeight() {
        return this.mMaxHeight;
    }

    public final int getMMaxWidth() {
        return this.mMaxWidth;
    }

    public final int getMMinHeight() {
        return this.mMinHeight;
    }

    public final int getMMinWidth() {
        return this.mMinWidth;
    }

    public final void hide() {
        this.mDismissed = true;
        removeCallbacks(this.mDelayedShow);
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = this.mStartTime;
        long j11 = currentTimeMillis - j10;
        if (j11 < 500 && j10 != -1) {
            if (!this.mPostedHide) {
                postDelayed(this.mDelayedHide, 500 - j11);
                this.mPostedHide = true;
                return;
            }
            return;
        }
        setVisibility(4);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NotNull Drawable dr) {
        Intrinsics.checkNotNullParameter(dr, "dr");
        if (verifyDrawable(dr)) {
            Rect bounds = dr.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            int scrollX = getScrollX() + getPaddingLeft();
            int scrollY = getScrollY() + getPaddingTop();
            invalidate(bounds.left + scrollX, bounds.top + scrollY, bounds.right + scrollX, bounds.bottom + scrollY);
            return;
        }
        super.invalidateDrawable(dr);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
        removeCallbacks();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        stopAnimation();
        super.onDetachedFromWindow();
        removeCallbacks();
    }

    @Override // android.view.View
    protected synchronized void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        drawTrack(canvas);
    }

    @Override // android.view.View
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i10;
        int i11;
        try {
            if (this.mIndicator != null) {
                i11 = (int) Math.max(this.mMinWidth, Math.min(this.mMaxWidth, r0.getIntrinsicWidth()));
                i10 = (int) Math.max(this.mMinHeight, Math.min(this.mMaxHeight, r0.getIntrinsicHeight()));
            } else {
                i10 = 0;
                i11 = 0;
            }
            updateDrawableState();
            setMeasuredDimension(View.resolveSizeAndState(i11 + getPaddingLeft() + getPaddingRight(), widthMeasureSpec, 0), View.resolveSizeAndState(i10 + getPaddingTop() + getPaddingBottom(), heightMeasureSpec, 0));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        updateDrawableBounds(w10, h10);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility != 4 && visibility != 8) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    public final void setIndicator(@Nullable Indicator indicator) {
        Indicator indicator2 = this.mIndicator;
        if (indicator2 != indicator) {
            if (indicator2 != null) {
                Intrinsics.checkNotNull(indicator2);
                indicator2.setCallback(null);
                unscheduleDrawable(this.mIndicator);
            }
            this.mIndicator = indicator;
            setIndicatorColor(this.mIndicatorColor);
            if (indicator != null) {
                indicator.setCallback(this);
            }
            postInvalidate();
        }
    }

    public final void setIndicatorColor(int color) {
        this.mIndicatorColor = color;
        Indicator indicator = this.mIndicator;
        Intrinsics.checkNotNull(indicator);
        indicator.setColor(color);
    }

    public final void setIndicatorName(@Nullable String indicatorName) {
        if (TextUtils.isEmpty(indicatorName)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNull(indicatorName);
        if (!StringsKt.contains$default((CharSequence) indicatorName, (CharSequence) InstructionFileId.DOT, false, 2, (Object) null)) {
            sb.append(IndicatorView.class.getPackage().getName());
            sb.append(".indicators");
            sb.append(InstructionFileId.DOT);
        }
        sb.append(indicatorName);
        try {
            Object newInstance = Class.forName(sb.toString()).newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.qhqc.core.basic.widget.svprogresshud.indicator.Indicator");
            setIndicator((Indicator) newInstance);
        } catch (ClassNotFoundException unused) {
            Log.e(TAG, "Didn't find your class , check the name again !");
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (InstantiationException e11) {
            e11.printStackTrace();
        }
    }

    public final void setMMaxHeight(int i10) {
        this.mMaxHeight = i10;
    }

    public final void setMMaxWidth(int i10) {
        this.mMaxWidth = i10;
    }

    public final void setMMinHeight(int i10) {
        this.mMinHeight = i10;
    }

    public final void setMMinWidth(int i10) {
        this.mMinWidth = i10;
    }

    @Override // android.view.View
    public void setVisibility(int v10) {
        if (getVisibility() != v10) {
            super.setVisibility(v10);
            if (v10 != 4 && v10 != 8) {
                startAnimation();
            } else {
                stopAnimation();
            }
        }
    }

    public final void show() {
        this.mStartTime = -1L;
        this.mDismissed = false;
        removeCallbacks(this.mDelayedHide);
        if (!this.mPostedShow) {
            postDelayed(this.mDelayedShow, 500L);
            this.mPostedShow = true;
        }
    }

    public final void smoothToHide() {
        startAnimation(AnimationUtils.loadAnimation(getContext(), android.R.anim.fade_out));
        setVisibility(8);
    }

    public final void smoothToShow() {
        startAnimation(AnimationUtils.loadAnimation(getContext(), android.R.anim.fade_in));
        setVisibility(0);
    }

    public final void startAnimation() {
        if (getVisibility() != 0) {
            return;
        }
        if (this.mIndicator instanceof Animatable) {
            this.mShouldStartAnimationDrawable = true;
        }
        postInvalidate();
    }

    public final void stopAnimation() {
        Indicator indicator = this.mIndicator;
        if (indicator instanceof Animatable) {
            Intrinsics.checkNotNull(indicator);
            indicator.stop();
            this.mShouldStartAnimationDrawable = false;
        }
        postInvalidate();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NotNull Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        if (who != this.mIndicator && !super.verifyDrawable(who)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndicatorView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mStartTime = -1L;
        this.mDelayedHide = new Runnable() { // from class: com.qhqc.core.basic.widget.svprogresshud.indicator.a
            @Override // java.lang.Runnable
            public final void run() {
                IndicatorView.mDelayedHide$lambda$0(IndicatorView.this);
            }
        };
        this.mDelayedShow = new Runnable() { // from class: com.qhqc.core.basic.widget.svprogresshud.indicator.b
            @Override // java.lang.Runnable
            public final void run() {
                IndicatorView.mDelayedShow$lambda$1(IndicatorView.this);
            }
        };
        init(context, attributeSet, 0, R.style.IndicatorView);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndicatorView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mStartTime = -1L;
        this.mDelayedHide = new Runnable() { // from class: com.qhqc.core.basic.widget.svprogresshud.indicator.a
            @Override // java.lang.Runnable
            public final void run() {
                IndicatorView.mDelayedHide$lambda$0(IndicatorView.this);
            }
        };
        this.mDelayedShow = new Runnable() { // from class: com.qhqc.core.basic.widget.svprogresshud.indicator.b
            @Override // java.lang.Runnable
            public final void run() {
                IndicatorView.mDelayedShow$lambda$1(IndicatorView.this);
            }
        };
        init(context, attributeSet, i10, R.style.IndicatorView);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public IndicatorView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mStartTime = -1L;
        this.mDelayedHide = new Runnable() { // from class: com.qhqc.core.basic.widget.svprogresshud.indicator.a
            @Override // java.lang.Runnable
            public final void run() {
                IndicatorView.mDelayedHide$lambda$0(IndicatorView.this);
            }
        };
        this.mDelayedShow = new Runnable() { // from class: com.qhqc.core.basic.widget.svprogresshud.indicator.b
            @Override // java.lang.Runnable
            public final void run() {
                IndicatorView.mDelayedShow$lambda$1(IndicatorView.this);
            }
        };
        init(context, attributeSet, i10, R.style.IndicatorView);
    }
}
