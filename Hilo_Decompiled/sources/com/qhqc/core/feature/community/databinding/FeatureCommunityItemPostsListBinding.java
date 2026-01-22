package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.widget.PostsContentView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class FeatureCommunityItemPostsListBinding extends ViewDataBinding {
    public final PostsContentView mViewPostContent;

    /* JADX INFO: Access modifiers changed from: protected */
    public FeatureCommunityItemPostsListBinding(Object obj, View view, int i10, PostsContentView postsContentView) {
        super(obj, view, i10);
        this.mViewPostContent = postsContentView;
    }

    public static FeatureCommunityItemPostsListBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FeatureCommunityItemPostsListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static FeatureCommunityItemPostsListBinding bind(View view, Object obj) {
        return (FeatureCommunityItemPostsListBinding) ViewDataBinding.bind(obj, view, R.layout.feature_community_item_posts_list);
    }

    @Deprecated
    public static FeatureCommunityItemPostsListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (FeatureCommunityItemPostsListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.feature_community_item_posts_list, viewGroup, z10, obj);
    }

    public static FeatureCommunityItemPostsListBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FeatureCommunityItemPostsListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FeatureCommunityItemPostsListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.feature_community_item_posts_list, null, false, obj);
    }
}
