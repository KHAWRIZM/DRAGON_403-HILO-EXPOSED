package com.qhqc.core.feature.community.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.qhqc.core.feature.community.databinding.FeatureCommunityWidgetBtnFollowBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\rJ\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/qhqc/core/feature/community/widget/FollowBtnView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defAttrStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBinding", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityWidgetBtnFollowBinding;", "isFollow", "", "", "followUser", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFollowBtnView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FollowBtnView.kt\ncom/qhqc/core/feature/community/widget/FollowBtnView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,67:1\n256#2,2:68\n256#2,2:70\n256#2,2:72\n256#2,2:74\n256#2,2:76\n296#2:78\n256#2,2:79\n256#2,2:81\n*S KotlinDebug\n*F\n+ 1 FollowBtnView.kt\ncom/qhqc/core/feature/community/widget/FollowBtnView\n*L\n30#1:68,2\n31#1:70,2\n33#1:72,2\n34#1:74,2\n37#1:76,2\n43#1:78\n44#1:79,2\n45#1:81,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FollowBtnView extends FrameLayout {

    @NotNull
    private final FeatureCommunityWidgetBtnFollowBinding mBinding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FollowBtnView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnClickListener$lambda$0(View.OnClickListener onClickListener, FollowBtnView followBtnView, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(followBtnView);
        }
    }

    public final void followUser() {
        if (getVisibility() == 8) {
            return;
        }
        SVGAImageView mIvSvgaFollowUser = this.mBinding.mIvSvgaFollowUser;
        Intrinsics.checkNotNullExpressionValue(mIvSvgaFollowUser, "mIvSvgaFollowUser");
        mIvSvgaFollowUser.setVisibility(0);
        AppCompatImageView mIvFollow = this.mBinding.mIvFollow;
        Intrinsics.checkNotNullExpressionValue(mIvFollow, "mIvFollow");
        mIvFollow.setVisibility(8);
        this.mBinding.mIvSvgaFollowUser.setLoops(1);
        SVGAParser.INSTANCE.shareParser().decodeFromAssets("feature_community_user_follow.svga", new SVGAParser.ParseCompletion() { // from class: com.qhqc.core.feature.community.widget.FollowBtnView$followUser$1
            @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity videoItem) {
                FeatureCommunityWidgetBtnFollowBinding featureCommunityWidgetBtnFollowBinding;
                FeatureCommunityWidgetBtnFollowBinding featureCommunityWidgetBtnFollowBinding2;
                FeatureCommunityWidgetBtnFollowBinding featureCommunityWidgetBtnFollowBinding3;
                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                featureCommunityWidgetBtnFollowBinding = FollowBtnView.this.mBinding;
                SVGAImageView mIvSvgaFollowUser2 = featureCommunityWidgetBtnFollowBinding.mIvSvgaFollowUser;
                Intrinsics.checkNotNullExpressionValue(mIvSvgaFollowUser2, "mIvSvgaFollowUser");
                if (mIvSvgaFollowUser2.getVisibility() == 0) {
                    featureCommunityWidgetBtnFollowBinding2 = FollowBtnView.this.mBinding;
                    featureCommunityWidgetBtnFollowBinding2.mIvSvgaFollowUser.setImageDrawable(new SVGADrawable(videoItem));
                    featureCommunityWidgetBtnFollowBinding3 = FollowBtnView.this.mBinding;
                    featureCommunityWidgetBtnFollowBinding3.mIvSvgaFollowUser.startAnimation();
                }
            }

            @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        });
    }

    public final void isFollow(boolean isFollow) {
        if (isFollow) {
            setVisibility(8);
            AppCompatImageView mIvFollow = this.mBinding.mIvFollow;
            Intrinsics.checkNotNullExpressionValue(mIvFollow, "mIvFollow");
            mIvFollow.setVisibility(8);
        } else {
            AppCompatImageView mIvFollow2 = this.mBinding.mIvFollow;
            Intrinsics.checkNotNullExpressionValue(mIvFollow2, "mIvFollow");
            mIvFollow2.setVisibility(0);
            setVisibility(0);
        }
        SVGAImageView mIvSvgaFollowUser = this.mBinding.mIvSvgaFollowUser;
        Intrinsics.checkNotNullExpressionValue(mIvSvgaFollowUser, "mIvSvgaFollowUser");
        mIvSvgaFollowUser.setVisibility(8);
        SVGAImageView.setSource$default(this.mBinding.mIvSvgaFollowUser, "", false, 2, null);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable final View.OnClickListener l10) {
        this.mBinding.mIvFollow.setOnClickListener(new View.OnClickListener() { // from class: com.qhqc.core.feature.community.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FollowBtnView.setOnClickListener$lambda$0(l10, this, view);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FollowBtnView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FollowBtnView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FollowBtnView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        FeatureCommunityWidgetBtnFollowBinding inflate = FeatureCommunityWidgetBtnFollowBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mBinding = inflate;
    }
}
