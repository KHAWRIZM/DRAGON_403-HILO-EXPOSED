package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogYouTuLinkBinding extends ViewDataBinding {
    public final TextView addButton;
    public final ConstraintLayout constraint;
    public final ImageView leftImage;
    public final AppCompatEditText linkEdit;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogYouTuLinkBinding(Object obj, View view, int i, TextView textView, ConstraintLayout constraintLayout, ImageView imageView, AppCompatEditText appCompatEditText) {
        super(obj, view, i);
        this.addButton = textView;
        this.constraint = constraintLayout;
        this.leftImage = imageView;
        this.linkEdit = appCompatEditText;
    }

    public static DialogYouTuLinkBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogYouTuLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogYouTuLinkBinding bind(View view, Object obj) {
        return (DialogYouTuLinkBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_you_tu_link);
    }

    @Deprecated
    public static DialogYouTuLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogYouTuLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_you_tu_link, viewGroup, z, obj);
    }

    public static DialogYouTuLinkBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogYouTuLinkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogYouTuLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_you_tu_link, (ViewGroup) null, false, obj);
    }
}
