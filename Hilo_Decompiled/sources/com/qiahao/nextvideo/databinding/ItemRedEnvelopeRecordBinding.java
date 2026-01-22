package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemRedEnvelopeRecordBinding extends ViewDataBinding {
    public final ImageView arrowImg;
    public final LinearLayout arrowLayout;
    public final TextView arrowText;
    public final TextView diamond;
    public final ImageView diamondImg;
    public final View line;
    public final TextView time;
    public final TextView title;
    public final FrameLayout titleLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemRedEnvelopeRecordBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, ImageView imageView2, View view2, TextView textView3, TextView textView4, FrameLayout frameLayout) {
        super(obj, view, i);
        this.arrowImg = imageView;
        this.arrowLayout = linearLayout;
        this.arrowText = textView;
        this.diamond = textView2;
        this.diamondImg = imageView2;
        this.line = view2;
        this.time = textView3;
        this.title = textView4;
        this.titleLayout = frameLayout;
    }

    public static ItemRedEnvelopeRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemRedEnvelopeRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemRedEnvelopeRecordBinding bind(View view, Object obj) {
        return (ItemRedEnvelopeRecordBinding) ViewDataBinding.bind(obj, view, R.layout.item_red_envelope_record);
    }

    @Deprecated
    public static ItemRedEnvelopeRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRedEnvelopeRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_red_envelope_record, viewGroup, z, obj);
    }

    public static ItemRedEnvelopeRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemRedEnvelopeRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRedEnvelopeRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_red_envelope_record, (ViewGroup) null, false, obj);
    }
}
