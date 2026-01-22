package com.qhqc.core.basic.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.qhqc.core.basic.widget.R;
import com.qhqc.core.basic.widget.toolbar.StatusBarHeightView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BasicWidgetLayoutCommonToolbarBinding implements a {
    public final AppCompatImageView mIvBack;
    public final LinearLayoutCompat mMenuContainer;
    public final TextView mTvTitle;
    public final StatusBarHeightView mViewStatus;
    private final StatusBarHeightView rootView;

    private BasicWidgetLayoutCommonToolbarBinding(StatusBarHeightView statusBarHeightView, AppCompatImageView appCompatImageView, LinearLayoutCompat linearLayoutCompat, TextView textView, StatusBarHeightView statusBarHeightView2) {
        this.rootView = statusBarHeightView;
        this.mIvBack = appCompatImageView;
        this.mMenuContainer = linearLayoutCompat;
        this.mTvTitle = textView;
        this.mViewStatus = statusBarHeightView2;
    }

    public static BasicWidgetLayoutCommonToolbarBinding bind(View view) {
        int i10 = R.id.mIvBack;
        AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i10);
        if (appCompatImageView != null) {
            i10 = R.id.mMenuContainer;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) b.a(view, i10);
            if (linearLayoutCompat != null) {
                i10 = R.id.mTvTitle;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    StatusBarHeightView statusBarHeightView = (StatusBarHeightView) view;
                    return new BasicWidgetLayoutCommonToolbarBinding(statusBarHeightView, appCompatImageView, linearLayoutCompat, textView, statusBarHeightView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static BasicWidgetLayoutCommonToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BasicWidgetLayoutCommonToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.basic_widget_layout_common_toolbar, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public StatusBarHeightView getRoot() {
        return this.rootView;
    }
}
