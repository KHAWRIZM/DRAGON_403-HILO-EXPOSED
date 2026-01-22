package com.qiahao.base_common.wedgit.shineText;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.wedgit.shineText.CenterGlowBreathingTextView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002IJB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u00100\u001a\u00020*J\u000e\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020$J\u000e\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\u0007J\u0006\u00105\u001a\u00020*J\u000e\u00106\u001a\u00020*2\u0006\u00107\u001a\u00020\rJ\u000e\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020\u0016J\u000e\u0010:\u001a\u00020*2\u0006\u00109\u001a\u00020\u0016J\u0006\u0010;\u001a\u00020\rJ\b\u0010<\u001a\u00020*H\u0002J\b\u0010=\u001a\u00020*H\u0002J(\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007H\u0014J\b\u0010C\u001a\u00020*H\u0002J\b\u0010D\u001a\u00020*H\u0014J\b\u0010E\u001a\u00020*H\u0014J\u0010\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020HH\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010%\u001a\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/qiahao/base_common/wedgit/shineText/CenterGlowBreathingTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "phase", "Lcom/qiahao/base_common/wedgit/shineText/CenterGlowBreathingTextView$Phase;", "animMode", "Lcom/qiahao/base_common/wedgit/shineText/CenterGlowBreathingTextView$AnimMode;", "defaultTextColor", "flowOffset", "", "glowOffset", "flowAnimator", "Landroid/animation/ValueAnimator;", "glowAnimator", "flowAnimDuration", "", "glowAnimDuration", "glowRepeatCount", "isAnimStarted", "", "cachedBgShader", "Landroid/graphics/LinearGradient;", "cachedGlowShader", "Landroid/graphics/RadialGradient;", "cachedComposeShader", "Landroid/graphics/ComposeShader;", "flowMatrix", "Landroid/graphics/Matrix;", "bgColors", "", "mAnimationListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isStart", "", "getMAnimationListener", "()Lkotlin/jvm/functions/Function1;", "setMAnimationListener", "(Lkotlin/jvm/functions/Function1;)V", "glowStopColors", "startAnim", "setBgColors", "colors", "setDefaultColor", "color", "cleanAnim", "setAnimMode", "mode", "setFlowSpeed", "ms", "setGlowSpeed", "getAnimMode", "ensureBgShader", "ensureGlowShaders", "onSizeChanged", "w", "h", "oldw", "oldh", "ensureAnimators", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "AnimMode", "Phase", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCenterGlowBreathingTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CenterGlowBreathingTextView.kt\ncom/qiahao/base_common/wedgit/shineText/CenterGlowBreathingTextView\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,376:1\n439#2:377\n439#2:378\n439#2:379\n*S KotlinDebug\n*F\n+ 1 CenterGlowBreathingTextView.kt\ncom/qiahao/base_common/wedgit/shineText/CenterGlowBreathingTextView\n*L\n62#1:377\n63#1:378\n64#1:379\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CenterGlowBreathingTextView extends AppCompatTextView {

    @NotNull
    private AnimMode animMode;

    @Nullable
    private int[] bgColors;

    @Nullable
    private LinearGradient cachedBgShader;

    @Nullable
    private ComposeShader cachedComposeShader;

    @Nullable
    private RadialGradient cachedGlowShader;
    private int defaultTextColor;
    private long flowAnimDuration;

    @Nullable
    private ValueAnimator flowAnimator;

    @NotNull
    private final Matrix flowMatrix;
    private float flowOffset;
    private long glowAnimDuration;

    @Nullable
    private ValueAnimator glowAnimator;
    private float glowOffset;
    private final int glowRepeatCount;

    @NotNull
    private final int[] glowStopColors;
    private boolean isAnimStarted;

    @Nullable
    private Function1<? super Boolean, Unit> mAnimationListener;

    @NotNull
    private Phase phase;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/base_common/wedgit/shineText/CenterGlowBreathingTextView$AnimMode;", "", "<init>", "(Ljava/lang/String;I)V", "FLOW_ONLY", "GLOW_AND_FLOW", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class AnimMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AnimMode[] $VALUES;
        public static final AnimMode FLOW_ONLY = new AnimMode("FLOW_ONLY", 0);
        public static final AnimMode GLOW_AND_FLOW = new AnimMode("GLOW_AND_FLOW", 1);

        private static final /* synthetic */ AnimMode[] $values() {
            return new AnimMode[]{FLOW_ONLY, GLOW_AND_FLOW};
        }

        static {
            AnimMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private AnimMode(String str, int i10) {
        }

        @NotNull
        public static EnumEntries<AnimMode> getEntries() {
            return $ENTRIES;
        }

        public static AnimMode valueOf(String str) {
            return (AnimMode) Enum.valueOf(AnimMode.class, str);
        }

        public static AnimMode[] values() {
            return (AnimMode[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/base_common/wedgit/shineText/CenterGlowBreathingTextView$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "FLOW", "GLOW", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Phase {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Phase[] $VALUES;
        public static final Phase FLOW = new Phase("FLOW", 0);
        public static final Phase GLOW = new Phase("GLOW", 1);

        private static final /* synthetic */ Phase[] $values() {
            return new Phase[]{FLOW, GLOW};
        }

        static {
            Phase[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Phase(String str, int i10) {
        }

        @NotNull
        public static EnumEntries<Phase> getEntries() {
            return $ENTRIES;
        }

        public static Phase valueOf(String str) {
            return (Phase) Enum.valueOf(Phase.class, str);
        }

        public static Phase[] values() {
            return (Phase[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Phase.values().length];
            try {
                iArr[Phase.FLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Phase.GLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CenterGlowBreathingTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void ensureAnimators() {
        int[] iArr;
        boolean z10;
        ValueAnimator valueAnimator;
        long j10;
        int i10;
        if (getWidth() > 0 && (iArr = this.bgColors) != null) {
            if (iArr.length == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                ValueAnimator valueAnimator2 = this.flowAnimator;
                if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                    return;
                }
                ValueAnimator valueAnimator3 = this.glowAnimator;
                if (valueAnimator3 != null && valueAnimator3.isRunning()) {
                    return;
                }
                ensureBgShader();
                ensureGlowShaders();
                if (this.flowAnimator == null) {
                    final ValueAnimator ofFloat = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
                    if (this.animMode == AnimMode.GLOW_AND_FLOW) {
                        j10 = this.flowAnimDuration;
                    } else {
                        j10 = this.glowAnimDuration * 2;
                    }
                    ofFloat.setDuration(j10);
                    ofFloat.setInterpolator(new LinearInterpolator());
                    if (this.animMode == AnimMode.FLOW_ONLY) {
                        i10 = -1;
                    } else {
                        i10 = 2;
                    }
                    ofFloat.setRepeatCount(i10);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qiahao.base_common.wedgit.shineText.a
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                            CenterGlowBreathingTextView.ensureAnimators$lambda$1$lambda$0(CenterGlowBreathingTextView.this, ofFloat, valueAnimator4);
                        }
                    });
                    ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.qiahao.base_common.wedgit.shineText.CenterGlowBreathingTextView$ensureAnimators$1$2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            CenterGlowBreathingTextView.this.isAnimStarted = false;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            CenterGlowBreathingTextView.AnimMode animMode;
                            boolean z11;
                            ValueAnimator valueAnimator4;
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            animMode = CenterGlowBreathingTextView.this.animMode;
                            if (animMode == CenterGlowBreathingTextView.AnimMode.GLOW_AND_FLOW) {
                                z11 = CenterGlowBreathingTextView.this.isAnimStarted;
                                if (z11) {
                                    Function1<Boolean, Unit> mAnimationListener = CenterGlowBreathingTextView.this.getMAnimationListener();
                                    if (mAnimationListener != null) {
                                        mAnimationListener.invoke(Boolean.FALSE);
                                    }
                                    CenterGlowBreathingTextView.this.phase = CenterGlowBreathingTextView.Phase.GLOW;
                                    valueAnimator4 = CenterGlowBreathingTextView.this.glowAnimator;
                                    if (valueAnimator4 != null) {
                                        valueAnimator4.start();
                                    }
                                }
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            CenterGlowBreathingTextView.this.phase = CenterGlowBreathingTextView.Phase.FLOW;
                        }
                    });
                    this.flowAnimator = ofFloat;
                }
                AnimMode animMode = this.animMode;
                AnimMode animMode2 = AnimMode.GLOW_AND_FLOW;
                if (animMode == animMode2 && this.glowAnimator == null) {
                    final ValueAnimator ofFloat2 = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
                    ofFloat2.setDuration(this.glowAnimDuration);
                    ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                    ofFloat2.setRepeatCount(this.glowRepeatCount);
                    ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qiahao.base_common.wedgit.shineText.b
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                            CenterGlowBreathingTextView.ensureAnimators$lambda$3$lambda$2(CenterGlowBreathingTextView.this, ofFloat2, valueAnimator4);
                        }
                    });
                    ofFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.qiahao.base_common.wedgit.shineText.CenterGlowBreathingTextView$ensureAnimators$2$2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            boolean z11;
                            ValueAnimator valueAnimator4;
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            z11 = CenterGlowBreathingTextView.this.isAnimStarted;
                            if (z11) {
                                CenterGlowBreathingTextView.this.glowOffset = DownloadProgress.UNKNOWN_PROGRESS;
                                CenterGlowBreathingTextView.this.phase = CenterGlowBreathingTextView.Phase.FLOW;
                                Function1<Boolean, Unit> mAnimationListener = CenterGlowBreathingTextView.this.getMAnimationListener();
                                if (mAnimationListener != null) {
                                    mAnimationListener.invoke(Boolean.TRUE);
                                }
                                valueAnimator4 = CenterGlowBreathingTextView.this.flowAnimator;
                                if (valueAnimator4 != null) {
                                    valueAnimator4.start();
                                }
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            CenterGlowBreathingTextView.this.phase = CenterGlowBreathingTextView.Phase.GLOW;
                        }
                    });
                    this.glowAnimator = ofFloat2;
                }
                if (isAttachedToWindow() && getWidth() > 0 && this.isAnimStarted) {
                    if (this.animMode == animMode2) {
                        ValueAnimator valueAnimator4 = this.flowAnimator;
                        if ((valueAnimator4 == null || !valueAnimator4.isRunning()) && (valueAnimator = this.glowAnimator) != null) {
                            valueAnimator.start();
                            return;
                        }
                        return;
                    }
                    ValueAnimator valueAnimator5 = this.flowAnimator;
                    if (valueAnimator5 != null) {
                        valueAnimator5.start();
                        return;
                    }
                    return;
                }
                return;
            }
        }
        ValueAnimator valueAnimator6 = this.flowAnimator;
        if (valueAnimator6 != null) {
            valueAnimator6.cancel();
        }
        ValueAnimator valueAnimator7 = this.glowAnimator;
        if (valueAnimator7 != null) {
            valueAnimator7.cancel();
        }
        getPaint().setShader(null);
        setTextColor(this.defaultTextColor);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ensureAnimators$lambda$1$lambda$0(CenterGlowBreathingTextView centerGlowBreathingTextView, ValueAnimator valueAnimator, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        centerGlowBreathingTextView.flowOffset = ((Float) animatedValue).floatValue();
        if (centerGlowBreathingTextView.animMode == AnimMode.FLOW_ONLY) {
            centerGlowBreathingTextView.phase = Phase.FLOW;
        }
        centerGlowBreathingTextView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ensureAnimators$lambda$3$lambda$2(CenterGlowBreathingTextView centerGlowBreathingTextView, ValueAnimator valueAnimator, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        centerGlowBreathingTextView.glowOffset = ((Float) animatedValue).floatValue();
        centerGlowBreathingTextView.invalidate();
    }

    private final void ensureBgShader() {
        int[] iArr;
        boolean z10;
        int[] iArr2;
        if (this.cachedBgShader == null && getWidth() > 0 && (iArr = this.bgColors) != null) {
            if (iArr.length == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                float width = getWidth();
                int[] iArr3 = this.bgColors;
                if (iArr3 == null) {
                    iArr2 = new int[0];
                } else {
                    iArr2 = iArr3;
                }
                this.cachedBgShader = new LinearGradient(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, width, DownloadProgress.UNKNOWN_PROGRESS, iArr2, (float[]) null, Shader.TileMode.REPEAT);
            }
        }
    }

    private final void ensureGlowShaders() {
        if (this.animMode == AnimMode.GLOW_AND_FLOW && getWidth() > 0 && getHeight() > 0) {
            float width = getWidth();
            float height = getHeight();
            LinearGradient linearGradient = this.cachedBgShader;
            if (linearGradient == null) {
                return;
            }
            if (this.cachedGlowShader == null) {
                this.cachedGlowShader = new RadialGradient(width / 2.0f, height / 2.0f, 1.0f, this.glowStopColors, (float[]) null, Shader.TileMode.CLAMP);
            }
            if (this.cachedComposeShader == null && this.cachedGlowShader != null) {
                RadialGradient radialGradient = this.cachedGlowShader;
                Intrinsics.checkNotNull(radialGradient);
                this.cachedComposeShader = new ComposeShader(linearGradient, radialGradient, PorterDuff.Mode.ADD);
            }
        }
    }

    public final void cleanAnim() {
        this.isAnimStarted = false;
        this.animMode = AnimMode.FLOW_ONLY;
        this.bgColors = null;
        ValueAnimator valueAnimator = this.flowAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.glowAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        getPaint().setShader(null);
        setTextColor(this.defaultTextColor);
        invalidate();
    }

    @NotNull
    public final AnimMode getAnimMode() {
        return this.animMode;
    }

    @Nullable
    public final Function1<Boolean, Unit> getMAnimationListener() {
        return this.mAnimationListener;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isAnimStarted) {
            ensureAnimators();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAnimationListener = null;
        ValueAnimator valueAnimator = this.flowAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.glowAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(@NotNull Canvas canvas) {
        int[] iArr;
        boolean z10;
        float f10;
        RadialGradient radialGradient;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.isAnimStarted && (iArr = this.bgColors) != null) {
            if (iArr.length == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                int i10 = WhenMappings.$EnumSwitchMapping$0[this.phase.ordinal()];
                if (i10 != 1) {
                    if (i10 == 2) {
                        ComposeShader composeShader = this.cachedComposeShader;
                        if (composeShader == null || (radialGradient = this.cachedGlowShader) == null) {
                            return;
                        }
                        float width = getWidth();
                        float height = getHeight();
                        float coerceAtLeast = RangesKt.coerceAtLeast(this.glowOffset * (RangesKt.coerceAtLeast(getWidth(), getHeight()) / 2.0f) * 2, 1.0f);
                        this.flowMatrix.reset();
                        this.flowMatrix.setScale(coerceAtLeast, coerceAtLeast, width / 2.0f, height / 2.0f);
                        radialGradient.setLocalMatrix(this.flowMatrix);
                        getPaint().setShader(composeShader);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    if (this.cachedBgShader == null) {
                        ensureBgShader();
                    }
                    LinearGradient linearGradient = this.cachedBgShader;
                    if (linearGradient == null) {
                        return;
                    }
                    float width2 = getWidth();
                    if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                        f10 = (-width2) * this.flowOffset;
                    } else {
                        f10 = width2 * this.flowOffset;
                    }
                    this.flowMatrix.setTranslate(f10, DownloadProgress.UNKNOWN_PROGRESS);
                    linearGradient.setLocalMatrix(this.flowMatrix);
                    getPaint().setShader(linearGradient);
                }
                super.onDraw(canvas);
                return;
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        this.cachedBgShader = null;
        this.cachedGlowShader = null;
        this.cachedComposeShader = null;
        ensureBgShader();
        ensureGlowShaders();
        if (this.isAnimStarted) {
            ensureAnimators();
        }
    }

    public final void setAnimMode(@NotNull AnimMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (this.animMode != mode) {
            this.animMode = mode;
            this.cachedComposeShader = null;
            if (this.isAnimStarted) {
                ValueAnimator valueAnimator = this.flowAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                ValueAnimator valueAnimator2 = this.glowAnimator;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                }
                this.flowAnimator = null;
                this.glowAnimator = null;
                ensureAnimators();
                return;
            }
            this.flowAnimator = null;
            this.glowAnimator = null;
        }
    }

    public final void setBgColors(@NotNull int[] colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.bgColors = colors;
        this.cachedBgShader = null;
        if (this.isAnimStarted) {
            ensureAnimators();
        }
    }

    public final void setDefaultColor(int color) {
        setTextColor(color);
    }

    public final void setFlowSpeed(long ms) {
        this.flowAnimDuration = ms;
    }

    public final void setGlowSpeed(long ms) {
        this.glowAnimDuration = ms;
    }

    public final void setMAnimationListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.mAnimationListener = function1;
    }

    public final void startAnim() {
        int[] iArr;
        boolean z10;
        if (!this.isAnimStarted && getWidth() > 0 && (iArr = this.bgColors) != null) {
            if (iArr.length == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                this.isAnimStarted = true;
                setVisibility(0);
                ensureAnimators();
                return;
            }
        }
        if (this.isAnimStarted) {
            ensureAnimators();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CenterGlowBreathingTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CenterGlowBreathingTextView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CenterGlowBreathingTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.phase = Phase.GLOW;
        this.animMode = AnimMode.FLOW_ONLY;
        this.defaultTextColor = -1;
        this.flowAnimDuration = 1600L;
        this.glowAnimDuration = 500L;
        this.glowRepeatCount = 3;
        this.isAnimStarted = true;
        this.flowMatrix = new Matrix();
        this.glowStopColors = new int[]{0, Color.parseColor("#7ffffb00"), Color.parseColor("#ffff9300"), Color.parseColor("#7ffffb00"), 0};
        this.isAnimStarted = false;
        setLayerType(1, null);
    }
}
