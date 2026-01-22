package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ItemBannerFamilyBinding implements a {
    private final ConstraintLayout rootView;
    public final SVGAImageView svgaView;
    public final TextView text;

    private ItemBannerFamilyBinding(ConstraintLayout constraintLayout, SVGAImageView sVGAImageView, TextView textView) {
        this.rootView = constraintLayout;
        this.svgaView = sVGAImageView;
        this.text = textView;
    }

    public static ItemBannerFamilyBinding bind(View view) {
        int i = R.id.svgaView;
        SVGAImageView a = b.a(view, R.id.svgaView);
        if (a != null) {
            i = 2131365026;
            TextView textView = (TextView) b.a(view, 2131365026);
            if (textView != null) {
                return new ItemBannerFamilyBinding((ConstraintLayout) view, a, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemBannerFamilyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemBannerFamilyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_banner_family, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
