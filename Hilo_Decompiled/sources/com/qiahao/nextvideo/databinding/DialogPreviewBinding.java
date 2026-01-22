package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogPreviewBinding extends ViewDataBinding {
    public final ImageView image;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogPreviewBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.image = imageView;
    }

    public static DialogPreviewBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogPreviewBinding bind(View view, Object obj) {
        return (DialogPreviewBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_preview);
    }

    @Deprecated
    public static DialogPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogPreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_preview, viewGroup, z, obj);
    }

    public static DialogPreviewBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogPreviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogPreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_preview, (ViewGroup) null, false, obj);
    }
}
