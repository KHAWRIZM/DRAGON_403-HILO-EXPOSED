package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qhqc.core.feature.community.R;
import j3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityActivityPostsLikeUserListBinding implements a {
    public final RecyclerView mRV;
    private final RecyclerView rootView;

    private FeatureCommunityActivityPostsLikeUserListBinding(RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.rootView = recyclerView;
        this.mRV = recyclerView2;
    }

    public static FeatureCommunityActivityPostsLikeUserListBinding bind(View view) {
        if (view != null) {
            RecyclerView recyclerView = (RecyclerView) view;
            return new FeatureCommunityActivityPostsLikeUserListBinding(recyclerView, recyclerView);
        }
        throw new NullPointerException("rootView");
    }

    public static FeatureCommunityActivityPostsLikeUserListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityActivityPostsLikeUserListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_activity_posts_like_user_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public RecyclerView getRoot() {
        return this.rootView;
    }
}
