package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.qhqc.core.basic.widget.KeyboardFrameLayout;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.widget.PostsContentView;
import com.ruffian.library.widget.REditText;
import com.ruffian.library.widget.RTextView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityActivityPostsDetailsBinding implements a {
    public final REditText mETComments;
    public final RecyclerView mRV;
    public final TextView mTvReplyTo;
    public final RTextView mTvSend;
    public final KeyboardFrameLayout mViewEdit;
    public final PostsContentView mViewPostContent;
    private final ConstraintLayout rootView;

    private FeatureCommunityActivityPostsDetailsBinding(ConstraintLayout constraintLayout, REditText rEditText, RecyclerView recyclerView, TextView textView, RTextView rTextView, KeyboardFrameLayout keyboardFrameLayout, PostsContentView postsContentView) {
        this.rootView = constraintLayout;
        this.mETComments = rEditText;
        this.mRV = recyclerView;
        this.mTvReplyTo = textView;
        this.mTvSend = rTextView;
        this.mViewEdit = keyboardFrameLayout;
        this.mViewPostContent = postsContentView;
    }

    public static FeatureCommunityActivityPostsDetailsBinding bind(View view) {
        int i10 = R.id.mETComments;
        REditText rEditText = (REditText) b.a(view, i10);
        if (rEditText != null) {
            i10 = R.id.mRV;
            RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
            if (recyclerView != null) {
                i10 = R.id.mTvReplyTo;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    i10 = R.id.mTvSend;
                    RTextView rTextView = (RTextView) b.a(view, i10);
                    if (rTextView != null) {
                        i10 = R.id.mViewEdit;
                        KeyboardFrameLayout keyboardFrameLayout = (KeyboardFrameLayout) b.a(view, i10);
                        if (keyboardFrameLayout != null) {
                            i10 = R.id.mViewPostContent;
                            PostsContentView postsContentView = (PostsContentView) b.a(view, i10);
                            if (postsContentView != null) {
                                return new FeatureCommunityActivityPostsDetailsBinding((ConstraintLayout) view, rEditText, recyclerView, textView, rTextView, keyboardFrameLayout, postsContentView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static FeatureCommunityActivityPostsDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityActivityPostsDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_activity_posts_details, viewGroup, false);
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
