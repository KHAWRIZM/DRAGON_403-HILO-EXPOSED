package com.qiahao.nextvideo.ui.paired.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import androidx.appcompat.widget.AppCompatButton;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/ui/paired/view/LaunchVideoCallButton;", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interruptLaunchVideoCallingButtonAnimationRunning", "", "scaleAnimation", "Landroid/view/animation/ScaleAnimation;", "getScaleAnimation", "()Landroid/view/animation/ScaleAnimation;", "scaleAnimation$delegate", "Lkotlin/Lazy;", "reverseScaleAnimation", "getReverseScaleAnimation", "reverseScaleAnimation$delegate", "startConnectionAnimation", "", "disableAnimation", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LaunchVideoCallButton extends AppCompatButton {
    private boolean interruptLaunchVideoCallingButtonAnimationRunning;

    /* renamed from: reverseScaleAnimation$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy reverseScaleAnimation;

    /* renamed from: scaleAnimation$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy scaleAnimation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LaunchVideoCallButton(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.interruptLaunchVideoCallingButtonAnimationRunning = true;
        this.scaleAnimation = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.paired.view.a
            public final Object invoke() {
                ScaleAnimation scaleAnimation_delegate$lambda$1;
                scaleAnimation_delegate$lambda$1 = LaunchVideoCallButton.scaleAnimation_delegate$lambda$1(LaunchVideoCallButton.this);
                return scaleAnimation_delegate$lambda$1;
            }
        });
        this.reverseScaleAnimation = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.paired.view.b
            public final Object invoke() {
                ScaleAnimation reverseScaleAnimation_delegate$lambda$3;
                reverseScaleAnimation_delegate$lambda$3 = LaunchVideoCallButton.reverseScaleAnimation_delegate$lambda$3(LaunchVideoCallButton.this);
                return reverseScaleAnimation_delegate$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScaleAnimation getReverseScaleAnimation() {
        return (ScaleAnimation) this.reverseScaleAnimation.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScaleAnimation getScaleAnimation() {
        return (ScaleAnimation) this.scaleAnimation.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScaleAnimation reverseScaleAnimation_delegate$lambda$3(final LaunchVideoCallButton launchVideoCallButton) {
        final ScaleAnimation scaleAnimation = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setAnimationListener(new AnimationListener() { // from class: com.qiahao.nextvideo.ui.paired.view.LaunchVideoCallButton$reverseScaleAnimation$2$1$1
            /* JADX WARN: Type inference failed for: r2v5, types: [android.view.View, com.qiahao.nextvideo.ui.paired.view.LaunchVideoCallButton] */
            @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                ScaleAnimation scaleAnimation2;
                Intrinsics.checkNotNullParameter(animation, "animation");
                z = LaunchVideoCallButton.this.interruptLaunchVideoCallingButtonAnimationRunning;
                if (z) {
                    ?? r2 = LaunchVideoCallButton.this;
                    scaleAnimation2 = r2.getScaleAnimation();
                    r2.startAnimation(scaleAnimation2);
                } else {
                    scaleAnimation.cancel();
                    LaunchVideoCallButton.this.setVisibility(8);
                }
            }
        });
        return scaleAnimation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScaleAnimation scaleAnimation_delegate$lambda$1(final LaunchVideoCallButton launchVideoCallButton) {
        final ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setAnimationListener(new AnimationListener() { // from class: com.qiahao.nextvideo.ui.paired.view.LaunchVideoCallButton$scaleAnimation$2$1$1
            /* JADX WARN: Type inference failed for: r2v5, types: [android.view.View, com.qiahao.nextvideo.ui.paired.view.LaunchVideoCallButton] */
            @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                ScaleAnimation reverseScaleAnimation;
                Intrinsics.checkNotNullParameter(animation, "animation");
                z = LaunchVideoCallButton.this.interruptLaunchVideoCallingButtonAnimationRunning;
                if (z) {
                    ?? r2 = LaunchVideoCallButton.this;
                    reverseScaleAnimation = r2.getReverseScaleAnimation();
                    r2.startAnimation(reverseScaleAnimation);
                } else {
                    scaleAnimation.cancel();
                    LaunchVideoCallButton.this.setVisibility(8);
                }
            }
        });
        return scaleAnimation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void disableAnimation() {
        this.interruptLaunchVideoCallingButtonAnimationRunning = false;
        setVisibility(8);
        clearAnimation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void startConnectionAnimation() {
        clearAnimation();
        setVisibility(0);
        startAnimation(getScaleAnimation());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LaunchVideoCallButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.interruptLaunchVideoCallingButtonAnimationRunning = true;
        this.scaleAnimation = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.paired.view.a
            public final Object invoke() {
                ScaleAnimation scaleAnimation_delegate$lambda$1;
                scaleAnimation_delegate$lambda$1 = LaunchVideoCallButton.scaleAnimation_delegate$lambda$1(LaunchVideoCallButton.this);
                return scaleAnimation_delegate$lambda$1;
            }
        });
        this.reverseScaleAnimation = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.paired.view.b
            public final Object invoke() {
                ScaleAnimation reverseScaleAnimation_delegate$lambda$3;
                reverseScaleAnimation_delegate$lambda$3 = LaunchVideoCallButton.reverseScaleAnimation_delegate$lambda$3(LaunchVideoCallButton.this);
                return reverseScaleAnimation_delegate$lambda$3;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LaunchVideoCallButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.interruptLaunchVideoCallingButtonAnimationRunning = true;
        this.scaleAnimation = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.paired.view.a
            public final Object invoke() {
                ScaleAnimation scaleAnimation_delegate$lambda$1;
                scaleAnimation_delegate$lambda$1 = LaunchVideoCallButton.scaleAnimation_delegate$lambda$1(LaunchVideoCallButton.this);
                return scaleAnimation_delegate$lambda$1;
            }
        });
        this.reverseScaleAnimation = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.paired.view.b
            public final Object invoke() {
                ScaleAnimation reverseScaleAnimation_delegate$lambda$3;
                reverseScaleAnimation_delegate$lambda$3 = LaunchVideoCallButton.reverseScaleAnimation_delegate$lambda$3(LaunchVideoCallButton.this);
                return reverseScaleAnimation_delegate$lambda$3;
            }
        });
    }
}
