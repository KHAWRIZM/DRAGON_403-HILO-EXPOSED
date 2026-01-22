package com.qiahao.nextvideo.ui.foodie;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.qiahao.nextvideo.utilities.AnimationHelper;
import com.qiahao.nextvideo.utilities.AnimatorType;
import com.qiahao.nextvideo.utilities.AnimatorViewSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieAnimHelper;", "", "<init>", "()V", "playSelectAnim", "", "view", "Landroid/view/View;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieAnimHelper {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ObjectAnimator playSelectAnim$lambda$0(AnimatorViewSet animatorViewSet) {
        Intrinsics.checkNotNullParameter(animatorViewSet, "it");
        return AnimationHelper.INSTANCE.startObjectAnimator(animatorViewSet, AnimatorType.ScaleY, 1.0f, 1.2f, 200L, 1, new AccelerateDecelerateInterpolator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playSelectAnim$lambda$2(View view) {
        AnimationHelper animationHelper = AnimationHelper.INSTANCE;
        animationHelper.start(animationHelper.with(animationHelper.startMyAnimator(view, AnimatorType.ScaleX, 1.2f, 1.0f, 200L, 1, new AccelerateDecelerateInterpolator()), new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.c
            public final Object invoke(Object obj) {
                ObjectAnimator playSelectAnim$lambda$2$lambda$1;
                playSelectAnim$lambda$2$lambda$1 = FoodieAnimHelper.playSelectAnim$lambda$2$lambda$1((AnimatorViewSet) obj);
                return playSelectAnim$lambda$2$lambda$1;
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObjectAnimator playSelectAnim$lambda$2$lambda$1(AnimatorViewSet animatorViewSet) {
        Intrinsics.checkNotNullParameter(animatorViewSet, "it");
        return AnimationHelper.INSTANCE.startObjectAnimator(animatorViewSet, AnimatorType.ScaleY, 1.2f, 1.0f, 200L, 1, new AccelerateDecelerateInterpolator());
    }

    public final void playSelectAnim(@NotNull final View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AnimationHelper animationHelper = AnimationHelper.INSTANCE;
        animationHelper.start(animationHelper.delayMillis(animationHelper.with(animationHelper.startMyAnimator(view, AnimatorType.ScaleX, 1.0f, 1.2f, 200L, 1, new AccelerateDecelerateInterpolator()), new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.a
            public final Object invoke(Object obj) {
                ObjectAnimator playSelectAnim$lambda$0;
                playSelectAnim$lambda$0 = FoodieAnimHelper.playSelectAnim$lambda$0((AnimatorViewSet) obj);
                return playSelectAnim$lambda$0;
            }
        }), 200L, new Function0() { // from class: com.qiahao.nextvideo.ui.foodie.b
            public final Object invoke() {
                Unit playSelectAnim$lambda$2;
                playSelectAnim$lambda$2 = FoodieAnimHelper.playSelectAnim$lambda$2(view);
                return playSelectAnim$lambda$2;
            }
        }));
    }
}
