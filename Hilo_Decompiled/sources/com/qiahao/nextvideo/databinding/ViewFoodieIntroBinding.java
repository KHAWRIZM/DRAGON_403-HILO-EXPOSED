package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewFoodieIntroBinding extends ViewDataBinding {
    public final ImageView ivClose;
    public final TextView tvContent;
    public final TextView tvTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewFoodieIntroBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.ivClose = imageView;
        this.tvContent = textView;
        this.tvTitle = textView2;
    }

    public static ViewFoodieIntroBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewFoodieIntroBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewFoodieIntroBinding bind(View view, Object obj) {
        return (ViewFoodieIntroBinding) ViewDataBinding.bind(obj, view, R.layout.view_foodie_intro);
    }

    @Deprecated
    public static ViewFoodieIntroBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewFoodieIntroBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_foodie_intro, viewGroup, z, obj);
    }

    public static ViewFoodieIntroBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewFoodieIntroBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewFoodieIntroBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_foodie_intro, (ViewGroup) null, false, obj);
    }
}
