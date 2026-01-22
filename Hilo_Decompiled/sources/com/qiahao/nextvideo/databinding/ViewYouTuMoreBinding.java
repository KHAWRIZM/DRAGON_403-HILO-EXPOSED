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
public abstract class ViewYouTuMoreBinding extends ViewDataBinding {
    public final ConstraintLayout constraint;
    public final ImageView delete;
    public final TextView deleteText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewYouTuMoreBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.constraint = constraintLayout;
        this.delete = imageView;
        this.deleteText = textView;
    }

    public static ViewYouTuMoreBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewYouTuMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewYouTuMoreBinding bind(View view, Object obj) {
        return (ViewYouTuMoreBinding) ViewDataBinding.bind(obj, view, R.layout.view_you_tu_more);
    }

    @Deprecated
    public static ViewYouTuMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewYouTuMoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_you_tu_more, viewGroup, z, obj);
    }

    public static ViewYouTuMoreBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewYouTuMoreBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewYouTuMoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_you_tu_more, (ViewGroup) null, false, obj);
    }
}
