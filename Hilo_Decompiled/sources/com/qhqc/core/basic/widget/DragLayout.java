package com.qhqc.core.basic.widget;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001SB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\tJ\u0010\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020AH\u0014J\b\u0010B\u001a\u00020<H\u0002J\u0010\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\tH\u0002J\u001a\u0010E\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010F\u001a\u00020<H\u0014J\u0012\u0010G\u001a\u00020\u00132\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0018\u0010J\u001a\u00020<2\u0006\u0010K\u001a\u00020\t2\u0006\u0010D\u001a\u00020\tH\u0014J(\u0010L\u001a\u00020<2\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0014J\u0012\u0010Q\u001a\u00020\u00132\b\u0010R\u001a\u0004\u0018\u00010IH\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\u001a\u0010\u001e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u000e\u0010&\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010:\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/qhqc/core/basic/widget/DragLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "innerView", "Landroid/view/View;", "getInnerView", "()Landroid/view/View;", "setInnerView", "(Landroid/view/View;)V", "innerViewId", "isAlphaVariable", "", "()Z", "setAlphaVariable", "(Z)V", "isIntercept", "isScaleVariable", "setScaleVariable", "isTranslationXVariable", "setTranslationXVariable", "isTranslationYTopVariable", "setTranslationYTopVariable", "mAlpha", "getMAlpha", "()I", "setMAlpha", "(I)V", "mDismissSlop", "getMDismissSlop", "setMDismissSlop", "mDownX", "mDownY", "mInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "mPoint", "Landroid/graphics/Point;", "mResetDuration", "", "mScale", "", "mTouchSlop", "mTranslationX", "mTranslationY", "mViewHeight", "onDragDistanceChangeListener", "Lcom/qhqc/core/basic/widget/DragLayout$OnDragDistanceChangeListener;", "getOnDragDistanceChangeListener", "()Lcom/qhqc/core/basic/widget/DragLayout$OnDragDistanceChangeListener;", "setOnDragDistanceChangeListener", "(Lcom/qhqc/core/basic/widget/DragLayout$OnDragDistanceChangeListener;)V", "resistance", "changeTranslationAndSize", "", "translationX", "translationY", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "finishAnimation", "getMeasureHeight", "heightMeasureSpec", "init", "onFinishInflate", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "OnDragDistanceChangeListener", "basic_widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DragLayout extends FrameLayout {

    @Nullable
    private View innerView;
    private int innerViewId;
    private boolean isAlphaVariable;
    private boolean isIntercept;
    private boolean isScaleVariable;
    private boolean isTranslationXVariable;
    private boolean isTranslationYTopVariable;
    private int mAlpha;
    private int mDismissSlop;
    private int mDownX;
    private int mDownY;

    @NotNull
    private DecelerateInterpolator mInterpolator;

    @NotNull
    private Point mPoint;
    private long mResetDuration;
    private float mScale;
    private int mTouchSlop;
    private int mTranslationX;
    private int mTranslationY;
    private int mViewHeight;

    @Nullable
    private OnDragDistanceChangeListener onDragDistanceChangeListener;
    private float resistance;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/qhqc/core/basic/widget/DragLayout$OnDragDistanceChangeListener;", "", "onDistanceChange", "", "translationX", "", "translationY", "onFingerUp", "basic_widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface OnDragDistanceChangeListener {
        void onDistanceChange(int translationX, int translationY);

        void onFingerUp(int translationX, int translationY);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDismissSlop = 400;
        this.mResetDuration = 300L;
        this.resistance = 1.0f;
        this.mScale = 1.0f;
        this.mAlpha = KotlinVersion.MAX_COMPONENT_VALUE;
        this.isAlphaVariable = true;
        this.isTranslationXVariable = true;
        this.isTranslationYTopVariable = true;
        this.isScaleVariable = true;
        this.mInterpolator = new DecelerateInterpolator();
        this.mPoint = new Point(0, 0);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private final void finishAnimation() {
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("mTranslationX", this.mTranslationX, 0), PropertyValuesHolder.ofInt("mTranslationY", this.mTranslationY, 0), PropertyValuesHolder.ofFloat("animateScale", this.mScale, 1.0f));
        ofPropertyValuesHolder.setDuration(this.mResetDuration);
        ofPropertyValuesHolder.setInterpolator(this.mInterpolator);
        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qhqc.core.basic.widget.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DragLayout.finishAnimation$lambda$3(DragLayout.this, valueAnimator);
            }
        });
        ofPropertyValuesHolder.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void finishAnimation$lambda$3(DragLayout this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue("mTranslationX");
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.mTranslationX = ((Integer) animatedValue).intValue();
        Object animatedValue2 = it.getAnimatedValue("mTranslationY");
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Int");
        this$0.mTranslationY = ((Integer) animatedValue2).intValue();
        Object animatedValue3 = it.getAnimatedValue("animateScale");
        Intrinsics.checkNotNull(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue3).floatValue();
        this$0.mScale = floatValue;
        this$0.mAlpha = (int) (KotlinVersion.MAX_COMPONENT_VALUE * floatValue);
        this$0.postInvalidate();
    }

    private final int getMeasureHeight(int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                return RangesKt.coerceAtMost(75, size);
            }
            return 75;
        }
        return size;
    }

    private final void init(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.DragLayout);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.innerViewId = obtainStyledAttributes.getResourceId(R.styleable.DragLayout_dl_inner_view_id, 0);
        obtainStyledAttributes.recycle();
    }

    public final void changeTranslationAndSize(int translationX, int translationY) {
        this.mTranslationX = translationX;
        this.mTranslationY = translationY;
        if (translationY < 0) {
            this.mScale = 1.0f;
            this.mAlpha = KotlinVersion.MAX_COMPONENT_VALUE;
        } else {
            float abs = Math.abs(1.0f - (translationY / this.mViewHeight));
            this.mScale = abs;
            this.mAlpha = (int) (KotlinVersion.MAX_COMPONENT_VALUE * abs);
        }
        postInvalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        float f10;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.isTranslationXVariable) {
            f10 = this.mTranslationX;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        canvas.translate(f10, this.mTranslationY);
        if (this.isScaleVariable) {
            float f11 = this.mScale;
            Point point = this.mPoint;
            canvas.scale(f11, f11, point.x, point.y);
        }
        if (this.isAlphaVariable) {
            getBackground().setAlpha(this.mAlpha);
        }
        super.dispatchDraw(canvas);
    }

    @Nullable
    public final View getInnerView() {
        return this.innerView;
    }

    public final int getMAlpha() {
        return this.mAlpha;
    }

    public final int getMDismissSlop() {
        return this.mDismissSlop;
    }

    @Nullable
    public final OnDragDistanceChangeListener getOnDragDistanceChangeListener() {
        return this.onDragDistanceChangeListener;
    }

    /* renamed from: isAlphaVariable, reason: from getter */
    public final boolean getIsAlphaVariable() {
        return this.isAlphaVariable;
    }

    /* renamed from: isScaleVariable, reason: from getter */
    public final boolean getIsScaleVariable() {
        return this.isScaleVariable;
    }

    /* renamed from: isTranslationXVariable, reason: from getter */
    public final boolean getIsTranslationXVariable() {
        return this.isTranslationXVariable;
    }

    /* renamed from: isTranslationYTopVariable, reason: from getter */
    public final boolean getIsTranslationYTopVariable() {
        return this.isTranslationYTopVariable;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        View childAt;
        super.onFinishInflate();
        if (getChildCount() > 0) {
            int i10 = this.innerViewId;
            if (i10 != 0) {
                childAt = findViewById(i10);
            } else {
                childAt = getChildAt(0);
            }
            this.innerView = childAt;
        }
        if (this.innerView == null) {
            Log.e("DragLayout", "DragLayout must have innerView");
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev) {
        Integer num;
        View view = this.innerView;
        if (view != null) {
            if (ev != null) {
                num = Integer.valueOf(ev.getActionMasked());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                view.clearAnimation();
                this.mDownX = (int) ev.getX();
                this.mDownY = (int) ev.getY();
            } else if (num != null && num.intValue() == 2) {
                float x10 = ev.getX() - this.mDownX;
                float y10 = ev.getY() - this.mDownY;
                if (Math.abs(y10) > this.mTouchSlop && Math.abs(y10) > Math.abs(x10)) {
                    ViewParent parent = getParent();
                    while (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                        parent = parent.getParent();
                        this.isIntercept = true;
                    }
                    if (!view.canScrollVertically(-1) && y10 > DownloadProgress.UNKNOWN_PROGRESS) {
                        return true;
                    }
                }
            } else if ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 3)) {
                if (this.isIntercept) {
                    for (ViewParent parent2 = getParent(); parent2 != null; parent2 = parent2.getParent()) {
                        parent2.requestDisallowInterceptTouchEvent(false);
                    }
                }
                this.isIntercept = false;
                this.mDownY = 0;
                this.mDownX = 0;
            }
        }
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mViewHeight = getMeasureHeight(heightMeasureSpec);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        Point point = this.mPoint;
        point.x = w10 / 2;
        point.y = h10 / 2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        Integer num;
        View view = this.innerView;
        if (view != null) {
            if (event != null) {
                num = Integer.valueOf(event.getActionMasked());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 2) {
                float x10 = event.getX() - this.mDownX;
                float y10 = event.getY() - this.mDownY;
                if (!view.canScrollVertically(-1) && y10 > DownloadProgress.UNKNOWN_PROGRESS) {
                    OnDragDistanceChangeListener onDragDistanceChangeListener = this.onDragDistanceChangeListener;
                    if (onDragDistanceChangeListener != null) {
                        onDragDistanceChangeListener.onDistanceChange((int) x10, (int) y10);
                    }
                    return true;
                }
                if (!view.canScrollVertically(1) && y10 < DownloadProgress.UNKNOWN_PROGRESS) {
                    if (!this.isTranslationYTopVariable && y10 < DownloadProgress.UNKNOWN_PROGRESS) {
                        return true;
                    }
                    this.mTranslationX = (int) x10;
                    this.mTranslationY = (int) y10;
                    invalidate();
                    return true;
                }
            } else if ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 3)) {
                if (this.mTranslationY < this.mDismissSlop) {
                    finishAnimation();
                } else {
                    float x11 = (event.getX() - this.mDownX) / this.resistance;
                    float y11 = (event.getY() - this.mDownY) / this.resistance;
                    OnDragDistanceChangeListener onDragDistanceChangeListener2 = this.onDragDistanceChangeListener;
                    if (onDragDistanceChangeListener2 != null) {
                        onDragDistanceChangeListener2.onFingerUp((int) x11, (int) y11);
                    }
                }
            }
        }
        try {
            return super.onTouchEvent(event);
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public final void setAlphaVariable(boolean z10) {
        this.isAlphaVariable = z10;
    }

    public final void setInnerView(@Nullable View view) {
        this.innerView = view;
    }

    public final void setMAlpha(int i10) {
        this.mAlpha = i10;
    }

    public final void setMDismissSlop(int i10) {
        this.mDismissSlop = i10;
    }

    public final void setOnDragDistanceChangeListener(@Nullable OnDragDistanceChangeListener onDragDistanceChangeListener) {
        this.onDragDistanceChangeListener = onDragDistanceChangeListener;
    }

    public final void setScaleVariable(boolean z10) {
        this.isScaleVariable = z10;
    }

    public final void setTranslationXVariable(boolean z10) {
        this.isTranslationXVariable = z10;
    }

    public final void setTranslationYTopVariable(boolean z10) {
        this.isTranslationYTopVariable = z10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDismissSlop = 400;
        this.mResetDuration = 300L;
        this.resistance = 1.0f;
        this.mScale = 1.0f;
        this.mAlpha = KotlinVersion.MAX_COMPONENT_VALUE;
        this.isAlphaVariable = true;
        this.isTranslationXVariable = true;
        this.isTranslationYTopVariable = true;
        this.isScaleVariable = true;
        this.mInterpolator = new DecelerateInterpolator();
        this.mPoint = new Point(0, 0);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDismissSlop = 400;
        this.mResetDuration = 300L;
        this.resistance = 1.0f;
        this.mScale = 1.0f;
        this.mAlpha = KotlinVersion.MAX_COMPONENT_VALUE;
        this.isAlphaVariable = true;
        this.isTranslationXVariable = true;
        this.isTranslationYTopVariable = true;
        this.isScaleVariable = true;
        this.mInterpolator = new DecelerateInterpolator();
        this.mPoint = new Point(0, 0);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init(context, attributeSet);
    }
}
