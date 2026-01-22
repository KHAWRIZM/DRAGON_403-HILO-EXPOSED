package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.widget.CommunityAvatarView;
import com.qhqc.core.feature.community.widget.GenderAgeView;
import com.ruffian.library.widget.RImageView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityItemPostsNoticeBinding implements a {
    public final CommunityAvatarView mIvAvatar;
    public final AppCompatImageView mIvNoble;
    public final RImageView mIvPostsPic;
    public final AppCompatImageView mIvSVip;
    public final TextView mTvContent;
    public final TextView mTvHistory;
    public final TextView mTvName;
    public final TextView mTvTime;
    public final GenderAgeView mViewGender;
    public final LinearLayoutCompat mViewInfos;
    private final ConstraintLayout rootView;

    private FeatureCommunityItemPostsNoticeBinding(ConstraintLayout constraintLayout, CommunityAvatarView communityAvatarView, AppCompatImageView appCompatImageView, RImageView rImageView, AppCompatImageView appCompatImageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, GenderAgeView genderAgeView, LinearLayoutCompat linearLayoutCompat) {
        this.rootView = constraintLayout;
        this.mIvAvatar = communityAvatarView;
        this.mIvNoble = appCompatImageView;
        this.mIvPostsPic = rImageView;
        this.mIvSVip = appCompatImageView2;
        this.mTvContent = textView;
        this.mTvHistory = textView2;
        this.mTvName = textView3;
        this.mTvTime = textView4;
        this.mViewGender = genderAgeView;
        this.mViewInfos = linearLayoutCompat;
    }

    public static FeatureCommunityItemPostsNoticeBinding bind(View view) {
        int i10 = R.id.mIvAvatar;
        CommunityAvatarView communityAvatarView = (CommunityAvatarView) b.a(view, i10);
        if (communityAvatarView != null) {
            i10 = R.id.mIvNoble;
            AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i10);
            if (appCompatImageView != null) {
                i10 = R.id.mIvPostsPic;
                RImageView rImageView = (RImageView) b.a(view, i10);
                if (rImageView != null) {
                    i10 = R.id.mIvSVip;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) b.a(view, i10);
                    if (appCompatImageView2 != null) {
                        i10 = R.id.mTvContent;
                        TextView textView = (TextView) b.a(view, i10);
                        if (textView != null) {
                            i10 = R.id.mTvHistory;
                            TextView textView2 = (TextView) b.a(view, i10);
                            if (textView2 != null) {
                                i10 = R.id.mTvName;
                                TextView textView3 = (TextView) b.a(view, i10);
                                if (textView3 != null) {
                                    i10 = R.id.mTvTime;
                                    TextView textView4 = (TextView) b.a(view, i10);
                                    if (textView4 != null) {
                                        i10 = R.id.mViewGender;
                                        GenderAgeView genderAgeView = (GenderAgeView) b.a(view, i10);
                                        if (genderAgeView != null) {
                                            i10 = R.id.mViewInfos;
                                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) b.a(view, i10);
                                            if (linearLayoutCompat != null) {
                                                return new FeatureCommunityItemPostsNoticeBinding((ConstraintLayout) view, communityAvatarView, appCompatImageView, rImageView, appCompatImageView2, textView, textView2, textView3, textView4, genderAgeView, linearLayoutCompat);
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

    public static FeatureCommunityItemPostsNoticeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityItemPostsNoticeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_item_posts_notice, viewGroup, false);
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
