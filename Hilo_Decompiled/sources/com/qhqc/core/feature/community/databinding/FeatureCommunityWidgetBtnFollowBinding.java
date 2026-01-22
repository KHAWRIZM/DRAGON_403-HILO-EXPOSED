package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qhqc.core.feature.community.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityWidgetBtnFollowBinding implements a {
    public final AppCompatImageView mIvFollow;
    public final SVGAImageView mIvSvgaFollowUser;
    private final FrameLayout rootView;

    private FeatureCommunityWidgetBtnFollowBinding(FrameLayout frameLayout, AppCompatImageView appCompatImageView, SVGAImageView sVGAImageView) {
        this.rootView = frameLayout;
        this.mIvFollow = appCompatImageView;
        this.mIvSvgaFollowUser = sVGAImageView;
    }

    public static FeatureCommunityWidgetBtnFollowBinding bind(View view) {
        int i10 = R.id.mIvFollow;
        AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i10);
        if (appCompatImageView != null) {
            i10 = R.id.mIvSvgaFollowUser;
            SVGAImageView sVGAImageView = (SVGAImageView) b.a(view, i10);
            if (sVGAImageView != null) {
                return new FeatureCommunityWidgetBtnFollowBinding((FrameLayout) view, appCompatImageView, sVGAImageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static FeatureCommunityWidgetBtnFollowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityWidgetBtnFollowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_widget_btn_follow, viewGroup, false);
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
