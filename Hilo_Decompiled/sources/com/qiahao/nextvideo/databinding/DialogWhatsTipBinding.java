package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogWhatsTipBinding extends ViewDataBinding {
    public final TextView confirm;
    public final ConstraintLayout constraint;
    public final FrameLayout frameLayout;
    public final ImageView handIcon;
    public final TextView title;
    public final ImageView whatsApp;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogWhatsTipBinding(Object obj, View view, int i, TextView textView, ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView, TextView textView2, ImageView imageView2) {
        super(obj, view, i);
        this.confirm = textView;
        this.constraint = constraintLayout;
        this.frameLayout = frameLayout;
        this.handIcon = imageView;
        this.title = textView2;
        this.whatsApp = imageView2;
    }

    public static DialogWhatsTipBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogWhatsTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogWhatsTipBinding bind(View view, Object obj) {
        return (DialogWhatsTipBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_whats_tip);
    }

    @Deprecated
    public static DialogWhatsTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogWhatsTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_whats_tip, viewGroup, z, obj);
    }

    public static DialogWhatsTipBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogWhatsTipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogWhatsTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_whats_tip, (ViewGroup) null, false, obj);
    }
}
