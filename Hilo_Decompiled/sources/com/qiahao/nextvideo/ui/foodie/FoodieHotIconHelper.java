package com.qiahao.nextvideo.ui.foodie;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.utilities.AnimationHelper;
import com.qiahao.nextvideo.utilities.AnimatorType;
import com.qiahao.nextvideo.view.youtube.FadeViewHelper;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u001d\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieHotIconHelper;", "", "Lcom/qiahao/nextvideo/ui/foodie/FoodieGameDialog;", "mActivity", "<init>", "(Lcom/qiahao/nextvideo/ui/foodie/FoodieGameDialog;)V", "Landroid/view/View;", "view", "", "playAnimInterval", "(Landroid/view/View;)V", "playAnim", "", "type", "anchorView", "locateOnScreen", "(ILandroid/view/View;)V", "removeHotView", "()V", TUIConstants.TUIBeauty.METHOD_DESTROY_XMAGIC, "Lcom/qiahao/nextvideo/ui/foodie/FoodieGameDialog;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mRootView$delegate", "Lkotlin/Lazy;", "getMRootView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "mRootView", "Lkotlin/Pair;", "Landroid/widget/ImageView;", "mHotViewPair", "Lkotlin/Pair;", "Lnd/c;", "mDisposable", "Lnd/c;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieHotIconHelper {

    @NotNull
    private final FoodieGameDialog mActivity;

    @Nullable
    private nd.c mDisposable;

    @Nullable
    private Pair<Integer, ? extends ImageView> mHotViewPair;

    /* renamed from: mRootView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRootView;

    public FoodieHotIconHelper(@NotNull FoodieGameDialog foodieGameDialog) {
        Intrinsics.checkNotNullParameter(foodieGameDialog, "mActivity");
        this.mActivity = foodieGameDialog;
        this.mRootView = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.foodie.n0
            public final Object invoke() {
                ConstraintLayout mRootView_delegate$lambda$0;
                mRootView_delegate$lambda$0 = FoodieHotIconHelper.mRootView_delegate$lambda$0(FoodieHotIconHelper.this);
                return mRootView_delegate$lambda$0;
            }
        });
    }

    private final ConstraintLayout getMRootView() {
        return (ConstraintLayout) this.mRootView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void locateOnScreen$lambda$1(FoodieHotIconHelper foodieHotIconHelper, int i, View view) {
        int i2;
        float f;
        Pair<Integer, ? extends ImageView> pair = foodieHotIconHelper.mHotViewPair;
        if (pair != null) {
            i2 = ((Number) pair.getFirst()).intValue();
        } else {
            i2 = 0;
        }
        if (i2 == i && foodieHotIconHelper.mHotViewPair != null) {
            return;
        }
        nd.c cVar = foodieHotIconHelper.mDisposable;
        if (cVar != null) {
            cVar.dispose();
        }
        foodieHotIconHelper.removeHotView();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        ImageView imageView = new ImageView(foodieHotIconHelper.mActivity.getContext());
        imageView.setImageDrawable(androidx.core.content.a.getDrawable(view.getContext(), R.drawable.ic_foodie_big_hot));
        ConstraintLayout mRootView = foodieHotIconHelper.getMRootView();
        if (mRootView != null) {
            mRootView.addView(imageView);
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).width = UiKtxKt.getDp(27);
        ((ViewGroup.MarginLayoutParams) bVar).height = UiKtxKt.getDp(20);
        imageView.setLayoutParams(bVar);
        imageView.setX((i3 + view.getWidth()) - UiKtxKt.getDp(16));
        float f2 = i4;
        ConstraintLayout mRootView2 = foodieHotIconHelper.getMRootView();
        if (mRootView2 != null) {
            f = mRootView2.getY();
        } else {
            f = 0.0f;
        }
        imageView.setY(f2 - f);
        foodieHotIconHelper.mHotViewPair = new Pair<>(Integer.valueOf(i), imageView);
        foodieHotIconHelper.playAnimInterval(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstraintLayout mRootView_delegate$lambda$0(FoodieHotIconHelper foodieHotIconHelper) {
        return foodieHotIconHelper.mActivity.findViewById(2131362433);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playAnim(final View view) {
        AnimationHelper animationHelper = AnimationHelper.INSTANCE;
        animationHelper.start(animationHelper.delayMillis(animationHelper.startMyAnimator(view, AnimatorType.Rotation, 0.0f, 20.0f, 100L, 1, new AccelerateDecelerateInterpolator()), 100L, new Function0() { // from class: com.qiahao.nextvideo.ui.foodie.q0
            public final Object invoke() {
                Unit playAnim$lambda$3;
                playAnim$lambda$3 = FoodieHotIconHelper.playAnim$lambda$3(view);
                return playAnim$lambda$3;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playAnim$lambda$3(final View view) {
        AnimationHelper animationHelper = AnimationHelper.INSTANCE;
        animationHelper.start(animationHelper.delayMillis(animationHelper.startMyAnimator(view, AnimatorType.Rotation, 20.0f, -20.0f, 200L, 1, new AccelerateDecelerateInterpolator()), 200L, new Function0() { // from class: com.qiahao.nextvideo.ui.foodie.o0
            public final Object invoke() {
                Unit playAnim$lambda$3$lambda$2;
                playAnim$lambda$3$lambda$2 = FoodieHotIconHelper.playAnim$lambda$3$lambda$2(view);
                return playAnim$lambda$3$lambda$2;
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playAnim$lambda$3$lambda$2(View view) {
        AnimationHelper animationHelper = AnimationHelper.INSTANCE;
        animationHelper.start(animationHelper.startMyAnimator(view, AnimatorType.Rotation, -20.0f, 0.0f, 100L, 1, new AccelerateDecelerateInterpolator()));
        return Unit.INSTANCE;
    }

    private final void playAnimInterval(final View view) {
        this.mDisposable = io.reactivex.rxjava3.core.z.interval(0L, FadeViewHelper.DEFAULT_FADE_OUT_DELAY, TimeUnit.MILLISECONDS).observeOn(md.b.c()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieHotIconHelper$playAnimInterval$1
            public final void accept(Long l) {
                Intrinsics.checkNotNullParameter(l, "it");
                FoodieHotIconHelper.this.playAnim(view);
            }
        });
    }

    public final void destroy() {
        nd.c cVar = this.mDisposable;
        if (cVar != null) {
            cVar.dispose();
        }
        this.mHotViewPair = null;
    }

    public final void locateOnScreen(final int type, @NotNull final View anchorView) {
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        anchorView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.foodie.p0
            @Override // java.lang.Runnable
            public final void run() {
                FoodieHotIconHelper.locateOnScreen$lambda$1(FoodieHotIconHelper.this, type, anchorView);
            }
        });
    }

    public final void removeHotView() {
        ImageView imageView;
        Pair<Integer, ? extends ImageView> pair = this.mHotViewPair;
        if (pair != null && (imageView = (ImageView) pair.getSecond()) != null) {
            ConstraintLayout mRootView = getMRootView();
            if (mRootView != null) {
                mRootView.removeView(imageView);
            }
            this.mHotViewPair = null;
        }
    }
}
