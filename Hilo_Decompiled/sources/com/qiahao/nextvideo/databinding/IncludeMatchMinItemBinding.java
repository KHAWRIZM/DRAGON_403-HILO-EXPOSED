package com.qiahao.nextvideo.databinding;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class IncludeMatchMinItemBinding extends ViewDataBinding {
    public final ImageView image;
    protected Drawable mImageSrc;
    protected String mTitle;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeMatchMinItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.image = imageView;
        this.title = textView;
    }

    public static IncludeMatchMinItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeMatchMinItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public Drawable getImageSrc() {
        return this.mImageSrc;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public abstract void setImageSrc(Drawable drawable);

    public abstract void setTitle(String str);

    @Deprecated
    public static IncludeMatchMinItemBinding bind(View view, Object obj) {
        return (IncludeMatchMinItemBinding) ViewDataBinding.bind(obj, view, R.layout.include_match_min_item);
    }

    @Deprecated
    public static IncludeMatchMinItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeMatchMinItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_match_min_item, viewGroup, z, obj);
    }

    public static IncludeMatchMinItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeMatchMinItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeMatchMinItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_match_min_item, (ViewGroup) null, false, obj);
    }
}
