package com.qiahao.nextvideo.ui.reusable.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import com.qiahao.nextvideo.ui.reusable.views.MatchingFloatView;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010(\u001a\u00020)2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0006\u0010*\u001a\u00020)J\u0006\u0010+\u001a\u00020)J\u000e\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u0018\u0010&\u001a\f\u0012\b\u0012\u00060'R\u00020\u00000\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/RippleBackground;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "rippleColor", "getRippleColor", "()I", "setRippleColor", "(I)V", "rippleStrokeWidth", "", "rippleRadius", "rippleDurationTime", "rippleAmount", "rippleDelay", "rippleScale", "rippleType", "paint", "Landroid/graphics/Paint;", "value", "", "isRippleAnimationRunning", "()Z", "animatorSet", "Landroid/animation/AnimatorSet;", "animatorList", "Ljava/util/ArrayList;", "Landroid/animation/Animator;", "rippleParams", "Landroid/widget/RelativeLayout$LayoutParams;", "rippleViewList", "Lcom/qiahao/nextvideo/ui/reusable/views/RippleBackground$RippleView;", "init", "", "start", "stop", VerificationCodeFragment.TYPE_BIND, Constants.KEY_MODE, "Lcom/qiahao/nextvideo/ui/reusable/views/MatchingFloatView$Mode;", "Companion", "RippleView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RippleBackground extends RelativeLayout {
    private static final int DEFAULT_DURATION_TIME = 3000;
    private static final int DEFAULT_FILL_TYPE = 0;
    private static final int DEFAULT_RIPPLE_COUNT = 6;
    private static final float DEFAULT_SCALE = 6.0f;

    @NotNull
    private ArrayList<Animator> animatorList;

    @NotNull
    private final AnimatorSet animatorSet;
    private boolean isRippleAnimationRunning;

    @NotNull
    private Paint paint;
    private int rippleAmount;
    private int rippleColor;
    private int rippleDelay;
    private int rippleDurationTime;
    private RelativeLayout.LayoutParams rippleParams;
    private float rippleRadius;
    private float rippleScale;
    private float rippleStrokeWidth;
    private int rippleType;

    @NotNull
    private final ArrayList<RippleView> rippleViewList;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/RippleBackground$RippleView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Lcom/qiahao/nextvideo/ui/reusable/views/RippleBackground;Landroid/content/Context;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public final class RippleView extends View {
        public RippleView(@Nullable Context context) {
            super(context);
            setVisibility(0);
        }

        @Override // android.view.View
        protected void onDraw(@NotNull Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            float min = Math.min(getWidth(), getHeight()) / 2;
            canvas.drawCircle(min, min, min - RippleBackground.this.rippleStrokeWidth, RippleBackground.this.paint);
        }
    }

    public RippleBackground(@Nullable Context context) {
        super(context);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.paint = paint;
        this.animatorSet = new AnimatorSet();
        this.animatorList = new ArrayList<>();
        this.rippleViewList = new ArrayList<>();
    }

    private final void init(Context context, AttributeSet attrs) {
        if (isInEditMode()) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.RippleBackground);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.rippleColor = obtainStyledAttributes.getColor(0, Color.parseColor("#ffca22"));
        this.rippleStrokeWidth = obtainStyledAttributes.getDimension(5, obtainStyledAttributes.getResources().getDimension(2131166463));
        this.rippleRadius = obtainStyledAttributes.getDimension(2, obtainStyledAttributes.getResources().getDimension(2131166462));
        this.rippleDurationTime = obtainStyledAttributes.getInt(1, 3000);
        this.rippleAmount = obtainStyledAttributes.getInt(3, 6);
        this.rippleScale = obtainStyledAttributes.getFloat(4, DEFAULT_SCALE);
        this.rippleType = obtainStyledAttributes.getInt(6, 0);
        obtainStyledAttributes.recycle();
        this.rippleDelay = this.rippleDurationTime / this.rippleAmount;
        if (this.rippleType == 0) {
            this.rippleStrokeWidth = 0.0f;
            this.paint.setStyle(Paint.Style.FILL);
        } else {
            this.paint.setStyle(Paint.Style.STROKE);
        }
        this.paint.setColor(this.rippleColor);
        float f = 2;
        float f2 = this.rippleRadius;
        float f3 = this.rippleStrokeWidth;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) ((f2 + f3) * f), (int) (f * (f2 + f3)));
        this.rippleParams = layoutParams;
        layoutParams.addRule(13, -1);
        this.animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        int i = this.rippleAmount;
        for (int i2 = 0; i2 < i; i2++) {
            RippleView rippleView = new RippleView(getContext());
            RelativeLayout.LayoutParams layoutParams2 = this.rippleParams;
            if (layoutParams2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rippleParams");
                layoutParams2 = null;
            }
            addView(rippleView, layoutParams2);
            this.rippleViewList.add(rippleView);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(rippleView, "ScaleX", 1.0f, this.rippleScale);
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(1);
            ofFloat.setStartDelay(this.rippleDelay * i2);
            ofFloat.setDuration(this.rippleDurationTime);
            this.animatorList.add(ofFloat);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(rippleView, "ScaleY", 1.0f, this.rippleScale);
            ofFloat2.setRepeatCount(-1);
            ofFloat2.setRepeatMode(1);
            ofFloat2.setStartDelay(this.rippleDelay * i2);
            ofFloat2.setDuration(this.rippleDurationTime);
            this.animatorList.add(ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(rippleView, "Alpha", 1.0f, 0.0f);
            ofFloat3.setRepeatCount(-1);
            ofFloat3.setRepeatMode(1);
            ofFloat3.setStartDelay(this.rippleDelay * i2);
            ofFloat3.setDuration(this.rippleDurationTime);
            this.animatorList.add(ofFloat3);
        }
        this.animatorSet.playTogether(this.animatorList);
    }

    public final void bind(@NotNull MatchingFloatView.Mode mode) {
        int parseColor;
        Intrinsics.checkNotNullParameter(mode, Constants.KEY_MODE);
        if (mode == MatchingFloatView.Mode.NORMAL) {
            parseColor = Color.parseColor("#ffca22");
        } else {
            parseColor = Color.parseColor("#13c66c");
        }
        this.rippleColor = parseColor;
        Iterator<RippleView> it = this.rippleViewList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RippleView next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            RippleView rippleView = next;
            rippleView.setVisibility(0);
            this.paint.setColor(this.rippleColor);
            rippleView.invalidate();
        }
    }

    public final int getRippleColor() {
        return this.rippleColor;
    }

    /* renamed from: isRippleAnimationRunning, reason: from getter */
    public final boolean getIsRippleAnimationRunning() {
        return this.isRippleAnimationRunning;
    }

    public final void setRippleColor(int i) {
        this.rippleColor = i;
    }

    public final void start() {
        if (!this.isRippleAnimationRunning) {
            this.animatorSet.end();
            Iterator<RippleView> it = this.rippleViewList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                RippleView next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                next.setVisibility(0);
            }
            this.animatorSet.start();
            this.isRippleAnimationRunning = true;
        }
    }

    public final void stop() {
        if (this.isRippleAnimationRunning) {
            this.animatorSet.end();
            this.isRippleAnimationRunning = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RippleBackground(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.paint = paint;
        this.animatorSet = new AnimatorSet();
        this.animatorList = new ArrayList<>();
        this.rippleViewList = new ArrayList<>();
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RippleBackground(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.paint = paint;
        this.animatorSet = new AnimatorSet();
        this.animatorList = new ArrayList<>();
        this.rippleViewList = new ArrayList<>();
        init(context, attributeSet);
    }
}
