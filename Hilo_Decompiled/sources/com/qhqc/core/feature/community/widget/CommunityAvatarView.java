package com.qhqc.core.feature.community.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.i;
import com.bumptech.glide.j;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.glideplugin.UtilKt;
import com.qhqc.core.basic.aws.ImageResizeKtKt;
import com.qhqc.core.basic.picture.glide.GlideConstant;
import com.qhqc.core.feature.bean.UserInfoBean;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.databinding.FeatureCommunityViewAvatarBinding;
import com.qiahao.base_common.utils.PathHelper;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/qhqc/core/feature/community/widget/CommunityAvatarView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defAttrStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityViewAvatarBinding;", "getBinding", "()Lcom/qhqc/core/feature/community/databinding/FeatureCommunityViewAvatarBinding;", "parser", "Lcom/opensource/svgaplayer/SVGAParser;", "getParser", "()Lcom/opensource/svgaplayer/SVGAParser;", "loadData", "", "userInfo", "Lcom/qhqc/core/feature/bean/UserInfoBean;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommunityAvatarView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommunityAvatarView.kt\ncom/qhqc/core/feature/community/widget/CommunityAvatarView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,165:1\n256#2,2:166\n256#2,2:168\n256#2,2:170\n256#2,2:172\n*S KotlinDebug\n*F\n+ 1 CommunityAvatarView.kt\ncom/qhqc/core/feature/community/widget/CommunityAvatarView\n*L\n141#1:166,2\n142#1:168,2\n145#1:170,2\n146#1:172,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CommunityAvatarView extends FrameLayout {

    @NotNull
    private final FeatureCommunityViewAvatarBinding binding;

    @NotNull
    private final SVGAParser parser;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommunityAvatarView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    public final FeatureCommunityViewAvatarBinding getBinding() {
        return this.binding;
    }

    @NotNull
    public final SVGAParser getParser() {
        return this.parser;
    }

    public final void loadData(@NotNull final UserInfoBean userInfo) {
        String picUrl;
        String effectUrl;
        String headwearIcon;
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        i q10 = Glide.with(this.binding.mIvAvatar).q(ImageResizeKtKt.imageResizeAvatar(userInfo.getAvatar()));
        int i10 = R.drawable.default_user_icon;
        ((i) ((i) q10.X(i10)).j(i10)).D0(this.binding.mIvAvatar);
        String effectUrl2 = userInfo.getEffectUrl();
        if ((effectUrl2 != null && effectUrl2.length() != 0) || ((picUrl = userInfo.getPicUrl()) != null && picUrl.length() != 0)) {
            String effectUrl3 = userInfo.getEffectUrl();
            if (effectUrl3 != null && effectUrl3.length() > 0 && (effectUrl = userInfo.getEffectUrl()) != null && StringsKt.endsWith$default(effectUrl, PathHelper.SUFFIX_TYPE_SVGA, false, 2, (Object) null)) {
                this.binding.mIvHeadWear.setImageDrawable(null);
                String headwearIcon2 = userInfo.getHeadwearIcon();
                if (headwearIcon2 != null && headwearIcon2.length() != 0) {
                    String headwearIcon3 = userInfo.getHeadwearIcon();
                    if ((headwearIcon3 != null && StringsKt.startsWith$default(headwearIcon3, "http://", false, 2, (Object) null)) || ((headwearIcon = userInfo.getHeadwearIcon()) != null && StringsKt.startsWith$default(headwearIcon, "https://", false, 2, (Object) null))) {
                        this.parser.decodeFromURL(new URL(userInfo.getEffectUrl() + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qhqc.core.feature.community.widget.CommunityAvatarView$loadData$1
                            @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
                            public void onComplete(SVGAVideoEntity videoItem) {
                                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                                SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                                sVGADynamicEntity.setDynamicImage(CommunityAvatarViewKt.imageCircle(UserInfoBean.this.getHeadwearIcon(), 100), "avatar");
                                this.getBinding().mIvHeadWear.stopAnimation(true);
                                this.getBinding().mIvHeadWear.setImageDrawable(new SVGADrawable(videoItem, sVGADynamicEntity));
                                this.getBinding().mIvHeadWear.startAnimation();
                            }

                            @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
                            public void onError() {
                            }
                        });
                    }
                } else {
                    j with = Glide.with(this.binding.mIvHeadWear);
                    Intrinsics.checkNotNullExpressionValue(with, "with(...)");
                    i iVar = (i) UtilKt.asSVGA(with).K0(userInfo.getEffectUrl()).j(GlideConstant.INSTANCE.getTRANSPARENT());
                    SVGAImageView mIvHeadWear = this.binding.mIvHeadWear;
                    Intrinsics.checkNotNullExpressionValue(mIvHeadWear, "mIvHeadWear");
                    iVar.A0(new SvgaImageVideoTarget(mIvHeadWear, true));
                }
            } else {
                String picUrl2 = userInfo.getPicUrl();
                if (picUrl2 != null && picUrl2.length() > 0) {
                    i q11 = Glide.with(this.binding.mIvHeadWear).q(ImageResizeKtKt.imageResizeAvatar(userInfo.getPicUrl()));
                    GlideConstant glideConstant = GlideConstant.INSTANCE;
                    Intrinsics.checkNotNull(((i) ((i) q11.X(glideConstant.getTRANSPARENT())).j(glideConstant.getTRANSPARENT())).D0(this.binding.mIvHeadWear));
                } else {
                    this.binding.mIvHeadWear.setImageDrawable(null);
                }
            }
        } else {
            this.binding.mIvHeadWear.setImageDrawable(null);
        }
        if (userInfo.getOnline() == 1) {
            LottieAnimationView mIvOnlineState = this.binding.mIvOnlineState;
            Intrinsics.checkNotNullExpressionValue(mIvOnlineState, "mIvOnlineState");
            mIvOnlineState.setVisibility(0);
            LottieAnimationView mTvOnlineState = this.binding.mTvOnlineState;
            Intrinsics.checkNotNullExpressionValue(mTvOnlineState, "mTvOnlineState");
            mTvOnlineState.setVisibility(0);
            return;
        }
        LottieAnimationView mIvOnlineState2 = this.binding.mIvOnlineState;
        Intrinsics.checkNotNullExpressionValue(mIvOnlineState2, "mIvOnlineState");
        mIvOnlineState2.setVisibility(8);
        LottieAnimationView mTvOnlineState2 = this.binding.mTvOnlineState;
        Intrinsics.checkNotNullExpressionValue(mTvOnlineState2, "mTvOnlineState");
        mTvOnlineState2.setVisibility(8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommunityAvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CommunityAvatarView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommunityAvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        FeatureCommunityViewAvatarBinding inflate = FeatureCommunityViewAvatarBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        this.parser = SVGAParser.INSTANCE.shareParser();
    }
}
