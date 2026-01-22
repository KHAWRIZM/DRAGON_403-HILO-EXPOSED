package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGroupPopular2Binding extends ViewDataBinding {
    public final SVGAImageView heartSvga;
    public final TextView matchNumber;
    public final TextView videoMatch;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGroupPopular2Binding(Object obj, View view, int i, SVGAImageView sVGAImageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.heartSvga = sVGAImageView;
        this.matchNumber = textView;
        this.videoMatch = textView2;
    }

    public static ItemGroupPopular2Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGroupPopular2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGroupPopular2Binding bind(View view, Object obj) {
        return (ItemGroupPopular2Binding) ViewDataBinding.bind(obj, view, R.layout.item_group_popular2);
    }

    @Deprecated
    public static ItemGroupPopular2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGroupPopular2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_popular2, viewGroup, z, obj);
    }

    public static ItemGroupPopular2Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGroupPopular2Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGroupPopular2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_popular2, (ViewGroup) null, false, obj);
    }
}
