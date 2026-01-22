package com.qhqc.core.basic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qhqc.core.basic.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BasicAdapterStateDefLoadingBinding implements a {
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;

    private BasicAdapterStateDefLoadingBinding(ConstraintLayout constraintLayout, ProgressBar progressBar) {
        this.rootView = constraintLayout;
        this.progressBar = progressBar;
    }

    public static BasicAdapterStateDefLoadingBinding bind(View view) {
        int i10 = R.id.progress_bar;
        ProgressBar progressBar = (ProgressBar) b.a(view, i10);
        if (progressBar != null) {
            return new BasicAdapterStateDefLoadingBinding((ConstraintLayout) view, progressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static BasicAdapterStateDefLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BasicAdapterStateDefLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.basic_adapter_state_def_loading, viewGroup, false);
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
