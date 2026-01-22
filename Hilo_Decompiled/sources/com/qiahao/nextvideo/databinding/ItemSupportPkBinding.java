package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.oudi.widget.text.GradientTextView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemSupportPkBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final TextView diamond;
    public final TextView name;
    public final GradientTextView position;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemSupportPkBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, TextView textView, TextView textView2, GradientTextView gradientTextView) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.diamond = textView;
        this.name = textView2;
        this.position = gradientTextView;
    }

    public static ItemSupportPkBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemSupportPkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemSupportPkBinding bind(View view, Object obj) {
        return (ItemSupportPkBinding) ViewDataBinding.bind(obj, view, R.layout.item_support_pk);
    }

    @Deprecated
    public static ItemSupportPkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSupportPkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_support_pk, viewGroup, z, obj);
    }

    public static ItemSupportPkBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemSupportPkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSupportPkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_support_pk, (ViewGroup) null, false, obj);
    }
}
