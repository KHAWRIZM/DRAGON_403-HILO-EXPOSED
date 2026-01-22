package com.qiahao.nextvideo.ui.reusable.views;

import android.animation.Animator;
import android.widget.FrameLayout;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/qiahao/nextvideo/ui/reusable/views/GlobalTipSvga2$leaveAnimator$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GlobalTipSvga2$leaveAnimator$1$1 implements Animator.AnimatorListener {
    final /* synthetic */ GlobalTipSvga2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GlobalTipSvga2$leaveAnimator$1$1(GlobalTipSvga2 globalTipSvga2) {
        this.this$0 = globalTipSvga2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAnimationEnd$lambda$0(GlobalTipSvga2 globalTipSvga2) {
        boolean z;
        z = globalTipSvga2.isAnimation;
        if (!z) {
            globalTipSvga2.show();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.isAnimation = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        boolean isContextValid;
        Object obj;
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.isAnimation = false;
        isContextValid = this.this$0.isContextValid();
        if (isContextValid) {
            try {
                obj = this.this$0.mContext;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qiahao.nextvideo.app.base.HiloBaseActivity");
                FrameLayout container = ((HiloBaseActivity) obj).getContainer();
                if (container != null) {
                    container.removeView(this.this$0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.this$0.setShow(false);
            final GlobalTipSvga2 globalTipSvga2 = this.this$0;
            globalTipSvga2.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.reusable.views.h
                @Override // java.lang.Runnable
                public final void run() {
                    GlobalTipSvga2$leaveAnimator$1$1.onAnimationEnd$lambda$0(GlobalTipSvga2.this);
                }
            });
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.isAnimation = true;
    }
}
