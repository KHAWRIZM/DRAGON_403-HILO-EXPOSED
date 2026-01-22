package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CellLoadingBinding implements a {
    public final ProgressBar cellLoadingProgressBar;
    public final Button cellLoadingRetryButton;
    public final TextView cellLoadingStatusText;
    public final FrameLayout rootLayout;
    private final FrameLayout rootView;

    private CellLoadingBinding(FrameLayout frameLayout, ProgressBar progressBar, Button button, TextView textView, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.cellLoadingProgressBar = progressBar;
        this.cellLoadingRetryButton = button;
        this.cellLoadingStatusText = textView;
        this.rootLayout = frameLayout2;
    }

    public static CellLoadingBinding bind(View view) {
        int i = R.id.cell_loading_progress_bar;
        ProgressBar progressBar = (ProgressBar) b.a(view, R.id.cell_loading_progress_bar);
        if (progressBar != null) {
            i = R.id.cell_loading_retry_button;
            Button button = (Button) b.a(view, R.id.cell_loading_retry_button);
            if (button != null) {
                i = R.id.cell_loading_status_text;
                TextView textView = (TextView) b.a(view, R.id.cell_loading_status_text);
                if (textView != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    return new CellLoadingBinding(frameLayout, progressBar, button, textView, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static CellLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CellLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cell_loading, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
