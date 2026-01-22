package com.qiahao.nextvideo.utilities;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007J\u001e\u0010\t\u001a\u00020\u0005*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007J\u001e\u0010\n\u001a\u00020\u0005*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007J\u0012\u0010\t\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ \u0010\r\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\n\u0010\u0011\u001a\u00020\u0010*\u00020\u0005J\n\u0010\u0012\u001a\u00020\u0010*\u00020\u0005J@\u0010\u0013\u001a\u00020\u0005*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ@\u0010\u001f\u001a\u00020\b*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/utilities/AnimationHelper;", "", "<init>", "()V", "with", "Lcom/qiahao/nextvideo/utilities/AnimatorViewSet;", "method", "Lkotlin/Function1;", "Landroid/animation/ObjectAnimator;", "after", "before", "delay", "", "delayMillis", "timeMillis", "Lkotlin/Function0;", "", "start", "stop", "startMyAnimator", "Landroid/view/View;", "type", "Lcom/qiahao/nextvideo/utilities/AnimatorType;", "from", "", "to", "duration", "repeatCount", "", "interpolator", "Landroid/view/animation/Interpolator;", "startObjectAnimator", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AnimationHelper {

    @NotNull
    public static final AnimationHelper INSTANCE = new AnimationHelper();

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnimatorType.values().length];
            try {
                iArr[AnimatorType.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnimatorType.ScaleX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnimatorType.ScaleY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnimatorType.TranslationX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnimatorType.TranslationY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnimatorType.Rotation.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AnimatorType.RotationY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AnimationHelper() {
    }

    public static /* synthetic */ AnimatorViewSet startMyAnimator$default(AnimationHelper animationHelper, View view, AnimatorType animatorType, float f, float f2, long j, int i, Interpolator interpolator, int i2, Object obj) {
        int i3;
        Interpolator interpolator2;
        if ((i2 & 16) != 0) {
            i3 = 1;
        } else {
            i3 = i;
        }
        if ((i2 & 32) != 0) {
            interpolator2 = null;
        } else {
            interpolator2 = interpolator;
        }
        return animationHelper.startMyAnimator(view, animatorType, f, f2, j, i3, interpolator2);
    }

    public static /* synthetic */ ObjectAnimator startObjectAnimator$default(AnimationHelper animationHelper, AnimatorViewSet animatorViewSet, AnimatorType animatorType, float f, float f2, long j, int i, Interpolator interpolator, int i2, Object obj) {
        int i3;
        Interpolator interpolator2;
        if ((i2 & 16) != 0) {
            i3 = 1;
        } else {
            i3 = i;
        }
        if ((i2 & 32) != 0) {
            interpolator2 = null;
        } else {
            interpolator2 = interpolator;
        }
        return animationHelper.startObjectAnimator(animatorViewSet, animatorType, f, f2, j, i3, interpolator2);
    }

    @NotNull
    public final AnimatorViewSet after(@NotNull AnimatorViewSet animatorViewSet, @NotNull Function1<? super AnimatorViewSet, ObjectAnimator> function1) {
        Intrinsics.checkNotNullParameter(animatorViewSet, "<this>");
        Intrinsics.checkNotNullParameter(function1, "method");
        AnimatorSet.Builder animatorSetBuilder = animatorViewSet.getAnimatorSetBuilder();
        if (animatorSetBuilder != null) {
            animatorSetBuilder.after((Animator) function1.invoke(animatorViewSet));
        }
        return animatorViewSet;
    }

    @NotNull
    public final AnimatorViewSet before(@NotNull AnimatorViewSet animatorViewSet, @NotNull Function1<? super AnimatorViewSet, ObjectAnimator> function1) {
        Intrinsics.checkNotNullParameter(animatorViewSet, "<this>");
        Intrinsics.checkNotNullParameter(function1, "method");
        AnimatorSet.Builder animatorSetBuilder = animatorViewSet.getAnimatorSetBuilder();
        if (animatorSetBuilder != null) {
            animatorSetBuilder.before((Animator) function1.invoke(animatorViewSet));
        }
        return animatorViewSet;
    }

    @NotNull
    public final AnimatorViewSet delayMillis(@NotNull AnimatorViewSet animatorViewSet, long j, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(animatorViewSet, "<this>");
        Intrinsics.checkNotNullParameter(function0, "method");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new AnimationHelper$delayMillis$1(function0, j, null), 2, (Object) null);
        return animatorViewSet;
    }

    public final void start(@NotNull AnimatorViewSet animatorViewSet) {
        Intrinsics.checkNotNullParameter(animatorViewSet, "<this>");
        animatorViewSet.getAnimatorSet().start();
    }

    @NotNull
    public final AnimatorViewSet startMyAnimator(@NotNull View view, @NotNull AnimatorType animatorType, float f, float f2, long j, int i, @Nullable Interpolator interpolator) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(animatorType, "type");
        AnimatorViewSet animatorViewSet = new AnimatorViewSet(new AnimatorSet(), view, null, 4, null);
        animatorViewSet.setAnimatorSetBuilder(animatorViewSet.getAnimatorSet().play(startObjectAnimator(animatorViewSet, animatorType, f, f2, j, i, interpolator)));
        return animatorViewSet;
    }

    @NotNull
    public final ObjectAnimator startObjectAnimator(@NotNull AnimatorViewSet animatorViewSet, @NotNull AnimatorType animatorType, float f, float f2, long j, int i, @Nullable Interpolator interpolator) {
        ObjectAnimator ofFloat;
        Intrinsics.checkNotNullParameter(animatorViewSet, "<this>");
        Intrinsics.checkNotNullParameter(animatorType, "type");
        switch (WhenMappings.$EnumSwitchMapping$0[animatorType.ordinal()]) {
            case 1:
                ofFloat = ObjectAnimator.ofFloat(animatorViewSet.getView(), "alpha", f, f2);
                break;
            case 2:
                ofFloat = ObjectAnimator.ofFloat(animatorViewSet.getView(), AnimationUtilitiesKt.propertyNameInScaleX, f, f2);
                break;
            case 3:
                ofFloat = ObjectAnimator.ofFloat(animatorViewSet.getView(), AnimationUtilitiesKt.propertyNameInScaleY, f, f2);
                break;
            case 4:
                ofFloat = ObjectAnimator.ofFloat(animatorViewSet.getView(), AnimationUtilitiesKt.propertyNameInTranslationX, f, f2);
                break;
            case 5:
                ofFloat = ObjectAnimator.ofFloat(animatorViewSet.getView(), "translationY", f, f2);
                break;
            case 6:
                ofFloat = ObjectAnimator.ofFloat(animatorViewSet.getView(), "rotation", f, f2);
                break;
            case 7:
                ofFloat = ObjectAnimator.ofFloat(animatorViewSet.getView(), "rotationY", f, f2);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (i > 1) {
            ofFloat.setRepeatCount(i);
        }
        if (interpolator != null) {
            ofFloat.setInterpolator(interpolator);
        } else {
            ofFloat.setInterpolator(new LinearInterpolator());
        }
        ofFloat.setDuration(j);
        Intrinsics.checkNotNull(ofFloat);
        return ofFloat;
    }

    public final void stop(@NotNull AnimatorViewSet animatorViewSet) {
        Intrinsics.checkNotNullParameter(animatorViewSet, "<this>");
        animatorViewSet.getAnimatorSet().pause();
    }

    @NotNull
    public final AnimatorViewSet with(@NotNull AnimatorViewSet animatorViewSet, @NotNull Function1<? super AnimatorViewSet, ObjectAnimator> function1) {
        Intrinsics.checkNotNullParameter(animatorViewSet, "<this>");
        Intrinsics.checkNotNullParameter(function1, "method");
        AnimatorSet.Builder animatorSetBuilder = animatorViewSet.getAnimatorSetBuilder();
        if (animatorSetBuilder != null) {
            animatorSetBuilder.with((Animator) function1.invoke(animatorViewSet));
        }
        return animatorViewSet;
    }

    @NotNull
    public final AnimatorViewSet after(@NotNull AnimatorViewSet animatorViewSet, long j) {
        Intrinsics.checkNotNullParameter(animatorViewSet, "<this>");
        AnimatorSet.Builder animatorSetBuilder = animatorViewSet.getAnimatorSetBuilder();
        if (animatorSetBuilder != null) {
            animatorSetBuilder.after(j);
        }
        return animatorViewSet;
    }
}
