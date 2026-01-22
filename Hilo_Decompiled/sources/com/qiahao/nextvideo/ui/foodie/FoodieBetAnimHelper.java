package com.qiahao.nextvideo.ui.foodie;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.utilities.AnimationHelper;
import com.qiahao.nextvideo.utilities.AnimatorType;
import com.qiahao.nextvideo.utilities.AnimatorViewSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieBetAnimHelper;", "", "dialog", "Lcom/qiahao/nextvideo/ui/foodie/FoodieGameDialog;", "<init>", "(Lcom/qiahao/nextvideo/ui/foodie/FoodieGameDialog;)V", "mRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMRootView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "mRootView$delegate", "Lkotlin/Lazy;", "startTranslateAnim", "", "fromView", "Landroid/view/View;", "toView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFoodieBetAnimHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FoodieBetAnimHelper.kt\ncom/qiahao/nextvideo/ui/foodie/FoodieBetAnimHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,72:1\n1#2:73\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieBetAnimHelper {

    @NotNull
    private final FoodieGameDialog dialog;

    /* renamed from: mRootView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRootView;

    public FoodieBetAnimHelper(@NotNull FoodieGameDialog foodieGameDialog) {
        Intrinsics.checkNotNullParameter(foodieGameDialog, "dialog");
        this.dialog = foodieGameDialog;
        this.mRootView = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.foodie.f
            public final Object invoke() {
                ConstraintLayout mRootView_delegate$lambda$0;
                mRootView_delegate$lambda$0 = FoodieBetAnimHelper.mRootView_delegate$lambda$0(FoodieBetAnimHelper.this);
                return mRootView_delegate$lambda$0;
            }
        });
    }

    private final ConstraintLayout getMRootView() {
        return (ConstraintLayout) this.mRootView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstraintLayout mRootView_delegate$lambda$0(FoodieBetAnimHelper foodieBetAnimHelper) {
        return foodieBetAnimHelper.dialog.findViewById(2131362433);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObjectAnimator startTranslateAnim$lambda$2(ImageView imageView, Ref.FloatRef floatRef, AnimatorViewSet animatorViewSet) {
        Intrinsics.checkNotNullParameter(animatorViewSet, "it");
        return AnimationHelper.startObjectAnimator$default(AnimationHelper.INSTANCE, animatorViewSet, AnimatorType.TranslationY, imageView.getY(), floatRef.element, 400L, 0, null, 48, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startTranslateAnim$lambda$3(FoodieBetAnimHelper foodieBetAnimHelper, ImageView imageView) {
        ConstraintLayout mRootView = foodieBetAnimHelper.getMRootView();
        if (mRootView != null) {
            mRootView.removeView(imageView);
        }
        return Unit.INSTANCE;
    }

    public final void startTranslateAnim(@NotNull View fromView, @NotNull View toView) {
        float f;
        Drawable drawable;
        float width;
        Intrinsics.checkNotNullParameter(fromView, "fromView");
        Intrinsics.checkNotNullParameter(toView, "toView");
        int[] iArr = new int[2];
        fromView.getLocationInWindow(iArr);
        int i = iArr[0];
        float f2 = iArr[1];
        ConstraintLayout mRootView = getMRootView();
        float f3 = 0.0f;
        if (mRootView != null) {
            f = mRootView.getY();
        } else {
            f = 0.0f;
        }
        float f4 = f2 - f;
        int[] iArr2 = new int[2];
        toView.getLocationInWindow(iArr2);
        int i2 = iArr2[0];
        float height = iArr2[1] + (toView.getHeight() / 2.0f);
        ConstraintLayout mRootView2 = getMRootView();
        if (mRootView2 != null) {
            f3 = mRootView2.getY();
        }
        float f5 = height - f3;
        final ImageView imageView = new ImageView(this.dialog.getContext());
        Context context = this.dialog.getContext();
        if (context != null) {
            drawable = androidx.core.content.a.getDrawable(context, R.drawable.bill_diamond);
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
        ConstraintLayout mRootView3 = getMRootView();
        if (mRootView3 != null) {
            mRootView3.addView(imageView);
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).width = UiKtxKt.getDp(26);
        ((ViewGroup.MarginLayoutParams) bVar).height = UiKtxKt.getDp(22);
        imageView.setLayoutParams(bVar);
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        ConstraintLayout mRootView4 = getMRootView();
        if (mRootView4 != null && mRootView4.getLayoutDirection() == 0) {
            imageView.setX(i);
            imageView.setY(f4);
            width = (i2 + (toView.getWidth() / 2.0f)) - UiKtxKt.getDp(12);
            floatRef.element = f5;
        } else {
            imageView.setX(i);
            imageView.setY(f4);
            width = (i2 + (toView.getWidth() / 2.0f)) - UiKtxKt.getDp(12);
            floatRef.element = f5;
        }
        float f6 = width;
        AnimationHelper animationHelper = AnimationHelper.INSTANCE;
        animationHelper.start(animationHelper.delayMillis(animationHelper.with(AnimationHelper.startMyAnimator$default(animationHelper, imageView, AnimatorType.TranslationX, imageView.getX(), f6, 400L, 0, null, 48, null), new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.d
            public final Object invoke(Object obj) {
                ObjectAnimator startTranslateAnim$lambda$2;
                startTranslateAnim$lambda$2 = FoodieBetAnimHelper.startTranslateAnim$lambda$2(imageView, floatRef, (AnimatorViewSet) obj);
                return startTranslateAnim$lambda$2;
            }
        }), 400L, new Function0() { // from class: com.qiahao.nextvideo.ui.foodie.e
            public final Object invoke() {
                Unit startTranslateAnim$lambda$3;
                startTranslateAnim$lambda$3 = FoodieBetAnimHelper.startTranslateAnim$lambda$3(FoodieBetAnimHelper.this, imageView);
                return startTranslateAnim$lambda$3;
            }
        }));
    }
}
