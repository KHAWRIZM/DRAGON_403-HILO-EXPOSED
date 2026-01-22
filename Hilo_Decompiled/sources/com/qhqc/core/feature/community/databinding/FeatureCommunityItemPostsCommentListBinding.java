package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.widget.LikeTextView;
import com.ruffian.library.widget.RImageView;
import com.ruffian.library.widget.RLinearLayout;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityItemPostsCommentListBinding implements a {
    public final RImageView mIvAvatar;
    public final AppCompatImageView mIvSvip;
    public final AppCompatImageView mIvVip;
    public final RecyclerView mRVFloor;
    public final TextView mTvContent;
    public final LikeTextView mTvLike;
    public final TextView mTvName;
    public final TextView mTvTime;
    public final RLinearLayout mViewCommentFloor;
    public final LinearLayoutCompat mViewInfos;
    public final AppCompatTextView mViewMoreCom;
    private final ConstraintLayout rootView;

    private FeatureCommunityItemPostsCommentListBinding(ConstraintLayout constraintLayout, RImageView rImageView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, RecyclerView recyclerView, TextView textView, LikeTextView likeTextView, TextView textView2, TextView textView3, RLinearLayout rLinearLayout, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView) {
        this.rootView = constraintLayout;
        this.mIvAvatar = rImageView;
        this.mIvSvip = appCompatImageView;
        this.mIvVip = appCompatImageView2;
        this.mRVFloor = recyclerView;
        this.mTvContent = textView;
        this.mTvLike = likeTextView;
        this.mTvName = textView2;
        this.mTvTime = textView3;
        this.mViewCommentFloor = rLinearLayout;
        this.mViewInfos = linearLayoutCompat;
        this.mViewMoreCom = appCompatTextView;
    }

    public static FeatureCommunityItemPostsCommentListBinding bind(View view) {
        int i10 = R.id.mIvAvatar;
        RImageView rImageView = (RImageView) b.a(view, i10);
        if (rImageView != null) {
            i10 = R.id.mIvSvip;
            AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i10);
            if (appCompatImageView != null) {
                i10 = R.id.mIvVip;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) b.a(view, i10);
                if (appCompatImageView2 != null) {
                    i10 = R.id.mRVFloor;
                    RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
                    if (recyclerView != null) {
                        i10 = R.id.mTvContent;
                        TextView textView = (TextView) b.a(view, i10);
                        if (textView != null) {
                            i10 = R.id.mTvLike;
                            LikeTextView likeTextView = (LikeTextView) b.a(view, i10);
                            if (likeTextView != null) {
                                i10 = R.id.mTvName;
                                TextView textView2 = (TextView) b.a(view, i10);
                                if (textView2 != null) {
                                    i10 = R.id.mTvTime;
                                    TextView textView3 = (TextView) b.a(view, i10);
                                    if (textView3 != null) {
                                        i10 = R.id.mViewCommentFloor;
                                        RLinearLayout rLinearLayout = (RLinearLayout) b.a(view, i10);
                                        if (rLinearLayout != null) {
                                            i10 = R.id.mViewInfos;
                                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) b.a(view, i10);
                                            if (linearLayoutCompat != null) {
                                                i10 = R.id.mViewMoreCom;
                                                AppCompatTextView appCompatTextView = (AppCompatTextView) b.a(view, i10);
                                                if (appCompatTextView != null) {
                                                    return new FeatureCommunityItemPostsCommentListBinding((ConstraintLayout) view, rImageView, appCompatImageView, appCompatImageView2, recyclerView, textView, likeTextView, textView2, textView3, rLinearLayout, linearLayoutCompat, appCompatTextView);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static FeatureCommunityItemPostsCommentListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityItemPostsCommentListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_item_posts_comment_list, viewGroup, false);
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
