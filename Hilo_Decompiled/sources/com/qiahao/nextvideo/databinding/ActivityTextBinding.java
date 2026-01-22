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
public abstract class ActivityTextBinding extends ViewDataBinding {
    public final ImageView buttonImage;
    public final ConstraintLayout constraint;
    public final TextView test;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityTextBinding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i);
        this.buttonImage = imageView;
        this.constraint = constraintLayout;
        this.test = textView;
    }

    public static ActivityTextBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityTextBinding bind(View view, Object obj) {
        return (ActivityTextBinding) ViewDataBinding.bind(obj, view, R.layout.activity_text);
    }

    @Deprecated
    public static ActivityTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_text, viewGroup, z, obj);
    }

    public static ActivityTextBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_text, (ViewGroup) null, false, obj);
    }
}
