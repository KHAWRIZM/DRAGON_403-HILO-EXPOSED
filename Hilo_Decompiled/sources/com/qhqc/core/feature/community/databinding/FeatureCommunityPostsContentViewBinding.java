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
import com.airbnb.lottie.LottieAnimationView;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.widget.CommunityAvatarView;
import com.qhqc.core.feature.community.widget.FollowBtnView;
import com.qhqc.core.feature.community.widget.GenderAgeView;
import com.ruffian.library.widget.RConstraintLayout;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityPostsContentViewBinding implements a {
    public final View likeClickView;
    public final CommunityAvatarView mIvAvatar;
    public final AppCompatImageView mIvLike;
    public final AppCompatImageView mIvLikeListEnd;
    public final AppCompatImageView mIvLikeListStart;
    public final LottieAnimationView mIvLikeSvga;
    public final AppCompatImageView mIvMore;
    public final AppCompatImageView mIvNoble;
    public final AppCompatImageView mIvSVip;
    public final RecyclerView mRVImages;
    public final RecyclerView mRVLikes;
    public final AppCompatTextView mTvComments;
    public final TextView mTvContent;
    public final AppCompatTextView mTvLikes;
    public final AppCompatTextView mTvMore;
    public final TextView mTvName;
    public final TextView mTvTime;
    public final View mViewBottom;
    public final LinearLayoutCompat mViewComments;
    public final FollowBtnView mViewFollow;
    public final GenderAgeView mViewGender;
    public final LinearLayoutCompat mViewIcons;
    public final RConstraintLayout mViewLike;
    private final ConstraintLayout rootView;

    private FeatureCommunityPostsContentViewBinding(ConstraintLayout constraintLayout, View view, CommunityAvatarView communityAvatarView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LottieAnimationView lottieAnimationView, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, AppCompatImageView appCompatImageView6, RecyclerView recyclerView, RecyclerView recyclerView2, AppCompatTextView appCompatTextView, TextView textView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, TextView textView2, TextView textView3, View view2, LinearLayoutCompat linearLayoutCompat, FollowBtnView followBtnView, GenderAgeView genderAgeView, LinearLayoutCompat linearLayoutCompat2, RConstraintLayout rConstraintLayout) {
        this.rootView = constraintLayout;
        this.likeClickView = view;
        this.mIvAvatar = communityAvatarView;
        this.mIvLike = appCompatImageView;
        this.mIvLikeListEnd = appCompatImageView2;
        this.mIvLikeListStart = appCompatImageView3;
        this.mIvLikeSvga = lottieAnimationView;
        this.mIvMore = appCompatImageView4;
        this.mIvNoble = appCompatImageView5;
        this.mIvSVip = appCompatImageView6;
        this.mRVImages = recyclerView;
        this.mRVLikes = recyclerView2;
        this.mTvComments = appCompatTextView;
        this.mTvContent = textView;
        this.mTvLikes = appCompatTextView2;
        this.mTvMore = appCompatTextView3;
        this.mTvName = textView2;
        this.mTvTime = textView3;
        this.mViewBottom = view2;
        this.mViewComments = linearLayoutCompat;
        this.mViewFollow = followBtnView;
        this.mViewGender = genderAgeView;
        this.mViewIcons = linearLayoutCompat2;
        this.mViewLike = rConstraintLayout;
    }

    public static FeatureCommunityPostsContentViewBinding bind(View view) {
        View a10;
        int i10 = R.id.likeClickView;
        View a11 = b.a(view, i10);
        if (a11 != null) {
            i10 = R.id.mIvAvatar;
            CommunityAvatarView communityAvatarView = (CommunityAvatarView) b.a(view, i10);
            if (communityAvatarView != null) {
                i10 = R.id.mIvLike;
                AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i10);
                if (appCompatImageView != null) {
                    i10 = R.id.mIvLikeListEnd;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) b.a(view, i10);
                    if (appCompatImageView2 != null) {
                        i10 = R.id.mIvLikeListStart;
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) b.a(view, i10);
                        if (appCompatImageView3 != null) {
                            i10 = R.id.mIvLikeSvga;
                            LottieAnimationView lottieAnimationView = (LottieAnimationView) b.a(view, i10);
                            if (lottieAnimationView != null) {
                                i10 = R.id.mIvMore;
                                AppCompatImageView appCompatImageView4 = (AppCompatImageView) b.a(view, i10);
                                if (appCompatImageView4 != null) {
                                    i10 = R.id.mIvNoble;
                                    AppCompatImageView appCompatImageView5 = (AppCompatImageView) b.a(view, i10);
                                    if (appCompatImageView5 != null) {
                                        i10 = R.id.mIvSVip;
                                        AppCompatImageView appCompatImageView6 = (AppCompatImageView) b.a(view, i10);
                                        if (appCompatImageView6 != null) {
                                            i10 = R.id.mRVImages;
                                            RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
                                            if (recyclerView != null) {
                                                i10 = R.id.mRVLikes;
                                                RecyclerView recyclerView2 = (RecyclerView) b.a(view, i10);
                                                if (recyclerView2 != null) {
                                                    i10 = R.id.mTvComments;
                                                    AppCompatTextView appCompatTextView = (AppCompatTextView) b.a(view, i10);
                                                    if (appCompatTextView != null) {
                                                        i10 = R.id.mTvContent;
                                                        TextView textView = (TextView) b.a(view, i10);
                                                        if (textView != null) {
                                                            i10 = R.id.mTvLikes;
                                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) b.a(view, i10);
                                                            if (appCompatTextView2 != null) {
                                                                i10 = R.id.mTvMore;
                                                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) b.a(view, i10);
                                                                if (appCompatTextView3 != null) {
                                                                    i10 = R.id.mTvName;
                                                                    TextView textView2 = (TextView) b.a(view, i10);
                                                                    if (textView2 != null) {
                                                                        i10 = R.id.mTvTime;
                                                                        TextView textView3 = (TextView) b.a(view, i10);
                                                                        if (textView3 != null && (a10 = b.a(view, (i10 = R.id.mViewBottom))) != null) {
                                                                            i10 = R.id.mViewComments;
                                                                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) b.a(view, i10);
                                                                            if (linearLayoutCompat != null) {
                                                                                i10 = R.id.mViewFollow;
                                                                                FollowBtnView followBtnView = (FollowBtnView) b.a(view, i10);
                                                                                if (followBtnView != null) {
                                                                                    i10 = R.id.mViewGender;
                                                                                    GenderAgeView genderAgeView = (GenderAgeView) b.a(view, i10);
                                                                                    if (genderAgeView != null) {
                                                                                        i10 = R.id.mViewIcons;
                                                                                        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) b.a(view, i10);
                                                                                        if (linearLayoutCompat2 != null) {
                                                                                            i10 = R.id.mViewLike;
                                                                                            RConstraintLayout rConstraintLayout = (RConstraintLayout) b.a(view, i10);
                                                                                            if (rConstraintLayout != null) {
                                                                                                return new FeatureCommunityPostsContentViewBinding((ConstraintLayout) view, a11, communityAvatarView, appCompatImageView, appCompatImageView2, appCompatImageView3, lottieAnimationView, appCompatImageView4, appCompatImageView5, appCompatImageView6, recyclerView, recyclerView2, appCompatTextView, textView, appCompatTextView2, appCompatTextView3, textView2, textView3, a10, linearLayoutCompat, followBtnView, genderAgeView, linearLayoutCompat2, rConstraintLayout);
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

    public static FeatureCommunityPostsContentViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityPostsContentViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_posts_content_view, viewGroup, false);
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
