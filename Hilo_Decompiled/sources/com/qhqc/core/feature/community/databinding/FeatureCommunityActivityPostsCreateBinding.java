package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.qhqc.core.feature.community.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityActivityPostsCreateBinding implements a {
    public final RecyclerView mRVPictures;
    public final AppCompatEditText mTvContent;
    public final TextView mTvContentCount;
    private final NestedScrollView rootView;
    public final View topDivider;

    private FeatureCommunityActivityPostsCreateBinding(NestedScrollView nestedScrollView, RecyclerView recyclerView, AppCompatEditText appCompatEditText, TextView textView, View view) {
        this.rootView = nestedScrollView;
        this.mRVPictures = recyclerView;
        this.mTvContent = appCompatEditText;
        this.mTvContentCount = textView;
        this.topDivider = view;
    }

    public static FeatureCommunityActivityPostsCreateBinding bind(View view) {
        View a10;
        int i10 = R.id.mRVPictures;
        RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
        if (recyclerView != null) {
            i10 = R.id.mTvContent;
            AppCompatEditText appCompatEditText = (AppCompatEditText) b.a(view, i10);
            if (appCompatEditText != null) {
                i10 = R.id.mTvContentCount;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null && (a10 = b.a(view, (i10 = R.id.top_divider))) != null) {
                    return new FeatureCommunityActivityPostsCreateBinding((NestedScrollView) view, recyclerView, appCompatEditText, textView, a10);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static FeatureCommunityActivityPostsCreateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityActivityPostsCreateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_activity_posts_create, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public NestedScrollView getRoot() {
        return this.rootView;
    }
}
