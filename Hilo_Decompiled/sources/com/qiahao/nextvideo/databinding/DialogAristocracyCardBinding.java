package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogAristocracyCardBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final TextView content;
    public final ImageView image;
    public final TextView name;
    public final TextView ok;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogAristocracyCardBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.content = textView;
        this.image = imageView;
        this.name = textView2;
        this.ok = textView3;
    }

    public static DialogAristocracyCardBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogAristocracyCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogAristocracyCardBinding bind(View view, Object obj) {
        return (DialogAristocracyCardBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_aristocracy_card);
    }

    @Deprecated
    public static DialogAristocracyCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogAristocracyCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_aristocracy_card, viewGroup, z, obj);
    }

    public static DialogAristocracyCardBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogAristocracyCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogAristocracyCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_aristocracy_card, (ViewGroup) null, false, obj);
    }
}
