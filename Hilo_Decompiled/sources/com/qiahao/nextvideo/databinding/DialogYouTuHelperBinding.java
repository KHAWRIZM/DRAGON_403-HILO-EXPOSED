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

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogYouTuHelperBinding extends ViewDataBinding {
    public final ImageView centerImage;
    public final ImageView close;
    public final ConstraintLayout constraint;
    public final TextView content;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogYouTuHelperBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.centerImage = imageView;
        this.close = imageView2;
        this.constraint = constraintLayout;
        this.content = textView;
        this.title = textView2;
    }

    public static DialogYouTuHelperBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogYouTuHelperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogYouTuHelperBinding bind(View view, Object obj) {
        return (DialogYouTuHelperBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_you_tu_helper);
    }

    @Deprecated
    public static DialogYouTuHelperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogYouTuHelperBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_you_tu_helper, viewGroup, z, obj);
    }

    public static DialogYouTuHelperBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogYouTuHelperBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogYouTuHelperBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_you_tu_helper, (ViewGroup) null, false, obj);
    }
}
