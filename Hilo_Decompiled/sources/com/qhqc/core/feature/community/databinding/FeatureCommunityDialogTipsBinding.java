package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.qhqc.core.feature.community.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityDialogTipsBinding implements a {
    public final LinearLayoutCompat mContentView;
    public final FrameLayout mCustomViewContainer;
    public final TextView mTvContent;
    public final TextView mTvTitle;
    private final FrameLayout rootView;

    private FeatureCommunityDialogTipsBinding(FrameLayout frameLayout, LinearLayoutCompat linearLayoutCompat, FrameLayout frameLayout2, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.mContentView = linearLayoutCompat;
        this.mCustomViewContainer = frameLayout2;
        this.mTvContent = textView;
        this.mTvTitle = textView2;
    }

    public static FeatureCommunityDialogTipsBinding bind(View view) {
        int i10 = R.id.mContentView;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) b.a(view, i10);
        if (linearLayoutCompat != null) {
            i10 = R.id.mCustomViewContainer;
            FrameLayout frameLayout = (FrameLayout) b.a(view, i10);
            if (frameLayout != null) {
                i10 = R.id.mTvContent;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    i10 = R.id.mTvTitle;
                    TextView textView2 = (TextView) b.a(view, i10);
                    if (textView2 != null) {
                        return new FeatureCommunityDialogTipsBinding((FrameLayout) view, linearLayoutCompat, frameLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static FeatureCommunityDialogTipsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityDialogTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_dialog_tips, viewGroup, false);
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
