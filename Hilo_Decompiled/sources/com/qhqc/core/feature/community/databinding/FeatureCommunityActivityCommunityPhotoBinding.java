package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.qhqc.core.basic.widget.DragLayout;
import com.qhqc.core.feature.community.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityActivityCommunityPhotoBinding implements a {
    public final DragLayout mViewDrag;
    public final ViewPager2 mViewPager;
    private final ConstraintLayout rootView;

    private FeatureCommunityActivityCommunityPhotoBinding(ConstraintLayout constraintLayout, DragLayout dragLayout, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.mViewDrag = dragLayout;
        this.mViewPager = viewPager2;
    }

    public static FeatureCommunityActivityCommunityPhotoBinding bind(View view) {
        int i10 = R.id.mViewDrag;
        DragLayout dragLayout = (DragLayout) b.a(view, i10);
        if (dragLayout != null) {
            i10 = R.id.mViewPager;
            ViewPager2 viewPager2 = (ViewPager2) b.a(view, i10);
            if (viewPager2 != null) {
                return new FeatureCommunityActivityCommunityPhotoBinding((ConstraintLayout) view, dragLayout, viewPager2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static FeatureCommunityActivityCommunityPhotoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityActivityCommunityPhotoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_activity_community_photo, viewGroup, false);
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
