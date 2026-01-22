package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qhqc.core.feature.community.R;
import com.ruffian.library.widget.RImageView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityItemPostsCommentFloorListBinding implements a {
    public final RImageView mIvAvatar;
    public final AppCompatImageView mIvSvip;
    public final AppCompatImageView mIvVip;
    public final TextView mTvContent;
    public final TextView mTvName;
    public final TextView mTvTime;
    public final LinearLayoutCompat mViewInfos;
    private final ConstraintLayout rootView;

    private FeatureCommunityItemPostsCommentFloorListBinding(ConstraintLayout constraintLayout, RImageView rImageView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, TextView textView2, TextView textView3, LinearLayoutCompat linearLayoutCompat) {
        this.rootView = constraintLayout;
        this.mIvAvatar = rImageView;
        this.mIvSvip = appCompatImageView;
        this.mIvVip = appCompatImageView2;
        this.mTvContent = textView;
        this.mTvName = textView2;
        this.mTvTime = textView3;
        this.mViewInfos = linearLayoutCompat;
    }

    public static FeatureCommunityItemPostsCommentFloorListBinding bind(View view) {
        int i10 = R.id.mIvAvatar;
        RImageView rImageView = (RImageView) b.a(view, i10);
        if (rImageView != null) {
            i10 = R.id.mIvSvip;
            AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i10);
            if (appCompatImageView != null) {
                i10 = R.id.mIvVip;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) b.a(view, i10);
                if (appCompatImageView2 != null) {
                    i10 = R.id.mTvContent;
                    TextView textView = (TextView) b.a(view, i10);
                    if (textView != null) {
                        i10 = R.id.mTvName;
                        TextView textView2 = (TextView) b.a(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.mTvTime;
                            TextView textView3 = (TextView) b.a(view, i10);
                            if (textView3 != null) {
                                i10 = R.id.mViewInfos;
                                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) b.a(view, i10);
                                if (linearLayoutCompat != null) {
                                    return new FeatureCommunityItemPostsCommentFloorListBinding((ConstraintLayout) view, rImageView, appCompatImageView, appCompatImageView2, textView, textView2, textView3, linearLayoutCompat);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static FeatureCommunityItemPostsCommentFloorListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityItemPostsCommentFloorListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_item_posts_comment_floor_list, viewGroup, false);
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
