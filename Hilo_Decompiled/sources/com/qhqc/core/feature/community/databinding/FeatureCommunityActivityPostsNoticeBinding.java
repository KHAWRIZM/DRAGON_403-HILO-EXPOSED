package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.qhqc.core.feature.community.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityActivityPostsNoticeBinding implements a {
    public final TextView goToPlaza;
    public final RecyclerView mRV;
    public final ConstraintLayout recentContainer;
    public final RecyclerView recentRv;
    public final TextView recentTitle;
    private final ConstraintLayout rootView;
    public final View topDivider;

    private FeatureCommunityActivityPostsNoticeBinding(ConstraintLayout constraintLayout, TextView textView, RecyclerView recyclerView, ConstraintLayout constraintLayout2, RecyclerView recyclerView2, TextView textView2, View view) {
        this.rootView = constraintLayout;
        this.goToPlaza = textView;
        this.mRV = recyclerView;
        this.recentContainer = constraintLayout2;
        this.recentRv = recyclerView2;
        this.recentTitle = textView2;
        this.topDivider = view;
    }

    public static FeatureCommunityActivityPostsNoticeBinding bind(View view) {
        View a10;
        int i10 = R.id.go_to_plaza;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = R.id.mRV;
            RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
            if (recyclerView != null) {
                i10 = R.id.recent_container;
                ConstraintLayout constraintLayout = (ConstraintLayout) b.a(view, i10);
                if (constraintLayout != null) {
                    i10 = R.id.recent_rv;
                    RecyclerView recyclerView2 = (RecyclerView) b.a(view, i10);
                    if (recyclerView2 != null) {
                        i10 = R.id.recent_title;
                        TextView textView2 = (TextView) b.a(view, i10);
                        if (textView2 != null && (a10 = b.a(view, (i10 = R.id.top_divider))) != null) {
                            return new FeatureCommunityActivityPostsNoticeBinding((ConstraintLayout) view, textView, recyclerView, constraintLayout, recyclerView2, textView2, a10);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static FeatureCommunityActivityPostsNoticeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityActivityPostsNoticeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_activity_posts_notice, viewGroup, false);
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
