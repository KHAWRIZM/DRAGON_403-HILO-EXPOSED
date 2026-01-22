package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.widget.GenderAgeView;
import com.ruffian.library.widget.RImageView;
import com.ruffian.library.widget.RTextView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityItemPostsLikeListBinding implements a {
    public final RTextView mBtnFollowUser;
    public final RImageView mIvAvatar;
    public final AppCompatImageView mIvNoble;
    public final AppCompatImageView mIvSVip;
    public final TextView mTvName;
    public final TextView mTvTime;
    public final GenderAgeView mViewGender;
    public final LinearLayoutCompat mViewIcons;
    private final ConstraintLayout rootView;

    private FeatureCommunityItemPostsLikeListBinding(ConstraintLayout constraintLayout, RTextView rTextView, RImageView rImageView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, TextView textView2, GenderAgeView genderAgeView, LinearLayoutCompat linearLayoutCompat) {
        this.rootView = constraintLayout;
        this.mBtnFollowUser = rTextView;
        this.mIvAvatar = rImageView;
        this.mIvNoble = appCompatImageView;
        this.mIvSVip = appCompatImageView2;
        this.mTvName = textView;
        this.mTvTime = textView2;
        this.mViewGender = genderAgeView;
        this.mViewIcons = linearLayoutCompat;
    }

    public static FeatureCommunityItemPostsLikeListBinding bind(View view) {
        int i10 = R.id.mBtnFollowUser;
        RTextView rTextView = (RTextView) b.a(view, i10);
        if (rTextView != null) {
            i10 = R.id.mIvAvatar;
            RImageView rImageView = (RImageView) b.a(view, i10);
            if (rImageView != null) {
                i10 = R.id.mIvNoble;
                AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i10);
                if (appCompatImageView != null) {
                    i10 = R.id.mIvSVip;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) b.a(view, i10);
                    if (appCompatImageView2 != null) {
                        i10 = R.id.mTvName;
                        TextView textView = (TextView) b.a(view, i10);
                        if (textView != null) {
                            i10 = R.id.mTvTime;
                            TextView textView2 = (TextView) b.a(view, i10);
                            if (textView2 != null) {
                                i10 = R.id.mViewGender;
                                GenderAgeView genderAgeView = (GenderAgeView) b.a(view, i10);
                                if (genderAgeView != null) {
                                    i10 = R.id.mViewIcons;
                                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) b.a(view, i10);
                                    if (linearLayoutCompat != null) {
                                        return new FeatureCommunityItemPostsLikeListBinding((ConstraintLayout) view, rTextView, rImageView, appCompatImageView, appCompatImageView2, textView, textView2, genderAgeView, linearLayoutCompat);
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

    public static FeatureCommunityItemPostsLikeListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityItemPostsLikeListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_item_posts_like_list, viewGroup, false);
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
