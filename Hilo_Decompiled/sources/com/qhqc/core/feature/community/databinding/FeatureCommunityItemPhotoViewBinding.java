package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.qhqc.core.feature.community.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityItemPhotoViewBinding implements a {
    public final SubsamplingScaleImageView mIvSubsampling;
    public final ProgressBar mProgress;
    private final FrameLayout rootView;

    private FeatureCommunityItemPhotoViewBinding(FrameLayout frameLayout, SubsamplingScaleImageView subsamplingScaleImageView, ProgressBar progressBar) {
        this.rootView = frameLayout;
        this.mIvSubsampling = subsamplingScaleImageView;
        this.mProgress = progressBar;
    }

    public static FeatureCommunityItemPhotoViewBinding bind(View view) {
        int i10 = R.id.mIvSubsampling;
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) b.a(view, i10);
        if (subsamplingScaleImageView != null) {
            i10 = R.id.mProgress;
            ProgressBar progressBar = (ProgressBar) b.a(view, i10);
            if (progressBar != null) {
                return new FeatureCommunityItemPhotoViewBinding((FrameLayout) view, subsamplingScaleImageView, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static FeatureCommunityItemPhotoViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityItemPhotoViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_item_photo_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
