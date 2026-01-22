package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qhqc.core.feature.community.R;
import com.ruffian.library.widget.RImageView;
import j3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityItemPostsListLikeUserAvatarBinding implements a {
    public final RImageView mIvAvatar;
    private final RImageView rootView;

    private FeatureCommunityItemPostsListLikeUserAvatarBinding(RImageView rImageView, RImageView rImageView2) {
        this.rootView = rImageView;
        this.mIvAvatar = rImageView2;
    }

    public static FeatureCommunityItemPostsListLikeUserAvatarBinding bind(View view) {
        if (view != null) {
            RImageView rImageView = (RImageView) view;
            return new FeatureCommunityItemPostsListLikeUserAvatarBinding(rImageView, rImageView);
        }
        throw new NullPointerException("rootView");
    }

    public static FeatureCommunityItemPostsListLikeUserAvatarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityItemPostsListLikeUserAvatarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_item_posts_list_like_user_avatar, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public RImageView getRoot() {
        return this.rootView;
    }
}
