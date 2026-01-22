package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ViewProgressBinding implements a {
    private final FrameLayout rootView;
    public final View viewProgressBackground;
    public final CardView viewProgressContent;
    public final AppCompatTextView viewProgressText;

    private ViewProgressBinding(FrameLayout frameLayout, View view, CardView cardView, AppCompatTextView appCompatTextView) {
        this.rootView = frameLayout;
        this.viewProgressBackground = view;
        this.viewProgressContent = cardView;
        this.viewProgressText = appCompatTextView;
    }

    public static ViewProgressBinding bind(View view) {
        int i = R.id.view_progress_background;
        View a = b.a(view, R.id.view_progress_background);
        if (a != null) {
            i = 2131365643;
            CardView a2 = b.a(view, 2131365643);
            if (a2 != null) {
                i = 2131365644;
                AppCompatTextView a3 = b.a(view, 2131365644);
                if (a3 != null) {
                    return new ViewProgressBinding((FrameLayout) view, a, a2, a3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ViewProgressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_progress, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
