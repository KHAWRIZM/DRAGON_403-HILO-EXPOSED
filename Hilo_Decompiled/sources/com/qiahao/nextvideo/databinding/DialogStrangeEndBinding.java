package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogStrangeEndBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final ImageView close;
    public final ConstraintLayout constraint;
    public final TextView content;
    public final TextView continueBtn;
    public final TextView name;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogStrangeEndBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.close = imageView;
        this.constraint = constraintLayout;
        this.content = textView;
        this.continueBtn = textView2;
        this.name = textView3;
        this.title = textView4;
    }

    public static DialogStrangeEndBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogStrangeEndBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogStrangeEndBinding bind(View view, Object obj) {
        return (DialogStrangeEndBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_strange_end);
    }

    @Deprecated
    public static DialogStrangeEndBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogStrangeEndBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_strange_end, viewGroup, z, obj);
    }

    public static DialogStrangeEndBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogStrangeEndBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogStrangeEndBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_strange_end, (ViewGroup) null, false, obj);
    }
}
