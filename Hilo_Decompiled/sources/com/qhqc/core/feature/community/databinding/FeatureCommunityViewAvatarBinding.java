package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qhqc.core.feature.community.R;
import com.ruffian.library.widget.RImageView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityViewAvatarBinding implements a {
    public final RImageView mIvAvatar;
    public final SVGAImageView mIvHeadWear;
    public final LottieAnimationView mIvOnlineState;
    public final LottieAnimationView mTvOnlineState;
    private final ConstraintLayout rootView;

    private FeatureCommunityViewAvatarBinding(ConstraintLayout constraintLayout, RImageView rImageView, SVGAImageView sVGAImageView, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2) {
        this.rootView = constraintLayout;
        this.mIvAvatar = rImageView;
        this.mIvHeadWear = sVGAImageView;
        this.mIvOnlineState = lottieAnimationView;
        this.mTvOnlineState = lottieAnimationView2;
    }

    public static FeatureCommunityViewAvatarBinding bind(View view) {
        int i10 = R.id.mIvAvatar;
        RImageView rImageView = (RImageView) b.a(view, i10);
        if (rImageView != null) {
            i10 = R.id.mIvHeadWear;
            SVGAImageView sVGAImageView = (SVGAImageView) b.a(view, i10);
            if (sVGAImageView != null) {
                i10 = R.id.mIvOnlineState;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) b.a(view, i10);
                if (lottieAnimationView != null) {
                    i10 = R.id.mTvOnlineState;
                    LottieAnimationView lottieAnimationView2 = (LottieAnimationView) b.a(view, i10);
                    if (lottieAnimationView2 != null) {
                        return new FeatureCommunityViewAvatarBinding((ConstraintLayout) view, rImageView, sVGAImageView, lottieAnimationView, lottieAnimationView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static FeatureCommunityViewAvatarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityViewAvatarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_view_avatar, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
