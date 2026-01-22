package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.qhqc.core.feature.community.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityFragmentPostsSquareBinding implements a {
    public final AppCompatImageView mIvPostsCreate;
    public final RecyclerView mRV;
    public final SmartRefreshLayout mRefreshLayout;
    public final ConstraintLayout postContainer;
    private final ConstraintLayout rootView;

    private FeatureCommunityFragmentPostsSquareBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.mIvPostsCreate = appCompatImageView;
        this.mRV = recyclerView;
        this.mRefreshLayout = smartRefreshLayout;
        this.postContainer = constraintLayout2;
    }

    public static FeatureCommunityFragmentPostsSquareBinding bind(View view) {
        SmartRefreshLayout a10;
        int i10 = R.id.mIvPostsCreate;
        AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i10);
        if (appCompatImageView != null) {
            i10 = R.id.mRV;
            RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
            if (recyclerView != null && (a10 = b.a(view, (i10 = R.id.mRefreshLayout))) != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                return new FeatureCommunityFragmentPostsSquareBinding(constraintLayout, appCompatImageView, recyclerView, a10, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static FeatureCommunityFragmentPostsSquareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityFragmentPostsSquareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_fragment_posts_square, viewGroup, false);
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
