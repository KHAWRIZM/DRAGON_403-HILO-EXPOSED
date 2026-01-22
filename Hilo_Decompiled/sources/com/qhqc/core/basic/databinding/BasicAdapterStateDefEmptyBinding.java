package com.qhqc.core.basic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qhqc.core.basic.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BasicAdapterStateDefEmptyBinding implements a {
    public final TextView content;
    public final RelativeLayout emptyContent;
    public final ImageView image;
    private final RelativeLayout rootView;

    private BasicAdapterStateDefEmptyBinding(RelativeLayout relativeLayout, TextView textView, RelativeLayout relativeLayout2, ImageView imageView) {
        this.rootView = relativeLayout;
        this.content = textView;
        this.emptyContent = relativeLayout2;
        this.image = imageView;
    }

    public static BasicAdapterStateDefEmptyBinding bind(View view) {
        int i10 = R.id.content;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            int i11 = R.id.image;
            ImageView imageView = (ImageView) b.a(view, i11);
            if (imageView != null) {
                return new BasicAdapterStateDefEmptyBinding(relativeLayout, textView, relativeLayout, imageView);
            }
            i10 = i11;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static BasicAdapterStateDefEmptyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BasicAdapterStateDefEmptyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.basic_adapter_state_def_empty, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
