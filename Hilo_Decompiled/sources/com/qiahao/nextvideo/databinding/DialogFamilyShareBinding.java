package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogFamilyShareBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final TextView cancel;
    public final ConstraintLayout centerLayout;
    public final TextView confirm;
    public final TextView content;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogFamilyShareBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, TextView textView, ConstraintLayout constraintLayout, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.cancel = textView;
        this.centerLayout = constraintLayout;
        this.confirm = textView2;
        this.content = textView3;
        this.title = textView4;
    }

    public static DialogFamilyShareBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogFamilyShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogFamilyShareBinding bind(View view, Object obj) {
        return (DialogFamilyShareBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_family_share);
    }

    @Deprecated
    public static DialogFamilyShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogFamilyShareBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_family_share, viewGroup, z, obj);
    }

    public static DialogFamilyShareBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogFamilyShareBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogFamilyShareBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_family_share, (ViewGroup) null, false, obj);
    }
}
