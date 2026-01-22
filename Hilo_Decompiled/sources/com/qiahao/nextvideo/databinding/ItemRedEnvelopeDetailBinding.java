package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemRedEnvelopeDetailBinding extends ViewDataBinding {
    public final TextView diamond;
    public final View line;
    public final TextView time;
    public final TextView title;
    public final FrameLayout titleLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemRedEnvelopeDetailBinding(Object obj, View view, int i, TextView textView, View view2, TextView textView2, TextView textView3, FrameLayout frameLayout) {
        super(obj, view, i);
        this.diamond = textView;
        this.line = view2;
        this.time = textView2;
        this.title = textView3;
        this.titleLayout = frameLayout;
    }

    public static ItemRedEnvelopeDetailBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemRedEnvelopeDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemRedEnvelopeDetailBinding bind(View view, Object obj) {
        return (ItemRedEnvelopeDetailBinding) ViewDataBinding.bind(obj, view, R.layout.item_red_envelope_detail);
    }

    @Deprecated
    public static ItemRedEnvelopeDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRedEnvelopeDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_red_envelope_detail, viewGroup, z, obj);
    }

    public static ItemRedEnvelopeDetailBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemRedEnvelopeDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRedEnvelopeDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_red_envelope_detail, (ViewGroup) null, false, obj);
    }
}
