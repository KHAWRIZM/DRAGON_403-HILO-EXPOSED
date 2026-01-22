package com.qhqc.core.basic.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qhqc.core.basic.widget.R;
import com.qhqc.core.basic.widget.svprogresshud.indicator.IndicatorView;
import com.qhqc.core.basic.widget.svprogresshud.view.SVCircleProgressBar;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BasicWidgetLayoutViewSvprogressdefaultBinding implements a {
    public final SVCircleProgressBar circleProgressBar;
    public final IndicatorView indicatorView;
    public final ImageView ivBigLoading;
    public final ImageView ivSmallLoading;
    private final LinearLayout rootView;
    public final TextView tvMsg;

    private BasicWidgetLayoutViewSvprogressdefaultBinding(LinearLayout linearLayout, SVCircleProgressBar sVCircleProgressBar, IndicatorView indicatorView, ImageView imageView, ImageView imageView2, TextView textView) {
        this.rootView = linearLayout;
        this.circleProgressBar = sVCircleProgressBar;
        this.indicatorView = indicatorView;
        this.ivBigLoading = imageView;
        this.ivSmallLoading = imageView2;
        this.tvMsg = textView;
    }

    public static BasicWidgetLayoutViewSvprogressdefaultBinding bind(View view) {
        int i10 = R.id.circleProgressBar;
        SVCircleProgressBar sVCircleProgressBar = (SVCircleProgressBar) b.a(view, i10);
        if (sVCircleProgressBar != null) {
            i10 = R.id.indicator_view;
            IndicatorView indicatorView = (IndicatorView) b.a(view, i10);
            if (indicatorView != null) {
                i10 = R.id.ivBigLoading;
                ImageView imageView = (ImageView) b.a(view, i10);
                if (imageView != null) {
                    i10 = R.id.ivSmallLoading;
                    ImageView imageView2 = (ImageView) b.a(view, i10);
                    if (imageView2 != null) {
                        i10 = R.id.tvMsg;
                        TextView textView = (TextView) b.a(view, i10);
                        if (textView != null) {
                            return new BasicWidgetLayoutViewSvprogressdefaultBinding((LinearLayout) view, sVCircleProgressBar, indicatorView, imageView, imageView2, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static BasicWidgetLayoutViewSvprogressdefaultBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BasicWidgetLayoutViewSvprogressdefaultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.basic_widget_layout_view_svprogressdefault, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
