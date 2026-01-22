package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qhqc.core.feature.community.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityAdapterStateViewEmptyBinding implements a {
    public final TextView content;
    public final ConstraintLayout emptyContent;
    public final ImageView image;
    private final ConstraintLayout rootView;

    private FeatureCommunityAdapterStateViewEmptyBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ImageView imageView) {
        this.rootView = constraintLayout;
        this.content = textView;
        this.emptyContent = constraintLayout2;
        this.image = imageView;
    }

    public static FeatureCommunityAdapterStateViewEmptyBinding bind(View view) {
        int i10 = R.id.content;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i11 = R.id.image;
            ImageView imageView = (ImageView) b.a(view, i11);
            if (imageView != null) {
                return new FeatureCommunityAdapterStateViewEmptyBinding(constraintLayout, textView, constraintLayout, imageView);
            }
            i10 = i11;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static FeatureCommunityAdapterStateViewEmptyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityAdapterStateViewEmptyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_adapter_state_view_empty, viewGroup, false);
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
