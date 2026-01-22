package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qhqc.core.feature.community.R;
import com.ruffian.library.widget.RImageView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityItemPostsMediaListBinding implements a {
    public final RImageView mIv;
    public final ConstraintLayout mViewContainer;
    private final ConstraintLayout rootView;

    private FeatureCommunityItemPostsMediaListBinding(ConstraintLayout constraintLayout, RImageView rImageView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.mIv = rImageView;
        this.mViewContainer = constraintLayout2;
    }

    public static FeatureCommunityItemPostsMediaListBinding bind(View view) {
        int i10 = R.id.mIv;
        RImageView rImageView = (RImageView) b.a(view, i10);
        if (rImageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new FeatureCommunityItemPostsMediaListBinding(constraintLayout, rImageView, constraintLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static FeatureCommunityItemPostsMediaListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityItemPostsMediaListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_item_posts_media_list, viewGroup, false);
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
