package com.qhqc.core.feature.community.ui.activity;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import com.qhqc.core.basic.ktx.DisplayKtxKt;
import com.qhqc.core.basic.uiframe.viewmodel.BaseViewModel;
import com.qhqc.core.basic.widget.DragLayout;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.databinding.FeatureCommunityActivityCommunityPhotoBinding;
import com.qhqc.core.feature.community.ui.adapter.PhotoViewPagerAdapter;
import com.qhqc.core.feature.uiframe.BaseModelActivity;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0014B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0017J\b\u0010\u0013\u001a\u00020\nH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/qhqc/core/feature/community/ui/activity/CommunityPhotoViewActivity;", "Lcom/qhqc/core/feature/uiframe/BaseModelActivity;", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityActivityCommunityPhotoBinding;", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "Lcom/qhqc/core/basic/widget/DragLayout$OnDragDistanceChangeListener;", "<init>", "()V", "animator", "Landroid/animation/ValueAnimator;", "onInit", "", "savedInstanceState", "Landroid/os/Bundle;", "onDistanceChange", "translationX", "", "translationY", "onFingerUp", "onBackPressed", "finish", "Companion", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CommunityPhotoViewActivity extends BaseModelActivity<FeatureCommunityActivityCommunityPhotoBinding, BaseViewModel> implements DragLayout.OnDragDistanceChangeListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private ValueAnimator animator;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/qhqc/core/feature/community/ui/activity/CommunityPhotoViewActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "images", "", "", "position", "", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, @NotNull List<String> images, int position) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(images, "images");
            Intent putStringArrayListExtra = new Intent(context, (Class<?>) CommunityPhotoViewActivity.class).putExtra("position", position).putStringArrayListExtra("images", new ArrayList<>(images));
            Intrinsics.checkNotNullExpressionValue(putStringArrayListExtra, "putStringArrayListExtra(...)");
            context.startActivity(putStringArrayListExtra);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onFingerUp$lambda$2(CommunityPhotoViewActivity communityPhotoViewActivity, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue("mAnimatorValue");
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        Object animatedValue2 = animation.getAnimatedValue("mAnimatorAlpha");
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue2).intValue();
        if (communityPhotoViewActivity.getBinding() != 0) {
            ((FeatureCommunityActivityCommunityPhotoBinding) communityPhotoViewActivity.getBinding()).mViewPager.setScaleX(floatValue);
            ((FeatureCommunityActivityCommunityPhotoBinding) communityPhotoViewActivity.getBinding()).mViewPager.setScaleY(floatValue);
        }
        ((FeatureCommunityActivityCommunityPhotoBinding) communityPhotoViewActivity.getBinding()).mViewDrag.getBackground().setAlpha(intValue);
        if (floatValue == DownloadProgress.UNKNOWN_PROGRESS) {
            communityPhotoViewActivity.finish();
            communityPhotoViewActivity.overridePendingTransition(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInit$lambda$1$lambda$0(CommunityPhotoViewActivity communityPhotoViewActivity) {
        communityPhotoViewActivity.finish();
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @NotNull List<String> list, int i10) {
        INSTANCE.start(context, list, i10);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.feature_community_window_close_anim_alpha);
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onBackPressed() {
        finishAfterTransition();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.widget.DragLayout.OnDragDistanceChangeListener
    public void onDistanceChange(int translationX, int translationY) {
        ((FeatureCommunityActivityCommunityPhotoBinding) getBinding()).mViewDrag.changeTranslationAndSize(translationX, translationY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.widget.DragLayout.OnDragDistanceChangeListener
    public void onFingerUp(int translationX, int translationY) {
        if (this.animator == null) {
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("mAnimatorValue", 1.0f, DownloadProgress.UNKNOWN_PROGRESS), PropertyValuesHolder.ofInt("mAnimatorAlpha", ((FeatureCommunityActivityCommunityPhotoBinding) getBinding()).mViewDrag.getMAlpha(), 0));
            this.animator = ofPropertyValuesHolder;
            if (ofPropertyValuesHolder != null) {
                ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            }
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.setDuration(300L);
            }
            ValueAnimator valueAnimator2 = this.animator;
            if (valueAnimator2 != null) {
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qhqc.core.feature.community.ui.activity.b
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        CommunityPhotoViewActivity.onFingerUp$lambda$2(CommunityPhotoViewActivity.this, valueAnimator3);
                    }
                });
            }
            ValueAnimator valueAnimator3 = this.animator;
            if (valueAnimator3 != null) {
                valueAnimator3.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    public void onInit(@Nullable Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        overridePendingTransition(R.anim.feature_community_window_enter_anim_alpha, 0);
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("images");
        if (stringArrayListExtra == null) {
            return;
        }
        int intExtra = getIntent().getIntExtra("position", 0);
        PhotoViewPagerAdapter photoViewPagerAdapter = new PhotoViewPagerAdapter();
        photoViewPagerAdapter.setImageClickListener(new Function0() { // from class: com.qhqc.core.feature.community.ui.activity.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onInit$lambda$1$lambda$0;
                onInit$lambda$1$lambda$0 = CommunityPhotoViewActivity.onInit$lambda$1$lambda$0(CommunityPhotoViewActivity.this);
                return onInit$lambda$1$lambda$0;
            }
        });
        ((FeatureCommunityActivityCommunityPhotoBinding) getBinding()).mViewPager.setAdapter(photoViewPagerAdapter);
        photoViewPagerAdapter.setList(stringArrayListExtra);
        ((FeatureCommunityActivityCommunityPhotoBinding) getBinding()).mViewPager.setCurrentItem(intExtra, false);
        ((FeatureCommunityActivityCommunityPhotoBinding) getBinding()).mViewDrag.setOnDragDistanceChangeListener(this);
        ((FeatureCommunityActivityCommunityPhotoBinding) getBinding()).mViewDrag.setMDismissSlop(DisplayKtxKt.getDp(75));
    }
}
