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
public final class BasicAdapterStateDefErrorBinding implements a {
    public final TextView content;
    public final RelativeLayout emptyContent;
    public final ImageView image;
    public final TextView mReload;
    private final RelativeLayout rootView;

    private BasicAdapterStateDefErrorBinding(RelativeLayout relativeLayout, TextView textView, RelativeLayout relativeLayout2, ImageView imageView, TextView textView2) {
        this.rootView = relativeLayout;
        this.content = textView;
        this.emptyContent = relativeLayout2;
        this.image = imageView;
        this.mReload = textView2;
    }

    public static BasicAdapterStateDefErrorBinding bind(View view) {
        int i10 = R.id.content;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i10 = R.id.image;
            ImageView imageView = (ImageView) b.a(view, i10);
            if (imageView != null) {
                i10 = R.id.mReload;
                TextView textView2 = (TextView) b.a(view, i10);
                if (textView2 != null) {
                    return new BasicAdapterStateDefErrorBinding(relativeLayout, textView, relativeLayout, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static BasicAdapterStateDefErrorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BasicAdapterStateDefErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.basic_adapter_state_def_error, viewGroup, false);
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
