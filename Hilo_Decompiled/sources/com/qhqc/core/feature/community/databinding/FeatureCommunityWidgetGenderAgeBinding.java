package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.qhqc.core.feature.community.R;
import com.ruffian.library.widget.RLinearLayout;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityWidgetGenderAgeBinding implements a {
    public final AppCompatImageView mIvGender;
    public final TextView mTvAge;
    public final RLinearLayout mViewContent;
    private final RLinearLayout rootView;

    private FeatureCommunityWidgetGenderAgeBinding(RLinearLayout rLinearLayout, AppCompatImageView appCompatImageView, TextView textView, RLinearLayout rLinearLayout2) {
        this.rootView = rLinearLayout;
        this.mIvGender = appCompatImageView;
        this.mTvAge = textView;
        this.mViewContent = rLinearLayout2;
    }

    public static FeatureCommunityWidgetGenderAgeBinding bind(View view) {
        int i10 = R.id.mIvGender;
        AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i10);
        if (appCompatImageView != null) {
            i10 = R.id.mTvAge;
            TextView textView = (TextView) b.a(view, i10);
            if (textView != null) {
                RLinearLayout rLinearLayout = (RLinearLayout) view;
                return new FeatureCommunityWidgetGenderAgeBinding(rLinearLayout, appCompatImageView, textView, rLinearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static FeatureCommunityWidgetGenderAgeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityWidgetGenderAgeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_widget_gender_age, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public RLinearLayout getRoot() {
        return this.rootView;
    }
}
